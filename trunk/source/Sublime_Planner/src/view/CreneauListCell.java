package view;

import javafx.beans.binding.Bindings;
import javafx.scene.control.ListCell;
import modele.Creneau;

public class CreneauListCell extends ListCell<Creneau> {

    @Override
    protected void updateItem(Creneau creneau, boolean b) {
        super.updateItem(creneau, b);
        if(!b){
            textProperty().bind(creneau.evenementProperty());

        }
    }
}
