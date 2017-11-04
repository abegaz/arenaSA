package application;

import java.net.URL;
import java.util.ResourceBundle;
import com.jfoenix.controls.JFXButton;
import java.sql.*;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import com.jfoenix.controls.JFXButton;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

public class ArenaController
{
	@FXML  private Label closeIcon;
	@FXML private Label errorLabel;
	@FXML private TableView<ArenaData> getTArenasTable;
	@FXML private TableColumn<ArenaData, String> getArenasArenaIDColumn;
	@FXML private TableColumn<ArenaData, String> getArenasArenaNameColumn;
	@FXML private Label loadMe;
	@FXML private JFXButton getArenaReturn;
	@FXML private JFXButton ArenaRefresh;
	@FXML private JFXButton createNewArena;
	@FXML private TextField createArenaNameField;
    @FXML private JFXButton manageArenaRemoveButton;

	private ObservableList<ArenaData> arenaDataArray;
	DatabaseConnector databaseConnector = new DatabaseConnector();
	public void initialize(URL url, ResourceBundle rb)
	{
		databaseConnector.DatabaseConnector();
	}
	@FXML
	void closeApplication(MouseEvent event)
	{

	}
	@FXML
	void goBackToLOLanding(ActionEvent event)
	{

	}
	@FXML
	void goBackToOpLanding(ActionEvent event)
	{

	}
	void loadArenasFromDatabase() throws SQLException
	{
		Connection connection = databaseConnector.getConnection();

    	arenaDataArray = FXCollections.observableArrayList();
    	// Execute query and store results
    	String getArenaDataQuery = "SELECT * FROM arena";
    	try
    	{
    		ResultSet rs = connection.createStatement().executeQuery(getArenaDataQuery);
			while (rs.next())
			{
				String arenaName = rs.getString("ArenaName");
				String arenaID = rs.getString("ArenaID");

				arenaDataArray.add(new ArenaData (arenaID, arenaName));
			}

			getArenasArenaIDColumn.setCellValueFactory(new PropertyValueFactory<>("arenaID"));
			getArenasArenaNameColumn.setCellValueFactory(new PropertyValueFactory<>("arenaName"));

			getTArenasTable.setItems(null);
			getTArenasTable.setItems(arenaDataArray);
		}
    	catch(Exception ex)
		{
			System.out.println("Error: " + ex);
		}
	}
	@FXML
	void loadArenasFromDatabase(ActionEvent event) throws SQLException
	{
		Connection connection = databaseConnector.getConnection();

    	arenaDataArray = FXCollections.observableArrayList();
    	// Execute query and store results
    	String getArenaDataQuery = "SELECT * FROM arena";
    	try
    	{
    		ResultSet rs = connection.createStatement().executeQuery(getArenaDataQuery);
			while (rs.next())
			{
				String arenaName = rs.getString("ArenaName");
				String arenaID = rs.getString("ArenaID");

				arenaDataArray.add(new ArenaData (arenaID, arenaName));
			}

			getArenasArenaIDColumn.setCellValueFactory(new PropertyValueFactory<>("arenaID"));
			getArenasArenaNameColumn.setCellValueFactory(new PropertyValueFactory<>("arenaName"));

			getTArenasTable.setItems(null);
			getTArenasTable.setItems(arenaDataArray);
		}
    	catch(Exception ex)
		{
			System.out.println("Error: " + ex);
		}
	}
	@FXML
    void createArena(ActionEvent event)
	{
		System.out.println("createArena");
		try
    	{
			Connection connection = databaseConnector.getConnection();
			String setNULL = null;

			if (createArenaNameField.getText().trim().isEmpty() || createArenaNameField.getText() == null)
			{
				createArenaNameField.setText("Please Enter Arena Name");
			}
			else
			{
				String ArenaName = createArenaNameField.getText();

				String addNewArenaQuery = "INSERT INTO arena (ArenaID, ArenaName)"
					+ " VALUES (?,?)";

				PreparedStatement preparedStmt = connection.prepareStatement(addNewArenaQuery);
				preparedStmt.setString (1, setNULL);
				preparedStmt.setString (2, ArenaName);

				//execute the preparedstatement
				preparedStmt.execute();
				loadArenasFromDatabase();
				createArenaNameField.setText("");

			}

		}
    	catch(Exception ex)
		{
			System.out.println("Error: " + ex);
		}
    }
	@FXML
    void removeArena(ActionEvent event) throws SQLException
	{
		Connection connection = databaseConnector.getConnection();
    	ArenaData arenaDataArray = getTArenasTable.getSelectionModel().getSelectedItem();
    	String selectedArenaID = arenaDataArray.getarenaID();
		System.out.println(selectedArenaID);
		String deleteTournamentQuery = "DELETE FROM arena WHERE ArenaID = '" + selectedArenaID + "'";
		try
		{
			PreparedStatement preparedStmt = connection.prepareStatement(deleteTournamentQuery);
			preparedStmt.execute();

			loadArenasFromDatabase();
		}
		catch(SQLException e)
		{
			e.printStackTrace();
			System.out.println("ERROR @ ArenaController.removeArena First Try");
		}
		finally
		{
			connection.close();
		}
    }

}
