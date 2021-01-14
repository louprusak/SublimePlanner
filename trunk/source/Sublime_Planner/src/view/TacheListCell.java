package view;

import javafx.beans.binding.Bindings;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ListCell;
import modele.Tache;


public class TacheListCell extends ListCell<Tache> {

    @Override
    protected void updateItem(Tache tache, boolean b) {
        super.updateItem(tache, b);
        if(!b){
            textProperty().bind(tache.descProperty());
            graphicProperty().bind(Bindings.createObjectBinding(
                    () -> new CheckBox()

            ));
        }
    }
}
