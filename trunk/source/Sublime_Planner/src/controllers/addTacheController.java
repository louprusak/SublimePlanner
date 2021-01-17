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

import java.net.URL;
import java.util.ResourceBundle;

public class addTacheController implements Initializable {

    //*********************Attributs*********************//

    /**
     * Elements FXML
     */
    @FXML
    private TextField TacheName;
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

    /**
     * L'indexx de la todoliste
     */
    private int todoIndex;

    /**
     * Gettre de mon index
     * @return
     */
    public int getTodoIndex(){return todoIndex;}

    //*********************Constructeur*********************//

    /**
     * Constructeur de la classe addTacheController
     * @param doc mes documents
     * @param todoIndex index de la liste
     */
    public addTacheController(Documents doc, int todoIndex){
        this.doc = doc;
        this.todoIndex = todoIndex;
    }

    //*********************Fonctions*********************//

    /**
     * initialisation de la partie graphique
     * @param url url
     * @param resourceBundle ressources
     */
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        initializeButton();
    }

    /**
     * initialisation des actions sur les bouttons
     */
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
