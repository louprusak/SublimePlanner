package modele;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

import java.time.LocalDateTime;

public class Creneau {

    //*********************Propriétés / Getter / Setter*********************//

    /**
     * id du Creneau
     */
    private IntegerProperty idCreneau = new SimpleIntegerProperty();
    public int getId(){return idCreneau.get();}
    public IntegerProperty idCreneauProperty(){return idCreneau;}
    public void setId(int id){this.idCreneau.set(id);}

    /**
     * evenement du Creneau
     */
    private StringProperty evenement = new SimpleStringProperty();
    public String getEvenement(){return evenement.get();}
    public StringProperty evenementProperty(){return evenement;}
    public void setEvenement(String evenement){this.evenement.set(evenement);}

    /**
     * date de début de l'évenement
     */
    private LocalDateTime dateDebut;
    public LocalDateTime getDateDebut(){return dateDebut;};
    public void setDateDebut(LocalDateTime ldt){this.dateDebut = ldt;}

    /**
     * date de fin de l'évenement
     */
    private LocalDateTime dateFin;
    public LocalDateTime getDateFin(){return dateFin;};
    public void setDateFin(LocalDateTime ldt){this.dateFin = ldt;}

    //*********************Constructeur*********************//

    /**
     * Constructeur de la classe Creneau
     * @param evenement description du creneau
     * @param dateDebut date de début
     * @param dateFin date de fin
     */
    public Creneau(String evenement, LocalDateTime dateDebut, LocalDateTime dateFin) {
        setEvenement(evenement);
        setDateFin(dateDebut);
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
        return this.getId() + " : " + this.getEvenement()+ "\n\tDate de début : " + getDateDebut() + "\n\tDate de fin : " + getDateFin();
    }

}
