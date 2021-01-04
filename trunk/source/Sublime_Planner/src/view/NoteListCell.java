package view;

import javafx.beans.binding.Bindings;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ListCell;
import javafx.scene.text.Text;
import modele.Notes;

public class NoteListCell extends ListCell<Notes> {
    @Override
    protected void updateItem(Notes item, boolean empty){
        super.updateItem(item, empty);
        /*if(!empty){
            textProperty().bind(item.nameProperty());
            graphicProperty().bind(Bindings.createObjectBinding(
                    () -> new Text(item.getNom()), new Text(item.getTextNote())

            ));
        }*/
    }
}
