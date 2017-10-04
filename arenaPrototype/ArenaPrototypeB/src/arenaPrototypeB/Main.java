package arenaPrototypeB;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class Main extends Application {
	
	@Override
	public void start(Stage stage) throws Exception {
		try {
			Parent root = FXMLLoader.load(getClass().getResource("loginPage.fxml"));
			stage.initStyle(StageStyle.UNDECORATED);
			Scene scene = new Scene(root);
			stage.setScene(scene);
			stage.getIcons().add(new Image(getClass().getResourceAsStream("arenaIcon.png")));
			stage.show();
			stage.setResizable(false);
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	public static void main(String[] args){
            launch(args);
	}
}
