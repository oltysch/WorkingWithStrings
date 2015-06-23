package entity;

import java.util.List;

/**
 * Created by Admin on 10.06.2015.
 */
public class Word implements Composite {
    private List<Char> chars;
    private String bound;

    public List<Char> getChars() {
        return chars;
    }

    public void setChars(List<Char> chars) {
        this.chars = chars;
    }

    public Word(List<Char> chars) {
        this.chars = chars;

    }

    @Override
    public String toSourceString() {
        StringBuilder sb = new StringBuilder();
        for (Char aChar : chars) {
            sb.append(aChar.toSourceString());
        }
        return sb.toString();
    }

    @Override
    public String getBound() {
        return bound;
    }

    @Override
    public void setBound(String bound) {
        this.bound = bound;
    }
}
