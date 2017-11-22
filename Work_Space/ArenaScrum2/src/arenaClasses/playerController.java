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

public class playerController extends Main  implements Initializable {

@FXML
private Label closeIcon;
@FXML
private JFXButton signUpPageGoBackButton;
@FXML
private JFXButton playerTeamAppButton;
@FXML
private JFXButton playerTeamJoinLeague;
@FXML
private JFXButton playerTeamMangLeague;
@FXML
private ImageView plBGBannerImage;
@FXML
private ImageView plLeftBannerImage;
@FXML
private ImageView plTopBannerImage;
@FXML
private ImageView plRightBannerImage;
@FXML
private ImageView plBottomBannerImage;
@FXML
private Label playerNameLabel;
	
Scene scene;
Stage stage = new Stage();
ResultSet rs;

	
@Override
public void initialize(URL location, ResourceBundle resources)
		{
			try{
				setPlADTop();
				setPlADBottom();
				setPlADLeft();
				setPlADRight();
				setPlADBG();
				setUserName();
				}
			catch(Exception e)
			{
				e.printStackTrace();
				System.out.println("Error@ playerController.initialize");
			}
		} 
@FXML
private void closeApplication(MouseEvent event)
    {
	    System.gc();
        System.exit(0);
    }
private void setUserName() {
	playerNameLabel.setText(Controller.currName);
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
private void goToTeamsApp(ActionEvent event) throws Exception {
    	playerTeamAppButton.getScene().getWindow().hide();
        loader.setLocation(getClass().getResource("/arenaViews/teamApp.fxml"));
        scene = new Scene(loader.load());
        stage.setScene(scene);
        stage.setResizable(false);
        stage.getIcons().add(new Image(getClass().getResourceAsStream("/images/arenaIcon.png")));
        stage.setTitle("Arena");
        stage.show();
        System.gc();
        }
@FXML
private void goToJoinLeag(ActionEvent event) throws Exception {
    	playerTeamJoinLeague.getScene().getWindow().hide();
        loader.setLocation(getClass().getResource("/arenaViews/PlayerJoinLeaguePage.fxml"));
        scene = new Scene(loader.load());
        stage.setScene(scene);
        stage.setResizable(false);
        stage.getIcons().add(new Image(getClass().getResourceAsStream("/images/arenaIcon.png")));
        stage.setTitle("Arena");
        stage.show();
        System.gc();
        }
@FXML
private void goToPlayerMangLeag(ActionEvent event) throws Exception {
    	playerTeamMangLeague.getScene().getWindow().hide();
        loader.setLocation(getClass().getResource("/arenaViews/PlayerCurrentLeaguePage.fxml"));
        scene = new Scene(loader.load());
        stage.setScene(scene);
        stage.setResizable(false);
        stage.getIcons().add(new Image(getClass().getResourceAsStream("/images/arenaIcon.png")));
        stage.setTitle("Arena");
        stage.show();
        System.gc();
        }
private void setPlADTop() throws SQLException, IOException{
	Connection myConnection = DBHandler.getConnection();
    String loadImage = "default.jpg";
	String query = "SELECT topBannerName FROM arenadatabase.adstorage WHERE adID = 1";
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
		System.out.println("ERROR @ playerController.setPlADTop.StepOne");
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
		    javafx.scene.image.Image image1=new Image("file:img.jpg", plTopBannerImage.getFitWidth(), plTopBannerImage.getFitHeight(), true, true);
		    plTopBannerImage.setImage(image1);
		   // plTopBannerImage.setPreserveRatio(true);
		}
		else if(!rs.next()) {
		}
		else {}
	}
	catch(SQLException e) {
		e.printStackTrace();
		System.out.println("ERROR@ playerController.setPlADTop.StepTwo");
	}
}
private void setPlADBottom() throws SQLException, IOException{
Connection myConnection = DBHandler.getConnection();
String loadImage = "default.jpg";
String query = "SELECT bottomBannerName FROM arenadatabase.adstorage WHERE adID = 1";
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
	System.out.println("ERROR @ playerController.setPlADBottom.StepOne");
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
	    javafx.scene.image.Image image1=new Image("file:img.jpg", plBottomBannerImage.getFitWidth(), plBottomBannerImage.getFitHeight(), true, true);
	    plBottomBannerImage.setImage(image1);
	   //plBottomBannerImage.setPreserveRatio(true);
	}
	else if(!rs.next()) {
	}
	else {}
}
catch(SQLException e) {
	e.printStackTrace();
	System.out.println("ERROR@ playerController.setPlADBottom.StepTwo");
}
}
private void setPlADLeft() throws SQLException, IOException{
Connection myConnection = DBHandler.getConnection();
String loadImage = "default.jpg";
String query = "SELECT leftBannerName FROM arenadatabase.adstorage WHERE adID = 1";
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
	System.out.println("ERROR @ playerController.setPlADLeft.StepOne");
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
	    javafx.scene.image.Image image1=new Image("file:img.jpg", plLeftBannerImage.getFitWidth(), plLeftBannerImage.getFitHeight(), true, true);
	    plLeftBannerImage.setImage(image1);
	   //plLeftBannerImage.setPreserveRatio(true);
	}
	else if(!rs.next()) {
	}
	else {}
}
catch(SQLException e) {
	e.printStackTrace();
	System.out.println("ERROR@ playerController.setPlADLeft.StepTwo");
}
}
private void setPlADRight() throws SQLException, IOException{
Connection myConnection = DBHandler.getConnection();
String loadImage = "default.jpg";
String query = "SELECT rightBannerName FROM arenadatabase.adstorage WHERE adID = 1";
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
	System.out.println("ERROR @ playerController.setPlADRight.StepOne");
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
	    javafx.scene.image.Image image1=new Image("file:img.jpg", plRightBannerImage.getFitWidth(), plRightBannerImage.getFitHeight(), true, true);
	    plRightBannerImage.setImage(image1);
	   //plRightBannerImage.setPreserveRatio(true);
	}
	else if(!rs.next()) {
	}
	else {}
}
catch(SQLException e) {
	e.printStackTrace();
	System.out.println("ERROR@ playerController.setPlADRight.StepTwo");
}
}
private void setPlADBG() throws SQLException, IOException{
Connection myConnection = DBHandler.getConnection();
String loadImage = "domina1.jpg";
String query = "SELECT bgBannerName FROM arenadatabase.adstorage WHERE adID = 1";
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
	System.out.println("ERROR @ playerController.setPlADBG.StepOne");
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
	    javafx.scene.image.Image image1=new Image("file:img.jpg", plBGBannerImage.getFitWidth(), plBGBannerImage.getFitHeight(), true, true);
	    plBGBannerImage.setImage(image1);
	   //plBGBannerImage.setPreserveRatio(true);
	}
	else if(!rs.next()) {
	}
	else {}
}
catch(SQLException e) {
	e.printStackTrace();
	System.out.println("ERROR@ playerController.setPlADBG.StepTwo");
}
}


}
