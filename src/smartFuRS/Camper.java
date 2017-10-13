/**
 * 
 */
package smartFuRS;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

/**
 * @author Yang Zhong
 *
 */
public class Camper {
	private int id;
	private String firstname;
	private String lastname;
	private Calendar birthday;
	private String birthdayText;
	private String gender;
	private String instrument;
	private int talentLevel;
	private String applicationStatus;
	private Calendar receivedDate;
	private String receivedDateText;
	private String hasPersonalEssay;
	private String personalEssayFilePath;
	private String hasRecording;
	private String recordingFilePath;
	private String hasDepositPayment;
	private String depositFilePath;
	private String rejectReason;
	private String category;

	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getFirstname() {
		return firstname;
	}
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}
	public String getLastname() {
		return lastname;
	}
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}
	public Calendar getBirthday() {
		return birthday;
	}
	
	public void setBirthday(String birthday) {
		try {
			this.birthdayText = birthday;
			this.birthday = Calendar.getInstance();
			SimpleDateFormat sdf = new SimpleDateFormat("mm/dd/yyyy", Locale.ENGLISH);
			this.birthday.setTime(sdf.parse(birthday));
		} catch (Exception ex) {
			System.out.println(ex.getMessage());
		}
	}
	
	public String getBirthdayText() {
		return birthdayText;
	}
	
	public int getAge() {
		if(birthday == null) {
			return -1;
		}
		Calendar today = Calendar.getInstance();
		int days = CalculationUtility.daysBetween(today, birthday);
		int year = days/365;
		return year;
		
	}
	
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getInstrument() {
		return instrument;
	}
	public void setInstrument(String instrument) {
		this.instrument = instrument;
	}
	public int getTalentLevel() {
		return talentLevel;
	}
	public void setTalentLevel(int talentLevel) {
		this.talentLevel = talentLevel;
	}
	public void setTalentLevel(String talentLeveltxt) {
		try {
			this.talentLevel = Integer.parseInt(talentLeveltxt);
		} catch (Exception ex) {
			
		}
	}

	public String getApplicationStatus() {
		return applicationStatus;
	}

	public void setApplicationStatus(String applicationStatus) {
		this.applicationStatus = applicationStatus;
	}

	public Calendar getReceivedDate() {
		return receivedDate;
	}

	public void setReceivedDate(String receivedDate) {
		try {
			this.receivedDateText = receivedDate;
			this.receivedDate = Calendar.getInstance();
			SimpleDateFormat sdf = new SimpleDateFormat("mm/dd/yyyy", Locale.ENGLISH);
			this.receivedDate.setTime(sdf.parse(receivedDate));
		} catch (Exception ex) {
			System.out.println(ex.getMessage());
		}
	}
	
	public String getReceivedDateText() {
		return receivedDateText;
	}

	public String getHasPersonalEssay() {
		return hasPersonalEssay;
	}

	public void setHasPersonalEssay(String hasPersonalEssay) {
		this.hasPersonalEssay = hasPersonalEssay;
	}

	public String getPersonalEssayFilePath() {
		return personalEssayFilePath;
	}

	public void setPersonalEssayFilePath(String personalEssayFilePath) {
		this.personalEssayFilePath = personalEssayFilePath;
	}

	public String getHasRecording() {
		return hasRecording;
	}

	public void setHasRecording(String hasRecording) {
		this.hasRecording = hasRecording;
	}

	public String getRecordingFilePath() {
		return recordingFilePath;
	}

	public void setRecordingFilePath(String recordingFilePath) {
		this.recordingFilePath = recordingFilePath;
	}

	public String getHasDepositPayment() {
		return hasDepositPayment;
	}

	public void setHasDepositPayment(String hasDepositPayment) {
		this.hasDepositPayment = hasDepositPayment;
	}

	public String getDepositFilePath() {
		return depositFilePath;
	}

	public void setDepositFilePath(String depositFilePath) {
		this.depositFilePath = depositFilePath;
	}

	public String getRejectReason() {
		return rejectReason;
	}

	public void setRejectReason(String rejectReason) {
		this.rejectReason = rejectReason;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	
	
	
}
