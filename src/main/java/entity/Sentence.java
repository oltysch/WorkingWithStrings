package entity;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Admin on 10.06.2015.
 */
public class Sentence {
    private List<Word> words;

    public List<Word> getWords() {
        return words;
    }

    public void setWords(List<Word> words) {
        this.words = words;
    }

    public Sentence(List<Word> words) {
        this.words = words;
    }
}
