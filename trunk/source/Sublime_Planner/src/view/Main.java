package view;


import Serialize.Serialize;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import modele.Documents;
import modele.Note;
import test.FonctionTest;

public class Main extends Application {

    //*********************Attributs*********************//

    /**
     * Attribut contenant tous les documents
     */
    public static Documents doc;

    private static final int H_SIZE = 1000;
    private static final int V_SIZE = 600;

    private static final String MAIN_WINDOW_FXML = "/layout/Accueil.fxml";
    private static final String MAIN_WINDOW_TITLE = "Sublime Planner";

    //*********************Fonctions*********************//

    public static void main(String[] args) {
        doc = new Documents();
        FonctionTest test = new FonctionTest();
        test.test(doc);
        /*
        Note n = new Note("test", "txt test");
        Serialize.serialize("test.txt", n);
        Note m;
        m = (Note) Serialize.deSerialize("test.txt", n);
        System.out.println(m);
         */
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        FXMLLoader loader = new FXMLLoader(getClass().getResource(MAIN_WINDOW_FXML));
        Parent root;
        root = loader.load();
        primaryStage.setTitle(MAIN_WINDOW_TITLE);
        Scene scene = new Scene(root,H_SIZE,V_SIZE);
        scene.getStylesheets().add(getClass().getResource("main.css").toExternalForm());
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}
