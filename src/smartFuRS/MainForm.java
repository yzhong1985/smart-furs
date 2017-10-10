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
import java.sql.ResultSet;
import java.awt.event.ActionEvent;
import java.awt.Window.Type;
import javax.swing.Icon;
import javax.swing.JComboBox;
import javax.swing.ButtonGroup;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JTable;
import java.awt.List;
import javax.swing.table.DefaultTableModel;

import net.proteanit.sql.DbUtils;

import javax.swing.JScrollPane;
import javax.swing.JCheckBox;
import javax.swing.SwingConstants;

public class MainForm {

	private JFrame frame;
	private JTextField firstnameTextField;
	private JTextField lastnameTextField;
	private JTextField dobTextField;
	private JTable camperTable;

	//defines five panels
	private JPanel applicationPanel;
	private JPanel mailingPanel;
	private JPanel checkinPanel;
	private JPanel dormAsnPanel;
	private JPanel bandAsnPanel;
	
	private JRadioButton maleRadioButton;
	private JRadioButton femaleRadioButton;
	private ButtonGroup genderBtnGroup;
	
	private JComboBox<String> instrumentDropdown;
	
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

	public void Display() {
		
		frame.setVisible(true);
	}
	
	/**
	 * Create the application.
	 */
	public MainForm() {
		initialize();
	}

	private void LoadCampers() {
		try {
			ResultSet rs =FuRSDBUtility.getCampers();
		    camperTable.setModel( DbUtils.resultSetToTableModel(rs));
		    
		    JCheckBox hasEssayCheckBox = new JCheckBox("Personal Essay");
		    hasEssayCheckBox.setBounds(17, 175, 131, 31);
		    applicationPanel.add(hasEssayCheckBox);
		    
		    JCheckBox hasRecordingCheckBox = new JCheckBox("Recording");
		    hasRecordingCheckBox.setBounds(150, 175, 120, 31);
		    applicationPanel.add(hasRecordingCheckBox);
		    
		    JCheckBox hasPaymentCheckBox = new JCheckBox("Payment");
		    hasPaymentCheckBox.setBounds(17, 209, 140, 31);
		    applicationPanel.add(hasPaymentCheckBox);
		    
		    JButton btnSave = new JButton("Save");
		    btnSave.setBounds(100, 367, 73, 39);
		    applicationPanel.add(btnSave);
		    
		    JButton btnDelete = new JButton("Delete");
		    btnDelete.setBounds(183, 367, 73, 39);
		    applicationPanel.add(btnDelete);
			} catch(Exception ex) {
				System.out.println(ex.getStackTrace());
		}
	}
	
	private void AddCamper(){
		
		
	}
	
	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setType(Type.UTILITY);
		frame.setResizable(false);
		frame.setBounds(100, 100, 629, 526);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(0, 11, 613, 482);
		frame.getContentPane().add(tabbedPane);
		
		applicationPanel = new JPanel();
		tabbedPane.addTab("Applications", (Icon) null, applicationPanel, null);
		applicationPanel.setLayout(null);
		
		JButton btnAdd = new JButton("Add");
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				AddCamper();
			}
		});
		btnAdd.setBounds(17, 367, 73, 39);
		applicationPanel.add(btnAdd);
		
		firstnameTextField = new JTextField();
		firstnameTextField.setBounds(104, 11, 140, 20);
		applicationPanel.add(firstnameTextField);
		firstnameTextField.setColumns(10);
		
		JLabel lblFirstName = new JLabel("First Name");
		lblFirstName.setBounds(17, 11, 89, 14);
		applicationPanel.add(lblFirstName);
		
		JLabel lblLastName = new JLabel("Last Name");
		lblLastName.setBounds(17, 46, 89, 14);
		applicationPanel.add(lblLastName);
		
		lastnameTextField = new JTextField();
		lastnameTextField.setColumns(10);
		lastnameTextField.setBounds(104, 42, 140, 20);
		applicationPanel.add(lastnameTextField);
		
		JLabel lblGender = new JLabel("Gender");
		lblGender.setBounds(17, 83, 89, 14);
		applicationPanel.add(lblGender);
		
		maleRadioButton = new JRadioButton("Male");
		maleRadioButton.setBounds(104, 79, 58, 23);
		applicationPanel.add(maleRadioButton);
		
		femaleRadioButton = new JRadioButton("Female");
		femaleRadioButton.setBounds(164, 79, 73, 23);
		applicationPanel.add(femaleRadioButton);
		
		genderBtnGroup = new ButtonGroup();
		genderBtnGroup.add(femaleRadioButton);
		genderBtnGroup.add(maleRadioButton);
		
		dobTextField = new JTextField();
		dobTextField.setBounds(104, 109, 140, 20);
		applicationPanel.add(dobTextField);
		dobTextField.setColumns(10);
		
		JLabel lblDob = new JLabel("DOB");
		lblDob.setBounds(17, 112, 89, 14);
		applicationPanel.add(lblDob);
		
		instrumentDropdown = new JComboBox<String>();
		instrumentDropdown.setModel(new DefaultComboBoxModel<String>());
		instrumentDropdown.setBounds(104, 140, 140, 20);
		applicationPanel.add(instrumentDropdown);
		
		JLabel lblInstrument = new JLabel("Instrument");
		lblInstrument.setBounds(17, 143, 89, 14);
		applicationPanel.add(lblInstrument);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(280, 11, 318, 395);
		applicationPanel.add(scrollPane);
		
		camperTable = new JTable();
		scrollPane.setViewportView(camperTable);
		LoadCampers();

		mailingPanel = new JPanel();
		tabbedPane.addTab("Mailing Notification", null, mailingPanel, null);
		
		checkinPanel = new JPanel();
		tabbedPane.addTab("Camper Checkin", null, checkinPanel, null);
		
		dormAsnPanel = new JPanel();
		tabbedPane.addTab("Dorm Assignment", null, dormAsnPanel, null);
		
		bandAsnPanel = new JPanel();
		tabbedPane.addTab("Band Assignment", null, bandAsnPanel, null);
	}
}
