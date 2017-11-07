package arenaClasses;

//import java.net.URL;
//import java.util.ResourceBundle;
import arenaClasses.DBHandler;

import com.jfoenix.controls.JFXButton;

import java.sql.*;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class TournamentController extends Main
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
    Scene scene;
    Stage stage = new Stage();

   //Initialize observable list to hold database data

    private ObservableList<TournamentData> tournamentDataArray;
   // DBHandler databaseConnector = new DBHandler();

   /* public void initialize(URL url, ResourceBundle rb) throws SQLException
    {
    	Connection connection = DBHandler.getConnection();
    } */
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
    	stage.initStyle(StageStyle.UNDECORATED);
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
    	stage.initStyle(StageStyle.UNDECORATED);
    	stage.setResizable(false);
    	stage.getIcons().add(new Image(getClass().getResourceAsStream("/images/arenaIcon.png")));
    	stage.setTitle("Arena");
    	stage.show();
    }
    @FXML
    private void loadTournamentsFromDatabase(ActionEvent event) throws SQLException
    {
    	//System.out.println("loadTournamentsFromDatabase");
    	Connection connection = DBHandler.getConnection();

    	tournamentDataArray = FXCollections.observableArrayList();
    	// Execute query and store results
    	String getTournamentDataQuery = ""
    			+ "SELECT Tournament.TournamentName, Tournament.TournamentDescription, Tournament.tournamentDate, League.leagueName, Tournamentstylecode.TournamentStyleCodeName "
    			+ "FROM Tournament tournament, League league, Tournamentstylecode tournamentstylecode "
    			+ "WHERE Tournament.League_LeagueID = League.leagueID AND Tournamentstylecode.TournamentStyleCodeID = Tournament.TournamentStyleCode_TournamentStyleCodeID";
    	try
    	{
    		ResultSet rs = connection.createStatement().executeQuery(getTournamentDataQuery);
			while (rs.next())
			{
				String tournamentName = rs.getString("Tournament.TournamentName");
				String tournamentDesc = rs.getString("Tournament.TournamentDescription");
				String tournamentLeagueName = rs.getString("League.leagueName");
				String tournamentStyleName = rs.getString("Tournamentstylecode.TournamentStyleCodeName");
				String tournamentDate = rs.getString("Tournament.tournamentDate");
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
    private void createTournament(ActionEvent event)
    {
    	try
    	{
			Connection connection = DBHandler.getConnection();
			String leagueID = createTournamentLeagueIDField.getText();
			String tourStyleID = createTournamentStyleIDField.getText();
			String tourDesc = createTournamentDescField.getText();
			String tourName = createTournamentNameField.getText();
			String tourDate = createTournamentDateField.getText();

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
		}
    	catch(Exception ex)
		{
			System.out.println("Error: " + ex);
		}
    }
    @FXML
    void removeTournament(ActionEvent event) throws SQLException
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
}

