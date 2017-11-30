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
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

public class LeagueOwnerManageLeagueController extends Main{


	@FXML
	private Label YourLeagues;
	@FXML
	private JFXTextField SearchTextField;
	@FXML
	private JFXButton SearchButton;
	@FXML
	private JFXButton refreshButton;
	@FXML
	private Label loadMe;
	@FXML
	private JFXButton RemoveButton;
	@FXML
	private JFXButton UpdateButton;
	@FXML
	private JFXButton GoBackButton;
	@FXML
	private ImageView progress;
	@FXML
	private ImageView Background;
	@FXML
	private TableView<PlayerJoinLeagueModel> LeaguesTable;
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
    private void loadDataFromDatabase(ActionEvent event) throws SQLException{
    	Connection myConnection = DBHandler.getConnection();
    	data = FXCollections.observableArrayList();
    	int PlayerID = UserModels.getUserID();
    	try {
    		ResultSet rs2 = myConnection.createStatement().executeQuery("SELECT LeagueID, LeagueName, LeagueDesc  FROM arenadatabase.league WHERE users_userID_LeagueOwner ="+PlayerID+"");
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
    	LeaguesTable.setItems(data); 
    	LeaguesTable.setEditable(true);
    	columnLeagueName.setCellFactory(TextFieldTableCell.forTableColumn());
    	columnLeagueDescription.setCellFactory(TextFieldTableCell.forTableColumn());
    } 
	private void loadDatafromDatabaseLoading() throws SQLException{
    	Connection myConnection = DBHandler.getConnection();
    	data = FXCollections.observableArrayList();
    	int PlayerID = UserModels.getUserID();
    	try {
    		ResultSet rs2 = myConnection.createStatement().executeQuery("SELECT LeagueID, LeagueName, LeagueDesc  FROM arenadatabase.league WHERE users_userID_LeagueOwner ="+PlayerID+"");
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
    	LeaguesTable.setItems(data);
    	LeaguesTable.setEditable(true);
    	columnLeagueName.setCellFactory(TextFieldTableCell.forTableColumn());
    	columnLeagueDescription.setCellFactory(TextFieldTableCell.forTableColumn());
    	
    	columnLeagueName.setOnEditCommit(event -> {PlayerJoinLeagueModel leagueEdit = event.getRowValue();
    	leagueEdit.setLeagueName(event.getNewValue());
    	updateLeagueName("LeagueName", event.getNewValue(), leagueEdit.getLeagueID());});
    	columnLeagueDescription.setOnEditCommit(event -> {PlayerJoinLeagueModel leagueEdit = event.getRowValue();
    	leagueEdit.setLeagueDesc(event.getNewValue());
    	updateLeagueDesc("LeagueDesc", event.getNewValue(), leagueEdit.getLeagueID());});
    }
	@FXML
    private void handleClose(MouseEvent event) {
        System.exit(0);
    }
	@FXML
	private void removeLeague(ActionEvent event) throws SQLException {
	     Connection myConnection = DBHandler.getConnection();
	     PlayerJoinLeagueModel LeagueData = LeaguesTable.getSelectionModel().getSelectedItem();
	     int selectedLeagueID = LeagueData.getLeagueID();
	     String sqlDelete ="DELETE FROM arenadatabase.league WHERE LeagueID ="+selectedLeagueID+"";
	     String sqlDelete2 ="DELETE FROM arenadatabase.leaguemembers WHERE League_LeagueID ="+selectedLeagueID+"";
	     
	     try {
	    PreparedStatement pst2 = myConnection.prepareStatement(sqlDelete2);
	    pst2.execute(sqlDelete2);
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
	private void updateLeagueName(String column, String newValue, int id) {
		String sqlUpdate = "Update arenadatabase.league SET "+column+" = ? WHERE LeagueID = ?";
		
		try{
			Connection myConnection = DBHandler.getConnection();
			PreparedStatement preparedStatement = myConnection.prepareStatement(sqlUpdate);
			preparedStatement.setString (1, newValue);
			preparedStatement.setInt (2, id);
			preparedStatement.execute();
		}
		catch(SQLException e){
	         e.printStackTrace();
	         System.out.println("ERROR @ Control.updateLeagueName");
	     }

	}
	private void updateLeagueDesc(String column, String newValue, int id) {
		String sqlUpdate = "Update arenadatabase.league SET "+column+" = ? WHERE LeagueID = ?";
		
		try{
			Connection myConnection = DBHandler.getConnection();
			PreparedStatement preparedStatement = myConnection.prepareStatement(sqlUpdate);
			preparedStatement.setString (1, newValue);
			preparedStatement.setInt (2, id);
			preparedStatement.execute();
		}
		catch(SQLException e){
	         e.printStackTrace();
	         System.out.println("ERROR @ Control.updateLeagueName");
	     }

	}
	@FXML
	private void executeSearch(ActionEvent event) throws SQLException {
		Connection myConnection = DBHandler.getConnection();
    	data = FXCollections.observableArrayList();
    	String SearchText =SearchTextField.getText();
    	int PlayerID = UserModels.getUserID();
    	try {
    		ResultSet rs2 = myConnection.createStatement().executeQuery("SELECT LeagueID, LeagueName, LeagueDesc  FROM arenadatabase.league WHERE users_userID_LeagueOwner ="+PlayerID+" and LeagueName = '"+SearchText+"'");
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
    	LeaguesTable.setItems(data);
    	LeaguesTable.setEditable(true);
    	columnLeagueName.setCellFactory(TextFieldTableCell.forTableColumn());
    	columnLeagueDescription.setCellFactory(TextFieldTableCell.forTableColumn());
	}
	
}
