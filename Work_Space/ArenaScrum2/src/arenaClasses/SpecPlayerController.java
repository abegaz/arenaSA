package arenaClasses;

import java.awt.Label;
import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.jfoenix.controls.JFXButton;

import arenaModels.SpecPlayerModel;
import arenaModels.SpecTeamModel;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.stage.Stage;

public class SpecPlayerController extends Main{
    @FXML
    private JFXButton PlayerRefreshButton;
    @FXML
    private JFXButton GoBackButton;
    @FXML
    private TableView<SpecPlayerModel> PlayerListTable;
    @FXML
    private TableColumn<SpecPlayerModel, Integer> columnPlayerID;
    @FXML
    private TableColumn<SpecPlayerModel, String> columnPlayerName;
    @FXML
    private TableColumn<SpecPlayerModel, String> columnTeamName;
    @FXML
    private JFXButton PlayerDetailsButton;
    @FXML
    
	Scene scene;
	Stage stage = new Stage();
	private ObservableList<SpecPlayerModel>data;
	
	@FXML
    private void LoadPlayer(ActionEvent event) throws SQLException {
    	Connection myConnection = DBHandler.getConnection();
    	data = FXCollections.observableArrayList();
    	data.removeAll(data);
    	try {
    		ResultSet rs = myConnection.createStatement().executeQuery("Select userID, userName, TeamName FROM teams, users WHERE userRoleID =3 and userTeamID=TeamID");
    		while (rs.next()){

    			data.add(new SpecPlayerModel(rs.getInt("userID"),rs.getString("userName"),rs.getString("TeamName")));
    		}
    		JustDoLoadPlayer();
    		columnPlayerID.setCellValueFactory(new PropertyValueFactory<>("userID"));
    		columnPlayerName.setCellValueFactory(new PropertyValueFactory<>("userName"));
    		columnTeamName.setCellValueFactory(new PropertyValueFactory<>("TeamName"));;
    		PlayerListTable.setItems(data);
    	}
    	catch(SQLException e)
        {
            e.printStackTrace();
            System.out.println("ERROR @ Load Teams");
        }
    	
        finally
        {
        	myConnection.close();
        }
    	
    }
    
	private void JustDoLoadPlayer() throws SQLException {
    	Connection myConnection = DBHandler.getConnection();
    	data = FXCollections.observableArrayList();
    	data.removeAll(data);
    	try {
    		ResultSet rs = myConnection.createStatement().executeQuery("Select userID, userName, TeamName FROM teams, users WHERE userRoleID =3 and userTeamID=TeamID");
    		while (rs.next()){

    			data.add(new SpecPlayerModel(rs.getInt("userID"),rs.getString("userName"),rs.getString("TeamName")));
    		}
    		columnPlayerID.setCellValueFactory(new PropertyValueFactory<>("userID"));
    		columnPlayerName.setCellValueFactory(new PropertyValueFactory<>("userName"));
    		columnTeamName.setCellValueFactory(new PropertyValueFactory<>("TeamName"));;
    		PlayerListTable.setItems(data);
    	}
    	catch(SQLException e)
        {
            e.printStackTrace();
            System.out.println("ERROR @ Load Teams");
        }
    	
        finally
        {
        	myConnection.close();
        }
    }

    @FXML
    void LoadPlayerDetails(ActionEvent event) throws IOException, SQLException {
    	PlayerDetailsButton.getScene().getWindow().hide();
        loader.setLocation(getClass().getResource("/arenaViews/SpecPlayerDetails.fxml"));
        scene = new Scene(loader.load());
        stage.setScene(scene);
        SpecPlayerDetailController controller = loader.getController();
        controller.initData(PlayerListTable.getSelectionModel().getSelectedItem());
        SpecPlayerDetailController controller2 = loader.getController();
        controller2.initalize(PlayerListTable.getSelectionModel().getSelectedItem());
        stage.setResizable(false);
        stage.getIcons().add(new Image(getClass().getResourceAsStream("/images/arenaIcon.png")));
        stage.setTitle("Arena");
        stage.show();
    }
    @FXML
    void LoadGuestPlayerDetails(ActionEvent event) throws IOException, SQLException {
    	PlayerDetailsButton.getScene().getWindow().hide();
        loader.setLocation(getClass().getResource("/arenaViews/GuestPlayerDetails.fxml"));
        scene = new Scene(loader.load());
        stage.setScene(scene);
        SpecPlayerDetailController controller = loader.getController();
        controller.initData(PlayerListTable.getSelectionModel().getSelectedItem());
        SpecPlayerDetailController controller2 = loader.getController();
        controller2.initalize(PlayerListTable.getSelectionModel().getSelectedItem());
        stage.setResizable(false);
        stage.getIcons().add(new Image(getClass().getResourceAsStream("/images/arenaIcon.png")));
        stage.setTitle("Arena");
        stage.show();
    }

    @FXML
    void goToSpecLanding(ActionEvent event) throws IOException {
    	GoBackButton.getScene().getWindow().hide();
        loader.setLocation(getClass().getResource("/arenaViews/spectatorLanding.fxml"));
        scene = new Scene(loader.load());
        stage.setScene(scene);
        stage.setResizable(false);
        stage.getIcons().add(new Image(getClass().getResourceAsStream("/images/arenaIcon.png")));
        stage.setTitle("Arena");
        stage.show();
    }
    @FXML
    void goToGuestLanding(ActionEvent event) throws IOException {
    	GoBackButton.getScene().getWindow().hide();
        loader.setLocation(getClass().getResource("/arenaViews/GuestLanding.fxml"));
        scene = new Scene(loader.load());
        stage.setScene(scene);
        stage.setResizable(false);
        stage.getIcons().add(new Image(getClass().getResourceAsStream("/images/arenaIcon.png")));
        stage.setTitle("Arena");
        stage.show();
    }
}
