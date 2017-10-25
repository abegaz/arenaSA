package application;

import java.util.Scanner;

import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;


public class Main extends Application
{
	//Text User Interface

	public static void BasicFunctionMenu()
	{
	    DatabaseConnector databaseConnector = new DatabaseConnector();
		Scanner scanner = null;
		try
		{
		    scanner = new Scanner(System.in);

			System.out.println("0. Get All Users");
			System.out.println("1. Get All Operators");
			System.out.println("2. Make New User");
			System.out.println("3. Delete user from Database");
			System.out.println("Select Function from list below:");
			int userFunctionInput = scanner.nextInt();
			scanner.nextLine(); //Eats any whitespace in buffer
			switch(userFunctionInput)
			{
				case 0:
				{
					System.out.println("0. Get All Users");
					databaseConnector.getUsersInformation();
					break;
				}
				case 1:
				{
					System.out.println("1. Get All Operators");
					databaseConnector.getOperators();
					break;
				}
				case 2:
				{
					System.out.println("2. Make New User");
					databaseConnector.makeNewUser();
					break;
				}
				case 3:
				{
					System.out.println("3. Delete user from Database");
					databaseConnector.DeleteUser();
					break;
				}
				default:
				{
					System.out.println("You Should never see me.");
					BasicFunctionMenu();
				}
			}
		}
		finally
		{
		    if(scanner!=null)
		    {
		    	scanner.close();
		    }
		}
	}

	@Override
	public void start(Stage primaryStage)
	{
		try
		{
			primaryStage.show();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}

	public static void main(String[] args)
	{
		//launch(args);

		BasicFunctionMenu();
	}
}
