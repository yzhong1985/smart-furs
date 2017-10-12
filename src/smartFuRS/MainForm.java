package smartFuRS;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTabbedPane;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JRadioButton;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.util.ArrayList;
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
import javax.swing.ListSelectionModel;
import javax.swing.JEditorPane;
import javax.swing.border.TitledBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.UIManager;
import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;
import javax.swing.JList;

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
	private JLabel lblApplicationRecivedOn;
	private JTextField recvdayTextField;
	private JTable mailingTable;
	private JTextField instrumentTextField;
	private JCheckBox hasEssayCheckBox;
	private JCheckBox hasRecordingCheckBox;
	private JCheckBox hasPaymentCheckBox;
	
	private JLabel idLabel;
	private JLabel lblDob;
	private JLabel lblGender;
	private JButton btnAdd;
	private JButton btnSave;
	private JButton btnDelete;
	private JButton btnCancel;
	private JScrollPane applicationScrollPane;
	
	private Boolean isApplicationEditMode = false;
	
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

	private void reloadApplicationTable() {
		ArrayList<Camper> applicationCampers =FuRSDBUtility.getApplicationCampers();
	    DefaultTableModel model = (DefaultTableModel)camperTable.getModel();
	    model.setRowCount(0);
	    Object rowData[] = new Object[10];
	    for(int i=0; i<applicationCampers.size();i++) {
	    	rowData[0] = applicationCampers.get(i).getId();
	    	rowData[1] = applicationCampers.get(i).getReceivedDateText();
	    	rowData[2] = applicationCampers.get(i).getFirstname();
	    	rowData[3] = applicationCampers.get(i).getLastname();
	    	rowData[4] = applicationCampers.get(i).getBirthdayText();
	    	rowData[5] = applicationCampers.get(i).getGender();
	    	rowData[6] = applicationCampers.get(i).getInstrument();
	    	rowData[7] = applicationCampers.get(i).getHasPersonalEssay();
	    	rowData[8] = applicationCampers.get(i).getHasRecording();
	    	rowData[9] = applicationCampers.get(i).getHasDepositPayment();
	    	model.addRow(rowData);
	    }
	    
	    //firstname, lastname, birthday, gender, instrument,
		//camperTable.setModel( DbUtils.resultSetToTableModel(applicationRs));
	    
	    //ResultSet mailingRs =FuRSDBUtility.getMailingCampers();
	    //mailingTable.setModel( DbUtils.resultSetToTableModel(mailingRs));
	}
	
	private void cleanApplicationInputs() {
		
		recvdayTextField.setText("");
		firstnameTextField.setText("");
		lastnameTextField.setText("");
		dobTextField.setText("");
		instrumentTextField.setText("");
		maleRadioButton.setSelected(true);
		hasRecordingCheckBox.setSelected(false);
		hasEssayCheckBox.setSelected(false);
		hasPaymentCheckBox.setSelected(false);
	}
	
	private boolean ValidateApplicationInput() {
		//should do a validation logic here
		String fname = firstnameTextField.getText().trim();
		String errmsg = "";
		Boolean validateResult = true;
		
		if(fname== null || fname.isEmpty()) {
			errmsg += "Firstname cannot be blank!\n";
			validateResult = false;
		}
		String lname = lastnameTextField.getText().trim();
		if(lname== null || lname.isEmpty()) {
			errmsg += "Lastname cannot be blank!\n";
			validateResult = false;
		}
		String recvdaytxt = recvdayTextField.getText().trim();
		if(recvdaytxt== null || recvdaytxt.isEmpty()) {
			errmsg += "Received Date cannot be blank!\n";
			validateResult = false;
		}
		if(!CalculationUtility.isDateFormattedCorrect(recvdaytxt)) {
			errmsg += "Received Date format incorrect!\n";
			validateResult = false;
		}
		//should check the date format
		String bdatetxt = dobTextField.getText().trim();
		if(bdatetxt== null || bdatetxt.isEmpty()) {
			errmsg += "Birth Date cannot be blank!\n";
			validateResult = false;
		}
		if(!CalculationUtility.isDateFormattedCorrect(bdatetxt)) {
			errmsg += "Birth Date format incorrect!\n";
			validateResult = false;
		}
		String instrumenttxt = instrumentTextField.getText().trim();
		if(instrumenttxt== null || instrumenttxt.isEmpty()) {
			errmsg += "Instrument cannot be blank!";
			validateResult = false;
		}
		if(!validateResult) {
			JOptionPane.showMessageDialog(null, errmsg);
		}
		
		return validateResult;
	}
	
	private void addCamper(){
		
		if(!ValidateApplicationInput()) {
			return;
		}
		
		Camper camperToAdd = new Camper();
		camperToAdd.setReceivedDate(recvdayTextField.getText());
		camperToAdd.setFirstname(firstnameTextField.getText());
		camperToAdd.setLastname(lastnameTextField.getText());
		camperToAdd.setBirthday(dobTextField.getText());
		camperToAdd.setInstrument(instrumentTextField.getText());
		if(maleRadioButton.isSelected()) {
			camperToAdd.setGender("Boy");
		} else {
			camperToAdd.setGender("Girl");
		}
		if(hasEssayCheckBox.isSelected()) {
			camperToAdd.setHasPersonalEssay("YES");
		} else {
			camperToAdd.setHasPersonalEssay("NO");
		}
		if(hasRecordingCheckBox.isSelected()) {
			camperToAdd.setHasRecording("YES");
		} else {
			camperToAdd.setHasRecording("NO");
		}
		if(hasPaymentCheckBox.isSelected()) {
			camperToAdd.setHasDepositPayment("YES");
		} else {
			camperToAdd.setHasDepositPayment("NO");
		}
		
		if(FuRSDBUtility.addCamper(camperToAdd)) {
			//show success msg
			String camperfullname = camperToAdd.getFirstname() + " " + camperToAdd.getLastname();
			JOptionPane.showMessageDialog(null, camperfullname + " has been added into our candidate list.");
			//update the table
			reloadApplicationTable();
			//clean the inputs
			cleanApplicationInputs();
		}
		
	}
	
	private void saveCamper() {
		if(!ValidateApplicationInput()) {
			return;
		}
		Camper camperToUpdate = new Camper();
		String idstr = camperTable.getValueAt(camperTable.getSelectedRow(), 0).toString();
	    int id =Integer.parseInt(idstr);
		camperToUpdate.setId(id);
		camperToUpdate.setReceivedDate(recvdayTextField.getText());
		camperToUpdate.setFirstname(firstnameTextField.getText());
		camperToUpdate.setLastname(lastnameTextField.getText());
		camperToUpdate.setBirthday(dobTextField.getText());
		camperToUpdate.setInstrument(instrumentTextField.getText());
		if(maleRadioButton.isSelected()) {
			camperToUpdate.setGender("Boy");
		} else {
			camperToUpdate.setGender("Girl");
		}
		if(hasEssayCheckBox.isSelected()) {
			camperToUpdate.setHasPersonalEssay("YES");
		} else {
			camperToUpdate.setHasPersonalEssay("NO");
		}
		if(hasRecordingCheckBox.isSelected()) {
			camperToUpdate.setHasRecording("YES");
		} else {
			camperToUpdate.setHasRecording("NO");
		}
		if(hasPaymentCheckBox.isSelected()) {
			camperToUpdate.setHasDepositPayment("YES");
		} else {
			camperToUpdate.setHasDepositPayment("NO");
		}
		if(FuRSDBUtility.updateCamper(camperToUpdate)) {
			//show success msg
			String camperfullname = camperToUpdate.getFirstname() + " " + camperToUpdate.getLastname();
			JOptionPane.showMessageDialog(null, camperfullname + " has been updated.");
			//update the table
			reloadApplicationTable();
			//clean the inputs
			cancelApplicationEdit();
		}
		
	}
	
	private void deleteSelectedCamper() {
		if(!isApplicationEditMode) {
			//something goes wrong
			return;
		}
		String id = camperTable.getValueAt(camperTable.getSelectedRow(), 0).toString();
		String fname = camperTable.getValueAt(camperTable.getSelectedRow(), 2).toString();
    	String lname = camperTable.getValueAt(camperTable.getSelectedRow(), 3).toString();
    	
		int dialogButton = JOptionPane.YES_NO_OPTION;
		int dialogResult = JOptionPane.showConfirmDialog (null, "Are you sure you want to delete "+fname+" "+lname+"?","Warning",dialogButton);
		if(dialogResult == JOptionPane.YES_OPTION){
			if(FuRSDBUtility.deleteCamper(id)) {
				JOptionPane.showMessageDialog(null, fname+" "+lname + " has been deleted from our candidate list.");
				//setback to add mode
				isApplicationEditMode = false;
		    	btnAdd.setVisible(true);
		    	btnSave.setVisible(false);
		    	btnDelete.setVisible(false);
		    	btnCancel.setVisible(false);
		    	idLabel.setVisible(false);
		    	cleanApplicationInputs();
				reloadApplicationTable();
			}
		}
	}
	
	private void cancelApplicationEdit() {
		isApplicationEditMode = false;
    	btnAdd.setVisible(true);
    	btnSave.setVisible(false);
    	btnDelete.setVisible(false);
    	btnCancel.setVisible(false);
    	idLabel.setVisible(false);
    	cleanApplicationInputs();
	}
	
	private void populateFields() {
		isApplicationEditMode = true;
    	btnAdd.setVisible(false);
    	btnSave.setVisible(true);
    	btnDelete.setVisible(true);
    	btnCancel.setVisible(true);
    	idLabel.setVisible(true);
    	String id = camperTable.getValueAt(camperTable.getSelectedRow(), 0).toString();
    	String recvDate = camperTable.getValueAt(camperTable.getSelectedRow(), 1).toString();
    	String fname = camperTable.getValueAt(camperTable.getSelectedRow(), 2).toString();
    	String lname = camperTable.getValueAt(camperTable.getSelectedRow(), 3).toString();
    	String bDate = camperTable.getValueAt(camperTable.getSelectedRow(), 4).toString();
    	String gender = camperTable.getValueAt(camperTable.getSelectedRow(), 5).toString();
    	String instrmt = camperTable.getValueAt(camperTable.getSelectedRow(), 6).toString();
    	String hasEsy = camperTable.getValueAt(camperTable.getSelectedRow(), 7).toString();
    	String hasRec = camperTable.getValueAt(camperTable.getSelectedRow(), 8).toString();
    	String hasDps = camperTable.getValueAt(camperTable.getSelectedRow(), 9).toString();
    	
    	idLabel.setText("Id: "+id);
    	recvdayTextField.setText(recvDate);
    	firstnameTextField.setText(fname);
    	lastnameTextField.setText(lname);
    	dobTextField.setText(bDate);
    	instrumentTextField.setText(instrmt);
    	if(gender.equals("Boy")) {
    		maleRadioButton.setSelected(true);
    	} else {
    		femaleRadioButton.setSelected(true);
    	}
    	
    	if(hasEsy.equals("YES")) {
    		hasEssayCheckBox.setSelected(true);
    	} else {
    		hasEssayCheckBox.setSelected(false);
    	}
    	if(hasRec.equals("YES")) {
    		hasRecordingCheckBox.setSelected(true);
    	} else {
    		hasRecordingCheckBox.setSelected(false);
    	}
    	if(hasDps.equals("YES")) {
    		hasPaymentCheckBox.setSelected(true);
    	} else {
    		hasPaymentCheckBox.setSelected(false);
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
		
		btnAdd = new JButton("Add");
		btnAdd.setForeground(SystemColor.desktop);
		btnAdd.setBackground(SystemColor.control);
		btnAdd.setFont(new Font("Calibri", Font.PLAIN, 16));
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				addCamper();
				//reload application campers
			}
		});
		btnAdd.setBounds(10, 410, 74, 41);
		applicationPanel.add(btnAdd);
		
		firstnameTextField = new JTextField();
		firstnameTextField.setFont(new Font("Calibri", Font.PLAIN, 16));
		firstnameTextField.setBackground(SystemColor.window);
		firstnameTextField.setBounds(121, 99, 156, 29);
		applicationPanel.add(firstnameTextField);
		firstnameTextField.setColumns(10);
		
		JLabel lblFirstName = new JLabel("First Name");
		lblFirstName.setFont(new Font("Calibri", Font.PLAIN, 16));
		lblFirstName.setBackground(SystemColor.window);
		lblFirstName.setBounds(10, 98, 101, 31);
		applicationPanel.add(lblFirstName);
		
		JLabel lblLastName = new JLabel("Last Name");
		lblLastName.setFont(new Font("Calibri", Font.PLAIN, 16));
		lblLastName.setBackground(SystemColor.window);
		lblLastName.setBounds(10, 138, 101, 31);
		applicationPanel.add(lblLastName);
		
		lastnameTextField = new JTextField();
		lastnameTextField.setFont(new Font("Calibri", Font.PLAIN, 16));
		lastnameTextField.setBackground(SystemColor.window);
		lastnameTextField.setColumns(10);
		lastnameTextField.setBounds(121, 139, 156, 29);
		applicationPanel.add(lastnameTextField);
		
		lblGender = new JLabel("Gender");
		lblGender.setFont(new Font("Calibri", Font.PLAIN, 16));
		lblGender.setBackground(SystemColor.window);
		lblGender.setBounds(10, 179, 101, 29);
		applicationPanel.add(lblGender);
		
		maleRadioButton = new JRadioButton("Boy");
		maleRadioButton.setFont(new Font("Calibri", Font.PLAIN, 16));
		maleRadioButton.setBackground(SystemColor.window);
		maleRadioButton.setBounds(121, 177, 73, 33);
		applicationPanel.add(maleRadioButton);
		
		femaleRadioButton = new JRadioButton("Girl");
		femaleRadioButton.setFont(new Font("Calibri", Font.PLAIN, 16));
		femaleRadioButton.setBackground(SystemColor.window);
		femaleRadioButton.setBounds(196, 177, 105, 33);
		applicationPanel.add(femaleRadioButton);
		
		genderBtnGroup = new ButtonGroup();
		genderBtnGroup.add(femaleRadioButton);
		genderBtnGroup.add(maleRadioButton);
		
		dobTextField = new JTextField();
		dobTextField.setToolTipText("Please follow format mm/dd/yyyy");
		dobTextField.setFont(new Font("Calibri", Font.PLAIN, 16));
		dobTextField.setBackground(SystemColor.window);
		dobTextField.setBounds(121, 217, 156, 29);
		applicationPanel.add(dobTextField);
		dobTextField.setColumns(10);
		
		lblDob = new JLabel("DOB");
		lblDob.setFont(new Font("Calibri", Font.PLAIN, 16));
		lblDob.setBackground(SystemColor.window);
		lblDob.setBounds(10, 218, 101, 27);
		applicationPanel.add(lblDob);
		
		JLabel lblInstrument = new JLabel("Instrument");
		lblInstrument.setFont(new Font("Calibri", Font.PLAIN, 16));
		lblInstrument.setBackground(SystemColor.window);
		lblInstrument.setBounds(10, 257, 101, 29);
		applicationPanel.add(lblInstrument);
		
		applicationScrollPane = new JScrollPane();
		applicationScrollPane.setBounds(313, 11, 630, 448);
		applicationPanel.add(applicationScrollPane);
		
		camperTable = new JTable();
		camperTable.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Id", "Recv.On", "FName", "LName", "BDay", "Gender", "Instrument", "Esy", "Rec", "Dps"
			}
		));
		camperTable.setFont(new Font("Calibri", Font.PLAIN, 16));
		applicationScrollPane.setViewportView(camperTable);
		camperTable.setRowHeight(21);
		camperTable.getColumnModel().getColumn(0).setPreferredWidth(20);
		camperTable.getColumnModel().getColumn(1).setPreferredWidth(100);
		camperTable.getColumnModel().getColumn(4).setPreferredWidth(100);
		camperTable.getColumnModel().getColumn(5).setPreferredWidth(50);
		camperTable.getColumnModel().getColumn(7).setPreferredWidth(40);
		camperTable.getColumnModel().getColumn(8).setPreferredWidth(40);
		camperTable.getColumnModel().getColumn(9).setPreferredWidth(40);
		ListSelectionModel selModel = camperTable.getSelectionModel(); 
		selModel.addListSelectionListener(new ListSelectionListener(){
	        @Override
			public void valueChanged(ListSelectionEvent event) {
	            if(!selModel.isSelectionEmpty()) {populateFields();}
	        }
	    });
		

		hasEssayCheckBox = new JCheckBox("Personal Essay");
	    hasEssayCheckBox.setFont(new Font("Calibri", Font.PLAIN, 16));
	    hasEssayCheckBox.setBackground(SystemColor.window);
	    hasEssayCheckBox.setBounds(10, 304, 140, 31);
	    applicationPanel.add(hasEssayCheckBox);
	    
	    hasRecordingCheckBox = new JCheckBox("Recording");
	    hasRecordingCheckBox.setFont(new Font("Calibri", Font.PLAIN, 16));
	    hasRecordingCheckBox.setBackground(SystemColor.window);
	    hasRecordingCheckBox.setBounds(157, 304, 120, 31);
	    applicationPanel.add(hasRecordingCheckBox);
	    
	    hasPaymentCheckBox = new JCheckBox("Deposit Payment");
	    hasPaymentCheckBox.setFont(new Font("Calibri", Font.PLAIN, 16));
	    hasPaymentCheckBox.setBackground(SystemColor.window);
	    hasPaymentCheckBox.setBounds(10, 338, 184, 31);
	    applicationPanel.add(hasPaymentCheckBox);
	    
	    btnSave = new JButton("Save");
	    btnSave.addActionListener(new ActionListener() {
	    	public void actionPerformed(ActionEvent e) {
	    		saveCamper();
	    	}
	    });
	    btnSave.setBackground(SystemColor.control);
	    btnSave.setFont(new Font("Calibri", Font.PLAIN, 16));
	    btnSave.setBounds(127, 410, 85, 41);
	    btnSave.setVisible(false);
	    applicationPanel.add(btnSave);
	    
	    btnDelete = new JButton("Delete");
	    btnDelete.addActionListener(new ActionListener() {
	    	public void actionPerformed(ActionEvent e) {
	    		deleteSelectedCamper();
	    	}
	    });
	    btnDelete.setBackground(SystemColor.control);
	    btnDelete.setFont(new Font("Calibri", Font.PLAIN, 16));
	    btnDelete.setBounds(192, 11, 85, 30);
	    btnDelete.setVisible(false);
	    applicationPanel.add(btnDelete);
	    
	    lblApplicationRecivedOn = new JLabel("Received On");
	    lblApplicationRecivedOn.setFont(new Font("Calibri", Font.PLAIN, 16));
	    lblApplicationRecivedOn.setBackground(Color.WHITE);
	    lblApplicationRecivedOn.setBounds(10, 61, 101, 27);
	    applicationPanel.add(lblApplicationRecivedOn);
	    
	    recvdayTextField = new JTextField();
	    recvdayTextField.setToolTipText("Please follow format mm/dd/yyyy");
	    recvdayTextField.setFont(new Font("Calibri", Font.PLAIN, 16));
	    recvdayTextField.setColumns(10);
	    recvdayTextField.setBackground(Color.WHITE);
	    recvdayTextField.setBounds(121, 59, 156, 29);
	    applicationPanel.add(recvdayTextField);
	    
	    instrumentTextField = new JTextField();
	    instrumentTextField.setToolTipText("");
	    instrumentTextField.setFont(new Font("Calibri", Font.PLAIN, 16));
	    instrumentTextField.setColumns(10);
	    instrumentTextField.setBackground(Color.WHITE);
	    instrumentTextField.setBounds(121, 257, 156, 29);
	    applicationPanel.add(instrumentTextField);
	    
	    idLabel = new JLabel("Id: ");
	    idLabel.setFont(new Font("Calibri", Font.PLAIN, 16));
	    idLabel.setBackground(Color.WHITE);
	    idLabel.setBounds(10, 11, 101, 27);
	    idLabel.setVisible(false);
	    applicationPanel.add(idLabel);
	    
	    btnCancel = new JButton("Cancel");
	    btnCancel.addActionListener(new ActionListener() {
	    	public void actionPerformed(ActionEvent e) {
	    		cancelApplicationEdit();
	    	}
	    });
	    btnCancel.setForeground(Color.BLACK);
	    btnCancel.setFont(new Font("Calibri", Font.PLAIN, 16));
	    btnCancel.setBackground(SystemColor.menu);
	    btnCancel.setBounds(222, 410, 79, 41);
	    btnCancel.setVisible(false);
	    applicationPanel.add(btnCancel);
		
		mailingPanel = new JPanel();
		mailingPanel.setBackground(SystemColor.window);
		tabbedPane.addTab("Mailing Notification", null, mailingPanel, null);
		mailingPanel.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(327, 46, 610, 413);
		mailingPanel.add(scrollPane);
		
		mailingTable = new JTable();
		mailingTable.setFont(new Font("Calibri", Font.PLAIN, 16));
		scrollPane.setViewportView(mailingTable);
		mailingTable.setRowHeight(21);
		
		JButton btnGenerateMail = new JButton("Generate Mail");
		btnGenerateMail.setForeground(Color.BLACK);
		btnGenerateMail.setFont(new Font("Calibri", Font.PLAIN, 18));
		btnGenerateMail.setBackground(SystemColor.menu);
		btnGenerateMail.setBounds(151, 393, 156, 66);
		mailingPanel.add(btnGenerateMail);
		
		JLabel lblNewLabel = new JLabel("Please Select the Decision for");
		lblNewLabel.setFont(new Font("Calibri", Font.PLAIN, 16));
		lblNewLabel.setBounds(16, 12, 202, 32);
		mailingPanel.add(lblNewLabel);
		
		JLabel lblJustin = new JLabel("Justin");
		lblJustin.setFont(new Font("Calibri", Font.BOLD, 16));
		lblJustin.setBounds(214, 12, 146, 32);
		mailingPanel.add(lblJustin);
		
		JLabel lblDecision = new JLabel("Decision:");
		lblDecision.setFont(new Font("Calibri", Font.PLAIN, 16));
		lblDecision.setBackground(Color.WHITE);
		lblDecision.setBounds(16, 46, 90, 29);
		mailingPanel.add(lblDecision);
		
		JComboBox<String> comboBox = new JComboBox<String>();
		comboBox.setFont(new Font("Calibri", Font.PLAIN, 16));
		comboBox.setBackground(Color.WHITE);
		comboBox.setBounds(127, 46, 180, 29);
		mailingPanel.add(comboBox);
		
		JComboBox<String> comboBox_1 = new JComboBox<String>();
		comboBox_1.setFont(new Font("Calibri", Font.PLAIN, 16));
		comboBox_1.setBackground(Color.WHITE);
		comboBox_1.setBounds(127, 86, 180, 29);
		mailingPanel.add(comboBox_1);
		
		JLabel lblCategory = new JLabel("Category:");
		lblCategory.setFont(new Font("Calibri", Font.PLAIN, 16));
		lblCategory.setBackground(Color.WHITE);
		lblCategory.setBounds(16, 86, 90, 29);
		mailingPanel.add(lblCategory);
		
		JButton btnSave_1 = new JButton("Save");
		btnSave_1.setForeground(Color.BLACK);
		btnSave_1.setFont(new Font("Calibri", Font.PLAIN, 18));
		btnSave_1.setBackground(SystemColor.menu);
		btnSave_1.setBounds(16, 393, 113, 66);
		mailingPanel.add(btnSave_1);
		
		JLabel lblSkillLevel = new JLabel("Talent Level:");
		lblSkillLevel.setFont(new Font("Calibri", Font.PLAIN, 16));
		lblSkillLevel.setBackground(Color.WHITE);
		lblSkillLevel.setBounds(16, 126, 90, 29);
		mailingPanel.add(lblSkillLevel);
		
		JSpinner spinner = new JSpinner();
		spinner.setFont(new Font("Calibri", Font.PLAIN, 16));
		spinner.setModel(new SpinnerNumberModel(5, 0, 10, 1));
		spinner.setBounds(127, 126, 65, 29);
		mailingPanel.add(spinner);
		
		JLabel lblNewLabel_1 = new JLabel("Accepted Grils:");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_1.setFont(new Font("Calibri", Font.PLAIN, 16));
		lblNewLabel_1.setBounds(455, 12, 120, 23);
		mailingPanel.add(lblNewLabel_1);
		
		JLabel label = new JLabel("0/24");
		label.setFont(new Font("Calibri", Font.BOLD, 16));
		label.setBounds(585, 12, 65, 23);
		mailingPanel.add(label);
		
		JLabel lblAcceptedBoys = new JLabel("Accepted Boys:");
		lblAcceptedBoys.setHorizontalAlignment(SwingConstants.RIGHT);
		lblAcceptedBoys.setFont(new Font("Calibri", Font.PLAIN, 16));
		lblAcceptedBoys.setBounds(686, 12, 146, 23);
		mailingPanel.add(lblAcceptedBoys);
		
		JLabel label_2 = new JLabel("0/24");
		label_2.setFont(new Font("Calibri", Font.BOLD, 16));
		label_2.setBounds(842, 12, 65, 23);
		mailingPanel.add(label_2);
		
		checkinPanel = new JPanel();
		checkinPanel.setBackground(SystemColor.window);
		tabbedPane.addTab("Camper Checkin", null, checkinPanel, null);
		checkinPanel.setLayout(null);
		
		dormAsnPanel = new JPanel();
		dormAsnPanel.setBackground(SystemColor.window);
		tabbedPane.addTab("Dorm Assignment", null, dormAsnPanel, null);
		dormAsnPanel.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(null, "Grils Dorm #1", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel.setBounds(20, 17, 191, 203);
		dormAsnPanel.add(panel);
		panel.setLayout(null);
		
		JList listDorm1 = new JList();
		listDorm1.setFont(new Font("Calibri", Font.PLAIN, 14));
		listDorm1.setBounds(6, 16, 179, 176);
		panel.add(listDorm1);
		
		JPanel panel_1 = new JPanel();
		panel_1.setLayout(null);
		panel_1.setBorder(new TitledBorder(null, "Grils Dorm #2", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_1.setBounds(220, 17, 191, 203);
		dormAsnPanel.add(panel_1);
		
		JList list = new JList();
		list.setFont(new Font("Calibri", Font.PLAIN, 14));
		list.setBounds(6, 16, 179, 176);
		panel_1.add(list);
		
		JPanel panel_2 = new JPanel();
		panel_2.setLayout(null);
		panel_2.setBorder(new TitledBorder(null, "Grils Dorm #3", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_2.setBounds(420, 17, 191, 203);
		dormAsnPanel.add(panel_2);
		
		JList list_1 = new JList();
		list_1.setFont(new Font("Calibri", Font.PLAIN, 14));
		list_1.setBounds(6, 16, 179, 176);
		panel_2.add(list_1);
		
		JPanel panel_3 = new JPanel();
		panel_3.setLayout(null);
		panel_3.setBorder(new TitledBorder(null, "Boys Dorm #1", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_3.setBounds(20, 238, 191, 203);
		dormAsnPanel.add(panel_3);
		
		JList list_2 = new JList();
		list_2.setFont(new Font("Calibri", Font.PLAIN, 14));
		list_2.setBounds(6, 16, 179, 176);
		panel_3.add(list_2);
		
		JPanel panel_4 = new JPanel();
		panel_4.setLayout(null);
		panel_4.setBorder(new TitledBorder(null, "Boys Dorm #2", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_4.setBounds(220, 238, 191, 203);
		dormAsnPanel.add(panel_4);
		
		JList list_3 = new JList();
		list_3.setFont(new Font("Calibri", Font.PLAIN, 14));
		list_3.setBounds(6, 16, 179, 176);
		panel_4.add(list_3);
		
		JPanel panel_5 = new JPanel();
		panel_5.setLayout(null);
		panel_5.setBorder(new TitledBorder(null, "Boys Dorm #3", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_5.setBounds(420, 238, 191, 203);
		dormAsnPanel.add(panel_5);
		
		JList list_4 = new JList();
		list_4.setFont(new Font("Calibri", Font.PLAIN, 14));
		list_4.setBounds(6, 16, 179, 176);
		panel_5.add(list_4);
		
		bandAsnPanel = new JPanel();
		bandAsnPanel.setBackground(SystemColor.window);
		tabbedPane.addTab("Band Assignment", null, bandAsnPanel, null);
		bandAsnPanel.setLayout(null);
		
		JPanel panel_6 = new JPanel();
		panel_6.setLayout(null);
		panel_6.setBorder(new TitledBorder(null, "Band #1", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_6.setBounds(10, 22, 191, 203);
		bandAsnPanel.add(panel_6);
		
		JList list_5 = new JList();
		list_5.setFont(new Font("Calibri", Font.PLAIN, 14));
		list_5.setBounds(6, 16, 179, 176);
		panel_6.add(list_5);
		
		JPanel panel_7 = new JPanel();
		panel_7.setLayout(null);
		panel_7.setBorder(new TitledBorder(null, "Band #2", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_7.setBounds(210, 22, 191, 203);
		bandAsnPanel.add(panel_7);
		
		JList list_6 = new JList();
		list_6.setFont(new Font("Calibri", Font.PLAIN, 14));
		list_6.setBounds(6, 16, 179, 176);
		panel_7.add(list_6);
		
		JPanel panel_8 = new JPanel();
		panel_8.setLayout(null);
		panel_8.setBorder(new TitledBorder(null, "Band #3", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_8.setBounds(410, 22, 191, 203);
		bandAsnPanel.add(panel_8);
		
		JList list_7 = new JList();
		list_7.setFont(new Font("Calibri", Font.PLAIN, 14));
		list_7.setBounds(6, 16, 179, 176);
		panel_8.add(list_7);
		
		JPanel panel_9 = new JPanel();
		panel_9.setLayout(null);
		panel_9.setBorder(new TitledBorder(null, "Band #5", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_9.setBounds(10, 243, 191, 203);
		bandAsnPanel.add(panel_9);
		
		JList list_8 = new JList();
		list_8.setFont(new Font("Calibri", Font.PLAIN, 14));
		list_8.setBounds(6, 16, 179, 176);
		panel_9.add(list_8);
		
		JPanel panel_10 = new JPanel();
		panel_10.setLayout(null);
		panel_10.setBorder(new TitledBorder(null, "Band #6", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_10.setBounds(210, 243, 191, 203);
		bandAsnPanel.add(panel_10);
		
		JList list_9 = new JList();
		list_9.setFont(new Font("Calibri", Font.PLAIN, 14));
		list_9.setBounds(6, 16, 179, 176);
		panel_10.add(list_9);
		
		JPanel panel_11 = new JPanel();
		panel_11.setLayout(null);
		panel_11.setBorder(new TitledBorder(null, "Band #7", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_11.setBounds(410, 243, 191, 203);
		bandAsnPanel.add(panel_11);
		
		JList list_10 = new JList();
		list_10.setFont(new Font("Calibri", Font.PLAIN, 14));
		list_10.setBounds(6, 16, 179, 176);
		panel_11.add(list_10);
		
		JPanel panel_12 = new JPanel();
		panel_12.setLayout(null);
		panel_12.setBorder(new TitledBorder(null, "Band #4", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_12.setBounds(611, 22, 191, 203);
		bandAsnPanel.add(panel_12);
		
		JList list_11 = new JList();
		list_11.setFont(new Font("Calibri", Font.PLAIN, 14));
		list_11.setBounds(6, 16, 179, 176);
		panel_12.add(list_11);
		
		JPanel panel_13 = new JPanel();
		panel_13.setLayout(null);
		panel_13.setBorder(new TitledBorder(null, "Band #8", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_13.setBounds(611, 243, 191, 203);
		bandAsnPanel.add(panel_13);
		
		JList list_12 = new JList();
		list_12.setFont(new Font("Calibri", Font.PLAIN, 14));
		list_12.setBounds(6, 16, 179, 176);
		panel_13.add(list_12);
		
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
		
		reloadApplicationTable();
	}
}
