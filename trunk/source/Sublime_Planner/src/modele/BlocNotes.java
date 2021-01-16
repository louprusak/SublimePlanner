package modele;

import java.io.Serializable;
import java.util.LinkedList;

public class BlocNotes extends LinkedList<Note> implements Serializable {

    //*********************Redéfinition*********************//

    /**
     * redéfinition de la méthode add
     * @param item Note à ajouter
     * @return true si l'ajout a été effectuer et false si non
     */
    @Override
    public boolean add(Note item){
        int id = 1;
        if (this.size() > 0){
            id = this.getLast().getId()+1;
        }
        item.setId(id);
        return super.add(item);
    }

    /**
     * redéfinition de la méthode set
     * @param index int index dans la liste de l'item à modifier
     * @param item nouvelle Note
     * @return l'objet modifié
     */
    @Override
    public Note set(int index, Note item){
        item.setId(this.get(index).getId());
        return super.set(index, item);
    }

    /**
     * redéfinition de la méthode toString de la classe BlocNotes
     * @return le message à afficher
     */
    @Override
    public String toString(){
        String message = "Mon block note :";
        if (this.size() == 0){
            message += "\n\t Le block note est vide.";
        } else {
            StringBuilder messageBuilder = new StringBuilder(message);
            for (Note note : this){
                messageBuilder.append("\n").append(note.toString());
            }
            message = messageBuilder.toString();

        }
        return message;
    }

}

