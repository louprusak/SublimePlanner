package view;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
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
        Parent root = FXMLLoader.load(getClass().getResource("/layout/Note.fxml"));
        primaryStage.setTitle("Sublime Planner");

        primaryStage.setScene(new Scene(root,H_SIZE,V_SIZE));
        primaryStage.show();
    }
}
