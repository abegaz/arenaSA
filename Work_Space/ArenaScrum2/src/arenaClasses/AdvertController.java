package arenaClasses;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javafx.fxml.Initializable;
import java.sql.SQLException;
import java.util.ResourceBundle;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXTextField;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import arenaClasses.DBHandler;

public class AdvertController extends Main implements Initializable{
 @FXML
private JFXButton signUpPageGoBackButton;
@FXML
private Label closeIcon;
@FXML
private Label advertAmountDue;
@FXML
private JFXTextField adPayAmountField;
@FXML
private JFXButton advertPayBalance;
@FXML
private JFXButton adImageUpload;
@FXML
private JFXButton adImageSelect;
@FXML
private Label adImageUploadSuccessMessage;
@FXML
private Label adImageUploadFailMessage;
@FXML
private JFXButton adImageRemove;
@FXML
private JFXButton adImageSet;
@FXML
private Label advertTopAdPrice;
@FXML
private Label advertLeftAdPrice;
@FXML
private Label advertRightAdPrice;
@FXML
private Label advertBottomAdPrice;
@FXML
private Label advertBackgroundAdPrice;
@FXML
private Label adUploadTempName;
@FXML
private JFXComboBox<String> adImageRemoveChoiceBox;
@FXML
private JFXComboBox<String> adRoleChoiceBox;
@FXML
private JFXComboBox<String> adImageChoiceBox;
@FXML
private JFXComboBox<String> adSchemeChoiceBox;
@FXML
private ImageView adPreviewImage;
@FXML
private Label adRemoveSuccessOne;
@FXML
private Label adRemoveSuccessTwo;
@FXML
private Label adRemoveFailOne;
@FXML
private Label adRemoveFailTwo;
@FXML
private Label adImageSizeError;
@FXML
private Label adSETSuccess;
@FXML
private Label adSETFail;

Scene scene;
Stage stage = new Stage();
FileChooser fileChooser = new FileChooser();
FileChooser.ExtensionFilter extFilterJPG = new FileChooser.ExtensionFilter("JPG files (*.jpg)", "*.JPG");
FileChooser.ExtensionFilter extFilterJPEG = new FileChooser.ExtensionFilter("JPEG files (*.jpeg)", "*.JPEG");
static File selectedFile;

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
	System.gc();
	}
@FXML
private void closeApplication(MouseEvent event)
{
	System.gc();
	System.exit(0);
	}
@FXML
private void selectImageToUpload(ActionEvent event) throws IOException {
	fileChooser.getExtensionFilters().addAll(extFilterJPG,extFilterJPEG);
	selectedFile = fileChooser.showOpenDialog(null);
	if (selectedFile != null)
	{
	adUploadTempName.setTextFill(Color.web("#fcff4c"));	
	adUploadTempName.setText("File selected: " + selectedFile.getName());
	adUploadTempName.setVisible(true);
	}
	else 
	{
	adUploadTempName.setTextFill(Color.web("#dd1506"));
	adUploadTempName.setText("File selection cancelled.");
	adUploadTempName.setVisible(true);
	}
}
@FXML
private void uploadImageToDB(ActionEvent event) throws SQLException, IOException 
{
	Connection myConnection = DBHandler.getConnection();
	String i1 ="\""+ selectedFile.getName()+ "\"";
	String i2 = selectedFile.getPath();
	i2 = i2.replace("\\", "/");
	String imageInsert = "INSERT INTO advertisment (users_userID, AdvertismentName, image_blob)"
			+ " VALUES("+Controller.currUserID+","+i1+",LOAD_FILE('"+i2+"'))";
	// 1MB Limit
	long maxFileSize=1000000;
	FileInputStream fileinputstream = new FileInputStream(selectedFile);
	long fileSize = fileinputstream.getChannel().size();
	fileinputstream.close();
	if(fileSize <= maxFileSize) {
	try
	{
		PreparedStatement preparedStatement = myConnection.prepareStatement(imageInsert);
		preparedStatement.executeUpdate(imageInsert);
		adImageUploadSuccessMessage.setVisible(true);
		adImageUploadFailMessage.setVisible(false);
		adRemoveSuccessOne.setVisible(false);
		adRemoveSuccessTwo.setVisible(false);
		adRemoveFailOne.setVisible(false);
		adRemoveFailTwo.setVisible(false);
		adUploadTempName.setVisible(false);
		adImageSizeError.setVisible(false);
		populateImageChoiceComboBox();
		populateRemoveImageChoiceComboBox();
	}
	catch(SQLException e)
	{
		adImageUploadSuccessMessage.setVisible(false);
		adImageUploadFailMessage.setVisible(true);
		adRemoveSuccessOne.setVisible(false);
		adRemoveSuccessTwo.setVisible(false);
		adRemoveFailOne.setVisible(false);
		adRemoveFailTwo.setVisible(false);
		e.printStackTrace();
		System.out.println("ERROR @ AdvertController.uploadImageToDB");
	}
	}
	else if(fileSize > maxFileSize) {
		adImageSizeError.setVisible(true);
		adImageUploadSuccessMessage.setVisible(false);
		adImageUploadFailMessage.setVisible(true);
		adRemoveSuccessOne.setVisible(false);
		adRemoveSuccessTwo.setVisible(false);
		adRemoveFailOne.setVisible(false);
		adRemoveFailTwo.setVisible(false);
		adUploadTempName.setVisible(true);
		adImageSizeError.setVisible(true);
	}
}
@FXML
private void removeImageFromDB(ActionEvent event) throws SQLException, FileNotFoundException 
{
	Connection myConnection = DBHandler.getConnection();
	String i1 ="\""+ adImageRemoveChoiceBox.getValue()+ "\"";
	String imageInsert = "DELETE FROM arenadatabase.advertisment WHERE AdvertismentName ="+i1+"";
	try
	{
		PreparedStatement preparedStatement = myConnection.prepareStatement(imageInsert);
		preparedStatement.executeUpdate(imageInsert);
		adRemoveSuccessOne.setVisible(true);
		adRemoveSuccessTwo.setVisible(true);
		adRemoveFailOne.setVisible(false);
		adRemoveFailTwo.setVisible(false);
		adImageUploadSuccessMessage.setVisible(false);
		adImageUploadFailMessage.setVisible(false);
		adImageSizeError.setVisible(false);
		populateImageChoiceComboBox();
		populateRemoveImageChoiceComboBox();
		adUploadTempName.setVisible(false);
	}
	catch(SQLException e)
	{
		adRemoveSuccessOne.setVisible(false);
		adRemoveSuccessTwo.setVisible(false);
		adImageSizeError.setVisible(false);
		adRemoveFailOne.setVisible(true);
		adRemoveFailTwo.setVisible(true);
		adImageUploadSuccessMessage.setVisible(false);
		adImageUploadFailMessage.setVisible(false);
		adUploadTempName.setVisible(false);
		e.printStackTrace();
		System.out.println("ERROR @ AdvertController.removeImageFromDB");
	}
	
}
@Override
public void initialize(URL location, ResourceBundle resources)
{
	try{
		populateRoleComboBox();
		populateSchemeComboBox();
		populateImageChoiceComboBox();
		populateRemoveImageChoiceComboBox();
		}
	catch(Exception e)
	{
		e.printStackTrace();
		System.out.println("Error@ AdvertController.initialize");
	}
}
@FXML
private void setButtonFunctionality(ActionEvent event) throws SQLException{
	String adRoleGoesTo = adRoleChoiceBox.getValue();
	String schemeChoice = adSchemeChoiceBox.getValue();
	String imageChoiceName = adImageChoiceBox.getValue();
	String imageName = "\""+imageChoiceName+"\"";
	String update="";
	System.out.println("Image Choice: "+imageChoiceName);
	Connection myConnection = DBHandler.getConnection();
	// 1 Player
	// 2 LeagueOwner
	// 3 Spectator
	if(adRoleGoesTo.equals("Player") && schemeChoice.equals("Top Banner")) {
		update = "UPDATE adstorage SET topBannerName ="+imageName+" WHERE adID =1";
	}
	else if(adRoleGoesTo.equals("Player") && schemeChoice.equals("Left Side Banner")) {
		update = "UPDATE adstorage SET leftBannerName ="+imageName+" WHERE adID =1";
	}
	else if(adRoleGoesTo.equals("Player") && schemeChoice.equals("Right Side Banner")) {
		update = "UPDATE adstorage SET rightBannerName ="+imageName+" WHERE adID =1";
	}
	else if(adRoleGoesTo.equals("Player") && schemeChoice.equals("Bottom Banner")) {
		update = "UPDATE adstorage SET bottomBannerName ="+imageName+" WHERE adID =1";
	}
	else if(adRoleGoesTo.equals("Player") && schemeChoice.equals("Background Banner")) {
		update = "UPDATE adstorage SET bgBannerName ="+imageName+" WHERE adID =1";
	}
	else {}
	if(adRoleGoesTo.equals("LeagueOwner") && schemeChoice.equals("Top Banner")) {
		update = "UPDATE adstorage SET topBannerName ="+imageName+" WHERE adID =2";
	}
	
	else if(adRoleGoesTo.equals("LeagueOwner") && schemeChoice.equals("Left Side Banner")) {
		update = "UPDATE adstorage SET leftBannerName ="+imageName+" WHERE adID =2";
	}
	//loRB
	else if(adRoleGoesTo.equals("LeagueOwner") && schemeChoice.equals("Right Side Banner")) {
		update = "UPDATE adstorage SET rightBannerName ="+imageName+" WHERE adID =2";
	}
	//loBB
	else if(adRoleGoesTo.equals("LeagueOwner") && schemeChoice.equals("Bottom Banner")) {
		update = "UPDATE adstorage SET bottomBannerName ="+imageName+" WHERE adID =2";
	}
	//loBgB
	else if(adRoleGoesTo.equals("LeagueOwner") && schemeChoice.equals("Background Banner")) {
		update = "UPDATE adstorage SET bgBannerName ="+imageName+" WHERE adID =2";
	}
	else {}
	if(adRoleGoesTo.equals("Spectator") && schemeChoice.equals("Top Banner")) {
		update = "UPDATE adstorage SET topBannerName ="+imageName+" WHERE adID =3";
	}
	else if(adRoleGoesTo.equals("Spectator") && schemeChoice.equals("Left Side Banner")) {
		update = "UPDATE adstorage SET leftBannerName ="+imageName+" WHERE adID =3";
	}
	else if(adRoleGoesTo.equals("Spectator") && schemeChoice.equals("Right Side Banner")) {
		update = "UPDATE adstorage SET rightBannerName ="+imageName+" WHERE adID =3";
	}
	else if(adRoleGoesTo.equals("Spectator") && schemeChoice.equals("Bottom Banner")) {
		update = "UPDATE adstorage SET bottomBannerName ="+imageName+" WHERE adID =3";
	}
	else if(adRoleGoesTo.equals("Spectator") && schemeChoice.equals("Background Banner")) {
		update = "UPDATE adstorage SET bgBannerName ="+imageName+" WHERE adID =3";
	}
	else {}
	try {
		PreparedStatement preparedStatementOne = myConnection.prepareStatement(update);
		preparedStatementOne.executeUpdate(update);
		adSETSuccess.setVisible(true);
		adSETFail.setVisible(false);
	}
	catch(SQLException e) {
		System.out.println("ERROR@AdvertController.setButtonFunctionality");
		e.printStackTrace();
		adSETSuccess.setVisible(false);
		adSETFail.setVisible(true);
	}

}
private void populateRoleComboBox() throws SQLException {
	Connection connection = DBHandler.getConnection();

	String roleNames = "SELECT userRoleTypeName FROM arenadatabase.userroletype WHERE userRoleTypeID = 1 OR userRoleTypeID = 3 OR userRoleTypeID = 4";
	ObservableList<String> roleList = FXCollections.observableArrayList();
	try
	{
		ResultSet rs = connection.createStatement().executeQuery(roleNames);
		while (rs.next())
		{
			roleList.add(rs.getString("userRoleTypeName"));
		}
		adRoleChoiceBox.setItems(roleList);
	}
	catch(SQLException e)
	{
		e.printStackTrace();
		System.out.println("ERROR @ AdvertController.populateRoleComboBox");
	}
}
private void populateImageChoiceComboBox() throws SQLException {
	Connection connection = DBHandler.getConnection();
	int adUserID = Controller.currUserID;
	String roleNames = "SELECT AdvertismentName FROM arenadatabase.advertisment WHERE users_userID="+adUserID;
	ObservableList<String> roleList = FXCollections.observableArrayList();
	try
	{
		ResultSet rs = connection.createStatement().executeQuery(roleNames);
		while (rs.next())
		{
			roleList.add(rs.getString("AdvertismentName"));
		}
		adImageChoiceBox.setItems(roleList);
	}
	catch(SQLException e)
	{
		e.printStackTrace();
		System.out.println("ERROR @ AdvertController.populateImageChoiceComboBox");
	}
}
private void populateSchemeComboBox() throws SQLException {
	Connection connection = DBHandler.getConnection();
	String roleNames = "SELECT AdSchemeName FROM arenadatabase.advertismentscheme";
	ObservableList<String> roleList = FXCollections.observableArrayList();
	try
	{
		ResultSet rs = connection.createStatement().executeQuery(roleNames);
		while (rs.next())
		{
			roleList.add(rs.getString("AdSchemeName"));
		}
		adSchemeChoiceBox.setItems(roleList);
	}
	catch(SQLException e)
	{
		e.printStackTrace();
		System.out.println("ERROR @ AdvertController.populateSchemeComboBox");
	}
}
private void populateRemoveImageChoiceComboBox() throws SQLException {
	Connection connection = DBHandler.getConnection();
	int adUserID = Controller.currUserID;
	String roleNames = "SELECT AdvertismentName FROM arenadatabase.advertisment WHERE users_userID="+adUserID;
	ObservableList<String> roleList = FXCollections.observableArrayList();
	try
	{
		ResultSet rs = connection.createStatement().executeQuery(roleNames);
		while (rs.next())
		{
			roleList.add(rs.getString("AdvertismentName"));
		}
		adImageRemoveChoiceBox.setItems(roleList);
	}
	catch(SQLException e)
	{
		e.printStackTrace();
		System.out.println("ERROR @ AdvertController.populateRemoveImageChoiceComboBox");
	}
}
private void setPreviewImage() throws SQLException, IOException{
	try {
		Connection connection = DBHandler.getConnection();
		String i1 ="\""+ adImageChoiceBox.getValue()+ "\"";
		String roleNames = "SELECT image_blob FROM arenadatabase.advertisment WHERE AdvertismentName ="+i1+"";
		PreparedStatement preparedStatement = connection.prepareStatement(roleNames);
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
		    javafx.scene.image.Image image1=new Image("file:img.jpg", adPreviewImage.getFitWidth(), adPreviewImage.getFitHeight(), true, true);
		    adPreviewImage.setImage(image1);
		    adPreviewImage.setPreserveRatio(true);
		}
	}
	catch(SQLException e) {
		e.printStackTrace();
		System.out.println("ERROR@ AdvertController.setPreviewImage");
	}
}
@FXML
private void reallySetPrieviewImage(MouseEvent event) throws SQLException, IOException {
	setPreviewImage();
	adSETSuccess.setVisible(false);
	adSETFail.setVisible(false);
	adRemoveSuccessOne.setVisible(false);
	adRemoveSuccessTwo.setVisible(false);
	adRemoveFailOne.setVisible(false);
	adRemoveFailTwo.setVisible(false);
	adImageUploadSuccessMessage.setVisible(false);
	adImageUploadFailMessage.setVisible(false);
	adUploadTempName.setVisible(false);
	adImageSizeError.setVisible(false);
}

}
