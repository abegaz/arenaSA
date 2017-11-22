package arenaClasses;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
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
import arenaClasses.DBHandler;

public class TeamsController extends Main {

// View Attributes for teamsPage View
@FXML
private Label closeIcon;
@FXML
private JFXButton teamsGoBack;
@FXML
private JFXButton teamsCreateButton;
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
private TableColumn<TeamsTableViewController, Integer> teamsColumnTeamLeagueID;
@FXML
private JFXTextField teamsNameTextField;
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
private TableView<TeamsLOTable> LeaguesTableForTeams;
@FXML
private TableColumn<TeamsLOTable, Integer> columnLeagueIDForTeams;
@FXML
private TableColumn<TeamsLOTable, String> columnLeagueNameForTeams;
@FXML
private TableColumn<TeamsLOTable, String> columnLeagueDescriptionForTeams;
// Method Attributes
    ResultSet rs3,rs4,rs5,rs6,rs7;
    Scene scene;
    Stage stage = new Stage();
    private ObservableList<TeamsTableViewController>data2;
    private ObservableList<loPlayerAppTable>data5;
    private ObservableList<TeamsLOTable>data;
    private PreparedStatement pstTwo;
    Connection myConnection;
    static int currTeamID;
    static String currTeamName;
 
    

//-------------------------------------end_of_attributes----------------------------------------------------------------------
// 'X' Label Functionality
@FXML
private void closeApplication(MouseEvent event)
    {
        System.exit(0);
    }
// Go Back Button Functionality
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
// Add Team
@FXML
private void addTeam(ActionEvent event) throws SQLException, IOException
    {
    	myConnection = DBHandler.getConnection();
    	// TeamName, users_userID, league_LeagueID
        TeamsLOTable userData2 = LeaguesTableForTeams.getSelectionModel().getSelectedItem();
        int selectedteamID = userData2.getLeagueID();
    	String addingTeam = "INSERT INTO teams(TeamName, users_userID, league_LeagueID)"+ "VALUES (?,?,?)";
    	try
    	{
    		PreparedStatement preparedStatement = myConnection.prepareStatement(addingTeam);
			preparedStatement.setString (1, teamsNameTextField.getText());
			preparedStatement.setInt(2, Controller.currUserID);
			preparedStatement.setInt(3, selectedteamID);
    		preparedStatement.execute();
    		justDousersToTableView();
    		}
    	catch(SQLException e)
    	{
    		e.printStackTrace();
    		System.out.println("ERROR @ TeamsController.addTeam");
    		}
    	finally {
    		myConnection.close();
    	}
    	}
// Teams Refresh Button Functionality
@FXML
private void usersToTableView(ActionEvent event) throws SQLException
    {
    	myConnection = DBHandler.getConnection();
    	data2 = FXCollections.observableArrayList();
    	try
    	{
    		ResultSet rs2 = myConnection.createStatement().executeQuery("SELECT TeamID, TeamName, league_LeagueID FROM arenadatabase.teams WHERE TeamID > 0");
    		while(rs2.next())
    		{
    			data2.add(new TeamsTableViewController(rs2.getInt("TeamID"),rs2.getString("TeamName"),rs2.getInt("league_LeagueID")));
    		}
    	}
    	catch(SQLException e)
    	{
    		e.printStackTrace();
    		System.out.println("ERROR @ TeamsController.usersToTableView");
    	}
    	teamsColumnTeamID.setCellValueFactory(new PropertyValueFactory<>("TeamID"));
    	teamsColumnTeamName.setCellValueFactory(new PropertyValueFactory<>("TeamName"));
    	teamsColumnTeamLeagueID.setCellValueFactory(new PropertyValueFactory<>("league_LeagueID"));
    	teamsTable.setItems(data2);
    }
// Teams Remove Button Functionality
@FXML
private void teamsRemoveUser(ActionEvent event) throws SQLException
    {
        myConnection = DBHandler.getConnection();
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
// Teams Just Do. Refresh
private void justDousersToTableView() throws SQLException
    {
    	Connection myConnection = DBHandler.getConnection();
    	data2= FXCollections.observableArrayList();
    	try
    	{
    		ResultSet rs2 = myConnection.createStatement().executeQuery("SELECT TeamID, TeamName, league_LeagueID FROM arenadatabase.teams  WHERE TeamID > 0");
    		while(rs2.next())
    		{
    			data2.add(new TeamsTableViewController(rs2.getInt("TeamID"),rs2.getString("TeamName"),rs2.getInt("league_LeagueID")));
    		}
    	}
    	catch(SQLException e)
    	{
    		e.printStackTrace();
    		System.out.println("ERROR @ TeamsController.usersToTableView");
    	}
    	teamsColumnTeamID.setCellValueFactory(new PropertyValueFactory<>("teamID"));
    	teamsColumnTeamName.setCellValueFactory(new PropertyValueFactory<>("teamName"));
    	teamsColumnTeamLeagueID.setCellValueFactory(new PropertyValueFactory<>("league_LeagueID"));
    	teamsTable.setItems(data2);
    }
// Player Landing Page Go Back Button
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
// Player Team Application Apply Button Functionality
@FXML
private void sendTeamApp(ActionEvent event) throws Exception{
    	myConnection = DBHandler.getConnection();
    	// First. Let's get the User's Current Team ID.
    	  // Check 1
    	try {
    		String checkOne = "SELECT userTeamID FROM users WHERE userID ="+Controller.currUserID;
    		rs6 = myConnection.createStatement().executeQuery(checkOne);
    		rs6.first();
    		currTeamID = rs6.getInt("userTeamID");
    		//System.out.println("Current Team: "+currTeamID);
    	}
    	catch(SQLException e) {
    		e.printStackTrace();
    		System.out.println("ERROR @ TeamsController.sendTeamApp. Check 1");
    	}
       // Then. Next. Let's use that to get the Name of the Team the User is Currently in
    	  // Check 2
    	try {
    		String checkTwo = "SELECT TeamName FROM teams WHERE TeamID="+currTeamID;
    		rs7 = myConnection.createStatement().executeQuery(checkTwo);
    		rs7.first();
    		currTeamName = rs7.getString("TeamName");
    		//System.out.println("Current Team Name: "+currTeamName);
    	}
    	catch(SQLException e){
    		e.printStackTrace();
    		System.out.println("ERROR @ TeamsController.sendTeamApp. Check 2");
    	}
    	// Now. Let's get the desired_teamName, teamID, & LeagueID from TableView. Selected by the User
    	// We'll need a lot of this stuff for the insert to teams pending.
    	TeamsTableViewController userData = teamsTable.getSelectionModel().getSelectedItem();
        String desiredTeamName = userData.getTeamName();
        int desiredTeamID = userData.getTeamID();
        int desiredTeamLeagueID = userData.getLeague_LeagueID();
      //  System.out.println("Desired Team: "+desiredTeamID);
      //  System.out.println("Desired Team Name: "+desiredTeamName);

        // If the Same. Show Error. :"You are already in that team"
        if(currTeamID == desiredTeamID) {
        	errorLabelTeamApp.setVisible(true);
        	successLabelTeamApp.setVisible(false);
        }
    	// If NOT the same. Show Success. : "Application Sent"
        else if(currTeamID != desiredTeamID) {
        	errorLabelTeamApp.setVisible(false);
        	successLabelTeamApp.setVisible(true);
        	// Current User ID. Current User Name. Desired Team Name. Current Team Name. Desired Team ID. Desired Team League ID
    		String insert = "INSERT INTO teamspending(appUserID,appUserName,desired_teamName,current_teamName,desired_teamID,leagueOwnerID)"
                    + "VALUES (?,?,?,?,?,?)";
        		try
        		{
        			PreparedStatement preparedStatement = myConnection.prepareStatement(insert);
        			preparedStatement.setInt (1,Controller.currUserID );
        			preparedStatement.setString (2, Controller.currName);
        			preparedStatement.setString (3, desiredTeamName);
        			preparedStatement.setString (4,currTeamName );
        			preparedStatement.setInt (5, desiredTeamID);
        			preparedStatement.setInt (6, desiredTeamLeagueID);
        			preparedStatement.execute();
        		}
        		catch(Exception e)
        		{
        			e.printStackTrace();
        			System.out.println("ERROR @ TeamController.sendTeamApp. INSERT FAILURE");
        		}
        		finally
        		{
        			myConnection.close();
        		}
        }
    	
    } 
// League Owners Pending Player Team Applications Refresh
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
    			data5.add(new loPlayerAppTable(rs5.getInt("appUserID"),rs5.getInt("desired_teamID"),rs5.getString("appUserName"),rs5.getString("desired_teamName"), rs5.getString("current_teamName")));
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
private void justDousersToTableViewPendingTeamApps() throws SQLException
    {
    	myConnection = DBHandler.getConnection();
    	data5 = FXCollections.observableArrayList();
    	try
    	{
    		rs5 = myConnection.createStatement().executeQuery("SELECT * FROM teamspending");
    		while(rs5.next())
    		{
    			data5.add(new loPlayerAppTable(rs5.getInt("appUserID"),rs5.getInt("desired_teamID"),rs5.getString("appUserName"),rs5.getString("desired_teamName"), rs5.getString("current_teamName")));
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
// Load League Table Info
@FXML
private void leaguesToTable(MouseEvent event) throws SQLException
    {
    	myConnection = DBHandler.getConnection();
    	data = FXCollections.observableArrayList();
    	try
    	{
    		rs5 = myConnection.createStatement().executeQuery("SELECT * FROM league");
    		while(rs5.next())
    		{
    			data.add(new TeamsLOTable(rs5.getInt("LeagueID"),rs5.getString("LeagueName"),rs5.getString("leagueDesc")));
    		}
    	}
    	catch(SQLException e)
    	{
    		e.printStackTrace();
    		System.out.println("ERROR @ TeamsController.leaguesToTable");
    	}
    	columnLeagueIDForTeams.setCellValueFactory(new PropertyValueFactory<>("LeagueID"));
    	columnLeagueNameForTeams.setCellValueFactory(new PropertyValueFactory<>("LeagueName"));
    	columnLeagueDescriptionForTeams.setCellValueFactory(new PropertyValueFactory<>("leagueDesc"));
    	LeaguesTableForTeams.setItems(data);
    }
// Player Pending Application Remove
@FXML
private void removeTeam(ActionEvent event) throws SQLException, IOException
    {
    	myConnection = DBHandler.getConnection();
    	loPlayerAppTable userData = loPlayersAppTable.getSelectionModel().getSelectedItem();
        int selectedUserID = userData.getAppUserID();
        String sqlUpdateFour = "DELETE FROM arenadatabase.teamspending WHERE appUserID ="+selectedUserID+"";
        try
    	{
    		PreparedStatement preparedStatement = myConnection.prepareStatement(sqlUpdateFour);
    		preparedStatement.execute();
    		justDousersToTableViewPendingTeamApps();
    		}
    	catch(SQLException e)
    	{
    		e.printStackTrace();
    		System.out.println("ERROR @ TeamsController.removeTeam");
    		}
    	finally {
    		myConnection.close();
    	}
    }
// Player Pending Application Approve
@FXML
private void approveTeamChange(ActionEvent event) throws SQLException, IOException
    {
    	myConnection = DBHandler.getConnection();
    	loPlayerAppTable userData = loPlayersAppTable.getSelectionModel().getSelectedItem();
        int selectedUserID = userData.getAppUserID();
        int desiredTeamID = userData.getDesired_teamID();
        
        String sqlUpdateFive = "UPDATE users SET userTeamID = ? WHERE userID =?";
    	try
    	{
    		PreparedStatement preparedStatement = myConnection.prepareStatement(sqlUpdateFive);
    		preparedStatement.setInt(1,desiredTeamID );
			preparedStatement.setInt (2, selectedUserID);
    		preparedStatement.execute();
    		removeTeamAfterApprove() ;
    		justDousersToTableViewPendingTeamApps();
    		}
    	catch(SQLException e)
    	{
    		e.printStackTrace();
    		System.out.println("ERROR @ TeamsController.approveTeamChange");
    		}
    	finally {
    		myConnection.close();
    	}
    }
// Remove when Approved
private void removeTeamAfterApprove() throws SQLException, IOException
    {
    	myConnection = DBHandler.getConnection();
    	loPlayerAppTable userData = loPlayersAppTable.getSelectionModel().getSelectedItem();
        int selectedUserID = userData.getAppUserID();
        String sqlUpdateFour = "DELETE FROM arenadatabase.teamspending WHERE appUserID ="+selectedUserID+"";
        try
    	{
    		PreparedStatement preparedStatement = myConnection.prepareStatement(sqlUpdateFour);
    		preparedStatement.execute();
    		justDousersToTableViewPendingTeamApps();
    		}
    	catch(SQLException e)
    	{
    		e.printStackTrace();
    		System.out.println("ERROR @ TeamsController.removeTeamAfterApprove");
    		}
    	finally {
    		myConnection.close();
    	}
    }
}
