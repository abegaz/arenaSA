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
@FXML
private Label balSuccess;
@FXML
private Label balError;
@FXML
private Label otherSetErr;

Scene scene;
Stage stage = new Stage();
FileChooser fileChooser = new FileChooser();
FileChooser.ExtensionFilter extFilterJPG = new FileChooser.ExtensionFilter("JPG files (*.jpg)", "*.JPG");
FileChooser.ExtensionFilter extFilterJPEG = new FileChooser.ExtensionFilter("JPEG files (*.jpeg)", "*.JPEG");
static File selectedFile;
String maxBal;


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

		//kyle
		getAdPrices();
		getAdBal();
		maxBal = getMaxBal();

		}
	catch(Exception e)
	{
		e.printStackTrace();
		System.out.println("Error@ AdvertController.initialize");
	}
}
@FXML
private void setButtonFunctionality(ActionEvent event) throws SQLException{

	//hide 'otherSetErr'
	otherSetErr.setVisible(false);


	String adRoleGoesTo = adRoleChoiceBox.getValue();
	String schemeChoice = adSchemeChoiceBox.getValue();
	String imageChoiceName = adImageChoiceBox.getValue();
	String imageName = "\""+imageChoiceName+"\"";
	String update1="";
	Connection myConnection = DBHandler.getConnection();
	// 1 Player
	// 2 LeagueOwner
	// 3 Spectator
	/*
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
	*/

	//tidy
	String adID = "";
	String adBanner = "";
	String adCost = "";
	String update = "UPDATE adstorage SET %s = %s WHERE adID = %s";
	switch(adRoleGoesTo){
		case "Player" : adID = "1";break;
		case "LeagueOwner" : adID = "2";break;
		case "Spectator" : adID =" 3";break;
	}
	switch(schemeChoice){
		case "Top Banner" : adBanner = "topBannerName";
							adCost = advertTopAdPrice.getText();
							break;
		case "Left Side Banner" : adBanner = "leftBannerName";
							adCost = advertLeftAdPrice.getText();
							break;
		case "Right Side Banner" : adBanner = "rightBannerName";
							adCost = advertRightAdPrice.getText();
							break;
		case "Bottom Banner" : adBanner = "bottomBannerName";
							adCost = advertBottomAdPrice.getText();
							break;
		case "Background Banner" : adBanner = "bgBannerName";
							adCost = advertBackgroundAdPrice.getText();
							break;
	}
	update = String.format(update, adBanner, imageName, adID);
	if(!(Integer.parseInt(advertAmountDue.getText()) + Integer.parseInt(adCost) > Integer.parseInt(maxBal)) ) {
		try {
			PreparedStatement preparedStatementOne = myConnection.prepareStatement(update);
			preparedStatementOne.executeUpdate(update);
			adSETSuccess.setVisible(true);
			adSETFail.setVisible(false);

			//balance/ad price stuff
			addBal(adCost);
			incrementSchemePrice(schemeChoice, adCost);
			getAdBal();
			getAdPrices();
		} catch (SQLException e) {

			e.printStackTrace();
			adSETSuccess.setVisible(false);
			adSETFail.setVisible(true);
		}
	}else{
		showOtherSetError("Buying this ad space would put you over the max allowed balance of $" + maxBal);
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



	//kyle
	private void getAdPrices() throws SQLException{
		Connection connection = DBHandler.getConnection();
		int adUserID = Controller.currUserID;
		String roleNames = "SELECT * FROM arenadatabase.advertismentscheme";

		try
		{
			ResultSet rs = connection.createStatement().executeQuery(roleNames);
			while (rs.next())
			{


				switch (rs.getInt("AdvertismentSchemeId")){
					case 1: advertTopAdPrice.setText(rs.getString("AdPrice"));
					case 2: advertLeftAdPrice.setText(rs.getString("AdPrice"));
					case 3: advertRightAdPrice.setText(rs.getString("AdPrice"));
					case 4: advertBottomAdPrice.setText(rs.getString("AdPrice"));
					case 5: advertBackgroundAdPrice.setText(rs.getString("AdPrice"));
				}


			}

		}
		catch(SQLException e)
		{
			e.printStackTrace();

		}


	}
	private void getAdBal() throws SQLException{
		Connection connection = DBHandler.getConnection();
		int adUserID = Controller.currUserID;
		String roleNames = "SELECT balance FROM arenadatabase.adbalances WHERE userID = " + adUserID;

		try
		{
			ResultSet rs = connection.createStatement().executeQuery(roleNames);
			if(!rs.next()){
				//first time balance
				String insert ="INSERT INTO adbalances (userID) VALUES ("+ adUserID +");";
				try {
					PreparedStatement preparedStatementOne = connection.prepareStatement(insert);
					preparedStatementOne.executeUpdate(insert);


				} catch (SQLException e) {
					//showError(e.getLocalizedMessage());
					e.printStackTrace();
				}
				advertAmountDue.setText("0");
			}else{


				 advertAmountDue.setText(rs.getString("balance"));

				}

		}
		catch(SQLException e)
		{
			e.printStackTrace();

		}


	}
	@FXML
	private void payAdBal(ActionEvent ae) throws SQLException {
		hideMsgs();
		if (Integer.parseInt(adPayAmountField.getText()) <= Integer.parseInt(advertAmountDue.getText()) && Integer.parseInt(adPayAmountField.getText()) > 0
		) {

			int newBal = Integer.parseInt(advertAmountDue.getText()) - Integer.parseInt(adPayAmountField.getText());
			Connection connection = DBHandler.getConnection();
			int adUserID = Controller.currUserID;
			String update = "UPDATE adbalances SET balance = " + newBal + " WHERE userID = " + adUserID;

			try {
				PreparedStatement preparedStatementOne = connection.prepareStatement(update);
				preparedStatementOne.executeUpdate(update);


			} catch (SQLException e) {
				//showError(e.getLocalizedMessage());
				showBalError(e.getLocalizedMessage());
			}
			showBalMsg("Thank you for your payment of $" + adPayAmountField.getText());
			adPayAmountField.setText("");
			advertAmountDue.setText(Integer.toString(newBal));



		}else{
			if(Integer.parseInt(adPayAmountField.getText()) == 0){
				showBalError("Enter an amount");
			}else{
				adPayAmountField.setText(advertAmountDue.getText());
				showBalError("Amount entered greater than total amount due. Amount has been adjusted, press PAY if you wish to proceed");
			}
		}
	}
	private void showBalMsg(String s){
		balSuccess.setText(s);
		if(!balSuccess.isVisible())
			balSuccess.setVisible(true);
	}
	private void showBalError(String e){
		balError.setText(e);
		if(!balError.isVisible())
			balError.setVisible(true);
	}
	private void showOtherSetError(String e){
		otherSetErr.setText(e);
		if(!otherSetErr.isVisible())
			otherSetErr.setVisible(true);
	}
	private void hideMsgs(){
		balError.setVisible(false);
		balSuccess.setVisible(false);
	}
	private void addBal(String cost) throws SQLException{


		int newBal = Integer.parseInt(advertAmountDue.getText()) + Integer.parseInt(cost);
		Connection connection = DBHandler.getConnection();
		int adUserID = Controller.currUserID;
		String update = "UPDATE adbalances SET balance = " + newBal + " WHERE userID = " + adUserID;

		try {
			PreparedStatement preparedStatementOne = connection.prepareStatement(update);
			preparedStatementOne.executeUpdate(update);


		} catch (SQLException e) {
			//showError(e.getLocalizedMessage());
			showBalError(e.getLocalizedMessage());
		}

	}
	private void incrementSchemePrice(String scheme, String prevCost) throws SQLException{
		int schemeID;
		switch(scheme){
			case "Top Banner" : schemeID = 1;
				break;
			case "Left Side Banner" : schemeID = 2;

				break;
			case "Right Side Banner" : schemeID = 3;
				break;
			case "Bottom Banner" : schemeID = 4;
				break;
			case "Background Banner" : schemeID = 5;
				break;
			default: schemeID = -1;break;
		}


		Connection connection = DBHandler.getConnection();
		int newCost = Integer.parseInt(prevCost) + 1;
		String update = String.format("UPDATE advertismentscheme SET AdPrice = %s WHERE AdvertismentSchemeID = %s",newCost, schemeID);

		try {
			PreparedStatement preparedStatementOne = connection.prepareStatement(update);
			preparedStatementOne.executeUpdate(update);


		} catch (SQLException e) {

			e.printStackTrace();
		}



	}
	private String getMaxBal()throws SQLException{
		Connection connection = DBHandler.getConnection();
		int adUserID = Controller.currUserID;
		String roleNames = "SELECT amount FROM arenadatabase.admaxbal WHERE id = 1";

		try
		{
			ResultSet rs = connection.createStatement().executeQuery(roleNames);
			while(rs.next())
				return rs.getString("amount");

		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
		return "-1";
	}

}
