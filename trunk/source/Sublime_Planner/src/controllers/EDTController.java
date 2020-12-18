package controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;
import modele.Creneau;
import modele.Documents;
import org.w3c.dom.Text;

import java.net.URL;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ResourceBundle;

public class EDTController implements Initializable {

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
    private TextField HeureFin;
    @FXML
    private TextArea Desc;
    @FXML
    private Button ButtonAjout;
    @FXML
    private ListView ListeEvenements;

    public static final int H_SIZE = 1000;
    public static final int V_SIZE = 600;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        initializeTxt();
    }

    public void initializeTxt(){
        HomeButton.setText("Home");
        ButtonEDT.setText("EDT");
        ButtonBlocNotes.setText("Bloc-Notes");
        ButtonToDoListe.setText("To-Do Liste");
        HeureDebut.setPromptText("Heure de début (h:mn)");
        HeureFin.setPromptText("Heure de fin (h:mn)");
        Desc.setPromptText("Description");
        ButtonAjout.setText("Ajouter un événement");
    }

    public void goToToDoListe(ActionEvent actionEvent) throws Exception {
        Parent root2 = FXMLLoader.load(getClass().getResource("/layout/ToDoListe.fxml"));
        Scene scene2 = new Scene(root2, H_SIZE, V_SIZE);
        Stage window = (Stage)((Node)actionEvent.getSource()).getScene().getWindow();
        window.setScene(scene2);
        window.show();
    }

    public void goToEDT(ActionEvent actionEvent) throws Exception {
        Parent root2 = FXMLLoader.load(getClass().getResource("/layout/EDT.fxml"));
        Scene scene2 = new Scene(root2, H_SIZE, V_SIZE);
        Stage window = (Stage)((Node)actionEvent.getSource()).getScene().getWindow();
        window.setScene(scene2);
        window.show();
    }

    public void goToBlocNotes(ActionEvent actionEvent) throws Exception {
        Parent root2 = FXMLLoader.load(getClass().getResource("/layout/BlocNotes.fxml"));
        Scene scene2 = new Scene(root2, H_SIZE, V_SIZE);
        Stage window = (Stage)((Node)actionEvent.getSource()).getScene().getWindow();
        window.setScene(scene2);
        window.show();
    }

    public void goToHome(ActionEvent actionEvent) throws Exception {
        Parent root2 = FXMLLoader.load(getClass().getResource("/layout/Accueil.fxml"));
        Scene scene2 = new Scene(root2, H_SIZE, V_SIZE);
        Stage window = (Stage)((Node)actionEvent.getSource()).getScene().getWindow();
        window.setScene(scene2);
        window.show();
    }

    public void ajoutEvenement(ActionEvent actionEvent) {
        Creneau c;
        try {
            LocalDate ld = DatePicker.getValue();
            LocalDateTime dateDebut = LocalDateTime.of(ld.getYear(), ld.getMonth(), ld.getDayOfMonth(), Integer.parseInt(HeureDebut.getText()), 10);
            LocalDateTime dateFin = LocalDateTime.of(ld.getYear(), ld.getMonth(), ld.getDayOfMonth(), Integer.parseInt(HeureFin.getText()), 10);
            c = new Creneau(Desc.getText(), dateDebut, dateFin);
            System.out.println(c);
        } catch (Exception e){
            System.out.println("erreur");
        }
    }
}
