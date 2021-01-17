package controllers;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.text.Text;
import javafx.stage.Modality;
import javafx.stage.Stage;
import modele.Documents;
import modele.Tache;
import modele.ToDoListe;
import view.TacheListCell2;
import view.ToDoListCell;

import java.net.URL;
import java.util.ResourceBundle;

public class ToDoListeController implements Initializable {

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
    private ListView<ToDoListe> ListToDo;
    @FXML
    private ListView<Tache> todoListView;
    @FXML
    private Button AddToDoButton;
    @FXML
    private Button AddTacheButton;
    @FXML
    private Button DeleteToDoButton;
    @FXML
    private Text CurrentListName;

    private ToDoListe currentTODO;

    /**
     * Controlleur de la todoliste
     */
    private ToDoListeController controller;

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
    private static final String ADDTODO_PATH = "/layout/addToDoListe.fxml";
    private static final String ADDTACHE_PATH = "/layout/addTache.fxml";

    //*********************Constructeur*********************//

    /**
     * Constructeur de la classe ToDoListe
     * @param doc mes documents
     */
    public ToDoListeController(Documents doc) {
        this.doc=doc;
        this.controller = this;
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

        ListToDo.setItems(doc.getMeslistetodo());
        ListToDo.setCellFactory(l -> new ToDoListCell());
        ListToDo.getSelectionModel().selectedItemProperty().addListener((new ChangeListener<ToDoListe>() {
            @Override
            public void changed(ObservableValue<? extends ToDoListe> observable, ToDoListe oldValue, ToDoListe newValue) {
                todoListView.setItems(newValue);
                todoListView.setCellFactory(l -> new TacheListCell2(controller,doc.getMeslistetodo().indexOf(currentTODO)));
                currentTODO  =  newValue;
                CurrentListName.setText(newValue.getNomToDo());
            }
        }));
    }

    /**
     * initialisation des textes
     */
    public void initializeTxt(){
        HomeButton.setText("Home");
        ButtonEDT.setText("EDT");
        ButtonToDoListe.setText("To-Do Liste");
        ButtonBlocNotes.setText("Bloc-Notes");
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
        AddToDoButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                try {
                    addToDoListe(actionEvent);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
        AddTacheButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                try{
                    addTache(actionEvent);
                }catch(Exception e){
                    e.printStackTrace();
                }
            }
        });
        DeleteToDoButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                try{
                    deleteTodoListe(actionEvent);
                }catch (Exception e){
                    e.printStackTrace();
                }
            }
        });
    }

    /**
     * Fonction permettant de supprimer une ToDoListe
     * @param actionEvent action
     */
    private void deleteTodoListe(ActionEvent actionEvent) {
        if(currentTODO != null){
            doc.getMeslistetodo().remove(currentTODO);
        }
    }

    /**
     * Fonction permettant d'ajouter une tache
     * @param actionEvent action
     * @throws Exception erreur
     */
    private void addTache(ActionEvent actionEvent) throws Exception {
        if(currentTODO != null){
            FXMLLoader loader = new FXMLLoader(getClass().getResource(ADDTACHE_PATH));
            loader.setController(new addTacheController(doc,doc.getMeslistetodo().indexOf(currentTODO)));
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

    /**
     * Fonction permettant d'ajouter une ToDoListe
     * @param actionEvent action
     * @throws Exception erreur
     */
    private void addToDoListe(ActionEvent actionEvent) throws Exception{
        FXMLLoader loader = new FXMLLoader(getClass().getResource(ADDTODO_PATH));
        loader.setController(new addToDoListeController(doc));
        Parent root2 = loader.load();
        Stage window = (Stage)((Node)actionEvent.getSource()).getScene().getWindow();
        final Stage dialog = new Stage();
        dialog.initModality(Modality.APPLICATION_MODAL);
        dialog.initOwner(window);
        Scene dialogScene = new Scene(root2, 400, 300);
        dialog.setScene(dialogScene);
        dialog.show();
    }

    /**
     * Fonction permettant d'afficher une page donnée
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
}
