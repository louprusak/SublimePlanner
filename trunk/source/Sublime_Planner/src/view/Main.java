package view;

import controllers.MainController;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import test.FonctionTest;

public class Main extends Application {

    public static final int H_SIZE = 1000;
    public static final int V_SIZE = 600;

    public static void main(String[] args) {
        FonctionTest test = new FonctionTest();
        test.test();
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/layout/Accueil.fxml"));
        Parent root = loader.load();
        MainController controller = (MainController) loader.getController();
        primaryStage.setTitle("Sublime Planner");

        primaryStage.setScene(new Scene(root,H_SIZE,V_SIZE));
        primaryStage.show();
    }
}
