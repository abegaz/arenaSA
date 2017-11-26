package arenaModels;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class SpecPlayerModel {
	private final SimpleIntegerProperty userID;
	private final SimpleStringProperty userName, TeamName;
	public SpecPlayerModel(Integer userID, String userName, String TeamName){
		this.userID = new SimpleIntegerProperty(userID);
		this.userName = new SimpleStringProperty(userName);
		this.TeamName = new SimpleStringProperty(TeamName);

	}
	
	public Integer getuserID()
	{
		return userID.get();
	}
	public void setuserID(Integer Value)
	{
		userID.set(Value);
	}
	public IntegerProperty userIDProperty()
	{
		return userID;
	}

	public String getuserName()
	{
		return userName.get();
	}
	public void setuserName(String Value)
	{
		userName.set(Value);
	}
	public StringProperty userNameProperty()
	{
		return userName;
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
