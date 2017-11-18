package arenaModels;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class PlayerJoinLeagueModel {

	private final SimpleStringProperty LeagueName;
	private final SimpleStringProperty LeagueDesc;
	private final SimpleIntegerProperty LeagueID;
	public PlayerJoinLeagueModel(Integer LeagueID, String LeagueName, String LeagueDesc) {
		this.LeagueName = new SimpleStringProperty(LeagueName);
		this.LeagueDesc = new SimpleStringProperty(LeagueDesc);
		this.LeagueID = new SimpleIntegerProperty(LeagueID);
		
}
	//Setter
	public void setLeagueName(String value) {
		LeagueName.set(value);
	}
	public void setLeagueDesc(String value) {
		LeagueDesc.set(value);
	}
	public void setLeagueID(Integer value) {
		LeagueID.set(value);
	}
	//Getter
	public String getLeagueName() {
		return LeagueName.get();
	}
	public String getLeagueDesc() {
		return LeagueDesc.get();
	}
	public Integer getLeagueID() {
		return LeagueID.get();
	}
	//Property Value
	public StringProperty LeagueNameProperty() {
		return LeagueName;
		}
	public StringProperty LeagueDescProperty() {
		return LeagueDesc;
	}
	public IntegerProperty LeagueIDProperty() {
		return LeagueID;
	}
}