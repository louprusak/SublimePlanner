package view;

import controllers.MainController;
import javafx.beans.binding.Bindings;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ListCell;
import modele.Tache;


public class TacheListCell extends ListCell<Tache> {

    CheckBox cb;
    MainController controller;

    public TacheListCell(MainController mainController) {
        this.controller = mainController;
    }

    @Override
    protected void updateItem(Tache tache, boolean b) {
        super.updateItem(tache, b);
        if(!b){
            textProperty().bind(tache.descProperty());
            cb = new CheckBox();
            cb.setMaxWidth(Double.MAX_VALUE);
            cb.setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent actionEvent) {
                    controller.getTodoliste().remove(tache);
                }
            });
            setGraphic(cb);
        }
    }
}
