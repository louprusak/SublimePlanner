package modele;

public class Notes {

    //*********************Attributs*********************//

    private String textNote;

    //*********************Getter Setter*********************//

    public String getTextNote() {
        return textNote;
    }

    public void setTextNote(String textNote) {
        this.textNote = textNote;
    }

    //*********************Constructeur*********************//

    public Notes(String textNote) {
        this.textNote = textNote;
    }

    //*********************Redéfinition*********************//

    @Override
    public boolean equals(Object obj){
        if (this == obj){
            return true;
        }
        if (obj == null || getClass() != obj.getClass()){
            return false;
        }
        Notes item = (Notes) obj;
        return this.getTextNote().equals(item.getTextNote());
    }

    @Override
    public String toString(){
        return textNote;
    }
}
