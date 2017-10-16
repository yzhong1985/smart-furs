package smartFuRS;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Image;

import javax.swing.SwingConstants;
import java.awt.Toolkit;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPasswordField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.Window.Type;
import javax.swing.border.CompoundBorder;
import java.awt.SystemColor;

public class Login extends JFrame {

	private JPanel contentPane;
	private JTextField usernameTextbox;
	private JPasswordField passwordField;
	private JLabel lblUser;
	private JLabel lblPassword;
	private JLabel lblPleaseEnterYour;
	private JButton LoginBtn;
	private JLabel messageLabel;
	
	private String loginUser;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login frame = new Login();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Login() {
		setType(Type.UTILITY);
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 656, 456);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 255));
		contentPane.setBorder(new CompoundBorder());
		setContentPane(contentPane);
		contentPane.setLayout(null);
		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
		this.setLocation(dim.width/2-this.getSize().width/2, dim.height/2-this.getSize().height/2);
		
		usernameTextbox = new JTextField();
		usernameTextbox.setFont(new Font("Calibri", Font.PLAIN, 20));
		usernameTextbox.setBounds(232, 212, 189, 29);
		contentPane.add(usernameTextbox);
		usernameTextbox.setColumns(10);
		
		passwordField = new JPasswordField();
		passwordField.setFont(new Font("Calibri", Font.PLAIN, 20));
		passwordField.addKeyListener(new KeyAdapter() {

			@Override
			public void keyReleased(KeyEvent e) {
				int enter = e.getKeyCode();
				if(enter == 10) {
					NaviToMainFrame();
				}
			}
		});
		passwordField.setBounds(232, 252, 189, 27);
		contentPane.add(passwordField);
		
		lblUser = new JLabel("Username:");
		lblUser.setHorizontalAlignment(SwingConstants.RIGHT);
		lblUser.setFont(new Font("Calibri", Font.PLAIN, 20));
		lblUser.setBounds(97, 215, 125, 24);
		contentPane.add(lblUser);
		
		lblPassword = new JLabel("Password:");
		lblPassword.setHorizontalAlignment(SwingConstants.RIGHT);
		lblPassword.setFont(new Font("Calibri", Font.PLAIN, 20));
		lblPassword.setBounds(97, 253, 125, 27);
		contentPane.add(lblPassword);
		
		lblPleaseEnterYour = new JLabel("<html>Please enter your username and password to login<br>Contact system admin if you need assist with your account.</html>", SwingConstants.CENTER);
		lblPleaseEnterYour.setFont(new Font("Calibri", Font.PLAIN, 18));
		lblPleaseEnterYour.setHorizontalAlignment(SwingConstants.CENTER);
		lblPleaseEnterYour.setBounds(95, 291, 470, 68);
		contentPane.add(lblPleaseEnterYour);
		
		LoginBtn = new JButton("Login");
		LoginBtn.setForeground(Color.BLACK);
		LoginBtn.setBackground(SystemColor.control);
		LoginBtn.setFont(new Font("Calibri", Font.PLAIN, 20));
		LoginBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				NaviToMainFrame();
			}
		});
		LoginBtn.setFocusable(false);
		LoginBtn.setBounds(438, 212, 89, 68);
		contentPane.add(LoginBtn);
		
		messageLabel = new JLabel("");
		messageLabel.setFont(new Font("Calibri", Font.PLAIN, 20));
		messageLabel.setForeground(Color.RED);
		messageLabel.setBounds(121, 362, 430, 29);
		contentPane.add(messageLabel);
		
		JLabel bgImgLabel = new JLabel("");
		Image img = new ImageIcon(this.getClass().getResource("../logo-design.png")).getImage();
		bgImgLabel.setIcon(new ImageIcon(img));
		bgImgLabel.setBounds(75, 23, 553, 178);
		contentPane.add(bgImgLabel);
		
		
		//initialize the db utility
		FuRSDBUtility.getConnection();
	}
	
	private void NaviToMainFrame() {
		
		if(Validate()) {
			MainForm mainfrm = new MainForm();
			mainfrm.SetAppUser(loginUser);
			mainfrm.Display();
			setVisible(false);
		}
		
	}
	
	private boolean Validate() {
		
		char[] pass = passwordField.getPassword();
		String user = usernameTextbox.getText();
		String psw = "";
		for(char c: pass) {psw += c;}
				 
		//check if these are empty or not
		if(pass.length==0 || user == "") {		
			messageLabel.setText("Username/password cannot be blank");
			return false;
		}
		
		//check if has the user in database
		AppUser appuser = null;
		appuser = FuRSDBUtility.getAppUser(user, psw);
		if(appuser == null) {
			messageLabel.setText("Wrong username or password");
			return false;
		}
		else {
			//if has user, return true
			messageLabel.setText("");
			loginUser = user;
			return true;
		}
		
	} 
}
