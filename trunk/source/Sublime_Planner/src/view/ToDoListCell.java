package view;

import javafx.scene.control.ListCell;
import modele.ToDoListe;

public class ToDoListCell extends ListCell<ToDoListe> {

    @Override
    protected void updateItem(ToDoListe toDoListe, boolean empty) {
        super.updateItem(toDoListe, empty);
        if (empty || toDoListe == null) {
            textProperty().unbind();
            setText(null);
            setGraphic(null);
        }else{
            textProperty().bind(toDoListe.nomToDoProperty());

        }
    }
}
