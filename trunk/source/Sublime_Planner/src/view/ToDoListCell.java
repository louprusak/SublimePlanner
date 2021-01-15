package view;

import javafx.scene.control.ListCell;
import modele.ToDoListe;

public class ToDoListCell extends ListCell<ToDoListe> {

    @Override
    protected void updateItem(ToDoListe toDoListe, boolean b) {
        super.updateItem(toDoListe, b);
        if(!b){
            textProperty().bind(toDoListe.nomToDoProperty());

        }
    }
}
