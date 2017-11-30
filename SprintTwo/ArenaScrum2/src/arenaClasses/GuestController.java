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
import com.jfoenix.controls.JFXListView;
import javafx.fxml.Initializable;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;




public class GuestController extends Main  implements Initializable {
	
@FXML
private ImageView specTopBannerImage;
@FXML
private ImageView specBottomBannerImage;
@FXML
private ImageView specRightBannerImage;
@FXML
private ImageView specLeftBannerImage;
@FXML
private ImageView specBGBannerImage;
@FXML
private JFXButton signUpPageGoBackButton;
@FXML
private Label closeIcon;
@FXML
private JFXButton spectApply;
@FXML
private JFXButton CurrentMatchesSpecButton;
@FXML
private Label playerNameLabel;
@FXML
private JFXListView<String> arenaList;
@FXML
private JFXListView<String> leagList;
@FXML
private JFXListView<String> tournList;
@FXML
private JFXListView<String> teamList;
@FXML
private JFXListView<String> playerList;
@FXML
private JFXButton PastMatchesSpecButton;
@FXML
private JFXButton TeamListButton;
@FXML
private JFXButton PlayerListButton;

Scene scene;
Stage stage = new Stage();
ResultSet rs;



@Override
public void initialize(URL location, ResourceBundle resources)
	{
		try{
			setSpecADTop();
			setSpecADBottom();
			setSpecADLeft();
			setSpecADRight();
			setSpecADBG();
			loadArenasFromDatabase();
			loadLeagueFromDatabase(); 
			loadTournFromDatabase();
			loadTeamFromDatabase();
			loadPlayersFromDatabase();

			}
		catch(Exception e)
		{
			e.printStackTrace();
			System.out.println("Error@ spectController.initialize");
		}
	}

private void setSpecADTop() throws SQLException, IOException{
		Connection myConnection = DBHandler.getConnection();
	    String loadImage = "default.jpg";
		String query = "SELECT topBannerName FROM arenadatabase.adstorage WHERE adID = 3";
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
			System.out.println("ERROR @ Controller.setSpecADTop.StepOne");
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
			    javafx.scene.image.Image image1=new Image("file:img.jpg", specTopBannerImage.getFitWidth(), specTopBannerImage.getFitHeight(), true, true);
			    specTopBannerImage.setImage(image1);
			   // specTopBannerImage.setPreserveRatio(true);
			}
			else if(!rs.next()) {
			}
			else {}
		}
		catch(SQLException e) {
			e.printStackTrace();
			System.out.println("ERROR@ Controller.setSpecADTop.StepTwo");
		}
	}
private void setSpecADBottom() throws SQLException, IOException{
	Connection myConnection = DBHandler.getConnection();
    String loadImage = "default.jpg";
	String query = "SELECT bottomBannerName FROM arenadatabase.adstorage WHERE adID = 3";
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
		System.out.println("ERROR @ Controller.setSpecADBottom.StepOne");
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
		    javafx.scene.image.Image image1=new Image("file:img.jpg", specBottomBannerImage.getFitWidth(), specBottomBannerImage.getFitHeight(), true, true);
		    specBottomBannerImage.setImage(image1);
		   //specBottomBannerImage.setPreserveRatio(true);
		}
		else if(!rs.next()) {
		}
		else {}
	}
	catch(SQLException e) {
		e.printStackTrace();
		System.out.println("ERROR@ Controller.setSpecADBottom.StepTwo");
	}
}
private void setSpecADLeft() throws SQLException, IOException{
	Connection myConnection = DBHandler.getConnection();
    String loadImage = "default.jpg";
	String query = "SELECT leftBannerName FROM arenadatabase.adstorage WHERE adID = 3";
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
		System.out.println("ERROR @ Controller.setSpecADLeft.StepOne");
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
		    javafx.scene.image.Image image1=new Image("file:img.jpg", specLeftBannerImage.getFitWidth(), specLeftBannerImage.getFitHeight(), true, true);
		    specLeftBannerImage.setImage(image1);
		   //specLeftBannerImage.setPreserveRatio(true);
		}
		else if(!rs.next()) {
		}
		else {}
	}
	catch(SQLException e) {
		e.printStackTrace();
		System.out.println("ERROR@ Controller.setSpecADLeft.StepTwo");
	}
}
private void setSpecADRight() throws SQLException, IOException{
	Connection myConnection = DBHandler.getConnection();
    String loadImage = "default.jpg";
	String query = "SELECT rightBannerName FROM arenadatabase.adstorage WHERE adID = 3";
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
		System.out.println("ERROR @ Controller.setSpecADRight.StepOne");
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
		    javafx.scene.image.Image image1=new Image("file:img.jpg", specRightBannerImage.getFitWidth(), specRightBannerImage.getFitHeight(), true, true);
		    specRightBannerImage.setImage(image1);
		   //specRightBannerImage.setPreserveRatio(true);
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
private void setSpecADBG() throws SQLException, IOException{
	Connection myConnection = DBHandler.getConnection();
    String loadImage = "domina1.jpg";
	String query = "SELECT bgBannerName FROM arenadatabase.adstorage WHERE adID = 3";
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
		System.out.println("ERROR @ Controller.setSpecADBG.StepOne");
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
		    javafx.scene.image.Image image1=new Image("file:img.jpg", specBGBannerImage.getFitWidth(), specBGBannerImage.getFitHeight(), true, true);
		    specBGBannerImage.setImage(image1);
		   //specBGBannerImage.setPreserveRatio(true);
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
private void goToApplicationPage(ActionEvent event) throws Exception
    {
        spectApply.getScene().getWindow().hide();
        loader.setLocation(getClass().getResource("/arenaViews/spectAppPage.fxml"));
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

private void loadArenasFromDatabase() throws SQLException
{
	Connection connection = DBHandler.getConnection();

	String roleNames = "SELECT * FROM arena ";
	ObservableList<String> roleList = FXCollections.observableArrayList();
	try
	{
		ResultSet rs = connection.createStatement().executeQuery(roleNames);
		while (rs.next())
		{
			roleList.add(rs.getString("ArenaName"));
		}
		arenaList.setItems(roleList);
	}
	catch(SQLException e)
	{
		e.printStackTrace();
		System.out.println("ERROR @ spectController.loadArenasFromDatabase");
	}
}
private void loadLeagueFromDatabase() throws SQLException
{
	Connection connection = DBHandler.getConnection();

	String roleNames = "SELECT LeagueName FROM league";
	ObservableList<String> roleList = FXCollections.observableArrayList();
	try
	{
		ResultSet rs = connection.createStatement().executeQuery(roleNames);
		while (rs.next())
		{
			roleList.add(rs.getString("LeagueName"));
		}
		leagList.setItems(roleList);
	}
	catch(SQLException e)
	{
		e.printStackTrace();
		System.out.println("ERROR @ spectController.loadLeagueFromDatabase");
	}
}
private void loadTournFromDatabase() throws SQLException{
	{
		Connection connection = DBHandler.getConnection();

		String roleNames = "SELECT TournamentName FROM tournament";
		ObservableList<String> roleList = FXCollections.observableArrayList();
		try
		{
			ResultSet rs = connection.createStatement().executeQuery(roleNames);
			while (rs.next())
			{
				roleList.add(rs.getString("TournamentName"));
			}
			tournList.setItems(roleList);
		}
		catch(SQLException e)
		{
			e.printStackTrace();
			System.out.println("ERROR @ spectController.loadTournsFromDatabase");
		}
	}
}
private void loadTeamFromDatabase() throws SQLException{
	{
		Connection connection = DBHandler.getConnection();

		String roleNames = "SELECT TeamName FROM teams WHERE TeamID > 0";
		ObservableList<String> roleList = FXCollections.observableArrayList();
		try
		{
			ResultSet rs = connection.createStatement().executeQuery(roleNames);
			while (rs.next())
			{
				roleList.add(rs.getString("TeamName"));
			}
			teamList.setItems(roleList);
		}
		catch(SQLException e)
		{
			e.printStackTrace();
			System.out.println("ERROR @ spectController.loadTeamFromDatabase");
		}
	}
}
private void loadPlayersFromDatabase() throws SQLException{
	{
		Connection connection = DBHandler.getConnection();

		String roleNames = "SELECT userName FROM users WHERE userRoleID = 3";
		ObservableList<String> roleList = FXCollections.observableArrayList();
		try
		{
			ResultSet rs = connection.createStatement().executeQuery(roleNames);
			while (rs.next())
			{
				roleList.add(rs.getString("userName"));
			}
			playerList.setItems(roleList);
		}
		catch(SQLException e)
		{
			e.printStackTrace();
			System.out.println("ERROR @ spectController.loadPlayersFromDatabase");
		}
	}
}
@FXML
private void goToCurrentMatchSpec(ActionEvent event) throws Exception{
	  CurrentMatchesSpecButton.getScene().getWindow().hide();
      loader.setLocation(getClass().getResource("/arenaViews/GuestCurrentMatches.fxml"));
      scene = new Scene(loader.load());
      stage.setScene(scene);
      stage.setResizable(false);
      stage.getIcons().add(new Image(getClass().getResourceAsStream("/images/arenaIcon.png")));
      stage.setTitle("Arena");
      stage.show();
      System.gc();
      }
@FXML
private void goToPastMatchSpec(ActionEvent event) throws Exception{
	PastMatchesSpecButton.getScene().getWindow().hide();
      loader.setLocation(getClass().getResource("/arenaViews/GuestPastMatches.fxml"));
      scene = new Scene(loader.load());
      stage.setScene(scene);
      stage.setResizable(false);
      stage.getIcons().add(new Image(getClass().getResourceAsStream("/images/arenaIcon.png")));
      stage.setTitle("Arena");
      stage.show();
      System.gc();
      }
@FXML
private void goToTeamSpec(ActionEvent event) throws Exception{
	  PastMatchesSpecButton.getScene().getWindow().hide();
      loader.setLocation(getClass().getResource("/arenaViews/GuestTeams.fxml"));
      scene = new Scene(loader.load());
      stage.setScene(scene);
      stage.setResizable(false);
      stage.getIcons().add(new Image(getClass().getResourceAsStream("/images/arenaIcon.png")));
      stage.setTitle("Arena");
      stage.show();
      System.gc();
      }
@FXML
private void goToPlayerSpec(ActionEvent event) throws Exception{
	PlayerListButton.getScene().getWindow().hide();
      loader.setLocation(getClass().getResource("/arenaViews/GuestPlayers.fxml"));
      scene = new Scene(loader.load());
      stage.setScene(scene);
      stage.setResizable(false);
      stage.getIcons().add(new Image(getClass().getResourceAsStream("/images/arenaIcon.png")));
      stage.setTitle("Arena");
      stage.show();
      System.gc();
      }
}