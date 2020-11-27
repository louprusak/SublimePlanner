package modele;

import java.util.LinkedList;

public class BlocNotes {

    //*********************Attributs*********************//

    private int indiceId = 0;

    private LinkedList<Notes> listNotes;

    //*********************Getter Setter*********************//

    public LinkedList<Notes> getListNotes() {
        return listNotes;
    }

    //*********************Constructeur*********************//

    public BlocNotes() {
        listNotes = new LinkedList<>();
    }

    //*********************Fonctions*********************//

    public boolean ajouterUneNote(Notes obj){
        if (obj != null){
            obj.setId(indiceId+1);
            indiceId++;
            listNotes.add(obj);
            return listNotes.contains(obj);
        }
        return false;
    }

    public boolean supprimerUneNote(Notes obj){
        if (obj != null && listNotes.contains(obj)){
            listNotes.remove(obj);
            return !listNotes.contains(obj);
        }
        return false;
    }

    public boolean modifierUneNote(Notes obj, Notes old){
        if (obj != null && old != null && listNotes.contains(old)){
            obj.setId(old.getId());
            old.setNom(obj.getNom());
            old.setTextNote(obj.getTextNote());
            return old.equals(obj);
        }
        return false;
    }

    public boolean viderUneNote(Notes obj){
        if (listNotes.contains(obj) && obj != null){
            obj.setTextNote("");
            return obj.getTextNote().equals("");
        }
        return false;
    }

    //*********************Redéfinition*********************//

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

