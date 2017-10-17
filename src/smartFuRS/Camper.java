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
public class Camper implements Comparable<Camper> {
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
	
	private String hasArrivalPack;
	private String hasMusicalInstrument;
	private String hasEquipmentSupplies;
	private String hasClothLeather;
	private String hasClothSpandex;
	private String hasClothGlitter;
	private String checkinStatus;
	
	//0 means no dorm assigned
	private int dormNum=0;
	//0 means no band assigned
	private int bandNum=0;

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
	
	public int getAgeGroup() {
		int age = getAge();
		if(age<=14) {
			return 1;
		} else if(age==15||age==16) {
			return 2;
		} else {
			return 3;
		}
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
	public int getDormNum() {
		return dormNum;
	}
	public void setDormNum(int dormNum) {
		this.dormNum = dormNum;
	}
	public String getHasArrivalPack() {
		return hasArrivalPack;
	}
	public void setHasArrivalPack(String hasArrivalPack) {
		this.hasArrivalPack = hasArrivalPack;
	}
	public String getHasMusicalInstrument() {
		return hasMusicalInstrument;
	}
	public void setHasMusicalInstrument(String hasMusicalInstrument) {
		this.hasMusicalInstrument = hasMusicalInstrument;
	}
	public String getHasEquipmentSupplies() {
		return hasEquipmentSupplies;
	}
	public void setHasEquipmentSupplies(String hasEquipmentSupplies) {
		this.hasEquipmentSupplies = hasEquipmentSupplies;
	}
	public String getHasClothLeather() {
		return hasClothLeather;
	}
	public void setHasClothLeather(String hasClothLeather) {
		this.hasClothLeather = hasClothLeather;
	}
	public String getHasClothSpandex() {
		return hasClothSpandex;
	}
	public void setHasClothSpandex(String hasClothSpandex) {
		this.hasClothSpandex = hasClothSpandex;
	}
	public String getHasClothGlitter() {
		return hasClothGlitter;
	}
	public void setHasClothGlitter(String hasClothGlitter) {
		this.hasClothGlitter = hasClothGlitter;
	}
	public int getBandNum() {
		return bandNum;
	}
	public void setBandNum(int bandNum) {
		this.bandNum = bandNum;
	}
	
	@Override
	public int compareTo(Camper c) {
		// -1 - less than, 1 - greater than, 0 - equal, all inversed for descending
		//order by Boy > Girl then by TalentLevel
		if(this.getGender().equals("Boy")&&c.getGender().equals("Girl")) {
			return 1;
		} else if(this.getGender().equals("Girl")&&c.getGender().equals("Boy")) {
			return -1;
		}
		
		if(this.getTalentLevel()>c.getTalentLevel()) {
			return 1;
		} else if (this.getTalentLevel()<c.getTalentLevel()) {
			return -1;
		}
		
		return 0;
	}
	public String getCheckinStatus() {
		return checkinStatus;
	}
	public void setCheckinStatus(String checkinStatus) {
		this.checkinStatus = checkinStatus;
	}

	
}
