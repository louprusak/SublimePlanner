package modele;

import java.util.LinkedList;

public class BlocNotes {

    //*********************Attributs*********************//

    /**
     * Attribut contenant le dernier id utiliser par un Notes pour attribuer à chaque Notes un id unique
     */
    private int indiceId = 0;

    /**
     * liste des Notes
     */
    private LinkedList<Notes> listNotes;

    //*********************Getter Setter*********************//

    /**
     * Getter de la liste de Notes
     * @return liste des Notes
     */
    public LinkedList<Notes> getListNotes() {
        return listNotes;
    }

    //*********************Constructeur*********************//

    /**
     * Constructeur de la classe BlocNotes
     */
    public BlocNotes() {
        listNotes = new LinkedList<>();
    }

    //*********************Fonctions*********************//

    /**
     * Fonction permettant d'ajouter un note à la liste
     * @param obj Notes à ajouter
     * @return retourne true si la la liste contient la Notes sinon retourne false
     */
    public boolean ajouterUneNote(Notes obj){
        if (obj != null){
            indiceId++;
            obj.setId(indiceId);
            listNotes.add(obj);
            return listNotes.contains(obj);
        }
        return false;
    }

    /**
     * Fonction permettant de supprimer ne Notes de la liste
     * @param obj Notes à supprimer
     * @return retourne true si la la liste ne contient pas la Notes sinon retourne false
     */
    public boolean supprimerUneNote(Notes obj){
        if (obj != null && listNotes.contains(obj)){
            listNotes.remove(obj);
            return !listNotes.contains(obj);
        }
        return false;
    }

    /**
     * Fonction permettant de modifier une Notes
     * @param obj Notes à ajouter
     * @param old Notes à supprimer
     * @return
     */
    public boolean modifierUneNote(Notes obj, Notes old){
        if (obj != null && old != null && listNotes.contains(old)){
            obj.setId(old.getId());
            old.setNom(obj.getNom());
            old.setTextNote(obj.getTextNote());
            return old.equals(obj);
        }
        return false;
    }

    /**
     * Fonction permettant de vider une note
     * @param obj Notes à vider
     * @return retourne true si la Notes est vide sinon false
     */
    public boolean viderUneNote(Notes obj){
        if (listNotes.contains(obj) && obj != null){
            obj.setTextNote("");
            return obj.getTextNote().equals("");
        }
        return false;
    }

    //*********************Redéfinition*********************//

    /**
     * Redéfinition de la méthode toString de la classe BlocNotes
     * @return message à afficher sinon false
     */
    @Override
    public String toString(){
        String message = "Mon block note :";
        if (listNotes.size() == 0){
            message += "\n\t Le block note est vide.";
        } else {
            StringBuilder messageBuilder = new StringBuilder(message);
            for (Notes notes : listNotes){
                messageBuilder.append("\n").append(notes.toString());
            }
            message = messageBuilder.toString();

        }
        return message;
    }
}

