package modele;

public class Tache {

    //*********************Attributs*********************//

    private int id;

    private String tache;

    private boolean avancement = false;

    //*********************Getter Setter*********************//


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTache() {
        return tache;
    }

    public void setTache(String nom) {
        this.tache = nom;
    }

    public boolean getAvancement(){
        return avancement;
    }

    public void setAvancement(boolean avancement) {
        this.avancement = avancement;
    }
    //*********************Constructeur*********************//

    public Tache(String nom) {
        this.tache = nom;
    }

    //*********************Redéfinition*********************//

    @Override
    public boolean equals(Object obj){
        if (this == obj){
            return true;
        }
        if (obj == null || getClass() != obj.getClass()){
            return false;
        }
        Tache item = (Tache) obj;
        return this.getId() == item.getId() && this.getTache().equals(item.getTache());
    }

    @Override
    public String toString(){
        return id + " : " + tache +  " " + avancement;
    }
}
