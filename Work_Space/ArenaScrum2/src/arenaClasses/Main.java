package arenaClasses;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

public class Main extends Application
{

Scene sceneLogin;
Stage stage = new Stage();
FXMLLoader loader = new FXMLLoader();


@Override
public void start(Stage stage) throws Exception
	{
		try
		{
			loader.setLocation(getClass().getResource("/arenaViews/loginPage.fxml"));
			sceneLogin = new Scene(loader.load());
			stage.setScene(sceneLogin);
			stage.getIcons().add(new Image(getClass().getResourceAsStream("/images/arenaIcon.png")));
			stage.setTitle("Arena");
			stage.setResizable(false);
			stage.show();
		}
		catch(Exception e)
		{
			e.printStackTrace();
			System.out.println("Main Operation Failure");
		}
		
		

	}


public static void main(String[] args)
	{
            launch(args);
	}
}
