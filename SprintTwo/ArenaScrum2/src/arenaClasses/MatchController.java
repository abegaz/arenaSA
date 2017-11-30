package arenaClasses;

import java.io.IOException;

import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ResourceBundle;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXDatePicker;
import com.jfoenix.controls.JFXTextField;
import com.jfoenix.controls.JFXTimePicker;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import arenaClasses.DBHandler;
import arenaModels.MatchData;

public class MatchController extends Main implements Initializable{
//View references from MatchMaker.fxml
/*********************************************************/
@FXML
private JFXTextField teamID1;
@FXML
private JFXTextField teamID2;
@FXML
private JFXTextField gameID;
@FXML
private JFXTimePicker matchTimePicker;
@FXML
private JFXDatePicker matchDatePicker;
@FXML
private JFXComboBox<String> selectTeamComboBox1;
@FXML
private JFXComboBox<String> selectTeamComboBox2;
@FXML
private JFXComboBox<String> selectGameComboBox;
@FXML
private JFXComboBox<String> selectLeagueComboBox;
@FXML
private JFXComboBox<String> selectTournamentComboBox;
/********************************************************/
//View Attributes for teamsPage View
@FXML
 private Label closeIcon;
 @FXML
 private JFXButton teamsGoBack;
 @FXML
 private JFXButton matchCreateButton;
 @FXML
 private JFXButton teamsRefreshButton;
 @FXML
 private JFXButton pendingRemoveButton;
 @FXML
 private TableView<TeamsTableViewController> teamsTable;
 @FXML
 private TableColumn<TeamsTableViewController, Integer> teamsColumnTeamID;
 @FXML
 private TableColumn<TeamsTableViewController, String> teamsColumnTeamName;
 @FXML
 private JFXButton teamAppGoBack;
 @FXML
 private JFXButton teamAppSendApp;
 @FXML
 private JFXComboBox<String> teamAppComboBox;
 @FXML
 private JFXButton teamAppRefresh;
 @FXML
 private Label errorLabelTeamApp;
 @FXML
 private Label successLabelTeamApp;
 @FXML
 private TableView<loPlayerAppTable> loPlayersAppTable;
 @FXML
 private TableColumn<loPlayerAppTable, Integer> loPlayerAppColumnUserID;
 @FXML
 private TableColumn<loPlayerAppTable, String> loPlayerAppColumnCurrTeam;
 @FXML
 private TableColumn<loPlayerAppTable, String> loPlayerAppDesiredTeam;
 @FXML
 private TableColumn<loPlayerAppTable, String> loPlayerAppColumnUserName;
 @FXML
 private JFXButton loPlayerAppApprove;
 @FXML
 private JFXButton loPlayerAppRefresh;
 @FXML
 private JFXButton loPlayerAppRemove;
 @FXML
 private JFXButton leagueOwnerGoToManageMatch;

 @FXML private TableView<MatchData> matchTable;
 @FXML private TableColumn<MatchData, String> matchColumnMatchID;
 @FXML private TableColumn<MatchData, String> matchColumnGameName;
 @FXML private TableColumn<MatchData, String> matchColumnLeagueName;
 @FXML private TableColumn<MatchData, String> matchColumnTournamentName;
 @FXML private TableColumn<MatchData, String> matchColumnTeam1;
 @FXML private TableColumn<MatchData, String> matchColumnTeam2;
 @FXML private TableColumn<MatchData, String> matchColumnWinner;
 @FXML private TableColumn<MatchData, String> matchColumnLoser;
 @FXML private TableColumn<MatchData, String> matchColumnStatus;
 @FXML private TableColumn<MatchData, String> matchColumnDate;
 @FXML private Label loadMe;

 @FXML
 private JFXButton teamsRemoveButton;
//Method Attributes
 ResultSet rs3,rs4,rs5;
 Scene scene;
 Stage stage = new Stage();
 private ObservableList<MatchData> matchData;
 private ObservableList<TeamsTableViewController>data;
 private ObservableList<loPlayerAppTable>data5;
 private PreparedStatement pstTwo;
 Connection myConnection;
 static int currTeamID,selectedteamID;
 static String currTeamName;
//-------------------------------------end_of_attributes----------------------------------------------------------------------
//'X' Label Functionality
@FXML
private void closeApplication(MouseEvent event)
 {
     System.exit(0);
 }
//Go Back Button Functionality
@FXML
private void goToLOLanding(ActionEvent event) throws Exception
 {
 	teamsGoBack.getScene().getWindow().hide();
     loader.setLocation(getClass().getResource("/arenaViews/leagueOwnerLanding.fxml"));
     scene = new Scene(loader.load());
     stage.setScene(scene);
     stage.setResizable(false);
     stage.getIcons().add(new Image(getClass().getResourceAsStream("/images/arenaIcon.png")));
     stage.setTitle("Arena");
     stage.show();
 }
//Initialize teamsToComboBox
@Override
public void initialize(URL location, ResourceBundle resources)
   {
   	try
   	{		//load teams to comboboxes for team 1 and 2
			teamsToComboBox1();
			teamsToComboBox2();
			//load leagues to combo box
			leaguesToComboBox();
			//load tournaments to combo box
			tournamentsToComboBox();
			//load games to combo box
			gamesToComboBox();
   		System.out.println("");
		}
   	catch (Exception e)
   	{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
//Teams Refresh Button Functionality
@FXML
private void usersToTableView(ActionEvent event) throws SQLException
 {
 	Connection connection = DBHandler.getConnection();

	matchData = FXCollections.observableArrayList();
	// Execute query and store results
	String getMatchDataQuery = "SELECT * FROM arenadatabase.matches";
	try
	{
		ResultSet rs = connection.createStatement().executeQuery(getMatchDataQuery);
		while (rs.next())
		{
			String matchID = rs.getString("MatchID");
			String gameName = getGameName(rs.getString("Game_GameID"));
			String leagueName = getLeaugeNameWithTournamnetID(rs.getString("Tournament_TournamentID"));
			String tournamentName = getTournamentNameWithTournamentID(rs.getString("Tournament_TournamentID"));
			String team1Name = getTeamNameWithTeamID(rs.getString("teams_TeamID1"));
			String team2Name = getTeamNameWithTeamID(rs.getString("teams_TeamID2"));
			String matchWinner = rs.getString("OutcomeWin_UserID");
			String matchLosser = rs.getString("OutcomeLoss_UserID");
			String matchStatus = getStatusNameWithStatusID(rs.getString("MatchStatus_MatchStatusID"));
			String matchDate = rs.getString("matchDate");

			matchData.add(new MatchData(
					matchID,
					gameName,
					leagueName,
					tournamentName,
					team1Name,
					team2Name,
					matchWinner,
					matchLosser,
					matchStatus,
					matchDate));
		}

		matchColumnMatchID.setCellValueFactory(new PropertyValueFactory<>("matchID"));
		matchColumnGameName.setCellValueFactory(new PropertyValueFactory<>("gameName"));
		matchColumnLeagueName.setCellValueFactory(new PropertyValueFactory<>("leagueName"));
		matchColumnTournamentName.setCellValueFactory(new PropertyValueFactory<>("tournamentName"));
		matchColumnTeam1.setCellValueFactory(new PropertyValueFactory<>("team1Name"));
		matchColumnTeam2.setCellValueFactory(new PropertyValueFactory<>("team2Name"));
		matchColumnWinner.setCellValueFactory(new PropertyValueFactory<>("matchWinner"));
		matchColumnLoser.setCellValueFactory(new PropertyValueFactory<>("matchLosser"));
		matchColumnStatus.setCellValueFactory(new PropertyValueFactory<>("matchStatus"));
		matchColumnDate.setCellValueFactory(new PropertyValueFactory<>("matchDate"));

		matchTable.setItems(null);
		matchTable.setItems(matchData);
	}
	catch(Exception ex)
	{
		ex.printStackTrace();
		System.out.println("Error: " + ex);
	}
 }
//Teams Remove Button Functionality
@FXML
private void teamsRemoveUser(ActionEvent event) throws SQLException
 {
     Connection myConnection = DBHandler.getConnection();
     TeamsTableViewController userData = teamsTable.getSelectionModel().getSelectedItem();
     int selectedteamID = userData.getTeamID();
     String sqlUpdateThree = "DELETE FROM arenadatabase.teams WHERE teams.teamID ="+selectedteamID+"";
     try
     {
     	pstTwo = myConnection.prepareStatement(sqlUpdateThree);
     	pstTwo.execute(sqlUpdateThree);
     	System.out.println("worked");
     	justDousersToTableView();
     }
     catch(SQLException e)
     {
         e.printStackTrace();
         System.out.println("ERROR @ TeamsControl.teamsRemoveUser");
     }

     finally
     {
     	myConnection.close();
     }
     }
//Teams Just Do. Refresh
private void justDousersToTableView() throws SQLException
 {
 	Connection myConnection = DBHandler.getConnection();
 	data = FXCollections.observableArrayList();
 	try
 	{
 		ResultSet rs2 = myConnection.createStatement().executeQuery("SELECT teamID,teamName FROM arenadatabase.teams");
 		while(rs2.next())
 		{
 			data.add(new TeamsTableViewController(rs2.getInt("teamID"),rs2.getString("teamName"), null));
 		}
 	}
 	catch(SQLException e)
 	{
 		e.printStackTrace();
 		System.out.println("ERROR @ TeamsController.usersToTableView");
 	}
 	teamsColumnTeamID.setCellValueFactory(new PropertyValueFactory<>("teamID"));
 	teamsColumnTeamName.setCellValueFactory(new PropertyValueFactory<>("teamName"));
 	teamsTable.setItems(data);
 }
//Player Landing Page Go Back Button
 @FXML
 private void goBacktoPlayerLanding(ActionEvent event) throws Exception {
 	teamAppGoBack.getScene().getWindow().hide();
     loader.setLocation(getClass().getResource("/arenaViews/playerLanding.fxml"));
     scene = new Scene(loader.load());
     stage.setScene(scene);
     stage.setResizable(false);
     stage.getIcons().add(new Image(getClass().getResourceAsStream("/images/arenaIcon.png")));
     stage.setTitle("Arena");
     stage.show();
     }
//Player Team App Apply Button Functionality
@FXML
private void sendTeamApp(ActionEvent event) throws Exception{
 	myConnection = DBHandler.getConnection();
 	String check = "SELECT userTeamID FROM users WHERE userID ="+Controller.currUserID;
		String insert = "INSERT INTO teamspending(appUserID,appUserName,desired_teamName,desired_teamID,current_teamName)"+ "VALUES (?,?,?,?,?)";
     TeamsTableViewController userData = teamsTable.getSelectionModel().getSelectedItem();
     selectedteamID = userData.getTeamID();
     System.out.println("Selected team: "+selectedteamID );
     String check2 ="SELECT teamName FROM teams WHERE teamID ="+selectedteamID ;
     String selectedteamName = userData.getTeamName();
 	try
 	{
 		PreparedStatement preparedStatement = myConnection.prepareStatement(check);
		rs3 = preparedStatement.executeQuery(check);
 		rs3.first();
 		currTeamID = rs3.getInt("userTeamID");
 		}
 	catch(SQLException e)
 	{
 		e.printStackTrace();
 		System.out.println("ERROR @ TeamsController.sendTeamApp/Check");
 		}
 	try {
 		PreparedStatement pst = myConnection.prepareStatement(check2);
 		rs4 = pst.executeQuery(check2);
 		rs4.first();
 		currTeamName = rs4.getString("teamName");
 	}
 	catch(SQLException e) {
 		e.printStackTrace();
 		System.out.println("ERROR @ TeamsController.sendTeamApp/GetCurrentTeamName");
 	}


 	// Already Exist
 	if(currTeamID == selectedteamID) {
 		 errorLabelTeamApp.setVisible(true);
 		 successLabelTeamApp.setVisible(false);
 	}
 	// DOES NOT Already Exist
 	if(currTeamID != selectedteamID) {
		 errorLabelTeamApp.setVisible(false);
		 successLabelTeamApp.setVisible(true);
		 PreparedStatement pst = myConnection.prepareStatement(insert);
		 pst.setInt (1, Controller.currUserID);
		 pst.setString (2, Controller.currName);
		 pst.setString(3, selectedteamName);
		 pst.setInt(4, selectedteamID);
		 pst.setString(5, currTeamName);
		 pst.execute();
 	}
 }
//League Owners Pending Player Team Applications Refresh
@FXML
private void usersToTableViewPendingTeamApps(ActionEvent event) throws SQLException
 {
 	myConnection = DBHandler.getConnection();
 	data5 = FXCollections.observableArrayList();
 	try
 	{
 		rs5 = myConnection.createStatement().executeQuery("SELECT * FROM teamspending");
 		while(rs5.next())
 		{
 			data5.add(new loPlayerAppTable(rs5.getInt("appUserID"),null, rs5.getString("appUserName"),rs5.getString("desired_teamName"), rs5.getString("current_teamName")));
 			System.out.println("Data2 contents: "+data5);
 			System.out.println(data5);
 		}
 	}
 	catch(SQLException e)
 	{
 		e.printStackTrace();
 		System.out.println("ERROR @ TeamsController.usersToTableViewPendingTeamApps");
 	}
 	loPlayerAppColumnUserID.setCellValueFactory(new PropertyValueFactory<>("appUserID"));
 	loPlayerAppColumnUserName.setCellValueFactory(new PropertyValueFactory<>("appUserName"));
 	loPlayerAppColumnCurrTeam.setCellValueFactory(new PropertyValueFactory<>("desired_teamName"));
 	loPlayerAppDesiredTeam.setCellValueFactory(new PropertyValueFactory<>("current_teamName"));
	loPlayersAppTable.setItems(data5);
 }
//get game id from game name combobox
public String getGameID(String GameName) throws SQLException
{
	String GameID = null;
	Connection connection = DBHandler.getConnection();
	String getGameIDQuery = "SELECT GameID FROM game WHERE GameName='" + GameName +"'";

	try
	{
		ResultSet rs = connection.createStatement().executeQuery(getGameIDQuery);
		while(rs.next())
		{
			GameID= rs.getString("GameID");
			return GameID;
		}

	}
	catch (SQLException e)
	{
		e.printStackTrace();
		return null;
	}
	return null;
}
//get tournament id from tournament name combo box
public String getTournamentID(String TournamentName) throws SQLException
{
	String TournamentID = null;
	System.out.println(TournamentName);
	Connection connection = DBHandler.getConnection();
	String getTournamentIDQuery = "SELECT TournamentID FROM tournament WHERE TournamentName='" + TournamentName +"'";

	try
	{
		ResultSet rs = connection.createStatement().executeQuery(getTournamentIDQuery);
		while(rs.next())
		{
			TournamentID= rs.getString("TournamentID");
			return TournamentID;
		}

	}
	catch (SQLException e)
	{
		e.printStackTrace();
		return null;
	}
	return null;
}
//get league id from league name combo box
public String getLeagueID(String LeagueName) throws SQLException
{
	String LeagueID = null;
	System.out.println(LeagueName);
	Connection connection = DBHandler.getConnection();
	String getLeagueIDQuery = "SELECT LeagueID FROM league WHERE LeagueName='" + LeagueName +"'";

	try
	{
		ResultSet rs = connection.createStatement().executeQuery(getLeagueIDQuery);
		while(rs.next())
		{
			LeagueID= rs.getString("LeagueID");
			return LeagueID;
		}

	}
	catch (SQLException e)
	{
		e.printStackTrace();
		return null;
	}
	return null;
}
//get team1 id from team name combo box
public String getTeam1ID(String Team1Name) throws SQLException
{
	String Team1ID = null;
	System.out.println(Team1Name);
	Connection connection = DBHandler.getConnection();
	String getTeam1IDQuery = "SELECT TeamID FROM teams WHERE TeamName='" + Team1Name +"'";

	try
	{
		ResultSet rs = connection.createStatement().executeQuery(getTeam1IDQuery);
		while(rs.next())
		{
			Team1ID= rs.getString("TeamID");
			return Team1ID;
		}

	}
	catch (SQLException e)
	{
		e.printStackTrace();
		return null;
	}
	return null;
}
//get team2 id from team name combo box
public String getTeam2ID(String Team2Name) throws SQLException
{
	String Team2ID = null;
	Connection connection = DBHandler.getConnection();
	String getTeam2IDQuery = "SELECT TeamID FROM teams WHERE TeamName='" + Team2Name +"'";

	try
	{
		ResultSet rs = connection.createStatement().executeQuery(getTeam2IDQuery);
		while(rs.next())
		{
			Team2ID = rs.getString("TeamID");
			return Team2ID;
		}

	}
	catch (SQLException e)
	{
		e.printStackTrace();
		return null;
	}
	return null;
}
//Add Match

public String getGameName(String gameID) throws SQLException
{
	String gameName = null;
	Connection connection = DBHandler.getConnection();
	String getGameNameQuery = "SELECT GameName FROM game WHERE GameID='" + gameID +"'";

	try
	{
		ResultSet rs = connection.createStatement().executeQuery(getGameNameQuery);
		while(rs.next())
		{
			gameName= rs.getString("GameName");
			return gameName;
		}

	}
	catch (SQLException e)
	{
		e.printStackTrace();
		return null;
	}
	return null;
}
public String getTournamentNameWithTournamentID(String tounamentID) throws SQLException
{
	String TournamentName = null;
	Connection connection = DBHandler.getConnection();
	String getTournamentNameQuery = "SELECT TournamentName FROM tournament WHERE TournamentID = '" + tounamentID +"'";

	try
	{
		ResultSet rs = connection.createStatement().executeQuery(getTournamentNameQuery);
		while(rs.next())
		{
			TournamentName= rs.getString("TournamentName");
			return TournamentName;
		}

	}
	catch (SQLException e)
	{
		e.printStackTrace();
		return null;
	}
	return null;
}
public String getTeamNameWithTeamID(String teamID) throws SQLException
{
	String TeamName = null;
	Connection connection = DBHandler.getConnection();
	String getTeamNameQuery = "SELECT TeamName FROM teams WHERE TeamID='" + teamID +"'";

	try
	{
		ResultSet rs = connection.createStatement().executeQuery(getTeamNameQuery);
		while(rs.next())
		{
			TeamName= rs.getString("TeamName");
			return TeamName;
		}

	}
	catch (SQLException e)
	{
		e.printStackTrace();
		return null;
	}
	return null;
}
public String getLeaugeNameWithTournamnetID(String tournamentID) throws SQLException
{
	String leagueName = null;
	Connection connection = DBHandler.getConnection();
	String getLeagueNameQuery = "SELECT `LeagueName` FROM league , tournament WHERE `LeagueID` = tournament.League_LeagueID AND tournament.TournamentID = '" + tournamentID +"'";

	try
	{
		ResultSet rs = connection.createStatement().executeQuery(getLeagueNameQuery);
		while(rs.next())
		{
			leagueName= rs.getString("LeagueName");
			return leagueName;
		}

	}
	catch (SQLException e)
	{
		e.printStackTrace();
		return null;
	}
	return null;
}
public String getStatusNameWithStatusID(String statusID) throws SQLException
{
	String StatusName = null;
	Connection connection = DBHandler.getConnection();
	String getStatusNameQuery = "SELECT MatchStatusName FROM matchstatus WHERE MatchStatusID =  '" + statusID +"'";

	try
	{
		ResultSet rs = connection.createStatement().executeQuery(getStatusNameQuery);
		while(rs.next())
		{
			StatusName= rs.getString("MatchStatusName");
			return StatusName;
		}

	}
	catch (SQLException e)
	{
		e.printStackTrace();
		return null;
	}
	return null;
}












@FXML
private void addMatch(ActionEvent event) throws SQLException, IOException
 {
	myConnection = DBHandler.getConnection();
	LocalDate date = matchDatePicker.getValue();
	LocalTime time = matchTimePicker.getValue();
	String matchTime = date + " " +time + ":00";
	String matchGame = selectGameComboBox.getValue();
	int GameID = Integer.parseInt(getGameID(matchGame));
	String matchTournament = selectTournamentComboBox.getValue();
	int TournamentID = Integer.parseInt(getTournamentID(matchTournament));
	String matchLeague = selectLeagueComboBox.getValue();
	int LeagueID = Integer.parseInt(getLeagueID(matchLeague));
	String matchTeam1 = selectTeamComboBox1.getValue();
	int matchTeam1ID = Integer.parseInt(getTeam1ID(matchTeam1));
	System.out.println(matchTeam1);
	String matchTeam2 = selectTeamComboBox2.getValue();
	int matchTeam2ID = Integer.parseInt(getTeam2ID(matchTeam2));

	System.out.println(GameID);
	System.out.println(TournamentID);
	System.out.println(LeagueID);
	System.out.println(matchTeam2ID);
	System.out.println(matchTeam1ID);
	System.out.println(matchTime);
 	myConnection = DBHandler.getConnection();
 	String addMatch = "INSERT INTO arenadatabase.matches (Game_GameID,Tournament_TournamentID,MatchStatus_MatchStatusID, matchDate,teams_TeamID2,teams_TeamID1)"+ "VALUES (?,?,?,?,?,?)";
 	try
 	{
 		PreparedStatement preparedStatement = myConnection.prepareStatement(addMatch);
 		preparedStatement.setInt (1, GameID);
 		preparedStatement.setInt(2, TournamentID);
 		preparedStatement.setInt(3, 0);
 		preparedStatement.setTimestamp(4, java.sql.Timestamp.valueOf(matchTime));
 		preparedStatement.setInt(5, matchTeam2ID);
 		preparedStatement.setInt(6, matchTeam1ID);
 		//System.out.println(preparedStatement);
 		preparedStatement.execute();
 		}
 	catch(SQLException e)
 	{
 		e.printStackTrace();
 		System.out.println("ERROR @ MatchController.addMatch");
 		}
 	finally {
 		myConnection.close();
 	}
 	}
private void teamsToComboBox1() throws SQLException
{
	Connection connection = DBHandler.getConnection();
	String teamsNames = "SELECT TeamName FROM arenadatabase.teams";
	ObservableList<String> teamsList = FXCollections.observableArrayList();
	try
	{
		ResultSet rs = connection.createStatement().executeQuery(teamsNames);
		while (rs.next())
		{
			teamsList.add(rs.getString("TeamName"));
		}
		selectTeamComboBox1.setItems(teamsList);
	}
	catch(SQLException e)
	{
		e.printStackTrace();
		System.out.println("ERROR @ Control.removeUser.First Try");
	}

}
private void teamsToComboBox2() throws SQLException
{
	Connection connection = DBHandler.getConnection();
	String teamsNames = "SELECT TeamName FROM arenadatabase.teams";
	ObservableList<String> teamsList = FXCollections.observableArrayList();
	try
	{
		ResultSet rs = connection.createStatement().executeQuery(teamsNames);
		while (rs.next())
		{
			teamsList.add(rs.getString("TeamName"));
		}
		selectTeamComboBox2.setItems(teamsList);
	}
	catch(SQLException e)
	{
		e.printStackTrace();
		System.out.println("ERROR @ Control.removeUser.First Try");
	}

}
private void tournamentsToComboBox() throws SQLException
{
	Connection connection = DBHandler.getConnection();
	String tournamentsNames = "SELECT TournamentName FROM arenadatabase.tournament";
	ObservableList<String> tournamentsList = FXCollections.observableArrayList();
	try
	{
		ResultSet rs = connection.createStatement().executeQuery(tournamentsNames);
		while (rs.next())
		{
			tournamentsList.add(rs.getString("TournamentName"));
		}
		selectTournamentComboBox.setItems(tournamentsList);
	}
	catch(SQLException e)
	{
		e.printStackTrace();
		System.out.println("ERROR @ Control.removeUser.First Try");
	}

}
private void leaguesToComboBox() throws SQLException
{
	Connection connection = DBHandler.getConnection();
	String leaguesNames = "SELECT LeagueName FROM arenadatabase.league";
	ObservableList<String> leaguesList = FXCollections.observableArrayList();
	try
	{
		ResultSet rs = connection.createStatement().executeQuery(leaguesNames);
		while (rs.next())
		{
			leaguesList.add(rs.getString("LeagueName"));
		}
		selectLeagueComboBox.setItems(leaguesList);
	}
	catch(SQLException e)
	{
		e.printStackTrace();
		System.out.println("ERROR @ Control.removeUser.First Try");
	}

}
private void gamesToComboBox() throws SQLException
{
	Connection connection = DBHandler.getConnection();
	String gamesNames = "SELECT GameName FROM arenadatabase.game";
	ObservableList<String> gamesList = FXCollections.observableArrayList();
	try
	{
		ResultSet rs = connection.createStatement().executeQuery(gamesNames);
		while (rs.next())
		{
			gamesList.add(rs.getString("GameName"));
		}
		selectGameComboBox.setItems(gamesList);
	}
	catch(SQLException e)
	{
		e.printStackTrace();
		System.out.println("ERROR @ Control.removeUser.First Try");
	}

}
}
