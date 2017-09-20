/**
 * 
 */
package smartFuRS;

import java.util.Date;

/**
 * @author Yang Zhong
 *
 */
public class CamperNotification {

	private Camper camper;
	private Date sendDate;
	private String notificationMsg;
	public Camper getCamper() {
		return camper;
	}
	public void setCamper(Camper camper) {
		this.camper = camper;
	}
	public Date getSendDate() {
		return sendDate;
	}
	public void setSendDate(Date sendDate) {
		this.sendDate = sendDate;
	}
	public String getNotificationMsg() {
		return notificationMsg;
	}
	public void setNotificationMsg(String notificationMsg) {
		this.notificationMsg = notificationMsg;
	}
	
}
