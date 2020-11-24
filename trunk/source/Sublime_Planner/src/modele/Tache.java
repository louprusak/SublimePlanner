package modele;

public class Tache {

    //*********************Attributs*********************//

    private String tache;

    //*********************Getter Setter*********************//

    public String getTache() {
        return tache;
    }

    public void setTache(String nom) {
        this.tache = nom;
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
        return this.getTache().equals(item.getTache());
    }

    @Override
    public String toString(){
        return tache;
    }
}
