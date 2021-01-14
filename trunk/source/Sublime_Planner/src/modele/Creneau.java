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
     * hour de début
     */
    private IntegerProperty hourDebut = new SimpleIntegerProperty();
    public int getHourDebut(){return hourDebut.get();}
    public IntegerProperty hourDebutProperty(){return hourDebut;}
    public void setHourDebut(int hourDebut){this.hourDebut.set(hourDebut);}

    /**
     * minute de début
     */
    private IntegerProperty minDebut = new SimpleIntegerProperty();
    public int getMinDebut(){return minDebut.get();}
    public IntegerProperty minDebutProperty(){return minDebut;}
    public void setMinDebut(int minDebut){this.minDebut.set(minDebut);}

    /**
     * hour de début
     */
    private IntegerProperty hourFin = new SimpleIntegerProperty();
    public int getHourFin(){return hourFin.get();}
    public IntegerProperty hourFinProperty(){return hourFin;}
    public void setHourFin(int hourFin){this.hourFin.set(hourFin);}

    /**
     * minute de début
     */
    private IntegerProperty minFin = new SimpleIntegerProperty();
    public int getMinFin(){return minFin.get();}
    public IntegerProperty minFinProperty(){return minFin;}
    public void setMinFin(int minFin){this.minFin.set(minFin);}

    /**
     * date de début de l'évenement
     */

    private LocalDateTime dateDebut;
    public LocalDateTime getDateDebut(){return dateDebut;};
    public void setDateDebut(LocalDateTime ldt){
        setHourDebut(ldt.getHour());
        setMinDebut(ldt.getMinute());
        this.dateDebut = ldt;
    }

    /**
     * date de fin de l'évenement
     */
    private LocalDateTime dateFin;
    public LocalDateTime getDateFin(){return dateFin;};
    public void setDateFin(LocalDateTime ldt){
        setHourFin(ldt.getHour());
        setMinFin(ldt.getMinute());
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
