package init;

import javafx.collections.ObservableList;
import modele.*;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class InitializeData {

    public InitializeData(Documents doc) {
        configureToDoList(doc);
        configurePlanner(doc);
        configureBlocNotes(doc);
    }

    public void configureToDoList(Documents doc){
        ObservableList<ToDoListe> listeToDo = doc.getMeslistetodo();
        ToDoListe td1 = new ToDoListe("Courses");
        ToDoListe td2 = new ToDoListe("Devoirs");
        ToDoListe td3 = new ToDoListe("Divers");
        td1.add(new Tache("Acheter du lait"));
        td1.add(new Tache("Acheter du sucre"));
        td1.add(new Tache("Acheter du café"));
        td1.add(new Tache("Acheter du chocolat"));
        td2.add(new Tache("Faire exercice de maths"));
        td2.add(new Tache("Faire exercice de programmation objet"));
        td2.add(new Tache("Faire exercice de PPP"));
        td3.add(new Tache("Sortir les poubelles"));
        td3.add(new Tache("Sortir max le chien"));
        listeToDo.add(td1);
        listeToDo.add(td2);
        listeToDo.add(td3);
    }

    public void configurePlanner(Documents doc){
        Planner planner = doc.getMonplanner();
        Creneau c1 = new Creneau("RDV chez le coiffeur", LocalDateTime.of(2021,01,19,8,00),
                LocalDateTime.of(2021,01,19,10,00));
        Creneau c2 = new Creneau("Réunion Projet", LocalDateTime.of(2021,01,19,14,30),
                LocalDateTime.of(2021,01,19,17,00));
        Creneau c3 = new Creneau("Rendu Projet", LocalDateTime.of(2021,01,20,17,00),
                LocalDateTime.of(2021,01,20,19,15));
        Creneau c4 = new Creneau("RDV chez le docteur", LocalDateTime.of(2021,01,21,8,00),
                LocalDateTime.of(2021,01,21,10,00));
        Creneau c5 = new Creneau("Entretien individuel", LocalDateTime.of(2021,01,21,14,30),
                LocalDateTime.of(2021,01,21,17,00));
        planner.add(c1);
        planner.add(c2);
        planner.add(c3);
        planner.add(c4);
        planner.add(c5);
    }

    public void configureBlocNotes(Documents doc){
        BlocNotes blocNotes = doc.getMonblocnotes();
        Note n1 = new Note("News les plus lues", "Alexeï Navalny arrêté dès son retour en Russie, cinq mois après son empoisonnement. " +
                "L’opposant russe Alexeï Navalny, de retour en Russie après plusieurs mois de convalescence en Allemagne où il se remettait d’une tentative d’empoisonnement, a été arrêté dès son arrivée à l’aéroport de Moscou, dimanche 17 janvier. Les services pénitentiaires russes (FSIN) ont confirmé son arrestation et ont précisé qu’il « restera en détention jusqu’à la décision du tribunal » sur son cas.\n" +
                "\n" +
                "Le principal opposant à Vladimir Poutine se voit reprocher d’avoir violé les conditions d’une peine de prison avec sursis, dont il a écopé en 2014. " +
                "Il a été emmené par plusieurs policiers en uniforme alors qu’il s’apprêtait à donner son passeport pour le contrôle à la frontière, aux côtés de sa femme Ioulia.\n" +
                "\n" +
                "« Ici, c’est chez moi. Je n’ai pas peur (...) car je sais que j’ai raison et que les affaires criminelles lancées contre moi sont fabriquées de toutes pièces. J" +
                "e n’ai peur de rien et je vous appelle à n’avoir peur de rien », a déclaré M. Navalny avant son arrestation.");
        Note n2 = new Note("Comment faire un gateau", "Vous cherchez LA recette de gâteau qui fera craquer les amis, les enfants, les petits-enfants ou les amoureux ? " +
                "Il va falloir trancher ! On vous a préparé les meilleures recettes de gâteaux à cuisiner à la maison, facilement et rapidement. " +
                "Pour le reste, c’est à vous de jouer… et de déguster. Fondants au chocolat bluffants pour un dîner à deux, cheesecake onctueux pour un dessert convivial, " +
                "brownie moelleux un goûter réconfortant ? Du gâteau au chocolat jusqu’au gâteau aux fruits, du clafoutis traditionnel jusqu’au gâteau au yaourt à préparer en famille, " +
                "les recettes sucrées ne manquent ni d’idées, ni de saveurs. Choisissez entre fruits et chocolat, pâtisserie gastronomique ou dessert express : pour la suite, " +
                "il ne reste qu’à rassembler œufs et farine, à enfiler le tablier et à préchauffer le four. " +
                "À moins d’opter pour une recette de gâteau sans cuisson à garder au frigo, bien sûr !");
        Note n3 = new Note("Inspiration","Bah pour celle là j'ai pas eu d'inspi ...");
        blocNotes.add(n1);
        blocNotes.add(n2);
        blocNotes.add(n3);
    }
}
