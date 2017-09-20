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
	private String firstname;
	private String lastname;
	private Date birthday;
	private Boolean gender;
	private String instrument;
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
	public Boolean getGender() {
		return gender;
	}
	public void setGender(Boolean gender) {
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
	private int talentLevel;
	
	
	
}
