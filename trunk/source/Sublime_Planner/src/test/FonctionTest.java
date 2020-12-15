package test;

import modele.*;

import java.time.LocalDateTime;

public class FonctionTest {

    //*********************Attributs*********************//

    /**
     * Attribut contenant tous les documents
     */
    private Documents doc;

    //*********************Constructeur*********************//

    /**
     * Constructeur de la classe FonctionTest
     */
    public FonctionTest() {
        doc = new Documents();
    }

    //*********************Fonctions*********************//

    /**
     * Fonction permettant d'affcher les documents et d'appeller des tests spécifiques
     */
    public void test(){
        System.out.println("***************test documents***************");
        System.out.println(doc.toString());

        testToDoListe();
        testPlanner();
        testBlocNotes();

        System.out.println("***************test documents***************");
        System.out.println(doc.toString());
    }

    /**
     * Fonction permettant de tester toutes les fonctions de la classe ToDoListe ainsi que celles de la classe Tache
     * - test de l'ajout
     * - test de la suppression
     * - test de la modification
     */
    public void testToDoListe(){
        System.out.println("***************test to do liste***************");
        ToDoListe to1 = new ToDoListe("todoliste 1");
        ToDoListe to2 = new ToDoListe("todoliste 2");
        ToDoListe to3 = null;
        assert doc.getMalistetodo().ajouterToDoListe(to1) : "Ajout normal to1 : ";
        assert doc.getMalistetodo().ajouterToDoListe(to2) : "Ajout normal to2 : ";
        assert !doc.getMalistetodo().ajouterToDoListe(to2) : "Ajout anormal to2 : ";
        assert !doc.getMalistetodo().ajouterToDoListe(to3) : "Ajout anormal to3 : ";
        assert doc.getMalistetodo().supprimerToDoListe(to1) : "Suppr normal to1 : ";
        assert !doc.getMalistetodo().supprimerToDoListe(to1) : "Suppr anormal to1 : ";
        assert doc.getMalistetodo().modifierNomToDoListe(to2, "todoliste2bis") : "Modif normal to2 : ";
        Tache t1 = new Tache("tache 1");
        Tache t2 = new Tache("tache 2");
        Tache t3 = null;
        System.out.println(t1.toString());
        System.out.println(t2.toString());
        assert doc.getMalistetodo().ajouterUneTache(to2, t1);
        assert !doc.getMalistetodo().ajouterUneTache(to2, t1);
        assert doc.getMalistetodo().ajouterUneTache(to2, t2);
        assert !doc.getMalistetodo().ajouterUneTache(to2, t3);
        assert doc.getMalistetodo().supprimerUneTache(to2, t1);
        assert !doc.getMalistetodo().supprimerUneTache(to2, t1);
        assert doc.getMalistetodo().modifierUneTache(to2, t1,t2);
        assert !doc.getMalistetodo().modifierUneTache(to2, t3,t2);
        assert doc.getMalistetodo().modifierAvancement(to2, t2);
        System.out.println(doc.getMalistetodo().toString());
    }

    /**
     * Fonction permettant de tester toutes les fonctions de la classe Planner ainsi que celles de la classe Creneau
     * - test de l'ajout
     * - test de la suppression
     * - test de la modification
     */
    public void testPlanner(){
        System.out.println("***************test planner***************");
        LocalDateTime dd1 = LocalDateTime.of(1111, 11, 20, 8, 45);
        LocalDateTime df1 = LocalDateTime.of(1111, 11, 20, 9, 15);
        LocalDateTime dd2 = LocalDateTime.of(2222, 11, 20, 13, 45);
        LocalDateTime df2 = LocalDateTime.of(2222, 11, 20, 15, 15);
        Creneau c1 = new Creneau("creneau 1 ", dd1, df1);
        Creneau c2 = new Creneau("creneau 2 ", dd2, df2);
        Creneau c3 = null;
        System.out.println(c1.toString());
        System.out.println(c2.toString());
        assert doc.getMonplanner().ajouterUnCreneau(c1);
        assert doc.getMonplanner().ajouterUnCreneau(c2);
        assert !doc.getMonplanner().ajouterUnCreneau(c3);
        assert doc.getMonplanner().supprimerUnCreneau(c1);
        assert doc.getMonplanner().modifierUnCreneau(c1, c2);
        assert !doc.getMonplanner().modifierUnCreneau(c3, c2);
        System.out.println(doc.getMonplanner().toString());
    }

    /**
     * Fonction permettant de tester toutes les fonctions de la classe BlocNotes ainsi que celles de la classe Notes
     * - test de l'ajout
     * - test de la suppression
     * - test de la modification
     * - test du vidage
     */
    public void testBlocNotes(){
        System.out.println("***************test block notes***************");
        Notes n1 = new Notes("note 1", "text de la note 1");
        Notes n2 = new Notes("note 2", "test de la note 2");
        Notes n3 = null;
        System.out.println(n1.toString());
        System.out.println(n2.toString());
        assert doc.getMonblocnotes().ajouterUneNote(n1);
        assert doc.getMonblocnotes().ajouterUneNote(n2);
        assert !doc.getMonblocnotes().ajouterUneNote(n3);
        assert doc.getMonblocnotes().supprimerUneNote(n1);
        assert doc.getMonblocnotes().modifierUneNote(n1, n2);
        assert !doc.getMonblocnotes().modifierUneNote(n3, n2);
        assert doc.getMonblocnotes().viderUneNote(n2);
        System.out.println(doc.getMonblocnotes().toString());
    }

}
