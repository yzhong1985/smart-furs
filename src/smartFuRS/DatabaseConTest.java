package smartFuRS;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DatabaseConTest {
	
	private static Connection con;
	private static boolean hasData = false;
	
	public ResultSet displayUsers() throws Exception {
		if(con==null) {
			getConnection();
		}
		
		Statement state = con.createStatement();
		ResultSet res = state.executeQuery("");
		return res;
	}

	private void getConnection() throws Exception{
		// TODO Auto-generated method stub
		Class.forName("org.sqlite.JDBC");
		con = DriverManager.getConnection("jdbc:sqlite:FuRSDB.sqlite");
		initialise();
	}

	private void initialise() throws Exception {
		// TODO Auto-generated method stub
		if(!hasData) {
			hasData = true;
			
			Statement state = con.createStatement();
			ResultSet res = state.executeQuery("SELECT * FROM AppUser");
			while (res.next()) {              
		        
		        System.out.println(res.getString("username"));
		}
			
		}
	}
	
	public static void main(String[] args) {
		
		DatabaseConTest contest = new DatabaseConTest();
		try
		{
			contest.displayUsers();
		
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
		}
    }

}
