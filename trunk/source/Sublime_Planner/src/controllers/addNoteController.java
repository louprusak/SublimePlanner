package controllers;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import modele.Documents;
import modele.Note;

import javax.swing.text.Document;
import java.net.URL;
import java.util.ResourceBundle;

public class addNoteController implements Initializable {
    @FXML
    private TextField NoteTitle;
    @FXML
    private TextArea NoteText;
    @FXML
    private Button AddButton;

    private Documents doc;
    public Documents getDoc(){return doc;}

    public addNoteController(Documents doc){
        this.doc = doc;
    }


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        initializeButton();
    }

    public void initializeButton(){
        AddButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                Stage window = (Stage)((Node)actionEvent.getSource()).getScene().getWindow();
                String noteTitle = NoteTitle.getText();
                String noteText = NoteText.getText();
                Note note = new Note(noteTitle,noteText);
                doc.getMonblocnotes().add(note);
                window.close();
            }
        });
    }
}
