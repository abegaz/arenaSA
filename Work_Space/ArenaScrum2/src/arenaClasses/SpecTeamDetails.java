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
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
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
    private BarChart<String, Integer> MatchWinloseChart;
    @FXML
    private ListView<String> PlayerList;
    @FXML
    private ListView<String> TourniesWon;
    @FXML
    private CategoryAxis WinLoss;
    @FXML
    private NumberAxis Numbers;
    
    private ObservableList<String> data;
    private ObservableList<String> data2;
	
    public void initData(SpecTeamModel Select){
    	TeamSelected = Select;
        TeamLabel.setText(TeamSelected.getTeamName());
    }
    
    public void initalize(SpecTeamModel Teams) throws SQLException{
    	Connection myConnection = DBHandler.getConnection();
    	data = FXCollections.observableArrayList();
    	data2 = FXCollections.observableArrayList();
    	data.removeAll(data);
    	data2.removeAll(data2);
    	TeamSelected = Teams;
    	int TeamID =TeamSelected.getTeamID();
    	XYChart.Series<String, Integer> series1 = new XYChart.Series<>();
		XYChart.Series<String, Integer> series2 = new XYChart.Series<>();
		series1.setName("Wins");
		series2.setName("Losses");

    	try {
    		ResultSet rs = myConnection.createStatement().executeQuery("SELECT userName FROM users WHERE userTeamID ="+TeamID+" and userRoleID<>1");
    		ResultSet rs2 = myConnection.createStatement().executeQuery("SELECT Count(OutcomeWin_UserID) FROM matches WHERE OutcomeWin_UserID="+TeamID+" ");
    		ResultSet rs3 = myConnection.createStatement().executeQuery("SELECT Count(OutcomeLoss_UserID) FROM matches WHERE OutcomeLoss_UserID="+TeamID+" ");
    		ResultSet rs4 = myConnection.createStatement().executeQuery("SELECT TournamentName FROM tournament WHERE tournamentWinner_TeamID="+TeamID+" ");
    		while (rs.next()){
    			data.add((rs.getString(1)));
    		}
    		while (rs2.next()){
    			Integer win = rs2.getInt(1);
    			series1.getData().add(new XYChart.Data<String, Integer>("", win));
    		}
    		while (rs3.next()){
    			Integer lose = rs3.getInt(1);
    			series2.getData().add(new XYChart.Data<String, Integer>("", lose));
    		}
    		while (rs4.next()){
    			data2.add((rs4.getString(1)));
    		}
    		PlayerList.setItems(data);
    		TourniesWon.setItems(data2);
    		MatchWinloseChart.getData().add(series1);
    		MatchWinloseChart.getData().add(series2);
    		
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
	
	@FXML
	private void goBackToGuestPastMatches() throws IOException{
		DetailsGoBackButton.getScene().getWindow().hide();
        loader.setLocation(getClass().getResource("/arenaViews/GuestTeams.fxml"));
        scene = new Scene(loader.load());
        stage.setScene(scene);
        stage.setResizable(false);
        stage.getIcons().add(new Image(getClass().getResourceAsStream("/images/arenaIcon.png")));
        stage.setTitle("Arena");
        stage.show();
	}
}

