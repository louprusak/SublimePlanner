package controllers;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Modality;
import javafx.stage.Stage;
import modele.Documents;
import view.NoteListCell;

import java.net.URL;
import java.util.ResourceBundle;

public class BlocNotesController implements Initializable{

    //*********************Attributs*********************//

    /**
     * Elements FXML
     */
    @FXML
    private Button HomeButton;
    @FXML
    private Button ButtonEDT;
    @FXML
    private Button ButtonBlocNotes;
    @FXML
    private Button ButtonToDoListe;
    @FXML
    private Button ButtonAddNote;
    @FXML
    private ListView NotesList;

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
     * Attribut contenant tous les documents
     */
    private static final String CSS_PATH = "../view/main.css";
    private static final String NOTECSS_PATH = "../view/note.css";
    private static final String ACCUEIL_PATH = "/layout/Accueil.fxml";
    private static final String EDT_PATH = "/layout/EDT.fxml";
    private static final String BLOCNOTES_PATH = "/layout/BlocNotes.fxml";
    private static final String TODO_PATH = "/layout/ToDoListe.fxml";
    private static final String ADDNOTE_PATH = "/layout/addNote.fxml";

    //*********************Constructeur*********************//

    /**
     * Constructeur de la classe BlocNotesController
     * @param doc mes documents
     */
    public BlocNotesController(Documents doc){
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
        initializeTxt();
        initializeButton();
        NotesList.setItems(doc.getMonblocnotes());
        NotesList.setCellFactory(l -> new NoteListCell(this));
    }

    /**
     * initialisation des textes
     */
    public void initializeTxt(){
        HomeButton.setText("Home");
        ButtonEDT.setText("EDT");
        ButtonBlocNotes.setText("Bloc-Notes");
        ButtonToDoListe.setText("To-Do Liste");
        ButtonAddNote.setText("Ajouter une Note");
    }

    /**
     * initialisation de l'action sur les bouttons
     */
    public void initializeButton(){
        HomeButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                try {
                    goTo(actionEvent,ACCUEIL_PATH, CSS_PATH, new MainController(doc));
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
        ButtonEDT.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                try {
                    goTo(actionEvent,EDT_PATH,CSS_PATH, new EDTController(doc));
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
        ButtonBlocNotes.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                try {
                    goTo(actionEvent,BLOCNOTES_PATH, NOTECSS_PATH, new BlocNotesController(doc));
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
        ButtonToDoListe.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                try {
                    goTo(actionEvent,TODO_PATH,CSS_PATH,new ToDoListeController(doc));
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
        ButtonAddNote.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                try {
                    addNote(actionEvent);
                }catch (Exception e){
                    e.printStackTrace();
                }
            }
        });
    }

    /**
     * Fonction permettant d'ouvrir une page donnée
     * @param actionEvent action
     * @param PATH lien vers la page
     * @param CSSPATH css de la page
     * @param CTRLPATH controlleur de la page
     * @throws Exception erreur
     */
    public void goTo(ActionEvent actionEvent, String PATH, String CSSPATH, Object CTRLPATH) throws Exception {
        FXMLLoader loader = new FXMLLoader(getClass().getResource(PATH));
        loader.setController(CTRLPATH);
        Parent root2 = loader.load();
        Stage window = (Stage)((Node)actionEvent.getSource()).getScene().getWindow();
        Scene actual = window.getScene();
        Scene scene2 = new Scene(root2, actual.getWidth(), actual.getHeight());
        scene2.getStylesheets().add(getClass().getResource(CSSPATH).toExternalForm());
        window.setScene(scene2);
        window.show();
    }

    /**
     * Fonction permettant d'ajouter une note
     * @param actionEvent action
     * @throws Exception erreur
     */
    public void addNote(ActionEvent actionEvent) throws Exception{
        FXMLLoader loader = new FXMLLoader(getClass().getResource(ADDNOTE_PATH));
        loader.setController(new addNoteController(doc));
        Parent root2 = loader.load();
        Stage window = (Stage)((Node)actionEvent.getSource()).getScene().getWindow();
        final Stage dialog = new Stage();
        dialog.initModality(Modality.APPLICATION_MODAL);
        dialog.initOwner(window);
        Scene dialogScene = new Scene(root2, 400, 300);
        dialog.setScene(dialogScene);
        dialog.show();
    }

}
