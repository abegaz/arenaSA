package arenaClasses;


import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.jfoenix.controls.JFXButton;

import arenaModels.SpecTeamModel;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.chart.BarChart;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.image.Image;
import javafx.stage.Stage;

public class SpecTeamDetails extends Main{

	Scene scene;
	Stage stage = new Stage();
	
	private SpecTeamModel TeamSelected;
	
	@FXML
	private Label TeamLabel;
	@FXML
	private JFXButton DetailsGoBackButton;
    @FXML
    private BarChart<String, Integer> TournyWinloseChart;
    @FXML
    private BarChart<String, Integer> MatchWinloseChart;
    @FXML
    private ListView<String> PlayerList;
    
    private ObservableList<String> data;
	
    public void initData(SpecTeamModel Select){
    	TeamSelected = Select;
        TeamLabel.setText(TeamSelected.getTeamName());
    }
    
    public void initalize(SpecTeamModel Teams) throws SQLException{
    	Connection myConnection = DBHandler.getConnection();
    	data = FXCollections.observableArrayList();
    	data.removeAll(data);
    	TeamSelected = Teams;
    	int TeamID =TeamSelected.getTeamID();
    	try {
    		ResultSet rs = myConnection.createStatement().executeQuery("SELECT userName FROM users WHERE userTeamID ="+TeamID+" and userRoleID<>1");
    		while (rs.next()){
    			data.add((rs.getString(1)));
    		}
    		PlayerList.setItems(data);
    	}
        	catch(SQLException e)
            {
                e.printStackTrace();
                System.out.println("ERROR @ View Players");
            }
        	
            finally
            {
            	myConnection.close();
            }
    }

	@FXML
	private void goBackToPastMatches() throws IOException{
		DetailsGoBackButton.getScene().getWindow().hide();
        loader.setLocation(getClass().getResource("/arenaViews/SpectatorTeams.fxml"));
        scene = new Scene(loader.load());
        stage.setScene(scene);
        stage.setResizable(false);
        stage.getIcons().add(new Image(getClass().getResourceAsStream("/images/arenaIcon.png")));
        stage.setTitle("Arena");
        stage.show();
	}
}

