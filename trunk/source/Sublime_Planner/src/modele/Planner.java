package modele;

import javafx.beans.property.SimpleListProperty;
import javafx.collections.FXCollections;

import java.io.Serializable;

public class Planner extends SimpleListProperty<Creneau> implements Serializable {

    //*********************Constructeur*********************//

    /**
     * Constructeur de la classe Planner
     */
    public Planner() {
        super(FXCollections.observableArrayList());
    }

    //*********************Redéfinition*********************//

    /**
     * redéfinition de la méthode add
     * @param item Creneau à ajouter
     * @return true si l'ajout a été effectuer et false si non
     */
    @Override
    public boolean add(Creneau item){
        int id = 1;
        if (this.size() > 0){
            id = this.get(size()-1).getId()+1;
        }
        item.setId(id);
        return super.add(item);
    }

    /**
     * redéfinition de la méthode set
     * @param index int index dans la liste de l'item à modifier
     * @param item nouvelle Tache
     * @return l'objet modifié
     */
    @Override
    public Creneau set(int index, Creneau item){
        item.setId(this.get(index).getId());
        return super.set(index, item);
    }

    /**
     * redéfinition de la méthode toString de la classe Planner
     * @return le message à afficher
     */
    @Override
    public String toString(){
        String message = "Mon planneur : ";
        if (this.size() == 0){
            message += "\n\t Le planneur est vide.";
        } else {
            StringBuilder messageBuilder = new StringBuilder(message);
            for (Creneau creneau : this){
                messageBuilder.append("\n\t").append(creneau.toString());
            }
            message = messageBuilder.toString();
        }
        return message;
    }

}
