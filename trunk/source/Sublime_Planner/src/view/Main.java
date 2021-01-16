package view;


import Serialize.Serialize;
import controllers.MainController;
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

        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        doc = new Documents();
        FonctionTest test = new FonctionTest();
        test.test(doc);
        System.out.println(doc.toString());

        //Serialize.serialize("test.ser",doc);

        //Documents doc2 = (Documents) Serialize.deSerialize("test.ser",doc);

        System.out.println("------------------------------");
        System.out.println(doc.toString());

        FXMLLoader loader = new FXMLLoader(getClass().getResource(MAIN_WINDOW_FXML));
        Parent root;
        loader.setController(new MainController(doc));
        root = loader.load();
        primaryStage.setTitle(MAIN_WINDOW_TITLE);
        Scene scene = new Scene(root,H_SIZE,V_SIZE);
        scene.getStylesheets().add(getClass().getResource("main.css").toExternalForm());
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}
