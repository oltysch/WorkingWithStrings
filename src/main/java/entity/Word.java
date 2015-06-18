package entity;

import java.util.List;

/**
 * Created by Admin on 10.06.2015.
 */
public class Word {
    private List<Char> characters;

    public List<Char> getCharacters() {
        return characters;
    }

    public void setCharacters(List<Char> characters) {
        this.characters = characters;
    }

    public Word(List<Char> chars) {
        characters = chars;

    }
}
