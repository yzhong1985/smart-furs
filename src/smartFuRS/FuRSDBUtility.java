package smartFuRS;

import java.awt.EventQueue;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class FuRSDBUtility {
	
	public static Connection getConnection() {

		 try {
			Class.forName("org.sqlite.JDBC");
			Connection con = DriverManager.getConnection("jdbc:sqlite:FuRSDB.sqlite");
			return con;
		 } catch (Exception ex) {
			 ex.printStackTrace();
			 return null;
		 }
	}

	public static void main(String[] args) {
		try {
			
		}
		catch(Exception ex) {
			System.out.println(ex.getMessage());
		}
	}
	
	public static AppUser getAppUser(String username, String pass) {
		Connection con = getConnection();
		String sql = "SELECT * FROM AppUser WHERE username = '%s' AND password = '%s'";
		sql = String.format(sql, username, pass);
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		try {
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			if(rs.next()){
				AppUser appUser = new AppUser();
				appUser.setUsername(rs.getString("username"));
				appUser.setRole(rs.getString("role"));
				String d = rs.getString("lastLogon");
				appUser.setLastLogon(d);			
				return appUser;
			}
			else { return null; }
		} catch (Exception ex) {
			ex.printStackTrace();
			return null;
		} finally {
			if (rs != null) {try { rs.close(); } catch (Exception e) { e.printStackTrace(); }}
		    if (ps != null) {try { ps.close(); } catch (Exception e) { e.printStackTrace(); }}
		    if (con != null) {try { con.close(); } catch (Exception e) { e.printStackTrace(); }}
		}
		
		
	}
	
	public static ArrayList<Camper> getApplicationCampers() {
		
		Connection con = getConnection();
		String sql = "SELECT id, firstname, lastname, birthday, receivedDate, gender, instrument, hasPersonalEssay, hasRecording, hasDepositPayment FROM Camper";
		PreparedStatement ps = null;
		ResultSet rs = null;
		ArrayList<Camper> camperlist = new ArrayList<Camper>();
		try {
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			while(rs.next()){
				Camper camp = new Camper();
				camp.setId(rs.getInt("id"));
				camp.setFirstname(rs.getString("firstname"));
				camp.setLastname(rs.getString("lastname"));
				camp.setBirthday(rs.getString("birthday"));
				camp.setReceivedDate(rs.getString("receivedDate"));
				camp.setGender(rs.getString("gender"));
				camp.setInstrument(rs.getString("instrument"));
				camp.setHasPersonalEssay(rs.getString("hasPersonalEssay"));
				camp.setHasRecording(rs.getString("hasRecording"));			
				camp.setHasDepositPayment(rs.getString("hasDepositPayment"));

				camperlist.add(camp);		
			}
			return camperlist;
		}
		catch(Exception ex) {
			ex.printStackTrace();
			return null;
		}
		finally {
			if (rs != null) {try { rs.close(); } catch (Exception e) { e.printStackTrace(); }}
		    if (ps != null) {try { ps.close(); } catch (Exception e) { e.printStackTrace(); }}
		    if (con != null) {try { con.close(); } catch (Exception e) { e.printStackTrace(); }}
		}
	}
	
	public static ArrayList<Camper> getMailingCampers(){
		
		Connection con = getConnection();
		String sql = "SELECT id, firstname, lastname, birthday, receivedDate, gender, instrument, hasPersonalEssay, hasRecording, hasDepositPayment, talentLevel, category, applicationStatus FROM Camper";
		PreparedStatement ps = null;
		ResultSet rs = null;
		ArrayList<Camper> camperlist = new ArrayList<Camper>();
		try {
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			while(rs.next()){
				Camper camp = new Camper();
				camp.setId(rs.getInt("id"));
				camp.setFirstname(rs.getString("firstname"));
				camp.setLastname(rs.getString("lastname"));
				camp.setBirthday(rs.getString("birthday"));
				camp.setReceivedDate(rs.getString("receivedDate"));
				camp.setGender(rs.getString("gender"));
				camp.setInstrument(rs.getString("instrument"));
				camp.setHasPersonalEssay(rs.getString("hasPersonalEssay"));
				camp.setHasRecording(rs.getString("hasRecording"));			
				camp.setHasDepositPayment(rs.getString("hasDepositPayment"));
				camp.setTalentLevel(rs.getString("talentLevel"));
				camp.setCategory(rs.getString("category"));
				camp.setApplicationStatus(rs.getString("applicationStatus"));
				camperlist.add(camp);		
			}
			return camperlist;
		}
		catch(Exception ex) {
			ex.printStackTrace();
			return null;
		}
		finally {
			if (rs != null) {try { rs.close(); } catch (Exception e) { e.printStackTrace(); }}
		    if (ps != null) {try { ps.close(); } catch (Exception e) { e.printStackTrace(); }}
		    if (con != null) {try { con.close(); } catch (Exception e) { e.printStackTrace(); }}
		}
	}
	
	public static boolean addCamper(Camper camper){
		
		Connection con = getConnection();
		String sql = "INSERT INTO Camper (firstname, lastname, birthday, gender, instrument, receivedDate, hasPersonalEssay, hasRecording, hasDepositPayment) VALUES ('%s','%s','%s','%s','%s','%s','%s','%s','%s')";
		sql = String.format(sql, camper.getFirstname(), camper.getLastname(), camper.getBirthdayText(), camper.getGender(), camper.getInstrument(), camper.getReceivedDateText(), camper.getHasPersonalEssay(), camper.getHasRecording(), camper.getHasDepositPayment());
		PreparedStatement ps = null;
		try {
			ps = con.prepareStatement(sql);
			ps.execute();
			return true;
		}
		catch(Exception ex) {
			ex.printStackTrace();
			return false;
		}
		finally {
		    if (ps != null) {try { ps.close(); } catch (Exception e) { e.printStackTrace(); }}
		    if (con != null) {try { con.close(); } catch (Exception e) { e.printStackTrace(); }}
		}

	}
	
	public static boolean updateCamper(Camper camper){
		
		Connection con = getConnection();
		String sql = "UPDATE Camper SET firstname='%s', lastname='%s', birthday='%s', gender='%s', instrument='%s', receivedDate='%s', hasPersonalEssay='%s', hasRecording='%s', hasDepositPayment='%s' WHERE id='%s'" ;
		sql = String.format(sql, camper.getFirstname(), camper.getLastname(), camper.getBirthdayText(), camper.getGender(), camper.getInstrument(), camper.getReceivedDateText(), camper.getHasPersonalEssay(), camper.getHasRecording(), camper.getHasDepositPayment(), camper.getId());
		PreparedStatement ps = null;
		try {
			ps = con.prepareStatement(sql);
			ps.execute();
			return true;
		}
		catch(Exception ex) {
			ex.printStackTrace();
			return false;
		}
		finally {
		    if (ps != null) {try { ps.close(); } catch (Exception e) { e.printStackTrace(); }}
		    if (con != null) {try { con.close(); } catch (Exception e) { e.printStackTrace(); }}
		}

	}
	
	public static boolean updateCamperStatus(Camper camper){
		
		Connection con = getConnection();
		String sql = "UPDATE Camper SET applicationStatus='%s', talentLevel='%s', category='%s' WHERE id='%s'" ;
		sql = String.format(sql, camper.getApplicationStatus(), camper.getTalentLevel(), camper.getCategory(), camper.getId());
		PreparedStatement ps = null;
		try {
			ps = con.prepareStatement(sql);
			ps.execute();
			return true;
		}
		catch(Exception ex) {
			ex.printStackTrace();
			return false;
		}
		finally {
		    if (ps != null) {try { ps.close(); } catch (Exception e) { e.printStackTrace(); }}
		    if (con != null) {try { con.close(); } catch (Exception e) { e.printStackTrace(); }}
		}

	}
	
	public static boolean deleteCamper(String id){
		
		Connection con = getConnection();
		String sql = "DELETE FROM Camper WHERE id = '%s'";
		sql = String.format(sql, id);
		PreparedStatement ps = null;
		try {
			ps = con.prepareStatement(sql);
			ps.execute();
			return true;
		}
		catch(Exception ex) {
			ex.printStackTrace();
			return false;
		}
		finally {
		    if (ps != null) {try { ps.close(); } catch (Exception e) { e.printStackTrace(); }}
		    if (con != null) {try { con.close(); } catch (Exception e) { e.printStackTrace(); }}
		}

	}
	
	public static String AcceptMailContent = "CONGRATULATIONS!\r\nDear %s %s,\r\n\r\nYou have been accepted as a CAMPER to attend Our Future Rock Star Camp! We are looking forward to having a meaningful and fun experience with you this summer! Let the memories begin!\r\n\r\nThank you!\r\nFuture Rock Star Camp Director";
	public static String DenyMailContent = "Dear %s %s,\r\n\r\nThank you for your application for the Future Rock Star Camp. After very careful consideration, I regret to inform you that, on this occasion, your application has not been successful.\r\n\r\nMay I take this opportunity to thank you for the interest you have shown and we are welcome you to apply our future camps.\r\n\r\nFuture Rock Star Camp Director";
	

}
