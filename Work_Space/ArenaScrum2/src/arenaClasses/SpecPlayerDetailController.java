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
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.stage.Stage;

public class SpecPlayerDetailController extends Main{


    @FXML
    private Label PlayerLabel;
    @FXML
    private JFXButton DetailsGoBackButton;
    @FXML
    private BarChart<String, Integer> TournyWinloseChart;
    @FXML
    private BarChart<String, Integer> MatchWinloseChart;

    
	private SpecPlayerModel PlayerSelected;
	
	Scene scene;
	Stage stage = new Stage();
	
    public void initData(SpecPlayerModel Select) throws SQLException{
    	PlayerSelected = Select;
    	PlayerLabel.setText(PlayerSelected.getuserName());

    }
    public void initalize(SpecPlayerModel Select){
    	
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
}
