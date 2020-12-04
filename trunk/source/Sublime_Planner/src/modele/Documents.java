package modele;

public class Documents {

    //*********************Attributs*********************//

    /**
     * Attribut contenant la todoliste
     */
    private ListeToDo malistetodo;

    /**
     * Attibut contenant le planner
     */
    private Planner monplanner;

    /**
     * Attribut contenant le bloc note
     */
    private BlocNotes monblocnotes;

    //*********************Getter Setter*********************//

    /**
     * Getter de la todoliste
     * @return le contenus de ma todoliste
     */
    public ListeToDo getMalistetodo() {
        return malistetodo;
    }

    /**
     * Getter du planner
     * @return le contenus de mon planner
     */
    public Planner getMonplanner() {
        return monplanner;
    }

    /**
     * Getter du bloc note
     * @return le contenus de mon bloc note
     */
    public BlocNotes getMonblocnotes() {
        return monblocnotes;
    }

    //*********************Constructeur*********************//

    /**
     * Constructeur de ma classe Documents
     */
    public Documents() {
        malistetodo = new ListeToDo();
        monplanner = new Planner();
        monblocnotes = new BlocNotes();
    }

    //*********************Redéfinition*********************//

    /**
     * Redéfinition de la méthode toString de la classe Documents
     * @return le message permettant d'afficher mes documents
     */
    @Override
    public String toString(){
        String message;
        message = malistetodo.toString() + "\n" + monplanner.toString() + "\n" + monblocnotes.toString();
        return message;
    }

}
