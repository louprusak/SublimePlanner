package modele;

import java.util.LinkedList;

public class BlocNotes extends LinkedList<Note> {

    @Override
    public boolean add(Note item){
        int id = 1;
        if (this.size() > 0){
            id = this.getLast().getId()+1;
        }
        item.setId(id);
        return super.add(item);
    }

    @Override
    public Note set(int index, Note item){
        item.setId(this.get(index).getId());
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

