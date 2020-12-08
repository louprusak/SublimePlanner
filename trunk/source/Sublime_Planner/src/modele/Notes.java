package modele;

public class Notes {

    //*********************Attributs*********************//

    /**
     * id de la Notes
     */
    private int id;

    /**
     * nom de la Notes
     */
    private String nom;

    /**
     * text Notes
     */
    private String textNote;

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
     * Getter du nom
     * @return nouveau nom
     */
    public String getNom() {
        return nom;
    }

    /**
     * Setter du nom
     * @param nom nouveau nom
     */
    public void setNom(String nom) {
        this.nom = nom;
    }

    /**
     * Getter du text
     * @return le text
     */
    public String getTextNote() {
        return textNote;
    }

    /**
     * Setter du text
     * @param textNote nouveau text
     */
    public void setTextNote(String textNote) {
        this.textNote = textNote;
    }

    //*********************Constructeur*********************//

    /**
     * constructeur de la classe Notes
     * @param nom nom de la Notes
     * @param textNote texte de la Notes
     */
    public Notes(String nom, String textNote) {
        this.nom = nom;
        this.textNote = textNote;
    }

    //*********************Redéfinition*********************//

    /**
     * Redéfinition de la méthode equals de la classe Notes
     * @param obj L'object à comaprer
     * @return true si c'est égal
     */
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

    /**
     * Redéfinition de la méthode toString de la classe Notes
     * @return le message à afficher
     */
    @Override
    public String toString(){
        String message =  id + " : "+ nom + "\n\t";
        if (textNote.equals("")) {
            message += "La note est vide.";
        } else {
            message += textNote;
        }
        return message;
    }
}
