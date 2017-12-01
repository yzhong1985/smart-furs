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
import java.util.Collections;
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

	//## Defines main UI components 
	private JFrame main_Frame;
	private JTabbedPane main_TabPane;
	private JLabel main_WelcomeLabel;
	private JLabel main_TopImageLabel;
	private JLabel main_MainTitleLabel;
	private JLabel main_SetCampLabel;
	private JComboBox<String> main_CampDateDropdown;
	
	//## Defines five panels
	private JPanel ap_MainPanel;
	private JPanel mn_MainPanel;
	private JPanel ci_MainPanel;
	private JPanel da_MainPanel;
	private JPanel bd_MainPanel;
	private JPanel bd2_MainPanel;
	
	//########################################################
	//## US1 components on Application Panel prefix - 'ap'
	//########################################################
	private JScrollPane ap_ScrollPane;
	private JRadioButton ap_BoyRadioButton;
	private JRadioButton ap_GirlRadioButton;
	private JButton ap_AddButton;
	private JButton ap_SaveButton;
	private JButton ap_CancelButton;
	private JButton ap_DeleteButton;
	private ButtonGroup ap_GenderBtnGroup;
	private JLabel ap_RecivedOnLabel;
	private JLabel ap_LastnameLabel;
	private JLabel ap_FirstnameLabel;
	private JLabel ap_InstrumentLabel;
	private JLabel ap_IdLabel;
	private JLabel ap_DateOfBirthLabel;
	private JLabel ap_GenderLabel;
	private JTextField ap_RecivedOnTextField;
	private JTextField ap_InstrumentTextField;
	private JTextField ap_FirstnameTextField;
	private JTextField ap_LastnameTextField;
	private JTextField ap_DateOfBirthTextField;
	private JCheckBox ap_HasEssayCheckBox;
	private JCheckBox ap_HasRecordingCheckBox;
	private JCheckBox ap_HasPaymentCheckBox;
	private JTable ap_applicationTable;
	
	//########################################################
	//## US2 components on Mailing Notification Panel prefix - 'mn'
	//########################################################
	private JScrollPane mn_ScrollPane;	
    private JPanel mn_MailTextPanePanel;
	private JButton mn_CancelButton;
	private JButton mn_GenerateMailButton;
	private JButton mn_SaveButton;
	private JLabel mn_AcceptGirlLabel;
	private JLabel mn_AcceptBoysLabel;
	private JLabel mn_FullnameLabel;
	private JLabel mn_DecisionLabel;
	private JLabel mn_CategoryLabel;
	private JLabel mn_SkillLevelLabel;
	private JLabel mn_SelectDecisionLabel;
	private JLabel mn_InstrumentalistNumLabel;
	private JLabel mn_CategoryBGLabel;
	private JLabel mn_TotalBoyLabel;
	private JLabel mn_TotalGirlLabel;
	private JLabel mn_SingerNumLabel;
	private JLabel mn_KeyboardistNumLabel;
	private JLabel mn_BassistNumLabel;
	private JLabel mn_DrummerNumLabel;
	private JLabel mn_GuitaristNumLabel;
	private JSpinner mn_TelentLevelSpinner;
	private JTextPane mn_MailTextPane;
	private JTable mn_CandidatesTable;
	private JComboBox<String> mn_StatusDropdown;
	private JComboBox<String> mn_CategoryDropdown;
	
	//########################################################
	//## US3 components on Camper Check-in Panel prefix - 'ci'
	//########################################################
	private JScrollPane ci_ScrollPane;
	private JLabel ci_CheckinInfoLabel;
	private JLabel ci_ClothLabel;
	private JLabel ci_PleaseCheckinCamperLabel;
	private JLabel ci_CamperNameLabel;
	private JCheckBox ci_ArrivalpackCheckBox;
	private JCheckBox ci_MusicalInstrumentCheckBox;
	private JCheckBox ci_EquipmentSuppliesCheckBox;
	private JCheckBox ci_LeatherCheckBox;
	private JCheckBox ci_SpandexCheckBox;
	private JCheckBox ci_GlitteredCheckBox;
	private JCheckBox ci_CheckInCamperCheckBox;	
	private JButton ci_SaveButton;
	private JButton ci_CancelButton;
	private JTable ci_CheckinTable;
	
	//########################################################
	//## US4 components on Dorm Assignment Panel prefix - 'da'
	//########################################################
	private JLabel da_RequestSwitchDormLabel;
	private JButton da_AutoAssignDormButton;
	private JList<DormItem> da_GirlDorm1List;
	private JList<DormItem> da_GirlDorm2List;
	private JList<DormItem> da_GirlDorm3List;
	private JList<DormItem> da_BoyDorm1List;
	private JList<DormItem> da_BoyDorm2List;
	private JList<DormItem> da_BoyDorm3List;
	private JPanel da_GirlDorm1Panel;
	private JPanel da_GirlDorm2Panel;
	private JPanel da_GirlDorm3Panel;
	private JPanel da_BoyDorm1Panel;
	private JPanel da_BoyDorm2Panel;
	private JPanel da_BoyDorm3Panel;
	private DefaultListModel<DormItem> da_GirlDorm1Model = new DefaultListModel<DormItem>();
	private DefaultListModel<DormItem> da_GirlDorm2Model = new DefaultListModel<DormItem>();
	private DefaultListModel<DormItem> da_GirlDorm3Model = new DefaultListModel<DormItem>();
	private DefaultListModel<DormItem> da_BoyDorm1Model = new DefaultListModel<DormItem>();
	private DefaultListModel<DormItem> da_BoyDorm2Model = new DefaultListModel<DormItem>();
	private DefaultListModel<DormItem> da_BoyDorm3Model = new DefaultListModel<DormItem>();
	private JComboBox<DormItem> da_Swaper1Dropdown;
	private JComboBox<DormItem> da_Swaper2Dropdown;
	private JButton da_RequestButton;
	private DefaultComboBoxModel<DormItem> da_Swaper1Model = new DefaultComboBoxModel<DormItem>();
	private DefaultComboBoxModel<DormItem> da_Swaper2Model = new DefaultComboBoxModel<DormItem>();

	//########################################################
	//## US5 components on Band Assignment Panel prefix - 'bd'
	//########################################################
	private JLabel bd_SwitchBandLabel;
	private JButton bd_AutoAssignBandButton;
	private JButton bd_RequestButton;
	private JList<BandItem> bd_Band1List;
	private JList<BandItem> bd_Band2List;
	private JList<BandItem> bd_Band3List;
	private JList<BandItem> bd_Band4List;
	private JList<BandItem> bd_Band5List;
	private JList<BandItem> bd_Band6List;
	private JList<BandItem> bd_Band7List;
	private JList<BandItem> bd_Band8List;
	private JComboBox<BandItem> bd_Swaper1Dropdown;
	private JComboBox<BandItem> bd_Swaper2Dropdown;
	private JPanel bd_Band1Panel;
	private JPanel bd_Band2Panel;
	private JPanel bd_Band3Panel;
	private JPanel bd_Band4Panel;
	private JPanel bd_Band5Panel;
	private JPanel bd_Band6Panel;
	private JPanel bd_Band7Panel;
	private JPanel bd_Band8Panel;
	private DefaultListModel<BandItem> bd_Band1Model = new DefaultListModel<BandItem>();
	private DefaultListModel<BandItem> bd_Band2Model = new DefaultListModel<BandItem>();
	private DefaultListModel<BandItem> bd_Band3Model = new DefaultListModel<BandItem>();
	private DefaultListModel<BandItem> bd_Band4Model = new DefaultListModel<BandItem>();
	private DefaultListModel<BandItem> bd_Band5Model = new DefaultListModel<BandItem>();
	private DefaultListModel<BandItem> bd_Band6Model = new DefaultListModel<BandItem>();
	private DefaultListModel<BandItem> bd_Band7Model = new DefaultListModel<BandItem>();
	private DefaultListModel<BandItem> bd_Band8Model = new DefaultListModel<BandItem>();
	private DefaultComboBoxModel<BandItem> bd_Swaper1Model = new DefaultComboBoxModel<BandItem>();
	private DefaultComboBoxModel<BandItem> bd_Swaper2Model = new DefaultComboBoxModel<BandItem>();
	
	//#############################################################
	//## US6 components on 2nd Band Assignment Panel prefix - 'bd2'
	//#############################################################
	
	private JLabel bd2_SwitchBandLabel;
	private JButton bd2_AutoAssign2ndBandButton;
	private JButton bd2_RequestButton;
	private JComboBox<BandItem> bd2_Swaper1Dropdown;
	private JComboBox<BandItem> bd2_Swaper2Dropdown;
	private JPanel bd2_Band1Panel;
	private JPanel bd2_Band2Panel;
	private JPanel bd2_Band3Panel;
	private JPanel bd2_Band4Panel;
	private JPanel bd2_Band5Panel;
	private JPanel bd2_Band6Panel;
	private JPanel bd2_Band7Panel;
	private JPanel bd2_Band8Panel;
	private JList<BandItem> bd2_Band1List;
	private JList<BandItem> bd2_Band2List;
	private JList<BandItem> bd2_Band3List;
	private JList<BandItem> bd2_Band4List;
	private JList<BandItem> bd2_Band5List;
	private JList<BandItem> bd2_Band6List;
	private JList<BandItem> bd2_Band7List;
	private JList<BandItem> bd2_Band8List;
	private DefaultListModel<BandItem> bd2_Band1Model = new DefaultListModel<BandItem>();
	private DefaultListModel<BandItem> bd2_Band2Model = new DefaultListModel<BandItem>();
	private DefaultListModel<BandItem> bd2_Band3Model = new DefaultListModel<BandItem>();
	private DefaultListModel<BandItem> bd2_Band4Model = new DefaultListModel<BandItem>();
	private DefaultListModel<BandItem> bd2_Band5Model = new DefaultListModel<BandItem>();
	private DefaultListModel<BandItem> bd2_Band6Model = new DefaultListModel<BandItem>();
	private DefaultListModel<BandItem> bd2_Band7Model = new DefaultListModel<BandItem>();
	private DefaultListModel<BandItem> bd2_Band8Model = new DefaultListModel<BandItem>();
	private DefaultComboBoxModel<BandItem> bd2_Swaper1Model = new DefaultComboBoxModel<BandItem>();
	private DefaultComboBoxModel<BandItem> bd2_Swaper2Model = new DefaultComboBoxModel<BandItem>();
	
	//## Global Variables	
	private boolean isDormAssigned = false;
	private boolean isBandAssigned = false;	
	private boolean is2ndBandAssigned = false;
	private boolean isApplicationEditMode = false;
	private String appUser = "user";
	private ArrayList<Camper> allAptCampers = new ArrayList<Camper>();
	
	//## Global Methods
	public void SetAppUser(String user) {
		appUser = user;
		main_WelcomeLabel.setText("Welcome, "+ appUser);
	}
	
	public void Display() {		
		main_Frame.setVisible(true);
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
	    DefaultTableModel model = (DefaultTableModel)ap_applicationTable.getModel();
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
	}
	
	private void cleanApplicationInputs() {
		ap_RecivedOnTextField.setText("");
		ap_FirstnameTextField.setText("");
		ap_LastnameTextField.setText("");
		ap_DateOfBirthTextField.setText("");
		ap_InstrumentTextField.setText("");
		ap_BoyRadioButton.setSelected(true);
		ap_HasRecordingCheckBox.setSelected(false);
		ap_HasEssayCheckBox.setSelected(false);
		ap_HasPaymentCheckBox.setSelected(false);
	}
	
	private boolean ValidateApplicationInput() {
		//should do a validation logic here
		String fname = ap_FirstnameTextField.getText().trim();
		String errmsg = "";
		Boolean validateResult = true;
		
		if(fname== null || fname.isEmpty()) {
			errmsg += "Firstname cannot be blank!\n";
			validateResult = false;
		}
		String lname = ap_LastnameTextField.getText().trim();
		if(lname== null || lname.isEmpty()) {
			errmsg += "Lastname cannot be blank!\n";
			validateResult = false;
		}
		String recvdaytxt = ap_RecivedOnTextField.getText().trim();
		if(recvdaytxt== null || recvdaytxt.isEmpty()) {
			errmsg += "Received Date cannot be blank!\n";
			validateResult = false;
		}
		if(!CalculationUtility.isDateFormattedCorrect(recvdaytxt)) {
			errmsg += "Received Date format incorrect!\n";
			validateResult = false;
		} else {
			//validate receive date
			String campDateName = (String)main_CampDateDropdown.getSelectedItem();
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
		String bdatetxt = ap_DateOfBirthTextField.getText().trim();
		if(bdatetxt== null || bdatetxt.isEmpty()) {
			errmsg += "Birth Date cannot be blank!\n";
			validateResult = false;
		}
		if(!CalculationUtility.isDateFormattedCorrect(bdatetxt)) {
			errmsg += "Birth Date format incorrect!\n";
			validateResult = false;
		}
		String instrumenttxt = ap_InstrumentTextField.getText().trim();
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
		camperToAdd.setReceivedDate(ap_RecivedOnTextField.getText());
		camperToAdd.setFirstname(ap_FirstnameTextField.getText());
		camperToAdd.setLastname(ap_LastnameTextField.getText());
		camperToAdd.setBirthday(ap_DateOfBirthTextField.getText());
		camperToAdd.setInstrument(ap_InstrumentTextField.getText());
		if(ap_BoyRadioButton.isSelected()) {
			camperToAdd.setGender("Boy");
		} else {
			camperToAdd.setGender("Girl");
		}
		if(ap_HasEssayCheckBox.isSelected()) {
			camperToAdd.setHasPersonalEssay("YES");
		} else {
			camperToAdd.setHasPersonalEssay("NO");
		}
		if(ap_HasRecordingCheckBox.isSelected()) {
			camperToAdd.setHasRecording("YES");
		} else {
			camperToAdd.setHasRecording("NO");
		}
		if(ap_HasPaymentCheckBox.isSelected()) {
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
		String idstr = ap_applicationTable.getValueAt(ap_applicationTable.getSelectedRow(), 0).toString();
	    int id =Integer.parseInt(idstr);
		camperToUpdate.setId(id);
		camperToUpdate.setReceivedDate(ap_RecivedOnTextField.getText());
		camperToUpdate.setFirstname(ap_FirstnameTextField.getText());
		camperToUpdate.setLastname(ap_LastnameTextField.getText());
		camperToUpdate.setBirthday(ap_DateOfBirthTextField.getText());
		camperToUpdate.setInstrument(ap_InstrumentTextField.getText());
		if(ap_BoyRadioButton.isSelected()) {
			camperToUpdate.setGender("Boy");
		} else {
			camperToUpdate.setGender("Girl");
		}
		if(ap_HasEssayCheckBox.isSelected()) {
			camperToUpdate.setHasPersonalEssay("YES");
		} else {
			camperToUpdate.setHasPersonalEssay("NO");
		}
		if(ap_HasRecordingCheckBox.isSelected()) {
			camperToUpdate.setHasRecording("YES");
		} else {
			camperToUpdate.setHasRecording("NO");
		}
		if(ap_HasPaymentCheckBox.isSelected()) {
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
		String id = ap_applicationTable.getValueAt(ap_applicationTable.getSelectedRow(), 0).toString();
		String fname = ap_applicationTable.getValueAt(ap_applicationTable.getSelectedRow(), 2).toString();
    	String lname = ap_applicationTable.getValueAt(ap_applicationTable.getSelectedRow(), 3).toString();
    	
		int dialogButton = JOptionPane.YES_NO_OPTION;
		int dialogResult = JOptionPane.showConfirmDialog (null, "Are you sure you want to delete "+fname+" "+lname+"?","Warning",dialogButton);
		if(dialogResult == JOptionPane.YES_OPTION){
			if(FuRSDBUtility.deleteCamper(id)) {
				JOptionPane.showMessageDialog(null, fname+" "+lname + " has been deleted from our candidate list.");
				//setback to add mode
				isApplicationEditMode = false;
		    	ap_AddButton.setVisible(true);
		    	ap_SaveButton.setVisible(false);
		    	ap_DeleteButton.setVisible(false);
		    	ap_CancelButton.setVisible(false);
		    	ap_IdLabel.setVisible(false);
		    	cleanApplicationInputs();
				reloadApplicationTable();
				reloadMailingCampersTable();
			}
		}
	}
	
	private void cancelApplicationEdit() {
		isApplicationEditMode = false;
    	ap_AddButton.setVisible(true);
    	ap_SaveButton.setVisible(false);
    	ap_DeleteButton.setVisible(false);
    	ap_CancelButton.setVisible(false);
    	ap_IdLabel.setVisible(false);
    	cleanApplicationInputs();
	}
	
	private void populateFields() {
		isApplicationEditMode = true;
    	ap_AddButton.setVisible(false);
    	ap_SaveButton.setVisible(true);
    	ap_DeleteButton.setVisible(true);
    	ap_CancelButton.setVisible(true);
    	ap_IdLabel.setVisible(true);
    	String id = ap_applicationTable.getValueAt(ap_applicationTable.getSelectedRow(), 0).toString();
    	String recvDate = ap_applicationTable.getValueAt(ap_applicationTable.getSelectedRow(), 1).toString();
    	String fname = ap_applicationTable.getValueAt(ap_applicationTable.getSelectedRow(), 2).toString();
    	String lname = ap_applicationTable.getValueAt(ap_applicationTable.getSelectedRow(), 3).toString();
    	String bDate = ap_applicationTable.getValueAt(ap_applicationTable.getSelectedRow(), 4).toString();
    	String gender = ap_applicationTable.getValueAt(ap_applicationTable.getSelectedRow(), 5).toString();
    	String instrmt = ap_applicationTable.getValueAt(ap_applicationTable.getSelectedRow(), 6).toString();
    	String hasEsy = ap_applicationTable.getValueAt(ap_applicationTable.getSelectedRow(), 7).toString();
    	String hasRec = ap_applicationTable.getValueAt(ap_applicationTable.getSelectedRow(), 8).toString();
    	String hasDps = ap_applicationTable.getValueAt(ap_applicationTable.getSelectedRow(), 9).toString();
    	
    	ap_IdLabel.setText("Id: "+id);
    	ap_RecivedOnTextField.setText(recvDate);
    	ap_FirstnameTextField.setText(fname);
    	ap_LastnameTextField.setText(lname);
    	ap_DateOfBirthTextField.setText(bDate);
    	ap_InstrumentTextField.setText(instrmt);
    	if(gender.equals("Boy")) {
    		ap_BoyRadioButton.setSelected(true);
    	} else {
    		ap_GirlRadioButton.setSelected(true);
    	}
    	
    	if(hasEsy.equals("YES")) {
    		ap_HasEssayCheckBox.setSelected(true);
    	} else {
    		ap_HasEssayCheckBox.setSelected(false);
    	}
    	if(hasRec.equals("YES")) {
    		ap_HasRecordingCheckBox.setSelected(true);
    	} else {
    		ap_HasRecordingCheckBox.setSelected(false);
    	}
    	if(hasDps.equals("YES")) {
    		ap_HasPaymentCheckBox.setSelected(true);
    	} else {
    		ap_HasPaymentCheckBox.setSelected(false);
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
			String content = mn_MailTextPane.getText();
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
	    DefaultTableModel model = (DefaultTableModel)mn_CandidatesTable.getModel();
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
	    
	    mn_SingerNumLabel.setText("Singer: "+numsingerboy+"/"+numsingergirl);
	    mn_GuitaristNumLabel.setText("Guitarist: "+numguitaristboy+"/"+numguitaristgirl);
	    mn_DrummerNumLabel.setText("Drummer: "+numdrummerboy+"/"+numdrummergirl);
	    mn_BassistNumLabel.setText("Bassist: "+numbassistboy+"/"+numbassistgirl);
	    mn_KeyboardistNumLabel.setText("Keyboardist: "+numkeyboardistboy+"/"+numkeyboardistgirl);
	    mn_InstrumentalistNumLabel.setText("Instrumentalist: "+numinstrumentalistboy+"/"+numinstrumentalistgirl);
	    mn_TotalGirlLabel.setText(totalgirls + "/24");
	    mn_TotalBoyLabel.setText(totalboys + "/24");
	    
	    
	}
	
	@SuppressWarnings("null")
	private void populateMailingFields() {
		
		mn_SaveButton.setVisible(true);
		mn_CancelButton.setVisible(true);
		mn_GenerateMailButton.setVisible(true);
		mn_StatusDropdown.setEnabled(true);
		mn_CategoryDropdown.setEnabled(true);
		
    	String fname = mn_CandidatesTable.getValueAt(mn_CandidatesTable.getSelectedRow(), 2).toString();
    	String status = "";
    	if(mn_CandidatesTable.getValueAt(mn_CandidatesTable.getSelectedRow(), 1) !=null) {
    		status	= mn_CandidatesTable.getValueAt(mn_CandidatesTable.getSelectedRow(), 1).toString();
    	}
    	String talentlvltxt = "";
    	if(mn_CandidatesTable.getValueAt(mn_CandidatesTable.getSelectedRow(), 8) !=null) {
    		talentlvltxt	= mn_CandidatesTable.getValueAt(mn_CandidatesTable.getSelectedRow(), 8).toString();
    	}
    	String category = "";
    	if(mn_CandidatesTable.getValueAt(mn_CandidatesTable.getSelectedRow(), 7) !=null) {
    		category = mn_CandidatesTable.getValueAt(mn_CandidatesTable.getSelectedRow(), 7).toString();
    	}
    	
    	//set to controls
    	mn_FullnameLabel.setText(fname);
    	if(status.equals("Accept")||status.equals("Deny")||status.equals("WaitingList")) {
    		mn_StatusDropdown.setSelectedItem(status);
    	} else {
    		mn_StatusDropdown.setSelectedItem("Undecided");
    	}
    	
    	int talentlvl = 0;   	
    	try{
    		talentlvl = Integer.parseInt(talentlvltxt);
    	} catch (Exception ex) {
    		ex.printStackTrace();
    	}
    	mn_TelentLevelSpinner.setValue(talentlvl);
    	
    	if(category!=null ||!category.isEmpty()) {
    		mn_CategoryDropdown.setSelectedItem(category);
    	}
    	else {
    		mn_CategoryDropdown.setSelectedItem("Not Assigned");
    	}
	}
	
	private void mailingStatusChange() {
		String selStatus = mn_StatusDropdown.getSelectedItem().toString();
		String content = "";
		String fname = mn_CandidatesTable.getValueAt(mn_CandidatesTable.getSelectedRow(), 2).toString();
		String lname = mn_CandidatesTable.getValueAt(mn_CandidatesTable.getSelectedRow(), 3).toString();
		if(selStatus.equals("Accept")) {
			content = String.format(FuRSDBUtility.AcceptMailContent, fname, lname);
		} else if(selStatus.equals("Deny")) {
			content = String.format(FuRSDBUtility.DenyMailContent, fname, lname);
		} else if(selStatus.equals("WaitingList")) {
			content = String.format(FuRSDBUtility.WaitingListMailContent, fname, lname);
		}
		else {
			content = "";
		}
		mn_MailTextPane.setText(content);
	}
	
	private void clearMailingFields(boolean isStart) {
		mn_SaveButton.setVisible(false);
		mn_CancelButton.setVisible(false);
		mn_GenerateMailButton.setVisible(false);
		mn_StatusDropdown.setEnabled(false);
		mn_CategoryDropdown.setEnabled(false);
		mn_TelentLevelSpinner.setValue(0);
		
		mn_MailTextPane.setText("");
		mn_FullnameLabel.setText("");
		if(!isStart) {
			mn_CategoryDropdown.setSelectedIndex(0);
			mn_StatusDropdown.setSelectedIndex(0);
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
		String idstr = mn_CandidatesTable.getValueAt(mn_CandidatesTable.getSelectedRow(), 0).toString();
	    int id =Integer.parseInt(idstr);
		camperToUpdate.setId(id);
		camperToUpdate.setCategory(mn_CategoryDropdown.getSelectedItem().toString());
		camperToUpdate.setApplicationStatus(mn_StatusDropdown.getSelectedItem().toString());
		camperToUpdate.setTalentLevel(mn_TelentLevelSpinner.getValue().toString());
		
		if(FuRSDBUtility.updateCamperStatus(camperToUpdate)) {
			//show success msg
			String fname = mn_CandidatesTable.getValueAt(mn_CandidatesTable.getSelectedRow(), 2).toString();
			String lname = mn_CandidatesTable.getValueAt(mn_CandidatesTable.getSelectedRow(), 3).toString();
			String camperfullname = fname + " " + lname;
			JOptionPane.showMessageDialog(null, camperfullname + " has been updated.");
			//update the table
			reloadMailingCampersTable();
			//clean the inputs
			clearMailingFields(true);
		}
		
	}
	
	//#### USER STORY 3 ###
	
	private void  saveCheckinStatus() {
		Camper camperToCheckin = new Camper();
		String idstr = ci_CheckinTable.getValueAt(ci_CheckinTable.getSelectedRow(), 0).toString();
	    int id =Integer.parseInt(idstr);
	    camperToCheckin.setId(id);
	    String hasArrivalpack = "NO";
	    String hasInstrument = "NO";
	    String hasSupplies = "NO";
	    String hasLeather = "NO";
	    String hasGlittered = "NO";
	    String hasSpandex = "NO";
	    String checkedin = "NO";
	    int totalcloth = 0;
	    boolean hasItemsNeeded = true;
	    
	    if(ci_ArrivalpackCheckBox.isSelected()) {
	    	hasArrivalpack = "YES";
	    } else {
	    	hasItemsNeeded = false;
	    }
	    
	    if(ci_MusicalInstrumentCheckBox.isSelected()) {
	    	hasInstrument = "YES";
	    } else {
	    	hasItemsNeeded = false;
	    }
	    
	    if(ci_EquipmentSuppliesCheckBox.isSelected()) {
	    	hasSupplies = "YES";
	    } else {
	    	hasItemsNeeded = false;
	    }
	    
	    if(ci_LeatherCheckBox.isSelected()) {
	    	hasLeather = "YES";
	    	totalcloth++;
	    }
	    if(ci_GlitteredCheckBox.isSelected()) {
	    	hasGlittered = "YES";
	    	totalcloth++;
	    }
	    if(ci_SpandexCheckBox.isSelected()) {
	    	hasSpandex = "YES";
	    	totalcloth++;
	    }
	    if(ci_CheckInCamperCheckBox.isSelected()) {
	    	checkedin = "YES";
	    }
	    
	    if(!hasItemsNeeded) {
	    	JOptionPane.showMessageDialog(null, "The camper doesn't have the needed items for this camp. Checkin cannot be compelted.");
	    	return;
	    }
	    
	    if(totalcloth<2) {
	    	JOptionPane.showMessageDialog(null, "The camper doesn't have enough clothes for this camp. Checkin cannot be compelted.");
	    	return;
	    }
	    
	    camperToCheckin.setHasArrivalPack(hasArrivalpack);
	    camperToCheckin.setHasMusicalInstrument(hasInstrument);
	    camperToCheckin.setHasEquipmentSupplies(hasSupplies);
	    camperToCheckin.setHasClothLeather(hasLeather);
	    camperToCheckin.setHasClothGlitter(hasGlittered);
	    camperToCheckin.setHasClothSpandex(hasSpandex);
		camperToCheckin.setCheckinStatus(checkedin);
	    
		if(FuRSDBUtility.updateCamperCheckinStatus(camperToCheckin)) {
			//show success msg
			String fname = ci_CheckinTable.getValueAt(ci_CheckinTable.getSelectedRow(), 1).toString();
			String lname = ci_CheckinTable.getValueAt(ci_CheckinTable.getSelectedRow(), 2).toString();
			String camperfullname = fname + " " + lname;
			JOptionPane.showMessageDialog(null, camperfullname + " has been updated.");
			//update the table
			reloadCheckinTable();
			//clean the inputs
			clearCheckinFields();
		}
	}
	
	private void clearCheckinFields() {	
		ci_CamperNameLabel.setText("");
		ci_SaveButton.setVisible(false);
		ci_CancelButton.setVisible(false);
		ci_ArrivalpackCheckBox.setSelected(false);
		ci_MusicalInstrumentCheckBox.setSelected(false);
		ci_EquipmentSuppliesCheckBox.setSelected(false);
		ci_LeatherCheckBox.setSelected(false);
		ci_SpandexCheckBox.setSelected(false);
		ci_GlitteredCheckBox.setSelected(false);
		ci_CheckInCamperCheckBox.setSelected(false);
	}
	
	private void reloadCheckinTable() {
		
		ArrayList<Camper> checkinCampers =FuRSDBUtility.getAllAcceptedCampers();
	    DefaultTableModel model = (DefaultTableModel)ci_CheckinTable.getModel();
	    model.setRowCount(0);
	    Object rowData[] = new Object[11];
	    for(int i=0; i<checkinCampers.size();i++) {
	    	rowData[0] = checkinCampers.get(i).getId();
	    	rowData[1] = checkinCampers.get(i).getFirstname();
	    	rowData[2] = checkinCampers.get(i).getLastname();
	    	rowData[3] = checkinCampers.get(i).getHasArrivalPack();
	    	rowData[4] = checkinCampers.get(i).getHasMusicalInstrument();
	    	rowData[5] = checkinCampers.get(i).getHasEquipmentSupplies();
	    	rowData[6] = checkinCampers.get(i).getHasClothLeather();
	    	rowData[7] = checkinCampers.get(i).getHasClothSpandex();
	    	rowData[8] = checkinCampers.get(i).getHasClothGlitter();
	    	rowData[9] = checkinCampers.get(i).getHasEquipmentSupplies();
	    	rowData[10] = checkinCampers.get(i).getCheckinStatus();
	    	model.addRow(rowData);
	    }
		
	}
	
    private void populateCheckinFields() {
		
    	ci_SaveButton.setVisible(true);
		ci_CancelButton.setVisible(true);
    	
    	String fname = ci_CheckinTable.getValueAt(ci_CheckinTable.getSelectedRow(), 1).toString();
    	String lname = ci_CheckinTable.getValueAt(ci_CheckinTable.getSelectedRow(), 2).toString();
    	ci_CamperNameLabel.setText(fname+" "+lname);
    	
    	String hasArrivalpack = (String)ci_CheckinTable.getValueAt(ci_CheckinTable.getSelectedRow(), 3);
 	    String hasInstrument = (String)ci_CheckinTable.getValueAt(ci_CheckinTable.getSelectedRow(), 4);
 	    String hasSupplies = (String)ci_CheckinTable.getValueAt(ci_CheckinTable.getSelectedRow(), 5);
 	    String hasLeather = (String)ci_CheckinTable.getValueAt(ci_CheckinTable.getSelectedRow(), 6);
 	    String hasGlittered = (String)ci_CheckinTable.getValueAt(ci_CheckinTable.getSelectedRow(), 7);
 	    String hasSpandex = (String)ci_CheckinTable.getValueAt(ci_CheckinTable.getSelectedRow(), 8);
 	    String checkedin = (String)ci_CheckinTable.getValueAt(ci_CheckinTable.getSelectedRow(), 9);
    	
    	if(hasArrivalpack!=null&&hasArrivalpack.equals("YES")) {
    		ci_ArrivalpackCheckBox.setSelected(true);
    	} else {
    		ci_ArrivalpackCheckBox.setSelected(false);}
    	
    	if(hasInstrument!=null&&hasInstrument.equals("YES")) {
    		ci_MusicalInstrumentCheckBox.setSelected(true);
    	} else {
    		ci_MusicalInstrumentCheckBox.setSelected(false);
    	}
    	
    	if(hasSupplies!=null&&hasSupplies.equals("YES")) {
    		ci_EquipmentSuppliesCheckBox.setSelected(true);
    	} else {
    		ci_EquipmentSuppliesCheckBox.setSelected(false);
    	}
    	
    	if(hasLeather!=null&&hasLeather.equals("YES")) {
    		ci_LeatherCheckBox.setSelected(true);
    	} else {
    		ci_LeatherCheckBox.setSelected(false);
    	}
    	
    	if(hasGlittered!=null&&hasGlittered.equals("YES")) {
    		ci_GlitteredCheckBox.setSelected(true);
    	} else {
    		ci_GlitteredCheckBox.setSelected(false);
    	}
    	
    	if(hasSpandex!=null&&hasSpandex.equals("YES")) {
    		ci_SpandexCheckBox.setSelected(true);
    	} else {
    		ci_SpandexCheckBox.setSelected(false);
    	}
    	
    	if(checkedin!=null&&checkedin.equals("YES")) {
    		ci_CheckInCamperCheckBox.setSelected(true);
    	} else {
    		ci_CheckInCamperCheckBox.setSelected(false);
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
		allAptCampers = allAcceptCampers;
		//add to lists
		reloadDorm();
		
		isDormAssigned = true;
	}

	private void reloadDorm() {
		
		da_GirlDorm1Model.clear();
		da_GirlDorm2Model.clear();
		da_GirlDorm3Model.clear();
		da_BoyDorm1Model.clear();
		da_BoyDorm2Model.clear();
		da_BoyDorm3Model.clear();
		for(Camper c:allAptCampers) {			
			int dormNum = c.getDormNum();
			if(c.getGender().equals("Girl")) {
				if(dormNum==1) {
					da_GirlDorm1Model.addElement(new DormItem(c.getFirstname(), c.getLastname(), c.getGender(), c.getAge(), c.getId()));
				} else if(dormNum==2) {
					da_GirlDorm2Model.addElement(new DormItem(c.getFirstname(), c.getLastname(), c.getGender(), c.getAge(), c.getId()));
				} else if(dormNum==3) {
					da_GirlDorm3Model.addElement(new DormItem(c.getFirstname(), c.getLastname(), c.getGender(), c.getAge(), c.getId()));
				}
			} else if(c.getGender().equals("Boy")) {
				if(dormNum==1) {
					da_BoyDorm1Model.addElement(new DormItem(c.getFirstname(), c.getLastname(), c.getGender(), c.getAge(), c.getId()));
				} else if(dormNum==2) {
					da_BoyDorm2Model.addElement(new DormItem(c.getFirstname(), c.getLastname(), c.getGender(), c.getAge(), c.getId()));
				} else if(dormNum==3) {
					da_BoyDorm3Model.addElement(new DormItem(c.getFirstname(), c.getLastname(), c.getGender(), c.getAge(), c.getId()));
				}
			}
		}
	}
		
	private void loadDormSwapDropdowns() {
		ArrayList<Camper> allAcceptCampers = FuRSDBUtility.getAllAcceptedCampers(); 
		for(Camper c: allAcceptCampers) {
			da_Swaper1Model.addElement(new DormItem(c.getFirstname(), c.getLastname(), c.getGender(), c.getAge(), c.getId()));
			da_Swaper2Model.addElement(new DormItem(c.getFirstname(), c.getLastname(), c.getGender(), c.getAge(), c.getId()));
		}
	}
	
	private void loadBandSwapDropdowns() {
		ArrayList<Camper> allAcceptCampers = FuRSDBUtility.getAllAcceptedCampers(); 
		for(Camper c: allAcceptCampers) {
			bd_Swaper1Model.addElement(new BandItem(c.getFirstname(), c.getLastname(), c.getGender(), c.getId(), c.getCategory(), c.getTalentLevel()));
			bd_Swaper2Model.addElement(new BandItem(c.getFirstname(), c.getLastname(), c.getGender(), c.getId(), c.getCategory(), c.getTalentLevel()));
		}
	}
	
	private void load2ndBandSwapDropdowns() {
		ArrayList<Camper> allAcceptCampers = FuRSDBUtility.getAllAcceptedCampers(); 
		for(Camper c: allAcceptCampers) {
			bd2_Swaper1Model.addElement(new BandItem(c.getFirstname(), c.getLastname(), c.getGender(), c.getId(), c.getCategory(), c.getTalentLevel()));
			bd2_Swaper2Model.addElement(new BandItem(c.getFirstname(), c.getLastname(), c.getGender(), c.getId(), c.getCategory(), c.getTalentLevel()));
		}
	}
	
	private void swapCampersDormRequest() {
	    DormItem camp1 = (DormItem)da_Swaper1Dropdown.getSelectedItem();
	    DormItem camp2 = (DormItem)da_Swaper2Dropdown.getSelectedItem();
		
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
	    for(Camper c: allAptCampers) {
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
	    
	    allAptCampers = allAcceptCampers;
	    reloadBand();
	    isBandAssigned = true;
	}
	
	private void reloadBand() {
		bd_Band1Model.clear();
	    bd_Band2Model.clear();
	    bd_Band3Model.clear();
	    bd_Band4Model.clear();
	    bd_Band5Model.clear();
	    bd_Band6Model.clear();
	    bd_Band7Model.clear();
	    bd_Band8Model.clear();
	    
	    for(Camper c:allAptCampers) {			
			int bandnum = c.getBandNum();
			switch (bandnum) {
            case 1:  bd_Band1Model.addElement(new BandItem(c.getFirstname(), c.getLastname(), c.getGender(), c.getId(), c.getCategory(), c.getTalentLevel()));
                     break;
            case 2:  bd_Band2Model.addElement(new BandItem(c.getFirstname(), c.getLastname(), c.getGender(), c.getId(), c.getCategory(), c.getTalentLevel()));
                     break;
            case 3:  bd_Band3Model.addElement(new BandItem(c.getFirstname(), c.getLastname(), c.getGender(), c.getId(), c.getCategory(), c.getTalentLevel()));
                     break;
            case 4:  bd_Band4Model.addElement(new BandItem(c.getFirstname(), c.getLastname(), c.getGender(), c.getId(), c.getCategory(), c.getTalentLevel()));
                     break;
            case 5:  bd_Band5Model.addElement(new BandItem(c.getFirstname(), c.getLastname(), c.getGender(), c.getId(), c.getCategory(), c.getTalentLevel()));
                     break;
            case 6:  bd_Band6Model.addElement(new BandItem(c.getFirstname(), c.getLastname(), c.getGender(), c.getId(), c.getCategory(), c.getTalentLevel()));
                     break;
            case 7:  bd_Band7Model.addElement(new BandItem(c.getFirstname(), c.getLastname(), c.getGender(), c.getId(), c.getCategory(), c.getTalentLevel()));
                     break;
            case 8:  bd_Band8Model.addElement(new BandItem(c.getFirstname(), c.getLastname(), c.getGender(), c.getId(), c.getCategory(), c.getTalentLevel()));
                     break;
			}
	    }
	}
	
    private void swapCampersBandRequest() {
    	
    	BandItem camp1 = (BandItem)bd_Swaper1Dropdown.getSelectedItem();
    	BandItem camp2 = (BandItem)bd_Swaper2Dropdown.getSelectedItem();
		
	    if(!isBandAssigned) {
	    	JOptionPane.showMessageDialog(null, "The request cannot be performed.\r\nWe haven't assigned band yet.");
	    	return;
	    }
	    
	    if(!camp1.getGender().equals(camp2.getGender())) {
	    	JOptionPane.showMessageDialog(null, "The request cannot be performed.\r\nWe can't make a band swap between a boy and a girl.");
	    	return;
	    }
	    
	    if(!camp1.getCategory().equals(camp2.getCategory())) {
	    	JOptionPane.showMessageDialog(null, "The request cannot be performed.\r\nWe can't make a band swap between different instrument categories.");
	    	return;
	    }
	    
	    if(camp1.getId()==camp2.getId()) {
	    	JOptionPane.showMessageDialog(null, "The request cannot be performed.\r\nPlease select different campers.");
	    	return;
	    }
	    
	    Camper cmp1=null;
	    Camper cmp2=null;
	    for(Camper c: allAptCampers) {
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

	    //should check talent level here
	    boolean istalentmatch = true;
	    if(!istalentmatch) {
	    	JOptionPane.showMessageDialog(null, "The request cannot be performed.\r\nAge group rule violation! We want to keep age distributed evenly.");
	    	return;
	    } else {
	    	//swap dorm
	    	int b1 = cmp1.getBandNum();
	    	int b2 = cmp2.getBandNum();
	    	cmp1.setBandNum(b2);
	    	cmp2.setBandNum(b1);
	    	String fullname1 = cmp1.getFirstname() + cmp1.getLastname();
	    	String fullname2 = cmp2.getFirstname() + cmp2.getLastname();
	    	//reload the group
	    	
	    	reloadBand();
	    	JOptionPane.showMessageDialog(null, "The Band swap request has been performed.\r\n"+ fullname1 + " has moved to Band #" + b2 + " and\r\n"+fullname2+ " has moved to Band #" + b1);
	    	return;
	    }
    }
	
    private void autoAssn2ndBand() {
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
	    //for random assign
	    int advIndx = 0;   
	    for(int i=1; i<=allCat.size();i++) {   	
	    	ArrayList<Camper> thisCat = allCat.get(i-1);
	    	//System.out.println("-------------Group"+i);
	    	for(int j=1; j<=thisCat.size(); j++) {
	    		Camper c = thisCat.get(j-1);
	    		int bnum = 0;
	    		int base = 0;
	    		if(j<4) {
	    			base = j;
	    		} else {
	    			base = j-4;
	    		}
	    		bnum = (base + advIndx)%4;
	    		if(bnum==0) {
	    			bnum=4;
	    		}
	    		//calculate base
	    		if(!order) {
	    			bnum = 5-bnum;
	    		} 
	    		
	    		if(j>4) {
	    			bnum +=4;
	    		}

	    		//System.out.println(""+bnum);
	    		c.setBand2Num(bnum);
	    	}
	    	//reverse order
	    	if(!order) {
	    		advIndx+=2;
	    	}
	    	order = !order;
	    }
	    
	    //update the main camper list
	    allAptCampers = allAcceptCampers;
	    reload2ndBand();
	    is2ndBandAssigned = true;
    }
    
    private void reload2ndBand() {
    	bd2_Band1Model.clear();
	    bd2_Band2Model.clear();
	    bd2_Band3Model.clear();
	    bd2_Band4Model.clear();
	    bd2_Band5Model.clear();
	    bd2_Band6Model.clear();
	    bd2_Band7Model.clear();
	    bd2_Band8Model.clear();
	    
	    for(Camper c:allAptCampers) {			
			int band2num = c.getBand2Num();
			switch (band2num) {
            case 1:  bd2_Band1Model.addElement(new BandItem(c.getFirstname(), c.getLastname(), c.getGender(), c.getId(), c.getCategory(), c.getTalentLevel()));
                     break;
            case 2:  bd2_Band2Model.addElement(new BandItem(c.getFirstname(), c.getLastname(), c.getGender(), c.getId(), c.getCategory(), c.getTalentLevel()));
                     break;
            case 3:  bd2_Band3Model.addElement(new BandItem(c.getFirstname(), c.getLastname(), c.getGender(), c.getId(), c.getCategory(), c.getTalentLevel()));
                     break;
            case 4:  bd2_Band4Model.addElement(new BandItem(c.getFirstname(), c.getLastname(), c.getGender(), c.getId(), c.getCategory(), c.getTalentLevel()));
                     break;
            case 5:  bd2_Band5Model.addElement(new BandItem(c.getFirstname(), c.getLastname(), c.getGender(), c.getId(), c.getCategory(), c.getTalentLevel()));
                     break;
            case 6:  bd2_Band6Model.addElement(new BandItem(c.getFirstname(), c.getLastname(), c.getGender(), c.getId(), c.getCategory(), c.getTalentLevel()));
                     break;
            case 7:  bd2_Band7Model.addElement(new BandItem(c.getFirstname(), c.getLastname(), c.getGender(), c.getId(), c.getCategory(), c.getTalentLevel()));
                     break;
            case 8:  bd2_Band8Model.addElement(new BandItem(c.getFirstname(), c.getLastname(), c.getGender(), c.getId(), c.getCategory(), c.getTalentLevel()));
                     break;
			}
	    }
    }
    
private void swapCampers2ndBandRequest() {
    	
    	BandItem camp1 = (BandItem)bd2_Swaper1Dropdown.getSelectedItem();
    	BandItem camp2 = (BandItem)bd2_Swaper2Dropdown.getSelectedItem();
		
	    if(!is2ndBandAssigned) {
	    	JOptionPane.showMessageDialog(null, "The request cannot be performed.\r\nWe haven't assigned band yet.");
	    	return;
	    }
	    
	    if(!camp1.getGender().equals(camp2.getGender())) {
	    	JOptionPane.showMessageDialog(null, "The request cannot be performed.\r\nWe can't make a band swap between a boy and a girl.");
	    	return;
	    }
	    
	    if(!camp1.getCategory().equals(camp2.getCategory())) {
	    	JOptionPane.showMessageDialog(null, "The request cannot be performed.\r\nWe can't make a band swap between different instrument categories.");
	    	return;
	    }
	    
	    if(camp1.getId()==camp2.getId()) {
	    	JOptionPane.showMessageDialog(null, "The request cannot be performed.\r\nPlease select different campers.");
	    	return;
	    }
	    
	    Camper cmp1=null;
	    Camper cmp2=null;
	    for(Camper c: allAptCampers) {
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

	    //should check talent level here
	    boolean istalentmatch = true;
	    if(!istalentmatch) {
	    	JOptionPane.showMessageDialog(null, "The request cannot be performed.\r\nAge group rule violation! We want to keep age distributed evenly.");
	    	return;
	    } else {
	    	//swap band
	    	int b1 = cmp1.getBand2Num();
	    	int b2 = cmp2.getBand2Num();
	    	cmp1.setBand2Num(b2);
	    	cmp2.setBand2Num(b1);
	    	String fullname1 = cmp1.getFirstname() + cmp1.getLastname();
	    	String fullname2 = cmp2.getFirstname() + cmp2.getLastname();
	    	//reload the group
	    	
	    	reload2ndBand();
	    	JOptionPane.showMessageDialog(null, "The 2nd Band swap request has been performed.\r\n"+ fullname1 + " has moved to 2nd Band #" + b2 + " and\r\n"+fullname2+ " has moved to 2nd Band #" + b1);
	    	return;
	    }
    }
    
    
	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		
		main_Frame = new JFrame();
		main_Frame.setResizable(false);
		main_Frame.setType(Type.UTILITY);
		main_Frame.getContentPane().setFont(new Font("Calibri", Font.PLAIN, 14));
		main_Frame.getContentPane().setBackground(new Color(255, 255, 255));
		main_Frame.getContentPane().setForeground(Color.BLACK);
		main_Frame.setForeground(SystemColor.menu);
		main_Frame.setBounds(100, 100, 1091, 606);
		main_Frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		main_Frame.getContentPane().setLayout(null);
		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
		main_Frame.setLocation(dim.width/2-main_Frame.getSize().width/2, dim.height/2-main_Frame.getSize().height/2);
		
		main_TabPane = new JTabbedPane(JTabbedPane.TOP);
		main_TabPane.setFont(new Font("Calibri", Font.PLAIN, 18));
		main_TabPane.setForeground(new Color(0, 0, 0));
		main_TabPane.setBackground(new Color(255, 255, 255));
		main_TabPane.setBounds(10, 67, 1074, 507);
		main_Frame.getContentPane().add(main_TabPane);
		
		ap_MainPanel = new JPanel();
		ap_MainPanel.setBackground(new Color(255, 255, 255));
		main_TabPane.addTab("Applications", (Icon) null, ap_MainPanel, null);
		ap_MainPanel.setLayout(null);
		
		ap_ScrollPane = new JScrollPane();
		ap_ScrollPane.setBounds(345, 11, 714, 448);
		ap_MainPanel.add(ap_ScrollPane);
		
		ap_applicationTable = new JTable();
		ap_applicationTable.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Id", "Recv.On", "FName", "LName", "BDay", "Gender", "Instrument", "Esy", "Rec", "Dps"
			}
		));
		ap_applicationTable.setFont(new Font("Calibri", Font.PLAIN, 16));
		ap_ScrollPane.setViewportView(ap_applicationTable);
		ap_applicationTable.setRowHeight(21);
		ap_applicationTable.getColumnModel().getColumn(0).setPreferredWidth(20);
		ap_applicationTable.getColumnModel().getColumn(1).setPreferredWidth(100);
		ap_applicationTable.getColumnModel().getColumn(4).setPreferredWidth(100);
		ap_applicationTable.getColumnModel().getColumn(5).setPreferredWidth(50);
		ap_applicationTable.getColumnModel().getColumn(7).setPreferredWidth(40);
		ap_applicationTable.getColumnModel().getColumn(8).setPreferredWidth(40);
		ap_applicationTable.getColumnModel().getColumn(9).setPreferredWidth(40);
		ListSelectionModel selModel = ap_applicationTable.getSelectionModel(); 
		
		ap_IdLabel = new JLabel("Id: ");
		ap_IdLabel.setFont(new Font("Calibri", Font.PLAIN, 16));
		ap_IdLabel.setBackground(Color.WHITE);
		ap_IdLabel.setBounds(10, 11, 101, 27);
		ap_IdLabel.setVisible(false);
		ap_MainPanel.add(ap_IdLabel);
		
		ap_RecivedOnLabel = new JLabel("Received On");
		ap_RecivedOnLabel.setFont(new Font("Calibri", Font.PLAIN, 16));
		ap_RecivedOnLabel.setBackground(Color.WHITE);
		ap_RecivedOnLabel.setBounds(10, 61, 101, 27);
		ap_MainPanel.add(ap_RecivedOnLabel);
		
		ap_FirstnameLabel = new JLabel("First Name");
		ap_FirstnameLabel.setFont(new Font("Calibri", Font.PLAIN, 16));
		ap_FirstnameLabel.setBackground(SystemColor.window);
		ap_FirstnameLabel.setBounds(10, 98, 101, 31);
		ap_MainPanel.add(ap_FirstnameLabel);
		
		ap_LastnameLabel = new JLabel("Last Name");
		ap_LastnameLabel.setFont(new Font("Calibri", Font.PLAIN, 16));
		ap_LastnameLabel.setBackground(SystemColor.window);
		ap_LastnameLabel.setBounds(10, 138, 101, 31);
		ap_MainPanel.add(ap_LastnameLabel);
		
		ap_GenderLabel = new JLabel("Gender");
		ap_GenderLabel.setFont(new Font("Calibri", Font.PLAIN, 16));
		ap_GenderLabel.setBackground(SystemColor.window);
		ap_GenderLabel.setBounds(10, 179, 101, 29);
		ap_MainPanel.add(ap_GenderLabel);
		
		ap_DateOfBirthLabel = new JLabel("DOB");
		ap_DateOfBirthLabel.setFont(new Font("Calibri", Font.PLAIN, 16));
		ap_DateOfBirthLabel.setBackground(SystemColor.window);
		ap_DateOfBirthLabel.setBounds(10, 218, 101, 27);
		ap_MainPanel.add(ap_DateOfBirthLabel);
		
		ap_InstrumentLabel = new JLabel("Instrument");
		ap_InstrumentLabel.setFont(new Font("Calibri", Font.PLAIN, 16));
		ap_InstrumentLabel.setBackground(SystemColor.window);
		ap_InstrumentLabel.setBounds(10, 257, 101, 29);
		ap_MainPanel.add(ap_InstrumentLabel);
		
		ap_RecivedOnTextField = new JTextField();
		ap_RecivedOnTextField.setToolTipText("Please follow format mm/dd/yyyy");
		ap_RecivedOnTextField.setFont(new Font("Calibri", Font.PLAIN, 16));
		ap_RecivedOnTextField.setColumns(10);
		ap_RecivedOnTextField.setBackground(new Color(255, 255, 255));
		ap_RecivedOnTextField.setBounds(121, 59, 156, 29);
		ap_MainPanel.add(ap_RecivedOnTextField);
		
		ap_FirstnameTextField = new JTextField();
		ap_FirstnameTextField.setFont(new Font("Calibri", Font.PLAIN, 16));
		ap_FirstnameTextField.setBackground(new Color(255, 255, 255));
		ap_FirstnameTextField.setBounds(121, 99, 156, 29);
		ap_MainPanel.add(ap_FirstnameTextField);
		ap_FirstnameTextField.setColumns(10);
		
		ap_LastnameTextField = new JTextField();
		ap_LastnameTextField.setFont(new Font("Calibri", Font.PLAIN, 16));
		ap_LastnameTextField.setBackground(new Color(255, 255, 255));
		ap_LastnameTextField.setColumns(10);
		ap_LastnameTextField.setBounds(121, 139, 156, 29);
		ap_MainPanel.add(ap_LastnameTextField);
		
		ap_InstrumentTextField = new JTextField();
		ap_InstrumentTextField.setToolTipText("");
		ap_InstrumentTextField.setFont(new Font("Calibri", Font.PLAIN, 16));
		ap_InstrumentTextField.setColumns(10);
		ap_InstrumentTextField.setBackground(new Color(255, 255, 255));
		ap_InstrumentTextField.setBounds(121, 257, 156, 29);
		ap_MainPanel.add(ap_InstrumentTextField);
		
		ap_DateOfBirthTextField = new JTextField();
		ap_DateOfBirthTextField.setToolTipText("Please follow format mm/dd/yyyy");
		ap_DateOfBirthTextField.setFont(new Font("Calibri", Font.PLAIN, 16));
		ap_DateOfBirthTextField.setBackground(new Color(255, 255, 255));
		ap_DateOfBirthTextField.setBounds(121, 217, 156, 29);
		ap_MainPanel.add(ap_DateOfBirthTextField);
		ap_DateOfBirthTextField.setColumns(10);
		
		ap_BoyRadioButton = new JRadioButton("Boy");
		ap_BoyRadioButton.setFont(new Font("Calibri", Font.PLAIN, 16));
		ap_BoyRadioButton.setBackground(SystemColor.window);
		ap_BoyRadioButton.setBounds(121, 177, 73, 33);
		ap_MainPanel.add(ap_BoyRadioButton);
		
		ap_GirlRadioButton = new JRadioButton("Girl");
		ap_GirlRadioButton.setFont(new Font("Calibri", Font.PLAIN, 16));
		ap_GirlRadioButton.setBackground(SystemColor.window);
		ap_GirlRadioButton.setBounds(196, 177, 105, 33);
		ap_MainPanel.add(ap_GirlRadioButton);
		
		ap_GenderBtnGroup = new ButtonGroup();
		ap_GenderBtnGroup.add(ap_GirlRadioButton);
		ap_GenderBtnGroup.add(ap_BoyRadioButton);
		selModel.addListSelectionListener(new ListSelectionListener(){
	        @Override
			public void valueChanged(ListSelectionEvent event) {
	            if(!selModel.isSelectionEmpty()) {populateFields();}
	        }
	    });
		
		ap_HasEssayCheckBox = new JCheckBox("Personal Essay");
	    ap_HasEssayCheckBox.setFont(new Font("Calibri", Font.PLAIN, 16));
	    ap_HasEssayCheckBox.setBackground(SystemColor.window);
	    ap_HasEssayCheckBox.setBounds(10, 304, 140, 31);
	    ap_MainPanel.add(ap_HasEssayCheckBox);
	    
	    ap_HasRecordingCheckBox = new JCheckBox("Recording");
	    ap_HasRecordingCheckBox.setFont(new Font("Calibri", Font.PLAIN, 16));
	    ap_HasRecordingCheckBox.setBackground(SystemColor.window);
	    ap_HasRecordingCheckBox.setBounds(157, 304, 120, 31);
	    ap_MainPanel.add(ap_HasRecordingCheckBox);
	    
	    ap_HasPaymentCheckBox = new JCheckBox("Deposit Payment");
	    ap_HasPaymentCheckBox.setFont(new Font("Calibri", Font.PLAIN, 16));
	    ap_HasPaymentCheckBox.setBackground(SystemColor.window);
	    ap_HasPaymentCheckBox.setBounds(10, 338, 184, 31);
	    ap_MainPanel.add(ap_HasPaymentCheckBox);
	    
	    ap_SaveButton = new JButton("Save");
	    ap_SaveButton.addActionListener(new ActionListener() {
	    	public void actionPerformed(ActionEvent e) {
	    		saveCamper();
	    	}
	    });
	    ap_SaveButton.setBackground(SystemColor.control);
	    ap_SaveButton.setFont(new Font("Calibri", Font.PLAIN, 16));
	    ap_SaveButton.setBounds(127, 410, 85, 41);
	    ap_SaveButton.setVisible(false);
	    
	    ap_AddButton = new JButton("Add");
	    ap_AddButton.setForeground(new Color(0, 0, 0));
	    ap_AddButton.setBackground(SystemColor.control);
	    ap_AddButton.setFont(new Font("Calibri", Font.PLAIN, 16));
	    ap_AddButton.addActionListener(new ActionListener() {
	    	public void actionPerformed(ActionEvent arg0) {
	    		addCamper();
	    		//reload application campers
	    	}
	    });
	    ap_AddButton.setBounds(10, 410, 74, 41);
	    ap_MainPanel.add(ap_AddButton);
	    ap_MainPanel.add(ap_SaveButton);
	    
	    ap_DeleteButton = new JButton("Delete");
	    ap_DeleteButton.addActionListener(new ActionListener() {
	    	public void actionPerformed(ActionEvent e) {
	    		deleteSelectedCamper();
	    	}
	    });
	    ap_DeleteButton.setBackground(SystemColor.control);
	    ap_DeleteButton.setFont(new Font("Calibri", Font.PLAIN, 16));
	    ap_DeleteButton.setBounds(192, 11, 85, 30);
	    ap_DeleteButton.setVisible(false);
	    ap_MainPanel.add(ap_DeleteButton);
	    
	    ap_CancelButton = new JButton("Cancel");
	    ap_CancelButton.addActionListener(new ActionListener() {
	    	public void actionPerformed(ActionEvent e) {
	    		cancelApplicationEdit();
	    	}
	    });
	    ap_CancelButton.setForeground(new Color(0, 0, 0));
	    ap_CancelButton.setFont(new Font("Calibri", Font.PLAIN, 16));
	    ap_CancelButton.setBackground(SystemColor.menu);
	    ap_CancelButton.setBounds(222, 410, 79, 41);
	    ap_CancelButton.setVisible(false);
	    ap_MainPanel.add(ap_CancelButton);
		
		mn_MainPanel = new JPanel();
		mn_MainPanel.setBackground(new Color(255, 255, 255));
		main_TabPane.addTab("Mailing Notification", null, mn_MainPanel, null);
		mn_MainPanel.setLayout(null);
		
		mn_ScrollPane = new JScrollPane();
		mn_ScrollPane.setBounds(371, 79, 688, 380);
		mn_MainPanel.add(mn_ScrollPane);
		
		mn_CandidatesTable = new JTable();
		mn_CandidatesTable.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
					"Id", "Status", "FName", "LName", "Age", "Gender", "Instrument", "Category", "Talnt", "Esy", "Rec", "Dps"
			}
		));
		mn_CandidatesTable.setFont(new Font("Calibri", Font.PLAIN, 16));
		mn_ScrollPane.setViewportView(mn_CandidatesTable);
		mn_CandidatesTable.setRowHeight(21);
		mn_CandidatesTable.getColumnModel().getColumn(0).setPreferredWidth(15);
		mn_CandidatesTable.getColumnModel().getColumn(1).setPreferredWidth(40);
		mn_CandidatesTable.getColumnModel().getColumn(2).setPreferredWidth(60);
		mn_CandidatesTable.getColumnModel().getColumn(3).setPreferredWidth(60);
		mn_CandidatesTable.getColumnModel().getColumn(4).setPreferredWidth(20);
		mn_CandidatesTable.getColumnModel().getColumn(5).setPreferredWidth(40);
		mn_CandidatesTable.getColumnModel().getColumn(6).setPreferredWidth(80);
		mn_CandidatesTable.getColumnModel().getColumn(7).setPreferredWidth(100);
		mn_CandidatesTable.getColumnModel().getColumn(8).setPreferredWidth(30);
		mn_CandidatesTable.getColumnModel().getColumn(9).setPreferredWidth(30);
		mn_CandidatesTable.getColumnModel().getColumn(10).setPreferredWidth(30);
		mn_CandidatesTable.getColumnModel().getColumn(11).setPreferredWidth(30);
		ListSelectionModel selMailingModel = mn_CandidatesTable.getSelectionModel(); 
		selMailingModel.addListSelectionListener(new ListSelectionListener(){
	        @Override
			public void valueChanged(ListSelectionEvent event) {
	            if(!selMailingModel.isSelectionEmpty()) {populateMailingFields();}
	        }
	    });
		
		mn_SelectDecisionLabel = new JLabel("Please Select the Decision for");
		mn_SelectDecisionLabel.setFont(new Font("Calibri", Font.PLAIN, 16));
		mn_SelectDecisionLabel.setBounds(16, 12, 202, 32);
		mn_MainPanel.add(mn_SelectDecisionLabel);
		
		mn_FullnameLabel = new JLabel("");
		mn_FullnameLabel.setFont(new Font("Calibri", Font.BOLD, 16));
		mn_FullnameLabel.setBounds(214, 12, 146, 32);
		mn_MainPanel.add(mn_FullnameLabel);
		
		mn_DecisionLabel = new JLabel("Decision:");
		mn_DecisionLabel.setFont(new Font("Calibri", Font.PLAIN, 16));
		mn_DecisionLabel.setBackground(Color.WHITE);
		mn_DecisionLabel.setBounds(16, 48, 90, 29);
		mn_MainPanel.add(mn_DecisionLabel);
		
		mn_CategoryLabel = new JLabel("Category:");
		mn_CategoryLabel.setFont(new Font("Calibri", Font.PLAIN, 16));
		mn_CategoryLabel.setBackground(Color.WHITE);
		mn_CategoryLabel.setBounds(16, 86, 90, 29);
		mn_MainPanel.add(mn_CategoryLabel);
		
		mn_SkillLevelLabel = new JLabel("Talent Ranking:");
		mn_SkillLevelLabel.setFont(new Font("Calibri", Font.PLAIN, 16));
		mn_SkillLevelLabel.setBackground(Color.WHITE);
		mn_SkillLevelLabel.setBounds(16, 126, 116, 29);
		mn_MainPanel.add(mn_SkillLevelLabel);
		
		mn_CategoryBGLabel = new JLabel("(Category: Boy/Girl)");
		mn_CategoryBGLabel.setHorizontalAlignment(SwingConstants.LEFT);
		mn_CategoryBGLabel.setFont(new Font("Calibri", Font.ITALIC, 16));
		mn_CategoryBGLabel.setBounds(371, 11, 165, 23);
		mn_MainPanel.add(mn_CategoryBGLabel);
		
		mn_AcceptGirlLabel = new JLabel("Accepted Girls:");
		mn_AcceptGirlLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		mn_AcceptGirlLabel.setFont(new Font("Calibri", Font.PLAIN, 16));
		mn_AcceptGirlLabel.setBounds(684, 12, 120, 23);
		mn_MainPanel.add(mn_AcceptGirlLabel);
		
		mn_TotalGirlLabel = new JLabel("0/24");
		mn_TotalGirlLabel.setFont(new Font("Calibri", Font.BOLD, 16));
		mn_TotalGirlLabel.setBounds(814, 12, 65, 23);
		mn_MainPanel.add(mn_TotalGirlLabel);
		
		mn_AcceptBoysLabel = new JLabel("Accepted Boys:");
		mn_AcceptBoysLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		mn_AcceptBoysLabel.setFont(new Font("Calibri", Font.PLAIN, 16));
		mn_AcceptBoysLabel.setBounds(869, 12, 115, 23);
		mn_MainPanel.add(mn_AcceptBoysLabel);
		
		mn_TotalBoyLabel = new JLabel("0/24");
		mn_TotalBoyLabel.setFont(new Font("Calibri", Font.BOLD, 16));
		mn_TotalBoyLabel.setBounds(994, 12, 65, 23);
		mn_MainPanel.add(mn_TotalBoyLabel);
		
		mn_SingerNumLabel = new JLabel("Singer: 0/0");
		mn_SingerNumLabel.setHorizontalAlignment(SwingConstants.LEFT);
		mn_SingerNumLabel.setFont(new Font("Calibri", Font.PLAIN, 16));
		mn_SingerNumLabel.setBounds(371, 48, 90, 23);
		mn_MainPanel.add(mn_SingerNumLabel);
		
		mn_GuitaristNumLabel = new JLabel("Guitarist: 0/0");
		mn_GuitaristNumLabel.setHorizontalAlignment(SwingConstants.LEFT);
		mn_GuitaristNumLabel.setFont(new Font("Calibri", Font.PLAIN, 16));
		mn_GuitaristNumLabel.setBounds(457, 48, 99, 23);
		mn_MainPanel.add(mn_GuitaristNumLabel);
		
		mn_DrummerNumLabel = new JLabel("Drummer: 0/0");
		mn_DrummerNumLabel.setHorizontalAlignment(SwingConstants.LEFT);
		mn_DrummerNumLabel.setFont(new Font("Calibri", Font.PLAIN, 16));
		mn_DrummerNumLabel.setBounds(554, 48, 99, 23);
		mn_MainPanel.add(mn_DrummerNumLabel);
		
		mn_BassistNumLabel = new JLabel("Bassist: 0/0");
		mn_BassistNumLabel.setHorizontalAlignment(SwingConstants.LEFT);
		mn_BassistNumLabel.setFont(new Font("Calibri", Font.PLAIN, 16));
		mn_BassistNumLabel.setBounds(654, 48, 90, 23);
		mn_MainPanel.add(mn_BassistNumLabel);
		
		mn_KeyboardistNumLabel = new JLabel("Keyboardist: 0/0");
		mn_KeyboardistNumLabel.setHorizontalAlignment(SwingConstants.LEFT);
		mn_KeyboardistNumLabel.setFont(new Font("Calibri", Font.PLAIN, 16));
		mn_KeyboardistNumLabel.setBounds(751, 48, 120, 23);
		mn_MainPanel.add(mn_KeyboardistNumLabel);
		
		mn_InstrumentalistNumLabel = new JLabel("Instrumentalist: 0/0");
		mn_InstrumentalistNumLabel.setHorizontalAlignment(SwingConstants.LEFT);
		mn_InstrumentalistNumLabel.setFont(new Font("Calibri", Font.PLAIN, 16));
		mn_InstrumentalistNumLabel.setBounds(879, 48, 152, 23);
		mn_MainPanel.add(mn_InstrumentalistNumLabel);
		
		mn_StatusDropdown = new JComboBox<String>();
		mn_StatusDropdown.setEnabled(false);
		mn_StatusDropdown.setModel(new DefaultComboBoxModel<String>(new String[] {"Undecided", "Accept", "Deny", "WaitingList"}));
		mn_StatusDropdown.setFont(new Font("Calibri", Font.PLAIN, 16));
		mn_StatusDropdown.setBackground(Color.WHITE);
		mn_StatusDropdown.setBounds(142, 50, 180, 29);
		mn_StatusDropdown.addActionListener (new ActionListener () {
		    public void actionPerformed(ActionEvent e) {
		        mailingStatusChange();
		    }
		});
		
		mn_MainPanel.add(mn_StatusDropdown);
		
		mn_CategoryDropdown = new JComboBox<String>();
		mn_CategoryDropdown.setEnabled(false);
		mn_CategoryDropdown.setModel(new DefaultComboBoxModel<String>(new String[] {"Not Assigned", "Singer", "Guitarist", "Drummer", "Bassist", "Keyboardist", "Instrumentalist"}));
		mn_CategoryDropdown.setFont(new Font("Calibri", Font.PLAIN, 16));
		mn_CategoryDropdown.setBackground(Color.WHITE);
		mn_CategoryDropdown.setBounds(142, 86, 180, 29);
		mn_MainPanel.add(mn_CategoryDropdown);
		
		mn_TelentLevelSpinner = new JSpinner();
		mn_TelentLevelSpinner.setFont(new Font("Calibri", Font.PLAIN, 16));
		mn_TelentLevelSpinner.setModel(new SpinnerNumberModel(0, 0, 10, 1));
		mn_TelentLevelSpinner.setBounds(142, 126, 65, 29);
		mn_MainPanel.add(mn_TelentLevelSpinner);
		
		mn_MailTextPanePanel = new JPanel();
		mn_MailTextPanePanel.setBorder(new TitledBorder(null, "Mail Content", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		mn_MailTextPanePanel.setBounds(15, 166, 346, 239);
		mn_MainPanel.add(mn_MailTextPanePanel);
		mn_MailTextPanePanel.setLayout(null);
		
		mn_MailTextPane = new JTextPane();
		mn_MailTextPane.setText("");
		mn_MailTextPane.setBounds(6, 16, 330, 212);
		mn_MailTextPanePanel.add(mn_MailTextPane);
		mn_MailTextPane.setFont(new Font("Calibri", Font.PLAIN, 14));
		
		mn_CancelButton = new JButton("Cancel");
		mn_CancelButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				clearMailingFields(false);
			}
		});
		
		
		mn_GenerateMailButton = new JButton("Generate Mail");
		mn_GenerateMailButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				openWordMailTemplate();
			}
		});
		
		mn_SaveButton = new JButton("Save");
		mn_SaveButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				saveCamperStatus();
			}
		});
		mn_SaveButton.setForeground(Color.BLACK);
		mn_SaveButton.setFont(new Font("Calibri", Font.PLAIN, 18));
		mn_SaveButton.setBackground(SystemColor.menu);
		mn_SaveButton.setBounds(16, 416, 77, 43);
		mn_MainPanel.add(mn_SaveButton);
		mn_GenerateMailButton.setForeground(Color.BLACK);
		mn_GenerateMailButton.setFont(new Font("Calibri", Font.PLAIN, 18));
		mn_GenerateMailButton.setBackground(SystemColor.menu);
		mn_GenerateMailButton.setBounds(103, 416, 158, 43);
		mn_MainPanel.add(mn_GenerateMailButton);
		mn_CancelButton.setForeground(Color.BLACK);
		mn_CancelButton.setFont(new Font("Calibri", Font.PLAIN, 18));
		mn_CancelButton.setBackground(SystemColor.menu);
		mn_CancelButton.setBounds(271, 416, 90, 43);
		mn_MainPanel.add(mn_CancelButton);
		
		ci_MainPanel = new JPanel();
		ci_MainPanel.setBackground(SystemColor.window);
		main_TabPane.addTab("Camper Checkin", null, ci_MainPanel, null);
		ci_MainPanel.setLayout(null);
		
		ci_ScrollPane = new JScrollPane();
		
		ci_ScrollPane.setBounds(317, 12, 742, 447);
		ci_MainPanel.add(ci_ScrollPane);
		
		ci_CheckinTable = new JTable();
		
		ci_CheckinTable.setModel(new DefaultTableModel(
				new Object[][] {
				},
				new String[] {
						"Id", "FName", "LName", "HasArvalPak", "HasIstrmt", "HasSply", "LeatherCloth", "SpdxCloth", "GlitterCloth", "CheckedIn"
				}
			));
		ci_CheckinTable.setFont(new Font("Calibri", Font.PLAIN, 16));
		ci_CheckinTable.getColumnModel().getColumn(0).setPreferredWidth(20);
		ci_CheckinTable.getColumnModel().getColumn(1).setPreferredWidth(80);
		ci_CheckinTable.getColumnModel().getColumn(2).setPreferredWidth(80);
		ci_CheckinTable.getColumnModel().getColumn(3).setPreferredWidth(50);
		ci_CheckinTable.getColumnModel().getColumn(4).setPreferredWidth(40);
		ci_CheckinTable.getColumnModel().getColumn(5).setPreferredWidth(30);
		ci_CheckinTable.getColumnModel().getColumn(6).setPreferredWidth(50);
		ci_CheckinTable.getColumnModel().getColumn(7).setPreferredWidth(40);
		ci_CheckinTable.getColumnModel().getColumn(8).setPreferredWidth(40);
		ci_CheckinTable.getColumnModel().getColumn(9).setPreferredWidth(40);
		ci_CheckinTable.setRowHeight(21);
		ListSelectionModel selCheckinModel = ci_CheckinTable.getSelectionModel(); 
		
		ci_ScrollPane.setViewportView(ci_CheckinTable);
		
		ci_PleaseCheckinCamperLabel = new JLabel("Please Checkin for");
		ci_PleaseCheckinCamperLabel.setFont(new Font("Calibri", Font.PLAIN, 16));
		ci_PleaseCheckinCamperLabel.setBounds(10, 13, 130, 32);
		ci_MainPanel.add(ci_PleaseCheckinCamperLabel);
		
		ci_CamperNameLabel = new JLabel("");
		ci_CamperNameLabel.setFont(new Font("Calibri", Font.BOLD, 16));
		ci_CamperNameLabel.setBounds(10, 41, 286, 29);
		ci_MainPanel.add(ci_CamperNameLabel);
		
		ci_CheckinInfoLabel = new JLabel("Checkin Information");
		ci_CheckinInfoLabel.setFont(new Font("Calibri", Font.PLAIN, 16));
		ci_CheckinInfoLabel.setBounds(10, 84, 157, 16);
		ci_MainPanel.add(ci_CheckinInfoLabel);
		
		ci_ClothLabel = new JLabel("Cloth");
		ci_ClothLabel.setFont(new Font("Calibri", Font.PLAIN, 16));
		ci_ClothLabel.setBounds(10, 223, 61, 26);
		ci_MainPanel.add(ci_ClothLabel);
		
		ci_ArrivalpackCheckBox = new JCheckBox("Arrival Packet");
		ci_ArrivalpackCheckBox.setBackground(Color.WHITE);
		ci_ArrivalpackCheckBox.setFont(new Font("Calibri", Font.PLAIN, 16));
		ci_ArrivalpackCheckBox.setBounds(6, 107, 128, 23);
		ci_MainPanel.add(ci_ArrivalpackCheckBox);
		
		ci_MusicalInstrumentCheckBox = new JCheckBox("Musical Instrument");
		ci_MusicalInstrumentCheckBox.setBackground(Color.WHITE);
		ci_MusicalInstrumentCheckBox.setFont(new Font("Calibri", Font.PLAIN, 16));
		ci_MusicalInstrumentCheckBox.setBounds(6, 133, 170, 23);
		ci_MainPanel.add(ci_MusicalInstrumentCheckBox);
		
		ci_EquipmentSuppliesCheckBox = new JCheckBox("Equipment Supplies");
		ci_EquipmentSuppliesCheckBox.setBackground(Color.WHITE);
		ci_EquipmentSuppliesCheckBox.setFont(new Font("Calibri", Font.PLAIN, 16));
		ci_EquipmentSuppliesCheckBox.setBounds(6, 159, 170, 23);
		ci_MainPanel.add(ci_EquipmentSuppliesCheckBox);
		
		ci_LeatherCheckBox = new JCheckBox("Leather");
		ci_LeatherCheckBox.setBackground(Color.WHITE);
		ci_LeatherCheckBox.setFont(new Font("Calibri", Font.PLAIN, 16));
		ci_LeatherCheckBox.setBounds(10, 256, 92, 23);
		ci_MainPanel.add(ci_LeatherCheckBox);
		
		ci_SpandexCheckBox = new JCheckBox("Spandex");
		ci_SpandexCheckBox.setBackground(Color.WHITE);
		ci_SpandexCheckBox.setFont(new Font("Calibri", Font.PLAIN, 16));
		ci_SpandexCheckBox.setBounds(10, 282, 96, 23);
		ci_MainPanel.add(ci_SpandexCheckBox);
		
		ci_GlitteredCheckBox = new JCheckBox("Glittered");
		ci_GlitteredCheckBox.setBackground(Color.WHITE);
		ci_GlitteredCheckBox.setFont(new Font("Calibri", Font.PLAIN, 16));
		ci_GlitteredCheckBox.setBounds(10, 308, 109, 23);
		ci_MainPanel.add(ci_GlitteredCheckBox);
		
		ci_SaveButton = new JButton("Save");
		ci_SaveButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				saveCheckinStatus();
			}
		});
		ci_SaveButton.setBackground(SystemColor.control);
		ci_SaveButton.setFont(new Font("Calibri", Font.PLAIN, 16));
		ci_SaveButton.setBounds(10, 418, 117, 41);
		ci_SaveButton.setVisible(false);
		
		ci_CheckInCamperCheckBox = new JCheckBox("Check in Camper");
		ci_CheckInCamperCheckBox.setFont(new Font("Calibri", Font.PLAIN, 18));
		ci_CheckInCamperCheckBox.setBackground(Color.WHITE);
		ci_CheckInCamperCheckBox.setBounds(10, 366, 217, 23);
		ci_MainPanel.add(ci_CheckInCamperCheckBox);
		ci_MainPanel.add(ci_SaveButton);
		
		ci_CancelButton = new JButton("Cancel");
		ci_CancelButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				clearCheckinFields();
			}
		});
		ci_CancelButton.setBackground(SystemColor.control);
		ci_CancelButton.setFont(new Font("Calibri", Font.PLAIN, 16));
		ci_CancelButton.setBounds(185, 418, 117, 41);
		ci_CancelButton.setVisible(false);
		ci_MainPanel.add(ci_CancelButton);
		selCheckinModel.addListSelectionListener(new ListSelectionListener(){
	        @Override
			public void valueChanged(ListSelectionEvent event) {
	            if(!selCheckinModel.isSelectionEmpty()) {populateCheckinFields();}
	        }
	    });
		
		da_MainPanel = new JPanel();
		da_MainPanel.setBackground(SystemColor.window);
		main_TabPane.addTab("Dorm Assignment", null, da_MainPanel, null);
		da_MainPanel.setLayout(null);
		
		da_GirlDorm1Panel = new JPanel();
		da_GirlDorm1Panel.setBorder(new TitledBorder(null, "Girls Dorm #1", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		da_GirlDorm1Panel.setBounds(20, 17, 207, 203);
		da_MainPanel.add(da_GirlDorm1Panel);
		da_GirlDorm1Panel.setLayout(null);
		
		da_GirlDorm1List = new JList<DormItem>(da_GirlDorm1Model);
		da_GirlDorm1List.setFont(new Font("Calibri", Font.PLAIN, 14));
		da_GirlDorm1List.setBounds(6, 16, 191, 176);
		da_GirlDorm1List.setCellRenderer(new DormItemCellRenderer());
		da_GirlDorm1Panel.add(da_GirlDorm1List);
		
		da_GirlDorm2Panel = new JPanel();
		da_GirlDorm2Panel.setLayout(null);
		da_GirlDorm2Panel.setBorder(new TitledBorder(null, "Girls Dorm #2", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		da_GirlDorm2Panel.setBounds(248, 17, 207, 203);
		da_MainPanel.add(da_GirlDorm2Panel);
		
		da_GirlDorm2List = new JList<DormItem>(da_GirlDorm2Model);
		da_GirlDorm2List.setFont(new Font("Calibri", Font.PLAIN, 14));
		da_GirlDorm2List.setBounds(6, 16, 191, 176);
		da_GirlDorm2List.setCellRenderer(new DormItemCellRenderer());
		da_GirlDorm2Panel.add(da_GirlDorm2List);
		
		da_GirlDorm3Panel = new JPanel();
		da_GirlDorm3Panel.setLayout(null);
		da_GirlDorm3Panel.setBorder(new TitledBorder(null, "Girls Dorm #3", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		da_GirlDorm3Panel.setBounds(478, 17, 207, 203);
		da_MainPanel.add(da_GirlDorm3Panel);
		
		da_GirlDorm3List = new JList<DormItem>(da_GirlDorm3Model);
		da_GirlDorm3List.setFont(new Font("Calibri", Font.PLAIN, 14));
		da_GirlDorm3List.setBounds(6, 16, 191, 176);
		da_GirlDorm3List.setCellRenderer(new DormItemCellRenderer());
		da_GirlDorm3Panel.add(da_GirlDorm3List);
		
		da_BoyDorm1Panel = new JPanel();
		da_BoyDorm1Panel.setLayout(null);
		da_BoyDorm1Panel.setBorder(new TitledBorder(null, "Boys Dorm #1", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		da_BoyDorm1Panel.setBounds(20, 238, 207, 203);
		da_MainPanel.add(da_BoyDorm1Panel);
		
		da_BoyDorm1List = new JList<DormItem>(da_BoyDorm1Model);
		da_BoyDorm1List.setFont(new Font("Calibri", Font.PLAIN, 14));
		da_BoyDorm1List.setBounds(6, 16, 191, 176);
		da_BoyDorm1List.setCellRenderer(new DormItemCellRenderer());
		da_BoyDorm1Panel.add(da_BoyDorm1List);
		
		da_BoyDorm2Panel = new JPanel();
		da_BoyDorm2Panel.setLayout(null);
		da_BoyDorm2Panel.setBorder(new TitledBorder(null, "Boys Dorm #2", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		da_BoyDorm2Panel.setBounds(248, 238, 207, 203);
		da_MainPanel.add(da_BoyDorm2Panel);
		
		da_BoyDorm2List = new JList<DormItem>(da_BoyDorm2Model);
		da_BoyDorm2List.setFont(new Font("Calibri", Font.PLAIN, 14));
		da_BoyDorm2List.setBounds(6, 16, 191, 176);
		da_BoyDorm2List.setCellRenderer(new DormItemCellRenderer());
		da_BoyDorm2Panel.add(da_BoyDorm2List);
		
		da_BoyDorm3Panel = new JPanel();
		da_BoyDorm3Panel.setLayout(null);
		da_BoyDorm3Panel.setBorder(new TitledBorder(null, "Boys Dorm #3", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		da_BoyDorm3Panel.setBounds(478, 238, 207, 203);
		da_MainPanel.add(da_BoyDorm3Panel);
		
		da_BoyDorm3List = new JList<DormItem>(da_BoyDorm3Model);
		da_BoyDorm3List.setFont(new Font("Calibri", Font.PLAIN, 14));
		da_BoyDorm3List.setBounds(6, 16, 191, 176);
		da_BoyDorm3List.setCellRenderer(new DormItemCellRenderer());
		da_BoyDorm3Panel.add(da_BoyDorm3List);
		
		da_RequestSwitchDormLabel = new JLabel("Dorm Switch Request");
		da_RequestSwitchDormLabel.setFont(new Font("Calibri", Font.PLAIN, 16));
		da_RequestSwitchDormLabel.setBounds(714, 322, 168, 32);
		da_MainPanel.add(da_RequestSwitchDormLabel);
		
		da_Swaper1Dropdown = new JComboBox<DormItem>(da_Swaper1Model);
		da_Swaper1Dropdown.setFont(new Font("Calibri", Font.PLAIN, 16));
		da_Swaper1Dropdown.setBackground(Color.WHITE);
		da_Swaper1Dropdown.setBounds(714, 365, 191, 29);
		//da_Swaper1Dropdown.setRenderer(new SwaperComboItem());
		da_MainPanel.add(da_Swaper1Dropdown);
		
		da_Swaper2Dropdown = new JComboBox<DormItem>(da_Swaper2Model);
		da_Swaper2Dropdown.setFont(new Font("Calibri", Font.PLAIN, 16));
		da_Swaper2Dropdown.setBackground(Color.WHITE);
		da_Swaper2Dropdown.setBounds(714, 412, 191, 29);
		//da_Swaper2Dropdown.setRenderer(new SwaperComboItem());
		da_MainPanel.add(da_Swaper2Dropdown);
		
		da_RequestButton = new JButton("Request");
		da_RequestButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				swapCampersDormRequest();
			}
		});
		
		da_AutoAssignDormButton = new JButton("Auto Dorm Assign");
		da_AutoAssignDormButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				autoAssnDorm();
			}
		});
		da_AutoAssignDormButton.setForeground(Color.BLACK);
		da_AutoAssignDormButton.setFont(new Font("Calibri", Font.PLAIN, 18));
		da_AutoAssignDormButton.setBackground(SystemColor.menu);
		da_AutoAssignDormButton.setBounds(714, 17, 191, 43);
		da_MainPanel.add(da_AutoAssignDormButton);
		da_RequestButton.setForeground(Color.BLACK);
		da_RequestButton.setFont(new Font("Calibri", Font.PLAIN, 18));
		da_RequestButton.setBackground(SystemColor.menu);
		da_RequestButton.setBounds(928, 398, 119, 43);
		da_MainPanel.add(da_RequestButton);
		
		bd_MainPanel = new JPanel();
		bd_MainPanel.setBackground(SystemColor.window);
		main_TabPane.addTab("Band Assignment", null, bd_MainPanel, null);
		bd_MainPanel.setLayout(null);
		
		bd_Band1Panel = new JPanel();
		bd_Band1Panel.setLayout(null);
		bd_Band1Panel.setBorder(new TitledBorder(null, "Band #1", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		bd_Band1Panel.setBounds(25, 22, 236, 144);
		bd_MainPanel.add(bd_Band1Panel);
		
		bd_Band1List = new JList<BandItem>(bd_Band1Model);
		bd_Band1List.setFont(new Font("Calibri", Font.PLAIN, 12));
		bd_Band1List.setCellRenderer(new BandItemCellRenderer());
		bd_Band1List.setBounds(6, 16, 224, 120);
		bd_Band1Panel.add(bd_Band1List);
		
		bd_Band2Panel = new JPanel();
		bd_Band2Panel.setLayout(null);
		bd_Band2Panel.setBorder(new TitledBorder(null, "Band #2", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		bd_Band2Panel.setBounds(286, 22, 236, 144);
		bd_MainPanel.add(bd_Band2Panel);
		
		bd_Band2List = new JList<BandItem>(bd_Band2Model);
		bd_Band2List.setFont(new Font("Calibri", Font.PLAIN, 12));
		bd_Band2List.setCellRenderer(new BandItemCellRenderer());
		bd_Band2List.setBounds(6, 16, 224, 120);
		bd_Band2Panel.add(bd_Band2List);
		
		bd_Band3Panel = new JPanel();
		bd_Band3Panel.setLayout(null);
		bd_Band3Panel.setBorder(new TitledBorder(null, "Band #3", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		bd_Band3Panel.setBounds(547, 22, 236, 144);
		bd_MainPanel.add(bd_Band3Panel);
		
		bd_Band3List = new JList<BandItem>(bd_Band3Model);
		bd_Band3List.setFont(new Font("Calibri", Font.PLAIN, 12));
		bd_Band3List.setCellRenderer(new BandItemCellRenderer());
		bd_Band3List.setBounds(6, 16, 224, 120);
		bd_Band3Panel.add(bd_Band3List);
		
		bd_Band4Panel = new JPanel();
		bd_Band4Panel.setLayout(null);
		bd_Band4Panel.setBorder(new TitledBorder(null, "Band #4", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		bd_Band4Panel.setBounds(808, 22, 236, 144);
		bd_MainPanel.add(bd_Band4Panel);
		
		bd_Band4List = new JList<BandItem>(bd_Band4Model);
		bd_Band4List.setFont(new Font("Calibri", Font.PLAIN, 12));
		bd_Band4List.setCellRenderer(new BandItemCellRenderer());
		bd_Band4List.setBounds(6, 16, 224, 120);
		bd_Band4Panel.add(bd_Band4List);
		
		bd_Band5Panel = new JPanel();
		bd_Band5Panel.setLayout(null);
		bd_Band5Panel.setBorder(new TitledBorder(null, "Band #5", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		bd_Band5Panel.setBounds(25, 190, 236, 144);
		bd_MainPanel.add(bd_Band5Panel);
		
		bd_Band5List = new JList<BandItem>(bd_Band5Model);
		bd_Band5List.setFont(new Font("Calibri", Font.PLAIN, 12));
		bd_Band5List.setCellRenderer(new BandItemCellRenderer());
		bd_Band5List.setBounds(6, 16, 224, 120);
		bd_Band5Panel.add(bd_Band5List);
		
		bd_Band6Panel = new JPanel();
		bd_Band6Panel.setLayout(null);
		bd_Band6Panel.setBorder(new TitledBorder(null, "Band #6", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		bd_Band6Panel.setBounds(286, 190, 236, 144);
		bd_MainPanel.add(bd_Band6Panel);
		
		bd_Band6List = new JList<BandItem>(bd_Band6Model);
		bd_Band6List.setFont(new Font("Calibri", Font.PLAIN, 12));
		bd_Band6List.setCellRenderer(new BandItemCellRenderer());
		bd_Band6List.setBounds(6, 16, 224, 120);
		bd_Band6Panel.add(bd_Band6List);
		
		bd_Band7Panel = new JPanel();
		bd_Band7Panel.setLayout(null);
		bd_Band7Panel.setBorder(new TitledBorder(null, "Band #7", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		bd_Band7Panel.setBounds(547, 190, 236, 144);
		bd_MainPanel.add(bd_Band7Panel);
		
		bd_Band7List = new JList<BandItem>(bd_Band7Model);
		bd_Band7List.setFont(new Font("Calibri", Font.PLAIN, 12));
		bd_Band7List.setCellRenderer(new BandItemCellRenderer());
		bd_Band7List.setBounds(6, 16, 224, 120);
		bd_Band7Panel.add(bd_Band7List);
		
		bd_Band8Panel = new JPanel();
		bd_Band8Panel.setLayout(null);
		bd_Band8Panel.setBorder(new TitledBorder(null, "Band #8", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		bd_Band8Panel.setBounds(808, 190, 236, 144);
		bd_MainPanel.add(bd_Band8Panel);
		
		bd_Band8List = new JList<BandItem>(bd_Band8Model);
		bd_Band8List.setFont(new Font("Calibri", Font.PLAIN, 12));
		bd_Band8List.setCellRenderer(new BandItemCellRenderer());
		bd_Band8List.setBounds(6, 16, 224, 120);
		bd_Band8Panel.add(bd_Band8List);
		
		bd_SwitchBandLabel = new JLabel("Switch Band");
		bd_SwitchBandLabel.setFont(new Font("Calibri", Font.PLAIN, 16));
		bd_SwitchBandLabel.setBounds(34, 369, 100, 32);
		bd_MainPanel.add(bd_SwitchBandLabel);
		
		bd_Swaper1Dropdown = new JComboBox<BandItem>(bd_Swaper1Model);
		bd_Swaper1Dropdown.setFont(new Font("Calibri", Font.PLAIN, 16));
		bd_Swaper1Dropdown.setBackground(Color.WHITE);
		bd_Swaper1Dropdown.setBounds(149, 371, 191, 29);
		bd_MainPanel.add(bd_Swaper1Dropdown);
		
		bd_Swaper2Dropdown = new JComboBox<BandItem>(bd_Swaper2Model);
		bd_Swaper2Dropdown.setFont(new Font("Calibri", Font.PLAIN, 16));
		bd_Swaper2Dropdown.setBackground(Color.WHITE);
		bd_Swaper2Dropdown.setBounds(149, 411, 191, 29);
		bd_MainPanel.add(bd_Swaper2Dropdown);
		
		bd_RequestButton = new JButton("Request");
		bd_RequestButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				swapCampersBandRequest();
			}
		});
		
		bd_AutoAssignBandButton = new JButton("Auto Assign");
		bd_AutoAssignBandButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				autoAssnBand();
			}
		});
		bd_AutoAssignBandButton.setForeground(Color.BLACK);
		bd_AutoAssignBandButton.setFont(new Font("Calibri", Font.PLAIN, 18));
		bd_AutoAssignBandButton.setBackground(SystemColor.menu);
		bd_AutoAssignBandButton.setBounds(884, 403, 160, 43);
		bd_MainPanel.add(bd_AutoAssignBandButton);
		bd_RequestButton.setForeground(Color.BLACK);
		bd_RequestButton.setFont(new Font("Calibri", Font.PLAIN, 18));
		bd_RequestButton.setBackground(SystemColor.menu);
		bd_RequestButton.setBounds(363, 403, 119, 43);
		bd_MainPanel.add(bd_RequestButton);
		
		bd2_MainPanel = new JPanel();
		bd2_MainPanel.setLayout(null);
		bd2_MainPanel.setBackground(Color.WHITE);
		main_TabPane.addTab("2nd Band Assignment", null, bd2_MainPanel, null);
		
		bd2_Band1Panel = new JPanel();
		bd2_Band1Panel.setLayout(null);
		bd2_Band1Panel.setBorder(new TitledBorder(null, "Band #1", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		bd2_Band1Panel.setBounds(25, 22, 236, 144);
		bd2_MainPanel.add(bd2_Band1Panel);
		
		bd2_Band1List = new JList<BandItem>(bd2_Band1Model);
		bd2_Band1List.setFont(new Font("Calibri", Font.PLAIN, 12));
		bd2_Band1List.setCellRenderer(new BandItemCellRenderer());
		bd2_Band1List.setBounds(6, 16, 224, 120);
		bd2_Band1Panel.add(bd2_Band1List);
		
		bd2_Band2Panel = new JPanel();
		bd2_Band2Panel.setLayout(null);
		bd2_Band2Panel.setBorder(new TitledBorder(null, "Band #2", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		bd2_Band2Panel.setBounds(286, 22, 236, 144);
		bd2_MainPanel.add(bd2_Band2Panel);
		
		bd2_Band2List = new JList<BandItem>(bd2_Band2Model);
		bd2_Band2List.setFont(new Font("Calibri", Font.PLAIN, 12));
		bd2_Band2List.setCellRenderer(new BandItemCellRenderer());
		bd2_Band2List.setBounds(6, 16, 224, 120);
		bd2_Band2Panel.add(bd2_Band2List);
		
		bd2_Band3Panel = new JPanel();
		bd2_Band3Panel.setLayout(null);
		bd2_Band3Panel.setBorder(new TitledBorder(null, "Band #3", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		bd2_Band3Panel.setBounds(547, 22, 236, 144);
		bd2_MainPanel.add(bd2_Band3Panel);
		
		bd2_Band3List = new JList<BandItem>(bd2_Band3Model);
		bd2_Band3List.setFont(new Font("Calibri", Font.PLAIN, 12));
		bd2_Band3List.setCellRenderer(new BandItemCellRenderer());
		bd2_Band3List.setBounds(6, 16, 224, 120);
		bd2_Band3Panel.add(bd2_Band3List);
		
		bd2_Band4Panel = new JPanel();
		bd2_Band4Panel.setLayout(null);
		bd2_Band4Panel.setBorder(new TitledBorder(null, "Band #4", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		bd2_Band4Panel.setBounds(808, 22, 236, 144);
		bd2_MainPanel.add(bd2_Band4Panel);
		
		bd2_Band4List = new JList<BandItem>(bd2_Band4Model);
		bd2_Band4List.setFont(new Font("Calibri", Font.PLAIN, 12));
		bd2_Band4List.setCellRenderer(new BandItemCellRenderer());
		bd2_Band4List.setBounds(6, 16, 224, 120);
		bd2_Band4Panel.add(bd2_Band4List);
		
		bd2_Band5Panel = new JPanel();
		bd2_Band5Panel.setLayout(null);
		bd2_Band5Panel.setBorder(new TitledBorder(null, "Band #5", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		bd2_Band5Panel.setBounds(25, 190, 236, 144);
		bd2_MainPanel.add(bd2_Band5Panel);
		
		bd2_Band5List = new JList<BandItem>(bd2_Band5Model);
		bd2_Band5List.setFont(new Font("Calibri", Font.PLAIN, 12));
		bd2_Band5List.setCellRenderer(new BandItemCellRenderer());
		bd2_Band5List.setBounds(6, 16, 224, 120);
		bd2_Band5Panel.add(bd2_Band5List);
		
		bd2_Band6Panel = new JPanel();
		bd2_Band6Panel.setLayout(null);
		bd2_Band6Panel.setBorder(new TitledBorder(null, "Band #6", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		bd2_Band6Panel.setBounds(286, 190, 236, 144);
		bd2_MainPanel.add(bd2_Band6Panel);
		
		bd2_Band6List = new JList<BandItem>(bd2_Band6Model);
		bd2_Band6List.setFont(new Font("Calibri", Font.PLAIN, 12));
		bd2_Band6List.setCellRenderer(new BandItemCellRenderer());
		bd2_Band6List.setBounds(6, 16, 224, 120);
		bd2_Band6Panel.add(bd2_Band6List);
		
		bd2_Band7Panel = new JPanel();
		bd2_Band7Panel.setLayout(null);
		bd2_Band7Panel.setBorder(new TitledBorder(null, "Band #7", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		bd2_Band7Panel.setBounds(547, 190, 236, 144);
		bd2_MainPanel.add(bd2_Band7Panel);
		
		bd2_Band7List = new JList<BandItem>(bd2_Band7Model);
		bd2_Band7List.setFont(new Font("Calibri", Font.PLAIN, 12));
		bd2_Band7List.setCellRenderer(new BandItemCellRenderer());
		bd2_Band7List.setBounds(6, 16, 224, 120);
		bd2_Band7Panel.add(bd2_Band7List);
		
		bd2_Band8Panel = new JPanel();
		bd2_Band8Panel.setLayout(null);
		bd2_Band8Panel.setBorder(new TitledBorder(null, "Band #8", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		bd2_Band8Panel.setBounds(808, 190, 236, 144);
		bd2_MainPanel.add(bd2_Band8Panel);
		
		bd2_Band8List = new JList<BandItem>(bd2_Band8Model);
		bd2_Band8List.setFont(new Font("Calibri", Font.PLAIN, 12));
		bd2_Band8List.setCellRenderer(new BandItemCellRenderer());
		bd2_Band8List.setBounds(6, 16, 224, 120);
		bd2_Band8Panel.add(bd2_Band8List);
		
		bd2_SwitchBandLabel = new JLabel("Switch Band");
		bd2_SwitchBandLabel.setFont(new Font("Calibri", Font.PLAIN, 16));
		bd2_SwitchBandLabel.setBounds(34, 369, 100, 32);
		bd2_MainPanel.add(bd2_SwitchBandLabel);
		
		bd2_Swaper1Dropdown = new JComboBox<BandItem>(bd2_Swaper1Model);
		bd2_Swaper1Dropdown.setFont(new Font("Calibri", Font.PLAIN, 16));
		bd2_Swaper1Dropdown.setBackground(Color.WHITE);
		bd2_Swaper1Dropdown.setBounds(149, 371, 191, 29);
		bd2_MainPanel.add(bd2_Swaper1Dropdown);
		
		bd2_Swaper2Dropdown = new JComboBox<BandItem>(bd2_Swaper2Model);
		bd2_Swaper2Dropdown.setFont(new Font("Calibri", Font.PLAIN, 16));
		bd2_Swaper2Dropdown.setBackground(Color.WHITE);
		bd2_Swaper2Dropdown.setBounds(149, 411, 191, 29);
		bd2_MainPanel.add(bd2_Swaper2Dropdown);
		
		bd2_AutoAssign2ndBandButton = new JButton("Auto Assign 2nd Band");
		bd2_AutoAssign2ndBandButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				autoAssn2ndBand();
			}
		});
		bd2_AutoAssign2ndBandButton.setForeground(Color.BLACK);
		bd2_AutoAssign2ndBandButton.setFont(new Font("Calibri", Font.PLAIN, 18));
		bd2_AutoAssign2ndBandButton.setBackground(SystemColor.menu);
		bd2_AutoAssign2ndBandButton.setBounds(792, 403, 252, 43);
		bd2_MainPanel.add(bd2_AutoAssign2ndBandButton);
		
		bd2_RequestButton = new JButton("Request");
		bd2_RequestButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				swapCampers2ndBandRequest();
			}
		});
		bd2_RequestButton.setForeground(Color.BLACK);
		bd2_RequestButton.setFont(new Font("Calibri", Font.PLAIN, 18));
		bd2_RequestButton.setBackground(SystemColor.menu);
		bd2_RequestButton.setBounds(363, 403, 119, 43);
		bd2_MainPanel.add(bd2_RequestButton);
				
		main_WelcomeLabel = new JLabel("Welcome, " + appUser);
		main_WelcomeLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		main_WelcomeLabel.setFont(new Font("Calibri", Font.BOLD, 18));
		main_WelcomeLabel.setBounds(664, 31, 130, 20);
		
		main_Frame.getContentPane().add(main_WelcomeLabel);
		
		main_CampDateDropdown = new JComboBox<String>();
		main_CampDateDropdown.setBackground(Color.WHITE);
		main_CampDateDropdown.setModel(new DefaultComboBoxModel<String>(new String[] {"2017 Jun", "2017 July", "2017 Augest"}));
		main_CampDateDropdown.setFont(new Font("Calibri", Font.PLAIN, 18));
		main_CampDateDropdown.setBounds(917, 27, 158, 29);
		main_CampDateDropdown.setSelectedIndex(2);
		main_Frame.getContentPane().add(main_CampDateDropdown);
			
		main_SetCampLabel = new JLabel("Set Camp:");
		main_SetCampLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		main_SetCampLabel.setFont(new Font("Calibri", Font.PLAIN, 18));
		main_SetCampLabel.setBounds(804, 31, 88, 20);
		main_Frame.getContentPane().add(main_SetCampLabel);
		
		main_MainTitleLabel = new JLabel("Campers Management System");
		main_MainTitleLabel.setForeground(Color.DARK_GRAY);
		main_MainTitleLabel.setHorizontalAlignment(SwingConstants.CENTER);
		main_MainTitleLabel.setFont(new Font("Segoe UI", Font.BOLD, 20));
		main_MainTitleLabel.setBounds(280, 16, 312, 40);
		main_Frame.getContentPane().add(main_MainTitleLabel);
		
		main_TopImageLabel = new JLabel("");
		Image img = new ImageIcon(this.getClass().getResource("resources/topbg-main.png")).getImage();
		main_TopImageLabel.setIcon(new ImageIcon(img));
		main_TopImageLabel.setBounds(10, 0, 282, 69);
		main_Frame.getContentPane().add(main_TopImageLabel);
		
		
		reloadApplicationTable();
		reloadMailingCampersTable();
		reloadCheckinTable();
		clearMailingFields(true);
		//FOR US #4
		loadDormSwapDropdowns();
		loadBandSwapDropdowns();
		//FOR US #5
		load2ndBandSwapDropdowns();
	}
	
	//Main method for testing
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainForm window = new MainForm();
					window.main_Frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

}
