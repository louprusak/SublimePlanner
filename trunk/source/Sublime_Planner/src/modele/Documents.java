package modele;

public class Documents {

    //*********************Attributs*********************//

    private ToDoListe matodoliste;

    private Planner monplanner;

    private BlocNotes monblocnotes;

    //*********************Getter Setter*********************//

    public ToDoListe getMatodoliste() {
        return matodoliste;
    }

    public Planner getMonplanner() {
        return monplanner;
    }

    public BlocNotes getMonblocnotes() {
        return monblocnotes;
    }

    //*********************Constructeur*********************//

    public Documents() {
        matodoliste = new ToDoListe();
        monplanner = new Planner();
        monblocnotes = new BlocNotes();
    }

    //*********************Redéfinition*********************//

    @Override
    public String toString(){
        String message;
        message = matodoliste.toString() + "\n" + monplanner.toString() + "\n" + monblocnotes.toString();
        return message;
    }

}
