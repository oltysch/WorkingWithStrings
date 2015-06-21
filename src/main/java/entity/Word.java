package entity;

import java.util.List;

/**
 * Created by Admin on 10.06.2015.
 */
public class Word implements Composite {
    private List<Char> listValues;
    private String bound;

    public List<Char> getListValues() {
        return listValues;
    }

    public void setListValues(List<Char> listValues) {
        this.listValues = listValues;
    }

    public Word(List<Char> chars) {
        listValues = chars;

    }

    @Override
    public String toSourceString() {
        StringBuilder sb = new StringBuilder();
        for (Char aChar : listValues) {
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
