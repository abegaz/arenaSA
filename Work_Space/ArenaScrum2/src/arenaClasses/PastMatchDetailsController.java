package arenaClasses;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.jfoenix.controls.JFXButton;

import arenaModels.CurrentMatchSpecModel;
import arenaModels.PastMatchDetailsModel;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.stage.Stage;




public class PastMatchDetailsController extends Main{
	@FXML
	private Label Team1Label;
	@FXML
	private Label Team2Label;
	@FXML
	private JFXButton DetailsGoBackButton;
    @FXML
    private LineChart<String, Integer> MatchChart;
    @FXML
    private CategoryAxis x;
    @FXML
    private NumberAxis y;

	private CurrentMatchSpecModel TeamSelected;
	
	Scene scene;
	Stage stage = new Stage();
	
    public void initData(CurrentMatchSpecModel Select){
    	TeamSelected = Select;
        Team1Label.setText(TeamSelected.getTeam1Name()+"\n"+"Final Score\n"+Integer.toString(TeamSelected.getTeam1_Score()));
    	Team2Label.setText(TeamSelected.getTeam2Name()+"\n"+"Final Score\n"+Integer.toString(TeamSelected.getTeam2_Score()));

    }
    
	@FXML
	private void goBackToPastMatches() throws IOException{
		DetailsGoBackButton.getScene().getWindow().hide();
        loader.setLocation(getClass().getResource("/arenaViews/PastMatches.fxml"));
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
        loader.setLocation(getClass().getResource("/arenaViews/GuestPastMatches.fxml"));
        scene = new Scene(loader.load());
        stage.setScene(scene);
        stage.setResizable(false);
        stage.getIcons().add(new Image(getClass().getResourceAsStream("/images/arenaIcon.png")));
        stage.setTitle("Arena");
        stage.show();
	}
	
	public void initalize(CurrentMatchSpecModel scorest) throws SQLException{
		Integer i = 1;
		TeamSelected = scorest;
		XYChart.Series<String, Integer> series1 = new XYChart.Series<>();
		XYChart.Series<String, Integer> series2 = new XYChart.Series<>();
		series1.setName(scorest.getTeam1Name());
		series2.setName(scorest.getTeam2Name());
		Connection myConnection = DBHandler.getConnection();
    	try {
    	ResultSet rs = myConnection.createStatement().executeQuery("SELECT Team1_Score, Team2_Score FROM scores WHERE match_MatchID="+TeamSelected.getMatchID()+" ");

    		while (rs.next()){
    		    Integer team1Score = rs.getInt(1);
    			Integer team2Score = rs.getInt(2);
    			series1.getData().add(new XYChart.Data<String, Integer>("Update "+i+"", team1Score));
    			series2.getData().add(new XYChart.Data<String, Integer>("Update "+i+"", team2Score));
    			i++;
    		}
    		MatchChart.getData().add(series1);
    		MatchChart.getData().add(series2);
    	}
    	
       finally
        {
       	myConnection.close();
        }
	}
}
