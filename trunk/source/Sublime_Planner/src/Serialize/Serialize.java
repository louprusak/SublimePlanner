package Serialize;

import modele.Documents;
import modele.Note;

import javax.naming.Context;
import java.io.*;

public abstract class Serialize {

    public static void serialize (String filename, Object object){
        try {
            File fichier = new File(filename);
            ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(fichier));
            oos.writeObject(object);
            oos.flush();
            oos.close();
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public static Documents deSerialize (String filename, Object ensembleDocs){
        try {
            File fichier = new File(filename);
            if(!fichier.exists()){
                serialize(filename,ensembleDocs);
            }
            ObjectInputStream ois = new ObjectInputStream(new FileInputStream(fichier));
            Documents doc = new Documents();
            doc = (Documents) ois.readObject();
            ois.close();
            return doc;
        }catch (Exception e){
            e.printStackTrace();
            return new Documents();
        }
    }

}
