package controllers;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.text.Text;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import modele.Documents;
import modele.Note;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class NoteController implements Initializable {

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
    private Button ButtonDelete;
    @FXML
    private Button ButtonExport;
    @FXML
    private Button BackButton;
    @FXML
    private Text NoteTitle;
    @FXML
    private TextArea TextNote;

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
     * ma Note
     */
    private Note note;
    /**
     * Getter de ma note
     * @return ma note
     */
    public Note getNote(){return note;}

    /**
     * Attribut contenant tous les documents
     */
    private static final String CSS_PATH = "../view/main.css";
    private static final String NOTECSS_PATH = "../view/note.css";
    private static final String ACCUEIL_PATH = "/layout/Accueil.fxml";
    private static final String EDT_PATH = "/layout/EDT.fxml";
    private static final String BLOCNOTES_PATH = "/layout/BlocNotes.fxml";
    private static final String TODO_PATH = "/layout/ToDoListe.fxml";

    //*********************Constructeur*********************//

    /**
     * Constructeur de la classe NoteController
     * @param doc mes documents
     * @param item ma note
     */
    public NoteController(Documents doc, Note item){
        this.doc =doc;
        this.note = item;
    }

    //*********************Fonctions*********************//

    /**
     * initialisation de la partie graphique
     * @param url url
     * @param resourceBundle ressources
     */
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        initializeTxt();
        initializeButton();
    }

    /**
     * initialisation des textes
     */
    public void initializeTxt(){
        HomeButton.setText("Home");
        ButtonEDT.setText("EDT");
        ButtonBlocNotes.setText("Bloc-Notes");
        ButtonToDoListe.setText("To-Do Liste");
        ButtonDelete.setText("Supprimer");
        ButtonExport.setText("Exporter en .txt");
        NoteTitle.textProperty().bind(note.nomProperty());
        TextNote.setWrapText(true);
        TextNote.textProperty().bindBidirectional(note.textNoteProperty());
    }

    /**
     * initialisation des actions des buttons
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
        BackButton.setOnAction(new EventHandler<ActionEvent>() {
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
        ButtonDelete.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                try {
                    deleteNote(actionEvent);
                }catch (Exception e){
                    e.printStackTrace();
                }
            }
        });
        ButtonExport.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                try {
                    export(actionEvent);
                }catch (Exception e){
                    e.printStackTrace();
                }
            }
        });
    }

    /**
     * Fonction permettant d'ouvrir une page donn??e
     * @param actionEvent action
     * @param PATH liens vers la page
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
     * Fonction permettant de supprimer une Note
     * @param actionEvent action
     * @throws Exception erreur
     */
    public void deleteNote(ActionEvent actionEvent) throws Exception {
        doc.getMonblocnotes().remove(note);
        goTo(actionEvent,BLOCNOTES_PATH,NOTECSS_PATH,new BlocNotesController(doc));
    }

    /**
     * Fonction permettant d'exporter une note
     * @param actionEvent action
     */
    public void export(ActionEvent actionEvent){
        String NoteTitle = note.getNom();
        String NoteText = note.getTextNote();
        Stage window = (Stage)((Node)actionEvent.getSource()).getScene().getWindow();
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Enregistrer la note sous ...");
        fileChooser.setInitialFileName(NoteTitle+".txt");
        fileChooser.setInitialDirectory(new File("/"));
        File selectedFile = fileChooser.showSaveDialog(window);
        try{
            FileWriter savefile = new FileWriter(selectedFile);
            BufferedWriter writer = new BufferedWriter(savefile);
            writer.write(NoteText);
            writer.close();
        }catch (IOException exception){
            exception.printStackTrace();
        }
    }

}
