package arenaModels;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class ArenaData
{
	private StringProperty arenaName;
	private StringProperty arenaID;

	public ArenaData(String arenaID, String arenaName)
	{
		this.arenaName = new SimpleStringProperty(arenaName);
		this.arenaID = new SimpleStringProperty(arenaID);
	}

	//Getters
	public String getarenaName()
	{
		return arenaName.get();
	}
	public String getarenaID()
	{
		return arenaID.get();
	}

	//setters
	public void setarenaName(String Value)
	{
		arenaName.set(Value);
	}
	public void setarenaID(String Value)
	{
		arenaID.set(Value);
	}

	//properties
	public StringProperty arenaNameProperty()
	{
		return arenaName;
	}
	public StringProperty arenaIDProperty()
	{
		return arenaID;
	}
}
