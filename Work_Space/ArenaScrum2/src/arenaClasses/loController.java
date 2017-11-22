package arenaClasses;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;
import com.jfoenix.controls.JFXButton;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

public class loController extends Main  implements Initializable {

@FXML
private JFXButton signUpPageGoBackButton;
@FXML
private JFXButton leagueOwnerGoToTeamsButton;
@FXML
private Label closeIcon;
@FXML
private JFXButton leagueOwnerPendingButton;
@FXML
private JFXButton LoCreateMatch;
@FXML 
private JFXButton leagueOwnerGoToManageTournsButton;
@FXML 
private JFXButton leagueOwnerGoToCreateTournsButton;
@FXML
private JFXButton leagueOwnerGoToManagePlayers;
@FXML
private JFXButton leagueOwnerGoToMangLeagues;
@FXML
private JFXButton leagueOwnerGoToCreateLeagues;
@FXML
private ImageView loRightBannerImage;
@FXML
private ImageView loLeftBannerImage;
@FXML
private ImageView loTopBannerImage;
@FXML
private ImageView loBottomBannerImage;
@FXML
private ImageView loBGBannerImage;
@FXML
private JFXButton conductTournamentButton;
@FXML
private Label playerNameLabel;



Scene scene;
Stage stage = new Stage();
ResultSet rs;


@Override
public void initialize(URL location, ResourceBundle resources)
		{
			try{
				setLoADTop();
				setLoADBottom();
				setLoADLeft();
				setLoADRight();
				setLoADBG();
				setUserName();

				}
			catch(Exception e)
			{
				e.printStackTrace();
				System.out.println("Error@ loController.initialize");
			}
		}
private void setUserName() {
	playerNameLabel.setText(Controller.currName);
}
@FXML
private void closeApplication(MouseEvent event)
    {
	    System.gc();
        System.exit(0);
    }
@FXML
private void goBackToSignIn(ActionEvent event) throws Exception
    {
	signUpPageGoBackButton.getScene().getWindow().hide();
	loader.setLocation(getClass().getResource("/arenaViews/loginPage.fxml"));
	scene = new Scene(loader.load());
	stage.setScene(scene);
	stage.setResizable(false);
	stage.getIcons().add(new Image(getClass().getResourceAsStream("/images/arenaIcon.png")));
	stage.setTitle("Arena");
	stage.show();
	System.gc();
     }
@FXML
private void goToConductTournament(ActionEvent event) throws Exception
{
	conductTournamentButton.getScene().getWindow().hide();
	loader.setLocation(getClass().getResource("/arenaViews/ConductTournamentPage.fxml"));
	scene = new Scene(loader.load());
	stage.setScene(scene);
	stage.setResizable(false);
	stage.getIcons().add(new Image(getClass().getResourceAsStream("/images/arenaIcon.png")));
	stage.setTitle("Arena");
	stage.show();
	System.gc();
}
@FXML
private void goToCreateLeag(ActionEvent event) throws Exception {
    	leagueOwnerGoToCreateLeagues.getScene().getWindow().hide();
        loader.setLocation(getClass().getResource("/arenaViews/LeagueOwnerNewLeague.fxml"));
        scene = new Scene(loader.load());
        stage.setScene(scene);
        stage.setResizable(false);
        stage.getIcons().add(new Image(getClass().getResourceAsStream("/images/arenaIcon.png")));
        stage.setTitle("Arena");
        stage.show();
        System.gc();
        }
@FXML
private void goToTournMang(ActionEvent event) throws Exception
{
   leagueOwnerGoToManageTournsButton.getScene().getWindow().hide();
   loader.setLocation(getClass().getResource("/arenaViews/ManageTournaments.fxml"));
   scene = new Scene(loader.load());
   stage.setScene(scene);
   stage.setResizable(false);
   stage.getIcons().add(new Image(getClass().getResourceAsStream("/images/arenaIcon.png")));
   stage.setTitle("Arena");
   stage.show();
   System.gc();
}
@FXML
private void goToLOTeamsPage(ActionEvent event) throws Exception
    {
    	leagueOwnerGoToTeamsButton.getScene().getWindow().hide();
        loader.setLocation(getClass().getResource("/arenaViews/makeTeam.fxml"));
        scene = new Scene(loader.load());
        stage.setScene(scene);
        stage.setResizable(false);
        stage.getIcons().add(new Image(getClass().getResourceAsStream("/images/arenaIcon.png")));
        stage.setTitle("Arena");
        stage.show();
    }
@FXML
private void goToLoPlayersApp(ActionEvent event) throws Exception {
	    leagueOwnerPendingButton.getScene().getWindow().hide();
        loader.setLocation(getClass().getResource("/arenaViews/loPlayerApp.fxml"));
        scene = new Scene(loader.load());
        stage.setScene(scene);
        stage.setResizable(false);
        stage.getIcons().add(new Image(getClass().getResourceAsStream("/images/arenaIcon.png")));
        stage.setTitle("Arena");
        stage.show();
        System.gc();
        }
@FXML
void goToCreateMatch(ActionEvent event) throws IOException {
	 LoCreateMatch.getScene().getWindow().hide();
     loader.setLocation(getClass().getResource("/arenaViews/MatchMaker.fxml"));
     scene = new Scene(loader.load());
     stage.setScene(scene);
     stage.setResizable(false);
     stage.getIcons().add(new Image(getClass().getResourceAsStream("/images/arenaIcon.png")));
     stage.setTitle("Arena");
     stage.show();
     System.gc();
}
@FXML
private void goToCreateTournamentsView (ActionEvent event) throws Exception
 {
 	//System.out.println("Go to Create Arenas");
 	 leagueOwnerGoToCreateTournsButton.getScene().getWindow().hide();
     loader.setLocation(getClass().getResource("/arenaViews/CreateTournaments.fxml"));
     scene = new Scene(loader.load());
     stage.setScene(scene);
     stage.setResizable(false);
     stage.getIcons().add(new Image(getClass().getResourceAsStream("/images/arenaIcon.png")));
     stage.setTitle("Arena");
     stage.show();
     System.gc();
 }
@FXML
private void goToPlayerManagement(ActionEvent event) throws Exception {
      	  leagueOwnerGoToManagePlayers.getScene().getWindow().hide();
          loader.setLocation(getClass().getResource("/arenaViews/LeagueOwnerManageUsersPage.fxml"));
          scene = new Scene(loader.load());
          stage.setScene(scene);
          stage.setResizable(false);
          stage.getIcons().add(new Image(getClass().getResourceAsStream("/images/arenaIcon.png")));
          stage.setTitle("Arena");
          stage.show();
          System.gc();
          }
@FXML
private void goToMangLeag(ActionEvent event) throws Exception {
    	leagueOwnerGoToMangLeagues.getScene().getWindow().hide();
        loader.setLocation(getClass().getResource("/arenaViews/LeagueOwnerLeagueManagementPage.fxml"));
        scene = new Scene(loader.load());
        stage.setScene(scene);
        stage.setResizable(false);
        stage.getIcons().add(new Image(getClass().getResourceAsStream("/images/arenaIcon.png")));
        stage.setTitle("Arena");
        stage.show();
        System.gc();
        }
private void setLoADTop() throws SQLException, IOException{
	Connection myConnection = DBHandler.getConnection();
    String loadImage = "default.jpg";
	String query = "SELECT topBannerName FROM arenadatabase.adstorage WHERE adID = 2";
	try
	{
		PreparedStatement preparedStatementOne = myConnection.prepareStatement(query);
		preparedStatementOne.executeQuery(query);
		rs = preparedStatementOne.executeQuery(query);
		rs.first();
		loadImage = rs.getString("topBannerName");
	}
	catch(SQLException e)
	{
		e.printStackTrace();
		System.out.println("ERROR @ Controller.setLoADTop.StepOne");
	}
	
	try {
		String i1 ="\""+loadImage+ "\"";
		String roleNames = "SELECT image_blob FROM arenadatabase.advertisment WHERE AdvertismentName ="+i1+"";
		PreparedStatement preparedStatement = myConnection.prepareStatement(roleNames);
		preparedStatement.executeQuery(roleNames);
		ResultSet rs = preparedStatement.executeQuery(roleNames);

		if (rs.next()) {
		    InputStream is= rs.getBinaryStream("image_blob");
		    OutputStream os=new FileOutputStream(new File("img.jpg"));
		    byte [] content= new byte[1024];
		    int size=0;

		        while ((size=is.read(content))!=-1){
		            os.write(content, 0, size);
		        }
		    os.close();
		    is.close();
		    javafx.scene.image.Image image1=new Image("file:img.jpg", loTopBannerImage.getFitWidth(), loTopBannerImage.getFitHeight(), true, true);
		    loTopBannerImage.setImage(image1);
		   // loTopBannerImage.setPreserveRatio(true);
		}
		else if(!rs.next()) {
		}
		else {}
	}
	catch(SQLException e) {
		e.printStackTrace();
		System.out.println("ERROR@ Controller.setLoADTop.StepTwo");
	}
}
private void setLoADBottom() throws SQLException, IOException{
Connection myConnection = DBHandler.getConnection();
String loadImage = "default.jpg";
String query = "SELECT bottomBannerName FROM arenadatabase.adstorage WHERE adID = 2";
try
{
	PreparedStatement preparedStatementOne = myConnection.prepareStatement(query);
	preparedStatementOne.executeQuery(query);
	rs = preparedStatementOne.executeQuery(query);
	rs.first();
	loadImage = rs.getString("bottomBannerName");
}
catch(SQLException e)
{
	e.printStackTrace();
	System.out.println("ERROR @ Controller.setLoADBottom.StepOne");
}

try {
	String i1 ="\""+loadImage+ "\"";
	String roleNames = "SELECT image_blob FROM arenadatabase.advertisment WHERE AdvertismentName ="+i1+"";
	PreparedStatement preparedStatement = myConnection.prepareStatement(roleNames);
	preparedStatement.executeQuery(roleNames);
	ResultSet rs = preparedStatement.executeQuery(roleNames);

	if (rs.next()) {
	    InputStream is= rs.getBinaryStream("image_blob");
	    OutputStream os=new FileOutputStream(new File("img.jpg"));
	    byte [] content= new byte[1024];
	    int size=0;

	        while ((size=is.read(content))!=-1){
	            os.write(content, 0, size);
	        }
	    os.close();
	    is.close();
	    javafx.scene.image.Image image1=new Image("file:img.jpg", loBottomBannerImage.getFitWidth(), loBottomBannerImage.getFitHeight(), true, true);
	    loBottomBannerImage.setImage(image1);
	}
	else if(!rs.next()) {
	}
	else {}
}
catch(SQLException e) {
	e.printStackTrace();
	System.out.println("ERROR@ Controller.setLoADBottom.StepTwo");
}
}
private void setLoADLeft() throws SQLException, IOException{
Connection myConnection = DBHandler.getConnection();
String loadImage = "default.jpg";
String query = "SELECT leftBannerName FROM arenadatabase.adstorage WHERE adID = 2";
try
{
	PreparedStatement preparedStatementOne = myConnection.prepareStatement(query);
	preparedStatementOne.executeQuery(query);
	rs = preparedStatementOne.executeQuery(query);
	rs.first();
	loadImage = rs.getString("leftBannerName");
}
catch(SQLException e)
{
	e.printStackTrace();
	System.out.println("ERROR @ Controller.setLoADLeft.StepOne");
}

try {
	String i1 ="\""+loadImage+ "\"";
	String roleNames = "SELECT image_blob FROM arenadatabase.advertisment WHERE AdvertismentName ="+i1+"";
	PreparedStatement preparedStatement = myConnection.prepareStatement(roleNames);
	preparedStatement.executeQuery(roleNames);
	ResultSet rs = preparedStatement.executeQuery(roleNames);

	if (rs.next()) {
	    InputStream is= rs.getBinaryStream("image_blob");
	    OutputStream os=new FileOutputStream(new File("img.jpg"));
	    byte [] content= new byte[1024];
	    int size=0;

	        while ((size=is.read(content))!=-1){
	            os.write(content, 0, size);
	        }
	    os.close();
	    is.close();
	    javafx.scene.image.Image image1=new Image("file:img.jpg", loLeftBannerImage.getFitWidth(), loLeftBannerImage.getFitHeight(), true, true);
	    loLeftBannerImage.setImage(image1);
	}
	else if(!rs.next()) {
	}
	else {}
}
catch(SQLException e) {
	e.printStackTrace();
	System.out.println("ERROR@ Controller.setLoADLeft.StepTwo");
}
}
private void setLoADRight() throws SQLException, IOException{
Connection myConnection = DBHandler.getConnection();
String loadImage = "default.jpg";
String query = "SELECT rightBannerName FROM arenadatabase.adstorage WHERE adID = 2";
try
{
	PreparedStatement preparedStatementOne = myConnection.prepareStatement(query);
	preparedStatementOne.executeQuery(query);
	rs = preparedStatementOne.executeQuery(query);
	rs.first();
	loadImage = rs.getString("rightBannerName");
}
catch(SQLException e)
{
	e.printStackTrace();
	System.out.println("ERROR @ Controller.setLoADRight.StepOne");
}

try {
	String i1 ="\""+loadImage+ "\"";
	String roleNames = "SELECT image_blob FROM arenadatabase.advertisment WHERE AdvertismentName ="+i1+"";
	PreparedStatement preparedStatement = myConnection.prepareStatement(roleNames);
	preparedStatement.executeQuery(roleNames);
	ResultSet rs = preparedStatement.executeQuery(roleNames);

	if (rs.next()) {
	    InputStream is= rs.getBinaryStream("image_blob");
	    OutputStream os=new FileOutputStream(new File("img.jpg"));
	    byte [] content= new byte[1024];
	    int size=0;

	        while ((size=is.read(content))!=-1){
	            os.write(content, 0, size);
	        }
	    os.close();
	    is.close();
	    javafx.scene.image.Image image1=new Image("file:img.jpg", loRightBannerImage.getFitWidth(), loRightBannerImage.getFitHeight(), true, true);
	    loRightBannerImage.setImage(image1);
	}
	else if(!rs.next()) {
	}
	else {}
}
catch(SQLException e) {
	e.printStackTrace();
	System.out.println("ERROR@ Controller.setSpecADRight.StepTwo");
}
}
private void setLoADBG() throws SQLException, IOException{
Connection myConnection = DBHandler.getConnection();
String loadImage = "domina1.jpg";
String query = "SELECT bgBannerName FROM arenadatabase.adstorage WHERE adID = 2";
try
{
	PreparedStatement preparedStatementOne = myConnection.prepareStatement(query);
	preparedStatementOne.executeQuery(query);
	rs = preparedStatementOne.executeQuery(query);
	rs.first();
	loadImage = rs.getString("bgBannerName");
}
catch(SQLException e)
{
	e.printStackTrace();
	System.out.println("ERROR @ Controller.setLoADBG.StepOne");
}

try {
	String i1 ="\""+loadImage+ "\"";
	String roleNames = "SELECT image_blob FROM arenadatabase.advertisment WHERE AdvertismentName ="+i1+"";
	PreparedStatement preparedStatement = myConnection.prepareStatement(roleNames);
	preparedStatement.executeQuery(roleNames);
	ResultSet rs = preparedStatement.executeQuery(roleNames);

	if (rs.next()) {
	    InputStream is= rs.getBinaryStream("image_blob");
	    OutputStream os=new FileOutputStream(new File("img.jpg"));
	    byte [] content= new byte[1024];
	    int size=0;

	        while ((size=is.read(content))!=-1){
	            os.write(content, 0, size);
	        }
	    os.close();
	    is.close();
	    javafx.scene.image.Image image1=new Image("file:img.jpg", loBGBannerImage.getFitWidth(), loBGBannerImage.getFitHeight(), true, true);
	    loBGBannerImage.setImage(image1);
	}
	else if(!rs.next()) {
	}
	else {}
}
catch(SQLException e) {
	e.printStackTrace();
	System.out.println("ERROR@ Controller.setSpecADBG.StepTwo");
}
}
}
