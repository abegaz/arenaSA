package application;

import java.sql.*;
import java.util.Scanner;

public class DatabaseConnector
{
	private String databaseLink = "jdbc:mysql://localhost:3306/arenadatabase?autoReconnect=true&useSSL=false";
	private String databaseUser = "root";
	private String databasePassword = "";

	//private String databaseUser = "root"; // Xampp Credentials
	//private String databasePassword = ""; // Xampp Credentials

	private Connection connection;
	private Statement statement;
	private ResultSet resultSet;

	static Main main = new Main();
	Scanner scanner = new Scanner(System.in);

	// Connects to the database
	public DatabaseConnector()
	{
		try
		{
			Class.forName("com.mysql.jdbc.Driver");
			connection = DriverManager.getConnection(databaseLink, databaseUser, databasePassword);
			System.out.println("Connection Successful");
			statement = connection.createStatement();
		}
		catch(Exception ex)
		{
			System.out.println("Error: " + ex);
		}
	}
	public void makeNewUser()
	{
		String userID = null;
		String userName = null;
		String userPassword = null;

		String newUserQuery = "INSERT INTO users (userName, userPassword, userroletype_userRoleTypeID,userroletype_userRoleTypeName) "
				+ "VALUES (?, ?, 4 ,'Spectator')";
		try
		{
			System.out.println("Please enter the values of the new User:");

			System.out.println("Username: ");
			userName = scanner.nextLine();
			System.out.println("Userpassword: ");
			userPassword = scanner.nextLine();
			PreparedStatement preparedStatement = connection.prepareStatement(newUserQuery);
			preparedStatement.setString (1, userName);
			preparedStatement.setString (2, userPassword);

			// execute the preparedStatement
			preparedStatement.execute();
			getUsersInformation();

		}
		catch(Exception ex)
		{
			System.out.println("Error: " + ex);
		}
	}
	public void DeleteUser()
	{
		String deleteUserQuery;
		String userID = null;

		try
		{
			getUsersInformation();
			System.out.println("Enter User ID to delete");
			userID = scanner.nextLine();
			PreparedStatement preparedStatement = connection.prepareStatement("DELETE FROM users WHERE userID = '" + userID + "';");

			preparedStatement.execute();
		}
		catch(Exception ex)
		{
			System.out.println("Error: " + ex);
		}
		main.BasicFunctionMenu();
	}
	public void getUsersInformation()
	{
		//predefined query to select all entries from a specific pre-defined table
		String query = "select * from users";
		try
		{
			resultSet = statement.executeQuery(query);
			System.out.println("Users");
			while(resultSet.next())
			{
				String id = resultSet.getString("userID");
				String name = resultSet.getString("userName");
				String password = resultSet.getString("userPassword");
				String roleType = resultSet.getString("UserRoleType_userRoleTypeID");
				String roleName = resultSet.getString("userroletype_userRoleTypeName");

				System.out.println("User ID: " + id + " ");
				System.out.println("\t" + "Username: " + name);
				System.out.println("\t" + "Password: " + password + " ");
				System.out.println("\t" + "Role Type: " + roleType + " - " + roleName + " \n");
			}
		}
		catch(Exception ex)
		{
			System.out.println("Error: " + ex);
		}
	}
	public void getOperators()
	{
		String query = "select * from users WHERE userroletype_userRoleTypeID = 0";
		try
		{
			resultSet = statement.executeQuery(query);
			System.out.println("Operators");
			while(resultSet.next())
			{
				String id = resultSet.getString("userID");
				String name = resultSet.getString("userName");
				String password = resultSet.getString("userPassword");
				String roleType = resultSet.getString("UserRoleType_userRoleTypeID");
				String roleName = resultSet.getString("userroletype_userRoleTypeName");

				System.out.println("User ID: " + id + " ");
				System.out.println("\t" + "Username: " + name);
				System.out.println("\t" + "Password: " + password + " ");
				System.out.println("\t" + "Role Type: " + roleType + " - " + roleName + " \n");
			}
		}
		catch(Exception ex)
		{
			System.out.println("Error: " + ex);
		}
	}


	public void makeUserOperator()
	{

	}
	public void makeUserLeagueOwner()
	{

	}
	public void makeUserAdvertiser()
	{

	}
	public void makeUserPlayer()
	{

	}

	// Manipulation of Arenas
	public void GetAllArenas()
	{

	}
	public void CreateArena()
	{

	}
	public void DeleteArena()
	{

	}

	// Manipulation of Games
	public void GetAllGames()
	{

	}
	public void createGame()
	{

	}
	public void DeleteGame()
	{

	}


}
