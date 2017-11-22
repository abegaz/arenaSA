package arenaClasses;

import arenaClasses.DBHandler;
import arenaModels.TournamentData;
import com.jfoenix.controls.JFXButton;
import java.net.URL;
import java.sql.*;
import java.time.LocalDate;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

public class TournamentController extends Main implements Initializable
{
	@FXML private Label closeIcon;
    @FXML private Label errorLabel;
    @FXML private TableView<TournamentData> getTournamentsTable;
    @FXML private TableColumn<TournamentData, String> getTournamentsTournamentNameColumn;
    @FXML private TableColumn<TournamentData, String> getTournamentsTournamentDescriptionColumn;
    @FXML private TableColumn<TournamentData, String> getTournamentsLeagueNameColumn;
    @FXML private TableColumn<TournamentData, String> getTournamentsTournamentStyleColumn;
    @FXML private TableColumn<TournamentData, String> getTournamentsTournamentDateColumn;
    @FXML private Label loadMe;
    @FXML private JFXButton getLeagueReturn;
    @FXML private JFXButton tournamentRefresh;
    @FXML private JFXButton createNewTournament;
    @FXML private TextField createTournamentLeagueIDField;
    @FXML private TextField createTournamentStyleIDField;
    @FXML private TextField createTournamentDescField;
    @FXML private TextField createTournamentNameField;
    @FXML private TextField createTournamentDateField;
    @FXML private JFXButton manageTournamentsRemoveButton;
    @FXML private ChoiceBox<String> ChoiceBoxLeague;
    @FXML private ChoiceBox<String> ChoiceBoxTournamentStyle;
    @FXML private DatePicker createTournamentDatePicker;

    Scene scene;
    Stage stage = new Stage();
    Controller controller = new Controller();

    private ObservableList<TournamentData> tournamentDataArray;
    //Initialize observable list to hold database data

    public void loadTournamentsFromDatabase(ActionEvent event) throws SQLException
    {
    	//System.out.println("loadTournamentsFromDatabase");
    	Connection connection = DBHandler.getConnection();

    	tournamentDataArray = FXCollections.observableArrayList();
    	// Execute query and store results
    	String getTournamentDataQuery =  "SELECT TournamentName, TournamentDescription, tournamentDate, leagueName, TournamentStyleCodeName FROM tournament, league, tournamentstylecode WHERE League_LeagueID = leagueID AND TournamentStyleCodeID = TournamentStyleCode_TournamentStyleCodeID AND users_userID_LeagueOwner ='" + Controller.currUserID +"'";
    	try
    	{
    		ResultSet rs = connection.createStatement().executeQuery(getTournamentDataQuery);
			while (rs.next())
			{
				String tournamentName = rs.getString("TournamentName");
				String tournamentDesc = rs.getString("TournamentDescription");
				String tournamentLeagueName = rs.getString("leagueName");
				String tournamentStyleName = rs.getString("TournamentStyleCodeName");
				String tournamentDate = rs.getString("tournamentDate");
				tournamentDataArray.add(new TournamentData (tournamentName, tournamentDesc, tournamentLeagueName, tournamentStyleName, tournamentDate));
			}

			getTournamentsTournamentNameColumn.setCellValueFactory(new PropertyValueFactory<>("tournamentName"));
			getTournamentsTournamentDescriptionColumn.setCellValueFactory(new PropertyValueFactory<>("tournamentDesc"));
			getTournamentsLeagueNameColumn.setCellValueFactory(new PropertyValueFactory<>("tournamentLeagueName"));
			getTournamentsTournamentStyleColumn.setCellValueFactory(new PropertyValueFactory<>("tournamentStyleName"));
			getTournamentsTournamentDateColumn.setCellValueFactory(new PropertyValueFactory<>("tournamentDate"));

			getTournamentsTable.setItems(null);
			getTournamentsTable.setItems(tournamentDataArray);
		}
    	catch(Exception ex)
		{
			System.out.println("Error: " + ex);
		}
    }
    public String getLeagueID(String leagueName) throws SQLException
    {
    	String leaugeID = null;
    	Connection connection = DBHandler.getConnection();
    	String getLeaugeIDWithLeagueNameQuery = "SELECT LeagueID FROM league WHERE LeagueName = '" + leagueName + "'";

    	try
    	{
			ResultSet rs = connection.createStatement().executeQuery(getLeaugeIDWithLeagueNameQuery);
			while (rs.next())
			{
				leaugeID = rs.getString("LeagueID");
				return leaugeID;
			}
		}
    	catch (SQLException e)
    	{
			e.printStackTrace();
			return null;
		}

		return null;
    }
    public String getTournamentStyleID(String tournamentStyleName) throws SQLException
    {
    	String tournamentStyleCodeID = null;
    	Connection connection = DBHandler.getConnection();
    	String getTournamentStyleCodeIDWithLeagueNameQuery = "SELECT TournamentStyleCodeID FROM tournamentstylecode WHERE TournamentStyleCodeName = '" + tournamentStyleName + "'";

    	try
    	{
			ResultSet rs = connection.createStatement().executeQuery(getTournamentStyleCodeIDWithLeagueNameQuery);
			while (rs.next())
			{
				tournamentStyleCodeID= rs.getString("TournamentStyleCodeID");
				return tournamentStyleCodeID;
			}
		}
    	catch (SQLException e)
    	{
			e.printStackTrace();
			return null;
		}

		return null;
    }
    public String getPickedDate()
    {
    	String datePicked = null;
    	LocalDate localDate = createTournamentDatePicker.getValue();

    	datePicked = localDate.toString();

    	return datePicked;
    }
   // DBHandler databaseConnector = new DBHandler();

    @Override
	public void initialize(URL location, ResourceBundle resources)
    {
    	try
    	{
			populateChoiceBoxLeagueWithLeagueOwnerLeagues();
			populateChoiceBoxTournamentStyleWithLeagueOwnerLeagues();
	    	loadTournamentsFromDatabase(null);
    		System.out.println("");
		}
    	catch (Exception e)
    	{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
    @FXML
    private void closeApplication(MouseEvent event)
    {
        System.exit(0);
    }
    @FXML
    private void goBackToLOLanding(ActionEvent event) throws Exception
    {
    	getLeagueReturn.getScene().getWindow().hide();
    	loader.setLocation(getClass().getResource("/arenaViews/leagueOwnerLanding.fxml"));
    	scene = new Scene(loader.load());
    	stage.setScene(scene);
    	stage.setResizable(false);
    	stage.getIcons().add(new Image(getClass().getResourceAsStream("/images/arenaIcon.png")));
    	stage.setTitle("Arena");
    	stage.show();
    }
    @FXML
    private void goToCreateTournamentsView(ActionEvent event) throws Exception
    {
    	createNewTournament.getScene().getWindow().hide();
    	loader.setLocation(getClass().getResource("/arenaViews/CreateTournaments.fxml"));
    	scene = new Scene(loader.load());
    	stage.setScene(scene);
    	stage.setResizable(false);
    	stage.getIcons().add(new Image(getClass().getResourceAsStream("/images/arenaIcon.png")));
    	stage.setTitle("Arena");
    	stage.show();
    }
    @FXML
    private void createTournament(ActionEvent event)
    {
    	try
    	{
    		String choiceBoxLeagueValue = ChoiceBoxLeague.getValue();
    		String choiceBoxTournamentStyleValue = ChoiceBoxTournamentStyle.getValue();

    		Connection connection = DBHandler.getConnection();

			String leagueID = getLeagueID(choiceBoxLeagueValue);
			String tourStyleID = getTournamentStyleID(choiceBoxTournamentStyleValue);
			String tourDesc = createTournamentDescField.getText();
			String tourName = createTournamentNameField.getText();
			String tourDate = getPickedDate();
			String addNewTournamentQuery = "INSERT INTO tournament (TournamentName,TournamentDescription,League_LeagueID,TournamentStyleCode_TournamentStyleCodeID,tournamentDate)"
				+ " VALUES (?,?,?,?,?)";

			PreparedStatement preparedStmt = connection.prepareStatement(addNewTournamentQuery);
			preparedStmt.setString (1, tourName);
			preparedStmt.setString (2, tourDesc);
			preparedStmt.setString (3, leagueID);
			preparedStmt.setString (4, tourStyleID);
			preparedStmt.setString (5, tourDate);

			// execute the preparedstatement
			preparedStmt.execute();

			//System.out.println(preparedStmt);
			createTournamentNameField.setText("");
			createTournamentDescField.setText("");
			ChoiceBoxTournamentStyle.getSelectionModel().clearSelection();
			ChoiceBoxLeague.getSelectionModel().clearSelection();
			//createTournamentDatePicker.
			loadTournamentsFromDatabase(null);
		}
    	catch(Exception ex)
		{
			ex.printStackTrace();
		}
    }
    @FXML
    private void removeTournament(ActionEvent event) throws SQLException
    {
    	Connection connection = DBHandler.getConnection();
    	TournamentData tournamentDataArray = getTournamentsTable.getSelectionModel().getSelectedItem();
    	String selectedTournamentName = tournamentDataArray.getTournamentName();
		System.out.println(selectedTournamentName);
		String deleteTournamentQuery = "DELETE FROM tournament WHERE tournament.TournamentName = '" + selectedTournamentName + "'";
		try
		{
			PreparedStatement preparedStmt = connection.prepareStatement(deleteTournamentQuery);
			preparedStmt.execute();
		}
		catch(SQLException e)
		{
			e.printStackTrace();
			System.out.println("ERROR @ Control.removeUser.First Try");
		}
		finally
		{
			connection.close();
		}
    }
    private void populateChoiceBoxLeagueWithLeagueOwnerLeagues() throws SQLException
    {
    	Connection connection = DBHandler.getConnection();
    	System.out.println("Current UserID:" + Controller.currUserID);
    	String getLeagueOwnerLeaguesToPopulateCreateTournamentsChoiceBox = "SELECT LeagueName FROM league league1, users users1 WHERE league1.users_userID_LeagueOwner = users1.userID AND userID = " + Controller.currUserID;
    	try
		{
    		ResultSet rs = connection.createStatement().executeQuery(getLeagueOwnerLeaguesToPopulateCreateTournamentsChoiceBox);

    		while (rs.next())
			{
				ChoiceBoxLeague.getItems().addAll(rs.getString("LeagueName"));
			}
		}
		catch(SQLException e)
		{
			e.printStackTrace();
			System.out.println("ERROR @ Control.removeUser.First Try");
		}

    }
    private void populateChoiceBoxTournamentStyleWithLeagueOwnerLeagues() throws SQLException
    {
    	Connection connection = DBHandler.getConnection();
    	String getLeagueOwnerLeaguesToPopulateCreateTournamentsChoiceBox = "SELECT TournamentStyleCodeName FROM tournamentstylecode";
    	try
		{
    		ResultSet rs = connection.createStatement().executeQuery(getLeagueOwnerLeaguesToPopulateCreateTournamentsChoiceBox);
			while (rs.next())
			{
				ChoiceBoxTournamentStyle.getItems().addAll(rs.getString("TournamentStyleCodeName"));
			}
		}
		catch(SQLException e)
		{
			e.printStackTrace();
			System.out.println("ERROR @ Control.removeUser.First Try");
		}

    }

}


