package arenaPrototypeB;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;


public class usersInfo {
	

	private final StringProperty usersScreenName;
	private final StringProperty usersEmail;
	private final StringProperty usersFname;
	private final StringProperty usersLname;
	private final StringProperty isUsersConfirmed;
	private final StringProperty usersRole;
	
	public usersInfo(String usersScreenName, String usersEmail, String usersFname, String usersLname, String isUsersConfirmed, String usersRole) {
		this.usersScreenName = new SimpleStringProperty(usersScreenName);
		this.usersEmail = new SimpleStringProperty(usersEmail);
		this.usersFname = new SimpleStringProperty(usersFname);
		this.usersLname = new SimpleStringProperty(usersLname);
		this.isUsersConfirmed = new SimpleStringProperty(isUsersConfirmed);
		this.usersRole = new SimpleStringProperty(usersRole);
	}
	
	// Getters
	public String getUsersScreenName() {
		return usersScreenName.get();
	}
	public String getUsersEmail() {
		return usersEmail.get();
	}
	public String getUsersFname() {
		return usersFname.get();
	}
	public String getUsersLname() {
		return usersLname.get();
	}
	public String getIsUserConfirmed() {
		return isUsersConfirmed.get();
	}
	public String getUsersRole() {
		return usersRole.get();
	}
	
	// Setters 
	public void setUsersScreenName(String value) {
		usersScreenName.set(value);
	}
	public void setUsersEmail(String value) {
		usersEmail.set(value);
	}
	public void setUsersFname(String value) {
		usersFname.set(value);
	}
	public void setUsersLname(String value) {
		usersLname.set(value);
	}
	public void setIsUserConfirmed(String value) {
		isUsersConfirmed.set(value);
	}
	public void setUsersRole(String value) {
		usersRole.set(value);
	}
	
	// Property Values
	public StringProperty usersScreenNameProperty() {
		return usersScreenName;
	}
	public StringProperty usersEmailProperty() {
		return usersEmail;
	}
	public StringProperty usersFnameProperty() {
		return usersFname;
	}
	public StringProperty usersLnameProperty() {
		return usersLname;
	}
	public StringProperty isUsersConfirmedProperty() {
		return isUsersConfirmed;
	}
	public StringProperty usersRoleProperty() {
		return usersRole;
	}

}
