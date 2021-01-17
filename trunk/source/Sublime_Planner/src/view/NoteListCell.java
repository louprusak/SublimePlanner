package view;

import controllers.BlocNotesController;
import controllers.NoteController;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ListCell;
import javafx.stage.Stage;
import modele.Note;

public class NoteListCell extends ListCell<Note> {

    //*********************Attributs*********************//

    /**
     * Controlleur lié a la cellule
     */
    private BlocNotesController controller;

    /**
     * Button de la cellule
     */
    private Button b;

    /**
     * Attribut contenant tous les documents
     */
    private static final String CSS_PATH = "../view/main.css";
    private static final String NOTE_PATH ="/layout/Note.fxml";

    //*********************Controlleur*********************//

    /**
     * Constructeur de la classe BlocNotesController
     * @param blocNotesController
     */
    public NoteListCell(BlocNotesController blocNotesController) {
        this.controller = blocNotesController;
    }

    //*********************Fonctions*********************//

    /**
     * Fonction permettant de remplir une cellule
     * @param item note
     * @param empty boolean
     */
    @Override
    protected void updateItem(Note item, boolean empty){
        super.updateItem(item, empty);
        if (empty || item == null) {
            textProperty().unbind();
            setText(null);
            setGraphic(null);
        }else{
            textProperty().bind(item.nomProperty());
            b = new Button("Voir la Note");
            b.setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent actionEvent) {
                    try {
                        goToNote(actionEvent,NOTE_PATH,CSS_PATH,item);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            });
            setGraphic(b);
        }
    }

    /**
     * Fonction permettant d'ouvrir une note
     * @param actionEvent action
     * @param PATH lien layout
     * @param CSS_PATH lien css du layout
     * @param item la note
     * @throws Exception erreur
     */
    private void goToNote(ActionEvent actionEvent,String PATH, String CSS_PATH, Note item) throws Exception {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/layout/Note.fxml"));
        loader.setController(new NoteController(controller.getDoc(),item));
        Parent root2 = loader.load();
        Stage window = (Stage)((Node)actionEvent.getSource()).getScene().getWindow();
        Scene actual = window.getScene();
        Scene scene2 = new Scene(root2, actual.getWidth(), actual.getHeight());
        scene2.getStylesheets().add(getClass().getResource(CSS_PATH).toExternalForm());
        window.setScene(scene2);
        window.show();
    }
}
