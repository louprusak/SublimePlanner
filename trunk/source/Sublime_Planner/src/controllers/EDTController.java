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
import javafx.scene.text.Text;
import javafx.stage.Stage;
import modele.Creneau;
import modele.Documents;
import view.CreneauListCell;
import view.Main;

import java.net.URL;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.*;

public class EDTController implements Initializable {

    //*********************Attributs*********************//

    /**
     * Elements FXML
     */
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

    /**
     * Mes documents
     */
    private Documents doc;
    /**
     * Getter de mes documents
     * @return mes documents
     */
    private Documents getDoc(){return doc;}

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
     * Constructeur de la classe EDTController
     * @param doc mes documents
     */
    public EDTController(Documents doc){
        this.doc = doc;
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
        initializeDate();
        initializeButton();
        ListeEvenements.setItems(doc.getMonplanner());
        ListeEvenements.setCellFactory(l -> new CreneauListCell());
    }

    /**
     * initialisation des textes
     */
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

    /**
     * initialisation de la date
     */
    public void initializeDate(){
        Date date = new Date();
        SimpleDateFormat dateFormat = new SimpleDateFormat("EEEE dd MMM yyyy", Locale.FRANCE);
        String formatted = dateFormat.format(date);
        TextDate.setText(formatted);
    }

    /**
     * initialisation des actions des buttons
     */
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

    /**
     * Fonction permettant d'ouvir une autre page donnée
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
     * Fonction permettent d'ajouter un Creneau
     * @param actionEvent action
     * @throws Exception erreur
     */
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
