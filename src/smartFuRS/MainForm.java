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
import javax.swing.ImageIcon;
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
import java.awt.Color;
import java.awt.Dimension;
import java.awt.SystemColor;
import java.awt.Toolkit;
import java.awt.Font;
import java.awt.Image;

import javax.swing.JTextPane;
import javax.swing.JEditorPane;
import javax.swing.border.TitledBorder;
import javax.swing.UIManager;

public class MainForm {

	private JFrame frmSmartFursCamper;
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
	private JLabel lblApplicationRecivedOn;
	private JTextField textField;
	private JTable table;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainForm window = new MainForm();
					window.frmSmartFursCamper.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public void Display() {
		
		frmSmartFursCamper.setVisible(true);
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
		    hasEssayCheckBox.setFont(new Font("Calibri", Font.PLAIN, 16));
		    hasEssayCheckBox.setBackground(SystemColor.window);
		    hasEssayCheckBox.setBounds(10, 286, 198, 31);
		    applicationPanel.add(hasEssayCheckBox);
		    
		    JCheckBox hasRecordingCheckBox = new JCheckBox("Recording");
		    hasRecordingCheckBox.setFont(new Font("Calibri", Font.PLAIN, 16));
		    hasRecordingCheckBox.setBackground(SystemColor.window);
		    hasRecordingCheckBox.setBounds(10, 320, 120, 31);
		    applicationPanel.add(hasRecordingCheckBox);
		    
		    JCheckBox hasPaymentCheckBox = new JCheckBox("Deposit Payment");
		    hasPaymentCheckBox.setFont(new Font("Calibri", Font.PLAIN, 16));
		    hasPaymentCheckBox.setBackground(SystemColor.window);
		    hasPaymentCheckBox.setBounds(10, 355, 184, 31);
		    applicationPanel.add(hasPaymentCheckBox);
		    
		    JButton btnSave = new JButton("Save");
		    btnSave.setBackground(SystemColor.control);
		    btnSave.setFont(new Font("Calibri", Font.PLAIN, 16));
		    btnSave.setBounds(109, 393, 89, 66);
		    applicationPanel.add(btnSave);
		    
		    JButton btnDelete = new JButton("Delete");
		    btnDelete.setBackground(SystemColor.control);
		    btnDelete.setFont(new Font("Calibri", Font.PLAIN, 16));
		    btnDelete.setBounds(208, 393, 95, 66);
		    applicationPanel.add(btnDelete);
		    
		    lblApplicationRecivedOn = new JLabel("Received On");
		    lblApplicationRecivedOn.setFont(new Font("Calibri", Font.PLAIN, 16));
		    lblApplicationRecivedOn.setBackground(Color.WHITE);
		    lblApplicationRecivedOn.setBounds(10, 43, 101, 27);
		    applicationPanel.add(lblApplicationRecivedOn);
		    
		    textField = new JTextField();
		    textField.setFont(new Font("Calibri", Font.PLAIN, 16));
		    textField.setColumns(10);
		    textField.setBackground(Color.WHITE);
		    textField.setBounds(121, 41, 156, 29);
		    applicationPanel.add(textField);
			} catch(Exception ex) {
				System.out.println(ex.getStackTrace());
		}
	}
	
	private void AddCamper(){
		try {
		Camper camperToAdd = new Camper();
		camperToAdd.setFirstname(firstnameTextField.getText());
		camperToAdd.setLastname(lastnameTextField.getText());
		camperToAdd.setBirthday(dobTextField.getText());
		camperToAdd.setInstrument("Singer");
		if(maleRadioButton.isSelected()) {
			camperToAdd.setGender("Male");
		} else {
			camperToAdd.setGender("Female");
		}
		
		FuRSDBUtility.addCamper(camperToAdd);
		} catch (Exception ex) {
			System.out.println(ex.getStackTrace());
		}
		
	}
	
	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmSmartFursCamper = new JFrame();
		frmSmartFursCamper.getContentPane().setBackground(SystemColor.window);
		frmSmartFursCamper.getContentPane().setForeground(SystemColor.desktop);
		frmSmartFursCamper.setForeground(SystemColor.menu);
		frmSmartFursCamper.setType(Type.UTILITY);
		frmSmartFursCamper.setResizable(false);
		frmSmartFursCamper.setBounds(100, 100, 977, 645);
		frmSmartFursCamper.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmSmartFursCamper.getContentPane().setLayout(null);
		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
		frmSmartFursCamper.setLocation(dim.width/2-frmSmartFursCamper.getSize().width/2, dim.height/2-frmSmartFursCamper.getSize().height/2);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setFont(new Font("Calibri", Font.PLAIN, 18));
		tabbedPane.setForeground(SystemColor.desktop);
		tabbedPane.setBackground(SystemColor.window);
		tabbedPane.setBounds(10, 106, 952, 507);
		frmSmartFursCamper.getContentPane().add(tabbedPane);
		
		applicationPanel = new JPanel();
		applicationPanel.setBackground(SystemColor.window);
		tabbedPane.addTab("Applications", (Icon) null, applicationPanel, null);
		applicationPanel.setLayout(null);
		
		JButton btnAdd = new JButton("Add");
		btnAdd.setForeground(SystemColor.desktop);
		btnAdd.setBackground(SystemColor.control);
		btnAdd.setFont(new Font("Calibri", Font.PLAIN, 16));
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				AddCamper();
				LoadCampers();
			}
		});
		btnAdd.setBounds(10, 393, 89, 66);
		applicationPanel.add(btnAdd);
		
		firstnameTextField = new JTextField();
		firstnameTextField.setFont(new Font("Calibri", Font.PLAIN, 16));
		firstnameTextField.setBackground(SystemColor.window);
		firstnameTextField.setBounds(121, 81, 156, 29);
		applicationPanel.add(firstnameTextField);
		firstnameTextField.setColumns(10);
		
		JLabel lblFirstName = new JLabel("First Name");
		lblFirstName.setFont(new Font("Calibri", Font.PLAIN, 16));
		lblFirstName.setBackground(SystemColor.window);
		lblFirstName.setBounds(10, 80, 101, 31);
		applicationPanel.add(lblFirstName);
		
		JLabel lblLastName = new JLabel("Last Name");
		lblLastName.setFont(new Font("Calibri", Font.PLAIN, 16));
		lblLastName.setBackground(SystemColor.window);
		lblLastName.setBounds(10, 120, 101, 31);
		applicationPanel.add(lblLastName);
		
		lastnameTextField = new JTextField();
		lastnameTextField.setFont(new Font("Calibri", Font.PLAIN, 16));
		lastnameTextField.setBackground(SystemColor.window);
		lastnameTextField.setColumns(10);
		lastnameTextField.setBounds(121, 121, 156, 29);
		applicationPanel.add(lastnameTextField);
		
		JLabel lblGender = new JLabel("Gender");
		lblGender.setFont(new Font("Calibri", Font.PLAIN, 16));
		lblGender.setBackground(SystemColor.window);
		lblGender.setBounds(10, 161, 101, 29);
		applicationPanel.add(lblGender);
		
		maleRadioButton = new JRadioButton("Male");
		maleRadioButton.setFont(new Font("Calibri", Font.PLAIN, 16));
		maleRadioButton.setBackground(SystemColor.window);
		maleRadioButton.setBounds(121, 159, 73, 33);
		applicationPanel.add(maleRadioButton);
		
		femaleRadioButton = new JRadioButton("Female");
		femaleRadioButton.setFont(new Font("Calibri", Font.PLAIN, 16));
		femaleRadioButton.setBackground(SystemColor.window);
		femaleRadioButton.setBounds(196, 159, 105, 33);
		applicationPanel.add(femaleRadioButton);
		
		genderBtnGroup = new ButtonGroup();
		genderBtnGroup.add(femaleRadioButton);
		genderBtnGroup.add(maleRadioButton);
		
		dobTextField = new JTextField();
		dobTextField.setFont(new Font("Calibri", Font.PLAIN, 16));
		dobTextField.setBackground(SystemColor.window);
		dobTextField.setBounds(121, 199, 156, 29);
		applicationPanel.add(dobTextField);
		dobTextField.setColumns(10);
		
		JLabel lblDob = new JLabel("DOB");
		lblDob.setFont(new Font("Calibri", Font.PLAIN, 16));
		lblDob.setBackground(SystemColor.window);
		lblDob.setBounds(10, 200, 101, 27);
		applicationPanel.add(lblDob);
		
		instrumentDropdown = new JComboBox<String>();
		instrumentDropdown.setFont(new Font("Calibri", Font.PLAIN, 16));
		instrumentDropdown.setBackground(SystemColor.window);
		instrumentDropdown.setModel(new DefaultComboBoxModel<String>());
		instrumentDropdown.setBounds(121, 239, 156, 29);
		applicationPanel.add(instrumentDropdown);
		
		JLabel lblInstrument = new JLabel("Instrument");
		lblInstrument.setFont(new Font("Calibri", Font.PLAIN, 16));
		lblInstrument.setBackground(SystemColor.window);
		lblInstrument.setBounds(10, 239, 101, 29);
		applicationPanel.add(lblInstrument);
		
		JScrollPane applicationScrollPane = new JScrollPane();
		applicationScrollPane.setBounds(313, 11, 630, 448);
		applicationPanel.add(applicationScrollPane);
		
		camperTable = new JTable();
		camperTable.setFont(new Font("Calibri", Font.PLAIN, 16));
		applicationScrollPane.setViewportView(camperTable);
		camperTable.setRowHeight(21);
		LoadCampers();

		mailingPanel = new JPanel();
		mailingPanel.setBackground(SystemColor.window);
		tabbedPane.addTab("Mailing Notification", null, mailingPanel, null);
		mailingPanel.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(455, 11, 482, 448);
		mailingPanel.add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		
		JButton btnGenerateMail = new JButton("Generate Mail");
		btnGenerateMail.setForeground(Color.BLACK);
		btnGenerateMail.setFont(new Font("Calibri", Font.PLAIN, 18));
		btnGenerateMail.setBackground(SystemColor.menu);
		btnGenerateMail.setBounds(285, 393, 160, 66);
		mailingPanel.add(btnGenerateMail);
		
		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(UIManager.getBorder("CheckBoxMenuItem.border"), "Mail Content", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel.setBounds(16, 86, 431, 304);
		mailingPanel.add(panel);
		panel.setLayout(null);
		
		JTextPane textPane = new JTextPane();
		textPane.setBounds(6, 16, 419, 274);
		panel.add(textPane);
		textPane.setFont(new Font("Calibri", Font.PLAIN, 16));
		
		JLabel lblNewLabel = new JLabel("Please Select the Decision for");
		lblNewLabel.setFont(new Font("Calibri", Font.PLAIN, 16));
		lblNewLabel.setBounds(16, 12, 202, 32);
		mailingPanel.add(lblNewLabel);
		
		JLabel lblJustin = new JLabel("Justin");
		lblJustin.setFont(new Font("Calibri", Font.BOLD, 16));
		lblJustin.setBounds(214, 12, 202, 32);
		mailingPanel.add(lblJustin);
		
		JLabel lblDecision = new JLabel("Decision:");
		lblDecision.setFont(new Font("Calibri", Font.PLAIN, 16));
		lblDecision.setBackground(Color.WHITE);
		lblDecision.setBounds(16, 46, 90, 29);
		mailingPanel.add(lblDecision);
		
		JComboBox<String> comboBox = new JComboBox<String>();
		comboBox.setFont(new Font("Calibri", Font.PLAIN, 16));
		comboBox.setBackground(Color.WHITE);
		comboBox.setBounds(127, 46, 156, 29);
		mailingPanel.add(comboBox);
		
		checkinPanel = new JPanel();
		checkinPanel.setBackground(SystemColor.window);
		tabbedPane.addTab("Camper Checkin", null, checkinPanel, null);
		
		dormAsnPanel = new JPanel();
		dormAsnPanel.setBackground(SystemColor.window);
		tabbedPane.addTab("Dorm Assignment", null, dormAsnPanel, null);
		
		bandAsnPanel = new JPanel();
		bandAsnPanel.setBackground(SystemColor.window);
		tabbedPane.addTab("Band Assignment", null, bandAsnPanel, null);
		
		JLabel topImgbgLabel = new JLabel("");
		topImgbgLabel.setBounds(0, 0, 971, 102);
		Image img = new ImageIcon(this.getClass().getResource("../nlogo-bg-2.png")).getImage();
		topImgbgLabel.setIcon(new ImageIcon(img));
		frmSmartFursCamper.getContentPane().add(topImgbgLabel);
		
		JLabel welcomeLabel = new JLabel("Welcome, Yang");
		welcomeLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		welcomeLabel.setFont(new Font("Calibri", Font.PLAIN, 18));
		welcomeLabel.setBounds(795, 163, 167, 20);
		frmSmartFursCamper.getContentPane().add(welcomeLabel);
	}
}
