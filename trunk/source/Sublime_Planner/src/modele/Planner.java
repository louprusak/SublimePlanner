package modele;

import java.util.LinkedList;

public class Planner {

    //*********************Attributs*********************//

    /**
     * Attribut contenant le dernier id utiliser par un Creneau pour attribuer à chaque Creneau un id unique
     */
    private int indiceId = 0;

    /**
     * liste de Creneau
     */
    private LinkedList<Creneau> listCreneau;

    //*********************Getter Setter*********************//

    /**
     * Getter de la liste de Creneau
     * @return le contenus de la liste de creneau
     */
    public LinkedList<Creneau> getListCreneau() {
        return listCreneau;
    }

    //*********************Constructeur*********************//

    /**
     * Constructeur de la classe Planneur
     */
    public Planner() {
        listCreneau = new LinkedList<>();
    }

    //*********************Fonctions*********************//

    /**
     * Fonction permettant d'ajouter un Creneau à la liste
     * @param obj Creneau à ajouter à la liste
     * @return retourne true si la liste de Creneau contient le Creneau donné en paramètre sinon false
     */
    public boolean ajouterUnCreneau(Creneau obj){
        if (obj != null){
            obj.setId(indiceId+1);
            indiceId++;
            listCreneau.add(obj);
            return listCreneau.contains(obj);
        }
        return false;
    }

    /**
     * Fonction permettant de supprimer un Creneau à la liste
     * @param obj Creneau à supprimer de la liste
     * @return retourne true si la liste de Creneau ne contient pas le Creneau donné en paramètre sinon false
     */
    public boolean supprimerUnCreneau(Creneau obj){
        if (obj != null && listCreneau.contains(obj)){
            listCreneau.remove(obj);
            return !listCreneau.contains(obj);
        }
        return false;
    }

    /**
     * Fonction permettant de modifier un Creneau à la liste
     * @param obj Creneau à ajouter à liste
     * @param old Creneau à supprimer de la liste
     * @return retourne true si la liste de Creneau contient le Creneau donné en paramètre sinon false
     */
    public boolean modifierUnCreneau(Creneau obj, Creneau old){
        if (obj != null && old != null && listCreneau.contains(old)) {
            obj.setId(old.getId());
            old.setEvenement(obj.getEvenement());
            old.setDateDebut(obj.getDateDebut());
            old.setDateFin(obj.getDateFin());
            return old.equals(obj);
        }
        return false;
    }

    //*********************Redéfinition*********************//

    /**
     * Redéfinition de la méthode toString de la classe Planner
     * @return message à afficher
     */
    @Override
    public String toString(){
        String message = "Mon planneur : ";
        if (listCreneau.size() == 0){
            message += "\n\t Le planneur est vide.";
        } else {
            StringBuilder messageBuilder = new StringBuilder(message);
            for (Creneau creneau : listCreneau){
                messageBuilder.append("\n").append(creneau.toString());
            }
            message = messageBuilder.toString();
        }
        return message;
    }

}
