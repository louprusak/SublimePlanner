package modele;

import java.time.LocalDateTime;

public class Creneau {

    //*********************Attributs*********************//

    private String evenement;

    private LocalDateTime dateDebut;

    private LocalDateTime dateFin;

    //*********************Getter Setter*********************//

    public String getEvenement() {
        return evenement;
    }

    public void setEvenement(String evenement) {
        this.evenement = evenement;
    }

    public LocalDateTime getDateDebut() {
        return dateDebut;
    }

    public void setDateDebut(LocalDateTime dateDebut) {
        this.dateDebut = dateDebut;
    }

    public LocalDateTime getDateFin() {
        return dateFin;
    }

    public void setDateFin(LocalDateTime dateFin) {
        this.dateFin = dateFin;
    }

    //*********************Constructeur*********************//

    public Creneau(String evenement, LocalDateTime dateDebut, LocalDateTime dateFin) {
        this.evenement = evenement;
        this.dateDebut = dateDebut;
        this.dateFin = dateFin;
    }

    //*********************Redéfinition*********************//

    @Override
    public boolean equals(Object obj){
        if (this == obj){
            return true;
        }
        if (obj == null || getClass() != obj.getClass()){
            return false;
        }
        Creneau item = (Creneau) obj;
        return this.getEvenement().equals(item.getEvenement()) && this.getDateDebut().equals(item.getDateDebut()) && this.getDateFin().equals(item.getDateFin());
    }

    @Override
    public String toString(){
        return evenement + "\n\tDate de début : " + dateDebut + "\n\tDate de fin : " +dateFin;
    }

}
