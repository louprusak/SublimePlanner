package view;

import javafx.beans.binding.Bindings;
import javafx.scene.control.ListCell;
import modele.Creneau;

public class CreneauListCell extends ListCell<Creneau> {

    @Override
    protected void updateItem(Creneau creneau, boolean empty) {
        super.updateItem(creneau, empty);
        if (empty || creneau == null) {
            textProperty().unbind();
            setText(null);
            setGraphic(null);
        }else{

        setText(creneau.toString2());

        }
    }
}
