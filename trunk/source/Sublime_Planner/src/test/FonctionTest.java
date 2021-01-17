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

        testToDoListe(doc);
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
        Tache t1 = new Tache(1,"tache 1");
        Tache t2 = new Tache(2,"tache 2");
        ToDoListe td1 = new ToDoListe("todoliste 1");
        ToDoListe td2 = new ToDoListe("todoliste 2");
        assert doc.getMeslistetodo().add(td1) : "ajout todoliste 1";
        assert doc.getMeslistetodo().add(td2) : "ajout todoliste 2";
        assert doc.getMatodoliste(0).add(t1) : "ajout tache 1";
        assert doc.getMatodoliste(0).add(t2) : "ajout tache 2";
        assert doc.getMatodoliste(1).add(t1) : "ajout tache 1";
        assert doc.getMatodoliste(1).add(t2) : "ajout tache 2";
        assert doc.getMatodoliste(0).remove(t1) : "suppr tache 1 dans todoliste 1";
        assert doc.getMatodoliste(1).remove(t1) : "suppr tache 1 dans todoliste 2";
        assert doc.getMatodoliste(0).set(doc.getMatodoliste(0).indexOf(t2),t1) == t2 : "";
        assert doc.getMatodoliste(1).set(doc.getMatodoliste(1).indexOf(t2),t1) == t2 : "";
        System.out.println(doc.toStringListeToDoListe());
    }

    /**
     * Fonction permettant de tester toutes les fonctions de la classe Planner ainsi que celles de la classe Creneau
     * - test de l'ajout
     * - test de la suppression
     * - test de la modification
     */
    public void testPlanner(Documents doc){
        System.out.println("***************test planner***************");
        LocalDateTime dd1 = LocalDateTime.of(2021, 01, 17, 8, 45);
        LocalDateTime df1 = LocalDateTime.of(2021, 01, 17, 9, 15);
        LocalDateTime dd2 = LocalDateTime.of(2021, 01, 18, 15, 15);
        LocalDateTime df2 = LocalDateTime.of(2021, 01, 18, 16, 45);

        Creneau c1 = new Creneau("creneau 1 ", dd1, df1);
        Creneau c2 = new Creneau("creneau 2 ", dd2, df2);
        assert doc.getMonplanner().add(c1) : "ajout creneau 1";
        assert doc.getMonplanner().add(c2) : "ajout creneau 2";
        //assert doc.getMonplanner().remove(c1) : "suppr creneau 1";
        //assert doc.getMonplanner().set(doc.getMonplanner().indexOf(c2), c1) == c2 : "modif creneau n2 en n1";
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
        assert doc.getMonblocnotes().add(n1) : "ajout note 1";
        assert doc.getMonblocnotes().add(n2) : "ajout note 2";
        assert doc.getMonblocnotes().remove(n1) : "suppr note 1";
        assert doc.getMonblocnotes().set(doc.getMonblocnotes().indexOf(n2),n1) == n2 : "modif note n2 en n1";
        System.out.println(doc.getMonblocnotes().toString());
    }

}
