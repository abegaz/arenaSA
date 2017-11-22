package arenaClasses;


import com.jfoenix.controls.JFXButton;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;


public class CreateGameController extends Main{

	@FXML
	TextField gameNameField;
	@FXML
	TextArea gameDescField;
	@FXML
	Label errorMsg, exErrorMsg, successMsg;


	//Minimum length for valid game name (if applicable)
	private final int MIN_NAME_LENGTH = 3;


	//table stuff
	@FXML  private Button gameLoadBtn;
	//@FXML private Label errorMsg;
	@FXML private TableView<GameData> getGameTable;
	@FXML private TableColumn<GameData, String> gameIDColumn;
	@FXML  private TableColumn<GameData, String> gameNameColumn;
	@FXML  private TableColumn<GameData, String> gameDescColumn;
	@FXML private JFXButton returnBtn;
	Scene scene;
	Stage stage = new Stage();


	private ObservableList<GameData> gameDataArray;


	ArrayList<String> currentGames = new ArrayList<>();





	@FXML
	private void closeApplication(MouseEvent event)
	{
		System.exit(0);
	}


	@FXML
	public void addGame(ActionEvent ae){

		String gName = gameNameField.getText();
		String gDesc = gameDescField.getText();

		if(isValidEntry(gName)){
			try
			{
				Connection connection = DBHandler.getConnection();
				String addGameQuery = "INSERT INTO game (GameName, GameDescription) VALUES (?,?)";
				PreparedStatement preparedStatement = connection.prepareStatement(addGameQuery);
				preparedStatement.setString (1, gName);
				preparedStatement.setString (2, gDesc);
				preparedStatement.execute();
			}
			catch(Exception ex)
			{
				showError(ex.getLocalizedMessage());
			}
			refresh();
		}

	}




	public void showError(String e){

		errorMsg.setText(e);

		if(!errorMsg.isVisible())
			errorMsg.setVisible(true);

	}
	public void showError(Exception ex){
		if(successMsg.isVisible())
			successMsg.setVisible(false);
		exErrorMsg.setText(ex.getLocalizedMessage());
		if(!exErrorMsg.isVisible())
			exErrorMsg.setVisible(true);
	}
	public void hideError(){
		if(errorMsg.isVisible())
			errorMsg.setVisible(false);
	}
	public void hideExError(){
		if(exErrorMsg.isVisible())
			exErrorMsg.setVisible(false);
	}
	public boolean isValidEntry(String entry){


		if(entry.length() < MIN_NAME_LENGTH){
			showError("Name must be a least " + MIN_NAME_LENGTH +" characters.");
			return false;
		}
		else if(!entry.matches("^[a-zA-Z0-9_]+$")) //if contains characters
		{
			showError("Only letters or numbers allowed");
			return false;
		}else if(currentGames.contains(entry.toLowerCase())){
			showError("\"" + entry + "\" already exists");
			return false;
		}

		hideError();
		return true;
	}
	public void checkWhileTyping(KeyEvent ke){
		isValidEntry(gameNameField.getText());
	}
	public void refresh(){
		showSuccess(gameNameField.getText());
		gameNameField.clear();
		gameDescField.clear();
		hideError();
		try {
			loadGameFromDatabase();
		}catch(Exception ex){
			showError(ex);
		}


	}
	public void showSuccess(String gameName){
		successMsg.setText("\"" + gameName + "\" successfully created.");
		if(!successMsg.isVisible())
			successMsg.setVisible(true);
	}
	public void initialize() {
		// initialization code here...
		try {
			loadGameFromDatabase();
		}catch(Exception ex){
			showError(ex);
		}

	}
	@FXML
	void loadGameFromDatabase() throws SQLException
	{

		Connection connection = DBHandler.getConnection();
		String getAllGameFromDatabase = "SELECT * FROM game";
		gameDataArray = FXCollections.observableArrayList();
		try
		{
			ResultSet rs = connection.createStatement().executeQuery(getAllGameFromDatabase);
			while(rs.next())
			{
				String gameID = rs.getString("GameID");
				String gameName = rs.getString("GameName");
				String gameDesc = rs.getString("GameDescription");
				//table
				gameDataArray.add(new GameData (gameID, gameName, gameDesc));

				//current games list
				if(!currentGames.contains(gameName.toLowerCase()))
					currentGames.add(gameName.toLowerCase());
			}

			gameIDColumn.setCellValueFactory(new PropertyValueFactory<>("gameID"));
			gameNameColumn.setCellValueFactory(new PropertyValueFactory<>("gameName"));
			gameDescColumn.setCellValueFactory(new PropertyValueFactory<>("gameDesc"));

			getGameTable.setItems(null);
			getGameTable.setItems(gameDataArray);
		}
		catch(Exception ex)
		{
			showError(ex);
		}
		hideExError();
	}
	@FXML
	void refreshTable(ActionEvent event) throws SQLException
	{
		loadGameFromDatabase();
	}

	//load view
	@FXML
	private void loadView(String view) throws Exception
	{
		returnBtn.getScene().getWindow().hide();
		loader.setLocation(getClass().getResource("/arenaViews/"+ view +".fxml"));
		scene = new Scene(loader.load());
		stage.setScene(scene);
		stage.setResizable(false);
		stage.getIcons().add(new Image(getClass().getResourceAsStream("/images/arenaIcon.png")));
		stage.setTitle("Arena");
		stage.show();
	}
	@FXML
	private void handleReturnBtn(ActionEvent ae){
		try{
		loadView("operatorLanding");
		}catch(Exception ex){
			showError(ex);
		}
	}	@FXML
	private void goToCreateGame(ActionEvent ae){
		try{
		loadView("createGame");
		}catch(Exception ex){
			showError(ex);
		}
	}


}




	


