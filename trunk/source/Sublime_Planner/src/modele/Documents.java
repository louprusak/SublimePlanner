package modele;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Documents implements Serializable {

    //*********************Attributs*********************//

    /**
     * Attribut contenant les todolistes
     */
    private transient ObservableList<ToDoListe> malistetodo;

    /**
     * Attibut contenant le planner
     */
    private transient Planner monplanner;

    /**
     * Attribut contenant le bloc note
     */
    private transient BlocNotes monblocnotes;

    //*********************Getter Setter*********************//

    /**
     * Getter de la todoliste
     * @return le contenus de ma todoliste
     */
    public ObservableList<ToDoListe> getMeslistetodo() {
        return malistetodo;
    }

    /**
     * Getter permettant de donner une liste en particulier
     * @param index index de la liste
     * @return le contenus de la liste
     */
    public ToDoListe getMatodoliste(int index){return malistetodo.get(index);}

    /**
     * Getter du planner
     * @return le contenus de mon planner
     */
    public Planner getMonplanner() {
        return monplanner;
    }

    /**
     * Getter du bloc note
     * @return le contenus de mon bloc note
     */
    public BlocNotes getMonblocnotes() {
        return monblocnotes;
    }

    //*********************Constructeur*********************//

    /**
     * Constructeur de ma classe Documents
     */
    public Documents() {
        malistetodo = FXCollections.observableArrayList();

        monplanner = new Planner();
        monblocnotes = new BlocNotes();
    }

    //*********************Redéfinition*********************//

    /**
     * Redéfinition de la méthode toString de la classe Documents
     * @return le message permettant d'afficher mes documents
     */
    @Override
    public String toString(){
        return this.toStringListeToDoListe() + "\n" + monplanner.toString() + "\n" + monblocnotes.toString();
    }

    /**
     * fonction toString de la liste de To Do liste
     * @return le message a afficher
     */
    public String toStringListeToDoListe(){
        String message = "Ma liste de ToDo liste : ";
        if (malistetodo.size() == 0){
            message += "\n\t Il n'y a pas de ToDo liste.";
        } else {
            StringBuilder messageBuilder = new StringBuilder(message);
            for(ToDoListe todo : malistetodo){
                messageBuilder.append("\n\t").append(todo.toString());
            }
            message = messageBuilder.toString();
        }
        return message;
    }

    /**
     * Fonction permettant d'écrire dans un fichier pour la sérialisation
     * @param s objet à écrire
     * @throws IOException erreur
     */
    private void writeObject(ObjectOutputStream s) throws IOException {
        System.out.println("Je suis passé dans le writeobject de Documents");
        s.writeObject(new ArrayList<ToDoListe>(malistetodo));
        s.writeObject(new ArrayList<Creneau>(monplanner.get()));
        s.writeObject(new ArrayList<Note>(monblocnotes.get()));
    }

    /**
     * Fonction permettant de lire dans un fichier pour la sérialisation
     * @param s objet à écrire
     * @throws IOException erreur
     * @throws ClassNotFoundException erreur
     */
    private void readObject(ObjectInputStream s) throws IOException, ClassNotFoundException {
        System.out.println("Je suis passé dans le read Object de Documents");
        List<ToDoListe> listToDoListe = (List<ToDoListe>) s.readObject();
        malistetodo = FXCollections.observableList(listToDoListe);

        ArrayList<Creneau> planner = (ArrayList<Creneau>) s.readObject();
        monplanner = new Planner(FXCollections.observableList(planner));

        ArrayList<Note> blocNotes = (ArrayList<Note>) s.readObject();
        monblocnotes = new BlocNotes(FXCollections.observableList(blocNotes));

    }

}
