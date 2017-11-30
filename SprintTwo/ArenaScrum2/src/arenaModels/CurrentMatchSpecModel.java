package arenaModels;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class CurrentMatchSpecModel {
	private SimpleIntegerProperty MatchID;
	private SimpleStringProperty GameName;
	private SimpleStringProperty LeagueName;
	private SimpleStringProperty TournamentName;
	private SimpleStringProperty Team1Name;
	private SimpleStringProperty Team2Name;
	private SimpleIntegerProperty Team1_Score;
	private SimpleIntegerProperty Team2_Score;

	public CurrentMatchSpecModel(Integer MatchID, String GameName,String LeagueName,String TournamentName,String Team1Name,String Team2Name,Integer Team1_Score,Integer Team2_Score)
		{
			this.MatchID = new SimpleIntegerProperty(MatchID);
			this.GameName = new SimpleStringProperty(GameName);
			this.LeagueName = new SimpleStringProperty(LeagueName);
			this.TournamentName = new SimpleStringProperty(TournamentName);
			this.Team1Name = new SimpleStringProperty(Team1Name);
			this.Team2Name = new SimpleStringProperty(Team2Name);
			this.Team1_Score = new SimpleIntegerProperty(Team1_Score);
			this.Team2_Score = new SimpleIntegerProperty(Team2_Score);

		}

	public Integer getMatchID()
	{
		return MatchID.get();
	}
	public void setMatchID(Integer Value)
	{
		MatchID.set(Value);
	}
	public IntegerProperty MatchIDProperty()
	{
		return MatchID;
	}

	public String getGameName()
	{
		return GameName.get();
	}
	public void setGameName(String Value)
	{
		GameName.set(Value);
	}
	public StringProperty GameNameProperty()
	{
		return GameName;
	}

	public String getLeagueName()
	{
		return LeagueName.get();
	}
	public void setLeagueName(String Value)
	{
		LeagueName.set(Value);
	}
	public StringProperty LeagueNameProperty()
	{
		return LeagueName;
	}

	public String getTournamentName()
	{
		return TournamentName.get();
	}
	public void setTournamentName(String Value)
	{
		TournamentName.set(Value);
	}
	public StringProperty TournamentNameProperty()
	{
		return TournamentName;
	}

	public String getTeam1Name()
	{
		return Team1Name.get();
	}
	public void setTeam1Name(String Value)
	{
		Team1Name.set(Value);
	}
	public StringProperty Team1NameProperty()
	{
		return Team1Name;
	}

	public String getTeam2Name()
	{
		return Team2Name.get();
	}
	public void setTeam2Name(String Value)
	{
		Team2Name.set(Value);
	}
	public StringProperty Team2NameProperty()
	{
		return Team2Name;
	}

	public int getTeam1_Score()
	{
		return Team1_Score.get();
	}
	public void setTeam1_Score(int Value)
	{
		Team1_Score.set(Value);
	}
	public SimpleIntegerProperty Team1_ScoreProperty()
	{
		return Team1_Score;
	}

	public int getTeam2_Score()
	{
		return Team2_Score.get();
	}
	public void setTeam2_Score(int Value)
	{
		Team2_Score.set(Value);
	}
	public SimpleIntegerProperty Team2_ScoreProperty()
	{
		return Team2_Score;
	}
}
