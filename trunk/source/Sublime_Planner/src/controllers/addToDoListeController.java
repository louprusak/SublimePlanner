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
import modele.ToDoListe;

import java.net.URL;
import java.util.ResourceBundle;

public class addToDoListeController implements Initializable {

    //*********************Attributs*********************//

    /**
     * Elements FXML
     */
    @FXML
    private TextField ToDoName;
    @FXML
    private Button AddButton;

    /**
     * Mes documents
     */
    private Documents doc;
    /**
     * Getter de mes documents
     * @return mes documents
     */
    public Documents getDoc(){return doc;}

    //*********************Constructeur*********************//

    /**
     * Constructeur de la classe addToDoListeController
     * @param doc mes documents
     */
    public addToDoListeController(Documents doc){
        this.doc = doc;
    }

    //*********************Fonctions*********************//

    /**
     * initialisation de la partie graphique
     * @param url url
     * @param resourceBundle ressource
     */
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        initializeButton();
    }

    /**
     * initialisation des actions sur les buttons
     */
    public void initializeButton(){
        AddButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                Stage window = (Stage)((Node)actionEvent.getSource()).getScene().getWindow();
                String toDoName = ToDoName.getText();
                ToDoListe liste = new ToDoListe(toDoName);
                doc.getMeslistetodo().add(liste);
                window.close();
            }
        });
    }

}
