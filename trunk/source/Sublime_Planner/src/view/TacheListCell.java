package view;

import controllers.MainController;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ListCell;
import modele.Tache;

public class TacheListCell extends ListCell<Tache> {

    //*********************Attributs*********************//

    /**
     * Controlleur lié a la cellule
     */
    private MainController controller;

    /**
     * CheckBox de la cellule
     */
    private CheckBox cb;

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
     * Constructeur de la classe tacheListCell
     * @param mainController controleur
     */
    public TacheListCell(MainController mainController) {
        this.controller = mainController;
    }

    //*********************Fonctions*********************//

    /**
     * Fonction permettant de remplir une cellule
     * @param tache la Tache
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
                    controller.getDoc().getMatodoliste(0).remove(tache);
                }
            });
            setGraphic(cb);
            setWrapText(true);
        }
    }

}
