package arenaClasses;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import com.jfoenix.controls.JFXButton;
import arenaModels.CurrentMatchSpecModel;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

public class CurrentMatchSpectator extends Main{

	@FXML
	private JFXButton GoBackButton;
	@FXML
	private JFXButton MatchesRefreshButton;
	@FXML
	private TableView<CurrentMatchSpecModel> SpecCurrentTable;
	@FXML
	private TableColumn<CurrentMatchSpecModel, Integer> matchColumnMatchID;
	@FXML
	private TableColumn<CurrentMatchSpecModel, String> matchColumnGameName;
	@FXML
	private TableColumn<CurrentMatchSpecModel, String> matchColumnLeagueName;
	@FXML
	private TableColumn<CurrentMatchSpecModel, String> matchColumnTournamentName;
	@FXML
	private TableColumn<CurrentMatchSpecModel, String> matchColumnTeam1;
	@FXML
	private TableColumn<CurrentMatchSpecModel, String> matchColumnTeam2;
	@FXML
	private TableColumn<CurrentMatchSpecModel, Integer> matchColumnTeam1Score;
	@FXML
	private TableColumn<CurrentMatchSpecModel, Integer> matchColumnTeam2Score;
	@FXML
	private Label closeIcon;
	
	Scene scene;
	Stage stage = new Stage();
	private ObservableList<CurrentMatchSpecModel>data;

	@FXML
	private void goToSpecLanding() throws IOException{
    	GoBackButton.getScene().getWindow().hide();
        loader.setLocation(getClass().getResource("/arenaViews/spectatorLanding.fxml"));
        scene = new Scene(loader.load());
        stage.setScene(scene);
        stage.setResizable(false);
        stage.getIcons().add(new Image(getClass().getResourceAsStream("/images/arenaIcon.png")));
        stage.setTitle("Arena");
        stage.show();
	}
	
	@FXML
	private void goToGuestLanding() throws IOException{
    	GoBackButton.getScene().getWindow().hide();
        loader.setLocation(getClass().getResource("/arenaViews/GuestLanding.fxml"));
        scene = new Scene(loader.load());
        stage.setScene(scene);
        stage.setResizable(false);
        stage.getIcons().add(new Image(getClass().getResourceAsStream("/images/arenaIcon.png")));
        stage.setTitle("Arena");
        stage.show();
	}
	
    @FXML
    private void closeApplication(MouseEvent event) {
        System.exit(0);
    }
    
    @FXML
    private void LoadCurrentMatches() throws SQLException {
    	Connection myConnection = DBHandler.getConnection();
    	data = FXCollections.observableArrayList();
    	data.removeAll(data);
    	try {
    		ResultSet rs = myConnection.createStatement().executeQuery("Select M.MatchID, G.GameName, L.LeagueName, T.TournamentName, M.teams_TeamID1, M.teams_TeamID2, S.Team1_Score, S.Team2_Score FROM league AS L, tournament AS T, scores AS S, teams AS A, teams AS B, matches AS M, game AS G WHERE M.Game_GameID=G.GameID and S.match_MatchID = M.MatchID and L.LeagueID=T.League_LeagueID and T.TournamentID=M.Tournament_TournamentID and A.TeamID=M.teams_TeamID1 and B.TeamID=M.teams_TeamID2 and M.MatchStatus_MatchStatusID=1 and M.MatchDate<=+NOW() and S.Team1_Score = (Select MAX(S1.Team1_Score) from scores S1 where S.match_MatchID=S1.match_MatchID) and S.Team2_Score = (Select MAX(S1.Team2_Score) from scores S1 where S.match_MatchID=S1.match_MatchID) ");
    		while (rs.next()){
    			String teamname1 = getTeamNameWithTeamID(rs.getString("teams_TeamID1"));
    			String teamname2 = getTeamNameWithTeamID(rs.getString("teams_TeamID2"));
    			data.add(new CurrentMatchSpecModel(rs.getInt("MatchID"),rs.getString("GameName"), rs.getString("LeagueName"), rs.getString("TournamentName"),teamname1, teamname2, rs.getInt("Team1_Score"), rs.getInt("Team2_Score")));
    		}
    		JustDoLoadCurrentMatches();
    		matchColumnMatchID.setCellValueFactory(new PropertyValueFactory<>("MatchID"));
    		matchColumnGameName.setCellValueFactory(new PropertyValueFactory<>("GameName"));
    		matchColumnLeagueName.setCellValueFactory(new PropertyValueFactory<>("LeagueName"));
    		matchColumnTournamentName.setCellValueFactory(new PropertyValueFactory<>("TournamentName"));
    		matchColumnTeam1.setCellValueFactory(new PropertyValueFactory<>("Team1Name"));
    		matchColumnTeam2.setCellValueFactory(new PropertyValueFactory<>("Team2Name"));
    		matchColumnTeam1Score.setCellValueFactory(new PropertyValueFactory<>("Team1_Score"));
    		matchColumnTeam2Score.setCellValueFactory(new PropertyValueFactory<>("Team2_Score"));
    		SpecCurrentTable.setItems(data);
    	}
    	catch(SQLException e)
        {
            e.printStackTrace();
            System.out.println("ERROR @ Load Current Matches");
        }
    	
        finally
        {
        	myConnection.close();
        }
    }
    private void JustDoLoadCurrentMatches() throws SQLException {
    	Connection myConnection = DBHandler.getConnection();
    	data = FXCollections.observableArrayList();
    	data.removeAll(data);
    	
    	try {
    		ResultSet rs = myConnection.createStatement().executeQuery("Select M.MatchID, G.GameName, L.LeagueName, T.TournamentName, M.teams_TeamID1, M.teams_TeamID2, S.Team1_Score, S.Team2_Score FROM league AS L, tournament AS T, scores AS S, teams AS A, teams AS B, matches AS M, game AS G WHERE M.Game_GameID=G.GameID and S.match_MatchID = M.MatchID and L.LeagueID=T.League_LeagueID and T.TournamentID=M.Tournament_TournamentID and A.TeamID=M.teams_TeamID1 and B.TeamID=M.teams_TeamID2 and M.MatchStatus_MatchStatusID=1 and M.MatchDate<=+NOW() and S.Team1_Score = (Select MAX(S1.Team1_Score) from scores S1 where S.match_MatchID=S1.match_MatchID) and S.Team2_Score = (Select MAX(S1.Team2_Score) from scores S1 where S.match_MatchID=S1.match_MatchID) ");
    		while (rs.next()){
        		String teamname1 = getTeamNameWithTeamID(rs.getString("teams_TeamID1"));
    			String teamname2 = getTeamNameWithTeamID(rs.getString("teams_TeamID2"));
    			data.add(new CurrentMatchSpecModel(rs.getInt("MatchID"),rs.getString("GameName"), rs.getString("LeagueName"), rs.getString("TournamentName"),teamname1, teamname2, rs.getInt("Team1_Score"), rs.getInt("Team2_Score")));
    		}
    		matchColumnMatchID.setCellValueFactory(new PropertyValueFactory<>("MatchID"));
    		matchColumnGameName.setCellValueFactory(new PropertyValueFactory<>("GameName"));
    		matchColumnLeagueName.setCellValueFactory(new PropertyValueFactory<>("LeagueName"));
    		matchColumnTournamentName.setCellValueFactory(new PropertyValueFactory<>("TournamentName"));
    		matchColumnTeam1.setCellValueFactory(new PropertyValueFactory<>("Team1Name"));
    		matchColumnTeam2.setCellValueFactory(new PropertyValueFactory<>("Team2Name"));
    		matchColumnTeam1Score.setCellValueFactory(new PropertyValueFactory<>("Team1_Score"));
    		matchColumnTeam2Score.setCellValueFactory(new PropertyValueFactory<>("Team2_Score"));
    		SpecCurrentTable.setItems(data);
    	}
    	catch(SQLException e)
        {
            e.printStackTrace();
            System.out.println("ERROR @ Load Current Matches");
        }
    	
        finally
        {
        	myConnection.close();
        }
    }
    public String getTeamNameWithTeamID(String teamID) throws SQLException
    {
    	String TeamName = null;
    	Connection connection = DBHandler.getConnection();
    	String getTeamNameQuery = "SELECT TeamName FROM teams WHERE TeamID='" + teamID +"'";

    	try
    	{
    		ResultSet rs = connection.createStatement().executeQuery(getTeamNameQuery);
    		while(rs.next())
    		{
    			TeamName= rs.getString("TeamName");
    			return TeamName;
    		}

    	}
    	catch (SQLException e)
    	{
    		e.printStackTrace();
    		return null;
    	}
    	return null;
    }
}
