package application;

import java.sql.*;
import java.util.Scanner;

public class DatabaseConnector
{
	private String databaseLink = "jdbc:mysql://localhost:3306/arenadatabase?autoReconnect=true&useSSL=false";
	private String databaseUser = "root";
	private String databasePassword = "#altf4ctrlf6f12!";

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

	public String getUserRoleID(String userID)
	{
		String getUserRoleQuery = "SELECT userRoleID FROM users WHERE userID =" + userID;
		String userRoleID = null;
		try
		{
			resultSet = statement.executeQuery(getUserRoleQuery);
			while(resultSet.next())
			{
				 userRoleID = resultSet.getString("userRoleID");
			}

		}
		catch(Exception ex)
		{
			System.out.println("Error: " + ex);
		}

		return userRoleID;
	}
	public void makeNewUser()
	{
		String userName = null;
		String userPassword = null;

		String newUserQuery = "INSERT INTO users (userName, userPassword, userRoleID) "
				+ "VALUES (?, ?, 4)";
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
			getUsersInformation(false);

		}
		catch(Exception ex)
		{
			System.out.println("Error: " + ex);
		}
		main.BasicFunctionMenu();
	}
	public void DeleteUser()
	{
		String userID = null;
		String deleteUserQuery = "DELETE FROM users WHERE userID = '" + userID + "';";
		try
		{
			getUsersInformation(false);
			System.out.println("Enter User ID to delete");
			userID = scanner.nextLine();
			PreparedStatement preparedStatement = connection.prepareStatement(deleteUserQuery);

			preparedStatement.execute();
		}
		catch(Exception ex)
		{
			System.out.println("Error: " + ex);
		}
		main.BasicFunctionMenu();
	}
	public void getUsersInformation(boolean ReturnToMenu)
	{
		//predefined query to select all entries from a specific pre-defined table
		//String query = "SELECT * FROM users";
		String query = "SELECT user1.*, userroletype1.userRoleTypeName "
				+ "FROM users user1, userroletype userroletype1 "
				+ "WHERE user1.userRoleID = userroletype1.userRoleTypeID";
		try
		{
			resultSet = statement.executeQuery(query);
			System.out.println("Users");
			while(resultSet.next())
			{

				String id = resultSet.getString("userID");
				String name = resultSet.getString("userName");
				String password = resultSet.getString("userPassword");
				String roleTypeID = resultSet.getString("userRoleID");
				String roleTypeName = resultSet.getString("userRoleTypeName");

				System.out.println("User ID: " + id + " ");
				System.out.println("\t" + "Username: " + name);
				System.out.println("\t" + "Password: " + password + " ");
				System.out.println("\t" + "Role ID: " + roleTypeID + " Role Name: " + roleTypeName + "\n");
			}
		}
		catch(Exception ex)
		{
			System.out.println("Error: " + ex);
		}
		if (ReturnToMenu)
		{
			main.BasicFunctionMenu();
		}
	}
	public void getOperators()
	{
		String query = "SELECT user1.*, userroletype1.userRoleTypeName FROM users user1, userroletype userroletype1 WHERE user1.userRoleID = userroletype1.userRoleTypeID AND user1.userRoleID = 0";
		//String query = "select * from users WHERE userRoleID = 0";
		try
		{
			resultSet = statement.executeQuery(query);
			System.out.println("Operators");
			while(resultSet.next())
			{
				String id = resultSet.getString("userID");
				String name = resultSet.getString("userName");
				String password = resultSet.getString("userPassword");
				String roleType = resultSet.getString("userRoleID");

				System.out.println("User ID: " + id + " ");
				System.out.println("\t" + "Username: " + name);
				System.out.println("\t" + "Password: " + password + " ");
				System.out.println("\t" + "Role Type: " + roleType + " \n");
			}
		}
		catch(Exception ex)
		{
			System.out.println("Error: " + ex);
		}
		main.BasicFunctionMenu();
	}

	public void MakeUserOperator()
	{
		try
		{
			System.out.println("Enter UserID to change Role Type:");
			String userIDToMakeOperator = scanner.nextLine();

			String makeUserOperatorQuery = "UPDATE users SET userRoleID = 0  WHERE userID = "+ userIDToMakeOperator + " and userRoleID = 4 ";

			PreparedStatement preparedStatement = connection.prepareStatement(makeUserOperatorQuery);
			preparedStatement.execute();
		}
		catch(Exception ex)
		{
			System.out.println("Error: " + ex);
		}
		main.BasicFunctionMenu();
	}
	public void MakeUserLeagueOwner()
	{
		try
		{
			System.out.println("Enter UserID to change Role type to League Owner:");
			String userIDToMakeLeagueOwner = scanner.nextLine();

			String makeUserLeagueOwnerQuery = "UPDATE users SET userRoleID = 1  WHERE userID = "+ userIDToMakeLeagueOwner + " and userRoleID = 4 ";

			PreparedStatement preparedStatement = connection.prepareStatement(makeUserLeagueOwnerQuery);
			preparedStatement.execute();
		}
		catch(Exception ex)
		{
			System.out.println("Error: " + ex);
		}
		main.BasicFunctionMenu();
	}
	public void MakeUserAdvertiser()
	{
		try
		{
			System.out.println("Enter UserID to change Role type to Advertiser:");
			String userIDToMakeAdvertiser = scanner.nextLine();

			String makeUserAdvertiserQuery = "UPDATE users SET userRoleID = 2  WHERE userID = "+ userIDToMakeAdvertiser + " and userRoleID = 4 ";

			PreparedStatement preparedStatement = connection.prepareStatement(makeUserAdvertiserQuery);
			preparedStatement.execute();
		}
		catch(Exception ex)
		{
			System.out.println("Error: " + ex);
		}
		main.BasicFunctionMenu();
	}
	public void makeUserPlayer()
	{
		try
		{
			System.out.println("Enter UserID to change Role type to Player:");
			String userIDToMakePlayer = scanner.nextLine();

			String makeUserPlayerQuery = "UPDATE users SET userRoleID = 3  WHERE userID = "+ userIDToMakePlayer + " and userRoleID = 4 ";

			PreparedStatement preparedStatement = connection.prepareStatement(makeUserPlayerQuery);
			preparedStatement.execute();
		}
		catch(Exception ex)
		{
			System.out.println("Error: " + ex);
		}
		main.BasicFunctionMenu();
	}

	public void createExpertRatingFormula()
	{
		String createExpertRatingFormulaQuery = "INSERT INTO expertratingformula (ExpertRatingFormulaFormula) VALUES (?)";
		try
		{
			System.out.println("Enter New Formula");
			String Formula = scanner.nextLine();

			PreparedStatement preparedStatement = connection.prepareStatement(createExpertRatingFormulaQuery);
			preparedStatement.setString(1, Formula);

			preparedStatement.execute();
		}
		catch(Exception ex)
		{
				System.out.println("Error: " + ex);
		}

		main.BasicFunctionMenu();
	}
	public void getALLExpertRatingFormula(boolean ReturnToMenu)
	{
		String getAllExpertRatingFormulaQuery = "SELECT * FROM expertratingformula";
		try
		{
			resultSet = statement.executeQuery(getAllExpertRatingFormulaQuery);
			while(resultSet.next())
			{
				String eRFID = resultSet.getString("ExpertRatingFormulaID");
				String eRFName = resultSet.getString("ExpertRatingFormulaFormula");

				System.out.println("ER Formula ID: " + eRFID + " - " + eRFName);
			}
		}
		catch(Exception ex)
		{
			System.out.println("Error: " + ex);
		}
		if(ReturnToMenu)
		{
			main.BasicFunctionMenu();
		}
	}

	public void GetAllLeagues(boolean ReturnToMenu)
	{
		String getLeaguesQuery = "SELECT League1.*, Users1.userName, Arena1.ArenaName "
				+ "FROM league League1, users Users1, arena Arena1 "
				+ "WHERE Users1.userID = League1.users_userID AND Arena1.ArenaID = League1.arena_ArenaID";
		try
		{
			resultSet = statement.executeQuery(getLeaguesQuery);
			while(resultSet.next())
			{
				String leagueId = resultSet.getString("LeagueID");
				String leagueName = resultSet.getString("LeagueName");
				String eRFID = resultSet.getString("ExpertRatingFormula_ExpertRatingFormulaID");
				String leagueOwnerID = resultSet.getString("users_userID");
				String arenaID = resultSet.getString("arena_ArenaID");

				String leagueOwnerName = resultSet.getString("userName");
				String arenaName = resultSet.getString("ArenaName");

				System.out.println("Arena ID: " + arenaID + "- " + arenaName + "| League ID: " + leagueId + " - " + leagueName);
				System.out.println("\t" + "League Owner ID: " + leagueOwnerID + " - " + leagueOwnerName);
				System.out.println("\t" + "Expert Rating Formula: " + eRFID);
			}
		}
		catch(Exception ex)
		{
			System.out.println("Error: " + ex);
		}
		if(ReturnToMenu)
		{
			main.BasicFunctionMenu();
		}
	}
	public void createNewLeague()
	{
		//LeagueID Auto Increments
		//LeagueName
		//ExpertRatingFormula_ExpertRatingFormulaID getALLExpertRatingFormula(false)
		//users_userID	getUsersInformation(false)
		//arena_ArenaID GetAllArenas(false)

		String createLeagueQuery = "INSERT INTO league (LeagueName, ExpertRatingFormula_ExpertRatingFormulaID, users_userID, arena_ArenaID) "
				+ "VALUES (?, ?, ?, ?)";
		try
		{
			// These methods modify the initial string values above
			System.out.println("Enter Values to create a New League");
			System.out.println("League Name: ");
			String leagueName = scanner.nextLine();
			getALLExpertRatingFormula(false);
			System.out.println("Select Expert Rating Formula ID: ");
			String eRFID = scanner.nextLine();
			getUsersInformation(false);
			System.out.println("Select User ID: ");
			String userID = scanner.nextLine();

			if (getUserRoleID(userID) != "1")
			{
				System.out.println("User is not a League Owner. Returing to Main Menu");
				main.BasicFunctionMenu();
			}

			GetAllArenas(false);
			System.out.println("Select Arena ID");
			String arenaID = scanner.nextLine();

			PreparedStatement preparedStatement = connection.prepareStatement(createLeagueQuery);
			preparedStatement.setString (1, leagueName);
			preparedStatement.setString (2, eRFID);
			preparedStatement.setString (3, userID);
			preparedStatement.setString (4, arenaID);

			preparedStatement.execute();
		}
		catch(Exception ex)
		{
			System.out.println("Error: " + ex);
		}
	}
	public void deleteLeague()
	{

	}
	public void ApplyToLeague()
	{

	}

	// Manipulation of Arenas
	public void GetAllArenas(boolean ReturnToMenu)
	{
		String getAllArenaQuery = "SELECT * FROM arena";
		try
		{
			resultSet = statement.executeQuery(getAllArenaQuery);
			while(resultSet.next())
			{
				String arenaID = resultSet.getString("ArenaID");
				String arenaName = resultSet.getString("ArenaName");

				System.out.println("Arena ID: " + arenaID + " - " + arenaName);
			}
		}
		catch(Exception ex)
		{
			System.out.println("Error: " + ex);
		}

		if (ReturnToMenu)
		{
			main.BasicFunctionMenu();
		}
	}
	public void CreateArena()
	{
		GetAllArenas(false);

		String arenaName = null;
		String CreateArenaQuery = "INSERT INTO arena (ArenaName) VALUES (?)";
		try
		{
			System.out.println("Enter Name of Arena");
			arenaName = scanner.nextLine();

			PreparedStatement preparedStatement = connection.prepareStatement(CreateArenaQuery);
			preparedStatement.setString(1, arenaName);

			preparedStatement.execute();
		}
		catch(Exception ex)
		{
			System.out.println("Error: " + ex);
		}
		main.BasicFunctionMenu();
	}
	public void DeleteArena()
	{
		GetAllArenas(false);
		try
		{
			System.out.println("Enter Name of Arena to Delete");
			String arenaName = scanner.nextLine();

			String deleteArenaQuery = "DELETE FROM arena WHERE ArenaID = " + arenaName;

			PreparedStatement preparedStatement = connection.prepareStatement(deleteArenaQuery);
			preparedStatement.execute();
		}
		catch(Exception ex)
		{
			System.out.println("Error: " + ex);
		}
		main.BasicFunctionMenu();
	}

	// Manipulation of Games
	public void createGame()
	{
		// Initialize relevant strings
		String gameName = null;
		String gameDesc = null;

		// This is the base sql Query statement
		String newGameQuery = "INSERT INTO game (GameName, GameDescription) Values (?,?)";
		try
		{
			// These methods modify the initial string values above
			System.out.println("Please enter Game Info Values");
			System.out.println("Game Name: ");
			gameName = scanner.nextLine();
			System.out.println("Game Desc: ");
			gameDesc = scanner.nextLine();

			//
			PreparedStatement preparedStatement = connection.prepareStatement(newGameQuery);
			preparedStatement.setString (1, gameName);
			preparedStatement.setString (2, gameDesc);

			preparedStatement.execute();
		}
		catch(Exception ex)
		{
			System.out.println("Error: " + ex);
		}
		main.BasicFunctionMenu();
	}
	public void GetALLGameScores()
	{
		try
		{

		}
		catch(Exception ex)
		{
			System.out.println("Error: " + ex);
		}
	}
	public void AddGameScores()
	{

	}
	public void UpdateGameScores()
	{

	}

	public void GetAllGames(boolean ReturnToMenu)
	{
		String query = "SELECT * FROM game";
		try
		{
			resultSet = statement.executeQuery(query);
			System.out.println("Users");
			while(resultSet.next())
			{

				String gameid = resultSet.getString("GameID");
				String gameName = resultSet.getString("GameName");
				String gameDesc = resultSet.getString("GameDescription");

				System.out.println("Game ID: " + gameid + " " + gameName + ": " + gameDesc);
			}
		}
		catch(Exception ex)
		{
			System.out.println("Error: " + ex);
		}

		if(ReturnToMenu)
		{
			main.BasicFunctionMenu();
		}
	}
	public void DeleteGame()
	{
		try
		{
			GetAllGames(false);
			System.out.println("Please enter the GameID you wish to delete:");
			String deleteGameID = scanner.nextLine();
			String deleteGameQuery = "DELETE FROM game WHERE GameID = " + deleteGameID;

			PreparedStatement preparedStatement = connection.prepareStatement(deleteGameQuery);
			preparedStatement.execute();
		}
		catch(Exception ex)
		{
			System.out.println("Error: " + ex);
		}
		main.BasicFunctionMenu();
	}


}
