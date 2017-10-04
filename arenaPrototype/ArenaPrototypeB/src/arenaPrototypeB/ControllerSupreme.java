package arenaPrototypeB;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ResourceBundle;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;
import javafx.animation.PauseTransition;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.util.Duration;
import javafx.scene.control.ToggleGroup;
import javafx.scene.control.cell.PropertyValueFactory;
import com.jfoenix.controls.JFXRadioButton;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.Statement;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;


public class ControllerSupreme implements Initializable{
	
    @FXML
    private ImageView progress; 
    @FXML
    private Label loadMe;
    @FXML
    private JFXButton signUpButton;
    @FXML
    private JFXTextField userNameFrontField;
    @FXML
    private JFXPasswordField passwordFrontField;
    @FXML
    private JFXButton signInButton;
    @FXML
    private JFXTextField regUserName;
    @FXML
    private JFXPasswordField regPassword;
    @FXML
    private JFXTextField regEmail;
    @FXML
    private JFXTextField regFName;
    @FXML
    private JFXTextField regLName;
    @FXML
    private JFXButton regSignUpButton;
    @FXML
    private JFXButton regGoBackButton;
    @FXML
    private JFXRadioButton operatorRoleChoice;
    @FXML
    private ToggleGroup roleGroup;
    @FXML
    private JFXRadioButton leagueOwnerRoleChoice;
    @FXML
    private JFXRadioButton playerRoleChoice;
    @FXML
    private JFXRadioButton advertRoleChoice;
    @FXML
    private JFXRadioButton spectatorRoleChoice;
    @FXML
    private Label logInErrorText;
    @FXML
    private JFXButton operGoBackButton;
    @FXML
    private JFXButton applicationsButton;
    @FXML
    private TableView<usersInfo> userIdTable;
    @FXML
    private TableColumn<usersInfo, String> columnScreenName;
    @FXML
    private TableColumn<usersInfo, String> columnEmail;
    @FXML
    private TableColumn<usersInfo, String> columnFName;
    @FXML
    private TableColumn<usersInfo, String> columnLName;
    @FXML
    private TableColumn<usersInfo, String> columnIsConfirmed;
    @FXML
    private TableColumn<usersInfo, String> columnRole;
    @FXML
    private JFXButton operApproveButton;
    @FXML
    private JFXButton operRemoveButton;
    @FXML
    private JFXButton refreshButton;
    @FXML
    private JFXButton operUsersManageButton;
    @FXML
    private JFXButton operUsersRemoveButton;
    @FXML
    private JFXButton operRegSignUpButton;
    
    
    private Connection connection;
    private DBHandler handler;
    private PreparedStatement pst;
    private ObservableList<usersInfo>data;
  
    @FXML
    private void handleClose(MouseEvent event){
        System.exit(0);
    }
    @FXML
    private void loginAction(MouseEvent e){
        progress.setVisible(true);
        PauseTransition pt = new PauseTransition();
       pt.setDuration(Duration.seconds(3));
       pt.setOnFinished(ev -> 
       { 
        System.out.println("Working..");
    });
              pt.play();
    }
    @FXML
    private void checkIfRegistered(ActionEvent e) throws IOException {
    	// Retrieve Data
    	connection = handler.getConnection();
    	String queryOne = "SELECT * from new_users where newUserName=? and newUserPassword=?";
    	try {
    		pst = connection.prepareStatement(queryOne);
    		pst.setString(1,userNameFrontField.getText());
    		pst.setString(2,passwordFrontField.getText());
    		
    		String currentName = userNameFrontField.getText();
    		String currentPass = passwordFrontField.getText();
    		ResultSet rs = pst.executeQuery();
    		int count = 0;
      		boolean isOperator = false;
      		boolean isLeagueOwner = false;
      		boolean isPlayer = false;
      		boolean isAdvertiser = false;
      		boolean isSpectator = false;
      		boolean confirmedCheck = false; 
      		
			// Get Role
		Statement s = connection.createStatement();
    	s.executeQuery("SELECT newUserRole FROM arena.new_users where newUserName=\"" +currentName+ "\""
    			+ " and newUserPassword=\"" +currentPass+"\"");
		ResultSet rs2 = s.getResultSet();
		ResultSetMetaData rs2md = rs2.getMetaData();
		int colNum = rs2md.getColumnCount();
		 
		Statement s1 = connection.createStatement();
		s1.executeQuery("SELECT isConfirmed FROM arena.new_users where newUserName=\"" +currentName+ "\""
				+ " and newUserPassword=\"" +currentPass+"\"");
		ResultSet rs3 = s1.getResultSet();
		ResultSetMetaData rs3md = rs3.getMetaData();
		int colNum1 = rs3md.getColumnCount();
		
		while(rs2.next()) {
			for(int i = 1; i <= colNum; i++) {
				if(i > 1) System.out.print(", ");
				String colVal = rs2.getString(i);
				System.out.println(" " + colVal);
				if(colVal.equals("Operator")) {
					isOperator= true;
				}
				else if(colVal.equals("League Owner")) {
					isLeagueOwner = true;
				}
				else if(colVal.equals("Player")) {
					isPlayer = true;
				}
				else if(colVal.equals("Advertiser")) {
					isAdvertiser = true;
				}
				else if(colVal.equals("Spectator")) {
					isSpectator = true;
				}
			}
			System.out.println("");
		}
		// Print Confirmation Status
		while(rs3.next()) {
			for(int i = 1; i <= colNum1;i++) {
				if(i > 1)System.out.print(", ");
				String colVal1 = rs3.getString(i);
				System.out.println(" "+ colVal1);
				if(colVal1.equals("no")) {
					confirmedCheck = false;
				}
				else if(colVal1.equals("yes")) {
					confirmedCheck = true;
				}
			}
			System.out.println("");
		}
		// Selecting Page by Role
    		while(rs.next()) {
    			count = count+1;
    		}
    		
    		if(count == 1 && confirmedCheck == true && isOperator == false && isLeagueOwner == false && isPlayer == false
    				&& isAdvertiser == false && isSpectator == false) {
    			System.out.print("Login Success Default");
    		       signInButton.getScene().getWindow().hide();
    		       Stage stage = new Stage();
    		       Parent root = FXMLLoader.load(getClass().getResource("loggedInDefault.fxml"));
    		       Scene scene = new Scene(root);
    		       stage.setScene(scene);
    		       stage.initStyle(StageStyle.UNDECORATED);
    		       stage.setResizable(false);
    		       stage.getIcons().add(new Image(getClass().getResourceAsStream("arenaIcon.png")));
    		       stage.show();
    		}

    		else if(count==1 && isOperator == true && confirmedCheck == true) {
    			System.out.print("Login Success: Operator");
    			signInButton.getScene().getWindow().hide();
    			Stage stage = new Stage();
 		        Parent root = FXMLLoader.load(getClass().getResource("operatorMainPage.fxml"));
 		        Scene scene = new Scene(root);
 		        stage.setScene(scene);
 		        stage.initStyle(StageStyle.UNDECORATED);
 		        stage.setResizable(false);
 		        stage.getIcons().add(new Image(getClass().getResourceAsStream("arenaIcon.png")));
 		        stage.show();
    		}
    		
    		else if(count==1 && isLeagueOwner == true && confirmedCheck == true) {
    			System.out.print("Login Success: League Owner");
    			signInButton.getScene().getWindow().hide();
    			Stage stage = new Stage();
 		        Parent root = FXMLLoader.load(getClass().getResource("leagueOwnerMainPage.fxml"));
 		        Scene scene = new Scene(root);
 		        stage.setScene(scene);
 		        stage.initStyle(StageStyle.UNDECORATED);
 		        stage.setResizable(false);
 		        stage.getIcons().add(new Image(getClass().getResourceAsStream("arenaIcon.png")));
 		        stage.show();
    		}
    		
    		else if(count==1 && isPlayer == true && confirmedCheck == true) {
    			System.out.print("Login Success: Player");
    			signInButton.getScene().getWindow().hide();
    			Stage stage = new Stage();
 		        Parent root = FXMLLoader.load(getClass().getResource("playerMainPage.fxml"));
 		        Scene scene = new Scene(root);
 		        stage.setScene(scene);
 		        stage.initStyle(StageStyle.UNDECORATED);
 		        stage.setResizable(false);
 		        stage.getIcons().add(new Image(getClass().getResourceAsStream("arenaIcon.png")));
 		        stage.show();
    		}
    		
    		else if(count==1 && isAdvertiser == true && confirmedCheck == true) {
    			System.out.print("Login Success: Advertisor");
    			signInButton.getScene().getWindow().hide();
    			Stage stage = new Stage();
 		        Parent root = FXMLLoader.load(getClass().getResource("advertisorMainPage.fxml"));
 		        Scene scene = new Scene(root);
 		        stage.setScene(scene);
 		        stage.initStyle(StageStyle.UNDECORATED);
 		        stage.setResizable(false);
 		        stage.getIcons().add(new Image(getClass().getResourceAsStream("arenaIcon.png")));
 		        stage.show();
    		}
    		
    		else if(count==1 && isSpectator == true && confirmedCheck == true) {
    			System.out.print("Login Success: Spectator");
    			signInButton.getScene().getWindow().hide();
    			Stage stage = new Stage();
 		        Parent root = FXMLLoader.load(getClass().getResource("spectatorMainPage.fxml"));
 		        Scene scene = new Scene(root);
 		        stage.setScene(scene);
 		        stage.initStyle(StageStyle.UNDECORATED);
 		        stage.setResizable(false);
 		        stage.getIcons().add(new Image(getClass().getResourceAsStream("arenaIcon.png")));
 		        stage.show();
    		}

    		else {
    			System.out.println("Username & Password are incorrect.");
    			logInErrorText.setVisible(true);
    		}
    	}
    	catch(SQLException e3) {
    		e3.printStackTrace();
    	}
    	finally {
    		try {
    		connection.close();
    		}
    		catch(SQLException e4) {
    			e4.printStackTrace();
    		}
    	}
    }   
    @FXML
    private void approveNewUser(ActionEvent e) {
        connection = handler.getConnection();
     usersInfo userData = userIdTable.getSelectionModel().getSelectedItem();
     userData.setIsUserConfirmed("yes");
     String theUserName = userData.getUsersScreenName();
     String sqlUpdate ="UPDATE arena.new_users SET isConfirmed = \"yes\"WHERE newUserName =\"" +theUserName+"\"";
     System.out.println("");
     System.out.println(theUserName);

     try {
     pst = connection.prepareStatement(sqlUpdate);
     }
     catch(SQLException e1){
         e1.printStackTrace();
     }
     try{
     pst.executeUpdate();
     }
     catch(SQLException e2){
         e2.printStackTrace();
         System.out.println("SQL ERROR CONTROL SUPREME - e2");
     }
    JustDoloadDateFromDatabase();
    }
    private void justDoloadApprovedUserData() {
 	   connection = handler.getConnection();
 	   data = FXCollections.observableArrayList();
 	   try {
 	   ResultSet rs4 = connection.createStatement().executeQuery("SELECT newUserName,newUserEmail,newUserFName,newUserLName,isConfirmed,newUserRole FROM arena.new_users\r\n" + 
 	   		" WHERE isConfirmed =\"no\"");
 	   while(rs4.next()) {
 		data.add(new usersInfo(rs4.getString(1),rs4.getString(2),rs4.getString(3),rs4.getString(4),rs4.getString(5),rs4.getString(6)));   
 	   }
 	   
 	   }
        catch(SQLException e5){
            e5.printStackTrace();
            System.out.println("SQL ERROR CONTROL SUPREME - e5");
        }
 	   columnScreenName.setCellValueFactory(new PropertyValueFactory<>("usersScreenName"));
 	   columnEmail.setCellValueFactory(new PropertyValueFactory<>("usersEmail"));
 	   columnFName.setCellValueFactory(new PropertyValueFactory<>("usersFname"));
 	   columnLName.setCellValueFactory(new PropertyValueFactory<>("usersLname"));
 	   columnRole.setCellValueFactory(new PropertyValueFactory<>("usersRole"));
 	   
 	   userIdTable.setItems(null);
 	   userIdTable.setItems(data);
    }
    @FXML
    private void removeNewUser(ActionEvent e ) {
    	connection = handler.getConnection();
        usersInfo userData = userIdTable.getSelectionModel().getSelectedItem();
        String theUserName = userData.getUsersScreenName();
        String sqlUpdate = "DELETE FROM arena.new_users WHERE newUserName =\"" +theUserName+"\"";
        try {
        	pst = connection.prepareStatement(sqlUpdate);
        }
        catch(SQLException e1){
            e1.printStackTrace();
        }
        try{
        pst.executeUpdate();
        }
        catch(SQLException e2){
            e2.printStackTrace();
            System.out.println("SQL ERROR CONTROL SUPREME - e2");
        }
        JustDoloadDateFromDatabase();
    }   
    @FXML
    private void removeApprovedNewUser(ActionEvent e ) {
    	connection = handler.getConnection();
        usersInfo userData = userIdTable.getSelectionModel().getSelectedItem();
        String theUserName = userData.getUsersScreenName();
        String sqlUpdate = "DELETE FROM arena.new_users WHERE newUserName =\"" +theUserName+"\"";
        try {
        	pst = connection.prepareStatement(sqlUpdate);
        }
        catch(SQLException e1){
            e1.printStackTrace();
        }
        try{
        pst.executeUpdate();
        }
        catch(SQLException e2){
            e2.printStackTrace();
            System.out.println("SQL ERROR CONTROL SUPREME - e2");
        }
        justDoloadApprovedUserData();
    }    
    @FXML 
    private void passDataSignUp(ActionEvent e) throws IOException{
        regSignUpButton.getScene().getWindow().hide();

        
              //Saving Data                             1            2               3           4             5           6            7           8
              String insert = "INSERT INTO new_users(newUserName,newUserPassword,newUserEmail,newUserFName,newUserLname,newUserRole,isConfirmed,newUserIDNum)"
                      + "VALUES (?,?,?,?,?,?,?,?)";
              connection = handler.getConnection();
              try {
              pst = connection.prepareStatement(insert);
              }
              catch(SQLException e1){
                  e1.printStackTrace();
                  System.out.println("SQL ERROR CONTROL SUPREME - e1");
              }
              String roleChoice="";
              String confirmMe = "yes";
              
              if(operatorRoleChoice.isSelected()) {
            	  roleChoice = "Operator";
              }
              else if(leagueOwnerRoleChoice.isSelected()) {
            	  roleChoice = "League Owner";
              }
              else if(playerRoleChoice.isSelected()) {
            	  roleChoice = "Player";
              }
              else if(advertRoleChoice.isSelected()) {
            	  roleChoice = "Advertiser";
              }
              else if(spectatorRoleChoice.isSelected()){
            	  roleChoice = "Spectator";
              }
              else{
            	  roleChoice = "No Role!!";
              }
             
              
              if(roleChoice.equals("League Owner") || roleChoice.equals("Operator")) {
            	  confirmMe = "no";
              }
              
              try{
              pst.setString(1, regUserName.getText()); // newUserName
              pst.setString(2, regPassword.getText()); // newUserPassword
              pst.setString(3, regEmail.getText());    // newUserEmail
              pst.setString(4, regFName.getText());    // newUserFName
              pst.setString(5, regLName.getText());    // newUserLName
              pst.setString(6, roleChoice);            // newUserRole
              pst.setString(7, confirmMe);             // isConfirmed
              pst.setInt(8, 0);                        // newUserIDNum
              
              pst.executeUpdate();
              }
              catch(SQLException e2){
                  e2.printStackTrace();
                  System.out.println("SQL ERROR CONTROL SUPREME - e2");
              } 
              if(roleChoice.equals("Operator")){  
              Stage stage = new Stage();
              Parent root = FXMLLoader.load(getClass().getResource("mainPage.fxml"));
              Scene scene = new Scene(root);
              stage.setScene(scene);
              stage.initStyle(StageStyle.UNDECORATED);
              stage.setResizable(false);
              stage.getIcons().add(new Image(getClass().getResourceAsStream("arenaIcon.png")));
              stage.show();
              }
              else if(roleChoice.equals("League Owner")) {
                  Stage stage = new Stage();
                  Parent root = FXMLLoader.load(getClass().getResource("mainPage.fxml"));
                  Scene scene = new Scene(root);
                  stage.setScene(scene);
                  stage.initStyle(StageStyle.UNDECORATED);
                  stage.setResizable(false);
                  stage.getIcons().add(new Image(getClass().getResourceAsStream("arenaIcon.png")));
                  stage.show(); 
              }
              else if(roleChoice.equals("Player")) {
                  Stage stage = new Stage();
                  Parent root = FXMLLoader.load(getClass().getResource("loginPage.fxml"));
                  Scene scene = new Scene(root);
                  stage.setScene(scene);
                  stage.initStyle(StageStyle.UNDECORATED);
                  stage.setResizable(false);
                  stage.getIcons().add(new Image(getClass().getResourceAsStream("arenaIcon.png")));
                  stage.show();
              }
              else if(roleChoice.equals("Advertiser")){
                  Stage stage = new Stage();
                  Parent root = FXMLLoader.load(getClass().getResource("loginPage.fxml"));
                  Scene scene = new Scene(root);
                  stage.setScene(scene);
                  stage.initStyle(StageStyle.UNDECORATED);
                  stage.setResizable(false);
                  stage.getIcons().add(new Image(getClass().getResourceAsStream("arenaIcon.png")));
                  stage.show();
              }
              else if(roleChoice.equals("Spectator")) {
                  Stage stage = new Stage();
                  Parent root = FXMLLoader.load(getClass().getResource("loginPage.fxml"));
                  Scene scene = new Scene(root);
                  stage.setScene(scene);
                  stage.initStyle(StageStyle.UNDECORATED);
                  stage.setResizable(false);
                  stage.getIcons().add(new Image(getClass().getResourceAsStream("arenaIcon.png")));
                  stage.show();
              }
    }
    @FXML
    private void signUpAction(ActionEvent e) throws IOException{
       signUpButton.getScene().getWindow().hide();
       Stage signupStage = new Stage();
       Parent root = FXMLLoader.load(getClass().getResource("signUpPage.fxml"));
       Scene scene = new Scene(root);
       signupStage.setScene(scene);
       signupStage.initStyle(StageStyle.UNDECORATED);
       signupStage.setResizable(false);
       signupStage.show();
   }
    
    @FXML
    private void operSignUpAction(ActionEvent e) throws IOException{
    	operUsersRemoveButton.getScene().getWindow().hide();
        Stage signupStage = new Stage();
        Parent root = FXMLLoader.load(getClass().getResource("operSignUpPage.fxml"));
        Scene scene = new Scene(root);
        signupStage.setScene(scene);
        signupStage.initStyle(StageStyle.UNDECORATED);
        signupStage.setResizable(false);
        signupStage.show();
    }
    
    @FXML 
    private void operPassDataSignUp(ActionEvent e) throws IOException{
        operRegSignUpButton.getScene().getWindow().hide();
              //Saving Data                             1            2               3           4             5           6            7           8
              String insert = "INSERT INTO new_users(newUserName,newUserPassword,newUserEmail,newUserFName,newUserLname,newUserRole,isConfirmed,newUserIDNum)"
                      + "VALUES (?,?,?,?,?,?,?,?)";
              connection = handler.getConnection();
              try {
              pst = connection.prepareStatement(insert);
              }
              catch(SQLException e1){
                  e1.printStackTrace();
                  System.out.println("SQL ERROR CONTROL SUPREME - e1");
              }
              String roleChoice="";
              String confirmMe = "yes";
              
              if(operatorRoleChoice.isSelected()) {
            	  roleChoice = "Operator";
              }
              else if(leagueOwnerRoleChoice.isSelected()) {
            	  roleChoice = "League Owner";
              }
              else if(playerRoleChoice.isSelected()) {
            	  roleChoice = "Player";
              }
              else if(advertRoleChoice.isSelected()) {
            	  roleChoice = "Advertiser";
              }
              else if(spectatorRoleChoice.isSelected()){
            	  roleChoice = "Spectator";
              }
              else{
            	  roleChoice = "No Role!!";
              }
              if(roleChoice.equals("League Owner") || roleChoice.equals("Operator")) {
            	  confirmMe = "no";
              }   
              try{
              pst.setString(1, regUserName.getText()); // newUserName
              pst.setString(2, regPassword.getText()); // newUserPassword
              pst.setString(3, regEmail.getText());    // newUserEmail
              pst.setString(4, regFName.getText());    // newUserFName
              pst.setString(5, regLName.getText());    // newUserLName
              pst.setString(6, roleChoice);            // newUserRole
              pst.setString(7, confirmMe);             // isConfirmed
              pst.setInt(8, 0);                        // newUserIDNum
              
              pst.executeUpdate();
              }
              catch(SQLException e2){
                  e2.printStackTrace();
                  System.out.println("SQL ERROR CONTROL SUPREME - e2");
              } 
              Stage stage = new Stage();
              Parent root = FXMLLoader.load(getClass().getResource("usersOperPage.fxml"));
              Scene scene = new Scene(root);
              stage.setScene(scene);
              stage.initStyle(StageStyle.UNDECORATED);
              stage.setResizable(false);
              stage.getIcons().add(new Image(getClass().getResourceAsStream("arenaIcon.png")));
              stage.show();
    }

   @FXML
    private void goBackAction(ActionEvent e) throws IOException{
       regGoBackButton.getScene().getWindow().hide();
       Stage stage = new Stage();
       Parent root = FXMLLoader.load(getClass().getResource("loginPage.fxml"));
       Scene scene = new Scene(root);
       stage.setScene(scene);
       stage.initStyle(StageStyle.UNDECORATED);
       stage.setResizable(false);
       stage.getIcons().add(new Image(getClass().getResourceAsStream("arenaIcon.png")));
       stage.show();
       logInErrorText.setVisible(false);
   }
   @FXML
    private void goBackOperAction(ActionEvent e) throws IOException{
      operGoBackButton.getScene().getWindow().hide();
      Stage stage = new Stage();
      Parent root = FXMLLoader.load(getClass().getResource("operatorMainPage.fxml"));
      Scene scene = new Scene(root);
      stage.setScene(scene);
      stage.initStyle(StageStyle.UNDECORATED);
      stage.setResizable(false);
      stage.show();
      logInErrorText.setVisible(false);
  }
   @FXML
    private void goToManageUsersPage(ActionEvent e) throws IOException{
	      operUsersManageButton.getScene().getWindow().hide();
	      Stage stage = new Stage();
	      Parent root = FXMLLoader.load(getClass().getResource("usersOperPage.fxml"));
	      Scene scene = new Scene(root);
	      stage.setScene(scene);
	      stage.initStyle(StageStyle.UNDECORATED);
	      stage.setResizable(false);
	      stage.show();
	      logInErrorText.setVisible(false);
   }
   @FXML
    private void loadDateFromDatabase(ActionEvent event) {
	   connection = handler.getConnection();
	   data = FXCollections.observableArrayList();
	   // Execute query & store result in a ResultSet
	   try {
	   ResultSet rs4 = connection.createStatement().executeQuery("SELECT newUserName,newUserEmail,newUserFName,newUserLName,isConfirmed,newUserRole FROM arena.new_users\r\n" + 
	   		" WHERE isConfirmed =\"no\"");
	   while(rs4.next()) {
		data.add(new usersInfo(rs4.getString(1),rs4.getString(2),rs4.getString(3),rs4.getString(4),rs4.getString(5),rs4.getString(6)));   
	   }
	   
	   }
       catch(SQLException e5){
           e5.printStackTrace();
           System.out.println("SQL ERROR CONTROL SUPREME - e5");
       }
	   columnScreenName.setCellValueFactory(new PropertyValueFactory<>("usersScreenName"));
	   columnEmail.setCellValueFactory(new PropertyValueFactory<>("usersEmail"));
	   columnFName.setCellValueFactory(new PropertyValueFactory<>("usersFname"));
	   columnLName.setCellValueFactory(new PropertyValueFactory<>("usersLname"));
	   columnIsConfirmed.setCellValueFactory(new PropertyValueFactory<>("isUsersConfirmed"));
	   columnRole.setCellValueFactory(new PropertyValueFactory<>("usersRole"));
	   
	   userIdTable.setItems(null);
	   userIdTable.setItems(data);
   }  
   @FXML
    private void loadApprovedUserData(ActionEvent e) {
	   connection = handler.getConnection();
	   data = FXCollections.observableArrayList();
	   try {
	   ResultSet rs4 = connection.createStatement().executeQuery("SELECT newUserName,newUserEmail,newUserFName,newUserLName,isConfirmed,newUserRole FROM arena.new_users\r\n" + 
	   		" WHERE isConfirmed =\"yes\"");
	   while(rs4.next()) {
		data.add(new usersInfo(rs4.getString(1),rs4.getString(2),rs4.getString(3),rs4.getString(4),rs4.getString(5),rs4.getString(6)));   
	   }
	   
	   }
       catch(SQLException e5){
           e5.printStackTrace();
           System.out.println("SQL ERROR CONTROL SUPREME - e5");
       }
	   columnScreenName.setCellValueFactory(new PropertyValueFactory<>("usersScreenName"));
	   columnEmail.setCellValueFactory(new PropertyValueFactory<>("usersEmail"));
	   columnFName.setCellValueFactory(new PropertyValueFactory<>("usersFname"));
	   columnLName.setCellValueFactory(new PropertyValueFactory<>("usersLname"));
	   columnRole.setCellValueFactory(new PropertyValueFactory<>("usersRole"));
	   
	   userIdTable.setItems(null);
	   userIdTable.setItems(data);
	   
   }
    private void JustDoloadDateFromDatabase() {
	   connection = handler.getConnection();
	   data = FXCollections.observableArrayList();
	   // Execute query & store result in a ResultSet
	   try {
	   ResultSet rs4 = connection.createStatement().executeQuery("SELECT newUserName,newUserEmail,newUserFName,newUserLName,isConfirmed,newUserRole FROM arena.new_users\r\n" + 
	   		" WHERE isConfirmed =\"no\"");
	   while(rs4.next()) {
		data.add(new usersInfo(rs4.getString(1),rs4.getString(2),rs4.getString(3),rs4.getString(4),rs4.getString(5),rs4.getString(6)));   
	   }
	   
	   }
       catch(SQLException e5){
           e5.printStackTrace();
           System.out.println("SQL ERROR CONTROL SUPREME - e5");
       }
	   columnScreenName.setCellValueFactory(new PropertyValueFactory<>("usersScreenName"));
	   columnEmail.setCellValueFactory(new PropertyValueFactory<>("usersEmail"));
	   columnFName.setCellValueFactory(new PropertyValueFactory<>("usersFname"));
	   columnLName.setCellValueFactory(new PropertyValueFactory<>("usersLname"));
	   columnIsConfirmed.setCellValueFactory(new PropertyValueFactory<>("isUsersConfirmed"));
	   columnRole.setCellValueFactory(new PropertyValueFactory<>("usersRole"));
	   
	   userIdTable.setItems(null);
	   userIdTable.setItems(data);

   }
   @FXML
    private void goToAppsPage(ActionEvent e) throws IOException{
	  applicationsButton.getScene().getWindow().hide();
     Stage stage = new Stage();
     Parent root = FXMLLoader.load(getClass().getResource("applicationOperPage.fxml"));
     Scene scene = new Scene(root);
     stage.setScene(scene);
     stage.initStyle(StageStyle.UNDECORATED);
     stage.setResizable(false);
     stage.show();
     logInErrorText.setVisible(false);
     connection = handler.getConnection();
     //loadMe.setVisible(false);
 }
    @Override
    public void initialize(URL url, ResourceBundle rb) {
    progress.setVisible(false);
    logInErrorText.setVisible(false);
    handler = new DBHandler();
    
    }    
}
