package view;

import javafx.scene.control.ListCell;
import modele.ToDoListe;

public class ToDoListCell extends ListCell<ToDoListe> {

    //*********************Fonctions*********************//

    /**
     * Fonction permettant de remplir la cellule
     * @param toDoListe la ToDoListe
     * @param empty boolean
     */
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
        setWrapText(true);
    }

}
