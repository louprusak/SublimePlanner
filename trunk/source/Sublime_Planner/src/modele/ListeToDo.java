package modele;

import java.util.LinkedList;

public class ListeToDo {

    //*********************Attributs*********************//

    /**
     * Liste de ToDoListe
     */
    private LinkedList<ToDoListe> listeToDo;

    //*********************Getter Setter*********************//

    /**
     * Getter de la liste de ToDoListe
     * @return le contenus de la liste de ToDoListe
     */
    public LinkedList<ToDoListe> getListeToDo() {
        return listeToDo;
    }

    //*********************Constructeur*********************//

    /**
     * Constructeur de la classe ListeToDo
     */
    public ListeToDo(){
        listeToDo = new LinkedList<>();
    }

    //*********************Fonctions*********************//

    /**
     * Fonction permettant d'ajouter une ToDoListe à la liste
     * @param obj ToDoListe à ajouter à la liste
     * @return retourne true si la liste contient l'objet passé en paramètre sinon false
     */
    public boolean ajouterToDoListe(ToDoListe obj){
        if (obj != null && !listeToDo.contains(obj)){
            int id = 0;
            for (ToDoListe todo : listeToDo){
                id = todo.getId();
            }
            obj.setId(id+1);
            listeToDo.add(obj);
            return listeToDo.contains(obj);
        }
        return false;
    }

    /**
     * Fonction permettant de supprimer une ToDoListe à la liste
     * @param obj ToDoListe à supprimer de la liste
     * @return retourne true si la liste ne contient pas l'objet passé en paramètre sinon false
     */
    public boolean supprimerToDoListe(ToDoListe obj){
        if (obj != null && listeToDo.contains(obj)){
            listeToDo.remove(obj);
            return !listeToDo.contains(obj);
        }
        return false;
    }

    /**
     * Fonction permettant de modifier le nom d'une ToDoListe
     * @param obj ToDoListe à modifier
     * @param nom nouveau nom de la ToDoListe
     * @return true si le nom de la ToDoListe est le même que le texte passé en paramètre sinon false
     */
    public boolean modifierNomToDoListe(ToDoListe obj, String nom){
        if (obj != null && listeToDo.contains(obj) && nom != null){
            obj.setNomToDo(nom);
            return obj.getNomToDo().equals(nom);
        }
        return false;
    }

    /**
     * Fonction permettant d'appeler la fonction qui vas ajouter une tache à une liste
     * @param todoListe ToDoListe ou il faut ajouter la tache
     * @param obj Tache à ajouter
     * @return ce que retourne la fonction appelé
     */
    public boolean ajouterUneTache(ToDoListe todoListe, Tache obj){
        return todoListe.ajouterUneTache(obj);
    }

    /**
     * Fonction permettant d'appeler la fonction qui vas supprimer une tache à une liste
     * @param todoListe ToDoListe ou il faut supprimer la tache
     * @param obj Tache à supprimer
     * @return ce que retourne la fonction appelé
     */
    public boolean supprimerUneTache(ToDoListe todoListe, Tache obj){
        return todoListe.supprimerUneTache(obj);
    }

    /**
     * Fonction permettant d'appeler la fonction qui vas modifier une tache à une liste
     * @param todoListe ToDoListe ou il faut modifier la tache
     * @param obj Tache à ajouter
     * @param old Tache à supprimer
     * @return ce que retourne la fonction appelé
     */
    public boolean modifierUneTache(ToDoListe todoListe, Tache obj, Tache old){
        return todoListe.modifierUneTache(obj, old);
    }

    /**
     * Fonction permettant d'appeler la fonction qui vas modifier l'avancement d'une tache à une liste
     * @param todoListe ToDoListe ou il faut modifier l'avancement de la tache
     * @param obj Tache à modifier
     * @return ce que retourne la fonction appelé
     */
    public boolean modifierAvancement(ToDoListe todoListe, Tache obj){
        return todoListe.modifierAvancement(obj);
    }
    //*********************Redéfinition*********************//

    /**
     * Redéfinition de la méthode toString de la classe ListeToDo
     * @return le message à afficher
     */
    @Override
    public String toString(){
        String message = "Mes To Do listes : ";
        if (listeToDo.size() == 0){
            message += "\n\t Mes to do liste sont vide.";
        } else {
            StringBuilder messageBuilder = new StringBuilder(message);
                for (ToDoListe todo : listeToDo){
                messageBuilder.append("\n\t").append(todo.toString());
            }
            message = messageBuilder.toString();
        }
        return message;
    }

}
