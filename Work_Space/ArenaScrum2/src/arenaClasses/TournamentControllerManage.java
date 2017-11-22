package arenaClasses;

import arenaClasses.DBHandler;
import arenaModels.TournamentData;
import com.jfoenix.controls.JFXButton;
import java.sql.*;
import java.time.LocalDate;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
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

public class TournamentControllerManage extends Main
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
    public void initialize() throws SQLException, Exception
    {
    	loadTournamentsFromDatabase(null);
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
			loadTournamentsFromDatabase(null);
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

}


