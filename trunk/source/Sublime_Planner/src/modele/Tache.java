package modele;

public class Tache {

    //*********************Attributs*********************//

    /**
     * id de la Tache
     */
    private int id;

    /**
     * description de la tache
     */
    private String desc;

    /**
     * avancement de la tache
     * true = finie
     * false = en cour
     */
    private boolean avancement = false;

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
     * Getter du description
     * @return le description
     */
    public String getDesc() {
        return desc;
    }

    /**
     * Setter du description
     * @param desc nouvelle description
     */
    public void setDesc(String desc) {
        this.desc = desc;
    }

    /**
     * Getter de l'avancement
     * @return l'avancement
     */
    public boolean getAvancement(){
        return avancement;
    }

    /**
     * Setter de l'avancement
     * @param avancement nouveau avancement
     */
    public void setAvancement(boolean avancement) {
        this.avancement = avancement;
    }
    //*********************Constructeur*********************//

    /**
     * Constructeur de la tache
     * @param desc description de la tache
     */
    public Tache(String desc) {
        this.desc = desc;
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
        return id + " : " + desc +  " " + avancement;
    }
}
