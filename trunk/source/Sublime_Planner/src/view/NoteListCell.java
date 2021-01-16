package view;

import controllers.BlocNotesController;
import controllers.NoteController;
import javafx.beans.binding.Bindings;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ListCell;
import javafx.stage.Stage;
import modele.Note;

import javax.swing.text.html.CSS;

public class NoteListCell extends ListCell<Note> {

    BlocNotesController controller;
    Button b;

    private static final String CSS_PATH = "../view/main.css";
    private static final String NOTE_PATH ="/layout/Note.fxml";

    public NoteListCell(BlocNotesController blocNotesController) {
        this.controller = blocNotesController;
    }


    @Override
    protected void updateItem(Note item, boolean empty){
        super.updateItem(item, empty);
        if(!empty){
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
