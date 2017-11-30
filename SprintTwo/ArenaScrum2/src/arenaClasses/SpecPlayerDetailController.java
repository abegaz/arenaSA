package arenaClasses;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.jfoenix.controls.JFXButton;

import arenaModels.CurrentMatchSpecModel;
import arenaModels.SpecPlayerModel;
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

public class SpecPlayerDetailController extends Main{


    @FXML
    private Label PlayerLabel;
    @FXML
    private JFXButton DetailsGoBackButton;
    @FXML
    private BarChart<String, Integer> MatchWinloseChart;
    @FXML
    private CategoryAxis x;
    @FXML
    private NumberAxis y;
    @FXML
    private ListView<String> TournyWonList;

    private ObservableList<String> data2;
	private SpecPlayerModel PlayerSelected;
	
	Scene scene;
	Stage stage = new Stage();
	
    public void initData(SpecPlayerModel Select) throws SQLException{
    	PlayerSelected = Select;
    	PlayerLabel.setText(PlayerSelected.getuserName());

    }
    public void initalize(SpecPlayerModel Select) throws SQLException{
    	Connection myConnection = DBHandler.getConnection();
    	data2 = FXCollections.observableArrayList();
    	data2.removeAll(data2);
    	PlayerSelected = Select;
    	int userID =PlayerSelected.getuserID();
    	XYChart.Series<String, Integer> series1 = new XYChart.Series<>();
		XYChart.Series<String, Integer> series2 = new XYChart.Series<>();
		series1.setName("Wins");
		series2.setName("Losses");

    	try {
    		ResultSet rs2 = myConnection.createStatement().executeQuery("SELECT Count(*) FROM playerwin WHERE users_userID="+userID+" ");
    		ResultSet rs3 = myConnection.createStatement().executeQuery("SELECT Count(*)  FROM playerlose WHERE users_userID="+userID+" ");
    		ResultSet rs4 = myConnection.createStatement().executeQuery("SELECT TournamentName FROM tournament, playertournywin WHERE Tournament_TournamentID = TournamentID and users_userID="+userID+" ");

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
    		TournyWonList.setItems(data2);
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
	private void goBackToPlayer() throws IOException{
		DetailsGoBackButton.getScene().getWindow().hide();
        loader.setLocation(getClass().getResource("/arenaViews/SpectPlayer.fxml"));
        scene = new Scene(loader.load());
        stage.setScene(scene);
        stage.setResizable(false);
        stage.getIcons().add(new Image(getClass().getResourceAsStream("/images/arenaIcon.png")));
        stage.setTitle("Arena");
        stage.show();
	}
	@FXML
	private void goBackToGuestPlayer() throws IOException{
		DetailsGoBackButton.getScene().getWindow().hide();
        loader.setLocation(getClass().getResource("/arenaViews/GuestPlayers.fxml"));
        scene = new Scene(loader.load());
        stage.setScene(scene);
        stage.setResizable(false);
        stage.getIcons().add(new Image(getClass().getResourceAsStream("/images/arenaIcon.png")));
        stage.setTitle("Arena");
        stage.show();
	}
}
