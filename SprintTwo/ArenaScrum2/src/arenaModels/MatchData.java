package arenaModels;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class MatchData
{
	private SimpleStringProperty matchID;
	private SimpleStringProperty gameName;
	private SimpleStringProperty leagueName;
	private SimpleStringProperty tournamentName;
	private SimpleStringProperty team1Name;
	private SimpleStringProperty team2Name;
	private SimpleStringProperty matchWinner;
	private SimpleStringProperty matchLoser;
	private SimpleStringProperty matchStatus;
	private SimpleStringProperty matchDate;

	public MatchData(
			String matchID,
			String gameName,
			String leagueName,
			String tournamentName,
			String team1Name,
			String team2Name,
			String matchWinner,
			String matchLoser,
			String matchStatus,
			String matchDate)
		{
			this.matchID = new SimpleStringProperty(matchID);
			this.gameName = new SimpleStringProperty(gameName);
			this.leagueName = new SimpleStringProperty(leagueName);
			this.tournamentName = new SimpleStringProperty(tournamentName);
			this.team1Name = new SimpleStringProperty(team1Name);
			this.team2Name = new SimpleStringProperty(team2Name);
			this.matchWinner = new SimpleStringProperty(matchWinner);
			this.matchLoser = new SimpleStringProperty(matchLoser);
			this.matchStatus = new SimpleStringProperty(matchStatus);
			this.matchDate = new SimpleStringProperty(matchDate);
		}

	public String getmatchID()
	{
		return matchID.get();
	}
	public void setmatchID(String Value)
	{
		matchID.set(Value);
	}
	public StringProperty matchIDProperty()
	{
		return matchID;
	}

	public String getgameName()
	{
		return gameName.get();
	}
	public void setgameName(String Value)
	{
		gameName.set(Value);
	}
	public StringProperty gameNameProperty()
	{
		return gameName;
	}

	public String getleagueName()
	{
		return leagueName.get();
	}
	public void setleagueName(String Value)
	{
		leagueName.set(Value);
	}
	public StringProperty leagueNameProperty()
	{
		return leagueName;
	}

	public String gettournamentName()
	{
		return tournamentName.get();
	}
	public void settournamentName(String Value)
	{
		tournamentName.set(Value);
	}
	public StringProperty tournamentNameProperty()
	{
		return tournamentName;
	}

	public String getteam1Name()
	{
		return team1Name.get();
	}
	public void setteam1Name(String Value)
	{
		team1Name.set(Value);
	}
	public StringProperty team1NameProperty()
	{
		return team1Name;
	}

	public String getteam2Name()
	{
		return team2Name.get();
	}
	public void setteam2Name(String Value)
	{
		team2Name.set(Value);
	}
	public StringProperty team2NameProperty()
	{
		return team2Name;
	}

	public String getmatchWinner()
	{
		return matchWinner.get();
	}
	public void setmatchWinner(String Value)
	{
		matchWinner.set(Value);
	}
	public StringProperty matchWinnerProperty()
	{
		return matchWinner;
	}

	public String getmatchLoser()
	{
		return matchLoser.get();
	}
	public void setmatchLoser(String Value)
	{
		matchLoser.set(Value);
	}
	public StringProperty matchLoserProperty()
	{
		return matchLoser;
	}

	public String getmatchStatus()
	{
		return matchStatus.get();
	}
	public void setmatchStatus(String Value)
	{
		matchStatus.set(Value);
	}
	public StringProperty matchStatusProperty()
	{
		return matchStatus;
	}

	public String getmatchDate()
	{
		return matchDate.get();
	}
	public void setmatchDate(String Value)
	{
		matchDate.set(Value);
	}
	public StringProperty matchDateProperty()
	{
		return matchDate;
	}
}
