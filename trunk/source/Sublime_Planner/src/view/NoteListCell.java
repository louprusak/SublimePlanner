package view;

import javafx.scene.control.ListCell;
import modele.Note;

public class NoteListCell extends ListCell<Note> {
    @Override
    protected void updateItem(Note item, boolean empty){
        super.updateItem(item, empty);
        /*if(!empty){
            textProperty().bind(item.nameProperty());
            graphicProperty().bind(Bindings.createObjectBinding(
                    () -> new Text(item.getNom()), new Text(item.getTextNote())

            ));
        }*/
    }
}
