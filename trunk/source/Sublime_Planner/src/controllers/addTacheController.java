package controllers;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import modele.Documents;
import modele.Tache;
import modele.ToDoListe;

import java.net.URL;
import java.util.ResourceBundle;

public class addTacheController implements Initializable {
    @FXML
    private TextField TacheName;
    @FXML
    private Button AddButton;


    private Documents doc;
    public Documents getDoc(){return doc;}

    private int todoIndex;
    public int getTodoIndex(){return todoIndex;}

    public addTacheController(Documents doc, int todoIndex){
        this.doc = doc;
        this.todoIndex = todoIndex;
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
                String tacheName = TacheName.getText();
                Tache t = new Tache(tacheName);
                doc.getMatodoliste(todoIndex).add(t);
                window.close();
            }
        });
    }
}
