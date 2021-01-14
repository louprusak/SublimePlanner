package controllers;

import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
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
import modele.Planner;
import modele.Tache;
import view.CreneauListCell;
import view.TacheListCell;

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
    private ListView TodayPlanning;
    @FXML
    private ListView MainToDoList;
    
    private static final String CSS_PATH = "../view/main.css";
    private static final String NOTECSS_PATH = "../view/note.css";


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

    private static List<Tache> todoliste = new ArrayList<>(List.of(
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
    ));


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        initializeTxt();
        initializeDate();

        TodayPlanning.setItems(FXCollections.observableList(planning));
        //TodayPlanning.setCellFactory(l -> new CreneauListCell());
        MainToDoList.setItems(FXCollections.observableList(todoliste));
        MainToDoList.setCellFactory(l -> new TacheListCell());
    }

    public void initializeTxt(){
        ButtonEDT.setText("EDT");
        ButtonBlocNotes.setText("Bloc-Notes");
        ButtonToDoListe.setText("To-Do Liste");

    }

    public void initializeDate(){
        Locale.setDefault(Locale.FRANCE);
        LocalDate ld = LocalDate.now();
        String dayOfWeek = ld.getDayOfWeek().toString();
        int dayOfMonth = ld.getDayOfMonth();
        String month = ld.getMonth().toString();
        int year = ld.getYear();

        String message = dayOfWeek + " " + dayOfMonth + " " + month + " " + year;

        TodayDate.setText(message);

        DatePicker.setValue(LocalDate.now());
    }

    public void goToToDoListe(ActionEvent actionEvent) throws Exception {
        Parent root2 = FXMLLoader.load(getClass().getResource("/layout/ToDoListe.fxml"));
        Stage window = (Stage)((Node)actionEvent.getSource()).getScene().getWindow();
        Scene actual = window.getScene();
        Scene scene2 = new Scene(root2, actual.getWidth(), actual.getHeight());
        scene2.getStylesheets().add(getClass().getResource(CSS_PATH).toExternalForm());
        window.setScene(scene2);
        window.show();
    }

    public void goToEDT(ActionEvent actionEvent) throws Exception {
        Parent root2 = FXMLLoader.load(getClass().getResource("/layout/EDT.fxml"));
        Stage window = (Stage)((Node)actionEvent.getSource()).getScene().getWindow();
        Scene actual = window.getScene();
        Scene scene2 = new Scene(root2, actual.getWidth(), actual.getHeight());
        scene2.getStylesheets().add(getClass().getResource(CSS_PATH).toExternalForm());
        window.setScene(scene2);
        window.show();
    }

    public void goToBlocNotes(ActionEvent actionEvent) throws Exception {
        Parent root2 = FXMLLoader.load(getClass().getResource("/layout/BlocNotes.fxml"));
        Stage window = (Stage)((Node)actionEvent.getSource()).getScene().getWindow();
        Scene actual = window.getScene();
        Scene scene2 = new Scene(root2, actual.getWidth(), actual.getHeight());
        scene2.getStylesheets().add(getClass().getResource(NOTECSS_PATH).toExternalForm());
        window.setScene(scene2);
        window.show();
    }


}
