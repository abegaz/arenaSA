package arenaClasses;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class ManageUsersController
{
	private final SimpleIntegerProperty userIDNew, userRoleIDNew;
	private final SimpleStringProperty userNameNew;
public ManageUsersController(Integer userIDNew, String userNameNew, Integer userRoleIDNew)
	{
		this.userIDNew = new SimpleIntegerProperty(userIDNew);
		this.userNameNew = new SimpleStringProperty(userNameNew);
		this.userRoleIDNew= new SimpleIntegerProperty(userRoleIDNew);
	}
// Getters
public Integer getUserID()
	{
		return userIDNew.get();
	}
public String getUserName()
	{
		return userNameNew.get();
	}
public Integer getuserRoleID()
	{
		return userRoleIDNew.get();
	}
// Setters
public void setUserID(Integer value)
	{
		userIDNew.set(value);
	}
public void setUserName(String value)
	{
		userNameNew.set(value);
	}
public void setuserRoleID(Integer value)
	{
		userRoleIDNew.set(value);
	}
// Property Values
public IntegerProperty userIDProperty()
	{
		return userIDNew;
	}
public StringProperty userNameProperty()
	{
		return userNameNew;
	}
public IntegerProperty userRoleIDProperty()
	{
		return userRoleIDNew;
	}
}


