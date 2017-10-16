package smartFuRS;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTabbedPane;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JRadioButton;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.awt.event.ActionEvent;
import java.awt.Window.Type;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.ButtonGroup;
import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListModel;
import javax.swing.JTable;

import javax.swing.table.DefaultTableModel;

import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFParagraph;
import org.apache.poi.xwpf.usermodel.XWPFRun;

import javax.swing.JScrollPane;
import javax.swing.JCheckBox;
import javax.swing.SwingConstants;
import java.awt.Color;
import java.awt.Desktop;
import java.awt.Dimension;
import java.awt.SystemColor;
import java.awt.Toolkit;
import java.awt.Font;
import java.awt.Image;

import javax.swing.JTextPane;
import javax.swing.ListSelectionModel;
import javax.swing.border.TitledBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
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
	private JTextPane txtpnMail;
	
	private Boolean isApplicationEditMode = false;
	
	private JLabel lblMailingFname;
	private JComboBox<String> statusDropdown;
	private JSpinner spinnerTelentLvl;
	private JComboBox<String> dropdownCategory;
	private JButton btnMailingCancel;
	private JButton btnGenerateMail;
	private JLabel lblNewLabel;
	private JButton btnMailingSave;
	
	private JLabel labelMailingTotalBoy;
	private JLabel labelMailingTotalGril;
	private JLabel labelSingerNum;
	private JLabel lblInstrumentalistNum;
	private JLabel lblKeyboardistNum;
	private JLabel lblBassistNum;
	private JLabel lblDrummerNum;
	private JLabel labelGuitaristNum;
	private JLabel lblCategoryboygirl;
	
	private JButton btnAutoAssignDorm;
	private JList<DormItem> listGirlDorm1;
	private JList<DormItem> listGirlDorm2;
	private JList<DormItem> listGirlDorm3;
	private JList<DormItem> listBoyDorm1;
	private JList<DormItem> listBoyDorm2;
	private JList<DormItem> listBoyDorm3;
	
	private DefaultListModel<DormItem> girlDorm1Model = new DefaultListModel<DormItem>();
	private DefaultListModel<DormItem> girlDorm2Model = new DefaultListModel<DormItem>();
	private DefaultListModel<DormItem> girlDorm3Model = new DefaultListModel<DormItem>();
	private DefaultListModel<DormItem> boyDorm1Model = new DefaultListModel<DormItem>();
	private DefaultListModel<DormItem> boyDorm2Model = new DefaultListModel<DormItem>();
	private DefaultListModel<DormItem> boyDorm3Model = new DefaultListModel<DormItem>();
	
	private JList<BandItem> listBand1;
	private JList<BandItem> listBand2;
	private JList<BandItem> listBand3;
	private JList<BandItem> listBand4;
	private JList<BandItem> listBand5;
	private JList<BandItem> listBand6;
	private JList<BandItem> listBand7;
	private JList<BandItem> listBand8;
	
	private JComboBox<String> campDateDropdown;
	private JButton btnRequest;
	private JComboBox<DormItem> camperDropdownSwaper1;
	private JComboBox<DormItem> camperDropdownSwaper2;
	private JLabel welcomeLabel;
	
	private DefaultComboBoxModel<DormItem> dormSwaper1Model = new DefaultComboBoxModel<DormItem>();
	private DefaultComboBoxModel<DormItem> dormSwaper2Model = new DefaultComboBoxModel<DormItem>();
	
	private ArrayList<Camper> allDormCampers = new ArrayList<Camper>();
	private boolean isDormAssigned = false;
	private JTable tableCheckin;
	
	private String appUser = "user";
	
	private DefaultListModel<BandItem> band1Model = new DefaultListModel<BandItem>();
	private DefaultListModel<BandItem> band2Model = new DefaultListModel<BandItem>();
	private DefaultListModel<BandItem> band3Model = new DefaultListModel<BandItem>();
	private DefaultListModel<BandItem> band4Model = new DefaultListModel<BandItem>();
	private DefaultListModel<BandItem> band5Model = new DefaultListModel<BandItem>();
	private DefaultListModel<BandItem> band6Model = new DefaultListModel<BandItem>();
	private DefaultListModel<BandItem> band7Model = new DefaultListModel<BandItem>();
	private DefaultListModel<BandItem> band8Model = new DefaultListModel<BandItem>();
	
	public void SetAppUser(String user) {
		appUser = user;
		welcomeLabel.setText("Welcome, "+appUser);
	}
	
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

	
	/**
	 * #### USER STORY 1 Methods: Log applications ###
	 */
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
		} else {
			//validate receive date
			String campDateName = (String)campDateDropdown.getSelectedItem();
			String campDateTxt = "";
			if(campDateName.equals("2017 Jun")) {
				campDateTxt = "06/04/2017";
			} else if(campDateName.equals("2017 July")) {
				campDateTxt = "07/02/2017";
			} else if(campDateName.equals("2017 Augest")) {
				campDateTxt = "08/06/2017";
			}
			if(!CalculationUtility.isReceivedDateValidForCamp(recvdaytxt, campDateTxt)) {
				errmsg += "Received Date has to be at least one month early and not more than three month early!\n";
				validateResult = false;
			}
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
			//update mailing table too
			reloadMailingCampersTable();
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
			reloadMailingCampersTable();
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
				reloadMailingCampersTable();
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
	 * ####### END USER STORY 1 Methods ###
	 */
	
	/**
	 * #### USER STORY 2 Methods: Mailing notifications ###
	 */
	private void openWordMailTemplate() {
		try {
			@SuppressWarnings("resource")
			XWPFDocument document = new XWPFDocument();
			FileOutputStream out = new FileOutputStream(new File("notification.docx"));
			String content = txtpnMail.getText();
			String[] paraArray = content.split("\r\n");
			for(String p:paraArray) {
				XWPFParagraph paragraph = document.createParagraph();
				XWPFRun run = paragraph.createRun();
				run.setText(p);
			}
			document.write(out);
			out.close();
			//display word
			Desktop desktop = null;
		    if (Desktop.isDesktopSupported()) {
		        desktop = Desktop.getDesktop();
		    }

		    desktop.open(new File("notification.docx"));
						
		} catch (Exception ex) {
			ex.printStackTrace();
		} 
	}	
	
	private void reloadMailingCampersTable() {
		ArrayList<Camper> mailCampers =FuRSDBUtility.getMailingCampers();
	    DefaultTableModel model = (DefaultTableModel)mailingTable.getModel();
	    model.setRowCount(0);
	    Object rowData[] = new Object[12];
	    for(int i=0; i<mailCampers.size();i++) {
	    	rowData[0] = mailCampers.get(i).getId();
	    	rowData[1] = mailCampers.get(i).getApplicationStatus();
	    	rowData[2] = mailCampers.get(i).getFirstname();
	    	rowData[3] = mailCampers.get(i).getLastname();
	    	rowData[4] = mailCampers.get(i).getAge();
	    	rowData[5] = mailCampers.get(i).getGender();
	    	rowData[6] = mailCampers.get(i).getInstrument();
	    	rowData[7] = mailCampers.get(i).getCategory();
	    	rowData[8] = mailCampers.get(i).getTalentLevel();
	    	rowData[9] = mailCampers.get(i).getHasPersonalEssay();
	    	rowData[10] = mailCampers.get(i).getHasRecording();
	    	rowData[11] = mailCampers.get(i).getHasDepositPayment();
	    	model.addRow(rowData);
	    }
	    
	    int totalgirls = getAcceptGender("Girl",mailCampers);
	    int totalboys = getAcceptGender("Boy",mailCampers);
	    
	    int numsingerboy = getAcceptCategoryByGender("Boy", "Singer", mailCampers);
	    int numsingergirl = getAcceptCategoryByGender("Girl", "Singer", mailCampers);
	    int numguitaristboy = getAcceptCategoryByGender("Boy", "Guitarist", mailCampers);
	    int numguitaristgirl = getAcceptCategoryByGender("Girl", "Guitarist", mailCampers);
	    int numdrummerboy = getAcceptCategoryByGender("Boy", "Drummer", mailCampers);
	    int numdrummergirl = getAcceptCategoryByGender("Girl", "Drummer", mailCampers);
	    int numbassistboy = getAcceptCategoryByGender("Boy", "Bassist", mailCampers);
	    int numbassistgirl = getAcceptCategoryByGender("Girl", "Bassist", mailCampers);
	    int numkeyboardistboy = getAcceptCategoryByGender("Boy", "Keyboardist", mailCampers);
	    int numkeyboardistgirl = getAcceptCategoryByGender("Girl", "Keyboardist", mailCampers);
	    int numinstrumentalistboy = getAcceptCategoryByGender("Boy", "Instrumentalist", mailCampers);
	    int numinstrumentalistgirl = getAcceptCategoryByGender("Girl", "Instrumentalist", mailCampers);
	    
	    labelSingerNum.setText("Singer: "+numsingerboy+"/"+numsingergirl);
	    labelGuitaristNum.setText("Guitarist: "+numguitaristboy+"/"+numguitaristgirl);
	    lblDrummerNum.setText("Drummer: "+numdrummerboy+"/"+numdrummergirl);
	    lblBassistNum.setText("Bassist: "+numbassistboy+"/"+numbassistgirl);
	    lblKeyboardistNum.setText("Keyboardist: "+numkeyboardistboy+"/"+numkeyboardistgirl);
	    lblInstrumentalistNum.setText("Instrumentalist: "+numinstrumentalistboy+"/"+numinstrumentalistgirl);
	    labelMailingTotalGril.setText(totalgirls + "/24");
	    labelMailingTotalBoy.setText(totalboys + "/24");
	    
	    
	}
	
	@SuppressWarnings("null")
	private void populateMailingFields() {
		
		btnMailingSave.setVisible(true);
		btnMailingCancel.setVisible(true);
		btnGenerateMail.setVisible(true);
		statusDropdown.setEnabled(true);
		dropdownCategory.setEnabled(true);
		
    	String fname = mailingTable.getValueAt(mailingTable.getSelectedRow(), 2).toString();
    	String status = "";
    	if(mailingTable.getValueAt(mailingTable.getSelectedRow(), 1) !=null) {
    		status	= mailingTable.getValueAt(mailingTable.getSelectedRow(), 1).toString();
    	}
    	String talentlvltxt = "";
    	if(mailingTable.getValueAt(mailingTable.getSelectedRow(), 8) !=null) {
    		talentlvltxt	= mailingTable.getValueAt(mailingTable.getSelectedRow(), 8).toString();
    	}
    	String category = "";
    	if(mailingTable.getValueAt(mailingTable.getSelectedRow(), 7) !=null) {
    		category = mailingTable.getValueAt(mailingTable.getSelectedRow(), 7).toString();
    	}
    	
    	//set to controls
    	lblMailingFname.setText(fname);
    	if(status.equals("Accept")||status.equals("Deny")) {
    		statusDropdown.setSelectedItem(status);
    	} else {
    		statusDropdown.setSelectedItem("Undecided");
    	}
    	
    	int talentlvl = 0;   	
    	try{
    		talentlvl = Integer.parseInt(talentlvltxt);
    	} catch (Exception ex) {
    		ex.printStackTrace();
    	}
    	spinnerTelentLvl.setValue(talentlvl);
    	
    	if(category!=null ||!category.isEmpty()) {
    		dropdownCategory.setSelectedItem(category);
    	}
    	else {
    		dropdownCategory.setSelectedItem("Not Assigned");
    	}
	}
	
	private void mailingStatusChange() {
		String selStatus = statusDropdown.getSelectedItem().toString();
		String content = "";
		String fname = mailingTable.getValueAt(mailingTable.getSelectedRow(), 2).toString();
		String lname = mailingTable.getValueAt(mailingTable.getSelectedRow(), 3).toString();
		if(selStatus.equals("Accept")) {
			content = String.format(FuRSDBUtility.AcceptMailContent, fname, lname);
		} else if(selStatus.equals("Deny")) {
			content = String.format(FuRSDBUtility.DenyMailContent, fname, lname);
		} else {
			content = "";
		}
		txtpnMail.setText(content);
	}
	
	private void clearMailingFields(boolean isStart) {
		btnMailingSave.setVisible(false);
		btnMailingCancel.setVisible(false);
		btnGenerateMail.setVisible(false);
		statusDropdown.setEnabled(false);
		dropdownCategory.setEnabled(false);
		spinnerTelentLvl.setValue(0);
		
		txtpnMail.setText("");
		lblMailingFname.setText("");
		if(!isStart) {
			dropdownCategory.setSelectedIndex(0);
			statusDropdown.setSelectedIndex(0);
		}
	}
	
	private int getAcceptGender(String boyorgirl, ArrayList<Camper> campers) {
		int total = 0;
		for (Camper camp:campers){
			String status = camp.getApplicationStatus();
			String gender = camp.getGender();
			if(status==null ||status.isEmpty()) {
				continue;
			}
				
			if(status.equals("Accept") && gender.equals(boyorgirl)) {
				total ++;
			}
		}
		return total;
	}
	
	private int getAcceptCategoryByGender(String boyorgirl, String category, ArrayList<Camper> campers) {
		int total = 0;
		for (Camper camp:campers){
			String status = camp.getApplicationStatus();
			String gender = camp.getGender();
			String campercat = camp.getCategory();
			if(status==null ||status.isEmpty()||campercat==null||campercat.isEmpty()) {
				continue;
			}
				
			if(status.equals("Accept") && gender.equals(boyorgirl)&&campercat.equals(category)) {
				total ++;
			}
		}
		return total;
	}
	
	private void saveCamperStatus() {
		
		Camper camperToUpdate = new Camper();
		String idstr = mailingTable.getValueAt(mailingTable.getSelectedRow(), 0).toString();
	    int id =Integer.parseInt(idstr);
		camperToUpdate.setId(id);
		camperToUpdate.setCategory(dropdownCategory.getSelectedItem().toString());
		camperToUpdate.setApplicationStatus(statusDropdown.getSelectedItem().toString());
		camperToUpdate.setTalentLevel(spinnerTelentLvl.getValue().toString());
		
		if(FuRSDBUtility.updateCamperStatus(camperToUpdate)) {
			//show success msg
			String fname = mailingTable.getValueAt(mailingTable.getSelectedRow(), 2).toString();
			String lname = mailingTable.getValueAt(mailingTable.getSelectedRow(), 3).toString();
			String camperfullname = fname + " " + lname;
			JOptionPane.showMessageDialog(null, camperfullname + " has been updated.");
			//update the table
			reloadMailingCampersTable();
			//clean the inputs
			clearMailingFields(true);
		}
		
	}
	
	//#### USER STORY 3 ###
	private void reloadCheckinTable() {
		
		ArrayList<Camper> checkinCampers =FuRSDBUtility.getCheckinCampers();
	    DefaultTableModel model = (DefaultTableModel)tableCheckin.getModel();
	    model.setRowCount(0);
	    Object rowData[] = new Object[5];
	    for(int i=0; i<checkinCampers.size();i++) {
	    	rowData[0] = checkinCampers.get(i).getId();
	    	rowData[1] = checkinCampers.get(i).getFirstname();
	    	rowData[2] = checkinCampers.get(i).getLastname();
	    	rowData[3] = checkinCampers.get(i).getAge();
	    	rowData[4] = checkinCampers.get(i).getGender();
	    	model.addRow(rowData);
	    }
		
	}
	
	//####  USER STORY DORM ASSIGNMENT  #################
	private void autoAssnDorm() {
		
		ArrayList<Camper> allAcceptCampers = FuRSDBUtility.getAllAcceptedCampers(); 
		
		//check the number of boys and girls are both 24
		int numBoys = getAcceptGender("Boy", allAcceptCampers);
		int numGirls = getAcceptGender("Girl", allAcceptCampers);
		String errmsg = "";
		if(numBoys!=24) {
			errmsg += "Number of boys is not correct. please have 24 boys\r\n";
		}
		if(numGirls!=24) {
			errmsg += "Number of boys is not correct. please have 24 boys";
		}
		if(!errmsg.equals("")) {
			JOptionPane.showMessageDialog(null, errmsg);
			return;
		}
		
		ArrayList<Camper> ageGroupA = new ArrayList<Camper>();
		ArrayList<Camper> ageGroupB = new ArrayList<Camper>();
		ArrayList<Camper> ageGroupC = new ArrayList<Camper>();
		
		for(Camper c: allAcceptCampers) {
			int age = c.getAge();
			if(age<=14) {
				ageGroupA.add(c);
			} else if(age==15||age==16) {
				ageGroupB.add(c);
			} else if(age>=17) {
				ageGroupC.add(c);
			}
		}
		
		//randomize
		Collections.shuffle(ageGroupA);
		Collections.shuffle(ageGroupB);
		Collections.shuffle(ageGroupC);
		
		//assign girls dorm
		ArrayList<Camper> girlGroup = CalculationUtility.getCampersByGender("Girl", allAcceptCampers);
		ArrayList<Camper> ageAGirlGroup = CalculationUtility.getCampersByGender("Girl", ageGroupA);
		ArrayList<Camper> ageBGirlGroup = CalculationUtility.getCampersByGender("Girl", ageGroupB);
		ArrayList<Camper> ageCGirlGroup = CalculationUtility.getCampersByGender("Girl", ageGroupC);		
		
		int fewest = 1;
		//split ageAGirlGroup into 3
		for(int i=0;i<ageAGirlGroup.size();i++) {
			int groupNum = (i+fewest) %3;
			if(groupNum==0) { groupNum = 3; }
			ageAGirlGroup.get(i).setDormNum(groupNum);
		}
		fewest = CalculationUtility.getDormFewestGroup(girlGroup);
		for(int i=0;i<ageBGirlGroup.size();i++) {
			int groupNum = (i+fewest) %3;
			if(groupNum==0) { groupNum = 3; }
			ageBGirlGroup.get(i).setDormNum(groupNum);
		}
		fewest = CalculationUtility.getDormFewestGroup(girlGroup);
		for(int i=0;i<ageCGirlGroup.size();i++) {
			int groupNum = (i+fewest) %3;
			if(groupNum==0) { groupNum = 3; }
			ageCGirlGroup.get(i).setDormNum(groupNum);
		}
		
		ArrayList<Camper> boyGroup = CalculationUtility.getCampersByGender("Boy", allAcceptCampers);
		ArrayList<Camper> ageABoyGroup = CalculationUtility.getCampersByGender("Boy", ageGroupA);
		ArrayList<Camper> ageBBoyGroup = CalculationUtility.getCampersByGender("Boy", ageGroupB);
		ArrayList<Camper> ageCBoyGroup = CalculationUtility.getCampersByGender("Boy", ageGroupC);
		
		fewest = 1;
		//split ageAGirlGroup into 3
		for(int i=0;i<ageABoyGroup.size();i++) {
			int groupNum = (i+fewest) %3;
			if(groupNum==0) { groupNum = 3; }
			ageABoyGroup.get(i).setDormNum(groupNum);
		}
		fewest = CalculationUtility.getDormFewestGroup(boyGroup);
		for(int i=0;i<ageBBoyGroup.size();i++) {
			int groupNum = (i+fewest) %3;
			if(groupNum==0) { groupNum = 3; }
			ageBBoyGroup.get(i).setDormNum(groupNum);
		}
		fewest = CalculationUtility.getDormFewestGroup(boyGroup);
		for(int i=0;i<ageCBoyGroup.size();i++) {
			int groupNum = (i+fewest) %3;
			if(groupNum==0) { groupNum = 3; }
			ageCBoyGroup.get(i).setDormNum(groupNum);
		}

		//asign to global
		allDormCampers = allAcceptCampers;
		//add to lists
		reloadDorm();
		
		isDormAssigned = true;
	}

	private void reloadDorm() {
		
		girlDorm1Model.clear();
		girlDorm2Model.clear();
		girlDorm3Model.clear();
		boyDorm1Model.clear();
		boyDorm2Model.clear();
		boyDorm3Model.clear();
		for(Camper c:allDormCampers) {			
			int dormNum = c.getDormNum();
			if(c.getGender().equals("Girl")) {
				if(dormNum==1) {
					girlDorm1Model.addElement(new DormItem(c.getFirstname(), c.getLastname(), c.getGender(), c.getAge(), c.getId()));
				} else if(dormNum==2) {
					girlDorm2Model.addElement(new DormItem(c.getFirstname(), c.getLastname(), c.getGender(), c.getAge(), c.getId()));
				} else if(dormNum==3) {
					girlDorm3Model.addElement(new DormItem(c.getFirstname(), c.getLastname(), c.getGender(), c.getAge(), c.getId()));
				}
			} else if(c.getGender().equals("Boy")) {
				if(dormNum==1) {
					boyDorm1Model.addElement(new DormItem(c.getFirstname(), c.getLastname(), c.getGender(), c.getAge(), c.getId()));
				} else if(dormNum==2) {
					boyDorm2Model.addElement(new DormItem(c.getFirstname(), c.getLastname(), c.getGender(), c.getAge(), c.getId()));
				} else if(dormNum==3) {
					boyDorm3Model.addElement(new DormItem(c.getFirstname(), c.getLastname(), c.getGender(), c.getAge(), c.getId()));
				}
			}
		}
	}
	
	
	private void loadDormSwapDropdowns() {
		ArrayList<Camper> allAcceptCampers = FuRSDBUtility.getAllAcceptedCampers(); 
		for(Camper c: allAcceptCampers) {
			dormSwaper1Model.addElement(new DormItem(c.getFirstname(), c.getLastname(), c.getGender(), c.getAge(), c.getId()));
			dormSwaper2Model.addElement(new DormItem(c.getFirstname(), c.getLastname(), c.getGender(), c.getAge(), c.getId()));
		}
	}
	
	private void swapCampersDormRequest() {
	    DormItem camp1 = (DormItem)camperDropdownSwaper1.getSelectedItem();
	    DormItem camp2 = (DormItem)camperDropdownSwaper2.getSelectedItem();
		
	    if(!isDormAssigned) {
	    	JOptionPane.showMessageDialog(null, "The request cannot be performed.\r\nWe haven't assigned dorm yet.");
	    	return;
	    }
	    
	    if(!camp1.getGender().equals(camp2.getGender())) {
	    	JOptionPane.showMessageDialog(null, "The request cannot be performed.\r\nWe can't make a dorm swap between a boy and a girl.");
	    	return;
	    }
	    
	    if(camp1.getId()==camp2.getId()) {
	    	JOptionPane.showMessageDialog(null, "The request cannot be performed.\r\nPlease select different campers.");
	    	return;
	    }
	    
	    Camper cmp1=null;
	    Camper cmp2=null;
	    for(Camper c: allDormCampers) {
	    	if(c.getId()==camp1.getId()) {
	    		cmp1 = c;
	    	}
	    	if(c.getId()==camp2.getId()) {
	    		cmp2 = c;
	    	}
	    	if(cmp1!=null&&cmp2!=null) {
	    		break;
	    	}
	    }
	    if(cmp1.getDormNum()==cmp2.getDormNum()) {
	    	JOptionPane.showMessageDialog(null, "The request cannot be performed.\r\nPlease select camper from different dorms.");
	    	return;
	    }
	    if(cmp1.getAgeGroup()!=cmp2.getAgeGroup()) {
	    	JOptionPane.showMessageDialog(null, "The request cannot be performed.\r\nAge group rule violation! We want to keep age distributed evenly.");
	    	return;
	    } else {
	    	//swap dorm
	    	int dorm1 = cmp1.getDormNum();
	    	int dorm2 = cmp2.getDormNum();
	    	cmp1.setDormNum(dorm2);
	    	cmp2.setDormNum(dorm1);
	    	String fullname1 = cmp1.getFirstname() + cmp1.getLastname();
	    	String fullname2 = cmp2.getFirstname() + cmp2.getLastname();
	    	String gender = cmp1.getGender();
	    	//reload the group
	    	
	    	reloadDorm();
	    	JOptionPane.showMessageDialog(null, "The dorm swap request has been performed.\r\n"+ fullname1 + " has moved to "+gender+" Dorm #" + dorm2 + " and\r\n"+fullname2+ " has moved to "+gender+" Dorm #" + dorm1);
	    	return;
	    }
		
	}
	
	//#### USER STORY BAND ASSIGNMENT #################
	private void autoAssnBand() {
		
		ArrayList<Camper> allAcceptCampers = FuRSDBUtility.getAllAcceptedCampers(); 
		//Group them into 6 category
		ArrayList<Camper> singers = CalculationUtility.getCampersByCategory("Singer", allAcceptCampers);
		ArrayList<Camper> guitarists = CalculationUtility.getCampersByCategory("Guitarist", allAcceptCampers);
		ArrayList<Camper> drummers = CalculationUtility.getCampersByCategory("Drummer", allAcceptCampers);
		ArrayList<Camper> bassists = CalculationUtility.getCampersByCategory("Bassist", allAcceptCampers);
		ArrayList<Camper> keyboardists = CalculationUtility.getCampersByCategory("Keyboardist", allAcceptCampers);
		ArrayList<Camper> instrumentalists = CalculationUtility.getCampersByCategory("Instrumentalist", allAcceptCampers);
		//Sort each of them based on talentlevel and gender
		Collections.sort(singers);
		Collections.sort(guitarists);
		Collections.sort(drummers);
		Collections.sort(bassists);
		Collections.sort(keyboardists);
		Collections.sort(instrumentalists);
		
	    ArrayList<ArrayList<Camper>> allCat = new ArrayList<ArrayList<Camper>>();
	    allCat.add(singers);
	    allCat.add(guitarists);
	    allCat.add(drummers);
	    allCat.add(bassists);
	    allCat.add(keyboardists);
	    allCat.add(instrumentalists);
	    Collections.shuffle(allCat);
	    
	    //6 cats each assign number
	    boolean order = true;
	    //for random asisgn
	    int advArg = 0;
	    int advIndx = 0;
	    
	    for(int i=1; i<=allCat.size();i++) {
	    	if(advIndx==2) {
	    		//reset
	    		advArg=4; //adv factor = 
	    	} else if(advIndx==4) {
	    		advArg=0;
	    	}
	    	
	    	ArrayList<Camper> thisCat = allCat.get(i-1);
	    	//System.out.println("-------------Group"+i);
	    	for(int j=0; j<thisCat.size(); j++) {
	    		Camper c = thisCat.get(j);
	    		int bnum = ((j+1) + advArg)%8;
	    		if(bnum==0) {
	    			bnum=8;
	    		}
	    		//make some switch
	    		if(advArg!=0) {
	    			if(bnum>4&&bnum<=6) {
	    				bnum=bnum+2;
	    			} else if(bnum>6) {
	    				bnum=bnum-2;
	    			} else if(bnum<3) {
	    				bnum=bnum+2;
	    			} else if(bnum>=3 && bnum<=4) {
	    				bnum=bnum-2;
	    			}	
	    		}
	    		
	    		if(order) { 			
	    			c.setBandNum(bnum);
	    			//System.out.println(bnum);
	    		} else {
	    			c.setBandNum(thisCat.size()+1-bnum);
	    			//System.out.println((thisCat.size()+1-bnum)+"");
	    		}
	    	}
	    	//reverse order
	    	order = !order;
	    	advIndx++;
	    }
	    
	    band1Model.clear();
	    band2Model.clear();
	    band3Model.clear();
	    band4Model.clear();
	    band5Model.clear();
	    band6Model.clear();
	    band7Model.clear();
	    band8Model.clear();
	    
	    for(Camper c:allAcceptCampers) {			
			int bandnum = c.getBandNum();
			switch (bandnum) {
            case 1:  band1Model.addElement(new BandItem(c.getFirstname(), c.getLastname(), c.getGender(), c.getId(), c.getCategory(), c.getTalentLevel()));
                     break;
            case 2:  band2Model.addElement(new BandItem(c.getFirstname(), c.getLastname(), c.getGender(), c.getId(), c.getCategory(), c.getTalentLevel()));
                     break;
            case 3:  band3Model.addElement(new BandItem(c.getFirstname(), c.getLastname(), c.getGender(), c.getId(), c.getCategory(), c.getTalentLevel()));
                     break;
            case 4:  band4Model.addElement(new BandItem(c.getFirstname(), c.getLastname(), c.getGender(), c.getId(), c.getCategory(), c.getTalentLevel()));
                     break;
            case 5:  band5Model.addElement(new BandItem(c.getFirstname(), c.getLastname(), c.getGender(), c.getId(), c.getCategory(), c.getTalentLevel()));
                     break;
            case 6:  band6Model.addElement(new BandItem(c.getFirstname(), c.getLastname(), c.getGender(), c.getId(), c.getCategory(), c.getTalentLevel()));
                     break;
            case 7:  band7Model.addElement(new BandItem(c.getFirstname(), c.getLastname(), c.getGender(), c.getId(), c.getCategory(), c.getTalentLevel()));
                     break;
            case 8:  band8Model.addElement(new BandItem(c.getFirstname(), c.getLastname(), c.getGender(), c.getId(), c.getCategory(), c.getTalentLevel()));
                     break;
			}
	    } 
	}
	
	
	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmSmartFursCamper = new JFrame();
		frmSmartFursCamper.setResizable(false);
		frmSmartFursCamper.setType(Type.UTILITY);
		frmSmartFursCamper.getContentPane().setFont(new Font("Calibri", Font.PLAIN, 14));
		frmSmartFursCamper.getContentPane().setBackground(new Color(255, 255, 255));
		frmSmartFursCamper.getContentPane().setForeground(Color.BLACK);
		frmSmartFursCamper.setForeground(SystemColor.menu);
		frmSmartFursCamper.setBounds(100, 100, 1091, 606);
		frmSmartFursCamper.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmSmartFursCamper.getContentPane().setLayout(null);
		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
		frmSmartFursCamper.setLocation(dim.width/2-frmSmartFursCamper.getSize().width/2, dim.height/2-frmSmartFursCamper.getSize().height/2);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setFont(new Font("Calibri", Font.PLAIN, 18));
		tabbedPane.setForeground(new Color(0, 0, 0));
		tabbedPane.setBackground(new Color(255, 255, 255));
		tabbedPane.setBounds(10, 67, 1074, 507);
		frmSmartFursCamper.getContentPane().add(tabbedPane);
		
		applicationPanel = new JPanel();
		applicationPanel.setBackground(new Color(255, 255, 255));
		tabbedPane.addTab("Applications", (Icon) null, applicationPanel, null);
		applicationPanel.setLayout(null);
		
		btnAdd = new JButton("Add");
		btnAdd.setForeground(new Color(0, 0, 0));
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
		firstnameTextField.setBackground(new Color(255, 255, 255));
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
		lastnameTextField.setBackground(new Color(255, 255, 255));
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
		dobTextField.setBackground(new Color(255, 255, 255));
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
		applicationScrollPane.setBounds(345, 11, 714, 448);
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
	    recvdayTextField.setBackground(new Color(255, 255, 255));
	    recvdayTextField.setBounds(121, 59, 156, 29);
	    applicationPanel.add(recvdayTextField);
	    
	    instrumentTextField = new JTextField();
	    instrumentTextField.setToolTipText("");
	    instrumentTextField.setFont(new Font("Calibri", Font.PLAIN, 16));
	    instrumentTextField.setColumns(10);
	    instrumentTextField.setBackground(new Color(255, 255, 255));
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
	    btnCancel.setForeground(new Color(0, 0, 0));
	    btnCancel.setFont(new Font("Calibri", Font.PLAIN, 16));
	    btnCancel.setBackground(SystemColor.menu);
	    btnCancel.setBounds(222, 410, 79, 41);
	    btnCancel.setVisible(false);
	    applicationPanel.add(btnCancel);
		
		mailingPanel = new JPanel();
		mailingPanel.setBackground(new Color(255, 255, 255));
		tabbedPane.addTab("Mailing Notification", null, mailingPanel, null);
		mailingPanel.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(371, 79, 688, 380);
		mailingPanel.add(scrollPane);
		
		mailingTable = new JTable();
		mailingTable.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
					"Id", "Status", "FName", "LName", "Age", "Gender", "Instrument", "Category", "Talnt", "Esy", "Rec", "Dps"
			}
		));
		mailingTable.setFont(new Font("Calibri", Font.PLAIN, 16));
		scrollPane.setViewportView(mailingTable);
		mailingTable.setRowHeight(21);
		mailingTable.getColumnModel().getColumn(0).setPreferredWidth(15);
		mailingTable.getColumnModel().getColumn(1).setPreferredWidth(40);
		mailingTable.getColumnModel().getColumn(2).setPreferredWidth(60);
		mailingTable.getColumnModel().getColumn(3).setPreferredWidth(60);
		mailingTable.getColumnModel().getColumn(4).setPreferredWidth(20);
		mailingTable.getColumnModel().getColumn(5).setPreferredWidth(40);
		mailingTable.getColumnModel().getColumn(6).setPreferredWidth(80);
		mailingTable.getColumnModel().getColumn(7).setPreferredWidth(100);
		mailingTable.getColumnModel().getColumn(8).setPreferredWidth(30);
		mailingTable.getColumnModel().getColumn(9).setPreferredWidth(30);
		mailingTable.getColumnModel().getColumn(10).setPreferredWidth(30);
		mailingTable.getColumnModel().getColumn(11).setPreferredWidth(30);
		ListSelectionModel selMailingModel = mailingTable.getSelectionModel(); 
		selMailingModel.addListSelectionListener(new ListSelectionListener(){
	        @Override
			public void valueChanged(ListSelectionEvent event) {
	            if(!selMailingModel.isSelectionEmpty()) {populateMailingFields();}
	        }
	    });
		
		
		btnGenerateMail = new JButton("Generate Mail");
		btnGenerateMail.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				openWordMailTemplate();
			}
		});
		btnGenerateMail.setForeground(Color.BLACK);
		btnGenerateMail.setFont(new Font("Calibri", Font.PLAIN, 18));
		btnGenerateMail.setBackground(SystemColor.menu);
		btnGenerateMail.setBounds(103, 416, 158, 43);
		mailingPanel.add(btnGenerateMail);
		
		lblNewLabel = new JLabel("Please Select the Decision for");
		lblNewLabel.setFont(new Font("Calibri", Font.PLAIN, 16));
		lblNewLabel.setBounds(16, 12, 202, 32);
		mailingPanel.add(lblNewLabel);
		
		lblMailingFname = new JLabel("");
		lblMailingFname.setFont(new Font("Calibri", Font.BOLD, 16));
		lblMailingFname.setBounds(214, 12, 146, 32);
		mailingPanel.add(lblMailingFname);
		
		JLabel lblDecision = new JLabel("Decision:");
		lblDecision.setFont(new Font("Calibri", Font.PLAIN, 16));
		lblDecision.setBackground(Color.WHITE);
		lblDecision.setBounds(16, 48, 90, 29);
		mailingPanel.add(lblDecision);
		
		dropdownCategory = new JComboBox<String>();
		dropdownCategory.setEnabled(false);
		dropdownCategory.setModel(new DefaultComboBoxModel(new String[] {"Not Assigned", "Singer", "Guitarist", "Drummer", "Bassist", "Keyboardist", "Instrumentalist"}));
		dropdownCategory.setFont(new Font("Calibri", Font.PLAIN, 16));
		dropdownCategory.setBackground(Color.WHITE);
		dropdownCategory.setBounds(127, 86, 180, 29);
		mailingPanel.add(dropdownCategory);
		
		JLabel lblCategory = new JLabel("Category:");
		lblCategory.setFont(new Font("Calibri", Font.PLAIN, 16));
		lblCategory.setBackground(Color.WHITE);
		lblCategory.setBounds(16, 86, 90, 29);
		mailingPanel.add(lblCategory);
		
		btnMailingSave = new JButton("Save");
		btnMailingSave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				saveCamperStatus();
			}
		});
		btnMailingSave.setForeground(Color.BLACK);
		btnMailingSave.setFont(new Font("Calibri", Font.PLAIN, 18));
		btnMailingSave.setBackground(SystemColor.menu);
		btnMailingSave.setBounds(16, 416, 77, 43);
		mailingPanel.add(btnMailingSave);
		
		JLabel lblSkillLevel = new JLabel("Talent Level:");
		lblSkillLevel.setFont(new Font("Calibri", Font.PLAIN, 16));
		lblSkillLevel.setBackground(Color.WHITE);
		lblSkillLevel.setBounds(16, 126, 90, 29);
		mailingPanel.add(lblSkillLevel);
		
		spinnerTelentLvl = new JSpinner();
		spinnerTelentLvl.setFont(new Font("Calibri", Font.PLAIN, 16));
		spinnerTelentLvl.setModel(new SpinnerNumberModel(0, 0, 10, 1));
		spinnerTelentLvl.setBounds(127, 126, 65, 29);
		mailingPanel.add(spinnerTelentLvl);
		
		JLabel lblNewLabel_1 = new JLabel("Accepted Grils:");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_1.setFont(new Font("Calibri", Font.PLAIN, 16));
		lblNewLabel_1.setBounds(684, 12, 120, 23);
		mailingPanel.add(lblNewLabel_1);
		
		labelMailingTotalGril = new JLabel("0/24");
		labelMailingTotalGril.setFont(new Font("Calibri", Font.BOLD, 16));
		labelMailingTotalGril.setBounds(814, 12, 65, 23);
		mailingPanel.add(labelMailingTotalGril);
		
		JLabel lblAcceptedBoys = new JLabel("Accepted Boys:");
		lblAcceptedBoys.setHorizontalAlignment(SwingConstants.RIGHT);
		lblAcceptedBoys.setFont(new Font("Calibri", Font.PLAIN, 16));
		lblAcceptedBoys.setBounds(869, 12, 115, 23);
		mailingPanel.add(lblAcceptedBoys);
		
		labelMailingTotalBoy = new JLabel("0/24");
		labelMailingTotalBoy.setFont(new Font("Calibri", Font.BOLD, 16));
		labelMailingTotalBoy.setBounds(994, 12, 65, 23);
		mailingPanel.add(labelMailingTotalBoy);
		
		JPanel panel_14 = new JPanel();
		panel_14.setBorder(new TitledBorder(null, "Mail Content", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_14.setBounds(15, 166, 346, 239);
		mailingPanel.add(panel_14);
		panel_14.setLayout(null);
		
		txtpnMail = new JTextPane();
		txtpnMail.setText("");
		txtpnMail.setBounds(6, 16, 330, 212);
		panel_14.add(txtpnMail);
		txtpnMail.setFont(new Font("Calibri", Font.PLAIN, 14));
		
		statusDropdown = new JComboBox<String>();
		statusDropdown.setEnabled(false);
		statusDropdown.setModel(new DefaultComboBoxModel(new String[] {"Undecided", "Accept", "Deny"}));
		statusDropdown.setFont(new Font("Calibri", Font.PLAIN, 16));
		statusDropdown.setBackground(Color.WHITE);
		statusDropdown.setBounds(127, 50, 180, 29);
		statusDropdown.addActionListener (new ActionListener () {
		    public void actionPerformed(ActionEvent e) {
		        mailingStatusChange();
		    }
		});
		
		mailingPanel.add(statusDropdown);
		
		btnMailingCancel = new JButton("Cancel");
		btnMailingCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				clearMailingFields(false);
			}
		});
		btnMailingCancel.setForeground(Color.BLACK);
		btnMailingCancel.setFont(new Font("Calibri", Font.PLAIN, 18));
		btnMailingCancel.setBackground(SystemColor.menu);
		btnMailingCancel.setBounds(271, 416, 90, 43);
		mailingPanel.add(btnMailingCancel);
		
		lblCategoryboygirl = new JLabel("(Category: Boy/Girl)");
		lblCategoryboygirl.setHorizontalAlignment(SwingConstants.LEFT);
		lblCategoryboygirl.setFont(new Font("Calibri", Font.ITALIC, 16));
		lblCategoryboygirl.setBounds(371, 11, 165, 23);
		mailingPanel.add(lblCategoryboygirl);
		
		labelGuitaristNum = new JLabel("Guitarist: 0/0");
		labelGuitaristNum.setHorizontalAlignment(SwingConstants.LEFT);
		labelGuitaristNum.setFont(new Font("Calibri", Font.PLAIN, 16));
		labelGuitaristNum.setBounds(457, 48, 99, 23);
		mailingPanel.add(labelGuitaristNum);
		
		lblDrummerNum = new JLabel("Drummer: 0/0");
		lblDrummerNum.setHorizontalAlignment(SwingConstants.LEFT);
		lblDrummerNum.setFont(new Font("Calibri", Font.PLAIN, 16));
		lblDrummerNum.setBounds(554, 48, 99, 23);
		mailingPanel.add(lblDrummerNum);
		
		lblBassistNum = new JLabel("Bassist: 0/0");
		lblBassistNum.setHorizontalAlignment(SwingConstants.LEFT);
		lblBassistNum.setFont(new Font("Calibri", Font.PLAIN, 16));
		lblBassistNum.setBounds(654, 48, 90, 23);
		mailingPanel.add(lblBassistNum);
		
		lblKeyboardistNum = new JLabel("Keyboardist: 0/0");
		lblKeyboardistNum.setHorizontalAlignment(SwingConstants.LEFT);
		lblKeyboardistNum.setFont(new Font("Calibri", Font.PLAIN, 16));
		lblKeyboardistNum.setBounds(751, 48, 120, 23);
		mailingPanel.add(lblKeyboardistNum);
		
		lblInstrumentalistNum = new JLabel("Instrumentalist: 0/0");
		lblInstrumentalistNum.setHorizontalAlignment(SwingConstants.LEFT);
		lblInstrumentalistNum.setFont(new Font("Calibri", Font.PLAIN, 16));
		lblInstrumentalistNum.setBounds(879, 48, 152, 23);
		mailingPanel.add(lblInstrumentalistNum);
		
		labelSingerNum = new JLabel("Singer: 0/0");
		labelSingerNum.setHorizontalAlignment(SwingConstants.LEFT);
		labelSingerNum.setFont(new Font("Calibri", Font.PLAIN, 16));
		labelSingerNum.setBounds(371, 48, 90, 23);
		mailingPanel.add(labelSingerNum);
		
		checkinPanel = new JPanel();
		checkinPanel.setBackground(SystemColor.window);
		tabbedPane.addTab("Camper Checkin", null, checkinPanel, null);
		checkinPanel.setLayout(null);
		
		JLabel lblName = new JLabel("Name");
		lblName.setFont(new Font("Calibri", Font.PLAIN, 16));
		lblName.setBounds(10, 57, 61, 16);
		checkinPanel.add(lblName);
		
		JLabel lblCheckinInformation = new JLabel("Checkin Information");
		lblCheckinInformation.setFont(new Font("Calibri", Font.PLAIN, 16));
		lblCheckinInformation.setBounds(10, 84, 157, 16);
		checkinPanel.add(lblCheckinInformation);
		
		JCheckBox chckbx_arrivalpack = new JCheckBox("Arrival Packet");
		chckbx_arrivalpack.setBackground(Color.WHITE);
		chckbx_arrivalpack.setFont(new Font("Calibri", Font.PLAIN, 16));
		chckbx_arrivalpack.setBounds(6, 107, 128, 23);
		checkinPanel.add(chckbx_arrivalpack);
		
		JCheckBox chckbxMusicalInstrument = new JCheckBox("Musical Instrument");
		chckbxMusicalInstrument.setBackground(Color.WHITE);
		chckbxMusicalInstrument.setFont(new Font("Calibri", Font.PLAIN, 16));
		chckbxMusicalInstrument.setBounds(6, 133, 170, 23);
		checkinPanel.add(chckbxMusicalInstrument);
		
		JCheckBox chckbxEquipmentSupplies = new JCheckBox("Equipment Supplies");
		chckbxEquipmentSupplies.setBackground(Color.WHITE);
		chckbxEquipmentSupplies.setFont(new Font("Calibri", Font.PLAIN, 16));
		chckbxEquipmentSupplies.setBounds(6, 159, 170, 23);
		checkinPanel.add(chckbxEquipmentSupplies);
		
		JLabel lblCloth = new JLabel("Cloth");
		lblCloth.setFont(new Font("Calibri", Font.PLAIN, 16));
		lblCloth.setBounds(10, 196, 61, 16);
		checkinPanel.add(lblCloth);
		
		JCheckBox chckbxLeather = new JCheckBox("Leather");
		chckbxLeather.setBackground(Color.WHITE);
		chckbxLeather.setFont(new Font("Calibri", Font.PLAIN, 16));
		chckbxLeather.setBounds(10, 222, 92, 23);
		checkinPanel.add(chckbxLeather);
		
		JCheckBox chckbxSpandex = new JCheckBox("Spandex");
		chckbxSpandex.setBackground(Color.WHITE);
		chckbxSpandex.setFont(new Font("Calibri", Font.PLAIN, 16));
		chckbxSpandex.setBounds(104, 222, 96, 23);
		checkinPanel.add(chckbxSpandex);
		
		JCheckBox chckbxGlittered = new JCheckBox("Glittered");
		chckbxGlittered.setBackground(Color.WHITE);
		chckbxGlittered.setFont(new Font("Calibri", Font.PLAIN, 16));
		chckbxGlittered.setBounds(202, 222, 109, 23);
		checkinPanel.add(chckbxGlittered);
		
		JLabel lblSoecialRequest = new JLabel("Special Request");
		lblSoecialRequest.setFont(new Font("Calibri", Font.PLAIN, 16));
		lblSoecialRequest.setBounds(10, 260, 128, 16);
		checkinPanel.add(lblSoecialRequest);
		
		JCheckBox chckbxSameBand = new JCheckBox("Same Band");
		chckbxSameBand.setBackground(Color.WHITE);
		chckbxSameBand.setFont(new Font("Calibri", Font.PLAIN, 16));
		chckbxSameBand.setBounds(10, 283, 117, 23);
		checkinPanel.add(chckbxSameBand);
		
		JCheckBox chckbxSameDorm = new JCheckBox("Same Dorm");
		chckbxSameDorm.setBackground(Color.WHITE);
		chckbxSameDorm.setFont(new Font("Calibri", Font.PLAIN, 16));
		chckbxSameDorm.setBounds(10, 323, 109, 23);
		checkinPanel.add(chckbxSameDorm);
		
		JButton btnSave_2 = new JButton("Save");
		btnSave_2.setBackground(SystemColor.control);
		btnSave_2.setFont(new Font("Calibri", Font.PLAIN, 16));
		btnSave_2.setBounds(10, 430, 117, 29);
		checkinPanel.add(btnSave_2);
		
		JButton btnCancel_1 = new JButton("Cancel");
		btnCancel_1.setBackground(SystemColor.control);
		btnCancel_1.setFont(new Font("Calibri", Font.PLAIN, 16));
		btnCancel_1.setBounds(185, 430, 117, 29);
		checkinPanel.add(btnCancel_1);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		
		scrollPane_1.setBounds(317, 12, 742, 447);
		checkinPanel.add(scrollPane_1);
		
		tableCheckin = new JTable();
		
		tableCheckin.setModel(new DefaultTableModel(
				new Object[][] {
				},
				new String[] {
						"Id", "FName", "LName", "HasArvalPak", "HasIstrmt", "HasSply", "LeatherCloth", "SpdxCloth", "GlitterCloth", "CheckedIn"
				}
			));
		tableCheckin.setFont(new Font("Calibri", Font.PLAIN, 16));
		tableCheckin.getColumnModel().getColumn(0).setPreferredWidth(20);
		tableCheckin.getColumnModel().getColumn(1).setPreferredWidth(80);
		tableCheckin.getColumnModel().getColumn(2).setPreferredWidth(80);
		tableCheckin.getColumnModel().getColumn(3).setPreferredWidth(50);
		tableCheckin.getColumnModel().getColumn(4).setPreferredWidth(40);
		tableCheckin.getColumnModel().getColumn(5).setPreferredWidth(30);
		tableCheckin.getColumnModel().getColumn(6).setPreferredWidth(50);
		tableCheckin.getColumnModel().getColumn(7).setPreferredWidth(40);
		tableCheckin.getColumnModel().getColumn(8).setPreferredWidth(40);
		tableCheckin.getColumnModel().getColumn(9).setPreferredWidth(40);
		tableCheckin.setRowHeight(21);
		scrollPane_1.setViewportView(tableCheckin);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(139, 284, 157, 20);
		checkinPanel.add(comboBox);
		
		JComboBox comboBox_1 = new JComboBox();
		comboBox_1.setBounds(139, 324, 157, 20);
		checkinPanel.add(comboBox_1);
		
		JCheckBox chckbxCheckInCamper = new JCheckBox("Check in Camper");
		chckbxCheckInCamper.setFont(new Font("Calibri", Font.PLAIN, 18));
		chckbxCheckInCamper.setBackground(Color.WHITE);
		chckbxCheckInCamper.setBounds(10, 386, 217, 23);
		checkinPanel.add(chckbxCheckInCamper);
		
		dormAsnPanel = new JPanel();
		dormAsnPanel.setBackground(SystemColor.window);
		tabbedPane.addTab("Dorm Assignment", null, dormAsnPanel, null);
		dormAsnPanel.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(null, "Grils Dorm #1", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel.setBounds(20, 17, 207, 203);
		dormAsnPanel.add(panel);
		panel.setLayout(null);
		
		listGirlDorm1 = new JList<DormItem>(girlDorm1Model);
		listGirlDorm1.setFont(new Font("Calibri", Font.PLAIN, 14));
		listGirlDorm1.setBounds(6, 16, 191, 176);
		listGirlDorm1.setCellRenderer(new DormItemCellRenderer());
		panel.add(listGirlDorm1);
		
		JPanel panel_1 = new JPanel();
		panel_1.setLayout(null);
		panel_1.setBorder(new TitledBorder(null, "Grils Dorm #2", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_1.setBounds(248, 17, 207, 203);
		dormAsnPanel.add(panel_1);
		
		listGirlDorm2 = new JList<DormItem>(girlDorm2Model);
		listGirlDorm2.setFont(new Font("Calibri", Font.PLAIN, 14));
		listGirlDorm2.setBounds(6, 16, 191, 176);
		listGirlDorm2.setCellRenderer(new DormItemCellRenderer());
		panel_1.add(listGirlDorm2);
		
		JPanel panel_2 = new JPanel();
		panel_2.setLayout(null);
		panel_2.setBorder(new TitledBorder(null, "Grils Dorm #3", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_2.setBounds(478, 17, 207, 203);
		dormAsnPanel.add(panel_2);
		
		listGirlDorm3 = new JList<DormItem>(girlDorm3Model);
		listGirlDorm3.setFont(new Font("Calibri", Font.PLAIN, 14));
		listGirlDorm3.setBounds(6, 16, 191, 176);
		listGirlDorm3.setCellRenderer(new DormItemCellRenderer());
		panel_2.add(listGirlDorm3);
		
		JPanel panel_3 = new JPanel();
		panel_3.setLayout(null);
		panel_3.setBorder(new TitledBorder(null, "Boys Dorm #1", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_3.setBounds(20, 238, 207, 203);
		dormAsnPanel.add(panel_3);
		
		listBoyDorm1 = new JList<DormItem>(boyDorm1Model);
		listBoyDorm1.setFont(new Font("Calibri", Font.PLAIN, 14));
		listBoyDorm1.setBounds(6, 16, 191, 176);
		listBoyDorm1.setCellRenderer(new DormItemCellRenderer());
		panel_3.add(listBoyDorm1);
		
		JPanel panel_4 = new JPanel();
		panel_4.setLayout(null);
		panel_4.setBorder(new TitledBorder(null, "Boys Dorm #2", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_4.setBounds(248, 238, 207, 203);
		dormAsnPanel.add(panel_4);
		
		listBoyDorm2 = new JList<DormItem>(boyDorm2Model);
		listBoyDorm2.setFont(new Font("Calibri", Font.PLAIN, 14));
		listBoyDorm2.setBounds(6, 16, 191, 176);
		listBoyDorm2.setCellRenderer(new DormItemCellRenderer());
		panel_4.add(listBoyDorm2);
		
		JPanel panel_5 = new JPanel();
		panel_5.setLayout(null);
		panel_5.setBorder(new TitledBorder(null, "Boys Dorm #3", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_5.setBounds(478, 238, 207, 203);
		dormAsnPanel.add(panel_5);
		
		listBoyDorm3 = new JList<DormItem>(boyDorm3Model);
		listBoyDorm3.setFont(new Font("Calibri", Font.PLAIN, 14));
		listBoyDorm3.setBounds(6, 16, 191, 176);
		listBoyDorm3.setCellRenderer(new DormItemCellRenderer());
		panel_5.add(listBoyDorm3);
		
		btnAutoAssignDorm = new JButton("Auto Dorm Assign");
		btnAutoAssignDorm.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				autoAssnDorm();
			}
		});
		btnAutoAssignDorm.setForeground(Color.BLACK);
		btnAutoAssignDorm.setFont(new Font("Calibri", Font.PLAIN, 18));
		btnAutoAssignDorm.setBackground(SystemColor.menu);
		btnAutoAssignDorm.setBounds(714, 17, 191, 43);
		dormAsnPanel.add(btnAutoAssignDorm);
		
		JLabel lblRequestSwitchDorm = new JLabel("Dorm Switch Request");
		lblRequestSwitchDorm.setFont(new Font("Calibri", Font.PLAIN, 16));
		lblRequestSwitchDorm.setBounds(714, 322, 168, 32);
		dormAsnPanel.add(lblRequestSwitchDorm);
		
		camperDropdownSwaper1 = new JComboBox<DormItem>(dormSwaper1Model);
		camperDropdownSwaper1.setEnabled(true);
		camperDropdownSwaper1.setFont(new Font("Calibri", Font.PLAIN, 16));
		camperDropdownSwaper1.setBackground(Color.WHITE);
		camperDropdownSwaper1.setBounds(714, 365, 191, 29);
		//camperDropdownSwaper1.setRenderer(new SwaperComboItem());
		dormAsnPanel.add(camperDropdownSwaper1);
		
		camperDropdownSwaper2 = new JComboBox<DormItem>(dormSwaper2Model);
		camperDropdownSwaper2.setFont(new Font("Calibri", Font.PLAIN, 16));
		camperDropdownSwaper2.setEnabled(true);
		camperDropdownSwaper2.setBackground(Color.WHITE);
		camperDropdownSwaper2.setBounds(714, 412, 191, 29);
		//camperDropdownSwaper2.setRenderer(new SwaperComboItem());
		dormAsnPanel.add(camperDropdownSwaper2);
		
		btnRequest = new JButton("Request");
		btnRequest.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				swapCampersDormRequest();
			}
		});
		btnRequest.setForeground(Color.BLACK);
		btnRequest.setFont(new Font("Calibri", Font.PLAIN, 18));
		btnRequest.setBackground(SystemColor.menu);
		btnRequest.setBounds(928, 398, 119, 43);
		dormAsnPanel.add(btnRequest);
		
		bandAsnPanel = new JPanel();
		bandAsnPanel.setBackground(SystemColor.window);
		tabbedPane.addTab("Band Assignment", null, bandAsnPanel, null);
		bandAsnPanel.setLayout(null);
		
		JPanel panel_6 = new JPanel();
		panel_6.setLayout(null);
		panel_6.setBorder(new TitledBorder(null, "Band #1", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_6.setBounds(25, 22, 236, 144);
		bandAsnPanel.add(panel_6);
		
		listBand1 = new JList<BandItem>(band1Model);
		listBand1.setFont(new Font("Calibri", Font.PLAIN, 12));
		listBand1.setCellRenderer(new BandItemCellRenderer());
		listBand1.setBounds(6, 16, 224, 120);
		panel_6.add(listBand1);
		
		JPanel panel_7 = new JPanel();
		panel_7.setLayout(null);
		panel_7.setBorder(new TitledBorder(null, "Band #2", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_7.setBounds(286, 22, 236, 144);
		bandAsnPanel.add(panel_7);
		
		listBand2 = new JList<BandItem>(band2Model);
		listBand2.setFont(new Font("Calibri", Font.PLAIN, 12));
		listBand2.setCellRenderer(new BandItemCellRenderer());
		listBand2.setBounds(6, 16, 224, 120);
		panel_7.add(listBand2);
		
		JPanel panel_8 = new JPanel();
		panel_8.setLayout(null);
		panel_8.setBorder(new TitledBorder(null, "Band #3", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_8.setBounds(547, 22, 236, 144);
		bandAsnPanel.add(panel_8);
		
		listBand3 = new JList<BandItem>(band3Model);
		listBand3.setFont(new Font("Calibri", Font.PLAIN, 12));
		listBand3.setCellRenderer(new BandItemCellRenderer());
		listBand3.setBounds(6, 16, 224, 120);
		panel_8.add(listBand3);
		
		JPanel panel_9 = new JPanel();
		panel_9.setLayout(null);
		panel_9.setBorder(new TitledBorder(null, "Band #5", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_9.setBounds(25, 190, 236, 144);
		bandAsnPanel.add(panel_9);
		
		listBand5 = new JList<BandItem>(band5Model);
		listBand5.setFont(new Font("Calibri", Font.PLAIN, 12));
		listBand5.setCellRenderer(new BandItemCellRenderer());
		listBand5.setBounds(6, 16, 224, 120);
		panel_9.add(listBand5);
		
		JPanel panel_10 = new JPanel();
		panel_10.setLayout(null);
		panel_10.setBorder(new TitledBorder(null, "Band #6", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_10.setBounds(286, 190, 236, 144);
		bandAsnPanel.add(panel_10);
		
		listBand6 = new JList<BandItem>(band6Model);
		listBand6.setFont(new Font("Calibri", Font.PLAIN, 12));
		listBand6.setCellRenderer(new BandItemCellRenderer());
		listBand6.setBounds(6, 16, 224, 120);
		panel_10.add(listBand6);
		
		JPanel panel_11 = new JPanel();
		panel_11.setLayout(null);
		panel_11.setBorder(new TitledBorder(null, "Band #7", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_11.setBounds(547, 190, 236, 144);
		bandAsnPanel.add(panel_11);
		
		listBand7 = new JList<BandItem>(band7Model);
		listBand7.setFont(new Font("Calibri", Font.PLAIN, 12));
		listBand7.setCellRenderer(new BandItemCellRenderer());
		listBand7.setBounds(6, 16, 224, 120);
		panel_11.add(listBand7);
		
		JPanel panel_12 = new JPanel();
		panel_12.setLayout(null);
		panel_12.setBorder(new TitledBorder(null, "Band #4", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_12.setBounds(808, 22, 236, 144);
		bandAsnPanel.add(panel_12);
		
		listBand4 = new JList<BandItem>(band4Model);
		listBand4.setFont(new Font("Calibri", Font.PLAIN, 12));
		listBand4.setCellRenderer(new BandItemCellRenderer());
		listBand4.setBounds(6, 16, 224, 120);
		panel_12.add(listBand4);
		
		JPanel panel_13 = new JPanel();
		panel_13.setLayout(null);
		panel_13.setBorder(new TitledBorder(null, "Band #8", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_13.setBounds(808, 190, 236, 144);
		bandAsnPanel.add(panel_13);
		
		listBand8 = new JList<BandItem>(band8Model);
		listBand8.setFont(new Font("Calibri", Font.PLAIN, 12));
		listBand8.setCellRenderer(new BandItemCellRenderer());
		listBand8.setBounds(6, 16, 224, 120);
		panel_13.add(listBand8);
		
		JButton btnAutoAssignBand = new JButton("Auto Assign");
		btnAutoAssignBand.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				autoAssnBand();
			}
		});
		btnAutoAssignBand.setForeground(Color.BLACK);
		btnAutoAssignBand.setFont(new Font("Calibri", Font.PLAIN, 18));
		btnAutoAssignBand.setBackground(SystemColor.menu);
		btnAutoAssignBand.setBounds(884, 403, 160, 43);
		bandAsnPanel.add(btnAutoAssignBand);
		
		JLabel lblSwitchBand = new JLabel("Switch Band");
		lblSwitchBand.setFont(new Font("Calibri", Font.PLAIN, 16));
		lblSwitchBand.setBounds(34, 369, 100, 32);
		bandAsnPanel.add(lblSwitchBand);
		
		JComboBox<String> comboBox_2 = new JComboBox<String>();
		comboBox_2.setFont(new Font("Calibri", Font.PLAIN, 16));
		comboBox_2.setEnabled(false);
		comboBox_2.setBackground(Color.WHITE);
		comboBox_2.setBounds(149, 371, 191, 29);
		bandAsnPanel.add(comboBox_2);
		
		JComboBox<String> comboBox_3 = new JComboBox<String>();
		comboBox_3.setFont(new Font("Calibri", Font.PLAIN, 16));
		comboBox_3.setEnabled(false);
		comboBox_3.setBackground(Color.WHITE);
		comboBox_3.setBounds(149, 411, 191, 29);
		bandAsnPanel.add(comboBox_3);
		
		JButton button_1 = new JButton("Request");
		button_1.setForeground(Color.BLACK);
		button_1.setFont(new Font("Calibri", Font.PLAIN, 18));
		button_1.setBackground(SystemColor.menu);
		button_1.setBounds(363, 403, 119, 43);
		bandAsnPanel.add(button_1);
				
		welcomeLabel = new JLabel("Welcome, "+appUser);
		welcomeLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		welcomeLabel.setFont(new Font("Calibri", Font.BOLD, 18));
		welcomeLabel.setBounds(707, 31, 130, 20);
		
		frmSmartFursCamper.getContentPane().add(welcomeLabel);
		
		campDateDropdown = new JComboBox<String>();
		campDateDropdown.setBackground(Color.WHITE);
		campDateDropdown.setModel(new DefaultComboBoxModel<String>(new String[] {"2017 Jun", "2017 July", "2017 Augest"}));
		campDateDropdown.setFont(new Font("Calibri", Font.PLAIN, 18));
		campDateDropdown.setBounds(952, 27, 123, 29);
		campDateDropdown.setSelectedIndex(2);
		frmSmartFursCamper.getContentPane().add(campDateDropdown);
		
		JLabel topImgLabel = new JLabel("");
		topImgLabel.setBounds(10, 7, 282, 49);
		frmSmartFursCamper.getContentPane().add(topImgLabel);
		Image img = new ImageIcon(this.getClass().getResource("../toplogo.png")).getImage();
		topImgLabel.setIcon(new ImageIcon(img));
		
		JLabel lblSetCamp = new JLabel("Set Camp:");
		lblSetCamp.setHorizontalAlignment(SwingConstants.RIGHT);
		lblSetCamp.setFont(new Font("Calibri", Font.PLAIN, 18));
		lblSetCamp.setBounds(847, 31, 88, 20);
		frmSmartFursCamper.getContentPane().add(lblSetCamp);
		
		JLabel lblCampersManagementSystem = new JLabel("Campers Management System");
		lblCampersManagementSystem.setForeground(Color.DARK_GRAY);
		lblCampersManagementSystem.setHorizontalAlignment(SwingConstants.CENTER);
		lblCampersManagementSystem.setFont(new Font("Segoe UI", Font.BOLD, 20));
		lblCampersManagementSystem.setBounds(280, 16, 312, 40);
		frmSmartFursCamper.getContentPane().add(lblCampersManagementSystem);
		
		reloadApplicationTable();
		reloadMailingCampersTable();
		reloadCheckinTable();
		clearMailingFields(true);
		//FOR US #4
		loadDormSwapDropdowns();
	}
}
