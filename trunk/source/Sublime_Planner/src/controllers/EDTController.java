package controllers;

import javafx.beans.binding.Bindings;
import javafx.event.ActionEvent;
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
import view.Main;

import java.net.URL;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Locale;
import java.util.ResourceBundle;

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



    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        initializeTxt();
        initializeDate();

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
        Locale.setDefault(Locale.FRANCE);
        DatePicker.setValue(LocalDate.now());
        TextDate.textProperty().bind(Bindings.format("%s %d %s %d",DatePicker.valueProperty().getValue().getDayOfWeek(),
                DatePicker.valueProperty().getValue().getDayOfMonth(),DatePicker.valueProperty().getValue().getMonth(),
                DatePicker.valueProperty().getValue().getYear()));

        //TextDate.textProperty().bindBidirectional(DatePicker.valueProperty().getValue(),new DateStringConverter());
    }

    public void goToToDoListe(ActionEvent actionEvent) throws Exception {
        Parent root2 = FXMLLoader.load(getClass().getResource("/layout/ToDoListe.fxml"));
        Stage window = (Stage)((Node)actionEvent.getSource()).getScene().getWindow();
        Scene actual = window.getScene();
        Scene scene2 = new Scene(root2, actual.getWidth(), actual.getHeight());
        window.setScene(scene2);
        window.show();
    }

    public void goToEDT(ActionEvent actionEvent) throws Exception {
        Parent root2 = FXMLLoader.load(getClass().getResource("/layout/EDT.fxml"));
        Stage window = (Stage)((Node)actionEvent.getSource()).getScene().getWindow();
        Scene actual = window.getScene();
        Scene scene2 = new Scene(root2, actual.getWidth(), actual.getHeight());
        window.setScene(scene2);
        window.show();
    }

    public void goToBlocNotes(ActionEvent actionEvent) throws Exception {
        Parent root2 = FXMLLoader.load(getClass().getResource("/layout/BlocNotes.fxml"));
        Stage window = (Stage)((Node)actionEvent.getSource()).getScene().getWindow();
        Scene actual = window.getScene();
        Scene scene2 = new Scene(root2, actual.getWidth(), actual.getHeight());
        window.setScene(scene2);
        window.show();
    }

    public void goToHome(ActionEvent actionEvent) throws Exception {
        Parent root2 = FXMLLoader.load(getClass().getResource("/layout/Accueil.fxml"));
        Stage window = (Stage)((Node)actionEvent.getSource()).getScene().getWindow();
        Scene actual = window.getScene();
        Scene scene2 = new Scene(root2, actual.getWidth(), actual.getHeight());
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
                            Main.doc.getMonplanner().ajouterUnCreneau(c);
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
