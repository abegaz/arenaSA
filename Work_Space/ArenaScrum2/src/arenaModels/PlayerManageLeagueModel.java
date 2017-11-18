package arenaModels;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class PlayerManageLeagueModel {

	private final SimpleStringProperty LeagueName, LeagueDesc,MembershipStatusCodeName;
	private final SimpleIntegerProperty LeagueID;
	public PlayerManageLeagueModel(Integer LeagueID, String LeagueName, String LeagueDesc, String MembershipStatusCodeName) {
		this.LeagueName = new SimpleStringProperty(LeagueName);
		this.LeagueDesc = new SimpleStringProperty(LeagueDesc);
		this.LeagueID = new SimpleIntegerProperty(LeagueID);
		this.MembershipStatusCodeName = new SimpleStringProperty(MembershipStatusCodeName);
		
		
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
	public void setMembershipStatusCodeName(String value){
		MembershipStatusCodeName.set(value);
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
	public String getMembershipStatusCodeName(){
		return MembershipStatusCodeName.get();
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
	public StringProperty MembershipStatusCodeNameProperty(){
		return MembershipStatusCodeName;
	}
}