package arenaClasses;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextArea;
import com.jfoenix.controls.JFXTextField;

import arenaModels.UserModels;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import javafx.stage.StageStyle;


public class LeagueOwnerNewLeagueController extends Main{
	@FXML
	private Label NewLeagueLabel;
	@FXML
	private Label LeagueNameLabel;
	@FXML
	private Label LeagueDescriptionLabel;
	@FXML
	private Label LeagueRankingFormulaLabel;
	@FXML
	private JFXTextField LeagueNameTextField;
	@FXML
	private JFXTextArea LeagueDescriptionTextField;
	@FXML
	private ChoiceBox LeagueRankingsDropdown;
	@FXML
	private JFXButton CreateLeagueButton;
	@FXML
	private JFXButton LeagueGoBackButton;
	@FXML 
	private ImageView progress;
	@FXML
	private Label closeIcon;
	
Scene scene;
Stage stage = new Stage();
static String currName, currUserID;


    @FXML
    private void goBackLeagueSplash(ActionEvent event) throws Exception {
    	LeagueGoBackButton.getScene().getWindow().hide();
        loader.setLocation(getClass().getResource("/arenaViews/LeagueOwnerLanding.fxml"));
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
    private void handleClose(MouseEvent event) {
        System.exit(0);
    }
    @FXML
    private void CreateLeague(ActionEvent event) throws SQLException, IOException{
    	Connection myConnection = DBHandler.getConnection();
    	String createLeagueQuery = "INSERT INTO league (LeagueName, ExpertRatingFormula_ExpertRatingFormulaID, users_userID_LeagueOwner, Arena_ArenaID, LeagueDesc) "
			+ "VALUES (?, ?, ?, ?, ?)";
	try
	{
		// These methods modify the initial string values above

		String LeagueName = LeagueNameTextField.getText();
		int eRFID = 990001;
		int userID= UserModels.getUserID();
		int arenaID = 50001;
		String LeagueDescrip = LeagueDescriptionTextField.getText();
				
		PreparedStatement preparedStatement = myConnection.prepareStatement(createLeagueQuery);
		preparedStatement.setString (1, LeagueName);
		preparedStatement.setInt (2, eRFID);
		preparedStatement.setInt (3, userID);
		preparedStatement.setInt (4, arenaID);
		preparedStatement.setString (5, LeagueDescrip);

		preparedStatement.execute();
	}
	catch(Exception ex)
	{
		System.out.println("Error: " + ex);
	}
	finally {
		// Close Connection
		myConnection.close();
	}
}}