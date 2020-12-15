package view;

import controllers.MainController;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import test.FonctionTest;

public class Main extends Application {

    private static final int H_SIZE = 1000;
    private static final int V_SIZE = 600;

    private static final String MAIN_WINDOW_FXML = "/layout/Accueil.fxml";
    private static final String MAIN_WINDOW_TITLE = "Sublime Planner";


    public static void main(String[] args) {
        FonctionTest test = new FonctionTest();
        test.test();
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        FXMLLoader loader = new FXMLLoader(getClass().getResource(MAIN_WINDOW_FXML));
        Parent root = loader.load();
        MainController controller = (MainController) loader.getController();
        primaryStage.setTitle(MAIN_WINDOW_TITLE);

        primaryStage.setScene(new Scene(root,H_SIZE,V_SIZE));
        primaryStage.show();
    }
}
