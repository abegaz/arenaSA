package arenaClasses;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class TableViewController
{
	private final SimpleIntegerProperty appUserIDNew, appCurrentRoleNew, desired_RoleIDNew;
	private final SimpleStringProperty appUserNameNew;
public TableViewController(
			Integer appUserIDNew,
			String appUserNameNew,
			Integer appCurrentRoleNew,
			Integer desired_RoleIDNew)
	{
		this.appUserIDNew = new SimpleIntegerProperty(appUserIDNew);
		this.appUserNameNew = new SimpleStringProperty(appUserNameNew);
		this.appCurrentRoleNew = new SimpleIntegerProperty(appCurrentRoleNew);
		this.desired_RoleIDNew = new SimpleIntegerProperty(desired_RoleIDNew);
	}
// Getters
public Integer getAppUserID()
	{
		return appUserIDNew.get();
	}
public String getAppUserName()
	{
		return appUserNameNew.get();
	}
public Integer getAppCurrentRole()
	{
		return appCurrentRoleNew.get();
	}
public Integer getdesired_RoleIDNew()
	{
		return desired_RoleIDNew.get();
	}
// Setters
public void setAppUserID(Integer value)
	{
		appUserIDNew.set(value);
	}
public void setAppUserName(String value)
	{
		appUserNameNew.set(value);
	}
public void setAppCurrentRole(Integer value) {
		appCurrentRoleNew.set(value);
	}
public void setdesired_RoleIDNew(Integer value)
	{
		desired_RoleIDNew.set(value);
	}
// Property Values
public IntegerProperty appUserIDProperty()
	{
		return appUserIDNew;
	}
public StringProperty appUserNameProperty()
	{
		return appUserNameNew;
	}
public IntegerProperty appCurrentRoleProperty()
	{
		return appCurrentRoleNew;
	}
public IntegerProperty desired_RoleIDNewProperty()
	{
		return desired_RoleIDNew;
	}
}
