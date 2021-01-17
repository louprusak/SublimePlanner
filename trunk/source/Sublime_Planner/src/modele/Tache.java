package modele;

import javafx.beans.property.*;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class Tache implements Serializable {

    //*********************Propriétés / Getter / Setter*********************//

    /**
     * id de la Tache
     */
    private transient IntegerProperty idTache = new SimpleIntegerProperty();
    public int getId(){return idTache.get();}
    public IntegerProperty idTacheProperty(){return idTache;}
    public void setId(int id){this.idTache.set(id);}

    /**
     * description de la tache
     */
    private transient StringProperty desc = new SimpleStringProperty();
    public String getDesc(){return desc.get();}
    public StringProperty descProperty(){return desc;}
    public void setDesc(String desc){this.desc.set(desc);}



    //*********************Constructeur*********************//

    /**
     * Constructeur de la tache
     * @param desc description de la tache
     */
    public Tache(int id, String desc) {
        setId(id);
         setDesc(desc);
    }

    //*********************Redéfinition*********************//

    /**
     * Redéfinition de la méthode equals de la classe Tache
     * @param obj Object à comparer
     * @return true si c'est égale sinon false
     */
    @Override
    public boolean equals(Object obj){
        if (this == obj){
            return true;
        }
        if (obj == null || getClass() != obj.getClass()){
            return false;
        }
        Tache item = (Tache) obj;
        return this.getId() == item.getId() && this.getDesc().equals(item.getDesc());
    }

    /**
     * Redéfinition de la méthode toString de la classe Tache
     * @return le message à afficher
     */
    @Override
    public String toString(){
        return getId() + " : " + getDesc();
    }

    private void writeObject(ObjectOutputStream s) throws IOException {
        s.writeInt(getId());
        s.writeUTF(getDesc());
    }

    private void readObject(ObjectInputStream s) throws IOException, ClassNotFoundException {
        setId(s.readInt());
        setDesc(s.readUTF());
    }
}
