package arenaModels;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class SpecTeamModel {

	private final SimpleIntegerProperty TeamID;
	private final SimpleStringProperty TeamName;
	public SpecTeamModel(Integer TeamID, String TeamName){
		this.TeamID = new SimpleIntegerProperty(TeamID);
		this.TeamName = new SimpleStringProperty(TeamName);
	}
	
	public Integer getTeamID()
	{
		return TeamID.get();
	}
	public void setTeamID(Integer Value)
	{
		TeamID.set(Value);
	}
	public IntegerProperty TeamIDProperty()
	{
		return TeamID;
	}

	public String getTeamName()
	{
		return TeamName.get();
	}
	public void setTeamName(String Value)
	{
		TeamName.set(Value);
	}
	public StringProperty TeamNameProperty()
	{
		return TeamName;
	}


}
