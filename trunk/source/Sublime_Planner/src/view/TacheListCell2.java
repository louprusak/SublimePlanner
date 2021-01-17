package view;

import controllers.MainController;
import controllers.ToDoListeController;
import javafx.beans.binding.Bindings;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ListCell;
import javafx.stage.Stage;
import modele.Tache;
import modele.ToDoListe;

import java.io.IOException;


public class TacheListCell2 extends ListCell<Tache> {

    //*********************Attributs*********************//

    /**
     * Controlleur lié a la cellule
     */
    private ToDoListeController controller;

    /**
     * CheckBox lié a la cellule
     */
    private CheckBox cb;

    /**
     * index de la liste
     */
    private int index;

    /**
     * Attribut contenant tous les documents
     */
    private static final String CSS_PATH = "../view/main.css";
    private static final String NOTECSS_PATH = "../view/note.css";
    private static final String EDT_PATH = "/layout/EDT.fxml";
    private static final String MAIN_PATH = "/layout/Accueil.fxml";
    private static final String BLOCNOTES_PATH = "/layout/BlocNotes.fxml";
    private static final String TODO_PATH = "/layout/ToDoListe.fxml";

    //*********************Constructeur*********************//

    /**
     * Controleur de la TacheListCell2
     * @param mainController controleur
     * @param index index de la liste
     */
    public TacheListCell2(ToDoListeController mainController, int index) {
        this.controller = mainController;
        this.index = index;
    }

    //*********************Fonctions*********************//

    /**
     * Fonction permettant de remplir une cellule
     * @param tache La tache
     * @param empty boolean
     */
    @Override
    protected void updateItem(Tache tache, boolean empty) {
        super.updateItem(tache, empty);
        if (empty || tache == null) {
            textProperty().unbind();
            setText(null);
            setGraphic(null);
        } else {
            textProperty().bind(tache.descProperty());
            cb = new CheckBox();
            cb.setMaxWidth(Double.MAX_VALUE);
            cb.setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent actionEvent) {
                    controller.getDoc().getMatodoliste(index).remove(tache);
                }
            });
            setGraphic(cb);
        }
    }

}
