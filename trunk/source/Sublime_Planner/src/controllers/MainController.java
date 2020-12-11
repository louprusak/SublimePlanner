package controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ResourceBundle;

public class MainController implements Initializable {

    @FXML
    public Button ButtonEDT;
    @FXML
    public Button ButtonBlocNotes;
    @FXML
    public Button ButtonToDoListe;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        initializeTxt();
    }

    public void initializeTxt(){
        ButtonEDT.setText("EDT");
        ButtonBlocNotes.setText("Bloc-Notes");
        ButtonToDoListe.setText("To-Do Liste");
    }

    public void gotoToDoListe(ActionEvent actionEvent) {

    }
}
