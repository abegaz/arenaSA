package arenaClasses;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXDatePicker;
import com.jfoenix.controls.JFXTextField;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class MatchController extends Main {
//Data sources from MatchMaker.fxml	
	/*********************************************************/
	 @FXML
	 private JFXTextField teamID1;
	 @FXML
	 private JFXTextField teamID2;
	 @FXML
	 private JFXTextField gameID;
	 @FXML
	 private JFXTextField dateTime;
	 @FXML
	 private JFXDatePicker matchDate;
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
 
//Method Attributes
 ResultSet rs3,rs4,rs5;
 Scene scene;
 Stage stage = new Stage();
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
     stage.initStyle(StageStyle.UNDECORATED);
     stage.setResizable(false);
     stage.getIcons().add(new Image(getClass().getResourceAsStream("/images/arenaIcon.png")));
     stage.setTitle("Arena");
     stage.show();
 }

//Teams Refresh Button Functionality
 @FXML
 private void usersToTableView(ActionEvent event) throws SQLException
 {
 	myConnection = DBHandler.getConnection();
 	data = FXCollections.observableArrayList();
 	try
 	{
 		ResultSet rs2 = myConnection.createStatement().executeQuery("SELECT teamID,teamName FROM arenadatabase.teams");
 		while(rs2.next())
 		{
 			data.add(new TeamsTableViewController(rs2.getInt("teamID"),rs2.getString("teamName")));
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
 			data.add(new TeamsTableViewController(rs2.getInt("teamID"),rs2.getString("teamName")));
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
     stage.initStyle(StageStyle.UNDECORATED);
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
 			data5.add(new loPlayerAppTable(rs5.getInt("appUserID"),rs5.getString("appUserName"),rs5.getString("desired_teamName"), rs5.getString("current_teamName")));
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
//Add Match
 @FXML
 private void addMatch(ActionEvent event) throws SQLException, IOException
 {
 	myConnection = DBHandler.getConnection();
 	String addMatch = "INSERT INTO match (MatchStatus_MatchStatusID,Game_GameID,Tournament_TournamentID,matchDate,teams_TeamID2,teams_TeamID1)"+ "VALUES (?,?,?,?,?,?)";
 	try
 	{
 		PreparedStatement preparedStatement = myConnection.prepareStatement(addMatch);
			preparedStatement.setString (1, "pending");
			preparedStatement.setInt(2, Integer.parseInt(gameID.getText()));
			preparedStatement.setInt(3, 2);
			preparedStatement.setTimestamp(4, java.sql.Timestamp.valueOf("2017-11-08 12:30:00"));
			preparedStatement.setInt(5, Integer.parseInt(teamID2.getText()));
			preparedStatement.setInt(6, Integer.parseInt(teamID1.getText()));
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

}
