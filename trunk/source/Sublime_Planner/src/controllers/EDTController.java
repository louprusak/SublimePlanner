package controllers;

import javafx.beans.binding.Bindings;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.util.converter.DateStringConverter;
import modele.Creneau;
import modele.Documents;
import view.CreneauListCell;
import view.Main;

import javax.swing.text.html.CSS;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.*;

public class EDTController implements Initializable {
    @FXML
    private Text TextDate;
    @FXML
    private Button HomeButton;
    @FXML
    private Button ButtonEDT;
    @FXML
    private Button ButtonBlocNotes;
    @FXML
    private Button ButtonToDoListe;
    @FXML
    private DatePicker DatePicker;
    @FXML
    private TextField HeureDebut;
    @FXML
    private TextField MinuteDebut;
    @FXML
    private TextField HeureFin;
    @FXML
    private TextField MinuteFin;
    @FXML
    private TextArea Desc;
    @FXML
    private Button ButtonAjout;
    @FXML
    private ListView ListeEvenements;
    private Documents doc;
    private Documents getDoc(){return doc;}

    private static final String CSS_PATH = "../view/main.css";
    private static final String NOTECSS_PATH = "../view/note.css";
    private static final String ACCUEIL_PATH = "/layout/Accueil.fxml";
    private static final String EDT_PATH = "/layout/EDT.fxml";
    private static final String BLOCNOTES_PATH = "/layout/BlocNotes.fxml";
    private static final String TODO_PATH = "/layout/ToDoListe.fxml";

    private static List<Creneau> planning = new ArrayList<>(List.of(
            new Creneau("Evenement 1", LocalDateTime.now(),LocalDateTime.of(2020,01,15,8,0,0)),
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

    public EDTController(Documents doc){
        this.doc = doc;
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        initializeTxt();
        initializeDate();
        initializeButton();

        ListeEvenements.setItems(FXCollections.observableList(planning));

    }

    public void initializeTxt(){
        HomeButton.setText("Home");
        ButtonEDT.setText("EDT");
        ButtonBlocNotes.setText("Bloc-Notes");
        ButtonToDoListe.setText("To-Do Liste");
        HeureDebut.setPromptText("Heure de début");
        MinuteDebut.setPromptText("Minutes début");
        HeureFin.setPromptText("Heure de fin");
        MinuteFin.setPromptText("Minutes fin");
        Desc.setPromptText("Description");
        ButtonAjout.setText("Ajouter un événement");


    }

    public void initializeDate(){
        Date date = new Date();

        SimpleDateFormat dateFormat = new SimpleDateFormat("EEEE dd MMM yyyy", Locale.FRANCE);
        String formatted = dateFormat.format(date);

        TextDate.setText(formatted);

        /*Locale.setDefault(Locale.FRANCE);
        DatePicker.setValue(LocalDate.now());
        Date date = Date.from(DatePicker.getValue().atStartOfDay(ZoneId.systemDefault()).toInstant());
        TextDate.textProperty().bind(Bindings.createStringBinding(() ->
                date.format(myObject.myDateProperty().get()), myObject.myDateProperty()));
        //TextDate.textProperty().bindBidirectional(DatePicker.valueProperty().getValue(),new DateStringConverter());*/
    }

    public void initializeButton(){

        HomeButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                try {
                    goTo(actionEvent,ACCUEIL_PATH,CSS_PATH,new MainController(doc));
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
        ButtonEDT.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                try {
                    goTo(actionEvent,EDT_PATH,CSS_PATH,new EDTController(doc));
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
        ButtonBlocNotes.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                try {
                    goTo(actionEvent,BLOCNOTES_PATH,NOTECSS_PATH,new BlocNotesController(doc));
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
        ButtonAjout.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                try {
                    ajoutEvenement(actionEvent);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });

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

    public void ajoutEvenement(ActionEvent actionEvent) throws Exception {
        Creneau c;
        try {
            LocalDate ld = DatePicker.getValue();
            try {
                LocalDateTime dateDebut = LocalDateTime.of(ld.getYear(), ld.getMonth(), ld.getDayOfMonth(), Integer.parseInt(HeureDebut.getText()), Integer.parseInt(MinuteDebut.getText()));
                try {
                    LocalDateTime dateFin = LocalDateTime.of(ld.getYear(), ld.getMonth(), ld.getDayOfMonth(), Integer.parseInt(HeureFin.getText()), Integer.parseInt(MinuteFin.getText()));
                    try {
                        if (!Desc.getText().equals("")){
                            c = new Creneau(Desc.getText(), dateDebut, dateFin);
                            Main.doc.getMonplanner().add(c);
                            System.out.println(Main.doc.toString());
                        } else {
                            System.out.println("Erreur description vide.");
                        }
                    } catch (Exception e){
                        System.out.println("Erreur de l'ajout.");
                    }
                } catch (Exception e){
                    System.out.println("Erreur dans la date de fin.");
                }
            } catch (Exception e){
                System.out.println("Erreur dans la date de début.");
            }
        } catch (Exception e){
            System.out.println("Erreur dans le date picker.");
        }
    }
}
