package controllers;

import javafx.beans.Observable;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.ListView;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import modele.Creneau;
import modele.Documents;
import modele.Tache;
import view.TacheListCell;
import view.ToDoListCell;

import javax.print.Doc;
import javax.swing.text.Document;
import javax.swing.text.html.CSS;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.*;


public class MainController implements Initializable {
    @FXML
    private Text TodayDate;
    @FXML
    private Button ButtonEDT;
    @FXML
    private Button ButtonBlocNotes;
    @FXML
    private Button ButtonToDoListe;
    @FXML
    private DatePicker DatePicker;
    @FXML
    private ListView<Creneau> TodayPlanning;
    @FXML
    private ListView MainToDoList;

    private Documents doc;
    public Documents getDoc(){return doc;}

    
    private static final String CSS_PATH = "../view/main.css";
    private static final String NOTECSS_PATH = "../view/note.css";

    private static final String EDT_PATH = "/layout/EDT.fxml";
    private static final String BLOCNOTES_PATH = "/layout/BlocNotes.fxml";
    private static final String TODO_PATH = "/layout/ToDoListe.fxml";




    private static List<Creneau> planning = new ArrayList<>(List.of(
            new Creneau("Evenement 1", LocalDateTime.now(),LocalDateTime.now()),
            new Creneau("Evenement 2", LocalDateTime.now(),LocalDateTime.of(2020,01,15,8,0,0)),
            new Creneau("Evenement 3", LocalDateTime.now(),LocalDateTime.of(2020,01,15,8,0,0)),
            new Creneau("Evenement 3", LocalDateTime.now(),LocalDateTime.of(2020,01,15,8,0,0)),
            new Creneau("Evenement 3", LocalDateTime.now(),LocalDateTime.of(2020,01,15,8,0,0)),
            new Creneau("Evenement 3", LocalDateTime.now(),LocalDateTime.of(2020,01,15,8,0,0)),
            new Creneau("Evenement 3", LocalDateTime.now(),LocalDateTime.of(2020,01,15,8,0,0)),
            new Creneau("Evenement 3", LocalDateTime.now(),LocalDateTime.of(2020,01,15,8,0,0)),
            new Creneau("Evenement 3", LocalDateTime.now(),LocalDateTime.of(2020,01,15,8,0,0)),
            new Creneau("Evenement 4", LocalDateTime.now(),LocalDateTime.of(2020,01,15,8,0,0))
    ));

    private ObservableList<Tache> todoliste = FXCollections.observableArrayList(new ArrayList<Tache>(List.of(
            new Tache("Tache numéro 1"),
            new Tache("Tache numéro 1"),
            new Tache("Tache numéro 1"),
            new Tache("Tache numéro 1"),
            new Tache("Tache numéro 1"),
            new Tache("Tache numéro 1"),
            new Tache("Tache numéro 1"),
            new Tache("Tache numéro 1"),
            new Tache("Tache numéro 1"),
            new Tache("Tache numéro 1"),
            new Tache("Tache numéro 1"),
            new Tache("Tache numéro 1")
    ))) ;

    public MainController(Documents doc) {
        this.doc = doc;
    }


    public List<Tache> getTodoliste() {
        return this.todoliste;
    }


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        initializeTxt();
        initializeDate();
        initializeButton();

        TodayPlanning.setItems(FXCollections.observableList(planning));
        //MainToDoList.setItems(FXCollections.observableList(todoliste));

        ArrayList<Tache> liste = new ArrayList<>();

        for(int i=0 ; i<doc.getMeslistetodo().size() ; i++){
            for (int j=0 ; j<doc.getMatodoliste(i).size();j++){
                liste.add(doc.getMatodoliste(i).get(j));
            }
        }

        MainToDoList.setItems(FXCollections.observableList(doc.getMatodoliste(1)));
        MainToDoList.setCellFactory(l -> new TacheListCell(this));
    }

    public void initializeTxt(){
        ButtonEDT.setText("EDT");
        ButtonBlocNotes.setText("Bloc-Notes");
        ButtonToDoListe.setText("To-Do Liste");

    }

    public void initializeButton(){
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
                    goTo(actionEvent, BLOCNOTES_PATH,NOTECSS_PATH, new BlocNotesController(doc));
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
        ButtonToDoListe.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                try {
                    goTo(actionEvent,TODO_PATH, CSS_PATH, new ToDoListeController(doc));
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });

    }

    public void initializeDate(){
        Locale.setDefault(Locale.FRANCE);
        LocalDate ld = LocalDate.now();
        Date date = new Date();
        SimpleDateFormat dateFormat = new SimpleDateFormat("EEEE dd MMM yyyy", Locale.FRANCE);
        String formatted = dateFormat.format(date);
        TodayDate.setText(formatted);
        DatePicker.setValue(ld);
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
