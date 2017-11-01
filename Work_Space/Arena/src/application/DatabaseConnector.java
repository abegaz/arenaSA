package application;

import java.sql.*;
import java.util.Scanner;
import application.Main;

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

	Main main = new Main();
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
	//Gets roleID from UserID
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
	//Gets roleName from UserID
	public String getUserRoleName(String userID)
	{
		String getUserRoleNameQuery = "SELECT userroletype1.userRoleTypeName "
				+ "FROM users users1, userroletype userroletype1 "
				+ "WHERE users1.userID = " + userID +" and users1.userRoleID = userroletype1.userroleTypeID";
		String userRoleName = "";
		try
		{
			resultSet = statement.executeQuery(getUserRoleNameQuery);
			while(resultSet.next())
			{
				userRoleName = resultSet.getString("userRoleTypeName");
			}
		}
		catch(Exception ex)
		{
			System.out.println("Error: " + ex);
		}
		return userRoleName;
	}
	//Creates a New User that auto assigns a spectator role type
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
	//Deletes User from the Database
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
	public void makeUserPlayer(String userID)
	{
		try
		{
			String makeUserPlayerQuery = "UPDATE users SET userRoleID = 3  WHERE userID = "+ userID + " and userRoleID = 4 ";

			PreparedStatement preparedStatement = connection.prepareStatement(makeUserPlayerQuery);
			preparedStatement.execute();
		}
		catch(Exception ex)
		{
			System.out.println("Error: " + ex);
		}
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

				System.out.println("League ID: " + leagueId + " - " + leagueName);
				System.out.println("\t" + "Arena ID: " + arenaID + "- " + arenaName);
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


			 int userRoleIDInt = Integer.parseInt(getUserRoleID(userID));

			 if (userRoleIDInt == 1)
			 {
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
			 else
			 {
				 System.out.println("User is not a League Owner. Returing to Main Menu");
				 main.BasicFunctionMenu();
			 }
		}
		catch(Exception ex)
		{
			System.out.println("Error: " + ex);
		}
		main.BasicFunctionMenu();
	}
	public void deleteLeague()
	{
		GetAllLeagues(false);
		try
		{
			System.out.println("Enter League ID to delete");
			String leagueID = scanner.nextLine();
			String deleteLeagueQuery = "DELETE FROM league where LeagueID = " + leagueID;

			PreparedStatement preparedStatement = connection.prepareStatement(deleteLeagueQuery);
			preparedStatement.execute();
		}
		catch(Exception ex)
		{
			System.out.println("Error: " + ex);
		}
		main.BasicFunctionMenu();
	}

	public void ApplyUserToLeague()
	{
		try
		{
			String applyUserToLeagueQuery = "INSERT INTO leaguemembers (League_LeagueID, MembershipStatusCode_MembershipStatusCodeID, users_userID)"
					+ " VALUES (?, ?, ?)";

			GetAllLeagues(false);
			System.out.println("League ID: ");
			String leagueID = scanner.nextLine();

			getUsersInformation(false);
			System.out.println("User ID");
			String userID = scanner.nextLine();
			int userRoleIDInt = Integer.parseInt(getUserRoleID(userID));

			if (userRoleIDInt == 3)
			{
				PreparedStatement preparedStatement = connection.prepareStatement(applyUserToLeagueQuery);
				preparedStatement.setString (1, leagueID);
				preparedStatement.setString (2, "30002");
				preparedStatement.setString (3, userID);
				preparedStatement.execute();
			}
			else
			{
				System.out.println("User is not a Player. Returing to Main Menu");
				 main.BasicFunctionMenu();
			}
		}
		catch(Exception ex)
		{
			System.out.println("Error: " + ex);
		}
		main.BasicFunctionMenu();
	}
	public void ApplyUserToArena()
	{
		String applyUserToArenaQuery = "INSERT INTO arenamembers (arena_ArenaID, users_userID)"
				+ " VALUES (?, ?)";
		try
		{
			GetAllArenas(false);
			System.out.println("Arena ID: ");
			String arenaID = scanner.nextLine();

			getUsersInformation(false);
			System.out.println("User ID");
			String userID = scanner.nextLine();

			int userRoleIDInt = Integer.parseInt(getUserRoleID(userID));

			if (userRoleIDInt == 4)
			{
				makeUserPlayer(userID);
			}
			if (userRoleIDInt == 3)
			{
				PreparedStatement preparedStatement = connection.prepareStatement(applyUserToArenaQuery);
				preparedStatement.setString (1, arenaID);
				preparedStatement.setString (2, userID);
				preparedStatement.execute();
			}
			else
			{
				System.out.println("False");
				System.out.println("User is not a Player. User is a " + getUserRoleName(userID) + "Returing to Main Menu");
				main.BasicFunctionMenu();
			}
		}
		catch(Exception ex)
		{
			System.out.println("Error: " + ex);
		}
		main.BasicFunctionMenu();
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

	public void createTournament()
	{

	}
	public void deleteTournament()
	{

	}
	public void createMatch()
	{

	}
	public void cancelMatch()
	{

	}
	public void delayMatch()
	{

	}
	public void removeUserFromLeague()
	{

	}
	public void removeUserFromArena()
	{

	}
	public void GetAllUsersOfArena()
	{

	}
	public void GetAllUsersOfLeague()
	{

	}
	public void GetALLGameScores()
	{

	}
	public void AddGameScores()
	{

	}
	public void UpdateGameScores()
	{

	}
}
