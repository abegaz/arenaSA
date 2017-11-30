package arenaModels;

import javafx.beans.property.SimpleIntegerProperty;


public class UserModels {
private static SimpleIntegerProperty UserID;
 
 public UserModels (Integer currUserID){
	 UserModels.UserID= new SimpleIntegerProperty(currUserID);
 }

 public static int getUserID(){
	 return UserID.get();
 }
 public void setUserID(Integer UserID){
	 UserModels.UserID= new SimpleIntegerProperty(UserID);
}
}
