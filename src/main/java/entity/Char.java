package entity;

/**
 * Created by Admin on 10.06.2015.
 */
public class Char implements Component{
    private Character character;

    public Character getCharacter() {
        return character;
    }

    public void setCharacter(Character character) {
        this.character = character;
    }

    public Char(Character character) {
        this.character=character;
    }

    public String toSourceString() {
        return character.toString();
    }
}
