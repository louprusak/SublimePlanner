package modele;

import javafx.beans.property.*;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.time.LocalDateTime;

public class Creneau implements Serializable {

    //*********************Propriétés / Getter / Setter*********************//

    /**
     * id du Creneau
     */
    private transient IntegerProperty idCreneau = new SimpleIntegerProperty();
    public int getId(){return idCreneau.get();}
    public IntegerProperty idCreneauProperty(){return idCreneau;}
    public void setId(int id){this.idCreneau.set(id);}

    /**
     * evenement du Creneau
     */
    private transient StringProperty evenement = new SimpleStringProperty();
    public String getEvenement(){return evenement.get();}
    public StringProperty evenementProperty(){return evenement;}
    public void setEvenement(String evenement){this.evenement.set(evenement);}

    /**
     * date de début de l'évenement
     */

    private transient LocalDateTime dateDebut;
    public LocalDateTime getDateDebut(){return dateDebut;};
    public void setDateDebut(LocalDateTime ldt){
        this.dateDebut = ldt;
    }

    /**
     * date de fin de l'évenement
     */
    private transient LocalDateTime dateFin;
    public LocalDateTime getDateFin(){return dateFin;};
    public void setDateFin(LocalDateTime ldt){
        this.dateFin = ldt;
    }

    //*********************Constructeur*********************//

    /**
     * Constructeur de la classe Creneau
     * @param evenement description du creneau
     * @param dateDebut date de début
     * @param dateFin date de fin
     */
    public Creneau(String evenement, LocalDateTime dateDebut, LocalDateTime dateFin) {
        setEvenement(evenement);
        setDateDebut(dateDebut);
        setDateFin(dateFin);
    }

    //*********************Redéfinition*********************//

    /**
     * Redéfinition de la méthode equals de la classe Creneau
     * @param obj Object a comparer
     * @return true si c'est égale sinon false
     */
    @Override
    public boolean equals(Object obj){
        if (this == obj){
            return true;
        }
        if (obj == null || getClass() != obj.getClass()){
            return false;
        }
        Creneau item = (Creneau) obj;
        return this.getId() == item.getId() && this.getEvenement().equals(item.getEvenement()) && this.getDateDebut().equals(item.getDateDebut()) && this.getDateFin().equals(item.getDateFin());
    }

    /**
     * Redéfinition de la méthode toString de la classe Creneau
     * @return le message à afficher
     */
    @Override
    public String toString(){
        int heureDebut = this.getDateDebut().getHour();
        int minuteDebut = this.getDateDebut().getMinute();
        int heureFin = this.getDateFin().getHour();
        int minuteFin = this.getDateFin().getMinute();

        String message = "- "+getEvenement() + "\n\tDe " + heureDebut+"h"+minuteDebut + " à "+ heureFin+"h"+minuteFin;
        return message;
        //return this.getId() + " : " + this.getEvenement()+ "\n\tDate de début : " + getDateDebut() + "\n\tDate de fin : " + getDateFin();
    }

    /**
     * deuxième fonction toString
     * @return le message à afficher
     */
    public String toString2(){
        int heureDebut = this.getDateDebut().getHour();
        int minuteDebut = this.getDateDebut().getMinute();
        int heureFin = this.getDateFin().getHour();
        int minuteFin = this.getDateFin().getMinute();

        String message = "- "+getEvenement() +"\n\tLe "+ getDateDebut().getDayOfMonth()+"/"+ getDateDebut().getMonthValue()+"/"+getDateDebut().getYear() + "\n\tDe " + heureDebut+"h"+minuteDebut + " à "+ heureFin+"h"+minuteFin;
        return message;
        //return this.getId() + " : " + this.getEvenement()+ "\n\tDate de début : " + getDateDebut() + "\n\tDate de fin : " + getDateFin();
    }

    /**
     * Fonction permettant d'écrire dans un fichier pour la sérialisation
     * @param s objet à écrire
     * @throws IOException erreur
     */
    private void writeObject(ObjectOutputStream s) throws IOException {
        s.writeInt(getId());
        s.writeUTF(getEvenement());
        s.writeObject(getDateDebut());
        s.writeObject(getDateFin());
    }

    /**
     * Fonction permettant de lire dans un fichier pour la sérialisation
     * @param s objet à écrire
     * @throws IOException erreur
     * @throws ClassNotFoundException erreur
     */
    private void readObject(ObjectInputStream s) throws IOException, ClassNotFoundException {
        this.idCreneau = new SimpleIntegerProperty();
        this.evenement = new SimpleStringProperty();
        setId(s.readInt());
        setEvenement(s.readUTF());
        setDateDebut((LocalDateTime) s.readObject());
        setDateFin((LocalDateTime) s.readObject());
    }

}
