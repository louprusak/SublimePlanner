package modele;

import javafx.beans.Observable;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.io.Serializable;
import java.util.LinkedList;

public class Documents implements Serializable {

    //*********************Attributs*********************//

    /**
     * Attribut contenant les todolistes
     */
    private ObservableList<ToDoListe> malistetodo;

    /**
     * Attibut contenant le planner
     */
    private Planner monplanner;

    /**
     * Attribut contenant le bloc note
     */
    private BlocNotes monblocnotes;

    //*********************Getter Setter*********************//

    /**
     * Getter de la todoliste
     * @return le contenus de ma todoliste
     */
    public ObservableList<ToDoListe> getMeslistetodo() {
        return malistetodo;
    }

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


}
