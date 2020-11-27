package test;

import modele.*;

import java.time.LocalDateTime;

public class FonctionTest {

    private Documents doc;

    public FonctionTest() {
        doc = new Documents();
    }

    public void test(){

        System.out.println("***************test documents***************");
        System.out.println(doc.toString());

        testToDoListe();
        testPlanner();
        testBlocNotes();

        System.out.println("***************test documents***************");
        System.out.println(doc.toString());
    }

    public void testToDoListe(){
        System.out.println("***************test to do liste***************");
        Tache t1 = new Tache("tache 1");
        Tache t2 = new Tache("tache 2");
        Tache t3 = null;
        System.out.println(t1.toString());
        System.out.println(t2.toString());
        System.out.println(doc.getMatodoliste().toString());
        System.out.println("Ajout normal t1 :" + doc.getMatodoliste().ajouterUneTache(t1));
        System.out.println("Ajout anormal t1 :" + doc.getMatodoliste().ajouterUneTache(t1));
        System.out.println("Ajout normal t2 :" + doc.getMatodoliste().ajouterUneTache(t2));
        System.out.println("Ajout anormal t2 :" + doc.getMatodoliste().ajouterUneTache(t3));
        System.out.println(doc.getMatodoliste().toString());
        System.out.println("Suppr normal t1 :" + doc.getMatodoliste().supprimerUneTache(t1));
        System.out.println("Suppr anormal t1 :" + doc.getMatodoliste().supprimerUneTache(t1));
        System.out.println(doc.getMatodoliste().toString());
        System.out.println("Modif normal t1 dans t2 :" + doc.getMatodoliste().modifierUneTache(t1,t2));
        System.out.println("Modif anormal t3 dans t2 :" + doc.getMatodoliste().modifierUneTache(t3,t2));
        System.out.println(doc.getMatodoliste().toString());
    }

    public void testPlanner(){
        System.out.println("***************test planner***************");
        LocalDateTime dd1 = LocalDateTime.of(1111, 11, 20, 8, 45);
        LocalDateTime df1 = LocalDateTime.of(1111, 11, 20, 9, 15);
        LocalDateTime dd2 = LocalDateTime.of(2222, 11, 20, 13, 45);
        LocalDateTime df2 = LocalDateTime.of(2222, 11, 20, 15, 15);
        Creneau c1 = new Creneau("creneau 1", dd1, df1);
        Creneau c2 = new Creneau("creneau 2", dd2, df2);
        Creneau c3 = null;
        System.out.println(c1.toString());
        System.out.println(c2.toString());
        System.out.println(doc.getMonplanner().toString());
        System.out.println("Ajout norale c1 :" + doc.getMonplanner().ajouterUnCreneau(c1));
        System.out.println("Ajout norale c2 :" + doc.getMonplanner().ajouterUnCreneau(c2));
        System.out.println("Ajout anorale c3 :" + doc.getMonplanner().ajouterUnCreneau(c3));
        System.out.println(doc.getMonplanner().toString());
        System.out.println("Suppr normal c1 :" + doc.getMonplanner().supprimerUnCreneau(c1));
        System.out.println(doc.getMonplanner().toString());
        System.out.println("Modiff normal c1 dans c2 :" + doc.getMonplanner().modifierUnCreneau(c1, c2));
        System.out.println("Modiff anormal c3 dans c2 :" + doc.getMonplanner().modifierUnCreneau(c3, c2));
        System.out.println(doc.getMonplanner().toString());
    }

    public void testBlocNotes(){
        System.out.println("***************test block notes***************");
        Notes n1 = new Notes("note 1", "text de la note 1");
        Notes n2 = new Notes("note 2", "test de la note 2");
        Notes n3 = null;
        System.out.println(n1.toString());
        System.out.println(n2.toString());
        System.out.println(doc.getMonblocnotes().toString());
        System.out.println("Ajout normal n1 :" + doc.getMonblocnotes().ajouterUneNote(n1));
        System.out.println("Ajout normal n2 :" + doc.getMonblocnotes().ajouterUneNote(n2));
        System.out.println("Ajout anormal n3 :" + doc.getMonblocnotes().ajouterUneNote(n3));
        System.out.println(doc.getMonblocnotes().toString());
        System.out.println("Suppr normal n1 :" + doc.getMonblocnotes().supprimerUneNote(n1));
        System.out.println(doc.getMonblocnotes().toString());
        System.out.println("Modif normal n1 dans n2 :" + doc.getMonblocnotes().modifierUneNote(n1, n2));
        System.out.println("Modif anormal n3 dans n2 :" + doc.getMonblocnotes().modifierUneNote(n3, n2));
        System.out.println(doc.getMonblocnotes().toString());
        System.out.println("Vider la note n2 : " + doc.getMonblocnotes().viderUneNote(n2));
        System.out.println(doc.getMonblocnotes().toString());
    }

}
