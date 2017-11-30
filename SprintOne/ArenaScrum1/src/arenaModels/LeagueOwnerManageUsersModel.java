package arenaModels;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class LeagueOwnerManageUsersModel {
	
	private final SimpleIntegerProperty userID;
	private final SimpleStringProperty userName, leagueName, MembershipStatusCodeName;
	public LeagueOwnerManageUsersModel(Integer userID, String userName, String leagueName, String MembershipStatusCodeName) {
		this.leagueName = new SimpleStringProperty(leagueName);
		this.userName = new SimpleStringProperty(userName);
		this.userID = new SimpleIntegerProperty(userID);	
		this.MembershipStatusCodeName = new SimpleStringProperty(MembershipStatusCodeName);
}
	
	//Setter
	public void setLeagueName(String value) {
		leagueName.set(value);
	}
	public void setUserID(Integer value) {
		userID.set(value);
	}
	public void setUserName(String value) {
		userName.set(value);
	}
	public void setMembershipStatusCodeName(String value) {
		MembershipStatusCodeName.set(value);		
	}
	//Getter
	public String getLeagueName() {
		return leagueName.get();
	}
	public String getUserName() {
		return userName.get();
	}
	public Integer getUserID() {
		return userID.get();
	}
	public String getMembershipStatusCodeName(){
		return MembershipStatusCodeName.get();
	}
	//Property Value
	public StringProperty LeagueNameProperty() {
		return leagueName;
		}
	public StringProperty LeagueDescProperty() {
		return userName;
	}
	public IntegerProperty LeagueIDProperty() {
		return userID;
	}
	public StringProperty MembershipStatusCodeNameProperty() {
		return MembershipStatusCodeName;
	}
}


