package smartFuRS;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DatabaseConTest {
	
	private static Connection con;
	private static boolean hasData = false;
	
	public ResultSet displayUsers() throws SQLException, ClassNotFoundException {
		if(con==null) {
			getConnection();
		}
		
		Statement state = con.createStatement();
		ResultSet res = state.executeQuery("");
		return res;
	}

	private void getConnection() throws SQLException, ClassNotFoundException {
		// TODO Auto-generated method stub
		Class.forName("org.sqlite.JDBC");
		con = DriverManager.getConnection("jdbc:sqlite:FuRSDB.sqlite");
		initialise();
	}

	private void initialise() throws SQLException {
		// TODO Auto-generated method stub
		if(!hasData) {
			hasData = true;
			
			Statement state = con.createStatement();
			ResultSet res = state.executeQuery("SELECT * FROM CampApplication");
			while (res.next()) {              
		        
		        System.out.println(res.getString("id"));
		        System.out.println(res.getString("firstname"));
		        System.out.println(res.getString("lastname"));                    
		        System.out.println(res.getString("age"));
		        System.out.println(res.getString("gender"));
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
			
		}
    }

}
