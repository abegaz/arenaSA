package arenaClasses;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBHandler
{

	private static final String CONN_STRING = "jdbc:mysql://localhost:3306/arenadatabase";
	private static final String USERNAME = "root";
	private static final String PASSWORD = "";

	//private static final String databaseUser = "root"; // Xampp Credentials
	//private static final String databasePassword = ""; // Xampp Credentials

	//private static final String USERNAME = "root";
	//private static final String PASSWORD = "";
	//private static final String CONN_STRING = "jdbc:mysql://localhost/arenadatabase";

	// connection  method that connects us to the MySQL database
	public static Connection getConnection() throws SQLException{
		//System.out.println("Connected to Database Successfully");
		return DriverManager.getConnection(CONN_STRING, USERNAME, PASSWORD);
	}

	// method that displays our errors in more detail if connection fails
	public static void displayException(SQLException ex){
		System.err.println("Error Message: " + ex.getMessage());
		System.err.println("Error Code: " + ex.getErrorCode());
		System.err.println("SQL Status: " + ex.getSQLState());

	}
}
