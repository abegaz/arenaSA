package arenaClasses;

import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;
import arenaClasses.DBHandler;
import arenaModels.UserModels;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class Controller extends Main{

// FXML View Attributes
 // << General Attributes >> ( Used on various View Pages )
    @FXML
    private Label closeIcon;
    @FXML
    private Label errorLabel;
// << loginPage Attributes >>
    @FXML
    private JFXButton loginPageSignUpButton;
    @FXML
    private JFXButton loginPageSignInButton;
    @FXML
    private ImageView loadingGif;
    @FXML
    private JFXTextField loginPageUserNameTextField;
    @FXML
    private JFXPasswordField loginPagePasswordField;
// << signUpPage Attributes >>
    @FXML
    private JFXTextField signUpPageUserNameTextField;
    @FXML
    private JFXPasswordField signUpPagePasswordField;
    @FXML
    private JFXButton signUpPageSignUpButton;
    @FXML
    private JFXButton signUpPageGoBackButton;
    @FXML
    private Label errorLabelRegForm;
    @FXML
    private Label successLabelRegForm;
// << spectatorLanding Attributes >>
    @FXML
    private JFXButton spectApply;
// << spectAppPage Attributes >>
    @FXML
    private JFXButton appOperatorButton;
    @FXML
    private JFXButton appLeagueOwnerButton;
    @FXML
    private JFXButton appPlayerButton;
    @FXML
    private JFXButton appAdvertiserButton;
    @FXML
    private Label appOperatorDetails;
    @FXML
    private Label appLeagueOwnerDetails;
    @FXML
    private Label appLeagueOwnerDetails1;
    @FXML
    private Label noRoleSelectedLabel;
    @FXML
    private JFXButton spectGoBackButton;
    @FXML
    private Label appPlayerDetails;
    @FXML
    private Label appPlayerDetails1;
    @FXML
    private Label appAdvertDetails;
 // << appConfPage Attributes >>
    @FXML
    private JFXButton confGoBackButton;
    @FXML
    private JFXButton confYesButton;
    @FXML
    private JFXButton confNoButton;
// << operatorLanding Attributes >>
    @FXML
    private JFXButton opSeePendingButton;
    @FXML
    private JFXButton opManageUsersButton;
// << operatorPending Attributes >>
    @FXML
    private JFXButton pendingGoBack;
    @FXML
    private TableView<TableViewController> userPendingTable;
    @FXML
    private TableColumn<TableViewController, Integer> pendingColumnUserID;
    @FXML
    private TableColumn<TableViewController, String> pendingColumnUserName;
    @FXML
    private TableColumn<TableViewController, Integer> pendingColumnCurrentRole;
    @FXML
    private TableColumn<TableViewController, Integer> pendingColumnDesiredRole;
    @FXML
    private JFXButton pendingApproveButton;
    @FXML
    private JFXButton pendingRemoveButton;
    @FXML
    private JFXButton pendingRefreshButton;
// << operatorManageUsersPage Attributes >>
    @FXML
    private JFXButton manageUsersGoBack;
    @FXML
    private JFXButton manageUsersRemoveButton;
    @FXML
    private JFXButton manageUsersRefreshButton;
    @FXML
    private TableView<ManageUsersController> manageUsersTable;
    @FXML
    private TableColumn<ManageUsersController, Integer> manageUsersColumnUserID;
    @FXML
    private TableColumn<ManageUsersController, String> manageUsersColumnUserName;
    @FXML
    private TableColumn<ManageUsersController, Integer> manageUsersColumnCurrentRole;
// << leagueOwnerLanding Attributes >> 
    @FXML
    private JFXButton leagueOwnerGoToTeamsButton;
 // << playerLanding Attributes >> 
    @FXML
    private JFXButton playerTeamAppButton;
    @FXML
    private JFXButton leagueOwnerPendingButton;
    @FXML
    private JFXButton leagueOwnerGoToTournsButton;
    @FXML
    private JFXButton leagueOwnerGoToMangLeagues;
    @FXML
    private JFXButton leagueOwnerGoToCreateLeagues;
    @FXML
    private JFXButton playerTeamJoinLeague;
    @FXML
    private JFXButton playerTeamMangLeague;
    



// Attributes used in various Role ID related Methods
ResultSet rs;
ResultSetMetaData rsmd;
String currentName, currentPass,columnValue ;
int columnsNumber;
Scene scene;
Stage stage = new Stage();
private ObservableList<TableViewController>data;
private ObservableList<ManageUsersController>data2;
private PreparedStatement pst,pstTwo;
static String currName,currPass;
public static int currUserID,currRoleID,appRoleChoice;
//-------------------------------------end_of_attributes----------------------------------------------------------------------

    @FXML
    private void goToSignUp(ActionEvent event) throws Exception {
    	loginPageSignUpButton.getScene().getWindow().hide();
        loader.setLocation(getClass().getResource("/arenaViews/signUpPage.fxml"));
        scene = new Scene(loader.load());
        stage.setScene(scene);
        stage.initStyle(StageStyle.UNDECORATED);
        stage.setResizable(false);
        stage.getIcons().add(new Image(getClass().getResourceAsStream("/images/arenaIcon.png")));
        stage.setTitle("Arena");
        stage.show();
        loadingGif.setVisible(true);
        }
// League Owner . Go to Manage Leagues Button Functionality
    @FXML
    private void goToMangLeag(ActionEvent event) throws Exception {
    	leagueOwnerGoToMangLeagues.getScene().getWindow().hide();
        loader.setLocation(getClass().getResource("/arenaViews/LeagueOwnerLeagueManagementPage.fxml"));
        scene = new Scene(loader.load());
        stage.setScene(scene);
        stage.initStyle(StageStyle.UNDECORATED);
        stage.setResizable(false);
        stage.getIcons().add(new Image(getClass().getResourceAsStream("/images/arenaIcon.png")));
        stage.setTitle("Arena");
        stage.show();
        }
// League Owner. Go to Create Leagues Button Functionality 
    @FXML
    private void goToCreateLeag(ActionEvent event) throws Exception {
    	leagueOwnerGoToCreateLeagues.getScene().getWindow().hide();
        loader.setLocation(getClass().getResource("/arenaViews/LeagueOwnerNewLeague.fxml"));
        scene = new Scene(loader.load());
        stage.setScene(scene);
        stage.initStyle(StageStyle.UNDECORATED);
        stage.setResizable(false);
        stage.getIcons().add(new Image(getClass().getResourceAsStream("/images/arenaIcon.png")));
        stage.setTitle("Arena");
        stage.show();
        }
// Player Landing. Go to Join League Button Functionality
    @FXML
    private void goToJoinLeag(ActionEvent event) throws Exception {
    	playerTeamJoinLeague.getScene().getWindow().hide();
        loader.setLocation(getClass().getResource("/arenaViews/PlayerJoinLeaguePage.fxml"));
        scene = new Scene(loader.load());
        stage.setScene(scene);
        stage.initStyle(StageStyle.UNDECORATED);
        stage.setResizable(false);
        stage.getIcons().add(new Image(getClass().getResourceAsStream("/images/arenaIcon.png")));
        stage.setTitle("Arena");
        stage.show();
        }
 // Player Landing. Go to Manage League Button Functionality
    @FXML
    private void goToPlayerMangLeag(ActionEvent event) throws Exception {
    	playerTeamMangLeague.getScene().getWindow().hide();
        loader.setLocation(getClass().getResource("/arenaViews/PlayerCurrentLeaguePage.fxml"));
        scene = new Scene(loader.load());
        stage.setScene(scene);
        stage.initStyle(StageStyle.UNDECORATED);
        stage.setResizable(false);
        stage.getIcons().add(new Image(getClass().getResourceAsStream("/images/arenaIcon.png")));
        stage.setTitle("Arena");
        stage.show();
        }
// Player Landing Page Go To teamsApp   
    @FXML
    private void goToTeamsApp(ActionEvent event) throws Exception {
    	playerTeamAppButton.getScene().getWindow().hide();
        loader.setLocation(getClass().getResource("/arenaViews/teamApp.fxml"));
        scene = new Scene(loader.load());
        stage.setScene(scene);
        stage.initStyle(StageStyle.UNDECORATED);
        stage.setResizable(false);
        stage.getIcons().add(new Image(getClass().getResourceAsStream("/images/arenaIcon.png")));
        stage.setTitle("Arena");
        stage.show();
        }

// Log In Page Sign In Button Functionality. Checks loginPageUserNameTextField & associated Password Field against users table to see if both exist
// If both UserName & Password exist in database. Uses their Role Type to determine which View they will land on.
// Checks if the User Name & Password entered by user Exist in users Table(loginPageSignInButton Functionality)
// Determines Landing Page by Associated Role ID # if one exist.
// Role IDs: #  ROLE
    //       1  Spectator
    //       2  Operator
    //       3  League Owner
    //       4  Player
    //       5  Advertiser
    @FXML
    private void signIn(ActionEvent event) throws SQLException, IOException
    {
    	int roleIDCheck = 0;
    	Connection myConnection = DBHandler.getConnection();
    	currentName = "\""+loginPageUserNameTextField.getText()+"\"";
    	currentPass = "\""+loginPagePasswordField.getText()+"\"";
    	currName = loginPageUserNameTextField.getText();
    	currPass = loginPagePasswordField.getText();
    	loadingGif.setVisible(true);
    	String queryOne = "SELECT * FROM users WHERE userName ="+ currentName + " AND userPassword =" + currentPass;
    	try
    	{
    		PreparedStatement preparedStatement = myConnection.prepareStatement(queryOne);
    		preparedStatement.executeQuery(queryOne);
    		rs = preparedStatement.executeQuery(queryOne);
    		// Display Current User Info in Console
    		rsmd = rs.getMetaData();
    		columnsNumber = rsmd.getColumnCount();
    		System.out.println("signIn ResultSet Contents: ");
    		while (rs.next())
    		{
    			for (int i = 1; i <= columnsNumber; i++)
    			{
    				if (i > 1) System.out.print("");
    				columnValue = rs.getString(i);
    				System.out.println(rsmd.getColumnName(i)+ " : " + columnValue);
    			}
    			System.out.println("");
    		}
    		// if userName & Password Match DOES NOT Exist
    		if (rs.first())
    		{
    			roleIDCheck = rs.getInt(4);
    			currUserID = rs.getInt("userID");
    			currRoleID = rs.getInt("userRoleID");
    		}
    		if(!rs.isBeforeFirst())
    		{
    			errorLabel.setVisible(true);
    			loadingGif.setVisible(true);
    		}
    	// If userName & Password Match DOES exist &
    		// Role ID # = 0 (Operator). Lands on "operatorLanding.fxml"
    		if((rs.first()) && roleIDCheck == 0)
    		{
    			loginPageSignInButton.getScene().getWindow().hide();
    			loader.setLocation(getClass().getResource("/arenaViews/operatorLanding.fxml"));
    			scene = new Scene(loader.load());
    			stage.setScene(scene);
    			stage.initStyle(StageStyle.UNDECORATED);
    			stage.setResizable(false);
    			stage.getIcons().add(new Image(getClass().getResourceAsStream("/images/arenaIcon.png")));
    			stage.setTitle("Arena");
    			stage.show();
    		}
    		// Role ID # = 1 (LeagueOwner). Lands on "leagueOwnerLanding.fxml"
    		if((rs.first()) && roleIDCheck == 1)
    		{
    			loginPageSignInButton.getScene().getWindow().hide();
    			loader.setLocation(getClass().getResource("/arenaViews/leagueOwnerLanding.fxml"));
    			scene = new Scene(loader.load());
    			stage.setScene(scene);
    			stage.initStyle(StageStyle.UNDECORATED);
    			stage.setResizable(false);
    			stage.getIcons().add(new Image(getClass().getResourceAsStream("/images/arenaIcon.png")));
    			stage.setTitle("Arena");
    			stage.show();
    		}
    		// Role ID # = 2 (Advertiser). Lands on "advertisorLanding.fxml"
    		if((rs.first()) && roleIDCheck == 2)
    		{
    			loginPageSignInButton.getScene().getWindow().hide();
    			loader.setLocation(getClass().getResource("/arenaViews/advertisorLanding.fxml"));
    			scene = new Scene(loader.load());
    			stage.setScene(scene);
    			stage.initStyle(StageStyle.UNDECORATED);
    			stage.setResizable(false);
    			stage.getIcons().add(new Image(getClass().getResourceAsStream("/images/arenaIcon.png")));
    			stage.setTitle("Arena");
    			stage.show();
            	UserModels UserID = new UserModels(currUserID);
            	UserID.setUserID(currUserID);
    		}
    		// Role ID # = 3 (Player). Lands on "playerLanding.fxml"
    		if((rs.first()) && roleIDCheck == 3)
    		{
    			loginPageSignInButton.getScene().getWindow().hide();
    			loader.setLocation(getClass().getResource("/arenaViews/playerLanding.fxml"));
    			scene = new Scene(loader.load());
            	stage.setScene(scene);
            	stage.initStyle(StageStyle.UNDECORATED);
            	stage.setResizable(false);
            	stage.getIcons().add(new Image(getClass().getResourceAsStream("/images/arenaIcon.png")));
            	stage.setTitle("Arena");
            	stage.show();
            	UserModels UserID = new UserModels(currUserID);
            	UserID.setUserID(currUserID);
    		}
    		// Role ID # = 4 (Spectator). Lands on "spectatorLanding.fxml"
    		if((rs.first()) && roleIDCheck == 4)
    		{
    			loginPageSignInButton.getScene().getWindow().hide();
    			loader.setLocation(getClass().getResource("/arenaViews/spectatorLanding.fxml"));
    			scene = new Scene(loader.load());
    			stage.setScene(scene);
    			stage.initStyle(StageStyle.UNDECORATED);
    			stage.setResizable(false);
    			stage.getIcons().add(new Image(getClass().getResourceAsStream("/images/arenaIcon.png")));
    			stage.setTitle("Arena");
    			stage.show();
    		}
    	}
    	catch(SQLException e)
    	{
    		System.out.println("ERROR: Issue Checking User Name & Password.");
    		e.printStackTrace();
    	}
    	finally
    	{
    		// Close Connection
    		myConnection.close();
    	}
    }
    // 'X' Label Functionality. Closes the Application.
    @FXML
    private void closeApplication(MouseEvent event)
    {
        System.exit(0);
    }
    // Sign Up Page Go Back Button Functionality. Brings user from "signUpPage" View to "loginPage" View.
    @FXML
    private void goBackToSignIn(ActionEvent event) throws Exception
    {
    	signUpPageGoBackButton.getScene().getWindow().hide();
    	loader.setLocation(getClass().getResource("/arenaViews/loginPage.fxml"));
    	scene = new Scene(loader.load());
    	stage.setScene(scene);
    	stage.initStyle(StageStyle.UNDECORATED);
    	stage.setResizable(false);
    	stage.getIcons().add(new Image(getClass().getResourceAsStream("/images/arenaIcon.png")));
    	stage.setTitle("Arena");
    	stage.show();
     }
    // Sign Up Page Sign Up Button Functionality. First Checks if signUpTextFied for User Name exist in users Table. If so. Displays Error to User
    // If NOT. Adds user to user Table. Displays Success Label to User.
    @FXML
    private void firstSignUp (ActionEvent event) throws SQLException, IOException
    {
    	Connection myConnection = DBHandler.getConnection();
        String signUpName ="\""+ signUpPageUserNameTextField.getText()+ "\"";
    	String queryFour = "SELECT * FROM arenadatabase.users WHERE users.userName ="+signUpName+"";
    	try
    	{
    		PreparedStatement preparedStatementOne = myConnection.prepareStatement(queryFour);
    		preparedStatementOne.executeQuery(queryFour);
    		rs = preparedStatementOne.executeQuery(queryFour);
    	}
    	catch(SQLException e)
    	{
    		e.printStackTrace();
    		System.out.println("ERROR @ Conrol.firstSignUp. First Try/Catch.");
    	}
    	// already exist
    	if(rs.first())
    	{
    		successLabelRegForm.setVisible(false);
    		errorLabelRegForm.setVisible(true);
    		myConnection.close();
    	}
    	// does NOT exist
    	else if(!rs.isBeforeFirst())
    	{
    		String insert = "INSERT INTO users(userName,userPassword)"
                + "VALUES (?,?)";
    		try
    		{
    			PreparedStatement preparedStatement = myConnection.prepareStatement(insert);
    			preparedStatement.setString (1, signUpPageUserNameTextField.getText());
    			preparedStatement.setString (2, signUpPagePasswordField.getText());
    			preparedStatement.execute();
    		}
    		catch(Exception e)
    		{
    			e.printStackTrace();
    			System.out.println("ERROR: Prepared Statement Failure @ Sign Up Button. Control.firstSignUp. 2nd Try/Catch.");
    		}
    		finally
    		{
    			myConnection.close();
    		}
    		// User Successfully Added
    		errorLabelRegForm.setVisible(false);
    		successLabelRegForm.setVisible(true);
    		}
    	}
    // Spectator Landing Page's Apply Button (spectApply Functionality)  Brings User from Spectator Page to Application Page
    @FXML
    private void goToApplicationPage(ActionEvent event) throws Exception
    {
        spectApply.getScene().getWindow().hide();
        loader.setLocation(getClass().getResource("/arenaViews/spectAppPage.fxml"));
        scene = new Scene(loader.load());
        stage.setScene(scene);
        stage.initStyle(StageStyle.UNDECORATED);
        stage.setResizable(false);
        stage.getIcons().add(new Image(getClass().getResourceAsStream("/images/arenaIcon.png")));
        stage.setTitle("Arena");
        stage.show();
    }
    // League Owner's Manage Team Button Functionality. Brings League Owner to Manage Teams Page (from leagueOwnerLanding to teamsPage ) 
    @FXML
    private void goToLOTeamsPage(ActionEvent event) throws Exception
    {
    	leagueOwnerGoToTeamsButton.getScene().getWindow().hide();
        loader.setLocation(getClass().getResource("/arenaViews/teamsPage.fxml"));
        scene = new Scene(loader.load());
        stage.setScene(scene);
        stage.initStyle(StageStyle.UNDECORATED);
        stage.setResizable(false);
        stage.getIcons().add(new Image(getClass().getResourceAsStream("/images/arenaIcon.png")));
        stage.setTitle("Arena");
        stage.show();
    }
    
    // Operator Landing Page's Pending Application Button Functionality. Brings User from Operator Landing to Operator Pending User Management Page.
    @FXML
    private void opGoToPending(ActionEvent event) throws Exception
    {
    	opSeePendingButton.getScene().getWindow().hide();
        loader.setLocation(getClass().getResource("/arenaViews/operatorPendingPage.fxml"));
        scene = new Scene(loader.load());
        stage.setScene(scene);
        stage.initStyle(StageStyle.UNDECORATED);
        stage.setResizable(false);
        stage.getIcons().add(new Image(getClass().getResourceAsStream("/images/arenaIcon.png")));
        stage.setTitle("Arena");
        stage.show();
    }
    // Operator Pending Page's Go Back Button Functionality. Brings User from Operator Pending User Management Page to Operator Landing Page.
    @FXML
    private void goBackToOpLanding(ActionEvent event) throws Exception
    {
    	pendingGoBack.getScene().getWindow().hide();
        loader.setLocation(getClass().getResource("/arenaViews/operatorLanding.fxml"));
        scene = new Scene(loader.load());
        stage.setScene(scene);
        stage.initStyle(StageStyle.UNDECORATED);
        stage.setResizable(false);
        stage.getIcons().add(new Image(getClass().getResourceAsStream("/images/arenaIcon.png")));
        stage.setTitle("Arena");
        stage.show();
    }
    // Operator Manage Users Page's Go Back Button Functionality.
    @FXML
    private void goBackToOpLandingForMangUsers(ActionEvent event) throws Exception
    {
    	manageUsersGoBack.getScene().getWindow().hide();
        loader.setLocation(getClass().getResource("/arenaViews/operatorLanding.fxml"));
        scene = new Scene(loader.load());
        stage.setScene(scene);
        stage.initStyle(StageStyle.UNDECORATED);
        stage.setResizable(false);
        stage.getIcons().add(new Image(getClass().getResourceAsStream("/images/arenaIcon.png")));
        stage.setTitle("Arena");
        stage.show();
    }
    // Operator Pending User Management Page Refresh Button Functionality. Populates pending Table View from pending Table.
    @FXML
    private void pendingUsersToTableView(ActionEvent event) throws SQLException
    {
    	Connection myConnection = DBHandler.getConnection();
    	data = FXCollections.observableArrayList();
    	try
    	{
    		/*String originalQuery =
    				"SELECT appUserID,appUserName,appCurrentRole,roleID_desired "
    				+ "FROM arenadatabase.pending";*/
    		String getAllPendingApplicationQuery = ""
    				+ "SELECT  pendingTable.appUserID, userTable.userName, pendingTable.appCurrentRole, pendingTable.desired_RoleID "
    				+ "FROM pending pendingTable, users userTable "
    				+ "WHERE userTable.userID = pendingTable.appUserID";
    		ResultSet rs2 = myConnection.createStatement().executeQuery(getAllPendingApplicationQuery);
    		while(rs2.next())
    		{
    			int appUserID = rs2.getInt("pendingTable.appUserID");
				String appUserName = rs2.getString("userTable.userName");
				int appCurrentRole = rs2.getInt("pendingTable.appCurrentRole");
				int desired_RoleIDNew = rs2.getInt("pendingTable.desired_RoleID");
    			data.add(new TableViewController(appUserID, appUserName, appCurrentRole, desired_RoleIDNew));
    		}
    	}
    	catch(SQLException e)
    	{
    		e.printStackTrace();
    		System.out.println("ERROR @ Controller.pendingUsersToTableView");
    	}
    	pendingUsersToTableLoad();
    	pendingColumnUserID.setCellValueFactory(new PropertyValueFactory<>("appUserID"));
    	pendingColumnUserName.setCellValueFactory(new PropertyValueFactory<>("appUserName"));
    	pendingColumnCurrentRole.setCellValueFactory(new PropertyValueFactory<>("appCurrentRole"));
    	pendingColumnDesiredRole.setCellValueFactory(new PropertyValueFactory<>("desired_RoleIDNew"));
    	userPendingTable.setItems(data);
    }
    // Loads data from pending Table to Operator Pending User Management Table View. NOT FXML related. Used to Refresh Table View without Need
    // to press Refresh Button
    private void pendingUsersToTableLoad() throws SQLException
    {
    	Connection myConnection = DBHandler.getConnection();
    	data = FXCollections.observableArrayList();
    	try
    	{
    		//String OriginalgetAllPendingUsertoTableLoadQuery = "SELECT appUserID,appUserName,appCurrentRole,roleID_desired FROM arenadatabase.pending";
    		String getAllPendingUsertoTableLoadQuery = ""
    				+ "SELECT  pendingTable.appUserID, userTable.userName, pendingTable.appCurrentRole, pendingTable.desired_RoleID "
    				+ "FROM pending pendingTable, users userTable "
    				+ "WHERE userTable.userID = pendingTable.appUserID";
    		ResultSet rs2 = myConnection.createStatement().executeQuery(getAllPendingUsertoTableLoadQuery);
    		while(rs2.next())
    		{
    			data.add(new TableViewController(	rs2.getInt("pendingTable.appUserID"),
    												rs2.getString("userTable.userName"),
    												rs2.getInt("pendingTable.appCurrentRole"),
    												rs2.getInt("pendingTable.desired_RoleID")));
    		}
    	}
    	catch(SQLException e) {
    		e.printStackTrace();
    		System.out.println("ERROR @ Controller.pendingUsersToTableView");
    	}
    	pendingColumnUserID.setCellValueFactory(new PropertyValueFactory<>("pendingTable.appUserID"));
    	pendingColumnUserName.setCellValueFactory(new PropertyValueFactory<>("userTable.userName"));
    	pendingColumnCurrentRole.setCellValueFactory(new PropertyValueFactory<>("pendingTable.appCurrentRole"));
    	pendingColumnDesiredRole.setCellValueFactory(new PropertyValueFactory<>("pendingTable.desired_RoleID"));
    	userPendingTable.setItems(data);
    }
    // From Spectator's Application Page Go Back to Spectator's Landing Page ( Go Back Button Functionality )
    @FXML
    private void goBackToSpect(ActionEvent event) throws Exception
    {
    	spectGoBackButton.getScene().getWindow().hide();
    	loader.setLocation(getClass().getResource("/arenaViews/spectatorLanding.fxml"));
    	scene = new Scene(loader.load());
    	stage.setScene(scene);
    	stage.initStyle(StageStyle.UNDECORATED);
    	stage.setResizable(false);
    	stage.getIcons().add(new Image(getClass().getResourceAsStream("/images/arenaIcon.png")));
    	stage.setTitle("Arena");
    	stage.show();
     }
    // From Spectator's Application Confirmation Page back to Spectator's Application Page ( Go Back Button Functionality )
    @FXML
    private void goBackToApp(ActionEvent event) throws Exception
    {
    	confGoBackButton.getScene().getWindow().hide();
    	loader.setLocation(getClass().getResource("/arenaViews/spectAppPage.fxml"));
    	scene = new Scene(loader.load());
    	stage.setScene(scene);
    	stage.initStyle(StageStyle.UNDECORATED);
    	stage.setResizable(false);
    	stage.getIcons().add(new Image(getClass().getResourceAsStream("/images/arenaIcon.png")));
    	stage.setTitle("Arena");
    	pendingUsersToTableLoad();
    	stage.show();
     }
    // Application Choice Button Functionality. Goes from Spectator Application Page to Spectator Confirmation Page.
    @FXML
    private void appChoice(ActionEvent event) throws Exception
    {
    	appOperatorButton.getScene().getWindow().hide();
        loader.setLocation(getClass().getResource("/arenaViews/appConfPage.fxml"));
        scene = new Scene(loader.load());
        stage.setScene(scene);
        stage.initStyle(StageStyle.UNDECORATED);
        stage.setResizable(false);
        stage.getIcons().add(new Image(getClass().getResourceAsStream("/images/arenaIcon.png")));
        stage.setTitle("Arena");
        stage.show();
    }
    // Spectator Page Show / Hide Label(s)
    @FXML
    private void showRoleDetails(MouseEvent event) throws IOException
    {
    	appOperatorDetails.setVisible(true);
    	noRoleSelectedLabel.setVisible(false);
    }
    @FXML
    private void hideRoleDetails(MouseEvent event) throws IOException
    {
    	appOperatorDetails.setVisible(false);
    	noRoleSelectedLabel.setVisible(true);
    }
    @FXML
    private void showLoRoleDetails(MouseEvent event) throws IOException
    {
    	appLeagueOwnerDetails.setVisible(true);
    	appLeagueOwnerDetails1.setVisible(true);
    	noRoleSelectedLabel.setVisible(false);
    }
    @FXML
    private void hideLoRoleDetails(MouseEvent event) throws IOException
    {
    	appLeagueOwnerDetails.setVisible(false);
    	appLeagueOwnerDetails1.setVisible(false);
    	noRoleSelectedLabel.setVisible(true);
    }
    @FXML
    private void showPlayerRoleDetails(MouseEvent event) throws IOException
    {
    	appPlayerDetails.setVisible(true);
    	appPlayerDetails1.setVisible(true);
    	noRoleSelectedLabel.setVisible(false);
    }
    @FXML
    private void hidePlayerRoleDetails(MouseEvent event) throws IOException
    {
    	appPlayerDetails.setVisible(false);
    	appPlayerDetails1.setVisible(false);
    	noRoleSelectedLabel.setVisible(true);
    }
    @FXML
    private void showAdvertRoleDetails(MouseEvent event) throws IOException
    {
    	appAdvertDetails.setVisible(true);
    	noRoleSelectedLabel.setVisible(false);
    }
    @FXML
    private void hideAdvertRoleDetails(MouseEvent event) throws IOException
    {
    	appAdvertDetails.setVisible(false);
    	noRoleSelectedLabel.setVisible(true);
    }
    //---------------------end Spectator Page Show/Hide Label(s) Methods----------------------------

    // Gets Role Choice. Spectator Role Choice Button(s) Functionality.
    @FXML
    private void appOpChoice(MouseEvent event) throws IOException
    {
    	appRoleChoice = 0;
    }
    @FXML
    private void appLoChoice(MouseEvent event) throws IOException
    {
    	appRoleChoice = 1;
    }
    @FXML
    private void appPlChoice(MouseEvent event) throws IOException
    {
    	appRoleChoice = 3;
    }
    @FXML
    private void appAdChoice(MouseEvent event) throws IOException
    {
    	appRoleChoice = 2;
    }

 //-------- end Get Role Spectator Button Functionality ----------

 // Spectator confirmation YES button Functionality
    @FXML
    private void confYes(ActionEvent event) throws SQLException, IOException
    {
    	Connection myConnection = DBHandler.getConnection();
    	//String modCN = "\""+currName+"\"";
    	//String modCP = "\""+currPass+"\"";
    	// if Operator Chosen. Add to Pending Table
    	if(appRoleChoice == 0)
    	{
    		String confYesInsert = "INSERT INTO pending (appUserID,appCurrentRole,desired_RoleID)"
        			+ " VALUES("+currUserID+","+currRoleID+","+appRoleChoice+")";

    		//String confYesInsert = "INSERT INTO pending (roleID_desired,appUserID,appUserName,appUserPassword,appCurrentRole) VALUES("+appRoleChoice+","+currUserID+","+modCN+","+modCP+","+currRoleID+")";
    		try
    		{
    			PreparedStatement preparedStatement = myConnection.prepareStatement(confYesInsert);
    			preparedStatement.execute(confYesInsert);
    		}
    		catch(SQLException e)
    		{
    			e.printStackTrace();
    			System.out.println("ERROR: AT Controller.confYes.appRoleChoice 0");
    		}
    		finally
    		{
    			myConnection.close();
    		}
    	}
    	// if League Owner is chosen. Add to Pending Table
    	if(appRoleChoice == 1)
    	{
    		String confYesInsert = "INSERT INTO pending (appUserID,appCurrentRole,desired_RoleID)"
        			+ " VALUES("+currUserID+","+currRoleID+","+appRoleChoice+")";
    		//String confYesInsert = "INSERT INTO pending (roleID_desired,appUserID,appUserName,appUserPassword,appCurrentRole) VALUES("+appRoleChoice+","+currUserID+","+modCN+","+modCP+","+currRoleID+")";
    		try
    		{
    			PreparedStatement preparedStatement = myConnection.prepareStatement(confYesInsert);
    			preparedStatement.execute(confYesInsert);
    		}
    		catch(SQLException e)
    		{
    			e.printStackTrace();
    			System.out.println("ERROR: AT Controller.confYes.appRoleChoie 1");
    		}
    		finally
    		{
    			myConnection.close();
    		}
    	}
    	// if Advertiser is Chosen. Update User Role ID.
    	if(appRoleChoice == 2)
    	{
    		String confYesInsert ="UPDATE arenadatabase.users SET userRoleID = ? WHERE userID = ?";
    		try
    		{
    			PreparedStatement preparedStatement = myConnection.prepareStatement(confYesInsert);
    			preparedStatement.setInt(1,appRoleChoice);
    			preparedStatement.setInt(2, currUserID);
    			preparedStatement.executeUpdate();
    		}
    		catch(SQLException e)
    		{
    			e.printStackTrace();
    			System.out.println("ERROR: AT Controller.confYes.appRoleChoice 2");
    		}
    		finally
    		{
    			myConnection.close();
    		}
    	}
    	// if Player is Chosen. Update User Role ID.
    	if(appRoleChoice == 3)
    	{
    		String confYesInsert ="UPDATE arenadatabase.users SET userRoleID = ? WHERE userID = ?";
    		try
    		{
    			PreparedStatement preparedStatement = myConnection.prepareStatement(confYesInsert);
    			preparedStatement.setInt(1,appRoleChoice);
    			preparedStatement.setInt(2, currUserID);
    			preparedStatement.executeUpdate();
    		}
    		catch(SQLException e)
    		{
    			e.printStackTrace();
    			System.out.println("ERROR: AT Controller.confYes.appRoleChoice 3");
    		}
    		finally
    		{
    			myConnection.close();
    		}
    	}

    	// Bring User back to Log in.
    	confYesButton.getScene().getWindow().hide();
    	loader.setLocation(getClass().getResource("/arenaViews/loginPage.fxml"));
    	sceneLogin = new Scene(loader.load());
    	stage.setScene(sceneLogin);
		stage.initStyle(StageStyle.UNDECORATED);
    	stage.getIcons().add(new Image(getClass().getResourceAsStream("/images/arenaIcon.png")));
    	stage.setTitle("Arena");
    	stage.setResizable(false);
    	stage.show();
    }
// Spectator Confirmation NO Button Functionality
    @FXML
    private void confNo(ActionEvent event) throws IOException
    {
        confGoBackButton.getScene().getWindow().hide();
        loader.setLocation(getClass().getResource("/arenaViews/spectAppPage.fxml"));
        scene = new Scene(loader.load());
        stage.setScene(scene);
        stage.initStyle(StageStyle.UNDECORATED);
        stage.setResizable(false);
        stage.getIcons().add(new Image(getClass().getResourceAsStream("/images/arenaIcon.png")));
        stage.setTitle("Arena");
        stage.show();
    }
// Operator Pending Users Manage Page Approve Button Functionality. Will Change the Role of Selected ID to Desired Role
// Then Delete that selection from pending Table.
    @FXML
    private void approveNewUser(ActionEvent event) throws SQLException
    {
    	Connection myConnection = DBHandler.getConnection();
    	TableViewController userData = userPendingTable.getSelectionModel().getSelectedItem();
    	userData.setAppCurrentRole(appRoleChoice);
    	int selectedDesiredRole = userData.getdesired_RoleIDNew();
    	int selectedUserID = userData.getAppUserID();
    	String sqlUpdateTwo ="UPDATE arenadatabase.users SET userRoleID = "+selectedDesiredRole+" WHERE users.userID = "+selectedUserID;
    	String sqlUpdate = "DELETE FROM arenadatabase.pending WHERE pending.appUserID ="+selectedUserID+"";
    	try
    	{
    		pst = myConnection.prepareStatement(sqlUpdate);
    		pstTwo = myConnection.prepareStatement(sqlUpdateTwo);
    	}
    	catch(SQLException e)
    	{
    		e.printStackTrace();
    		System.out.println("ERROR @ Control.approveNewUser");
    	}
    	try
    	{
    		pst.executeUpdate();
    		pstTwo.execute(sqlUpdateTwo);
    		pendingUsersToTableLoad();
    	}
    	catch(SQLException e)
    	{
    		e.printStackTrace();
    		System.out.println("ERROR @ Control.approveNewUser");
    	}
    	finally
    	{
    		myConnection.close();
    	}
    }
// Deletes selected userID Row from pending Table. User will need to Apply again if they want to be considered again.
    @FXML
    private void denyNewUser(ActionEvent event) throws SQLException
    {
        Connection myConnection = DBHandler.getConnection();
        TableViewController userData = userPendingTable.getSelectionModel().getSelectedItem();
        userData.setAppCurrentRole(appRoleChoice);
        int selectedUserID = userData.getAppUserID();
        String sqlUpdateThree = "DELETE FROM arenadatabase.pending WHERE pending.appUserID ="+selectedUserID+"";
        try
        {
        	pstTwo = myConnection.prepareStatement(sqlUpdateThree);
        }
        catch(SQLException e)
        {
            e.printStackTrace();
            System.out.println("ERROR @ Control.approveNewUser");
        }
        try
        {
        	pstTwo.execute(sqlUpdateThree);
        	pendingUsersToTableLoad();
        }
        catch(SQLException e)
        {
            e.printStackTrace();
            System.out.println("ERROR @ Control.approveNewUser");
        }
        finally
        {
        	myConnection.close();
        }
        }
// Operators Landing Page. Manage Users Button Functionality. Goes from "operatorLanding" to "operatorManageUsersPage"
        @FXML
    private void goToMangUsers(ActionEvent event) throws Exception
    {
        opManageUsersButton.getScene().getWindow().hide();
        loader.setLocation(getClass().getResource("/arenaViews/operatorManageUsersPage.fxml"));
        scene = new Scene(loader.load());
        stage.setScene(scene);
        stage.initStyle(StageStyle.UNDECORATED);
        stage.setResizable(false);
        stage.getIcons().add(new Image(getClass().getResourceAsStream("/images/arenaIcon.png")));
        stage.setTitle("Arena");
        stage.show();
	}
// League Owner Go To Tourn Management Page 
        @FXML
    private void goToTournMang(ActionEvent event) throws Exception
    {
        leagueOwnerGoToTournsButton.getScene().getWindow().hide();
        loader.setLocation(getClass().getResource("/arenaViews/GetTournaments.fxml"));
        scene = new Scene(loader.load());
        stage.setScene(scene);
        stage.initStyle(StageStyle.UNDECORATED);
        stage.setResizable(false);
        stage.getIcons().add(new Image(getClass().getResourceAsStream("/images/arenaIcon.png")));
        stage.setTitle("Arena");
        stage.show();
	}
// Operator Manage Users TableView. Populate Table from users Table when user presses Refresh Button.
	@FXML
	private void ManageUsersToTableView(ActionEvent event) throws SQLException
	{
		Connection myConnection = DBHandler.getConnection();
		data2 = FXCollections.observableArrayList();
		try
		{
			ResultSet rs3 = myConnection.createStatement().executeQuery("SELECT userID, userName, userRoleID FROM users");
			while(rs3.next())
			{
				data2.add(new ManageUsersController(rs3.getInt("userID"),rs3.getString("userName"),rs3.getInt("userRoleID")));
			}
		}
		catch(SQLException e)
		{
			e.printStackTrace();
			System.out.println("ERROR @ Controller.ManageUsersToTableView");
		}
		manageUsersColumnUserID.setCellValueFactory(new PropertyValueFactory<>("userID"));
		manageUsersColumnUserName.setCellValueFactory(new PropertyValueFactory<>("userName"));
		manageUsersColumnCurrentRole.setCellValueFactory(new PropertyValueFactory<>("userRoleID"));
		manageUsersTable.setItems(data2);
	}
// Just Do. Load Manage Users Table View.
	private void JustDoManageUsersToTableView() throws SQLException
	{
		Connection myConnection = DBHandler.getConnection();
		data2 = FXCollections.observableArrayList();
		try
		{
			ResultSet rs3 = myConnection.createStatement().executeQuery("SELECT userID, userName, userRoleID FROM users");
			while(rs3.next())
			{
				data2.add(new ManageUsersController(rs3.getInt("userID"),rs3.getString("userName"),rs3.getInt("userRoleID")));
			}
		}
		catch(SQLException e)
		{
			e.printStackTrace();
			System.out.println("ERROR @ Controller.ManageUsersToTableView");
		}
		manageUsersColumnUserID.setCellValueFactory(new PropertyValueFactory<>("userID"));
		manageUsersColumnUserName.setCellValueFactory(new PropertyValueFactory<>("userName"));
		manageUsersColumnCurrentRole.setCellValueFactory(new PropertyValueFactory<>("userRoleID"));
		manageUsersTable.setItems(data2);
	}
 // Operator Manager Users TableView. Remove Button Functionality. Removes Selected user from Users Table.
        @FXML
	private void removeUser(ActionEvent event) throws SQLException
	{
		Connection myConnection = DBHandler.getConnection();
		ManageUsersController userData2 = manageUsersTable.getSelectionModel().getSelectedItem();
		//userData.setAppCurrentRole(appRoleChoice);
		int selectedUserID = userData2.getUserID();
		String sqlUpdateThree = "DELETE FROM arenadatabase.users WHERE users.userID =" +selectedUserID +"";
		try
		{
			pstTwo = myConnection.prepareStatement(sqlUpdateThree);
		}
		catch(SQLException e)
		{
			e.printStackTrace();
			System.out.println("ERROR @ Control.removeUser.First Try");
		}
		try
		{
			pstTwo.execute(sqlUpdateThree);
			JustDoManageUsersToTableView();
		}
		catch(SQLException e)
		{
			e.printStackTrace();
			System.out.println("ERROR @ Control.removeUser. 2nd Try");
		}
		finally
		{
			myConnection.close();
		}
	}
 // League Owner to Pending Team Applications
        @FXML
        private void goToLoAppsPage(ActionEvent event) throws Exception {
        	leagueOwnerPendingButton.getScene().getWindow().hide();
            loader.setLocation(getClass().getResource("/arenaViews/loPlayerApp.fxml"));
            scene = new Scene(loader.load());
            stage.setScene(scene);
            stage.initStyle(StageStyle.UNDECORATED);
            stage.setResizable(false);
            stage.getIcons().add(new Image(getClass().getResourceAsStream("/images/arenaIcon.png")));
            stage.setTitle("Arena");
            stage.show();
            }
        
}

