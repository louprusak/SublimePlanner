package modele;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

import java.util.LinkedList;

public class ToDoListe {

    //*********************Attributs*********************//

    /**
     * id de la ToDoListe
     */
    private IntegerProperty idToDo = new SimpleIntegerProperty();
    public int getId(){return idToDo.get();}
    public IntegerProperty idToDo(){return idToDo;}
    public void setId(int id){this.idToDo.set(id);}

    /**
     * nom de la ToDoListe
     */
    private StringProperty nomToDo = new SimpleStringProperty();
    public String getNomToDo(){return nomToDo.get();}
    public StringProperty nomToDoProperty(){return nomToDo;}
    public void setNomToDo(String desc){this.nomToDo.set(desc);}

    /**
     * liste de Tache
     */
    private LinkedList<Tache> listTache;

    //*********************Getter Setter*********************//



    /**
     * Getter de la liste
     * @return la liste de Tache
     */
    public LinkedList<Tache> getListTache() {
        return listTache;
    }

    //*********************Constructeur*********************//

    /**
     * Constructeur de la classe ToDoListe
     * @param nomToDo nom de la ToDoListe
     */
    public ToDoListe(String nomToDo) {
        setNomToDo(nomToDo);
        listTache = new LinkedList<>();
    }

    //*********************Fonctions*********************//

    /**
     * Fonction permettant d'ajouter une Tache
     * @param obj Tache à jouter
     * @return true si la Tache à été ajouté sinon false
     */
    public boolean ajouterUneTache(Tache obj){
        if (obj != null && !listTache.contains(obj)){
            int id = 0;
            for (Tache tache : listTache){
                id = tache.getId();
                System.out.println("****"+id);
            }
            obj.setId(id+1);
            listTache.add(obj);
            return listTache.contains(obj);
        }
        return false;
    }

    /**
     * Fonction permettant de supprimer une Tache
     * @param obj Tache à supprimer
     * @return true si la Tache à été supprimé sinon false
     */
    public boolean supprimerUneTache(Tache obj){
        if (obj != null && listTache.contains(obj)){
            listTache.remove(obj);
            return !listTache.contains(obj);
        }
        return false;
    }

    /**
     * Fonction permettant de modifier une Tache
     * @param obj Tache à jouter
     * @param old Tache à supprimer
     * @return true si la Tache à été modifié sinon false
     */
    public boolean modifierUneTache(Tache obj, Tache old){
        if (obj != null && old != null && listTache.contains(old)) {
            obj.setId(old.getId());
            old.setDesc(obj.getDesc());
            old.setAvancement(obj.getAvancement());
            return old.equals(obj);
        }
        return false;
    }

    /**
     * Fonction permettant de modifier l'avancemet d'une Tache
     * @param obj Tache à modifier
     * @return true si l'avancement de Tache à été modifié sinon false
     */
    public boolean modifierAvancement(Tache obj){
        if (obj != null && listTache.contains(obj)){
            obj.setAvancement(!obj.getAvancement());
            return true;
        }
        return false;
    }

    //*********************Redéfinition*********************//

    /**
     * Redéfinition de la méthode equals de la ToDoListe
     * @param obj Object à comparer
     * @return si c'est égale
     */
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

    /**
     * Redéfinition de la méthode toString de la classe ToDoListe
     * @return le message à afficher
     */
    @Override
    public String toString(){
        String message = nomToDo + " : " + id;
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
