package view;

import javafx.beans.InvalidationListener;
import javafx.beans.property.IntegerProperty;
import javafx.collections.ArrayChangeListener;
import javafx.collections.ObservableArray;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ListCell;
import javafx.scene.text.Text;
import modele.Creneau;

import javafx.beans.binding.Bindings;

import java.util.List;

public class CreneauListCell extends ListCell<Creneau> {

    @Override
    protected void updateItem(Creneau creneau, boolean b) {
        super.updateItem(creneau, b);
        if(!b){
            textProperty().bind(creneau.evenementProperty());
        }
    }
}
