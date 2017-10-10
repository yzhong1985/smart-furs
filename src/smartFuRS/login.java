package smartFuRS;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import java.awt.Toolkit;
import javax.swing.JButton;
import javax.swing.JPasswordField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.Window.Type;

public class Login extends JFrame {

	private JPanel contentPane;
	private JTextField usernameTextbox;
	private JPasswordField passwordField;
	private JLabel lblUser;
	private JLabel lblPassword;
	private JLabel lblPleaseEnterYour;
	private JButton ExitBtn;
	private JButton LoginBtn;
	private JLabel messageLabel;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					
					//FuRSDBUtility.getConnection();
					
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
		setBounds(100, 100, 342, 332);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		usernameTextbox = new JTextField();
		usernameTextbox.setFont(new Font("Arial", Font.PLAIN, 13));
		usernameTextbox.setBounds(121, 48, 138, 29);
		contentPane.add(usernameTextbox);
		usernameTextbox.setColumns(10);
		
		lblUser = new JLabel("Username:");
		lblUser.setHorizontalAlignment(SwingConstants.RIGHT);
		lblUser.setFont(new Font("Arial", Font.PLAIN, 12));
		lblUser.setBounds(34, 55, 77, 14);
		contentPane.add(lblUser);
		
		lblPassword = new JLabel("Password:");
		lblPassword.setHorizontalAlignment(SwingConstants.RIGHT);
		lblPassword.setFont(new Font("Arial", Font.PLAIN, 12));
		lblPassword.setBounds(34, 93, 77, 14);
		contentPane.add(lblPassword);
		
		lblPleaseEnterYour = new JLabel("<html>Please enter your username and password to login<br>Contact system admin if you need assist</html>", SwingConstants.CENTER);
		lblPleaseEnterYour.setHorizontalAlignment(SwingConstants.CENTER);
		lblPleaseEnterYour.setBounds(10, 185, 329, 59);
		contentPane.add(lblPleaseEnterYour);
		
		ExitBtn = new JButton("Exit");
		ExitBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				System.exit(0);
			}
		});
		ExitBtn.setBounds(170, 133, 89, 52);
		contentPane.add(ExitBtn);
		
		LoginBtn = new JButton("Login");
		LoginBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				NaviToMainFrame();
			}
		});
		LoginBtn.setBounds(57, 133, 89, 52);
		contentPane.add(LoginBtn);
		
		passwordField = new JPasswordField();
		passwordField.addKeyListener(new KeyAdapter() {

			@Override
			public void keyReleased(KeyEvent e) {
				int enter = e.getKeyCode();
				if(enter == 10) {
					NaviToMainFrame();
				}
			}
		});
		passwordField.setBounds(121, 88, 138, 27);
		contentPane.add(passwordField);
		
		messageLabel = new JLabel("");
		messageLabel.setForeground(Color.RED);
		messageLabel.setBounds(52, 241, 217, 29);
		contentPane.add(messageLabel);
		
		
		//initialize the db utility
		FuRSDBUtility.getConnection();
	}
	
	private void NaviToMainFrame() {
		
		if(Validate()) {
			MainForm mainfrm = new MainForm();
			mainfrm.Display();
			setVisible(false);
		}
		
	}
	
	private boolean Validate() {
		
		char[] pass = passwordField.getPassword();
		String user = usernameTextbox.getText();
		String psw = "";
		for(char c: pass) {
			psw += c;
		}
		
		System.out.println(psw);
		 
		//check if these are empty or not
		if(pass.length==0 || user == "") {
			
			messageLabel.setText("Username/password cannot be blank");
			return false;
		}
		
		try {
		
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
				return true;
			}
		
		}
		catch(Exception e) {
			//should log the exception here
			return false;
		}
		
	} 
}
