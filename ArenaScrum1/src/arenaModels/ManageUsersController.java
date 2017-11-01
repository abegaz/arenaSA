package arenaModels;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class ManageUsersController {	
private final SimpleIntegerProperty userIDNew, userRoleType_userRoleTypeIDNew;
private final SimpleStringProperty userNameNew;
public ManageUsersController(Integer userIDNew, String userNameNew, Integer userRoleType_userRoleTypeIDNew) {
	this.userIDNew = new SimpleIntegerProperty(userIDNew);
	this.userNameNew = new SimpleStringProperty(userNameNew);
	this.userRoleType_userRoleTypeIDNew= new SimpleIntegerProperty(userRoleType_userRoleTypeIDNew);	
}
// Getters
public Integer getUserID() {
	return userIDNew.get();
}
public String getUserName() {
	return userNameNew.get();
}
public Integer getUserRoleType_userRoleTypeID() {
	return userRoleType_userRoleTypeIDNew.get();
}
// Setters
public void setUserID(Integer value) {
	userIDNew.set(value);
}
public void setUserName(String value) {
	userNameNew.set(value);
}
public void setUserRoleType_userRoleTypeID(Integer value) {
	userRoleType_userRoleTypeIDNew.set(value);
}
// Property Values
public IntegerProperty userIDProperty() {
	return userIDNew;
	}
public StringProperty userNameProperty() {
	return userNameNew;
}
public IntegerProperty userRoleType_userRoleTypeIDProperty() {
	return userRoleType_userRoleTypeIDNew;
}
}


