package test;

import modele.*;

import java.time.LocalDateTime;

public class FonctionTest {

    //*********************Constructeur*********************//

    /**
     * Constructeur de la classe FonctionTest
     */
    public FonctionTest() {

    }

    //*********************Fonctions*********************//

    /**
     * Fonction permettant d'affcher les documents et d'appeller des tests spécifiques
     */
    public void test(Documents doc){
        System.out.println("***************test documents***************");
        System.out.println(doc.toString());

        //testToDoListe(doc);
        testPlanner(doc);
        testBlocNotes(doc);

        System.out.println("***************test documents***************");
        System.out.println(doc.toString());
    }

    /**
     * Fonction permettant de tester toutes les fonctions de la classe ToDoListe ainsi que celles de la classe Tache
     * - test de l'ajout
     * - test de la suppression
     * - test de la modification
     */
    public void testToDoListe(Documents doc){
        System.out.println("***************test to do liste***************");
        ToDoListe to1 = new ToDoListe("todoliste 1");
        ToDoListe to2 = new ToDoListe("todoliste 2");
        ToDoListe to3 = null;
        assert doc.getMalistetodo().ajouterToDoListe(to1) : "Ajout de to1";
        assert doc.getMalistetodo().ajouterToDoListe(to2) : "Ajout de to2";
        assert !doc.getMalistetodo().ajouterToDoListe(to2) : "Ajout de to2";
        assert !doc.getMalistetodo().ajouterToDoListe(to3) : "Ajout de to3";
        assert doc.getMalistetodo().supprimerToDoListe(to1) : "Suppr de to1 : ";
        assert !doc.getMalistetodo().supprimerToDoListe(to1) : "Suppr de to1 : ";
        assert doc.getMalistetodo().modifierNomToDoListe(to2, "todoliste2bis") : "Modif du nom de to2 : ";
        Tache t1 = new Tache("tache 1");
        Tache t2 = new Tache("tache 2");
        Tache t3 = null;
        System.out.println(t1.toString());
        System.out.println(t2.toString());
        assert doc.getMalistetodo().ajouterUneTache(to2, t1) : "Ajout de t1";
        assert !doc.getMalistetodo().ajouterUneTache(to2, t1) : "Ajout de t1";
        assert doc.getMalistetodo().ajouterUneTache(to2, t2) : "Ajout de t2";
        assert !doc.getMalistetodo().ajouterUneTache(to2, t3) : "Ajout de t3";
        assert doc.getMalistetodo().supprimerUneTache(to2, t1) : "Suppr de t1";
        assert !doc.getMalistetodo().supprimerUneTache(to2, t1) : "Suppr de t1";
        assert doc.getMalistetodo().modifierUneTache(to2, t1,t2) : "Modif de t2";
        assert !doc.getMalistetodo().modifierUneTache(to2, t3,t2) : "Modif de t2";
        assert doc.getMalistetodo().modifierAvancement(to2, t2) : "Modif de l'avancement de t2";
        System.out.println(doc.getMalistetodo().toString());
    }

    /**
     * Fonction permettant de tester toutes les fonctions de la classe Planner ainsi que celles de la classe Creneau
     * - test de l'ajout
     * - test de la suppression
     * - test de la modification
     */
    public void testPlanner(Documents doc){
        System.out.println("***************test planner***************");
        LocalDateTime dd1 = LocalDateTime.of(1111, 11, 20, 8, 45);
        LocalDateTime df1 = LocalDateTime.of(1111, 11, 20, 9, 15);
        LocalDateTime dd2 = LocalDateTime.of(2222, 11, 20, 13, 45);
        LocalDateTime df2 = LocalDateTime.of(2222, 11, 20, 15, 15);
        Creneau c1 = new Creneau("creneau 1 ", dd1, df1);
        Creneau c2 = new Creneau("creneau 2 ", dd2, df2);
        System.out.println(c1.toString());
        System.out.println(c2.toString());
        assert doc.getMonplanner().add(c1) : "ajout creneau 1";
        assert doc.getMonplanner().add(c2) : "ajout creneau 2";
        assert doc.getMonplanner().remove(c1) : "suppr creneau 1";
        assert doc.getMonplanner().set(doc.getMonplanner().indexOf(c2), c1) == c2 : "modif creneau n2 en n1";
        System.out.println(doc.getMonplanner().toString());
    }

    /**
     * Fonction permettant de tester toutes les fonctions de la classe BlocNotes ainsi que celles de la classe Notes
     * - test de l'ajout
     * - test de la suppression
     * - test de la modification
     * - test du vidage
     */
    public void testBlocNotes(Documents doc){
        System.out.println("***************test block notes***************");
        Note n1 = new Note("note 1", "text de la note 1");
        Note n2 = new Note("note 2", "test de la note 2");
        System.out.println(n1.toString());
        System.out.println(n2.toString());
        assert doc.getMonblocnotes().add(n1) : "ajout note 1";
        assert doc.getMonblocnotes().add(n2) : "ajout note 2";
        assert doc.getMonblocnotes().remove(n1) : "suppr note 1";
        assert doc.getMonblocnotes().set(doc.getMonblocnotes().indexOf(n2),n1) == n2 : "modif note n2 en n1";
        System.out.println(doc.getMonblocnotes().toString());
    }

}
