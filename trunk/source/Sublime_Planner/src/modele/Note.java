package modele;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Note {

    //*********************Propriétés / Getter / Setter*********************//

    /**
     * Propriété JavaFx de l'ID de la note
     */
    private IntegerProperty idNote = new SimpleIntegerProperty();
    public int getId(){return idNote.get();}
    public IntegerProperty idProperty(){return idNote;}
    public void setId(int id){this.idNote.set(id);}

    /**
     * Propriété JavaFx du nom de la note
     */
    private StringProperty nom = new SimpleStringProperty();
    public String getNom(){return nom.get();}
    public StringProperty nomProperty(){return nom;}
    public void setNom(String nom){this.nom.set(nom);}

    /**
     * Propriété JavaFx du text / contenu de la note
     */
    private StringProperty textNote = new SimpleStringProperty();
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
        String message =  this.getId() + " : "+ this.getNom() + "\n\t";
        if (this.getTextNote().equals("")) {
            message += "La note est vide.";
        } else {
            message += this.getTextNote();
        }
        return message;
    }

}
