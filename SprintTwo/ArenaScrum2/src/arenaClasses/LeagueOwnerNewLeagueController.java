package arenaClasses;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextArea;
import com.jfoenix.controls.JFXTextField;
import arenaModels.ChoiceExpertRatingFormula;
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


public class LeagueOwnerNewLeagueController extends Main{
	@FXML
	private Label NewLeagueLabel;
	@FXML
	private Label LeagueNameLabel;
	@FXML
	private Label LeagueCreatedLabel;
	@FXML
	private Label NewLeagueError;
	@FXML
	private Label LeagueDescriptionLabel;
	@FXML
	private Label LeagueRatingFormulaLabel;
	@FXML
	private JFXTextField LeagueNameTextField;
	@FXML
	private JFXTextArea LeagueDescriptionTextField;
	@FXML
	private JFXButton loadTableButton;
	@FXML
	private JFXButton CreateLeagueButton;
	@FXML
	private JFXButton LeagueGoBackButton;
	@FXML 
	private ImageView progress;
	@FXML
	private Label closeIcon;
	@FXML
	private TableView<ChoiceExpertRatingFormula> ExpertTable;
	@FXML
	private TableColumn<ChoiceExpertRatingFormula, String> columnExpertFormula;
	
Scene scene;
Stage stage = new Stage();
static String currName, currUserID;
private ObservableList<ChoiceExpertRatingFormula>ExpertRatingFormulalist;


    @FXML
    private void goBackLeagueSplash(ActionEvent event) throws Exception {
    	LeagueGoBackButton.getScene().getWindow().hide();
        loader.setLocation(getClass().getResource("/arenaViews/leagueOwnerLanding.fxml"));
        scene = new Scene(loader.load());
        stage.setScene(scene);
        stage.setResizable(false);
        stage.getIcons().add(new Image(getClass().getResourceAsStream("/images/arenaIcon.png")));
        stage.setTitle("Arena");
        stage.show();
        }
    @FXML
    private void handleClose(MouseEvent event) {
        System.exit(0);
    }
    
	@FXML
    private void loadTable() throws SQLException {
		Connection myConnection = DBHandler.getConnection();
		ExpertRatingFormulalist = FXCollections.observableArrayList();
		ExpertRatingFormulalist.removeAll(ExpertRatingFormulalist);
		try
		{
			ResultSet rs = myConnection.createStatement().executeQuery("SELECT ExpertRatingFormulaFormula FROM expertratingformula");
			while(rs.next())
			{
				ExpertRatingFormulalist.add(new ChoiceExpertRatingFormula(rs.getString("ExpertRatingFormulaFormula")));
			}
		}
		catch(SQLException e)
		{
			e.printStackTrace();
			System.out.println("ERROR @ LeagueOwnerNewLeagueController.Table");
		}
		JustDoloadTable();
		columnExpertFormula.setCellValueFactory(new PropertyValueFactory<>("ExpertRatingFormulaFormula"));
		ExpertTable.setItems(ExpertRatingFormulalist);
    }
	private void JustDoloadTable() throws SQLException
	{
		Connection myConnection = DBHandler.getConnection();
		ExpertRatingFormulalist = FXCollections.observableArrayList();
		ExpertRatingFormulalist.removeAll(ExpertRatingFormulalist);
		try
		{
			ResultSet rs = myConnection.createStatement().executeQuery("SELECT ExpertRatingFormulaFormula FROM expertratingformula");
			while(rs.next())
			{
				ExpertRatingFormulalist.add(new ChoiceExpertRatingFormula(rs.getString("ExpertRatingFormulaFormula")));
			}
		}
		catch(SQLException e)
		{
			e.printStackTrace();
			System.out.println("ERROR @ LeagueOwnerNewLeagueController.Table");
		}
		columnExpertFormula.setCellValueFactory(new PropertyValueFactory<>("ExpertRatingFormulaFormula"));
		ExpertTable.setItems(ExpertRatingFormulalist);
	}
    @FXML
    private void CreateLeague(ActionEvent event) throws SQLException, IOException{
    	Connection myConnection = DBHandler.getConnection();
    	String LeagueName;
    	LeagueCreatedLabel.setVisible(false);
    	NewLeagueError.setVisible(false);
    	String createLeagueQuery = "INSERT INTO league (LeagueName, ExpertRatingFormula_ExpertRatingFormulaID, users_userID_LeagueOwner, Arena_ArenaID, LeagueDesc) "
			+ "VALUES (?, ?, ?, ?, ?)";
		ChoiceExpertRatingFormula ExpertRank = ExpertTable.getSelectionModel().getSelectedItem();
		String selectedFormula = ExpertRank.getExpertRatingFormulaFormula();
		String sqlSelect = "SELECT ExpertRatingFormulaID From expertratingformula WHERE ExpertRatingFormulaFormula ='"+selectedFormula+"'";
    	int eRFID;
    	LeagueName = LeagueNameTextField.getText();
		int userID= UserModels.getUserID();
		int arenaID = 50001;
		String LeagueDescrip = LeagueDescriptionTextField.getText();
    	
    	
	try
	{
		// These methods modify the initial string values above
		ResultSet rs = myConnection.createStatement().executeQuery(sqlSelect);
		while (rs.next()){
			eRFID = rs.getInt(1);
			PreparedStatement preparedStatement = myConnection.prepareStatement(createLeagueQuery);
			preparedStatement.setString (1, LeagueName);
			preparedStatement.setInt (2, eRFID);
			preparedStatement.setInt (3, userID);
			preparedStatement.setInt (4, arenaID);
			preparedStatement.setString (5, LeagueDescrip);
			preparedStatement.execute();
		}
		LeagueCreatedLabel.setText("League "+LeagueName+" created.");
		LeagueCreatedLabel.setVisible(true);
	}
	catch(SQLException e)
	{
		e.printStackTrace();
        System.out.println("ERROR @ Control.createLeague");
		NewLeagueError.setVisible(true);
	}
	finally {
		// Close Connection
		myConnection.close();
	}
}}