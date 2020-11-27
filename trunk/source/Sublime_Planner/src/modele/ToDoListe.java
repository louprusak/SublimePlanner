package modele;

import java.util.LinkedList;

public class ToDoListe {

    //*********************Attributs*********************//

    private int indiceId = 0;

    private LinkedList<Tache> listTache;

    //*********************Getter Setter*********************//

    public LinkedList<Tache> getListTache() {
        return listTache;
    }

    //*********************Constructeur*********************//

    public ToDoListe() {
        listTache = new LinkedList<>();
    }

    //*********************Fonctions*********************//

    public boolean ajouterUneTache(Tache obj){
        if (obj != null && !listTache.contains(obj)){
            obj.setId(indiceId+1);
            indiceId++;
            listTache.add(obj);
            return listTache.contains(obj);
        }
        return false;
    }

    public boolean supprimerUneTache(Tache obj){
        if (obj != null && listTache.contains(obj)){
            listTache.remove(obj);
            return !listTache.contains(obj);
        }
        return false;
    }

    public boolean modifierUneTache(Tache obj, Tache old){
        if (obj != null && old != null && listTache.contains(old) && !listTache.contains(obj)) {
            obj.setId(old.getId());
            old.setTache(obj.getTache());
            return old.equals(obj);
        }
        return false;
    }

    //*********************Redéfinition*********************//

    @Override
    public String toString(){
        String message = "Ma To Do Liste : ";
        if (listTache.size() == 0){
            message += "\n\t La to do liste est vide.";
        } else {
            StringBuilder messageBuilder = new StringBuilder(message);
            for (Tache tache : listTache){
                messageBuilder.append("\n\t").append(tache.toString());
            }
            message = messageBuilder.toString();
        }
        return message;
    }

}
