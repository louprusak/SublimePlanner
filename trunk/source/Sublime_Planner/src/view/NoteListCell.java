package view;

import javafx.beans.binding.Bindings;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.ListCell;
import modele.Note;

public class NoteListCell extends ListCell<Note> {
    @Override
    protected void updateItem(Note item, boolean empty){
        super.updateItem(item, empty);
        if(!empty){
            textProperty().bind(item.nomProperty());
            graphicProperty().bind(Bindings.createObjectBinding(
                    () -> new Button("Voir la note")
            ));
        }
    }
}
