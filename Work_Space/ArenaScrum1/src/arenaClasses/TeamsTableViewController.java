package arenaClasses;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class TeamsTableViewController
{
private final SimpleIntegerProperty teamIDNew,league_LeagueIDNew;
private final SimpleStringProperty teamNameNew;
public TeamsTableViewController(
				Integer teamIDNew,
				String teamNameNew,
				Integer league_LeagueIDNew)
		{
			this.teamIDNew = new SimpleIntegerProperty(teamIDNew);
			this.teamNameNew = new SimpleStringProperty(teamNameNew);
			this.league_LeagueIDNew = new SimpleIntegerProperty(league_LeagueIDNew);
		}
	
	
// Getters
public Integer getTeamID()
	{
		return teamIDNew.get();
	}
public String getTeamName()
	{
		return teamNameNew.get();
	}
public Integer getLeague_LeagueID() 
	{
		return league_LeagueIDNew.get();
	}
// Setters
public void setTeamID(Integer value)
	{
		teamIDNew.set(value);
	}
public void setTeamName(String value)
	{
		teamNameNew.set(value);
	}
public void setLeague_LeagueID(Integer value)
	{
		league_LeagueIDNew.set(value);
	}
// Property Values
public IntegerProperty teamIDProperty()
	{
		return teamIDNew;
	}
public StringProperty teamNameProperty()
	{
		return teamNameNew;
	}
public IntegerProperty league_LeagueIDProperty()
	{
		return league_LeagueIDNew;
	}
}
