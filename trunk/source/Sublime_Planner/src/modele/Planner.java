package modele;

import java.util.LinkedList;

public class Planner {

    //*********************Attributs*********************//

    LinkedList<Creneau> listCreneau;

    //*********************Getter Setter*********************//

    private LinkedList<Creneau> getListCreneau() {
        return listCreneau;
    }

    //*********************Constructeur*********************//

    public Planner() {
        listCreneau = new LinkedList<>();
    }

    //*********************Fonctions*********************//

    public boolean ajouterUnCreneau(Creneau obj){
        if (obj != null){
            listCreneau.add(obj);
            return listCreneau.contains(obj);
        }
        return false;
    }

    public boolean supprimerUnCreneau(Creneau obj){
        if (obj != null && listCreneau.contains(obj)){
            listCreneau.remove(obj);
            return !listCreneau.contains(obj);
        }
        return false;
    }

    public boolean modifierUnCreneau(Creneau obj, Creneau old){
        if (obj != null && old != null && listCreneau.contains(old)) {
            old.setEvenement(obj.getEvenement());
            old.setDateDebut(obj.getDateDebut());
            old.setDateFin(obj.getDateFin());
            return old.equals(obj);
        }
        return false;
    }

    //*********************Redéfinition*********************//

        //string
    @Override
    public String toString(){
        String message = "Mon planneur : ";
        if (listCreneau.size() == 0){
            message += "\n\t le planneur est vide.";
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
