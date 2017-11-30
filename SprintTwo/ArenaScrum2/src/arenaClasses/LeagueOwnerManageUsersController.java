package arenaClasses;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import com.jfoenix.controls.JFXButton;
import arenaModels.LeagueOwnerManageUsersModel;
import arenaModels.UserModels;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

public class LeagueOwnerManageUsersController extends Main{
	@FXML
	private TableView<LeagueOwnerManageUsersModel> manageUsersTable;
	@FXML
	private TableColumn<LeagueOwnerManageUsersModel, Integer> columnUserID;
	@FXML
	private TableColumn<LeagueOwnerManageUsersModel, String> columnUserName;
	@FXML
	private TableColumn<LeagueOwnerManageUsersModel, String> columnLeagueName;
	@FXML
	private TableColumn<LeagueOwnerManageUsersModel, String> columnPlayerStatus;
	@FXML
	private JFXButton SearchButton;
	@FXML
	private JFXButton GoBackButton;
	@FXML
	private JFXButton RefreshButton;
	@FXML
	private JFXButton BanButton;
	@FXML
	private JFXButton UnBanButton;
	@FXML
	private TextField SearchField;

	
	Scene scene;
	Stage stage = new Stage();
	private ObservableList<LeagueOwnerManageUsersModel>data;
	
	@FXML
	private void goBackLeagueSplash(ActionEvent event) throws Exception {
		GoBackButton.getScene().getWindow().hide();
	    loader.setLocation(getClass().getResource("/arenaViews/leagueOwnerLanding.fxml"));
	    scene = new Scene(loader.load());
	    stage.setScene(scene);
	    stage.setResizable(false);
	    stage.getIcons().add(new Image(getClass().getResourceAsStream("/images/arenaIcon.png")));
	    stage.setTitle("Arena");
	    stage.show();
	    }
	@FXML
	private void ManageUsersToTableView(ActionEvent event) throws SQLException
	{
		Connection myConnection = DBHandler.getConnection();
		data = FXCollections.observableArrayList();
		int OwnerID = UserModels.getUserID();
		data.removeAll(data);
		try
		{
			ResultSet rs = myConnection.createStatement().executeQuery("SELECT userID, userName, LeagueName, MembershipStatusCodeName FROM users, leaguemembers, league, membershipstatuscode WHERE userID=users_UserID and LeagueID=League_LeagueID and MembershipStatuscodeID= MembershipStatuscode_MembershipStatuscodeID and users_userID_LeagueOwner ="+OwnerID+" and MembershipStatuscode_MembershipStatuscodeID<>3 ");
			while(rs.next())
			{
				data.add(new LeagueOwnerManageUsersModel(rs.getInt("userID"),rs.getString("userName"),rs.getString("LeagueName"), rs.getString("MembershipStatusCodeName")));
			}
		}
		catch(SQLException e)
		{
			e.printStackTrace();
			System.out.println("ERROR @ LeagueOwnerManageLeagueController.ManageUsersToTableView");
		}
		JustDoManageUsersToTableView();
		columnUserID.setCellValueFactory(new PropertyValueFactory<>("userID"));
		columnUserName.setCellValueFactory(new PropertyValueFactory<>("userName"));
		columnLeagueName.setCellValueFactory(new PropertyValueFactory<>("LeagueName"));
		columnPlayerStatus.setCellValueFactory(new PropertyValueFactory<>("MembershipStatusCodeName"));
		manageUsersTable.setItems(data);
	}
	private void JustDoManageUsersToTableView() throws SQLException
	{
		Connection myConnection = DBHandler.getConnection();
		data = FXCollections.observableArrayList();
		int OwnerID = UserModels.getUserID();
		data.removeAll(data);
		try
		{
			ResultSet rs = myConnection.createStatement().executeQuery("SELECT userID, userName, LeagueName, MembershipStatusCodeName FROM users, leaguemembers, league, membershipstatuscode WHERE userID=users_UserID and LeagueID=League_LeagueID and MembershipStatuscodeID= MembershipStatuscode_MembershipStatuscodeID and users_userID_LeagueOwner ="+OwnerID+" and MembershipStatuscode_MembershipStatuscodeID<>3 ");
			while(rs.next())
			{
				data.add(new LeagueOwnerManageUsersModel(rs.getInt("userID"),rs.getString("userName"),rs.getString("LeagueName"), rs.getString("MembershipStatusCodeName")));
			}
		}
		catch(SQLException e)
		{
			e.printStackTrace();
			System.out.println("ERROR @ LeagueOwnerManageLeagueController.ManageUsersToTableView");
		}
		columnUserID.setCellValueFactory(new PropertyValueFactory<>("userID"));
		columnUserName.setCellValueFactory(new PropertyValueFactory<>("userName"));
		columnLeagueName.setCellValueFactory(new PropertyValueFactory<>("LeagueName"));
		columnPlayerStatus.setCellValueFactory(new PropertyValueFactory<>("MembershipStatusCodeName"));
		manageUsersTable.setItems(data);
	}
	@FXML
	private void BanUser(ActionEvent event) throws SQLException
	{
		Connection myConnection = DBHandler.getConnection();
		data = FXCollections.observableArrayList();
		LeagueOwnerManageUsersModel userData = manageUsersTable.getSelectionModel().getSelectedItem();
		int selectedUserID = userData.getUserID();
		String selectedLeagueName = userData.getLeagueName();
		String sqlUpdate = "UPDATE arenadatabase.leaguemembers SET Membershipstatuscode_membershipstatuscodeID = 2 WHERE Exists (Select * FROM league WHERE users_userID =" +selectedUserID +" and League_LeagueID =LeagueID and LeagueName ='"+selectedLeagueName+"') ";
		try
		{
			PreparedStatement pst = myConnection.prepareStatement(sqlUpdate);
			pst.execute(sqlUpdate);
			JustDoManageUsersToTableView();
			
		}
		catch(SQLException e)
		{
			e.printStackTrace();
			System.out.println("ERROR @ LeagueOwnerManageUsersControl.banUser");
		}
		finally
		{
			myConnection.close();
		}
	}
	@FXML
	private void UnBanUser(ActionEvent event) throws SQLException
	{
		Connection myConnection = DBHandler.getConnection();
		data = FXCollections.observableArrayList();
		LeagueOwnerManageUsersModel userData = manageUsersTable.getSelectionModel().getSelectedItem();
		int selectedUserID = userData.getUserID();
		String selectedLeagueName = userData.getLeagueName();
		String sqlUpdate = "UPDATE arenadatabase.leaguemembers SET Membershipstatuscode_membershipstatuscodeID = 1 WHERE Exists (Select * FROM league WHERE users_userID =" +selectedUserID +" and League_LeagueID =LeagueID and LeagueName ='"+selectedLeagueName+"') ";
		try
		{
			PreparedStatement pst = myConnection.prepareStatement(sqlUpdate);
			pst.execute(sqlUpdate);
			JustDoManageUsersToTableView();
			
		}
		catch(SQLException e)
		{
			e.printStackTrace();
			System.out.println("ERROR @ LeagueOwnerManageUsersControl.banUser");
		}
		finally
		{
			myConnection.close();
		}
	}

	@FXML
	private void executeSearch(ActionEvent event) throws SQLException {
		Connection myConnection = DBHandler.getConnection();
		data = FXCollections.observableArrayList();
		String Searchfield = SearchField.getText();
		int OwnerID = UserModels.getUserID();
		data.removeAll(data);
		try
		{
			ResultSet rs = myConnection.createStatement().executeQuery("SELECT Distinct userID, userName, LeagueName, MembershipStatusCodeName from users, leaguemembers, league, membershipstatuscode  Where userID=users_UserID and LeagueID=League_LeagueID and MembershipStatuscodeID= MembershipStatuscode_MembershipStatuscodeID and users_userID_LeagueOwner ="+OwnerID+" and userName = '"+Searchfield+"'");
			while(rs.next())
			{
				data.add(new LeagueOwnerManageUsersModel(rs.getInt("userID"),rs.getString("userName"),rs.getString("LeagueName"), rs.getString("MembershipStatusCodeName")));
			}
		}
		catch(SQLException e)
		{
			e.printStackTrace();
			System.out.println("ERROR @ LeagueOwnerManageLeagueController.ManageUsersToTableView");
		}
		columnUserID.setCellValueFactory(new PropertyValueFactory<>("userID"));
		columnUserName.setCellValueFactory(new PropertyValueFactory<>("userName"));
		columnLeagueName.setCellValueFactory(new PropertyValueFactory<>("LeagueName"));
		columnPlayerStatus.setCellValueFactory(new PropertyValueFactory<>("MembershipStatusCodeName"));
		manageUsersTable.setItems(data);
	}
	
	@FXML
    private void closeApplication(MouseEvent event) {
        System.exit(0);
    }
}
