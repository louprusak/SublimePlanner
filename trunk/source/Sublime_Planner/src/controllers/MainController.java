package controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.net.URL;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;
import java.util.Locale;
import java.util.ResourceBundle;



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





    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        initializeTxt();
        initializeDate();
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


}
