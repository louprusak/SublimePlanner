package controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import javax.swing.*;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class NoteController implements Initializable {

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

    private static final String CSS_PATH = "../view/main.css";
    private static final String NOTECSS_PATH = "../view/note.css";

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        initializeTxt();
    }

    public void initializeTxt(){
        HomeButton.setText("Home");
        ButtonEDT.setText("EDT");
        ButtonBlocNotes.setText("Bloc-Notes");
        ButtonToDoListe.setText("To-Do Liste");
        ButtonDelete.setText("Supprimer");
        ButtonExport.setText("Exporter en .txt");
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

    public void goToHome(ActionEvent actionEvent) throws Exception {
        Parent root2 = FXMLLoader.load(getClass().getResource("/layout/Accueil.fxml"));
        Stage window = (Stage)((Node)actionEvent.getSource()).getScene().getWindow();
        Scene actual = window.getScene();
        Scene scene2 = new Scene(root2, actual.getWidth(), actual.getHeight());
        scene2.getStylesheets().add(getClass().getResource(CSS_PATH).toExternalForm());
        window.setScene(scene2);
        window.show();
    }

    public void deleteNote(ActionEvent actionEvent) {
    }

    public void export(ActionEvent actionEvent){
        Stage window = (Stage)((Node)actionEvent.getSource()).getScene().getWindow();
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Enregistrer la note sous ...");
        fileChooser.setInitialFileName("Titre_note.txt");
        fileChooser.setInitialDirectory(new File("/"));
        File selectedFile = fileChooser.showSaveDialog(window);
        try{
            FileWriter savefile = new FileWriter("Titre_Note.txt");
            BufferedWriter writer = new BufferedWriter(savefile);
            writer.write("blablabla");
            writer.close();
            JOptionPane.showMessageDialog(null, "File has been saved","File Saved",JOptionPane.INFORMATION_MESSAGE);
        }catch (IOException exception){
            exception.printStackTrace();
        }
    }
}
