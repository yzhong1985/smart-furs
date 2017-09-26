package smartFuRS;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTabbedPane;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JRadioButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class MainForm {

	private JFrame frame;
	private JTextField textField;
	private JTextField textField_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainForm window = new MainForm();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public MainForm() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 629, 553);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(0, 0, 613, 493);
		frame.getContentPane().add(tabbedPane);
		
		JPanel applicationPanel = new JPanel();
		tabbedPane.addTab("Applications", null, applicationPanel, null);
		applicationPanel.setLayout(null);
		
		JButton btnSave = new JButton("Save");
		btnSave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btnSave.setBounds(10, 431, 89, 23);
		applicationPanel.add(btnSave);
		
		textField = new JTextField();
		textField.setBounds(85, 11, 140, 20);
		applicationPanel.add(textField);
		textField.setColumns(10);
		
		JLabel lblFirstName = new JLabel("First Name");
		lblFirstName.setBounds(17, 11, 58, 14);
		applicationPanel.add(lblFirstName);
		
		JLabel lblLastName = new JLabel("Last Name");
		lblLastName.setBounds(17, 46, 58, 14);
		applicationPanel.add(lblLastName);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(85, 42, 140, 20);
		applicationPanel.add(textField_1);
		
		JLabel lblGender = new JLabel("Gender");
		lblGender.setBounds(17, 83, 58, 14);
		applicationPanel.add(lblGender);
		
		JRadioButton rdbtnNewRadioButton = new JRadioButton("Male");
		rdbtnNewRadioButton.setBounds(85, 79, 58, 23);
		applicationPanel.add(rdbtnNewRadioButton);
		
		JRadioButton rdbtnNewRadioButton_1 = new JRadioButton("Female");
		rdbtnNewRadioButton_1.setBounds(145, 79, 73, 23);
		applicationPanel.add(rdbtnNewRadioButton_1);
		
		JPanel mailingPanel = new JPanel();
		tabbedPane.addTab("Mailing Notification", null, mailingPanel, null);
		
		JPanel checkinPanel = new JPanel();
		tabbedPane.addTab("Camper Checkin", null, checkinPanel, null);
		
		JPanel dormAsnPanel = new JPanel();
		tabbedPane.addTab("Dorm Assignment", null, dormAsnPanel, null);
		
		JPanel bandAsnPanel = new JPanel();
		tabbedPane.addTab("Band Assignment", null, bandAsnPanel, null);
		
		JMenuBar menuBar = new JMenuBar();
		frame.setJMenuBar(menuBar);
		
		JMenu mnHelp = new JMenu("Help");
		menuBar.add(mnHelp);
	}
}
