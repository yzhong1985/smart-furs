package smartFuRS;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;

public class AppUser {
	
	private String username;
	private String password;
	private Calendar lastLogon;
	private String role;
	
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public Calendar getLastLogon() {
		return lastLogon;
	}
	public void setLastLogon(Calendar lastLogon) {
		this.lastLogon = lastLogon;
	}
	public void setLastLogon(String lastLogon) {
		try {
			this.lastLogon = Calendar.getInstance();
			SimpleDateFormat sdf = new SimpleDateFormat("mm/dd/yyyy", Locale.ENGLISH);
			this.lastLogon.setTime(sdf.parse(lastLogon));
		} catch (Exception ex) {
			System.out.println(ex.getMessage());
		}
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	
	
}
