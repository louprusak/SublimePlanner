package modele;

import java.time.LocalDateTime;

public class Creneau {

    //*********************Attributs*********************//

    /**
     * id du Creneau
     */
    private int id;

    /**
     * evenement du Creneau
     */
    private String evenement;

    /**
     * date de début de l'évenement
     */
    private LocalDateTime dateDebut;

    /**
     * date de fin de l'évenement
     */
    private LocalDateTime dateFin;

    //*********************Getter Setter*********************//

    /**
     * Getter de l'id
     * @return l'id
     */
    public int getId(){
        return id;
    }

    /**
     * Setter de l'id
     * @param id nouveau id
     */
    public void setId(int id){
        this.id =id;
    }

    /**
     * Getter de l'évenement
     * @return l'évenement
     */
    public String getEvenement() {
        return evenement;
    }

    /**
     * Setter de l'évenement
     * @param evenement nouveau évenement
     */
    public void setEvenement(String evenement) {
        this.evenement = evenement;
    }

    /**
     * Getter de la date de début
     * @return la date de début
     */
    public LocalDateTime getDateDebut() {
        return dateDebut;
    }

    /**
     * Setter de la date de début
     * @param dateDebut nouvelle date de début
     */
    public void setDateDebut(LocalDateTime dateDebut) {
        this.dateDebut = dateDebut;
    }

    /**
     * Getter de la date de fin
     * @return la date de fin
     */
    public LocalDateTime getDateFin() {
        return dateFin;
    }

    /**
     * Setter de la date de fin
     * @param dateFin nouvelle date de fin
     */
    public void setDateFin(LocalDateTime dateFin) {
        this.dateFin = dateFin;
    }

    //*********************Constructeur*********************//

    /**
     * Constructeur de la classe Creneau
     * @param evenement description du creneau
     * @param dateDebut date de début
     * @param dateFin date de fin
     */
    public Creneau(String evenement, LocalDateTime dateDebut, LocalDateTime dateFin) {
        this.evenement = evenement;
        this.dateDebut = dateDebut;
        this.dateFin = dateFin;
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
        return id + " : " + evenement + "\n\tDate de début : " + dateDebut + "\n\tDate de fin : " +dateFin;
    }

}
