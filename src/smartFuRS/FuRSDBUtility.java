package smartFuRS;

import java.awt.EventQueue;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class FuRSDBUtility {

	private static Connection con;
	private static boolean hasData = false;
	private static boolean isConnected = false;
	

	public static void getConnection() {

		 try {
			Class.forName("org.sqlite.JDBC");
		  	con = DriverManager.getConnection("jdbc:sqlite:FuRSDB.sqlite");
		  	isConnected = true;
		 } catch (Exception ex) {
		  //log exception
			 System.out.println(ex.getMessage());
			 isConnected = false;
		 }
	}

	public static void main(String[] args) {
		
		try {
			FuRSDBUtility.getConnection();
		    AppUser usr = FuRSDBUtility.getAppUser("'yang'", "'1234'");
		    //System.out.println(usr.getRole());
		}
		catch(Exception ex) {
			System.out.println(ex.getMessage());
		}
	}
	
	public static AppUser getAppUser(String username, String pass) throws SQLException
	{
		String sql = "SELECT * FROM AppUser WHERE username = '%s' AND password = '%s'";
		sql = String.format(sql, username, pass);
		Statement state = con.createStatement();
		ResultSet res = state.executeQuery(sql);
		
		if(res.next()){
			AppUser appUser = new AppUser();
			appUser.setUsername(res.getString("username"));
			appUser.setRole(res.getString("role"));
			String d = res.getString("lastLogon");
			appUser.setLastLogon(d);
			return appUser;
		}
		else {
			return null;
		}
		
		
	}
	
	public static ResultSet getCampers() throws SQLException{
		if(!isConnected) {
			getConnection();
		}
		String sql = "SELECT firstname, lastname, birthday, gender, instrument FROM Camper";
		PreparedStatement pst = con.prepareStatement(sql);
		ResultSet rs = pst.executeQuery();
		return rs;
	}
	
	public static void addCamper(Camper camper) throws SQLException{
		if(!isConnected) {
			getConnection();
		}
		String sql = "INSERT INTO Camper (firstname, lastname, birthday, gender, instrument) VALUES ('%s','%s','%s','%s','%s')";
		sql = String.format(sql, camper.getFirstname(), camper.getLastname(), camper.getBirthdayText(), camper.getGender(), camper.getInstrument());
		
		PreparedStatement pst = con.prepareStatement(sql);
		pst.execute();
		pst.close();

		
	}
	

}
