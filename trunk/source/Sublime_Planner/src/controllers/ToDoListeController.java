package controllers;

import javafx.collections.FXCollections;
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
import modele.ToDoListe;
import view.TacheListCell;
import view.ToDoListCell;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

public class ToDoListeController implements Initializable {

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
    private Button AddToDoButton;
    @FXML
    private Button AddTacheButton;
    @FXML
    private Button DeleteToDoButton;
    @FXML
    private Text CurrentListName;

    private Documents doc;
    public Documents getDoc(){return doc;}


    private static final String CSS_PATH = "../view/main.css";
    private static final String NOTECSS_PATH = "../view/note.css";
    private static final String ACCUEIL_PATH = "/layout/Accueil.fxml";
    private static final String EDT_PATH = "/layout/EDT.fxml";
    private static final String BLOCNOTES_PATH = "/layout/BlocNotes.fxml";
    private static final String TODO_PATH = "/layout/ToDoListe.fxml";
    private static final String ADDTODO_PATH = "/layout/addToDoListe.fxml";


    private static List<ToDoListe> listeToDo = new ArrayList<>(List.of(
            new ToDoListe("Catégorie 1"),
            new ToDoListe("Catégorie 2"),
            new ToDoListe("Catégorie 3"),
            new ToDoListe("Catégorie 4"),
            new ToDoListe("Catégorie 5"),
            new ToDoListe("Catégorie 6")
    ));

    public ToDoListeController(Documents doc) {
        this.doc=doc;
    }


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        initializeTxt();
        initializeButton();

        ListToDo.setItems(FXCollections.observableList(doc.getMeslistetodo()));
        ListToDo.setCellFactory(l -> new ToDoListCell());
    }

    public void initializeTxt(){
        HomeButton.setText("Home");
        ButtonEDT.setText("EDT");
        ButtonBlocNotes.setText("Bloc-Notes");
        ButtonToDoListe.setText("To-Do Liste");

        if(ListToDo.getSelectionModel().getSelectedItem() == null){
            CurrentListName.setText("");
        }
        else{
            CurrentListName.textProperty().bind(ListToDo.getSelectionModel().getSelectedItem().nomToDoProperty());
        }

    }

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
    }

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
