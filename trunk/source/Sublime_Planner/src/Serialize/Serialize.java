package Serialize;

import modele.Documents;
import modele.Note;

import javax.naming.Context;
import java.io.*;

public abstract class Serialize {

    public static void serialize (String filename, Object object){
        try {
            FileOutputStream file = new FileOutputStream(filename);
            ObjectOutputStream oos;
            try {
                oos = new ObjectOutputStream(file);
                oos.writeObject(object);
                oos.flush();
                oos.close();
            } catch (IOException e){
                e.printStackTrace();
            }
        }catch (FileNotFoundException e){
            e.printStackTrace();
        }
    }

    public static Object deSerialize (String filename, Object ensembleDocs){
        try {
            FileInputStream file = new FileInputStream(filename);
            ObjectInputStream ois;
            try {
                ois = new ObjectInputStream(file);
                try {
                    Object object = ois.readObject();
                    ois.close();
                    return object;
                } catch (ClassNotFoundException e) {
                    e.printStackTrace();
                }
            } catch (Exception e){
                e.printStackTrace();
            }
        }catch (FileNotFoundException e){
            e.printStackTrace();
            serialize(filename, ensembleDocs);
            return deSerialize(filename, ensembleDocs);
        }
        return null;
    }

}
