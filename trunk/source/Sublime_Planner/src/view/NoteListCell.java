package view;

import controllers.BlocNotesController;
import javafx.beans.binding.Bindings;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.ListCell;
import modele.Note;

public class NoteListCell extends ListCell<Note> {

    BlocNotesController controller;
    Button b;

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

                }
            });
            setGraphic(b);
        }
    }
}
