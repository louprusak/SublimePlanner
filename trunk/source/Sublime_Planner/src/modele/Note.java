package modele;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class Note implements Serializable {

    //*********************Propriétés / Getter / Setter*********************//

    /**
     * id de la note
     */

    private transient IntegerProperty idNote = new SimpleIntegerProperty();
    public int getId(){return idNote.get();}
    public IntegerProperty idProperty(){return idNote;}
    public void setId(int id){this.idNote.set(id);}

    /**
     * nom de la note
     */

    private transient StringProperty nom = new SimpleStringProperty();
    public String getNom(){return nom.get();}
    public StringProperty nomProperty(){return nom;}
    public void setNom(String nom){this.nom.set(nom);}

    /**
     * text de la note
     */

    private transient StringProperty textNote = new SimpleStringProperty();
    public String getTextNote(){return textNote.get();}
    public StringProperty textNoteProperty(){return textNote;}
    public void setTextNote(String textNote){this.textNote.set(textNote);}

    //*********************Constructeur*********************//

    /**
     * constructeur de la classe Notes
     * @param nom nom de la Notes
     * @param textNote texte de la Notes
     */
    public Note(String nom, String textNote) {
        setNom(nom);
        setTextNote(textNote);
    }

    //*********************Redéfinition*********************//

    /**
     * Redéfinition de la méthode equals de la classe Notes
     * @param obj L'object à comaprer
     * @return true si c'est égal
     */
    @Override
    public boolean equals(Object obj){
        if (this == obj){
            return true;
        }
        if (obj == null || getClass() != obj.getClass()){
            return false;
        }
        Note item = (Note) obj;
        return this.getId() == item.getId() && this.getNom().equals(item.getNom()) && this.getTextNote().equals(item.getTextNote());
    }

    /**
     * Redéfinition de la méthode toString de la classe Notes
     * @return le message à afficher
     */
    @Override
    public String toString(){
        String message = "\t" + this.getId() + " : "+ this.getNom() + "\n\t";
        if (this.getTextNote().equals("")) {
            message += "\tLa note est vide.";
        } else {
            message += "\t" + this.getTextNote();
        }
        return message;
    }

    /**
     * Fonction permettant d'écrire dans un fichier pour la sérialisation
     * @param s objet à écrire
     * @throws IOException erreur
     */
    private void writeObject(ObjectOutputStream s) throws IOException {
        s.writeLong(getId());
        s.writeUTF(getNom());
        s.writeUTF(getTextNote());
    }

    /**
     * Fonction permettant de lire dans un fichier pour la sérialisation
     * @param s objet à écrire
     * @throws IOException erreur
     * @throws ClassNotFoundException erreur
     */
    private void readObject(ObjectInputStream s) throws IOException, ClassNotFoundException {
        setId(s.readInt());
        setNom(s.readUTF());
        setTextNote(s.readUTF());
    }
}
