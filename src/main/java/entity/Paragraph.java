package entity;

import java.util.List;

public class Paragraph implements Composite {
    private List<Sentence> listValues;
    private String bound;

    public List<Sentence> getListValues() {
        return listValues;
    }

    public void setListValues(List<Sentence> listValues) {
        this.listValues = listValues;
    }

    public Paragraph(List<Sentence> sentences) {
        this.listValues = sentences;
    }

    @Override
    public String toSourceString() {
        StringBuilder sb = new StringBuilder();
        for (Sentence sentence : listValues) {
            sb.append(sentence.toSourceString());
            if (!(sentence.getBound()==null))
                sb.append(sentence.getBound());
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
