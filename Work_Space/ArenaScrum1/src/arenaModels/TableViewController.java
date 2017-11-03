package arenaModels;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class TableViewController {	
private final SimpleIntegerProperty appUserIDNew, appCurrentRoleNew, roleID_desiredNew;
private final SimpleStringProperty appUserNameNew;
public TableViewController(Integer appUserIDNew, String appUserNameNew, Integer appCurrentRoleNew, Integer roleID_desiredNew) {
	this.appUserIDNew = new SimpleIntegerProperty(appUserIDNew);
	this.appUserNameNew = new SimpleStringProperty(appUserNameNew);
	this.appCurrentRoleNew = new SimpleIntegerProperty(appCurrentRoleNew);
	this.roleID_desiredNew = new SimpleIntegerProperty(roleID_desiredNew);	
}
// Getters
public Integer getAppUserID() {
	return appUserIDNew.get();
}
public String getAppUserName() {
	return appUserNameNew.get();
}
public Integer getAppCurrentRole() {
	return appCurrentRoleNew.get();
}
public Integer getRoleID_desire() {
	return roleID_desiredNew.get();
}
// Setters
public void setAppUserID(Integer value) {
	appUserIDNew.set(value);
}
public void setAppUserName(String value) {
	appUserNameNew.set(value);
}
public void setAppCurrentRole(Integer value) {
	appCurrentRoleNew.set(value);
}
public void setRoleID_desired(Integer value) {
	roleID_desiredNew.set(value);
}
// Property Values
public IntegerProperty appUserIDProperty() {
	return appUserIDNew;
	}
public StringProperty appUserNameProperty() {
	return appUserNameNew;
}
public IntegerProperty appCurrentRoleProperty() {
	return appCurrentRoleNew;
}
public IntegerProperty roleID_desiredProperty() {
	return roleID_desiredNew;
}
}
