package entity;

/**
 * Created by Admin on 10.06.2015.
 */
public class Char implements SentencePart {
    private char character;

    public Char(char character) {
        this.character = character;
    }

    public String toSourceString() {
        return String.valueOf(character);
    }
}
