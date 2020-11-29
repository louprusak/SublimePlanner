package view;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import test.FonctionTest;

public class Main extends Application {

    public static void main(String[] args) {
        FonctionTest test = new FonctionTest();
        test.test();
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("../layout/Note.fxml"));
        primaryStage.setTitle("Sublime Planner");
        primaryStage.setScene(new Scene(root,1000,600));
        primaryStage.show();
    }
}
