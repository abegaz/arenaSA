package arenaClasses;


import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class GameData
{
	private StringProperty gameID;
	private StringProperty gameName;
	private StringProperty gameDesc;

	public GameData(String gameID, String gameName, String gameDesc)
	{
		this.gameID = new SimpleStringProperty(gameID);
		this.gameName = new SimpleStringProperty(gameName);
		this.gameDesc = new SimpleStringProperty(gameDesc);
	}

	public String getgameID()
	{
		return gameID.get();
	}
	public String getgameName()
	{
		return gameName.get();
	}
	public String getgameDesc()
	{
		return gameDesc.get();
	}

	public void setgameID(String Value)
	{
		gameID.set(Value);
	}
	public void setgameName(String Value)
	{
		gameName.set(Value);
	}
	public void setgameDesc(String Value)
	{
		gameDesc.set(Value);
	}

	public StringProperty gameIDProperty()
	{
		return gameID;
	}
	public StringProperty gameNameProperty()
	{
		return gameName;
	}
	public StringProperty gameDescProperty()
	{
		return gameDesc;
	}
}
