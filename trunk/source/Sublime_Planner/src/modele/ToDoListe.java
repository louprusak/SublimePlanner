package modele;

import java.util.LinkedList;

public class ToDoListe {

    //*********************Attributs*********************//

    private int id;

    private String nomToDo;

    private int indiceId = 0;

    private LinkedList<Tache> listTache;

    //*********************Getter Setter*********************//


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNomToDo() {
        return nomToDo;
    }

    public void setNomToDo(String nomToDo) {
        this.nomToDo = nomToDo;
    }

    public LinkedList<Tache> getListTache() {
        return listTache;
    }

    //*********************Constructeur*********************//

    public ToDoListe(String nomToDo) {
        this.nomToDo = nomToDo;
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

    public boolean modifierAvancement(Tache obj){
        if (obj != null && listTache.contains(obj)){
            obj.setAvancement(!obj.getAvancement());
            return true;
        }
        return false;
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
        ToDoListe item = (ToDoListe) obj;
        return this.getId() == item.getId();
    }

    @Override
    public String toString(){
        String message = nomToDo + " : ";
        if (listTache.size() == 0){
            message += "\n\t La to do liste est vide.";
        } else {
            StringBuilder messageBuilder = new StringBuilder(message);
            for (Tache tache : listTache){
                messageBuilder.append("\n\t\t").append(tache.toString());
            }
            message = messageBuilder.toString();
        }
        return message;
    }

}
