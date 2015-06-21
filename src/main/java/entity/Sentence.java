package entity;

import java.util.List;

/**
 * Created by Admin on 10.06.2015.
 */
public class Sentence implements Composite {
    private List<Word> listValues;
    private String bound;

    public List<Word> getListValues() {
        return listValues;
    }

    public void setListValues(List<Word> listValues) {
        this.listValues = listValues;
    }

    public Sentence(List<Word> words) {
        this.listValues = words;
    }

    @Override
    public String toSourceString() {
        StringBuilder sb = new StringBuilder();
        for (Word word : listValues) {
            sb.append(word.toSourceString());
            if (!(word.getBound()==null))
            sb.append(word.getBound());
        }
        if (!(bound==null))
        sb.append(bound);
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
