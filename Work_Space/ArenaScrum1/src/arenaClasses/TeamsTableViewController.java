package arenaClasses;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class TeamsTableViewController
{
	private final SimpleIntegerProperty teamIDNew;
	private final SimpleStringProperty teamNameNew;
	public TeamsTableViewController(
				Integer teamIDNew,
				String teamNameNew)
		{
			this.teamIDNew = new SimpleIntegerProperty(teamIDNew);
			this.teamNameNew = new SimpleStringProperty(teamNameNew);
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
	// Setters
	public void setTeamID(Integer value)
	{
		teamIDNew.set(value);
	}
	public void setTeamName(String value)
	{
		teamNameNew.set(value);
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
}
