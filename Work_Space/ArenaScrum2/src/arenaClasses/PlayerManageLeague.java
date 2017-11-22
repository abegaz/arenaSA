package arenaClasses;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import arenaModels.PlayerManageLeagueModel;
import arenaModels.UserModels;
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
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

public class PlayerManageLeague extends Main{


	@FXML
	private Label YourLeagues;
	@FXML
	private Label BannedLabel;
	@FXML
	private JFXTextField SearchBar;
	@FXML
	private JFXButton SearchButton;
	@FXML
	private JFXButton refreshButton;
	@FXML
	private Label loadMe;
	@FXML
	private JFXButton PlayerRemoveButton;
	@FXML
	private JFXButton GoBackButton;
	@FXML
	private ImageView progress;
	@FXML
	private ImageView Background;
	@FXML
	private TableView<PlayerManageLeagueModel> PlayerLeagueTable;
	@FXML
	private TableColumn<PlayerManageLeagueModel, String> columnLeagueName;
	@FXML
	private TableColumn<PlayerManageLeagueModel, String> columnLeagueDescription;
	@FXML
	private TableColumn<PlayerManageLeagueModel, Integer> columnLeagueID;
	@FXML
	private TableColumn<PlayerManageLeagueModel, String> columnPlayerStatus;
	

ResultSet rs;
Scene scene;
Stage stage = new Stage();
private ObservableList<PlayerManageLeagueModel>data;

@FXML
private void goBackPlayerSplash(ActionEvent event) throws Exception {
	GoBackButton.getScene().getWindow().hide();
    loader.setLocation(getClass().getResource("/arenaViews/playerLanding.fxml"));
    scene = new Scene(loader.load());
    stage.setScene(scene);
    stage.setResizable(false);
    stage.getIcons().add(new Image(getClass().getResourceAsStream("/images/arenaIcon.png")));
    stage.setTitle("Arena");
    stage.show();
    }
	@FXML
    private void loadDataFromDatabase(ActionEvent event) throws SQLException{
    	Connection myConnection = DBHandler.getConnection();
    	data = FXCollections.observableArrayList();
    	data.removeAll(data);
    	int PlayerID = UserModels.getUserID();
    	try {
    		ResultSet rs2 = myConnection.createStatement().executeQuery("SELECT L.LeagueID, L.LeagueName, L.LeagueDesc, N.MembershipStatusCodeName  FROM arenadatabase.league L, arenadatabase.leaguemembers M, arenadatabase.membershipstatuscode N WHERE L.LeagueID=M.League_LeagueID and M.users_userID ="+PlayerID+" and N.MembershipStatusCodeID= M.MembershipStatusCode_MembershipStatusCodeID");
    		while(rs2.next()) {
    			data.add(new PlayerManageLeagueModel(rs2.getInt("LeagueID"), rs2.getString("LeagueName"), rs2.getString("LeagueDesc"), rs2.getString("MembershipStatusCodeName")));
    		}
    	}
    	catch(SQLException e) {
    		e.printStackTrace();
    		System.out.println("ERROR @ Controller.PlayerLeagueTable");
    	}
    	loadDatafromDatabaseLoading();
    	columnLeagueID.setCellValueFactory(new PropertyValueFactory<>("LeagueID"));
    	columnLeagueName.setCellValueFactory(new PropertyValueFactory<>("LeagueName"));
    	columnLeagueDescription.setCellValueFactory(new PropertyValueFactory<>("LeagueDesc"));
    	columnPlayerStatus.setCellValueFactory(new PropertyValueFactory<>("MembershipStatusCodeName"));
    	PlayerLeagueTable.setItems(data); 
    } 
	private void loadDatafromDatabaseLoading() throws SQLException{
    	Connection myConnection = DBHandler.getConnection();
    	data = FXCollections.observableArrayList();
    	data.removeAll(data);
    	int PlayerID = UserModels.getUserID();
    	try {
    		ResultSet rs2 = myConnection.createStatement().executeQuery("SELECT L.LeagueID, L.LeagueName, L.LeagueDesc, N.MembershipStatusCodeName  FROM arenadatabase.league L, arenadatabase.leaguemembers M, arenadatabase.membershipstatuscode N WHERE L.LeagueID=M.League_LeagueID and M.users_userID ="+PlayerID+" and N.MembershipStatusCodeID= M.MembershipStatusCode_MembershipStatusCodeID");
    		while(rs2.next()) {
    			data.add(new PlayerManageLeagueModel(rs2.getInt("LeagueID"), rs2.getString("LeagueName"), rs2.getString("LeagueDesc"), rs2.getString("MembershipStatusCodeName")));
    		}
    	}
    	catch(SQLException e) {
    		e.printStackTrace();
    		System.out.println("ERROR @ Controller.PlayerLeagueTable");
    	}
    	columnLeagueID.setCellValueFactory(new PropertyValueFactory<>("LeagueID"));
    	columnLeagueName.setCellValueFactory(new PropertyValueFactory<>("LeagueName"));
    	columnLeagueDescription.setCellValueFactory(new PropertyValueFactory<>("LeagueDesc"));
    	columnPlayerStatus.setCellValueFactory(new PropertyValueFactory<>("MembershipStatusCodeName"));
    	PlayerLeagueTable.setItems(data); 
    }
	@FXML
    private void handleClose(MouseEvent event) {
        System.exit(0);
    }
	@FXML
	private void removeLeagueMembership(ActionEvent event) throws SQLException {
	     Connection myConnection = DBHandler.getConnection();
	     PlayerManageLeagueModel LeagueData = PlayerLeagueTable.getSelectionModel().getSelectedItem();
	     int selectedLeagueID = LeagueData.getLeagueID();
	     int selectedUserID = UserModels.getUserID();
	     String sqlDelete ="DELETE FROM arenadatabase.leaguemembers WHERE League_LeagueID ="+selectedLeagueID+" and users_userID="+selectedUserID+"";
	     String sqlStatus ="Select MembershipStatusCode_MembershipStatusCodeID FROM leaguemembers WHERE users_userid ="+selectedUserID+" and League_LeagueID="+selectedLeagueID+"";
	     
	     try {
	    
	    	 ResultSet rs2 = myConnection.createStatement().executeQuery(sqlStatus);
	    	 while(rs2.next()) {
	    		int memberStatus = rs2.getInt(1);
	    		if (memberStatus == 2){
	    		BannedLabel.setVisible(true);
	    		}
	    	else{
	    		PreparedStatement pst = myConnection.prepareStatement(sqlDelete);
	    		pst.execute(sqlDelete);
	    		loadDatafromDatabaseLoading();
	    		}
	    	 }
	    }
	     catch(SQLException e){
	         e.printStackTrace();
	         System.out.println("ERROR @ Control.JoinLeague");
	     }

	     finally {
	    	 myConnection.close();
	     }
}
	@FXML
	private void executeSearch(ActionEvent event) throws SQLException {
		
	}
	
}
