package modele;

import java.util.LinkedList;

public class ListeToDo {

    //*********************Attributs*********************//

    private int indiceId = 0;

    private LinkedList<ToDoListe> listeToDo;

    //*********************Getter Setter*********************//

    public LinkedList<ToDoListe> getListeToDo() {
        return listeToDo;
    }

    //*********************Constructeur*********************//

    public ListeToDo(){
        listeToDo = new LinkedList<>();
    }

    //*********************Fonctions*********************//

    public boolean ajouterToDoListe(ToDoListe obj){
        if (obj != null && !listeToDo.contains(obj)){
            obj.setId(indiceId+1);
            indiceId++;
            listeToDo.add(obj);
            return listeToDo.contains(obj);
        }
        return false;
    }

    public boolean supprimerToDoListe(ToDoListe obj){
        if (obj != null && listeToDo.contains(obj)){
            listeToDo.remove(obj);
            return !listeToDo.contains(obj);
        }
        return false;
    }

    public boolean modifierNomToDoListe(ToDoListe obj, String nom){
        if (obj != null && listeToDo.contains(obj) && nom != null){
            obj.setNomToDo(nom);
            return obj.getNomToDo().equals(nom);
        }
        return false;
    }

    public boolean ajouterUneTache(ToDoListe todo, Tache obj){
        return todo.ajouterUneTache(obj);
    }

    public boolean supprimerUneTache(ToDoListe todo, Tache obj){
        return todo.supprimerUneTache(obj);
    }

    public boolean modifierUneTache(ToDoListe todo, Tache obj, Tache old){
        return todo.modifierUneTache(obj, old);
    }

    public boolean modifierAvancement(ToDoListe todo, Tache obj){
        return todo.modifierAvancement(obj);
    }
    //*********************Redéfinition*********************//

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
