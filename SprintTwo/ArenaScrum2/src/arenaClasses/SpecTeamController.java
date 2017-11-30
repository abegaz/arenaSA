package arenaClasses;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.jfoenix.controls.JFXButton;

import arenaModels.CurrentMatchSpecModel;
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

public class SpecTeamController extends Main{
	@FXML
	private JFXButton GoBackButton;
	@FXML
	private JFXButton TeamRefreshButton;
	@FXML
	private JFXButton TeamDetailsButton;
	@FXML
	private TableView<SpecTeamModel> TeamListTable;
	@FXML
	private TableColumn<SpecTeamModel, Integer> columnTeamID;
	@FXML
	private TableColumn<SpecTeamModel, String> columnTeamName;

	
	Scene scene;
	Stage stage = new Stage();
	private ObservableList<SpecTeamModel>data;
	@FXML
	private void goToSpecLanding() throws IOException{
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
	private void goToGuestLanding() throws IOException{
    	GoBackButton.getScene().getWindow().hide();
        loader.setLocation(getClass().getResource("/arenaViews/GuestLanding.fxml"));
        scene = new Scene(loader.load());
        stage.setScene(scene);
        stage.setResizable(false);
        stage.getIcons().add(new Image(getClass().getResourceAsStream("/images/arenaIcon.png")));
        stage.setTitle("Arena");
        stage.show();
	}
	
    @FXML
    private void LoadTeams() throws SQLException {
    	Connection myConnection = DBHandler.getConnection();
    	data = FXCollections.observableArrayList();
    	data.removeAll(data);
    	try {
    		ResultSet rs = myConnection.createStatement().executeQuery("Select TeamID, TeamName FROM teams WHERE TeamID<>0");
    		while (rs.next()){

    			data.add(new SpecTeamModel(rs.getInt("TeamID"),rs.getString("TeamName")));
    		}
    		JustDoLoadTeams();
    		columnTeamID.setCellValueFactory(new PropertyValueFactory<>("TeamID"));
    		columnTeamName.setCellValueFactory(new PropertyValueFactory<>("TeamName"));
    		TeamListTable.setItems(data);
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
    
    private void JustDoLoadTeams() throws SQLException {
    	Connection myConnection = DBHandler.getConnection();
    	data = FXCollections.observableArrayList();
    	data.removeAll(data);
    	try {
    		ResultSet rs = myConnection.createStatement().executeQuery("Select TeamID, TeamName FROM teams WHERE TeamID<>0");
    		while (rs.next()){

    			data.add(new SpecTeamModel(rs.getInt("TeamID"),rs.getString("TeamName")));
    		}
    		columnTeamID.setCellValueFactory(new PropertyValueFactory<>("TeamID"));
    		columnTeamName.setCellValueFactory(new PropertyValueFactory<>("TeamName"));
    		TeamListTable.setItems(data);
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
    public void LoadTeamDetails(ActionEvent event) throws IOException, SQLException
    {	
    	TeamDetailsButton.getScene().getWindow().hide();
        loader.setLocation(getClass().getResource("/arenaViews/SpecTeamDetails.fxml"));
        scene = new Scene(loader.load());
        stage.setScene(scene);
        SpecTeamDetails controller = loader.getController();
        controller.initData(TeamListTable.getSelectionModel().getSelectedItem());
        SpecTeamDetails controller2 = loader.getController();
        controller2.initalize(TeamListTable.getSelectionModel().getSelectedItem());
        stage.setResizable(false);
        stage.getIcons().add(new Image(getClass().getResourceAsStream("/images/arenaIcon.png")));
        stage.setTitle("Arena");
        stage.show();
    }
    
    public void LoadGuestTeamDetails(ActionEvent event) throws IOException, SQLException
    {	
    	TeamDetailsButton.getScene().getWindow().hide();
        loader.setLocation(getClass().getResource("/arenaViews/GuestTeamDetails.fxml"));
        scene = new Scene(loader.load());
        stage.setScene(scene);
        SpecTeamDetails controller = loader.getController();
        controller.initData(TeamListTable.getSelectionModel().getSelectedItem());
        SpecTeamDetails controller2 = loader.getController();
        controller2.initalize(TeamListTable.getSelectionModel().getSelectedItem());
        stage.setResizable(false);
        stage.getIcons().add(new Image(getClass().getResourceAsStream("/images/arenaIcon.png")));
        stage.setTitle("Arena");
        stage.show();
    }
}
