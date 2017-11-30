package arenaClasses;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
public class loPlayerAppTable {
private final SimpleIntegerProperty appUserID,desired_teamID;
private final SimpleStringProperty appUserName,desired_teamName,current_teamName;
public loPlayerAppTable(Integer appUserID,
			Integer desired_teamID,
			String appUserName,
			String desired_teamName,
			String current_teamName){
			this.appUserID= new SimpleIntegerProperty(appUserID);
			this.desired_teamID = new SimpleIntegerProperty(desired_teamID);
			this.appUserName = new SimpleStringProperty(appUserName);
			this.desired_teamName= new SimpleStringProperty(desired_teamName);
			this.current_teamName = new SimpleStringProperty(current_teamName);
		}
// Getters
public Integer getAppUserID()
		{
			return appUserID.get();
		}
public Integer getDesired_teamID()
		{
			return desired_teamID.get();
		}
public String getAppUserName()
		{
			return appUserName.get();
		}
public String getDesired_teamName()
		{
			return desired_teamName.get();
		}
public String getCurrent_teamName()
		{
			return current_teamName.get();
		}
// Setters
public void setAppUserID(Integer value)
		{
			appUserID.set(value);
		}
public void setDesired_teamID(Integer value)
		{
			desired_teamID.set(value);
		}
public void setAppUserName(String value)
		{
			appUserName.set(value);
		}
public void setDesired_teamName(String value)
		{
			desired_teamName.set(value);
		}
public void setCurrent_teamName(String value)
		{
			current_teamName.set(value);
		}
// Property Values
public IntegerProperty appUserIDProperty()
		{
			return appUserID;
		}
public IntegerProperty desired_teamIDProperty()
		{
			return desired_teamID;
		}
public StringProperty appUserNameProperty()
		{
			return appUserName;
		}
public StringProperty desired_teamNameProperty()
		{
			return desired_teamName;
		}
public StringProperty current_teamNameProperty()
		{
			return current_teamName;
		}
}
