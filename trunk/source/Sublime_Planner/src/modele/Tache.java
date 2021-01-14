package modele;

import javafx.beans.property.*;

public class Tache {

    //*********************Propriétés / Getter / Setter*********************//

    /**
     * id de la Tache
     */
    private IntegerProperty idTache = new SimpleIntegerProperty();
    public int getId(){return idTache.get();}
    public IntegerProperty idTacheProperty(){return idTache;}
    public void setId(int id){this.idTache.set(id);}

    /**
     * description de la tache
     */
    private StringProperty desc = new SimpleStringProperty();
    public String getDesc(){return desc.get();}
    public StringProperty descProperty(){return desc;}
    public void setDesc(String desc){this.desc.set(desc);}

    /**
     * avancement de la tache
     * true = finie
     * false = en cour
     */
    private BooleanProperty avancement = new SimpleBooleanProperty();
    public Boolean getAvancement(){return avancement.get();}
    public BooleanProperty avancementProperty(){return avancement;}
    public void setAvancement(Boolean avancement){this.avancement.set(avancement);}



    //*********************Constructeur*********************//

    /**
     * Constructeur de la tache
     * @param desc description de la tache
     */
    public Tache(String desc) {
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
        return getId() + " : " + getDesc() +  " " + getAvancement();
    }
}
