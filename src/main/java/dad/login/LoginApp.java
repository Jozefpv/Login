package dad.login;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class LoginApp extends Application {
	
	public static Stage primaryStage;

	@Override
	public void start(Stage primaryStage) throws Exception {
		// TODO Auto-generated method stub
		LoginApp.primaryStage = primaryStage;
		Controller controller = new Controller();
		Scene scene = new Scene(controller.getView(),320, 200);
		
		primaryStage.setTitle("Login");
		primaryStage.setScene(scene);
		primaryStage.show();
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		launch(args);
	}

}
