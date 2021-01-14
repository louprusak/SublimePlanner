package modele;

import java.util.LinkedList;

public class Planner extends LinkedList<Creneau>{

    @Override
    public boolean add(Creneau item){
        int id = 1;
        if (this.size() > 0){
            id = this.getLast().getId()+1;
        }
        item.setId(id);
        return super.add(item);
    }

    @Override
    public Creneau set(int index, Creneau item){
        item.setId(this.get(index).getId());
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
                messageBuilder.append("\n\t").append(creneau.toString());
            }
            message = messageBuilder.toString();
        }
        return message;
    }

}
