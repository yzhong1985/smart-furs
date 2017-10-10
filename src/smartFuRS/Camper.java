/**
 * 
 */
package smartFuRS;

import java.util.Date;

/**
 * @author Yang Zhong
 *
 */
public class Camper {
	private int id;
	private String firstname;
	private String lastname;
	private Date birthday;
	private String gender;
	private String instrument;
	private int talentLevel;
	private String applicationStatus;
	private Date receivedDate;
	private Boolean hasPersonalEssay;
	private String personalEssayFilePath;
	private Boolean hasRecording;
	private String recordingFilePath;
	private Boolean hasDepositPayment;
	private String depositFilePath;
	private String rejectReason;
	
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
	public Date getBirthday() {
		return birthday;
	}
	public void setBirthday(Date birthday) {
		this.birthday = birthday;
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

	public String getApplicationStatus() {
		return applicationStatus;
	}

	public void setApplicationStatus(String applicationStatus) {
		this.applicationStatus = applicationStatus;
	}

	public Date getReceivedDate() {
		return receivedDate;
	}

	public void setReceivedDate(Date receivedDate) {
		this.receivedDate = receivedDate;
	}

	public Boolean getHasPersonalEssay() {
		return hasPersonalEssay;
	}

	public void setHasPersonalEssay(Boolean hasPersonalEssay) {
		this.hasPersonalEssay = hasPersonalEssay;
	}

	public String getPersonalEssayFilePath() {
		return personalEssayFilePath;
	}

	public void setPersonalEssayFilePath(String personalEssayFilePath) {
		this.personalEssayFilePath = personalEssayFilePath;
	}

	public Boolean getHasRecording() {
		return hasRecording;
	}

	public void setHasRecording(Boolean hasRecording) {
		this.hasRecording = hasRecording;
	}

	public String getRecordingFilePath() {
		return recordingFilePath;
	}

	public void setRecordingFilePath(String recordingFilePath) {
		this.recordingFilePath = recordingFilePath;
	}

	public Boolean getHasDepositPayment() {
		return hasDepositPayment;
	}

	public void setHasDepositPayment(Boolean hasDepositPayment) {
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
	
	
	
}
