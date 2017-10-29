package application;

import java.util.Scanner;

import javafx.application.Application;
import javafx.stage.Stage;


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
			System.out.println("4. Make User Operator");
			System.out.println("5. Make User League Owner");
			System.out.println("6. Make User Advertiser");
			System.out.println("7. Make User Player");
			System.out.println("8. Get All Games");
			System.out.println("9. Create New Game");
			System.out.println("10. Delete Game");
			System.out.println("11. Get All Arenas");
			System.out.println("12. Create New Arena");
			System.out.println("13. Delete Arena");
			System.out.println("14. Get All Expert Rating Formula");
			System.out.println("15. Create New Formula");
			System.out.println("16. Get All Leagues");
			System.out.println("17. Create New League");
			System.out.println("Select Function from list below:");
			int userFunctionInput = scanner.nextInt();
			scanner.nextLine(); //Eats any whitespace in buffer
			switch(userFunctionInput)
			{
				case 0:
				{
					System.out.println("0. Get All Users");
					databaseConnector.getUsersInformation(true);
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
				case 4:
				{
					System.out.println("4. Make User Operator");
					databaseConnector.MakeUserOperator();
					break;
				}
				case 5:
				{
					System.out.println("5. Make User League Owner");
					databaseConnector.MakeUserLeagueOwner();
					break;
				}
				case 6:
				{
					System.out.println("6. Make User Advertiser");
					databaseConnector.MakeUserAdvertiser();
					break;
				}
				case 7:
				{
					System.out.println("7. Make User Player");
					databaseConnector.makeUserPlayer();
					break;
				}
				case 8:
				{
					System.out.println("8. Get All Games");
					databaseConnector.GetAllGames(true);
					break;
				}
				case 9:
				{
					System.out.println("9. Create New Game");
					databaseConnector.createGame();
					break;
				}
				case 10:
				{
					System.out.println("10. Delete Game");
					databaseConnector.DeleteGame();
					break;
				}
				case 11:
				{
					System.out.println("11. Get All Arenas");
					databaseConnector.GetAllArenas(true);
					break;
				}
				case 12:
				{
					System.out.println("12. Create New Arena");
					databaseConnector.CreateArena();
					break;
				}
				case 13:
				{
					System.out.println("13. Delete Arena");
					databaseConnector.DeleteArena();
					break;
				}
				case 14:
				{
					System.out.println("14. Get All Expert Rating Formula");
					databaseConnector.getALLExpertRatingFormula(true);
					break;
				}
				case 15:
				{
					System.out.println("15. Create New Formula");
					databaseConnector.createExpertRatingFormula();
					break;
				}
				case 16:
				{
					System.out.println("16. Get All Leagues");
					databaseConnector.GetAllLeagues(true);
					break;
				}
				case 17:
				{
					System.out.println("17. Create New League");
					databaseConnector.createNewLeague();
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
