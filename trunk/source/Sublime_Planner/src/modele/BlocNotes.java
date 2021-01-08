package modele;

import java.util.LinkedList;

public class BlocNotes extends LinkedList<Note> {

    @Override
    public boolean add(Note item){
        int id = 0;
        for (Note note : this){
            id = note.getId() + 1;
        }
        item.setId(id);
        return super.add(item);
    }

    @Override
    public Note set(int index, Note item){
        Note n = this.get(index);
        item.setId(n.getId());
        return super.set(index, item);
    }

    @Override
    public String toString(){
        String message = "Mon block note :";
        if (this.size() == 0){
            message += "\n\t Le block note est vide.";
        } else {
            StringBuilder messageBuilder = new StringBuilder(message);
            for (Note note : this){
                messageBuilder.append("\n").append(note.toString());
            }
            message = messageBuilder.toString();

        }
        return message;
    }

}

