package arenaClasses;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBHandler
{
	private static final String CONN_STRING = "jdbc:mysql://localhost:3306/arenadatabase?autoReconnect=true&useSSL=false";
	private static final String USERNAME = "root";
	private static final String PASSWORD = "";

	//private static final String CONN_STRING = "jdbc:mysql://50.62.209.8:3306/arenadatabase?autoReconnect=true&useSSL=false";
	//private static final String USERNAME = "arenaAbegaz";
	//private static final String PASSWORD = "9%Kn02my";

	//private static final String PASSWORD = "#altf4ctrlf6f12!";
	// connection  method that connects us to the MySQL database
	public static Connection getConnection() throws SQLException{
		return DriverManager.getConnection(CONN_STRING, USERNAME, PASSWORD);
	}
	// method that displays our errors in more detail if connection fails
	public static void displayException(SQLException ex){
		System.err.println("Error Message: " + ex.getMessage());
		System.err.println("Error Code: " + ex.getErrorCode());
		System.err.println("SQL Status: " + ex.getSQLState());
	}
}
