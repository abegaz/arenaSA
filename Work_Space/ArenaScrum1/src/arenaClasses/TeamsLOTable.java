package arenaClasses;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class TeamsLOTable {
private final SimpleIntegerProperty LeagueIDNew;
private final SimpleStringProperty LeagueNameNew, leagueDescNew;
public TeamsLOTable(
				Integer LeagueIDNew,
				String LeagueNameNew,
				String leagueDescNew)
		{
			this.LeagueIDNew = new SimpleIntegerProperty(LeagueIDNew);
			this.LeagueNameNew= new SimpleStringProperty(LeagueNameNew);
			this.leagueDescNew= new SimpleStringProperty(leagueDescNew);
		}
// Getters
public Integer getLeagueID()
	{
		return LeagueIDNew.get();
	}
public String getLeagueName()
	{
		return LeagueNameNew.get();
	}
public String getLeagueDesc() 
	{
		return leagueDescNew.get();
	}
// Setters
public void setLeagueID(Integer value)
	{
		LeagueIDNew.set(value);
	}
public void setLeagueName(String value)
	{
		LeagueNameNew.set(value);
	}
public void setLeagueDesc(String value)
	{
		leagueDescNew.set(value);
	}
// Property Values
public IntegerProperty LeagueIDProperty()
	{
		return LeagueIDNew;
	}
public StringProperty LeagueNameProperty()
	{
		return LeagueNameNew;
	}
public StringProperty leagueDescProperty()
	{
		return leagueDescNew;
	}
	
}
