package smartFuRS;

import java.util.Date;

public class AppUser {
	
	private String username;
	private String password;
	private Date lastLogon;
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
	public Date getLastLogon() {
		return lastLogon;
	}
	public void setLastLogon(Date lastLogon) {
		this.lastLogon = lastLogon;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	
	
}
