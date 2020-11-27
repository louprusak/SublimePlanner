package modele;

public class Notes {

    //*********************Attributs*********************//

    private int id;

    private String nom;

    private String textNote;

    //*********************Getter Setter*********************//


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getTextNote() {
        return textNote;
    }

    public void setTextNote(String textNote) {
        this.textNote = textNote;
    }

    //*********************Constructeur*********************//

    public Notes(String nom, String textNote) {
        this.nom = nom;
        this.textNote = textNote;
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
        Notes item = (Notes) obj;
        return this.getId() == item.getId() && this.getNom().equals(item.getNom()) && this.getTextNote().equals(item.getTextNote());
    }

    @Override
    public String toString(){
        String message;
        message =  id + " : "+ nom + "\n\t";
        if (textNote.equals("")) {
            message += "La note est vide.";
        } else {
            message += textNote;
        }
        return message;
    }
}
