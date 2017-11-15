//This class acts as a model class, holding getters, setters, and properties
package arenaClasses;

import javafx.beans.property.StringProperty;
import javafx.beans.property.SimpleStringProperty;

public class TournamentData
{
	private StringProperty tournamentName;
	private StringProperty tournamentDesc;
	private StringProperty tournamentLeagueName;
	private StringProperty tournamentStyleName;
	private StringProperty tournamentDate;
public TournamentData(String tournamentName, String tournamentDesc, String tournamentLeagueName, String tournamentStyleName, String tournamentDate)
	{
		this.tournamentDate = new SimpleStringProperty(tournamentDate);
		this.tournamentName = new SimpleStringProperty(tournamentName);
		this.tournamentDesc = new SimpleStringProperty(tournamentDesc);
		this.tournamentLeagueName = new SimpleStringProperty(tournamentLeagueName);
		this.tournamentStyleName = new SimpleStringProperty(tournamentStyleName);
	}
//Getters
public String gettournamentDate()
	{
		return tournamentDate.get();
	}
public String getTournamentName()
	{
		return tournamentName.get();
	}
public String getTournamentDesc()
	{
		return tournamentDesc.get();
	}
public String getTournamentLeagueName()
	{
		return tournamentLeagueName.get();
	}
public String getTournamentStyleName()
	{
		return tournamentStyleName.get();
	}
//setters
public void settournamentDate(String Value)
	{
		tournamentDate.set(Value);
	}
public void setTournamentName(String Value)
	{
		tournamentName.set(Value);
	}
public void setTournamentDesc(String Value)
	{
		tournamentDesc.set(Value);
	}
public void setTournamentLeagueName(String Value)
	{
		tournamentLeagueName.set(Value);
	}
public void setTournamentStyleName(String Value)
	{
		tournamentStyleName.set(Value);
	}
//properties
public StringProperty tournamentDateProperty()
	{
		return tournamentDate;
	}
public StringProperty tournamentNameProperty()
	{
		return tournamentName;
	}
public StringProperty tournamentDescProperty()
	{
		return tournamentDesc;
	}
public StringProperty tournamentLeagueNameProperty()
	{
		return tournamentLeagueName;
	}
public StringProperty tournamentStyleNameProperty()
	{
		return tournamentStyleName;
	}
}

