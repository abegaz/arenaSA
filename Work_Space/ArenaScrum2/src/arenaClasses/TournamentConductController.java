package arenaClasses;

import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.chart.LineChart;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.TextFieldListCell;
import javafx.scene.image.Image;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import javafx.util.StringConverter;
import javafx.fxml.Initializable;
import arenaClasses.DBHandler;

public class TournamentConductController extends Main implements Initializable
{
    @FXML private Label closeIcon;
    @FXML private JFXButton teamsGoBack;
    @FXML private JFXButton makeMatchBeginButton;
    @FXML private JFXComboBox<KeyValuePair> selectLeagueConductTour;
    @FXML private ListView<KeyValueMatchData> matchListView;
    @FXML private JFXComboBox<KeyValuePair> selectTournamentConductTour;
    @FXML private JFXButton addNewScoreButton;
    @FXML private JFXButton finalizeScoresButton;
    @FXML private Label team1Label;
    @FXML private Label team1ScoreLabel;
    @FXML private Label team2Label;
    @FXML private Label team2ScoreLabel;
    @FXML private Label team1LabelValue;
    @FXML private Label team2LabelValue;
    @FXML private Label currentMatchLabel;
    @FXML private TextField team1ScoreValueTextField;
    @FXML private TextField team2ScoreValueTextField;
    @FXML private LineChart<?, ?> scoresGraph;
    @FXML private JFXButton makeMatchCanelButton;

    private String selectedMatch = null;
    KeyValueMatchData keyValueMatchData = new KeyValueMatchData(null, null, null, null, null, null, null);
    Scene scene;
    Stage stage = new Stage();

    ObservableList<KeyValuePair> leagueNameList;
    ObservableList<KeyValuePair> tournamentNameList;
    ObservableList<KeyValueMatchData> matchIDList;

    class KeyValueMatchData
    {
    	private String matchID;
    	private String matchTeam1Name;
    	private String matchTeam2Name;
    	private String matchTeam1ID;
    	private String matchTeam2ID;
    	private String gameID;
    	private String gameName;

    	public KeyValueMatchData(String matchID, String matchTeam1Name, String matchTeam2Name, String matchTeam1ID, String matchTeam2ID, String gameID, String gameName)
        {
            this.matchID = matchID;
            this.matchTeam1Name = matchTeam1Name;
            this.matchTeam2Name = matchTeam2Name;
            this.matchTeam1ID = matchTeam1ID;
            this.matchTeam2ID = matchTeam2ID;
            this.gameID = gameID;
            this.gameName = gameName;
        }
    	public String getMatchID()
    	{
			return matchID;
		}
		public void setMatchID(String matchID)
		{
			this.matchID = matchID;
		}
		public String getMatchTeam1Name()
		{
			return matchTeam1Name;
		}
		public void setMatchTeam1Name(String matchTeam1Name)
		{
			this.matchTeam1Name = matchTeam1Name;
		}
		public String getMatchTeam2Name()
		{
			return matchTeam2Name;
		}
		public void setMatchTeam2Name(String matchTeam2Name)
		{
			this.matchTeam2Name = matchTeam2Name;
		}
		public String getMatchTeam1ID()
		{
			return matchTeam1ID;
		}
		public void setMatchTeam1ID(String matchTeam1ID)
		{
			this.matchTeam1ID = matchTeam1ID;
		}
		public String getMatchTeam2ID()
		{
			return matchTeam2ID;
		}
		public void setMatchTeam2ID(String matchTeam2ID)
		{
			this.matchTeam2ID = matchTeam2ID;
		}
		public String getGameID()
    	{
			return gameID;
		}
		public void setGameID(String gameID)
		{
			this.gameID = gameID;
		}
		public String getGameName()
    	{
			return gameName;
		}
		public void setGameName(String gameName)
		{
			this.gameName = gameName;
		}
		public String getFormatedInfo()
		{
			String formattedInfo = null;
			formattedInfo = (matchID + ": " + matchTeam1Name + " VS. " + matchTeam2Name);
			return formattedInfo;
		}
    }
    class KeyValuePair
    {
        private final String key;
        private final String value;

        public KeyValuePair(String key, String value)
        {
            this.key = key;
            this.value = value;
        }
        public String getKey()
        {
            return key;
        }
        public String getValue()
        {
            return value;
        }
    }

    @Override
    public void initialize(URL location, ResourceBundle resources)
    {
    	System.out.println("initialize() Called");
       	try
       	{
       		PopulateLeagueComboBox();
       	    selectTournamentConductTour.setDisable(true);
       	    matchListView.setDisable(true);
       	    currentMatchLabel.setDisable(true);
       	    addNewScoreButton.setDisable(true);
       	    finalizeScoresButton.setDisable(true);
       	}
       	catch (Exception e)
       	{
    		e.printStackTrace();
       	}
    }
    @FXML
    private void closeApplication(MouseEvent event)
    {
    	System.exit(0);
    }
    @FXML
    private void goToLOLanding(ActionEvent event) throws Exception
    {
     	teamsGoBack.getScene().getWindow().hide();
        loader.setLocation(getClass().getResource("/arenaViews/leagueOwnerLanding.fxml"));
        scene = new Scene(loader.load());
        stage.setScene(scene);
        stage.setResizable(false);
        stage.getIcons().add(new Image(getClass().getResourceAsStream("/images/arenaIcon.png")));
        stage.setTitle("Arena");
        stage.show();
     }
    void PopulateLeagueComboBox() throws SQLException
    {
    	System.out.println("PopulateLeagueComboBox() Called");
    	// Create Connection
    	Connection connection = DBHandler.getConnection();
    	// Get Current User ID League Names Query
    	System.out.println("Current UserID: " + Controller.currUserID);
    	String leagueNames = "SELECT LeagueID, LeagueName FROM league WHERE users_userID_LeagueOwner = '" + Controller.currUserID + "'";
    	// Creates Observable Array
    	leagueNameList = FXCollections.observableArrayList();
    	try
    	{
    		ResultSet rs = connection.createStatement().executeQuery(leagueNames);
    		while (rs.next())
    		{
    			KeyValuePair keyValuePairLeagues = new KeyValuePair(rs.getString("LeagueID"), rs.getString("LeagueName"));
    			leagueNameList.add(keyValuePairLeagues);
    		}
    		selectLeagueConductTour.setItems(leagueNameList);
    	}
    	catch(SQLException e)
    	{
    		e.printStackTrace();
    		System.out.println("ERROR @ Control.removeUser.First Try");
    	}

    	selectLeagueConductTour.setConverter(new StringConverter<KeyValuePair>()
    	{
            @Override
            public String toString(KeyValuePair object)
            {
                return object.getValue();
            }
            @Override
            public KeyValuePair fromString(String string)
            {
                return null; // No conversion fromString needed.
            }
        });
    	selectLeagueConductTour.valueProperty().addListener((ov, oldVal, newVal) ->
    	{
             //System.out.println(newVal.getValue() + "'s League ID:" + newVal.getKey());
             //System.out.println("Call PopulateTournamentsComboBox("+ newVal.getKey()+");");
             try
             {
            	 if (newVal != null)
                 {
                 	PopulateTournamentsComboBox(newVal.getKey());
                 }
             	else
             	{
             		System.out.println("Nothing is here");
             	}
             }
             catch (SQLException e)
             {
				e.printStackTrace();
             }
     		 matchListView.getSelectionModel().clearSelection();
     		 matchListView.getItems().clear();
        });
    }
    void PopulateTournamentsComboBox(String LeagueID) throws SQLException
    {
    	System.out.println("PopulateTournamentsComboBox("+LeagueID+")");
    	// Create Connection
    	Connection connection = DBHandler.getConnection();
    	String TournamentNames = "SELECT TournamentID, TournamentName FROM tournament WHERE League_LeagueID = '" + LeagueID + "'";
    	// Creates Observable Array
    	tournamentNameList = FXCollections.observableArrayList();
    	try
    	{
    		ResultSet rs = connection.createStatement().executeQuery(TournamentNames);
    		while (rs.next())
    		{
    			KeyValuePair keyValuePairTournaments = new KeyValuePair(rs.getString("TournamentID"), rs.getString("TournamentName"));
    			tournamentNameList.add(keyValuePairTournaments);
    		}
    		selectTournamentConductTour.setItems(tournamentNameList);
    		selectTournamentConductTour.setDisable(false);
    	}
    	catch(SQLException e)
    	{
    		e.printStackTrace();
    		System.out.println("ERROR @ Control.removeUser.First Try");
    	}

    	selectTournamentConductTour.setConverter(new StringConverter<KeyValuePair>()
    	{
            @Override
            public String toString(KeyValuePair object)
            {
                return object.getValue();
            }
            @Override
            public KeyValuePair fromString(String string)
            {
                return null; // No conversion fromString needed.
            }
        });
    	selectTournamentConductTour.valueProperty().addListener((ov, oldVal, newVal) ->
    	{
            try
            {
            	if (newVal != null)
            	{
                	PopulateMatchListView(newVal.getKey());
            	}
            	else
            	{
            		System.out.println("Nothing is here");
            	}
			}
            catch (SQLException e)
            {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
        });
    }
    void PopulateMatchListView(String TrounamentID) throws SQLException
    {
    	//System.out.println("PopulateMatchListView("+TrounamentID+")");
    	// Create Connection
    	Connection connection = DBHandler.getConnection();
    	String TournamentNames = "SELECT MatchID, team1.TeamName, team2.TeamName, teams_TeamID1, teams_TeamID2, Game_GameID, game.GameName  FROM matches, teams team1, teams team2, game "
    			+ "WHERE team1.TeamID = teams_TeamID1 AND team2.TeamID = teams_TeamID2 AND Game_GameID = game.GameID AND "
    			+ "Tournament_TournamentID = '" + TrounamentID + "' AND MatchStatus_MatchStatusID = '0'";
    	matchIDList = FXCollections.observableArrayList();
    	try
    	{
    		ResultSet rs = connection.createStatement().executeQuery(TournamentNames);
    		while (rs.next())
    		{
    			String matchID = rs.getString("MatchID");
    			String team1Name = rs.getString("team1.TeamName");
    			String team2Name = rs.getString("team2.TeamName");
    			String team1ID = rs.getString("teams_TeamID1");
    			String team2ID = rs.getString("teams_TeamID2");
    			String gameID = rs.getString("Game_GameID");
    			String gameName = rs.getString("game.GameName");

    			KeyValueMatchData keyValuePairMatches = new KeyValueMatchData(matchID , team1Name, team2Name, team1ID, team2ID, gameID, gameName);
    			//KeyValueMatchData keyValuePairMatches = new KeyValueMatchData(matchID , matchID + ": " + team1Name + " VS. " + team2Name);
    			matchIDList.add(keyValuePairMatches);	//Stores custom object to listView
    		}
    		matchListView.setDisable(false);
    		matchListView.setItems(matchIDList);
    		matchListView.setCellFactory(lv -> {
    	        TextFieldListCell<KeyValueMatchData> cell = new TextFieldListCell<KeyValueMatchData>();
    	        cell.setConverter(new StringConverter<KeyValueMatchData>()
    	        {
    	        	 @Override
    	             public String toString(KeyValueMatchData object)
    	             {
    	                 return object.getFormatedInfo();
    	             }
    	             @Override
    	             public KeyValueMatchData fromString(String string)
    	             {
    	                 return null; // No conversion fromString needed.
    	             }
    	        });
    	        return cell;
    	    });
    	}
    	catch(SQLException e)
    	{
    		e.printStackTrace();
    		System.out.println("ERROR @ Control.removeUser.First Try");
    	}
    }
    @FXML
    void setMatchToActive(ActionEvent event)
    {
    	String activeMatchStatusID = "1";
    	try
    	{
			Connection connection = DBHandler.getConnection();
			selectedMatch = matchListView.getSelectionModel().getSelectedItem().getMatchID();
			//System.out.println("setMatchToActive() Called");
			String matchStatusUpdateQuery = "UPDATE matches SET MatchStatus_MatchStatusID = ? WHERE MatchID = ?";
			PreparedStatement preparedStatement = connection.prepareStatement(matchStatusUpdateQuery);
			preparedStatement.setString(1, activeMatchStatusID);
			preparedStatement.setString(2, selectedMatch);
			preparedStatement.executeUpdate();

			currentMatchLabel.setText(matchListView.getSelectionModel().getSelectedItem().getFormatedInfo());
			currentMatchLabel.setDisable(false);

			team1LabelValue.setText(matchListView.getSelectionModel().getSelectedItem().getMatchTeam1Name());
			team2LabelValue.setText(matchListView.getSelectionModel().getSelectedItem().getMatchTeam2Name());

			selectLeagueConductTour.setDisable(true);
			selectTournamentConductTour.setDisable(true);
			matchListView.setDisable(true);
			makeMatchBeginButton.setDisable(true);
			addNewScoreButton.setDisable(false);
		}
    	catch (SQLException e)
    	{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }

    @FXML
    void addNewScore(ActionEvent event)
    {
    	System.out.println("addNewScore()");
    	finalizeScoresButton.setDisable(false);
    	try
    	{
    		String ongoingScoreStatusValue = "1";
    		String insertNewScoreQuery = "INSERT INTO scores (match_MatchID, game_GameID, Team1_Score, Team2_Score, teams_TeamID2, teams_TeamID1, ScoreStatusTable_idScoreStatusTable) "
    				+ "VALUES (?, ?, ?, ?, ?, ?, ?)";
    		Connection connection = DBHandler.getConnection();

    		String team1ScoreValue = team1ScoreValueTextField.getText();
    		String team2ScoreValue = team2ScoreValueTextField.getText();
    		String gameID = matchListView.getSelectionModel().getSelectedItem().getGameID();
    		String matchID = matchListView.getSelectionModel().getSelectedItem().getMatchID();
    		String teamID1 = matchListView.getSelectionModel().getSelectedItem().getMatchTeam1ID();
    		String teamID2 = matchListView.getSelectionModel().getSelectedItem().getMatchTeam2ID();

    		PreparedStatement preparedStatement = connection.prepareStatement(insertNewScoreQuery);
			preparedStatement.setString(1, matchID);
			preparedStatement.setString(2, gameID);
			preparedStatement.setString(3, team1ScoreValue);
			preparedStatement.setString(4, team2ScoreValue);
			preparedStatement.setString(5, teamID1);
			preparedStatement.setString(6, teamID2);
			preparedStatement.setString(7, ongoingScoreStatusValue);
			preparedStatement.executeUpdate();

	    	finalizeScoresButton.setDisable(false);
			team1ScoreValueTextField.clear();
			team2ScoreValueTextField.clear();
    	}
    	catch(Exception exception)
    	{
    		exception.printStackTrace();
    	}
    }

    @FXML
    void requestFinializedScores(ActionEvent event)
    {
    	System.out.println("requestFinializedScores()");

    	String pendingScoresApprovalStatusID = "2";

		String scoresSetCancelledStatusQuery = "UPDATE scores SET ScoreStatusTable_idScoreStatusTable = '"+ pendingScoresApprovalStatusID +"' "
				+ "WHERE match_MatchID = ? and game_GameID = ? and teams_TeamID2 = ? and teams_TeamID1 = ?";
		String currentMatchID = matchListView.getSelectionModel().getSelectedItem().getMatchID();
		String currentMatchGameID = matchListView.getSelectionModel().getSelectedItem().getGameID();
		String currentMatchTeam1ID = matchListView.getSelectionModel().getSelectedItem().getMatchTeam1ID();
		String currentMatchTeam2ID = matchListView.getSelectionModel().getSelectedItem().getMatchTeam2ID();
		try
    	{
			Connection connection = DBHandler.getConnection();

			PreparedStatement pendApprovalScoreStatus = connection.prepareStatement(scoresSetCancelledStatusQuery);
			pendApprovalScoreStatus.setString(1, currentMatchID);
			pendApprovalScoreStatus.setString(2, currentMatchGameID);
			pendApprovalScoreStatus.setString(3, currentMatchTeam1ID);
			pendApprovalScoreStatus.setString(4, currentMatchTeam2ID);
			pendApprovalScoreStatus.executeUpdate();
    	}
    	catch (SQLException e)
    	{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }

    @FXML
    void setMatchToCancelled(ActionEvent event)
    {
    	String cancelledMatchStatusID = "3";
    	String cancelledScoresMatchStatusID = "5";
    	try
    	{
			Connection connection = DBHandler.getConnection();
			selectedMatch = matchListView.getSelectionModel().getSelectedItem().getMatchID();
			//System.out.println("setMatchToActive() Called");
			String matchStatusUpdateQuery = "UPDATE matches SET MatchStatus_MatchStatusID = ? WHERE MatchID = ?";
			PreparedStatement preparedStatement = connection.prepareStatement(matchStatusUpdateQuery);
			preparedStatement.setString(1, cancelledMatchStatusID);
			preparedStatement.setString(2, selectedMatch);
			preparedStatement.executeUpdate();

			String scoresSetCancelledStatusQuery = "UPDATE scores SET ScoreStatusTable_idScoreStatusTable = '"+ cancelledScoresMatchStatusID +"' "
					+ "WHERE match_MatchID = ? and game_GameID = ? and teams_TeamID2 = ? and teams_TeamID1 = ?";
			String currentMatchID = matchListView.getSelectionModel().getSelectedItem().getMatchID();
			String currentMatchGameID = matchListView.getSelectionModel().getSelectedItem().getGameID();
			String currentMatchTeam1ID = matchListView.getSelectionModel().getSelectedItem().getMatchTeam1ID();
			String currentMatchTeam2ID = matchListView.getSelectionModel().getSelectedItem().getMatchTeam2ID();
			PreparedStatement cancelledMatchScoreStatus = connection.prepareStatement(scoresSetCancelledStatusQuery);
			cancelledMatchScoreStatus.setString(1, currentMatchID);
			cancelledMatchScoreStatus.setString(2, currentMatchGameID);
			cancelledMatchScoreStatus.setString(3, currentMatchTeam1ID);
			cancelledMatchScoreStatus.setString(4, currentMatchTeam2ID);
			cancelledMatchScoreStatus.executeUpdate();

			currentMatchLabel.setText("");
			currentMatchLabel.setDisable(false);

			team1LabelValue.setText("");
			team2LabelValue.setText("");

			selectLeagueConductTour.getSelectionModel().clearSelection();
			selectLeagueConductTour.setDisable(false);
			selectTournamentConductTour.getSelectionModel().clearSelection();
			matchListView.getSelectionModel().clearSelection();
			matchListView.getItems().clear();
			makeMatchBeginButton.setDisable(false);

		}
    	catch (SQLException e)
    	{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
}
