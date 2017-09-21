package smartFuRS;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
 
public class login{
    String Username = "clerk";
    String Password = "pass";
    String msg = " ";
	private JTextField txtUsername;
	private JTextField txtPassword;
	public JButton btnLogin;
	public JButton JbtnCan;
     
     
    public static void main(String[] args){
        login gui = new login();
        gui.go();
    }
    public void go(){
        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JPanel panel = new JPanel();
        JLabel lblUsername = new JLabel("Username:");   
        JLabel lblPassword = new JLabel("Password:");
        txtUsername = new JTextField(15);
        txtPassword = new JTextField(15);
        btnLogin = new JButton("Login");
        btnLogin.addActionListener(new LoginListener());
        JbtnCan = new JButton("Cancel");
       
     
 
        panel.add(lblUsername);
        panel.add(txtUsername);
        panel.add(lblPassword);
        panel.add(txtPassword); 
        panel.add(btnLogin);
        panel.add(JbtnCan);
        frame.getContentPane().add(BorderLayout.CENTER,panel);
 
 
 
        frame.setSize(300,300);
        frame.setVisible(true);
 
 
    }
 
    public class LoginListener implements ActionListener{
        public void actionPerformed(ActionEvent event){
            if(Username.equals(txtUsername.getText())){
                if(Password.equals(txtPassword.getText())){
                    msg = "Login Granted!";
                }else{
                    msg = "Login Denied";
                }
            }else{
                msg = "Login Denied";
            }   
            JOptionPane.showMessageDialog(null,msg);                    
        }
    }
}
    
    