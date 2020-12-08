package modele;

import java.util.LinkedList;

public class ToDoListe {

    //*********************Attributs*********************//

    /**
     * id de la ToDoListe
     */
    private int id;

    /**
     * nom de la ToDoListe
     */
    private String nomToDo;

    /**
     * Attribut contenant le dernier id utiliser par une Tache pour attribuer à chaque Tache un id unique
     */
    private int indiceId = 0;

    /**
     * liste de Tache
     */
    private LinkedList<Tache> listTache;

    //*********************Getter Setter*********************//

    /**
     * Getter de l'id
     * @return l'id
     */
    public int getId() {
        return id;
    }

    /**
     * Setter de l'id
     * @param id nouveau id
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Getter du nom
     * @return le nom
     */
    public String getNomToDo() {
        return nomToDo;
    }

    /**
     * Setter du nom
     * @param nomToDo nouveau nom
     */
    public void setNomToDo(String nomToDo) {
        this.nomToDo = nomToDo;
    }

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
        this.nomToDo = nomToDo;
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
            indiceId++;
            obj.setId(indiceId);
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
        if (obj != null && old != null && listTache.contains(old) && !listTache.contains(obj)) {
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
