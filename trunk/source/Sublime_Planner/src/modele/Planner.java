package modele;

import java.util.LinkedList;

public class Planner extends LinkedList<Creneau>{

    @Override
    public boolean add(Creneau item){
        int id = 0;
        for (Creneau creneau : this){
            id = creneau.getId() + 1;
        }
        item.setId(id);
        return super.add(item);
    }

    @Override
    public Creneau set(int index, Creneau item){
        Creneau c = this.get(index);
        item.setId(c.getId());
        return super.set(index, item);
    }

    @Override
    public String toString(){
        String message = "Mon planneur : ";
        if (this.size() == 0){
            message += "\n\t Le planneur est vide.";
        } else {
            StringBuilder messageBuilder = new StringBuilder(message);
            for (Creneau creneau : this){
                messageBuilder.append("\n").append(creneau.toString());
            }
            message = messageBuilder.toString();
        }
        return message;
    }

}
