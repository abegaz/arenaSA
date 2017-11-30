package arenaModels;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;

public class SelectedMatchModel {

	private static SimpleIntegerProperty MatchID;
	public SelectedMatchModel (Integer MatchID){
		this.MatchID = new SimpleIntegerProperty(MatchID);
	}
	public static Integer getMatchID()
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
}
