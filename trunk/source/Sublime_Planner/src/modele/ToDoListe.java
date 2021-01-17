package modele;

import javafx.beans.property.SimpleListProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.collections.FXCollections;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class ToDoListe extends SimpleListProperty<Tache> implements Serializable{

    //*********************Propriétés / Getter / Setter*********************//

    /**
     * nom de la liste
     */
    private transient StringProperty nomToDo = new SimpleStringProperty();
    public String getNomToDo(){return nomToDo.get();}
    public StringProperty nomToDoProperty(){return nomToDo;}
    public void setNomToDo(String nom){this.nomToDo.set(nom);}

    //*********************Constructeur*********************//

    /**
     * constructeur de la classe ToDoListe
     * @param nom nom de la liste
     */
    public ToDoListe (String nom){
        super(FXCollections.observableArrayList());
        setNomToDo(nom);
    }

    //*********************Redéfinition*********************//

    /**
     * redéfinition de la méthode add
     * @param item Tache à ajouter
     * @return true si l'ajout a été effectuer et false si non
     */
    @Override
    public boolean add(Tache item){
        int id = 1;
        if (this.size() > 0){
            id = this.get(size()-1).getId()+1;
        }
        item.setId(id);
        return super.add(item);
    }

    /**
     * redéfinition de la méthode set
     * @param index int index dans la liste de l'item à modifier
     * @param item nouvelle Tache
     * @return l'objet modifié
     */
    @Override
    public Tache set(int index, Tache item){
        item.setId(this.get(index).getId());
        return super.set(index, item);
    }

    /**
     * Redéfinition de la méthode toString de la classe ToDoListe
     * @return le message à afficher
     */
    @Override
    public String toString(){
        String message = this.getNomToDo() + " : ";
        if (this.size() == 0){
            message += "\n\t\t La ToDo liste est vide.";
        } else {
            StringBuilder messageBuilder = new StringBuilder(message);
            for (Tache tache : this){
                messageBuilder.append("\n\t\t").append(tache.toString());
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
        s.defaultWriteObject();
        s.writeUTF(getNomToDo());
    }

    /**
     * Fonction permettant de lire dans un fichier pour la sérialisation
     * @param s objet à écrire
     * @throws IOException erreur
     * @throws ClassNotFoundException erreur
     */
    private void readObject(ObjectInputStream s) throws IOException, ClassNotFoundException {
        s.defaultReadObject();
        setNomToDo(s.readUTF());
    }

}
