/**
 * 
 */
package smartFuRS;

import java.util.Date;

/**
 * @author Yang Zhong
 *
 */
public class CampApplication {

	private int id;
	private Camper camper;
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
	
	public Camper getCamper() {
		return camper;
	}

	public void setCamper(Camper camper) {
		this.camper = camper;
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
