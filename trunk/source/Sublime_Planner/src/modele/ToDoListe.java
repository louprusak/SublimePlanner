package modele;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

import java.util.LinkedList;

public class ToDoListe extends LinkedList<Tache> {

    private StringProperty nomToDo = new SimpleStringProperty();
    public String getNomToDo(){return nomToDo.get();}
    public StringProperty nomToDoProperty(){return nomToDo;}
    public void setNomToDo(String nom){this.nomToDo.set(nom);}

    public ToDoListe (String nom){
        setNomToDo(nom);
    }

    @Override
    public boolean add(Tache item){
        int id = 1;
        if (this.size() > 0){
            id = this.getLast().getId()+1;
        }
        item.setId(id);
        return super.add(item);
    }

    @Override
    public Tache set(int index, Tache item){
        item.setId(this.get(index).getId());
        return super.set(index, item);
    }

    /**
     * Redéfinition de la méthode toString de la classe ToDoListe
     * @return le message à afficher
     */
    @Override
    public String toString(){
        String message = this.getNomToDo() + " : ";
        if (this.size() == 0){
            message += "\n\t\t La ToDo liste est vide.";
        } else {
            StringBuilder messageBuilder = new StringBuilder(message);
            for (Tache tache : this){
                messageBuilder.append("\n\t\t").append(tache.toString());
            }
            message = messageBuilder.toString();
        }
        return message;
    }

}
