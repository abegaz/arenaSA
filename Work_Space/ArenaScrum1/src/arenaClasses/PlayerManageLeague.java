package arenaClasses;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import java.sql.SQLException;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;

import arenaModels.PlayerJoinLeagueModel;
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
import javafx.stage.StageStyle;

public class PlayerManageLeague extends Main{


	@FXML
	private Label YourLeagues;
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
	private TableView<PlayerJoinLeagueModel> PlayerLeagueTable;
	@FXML
	private TableColumn<PlayerJoinLeagueModel, String> columnLeagueName;
	@FXML
	private TableColumn<PlayerJoinLeagueModel, String> columnLeagueDescription;
	@FXML
	private TableColumn<PlayerJoinLeagueModel, Integer> columnLeagueID;

ResultSet rs;
Scene scene;
Stage stage = new Stage();
private ObservableList<PlayerJoinLeagueModel>data;

@FXML
private void goBackPlayerSplash(ActionEvent event) throws Exception {
	GoBackButton.getScene().getWindow().hide();
    loader.setLocation(getClass().getResource("/arenaViews/playerLanding.fxml"));
    scene = new Scene(loader.load());
    stage.setScene(scene);
    stage.initStyle(StageStyle.UNDECORATED);
    stage.setResizable(false);
    stage.getIcons().add(new Image(getClass().getResourceAsStream("/images/arenaIcon.png")));
    stage.setTitle("Arena");
    stage.show();
    progress.setVisible(true);
    }
	@FXML
    private void loadDataFromDatabase(ActionEvent event) throws SQLException{
    	Connection myConnection = DBHandler.getConnection();
    	data = FXCollections.observableArrayList();
    	int PlayerID = UserModels.getUserID();
    	try {
    		ResultSet rs2 = myConnection.createStatement().executeQuery("SELECT L.LeagueID, L.LeagueName, L.LeagueDesc  FROM arenadatabase.league L, arenadatabase.leaguemembers M WHERE L.LeagueID=M.League_LeagueID and M.users_userID ="+PlayerID+"");
    		while(rs2.next()) {
    			data.add(new PlayerJoinLeagueModel(rs2.getInt("LeagueID"), rs2.getString("LeagueName"), rs2.getString("LeagueDesc")));
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
    	PlayerLeagueTable.setItems(data); 
    } 
	private void loadDatafromDatabaseLoading() throws SQLException{
    	Connection myConnection = DBHandler.getConnection();
    	data = FXCollections.observableArrayList();
    	int PlayerID = UserModels.getUserID();
    	try {
    		ResultSet rs2 = myConnection.createStatement().executeQuery("SELECT L.LeagueID, L.LeagueName, L.LeagueDesc  FROM arenadatabase.league L, arenadatabase.leaguemembers M WHERE L.LeagueID=M.League_LeagueID and M.users_userID ="+PlayerID+"");
    		while(rs2.next()) {
    			data.add(new PlayerJoinLeagueModel(rs2.getInt("LeagueID"), rs2.getString("LeagueName"), rs2.getString("LeagueDesc")));
    		}
    	}
    	catch(SQLException e) {
    		e.printStackTrace();
    		System.out.println("ERROR @ Controller.PlayerLeagueTable");
    	}
    	columnLeagueID.setCellValueFactory(new PropertyValueFactory<>("LeagueID"));
    	columnLeagueName.setCellValueFactory(new PropertyValueFactory<>("LeagueName"));
    	columnLeagueDescription.setCellValueFactory(new PropertyValueFactory<>("LeagueDesc"));
    	PlayerLeagueTable.setItems(data); 
    }
	@FXML
    private void handleClose(MouseEvent event) {
        System.exit(0);
    }
	@FXML
	private void removeLeagueMembership(ActionEvent event) throws SQLException {
	     Connection myConnection = DBHandler.getConnection();
	     PlayerJoinLeagueModel LeagueData = PlayerLeagueTable.getSelectionModel().getSelectedItem();
	     int selectedLeagueID = LeagueData.getLeagueID();
	     int selectedUserID = UserModels.getUserID();
	     String sqlDelete ="DELETE FROM arenadatabase.LeagueMembers WHERE League_LeagueID ="+selectedLeagueID+" and users_userID="+selectedUserID+"";
	     
	     try {

	    PreparedStatement pst = myConnection.prepareStatement(sqlDelete);
	    pst.execute(sqlDelete);
	     
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
