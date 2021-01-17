package view;

import javafx.scene.control.ListCell;
import modele.Creneau;

public class CreneauListCell extends ListCell<Creneau> {

    //*********************Fonctions*********************//

    /**
     * Fonction permettant de remplir la cellules du Creneau
     * @param creneau le Creneau
     * @param empty boolean
     */
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
