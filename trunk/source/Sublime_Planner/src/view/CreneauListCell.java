package view;

import javafx.beans.binding.Bindings;
import javafx.scene.control.ListCell;
import modele.Creneau;

public class CreneauListCell extends ListCell<Creneau> {

    //boolean showDate;

    //public CreneauListCell(boolean showDate) {
        //super();
       // this.showDate = showDate;
    //}

    @Override
    protected void updateItem(Creneau creneau, boolean b) {
        super.updateItem(creneau, b);
        if(!b){
            setText(creneau.getDateDebut().toString());
            //textProperty().bind(creneau);

        }
    }
}
