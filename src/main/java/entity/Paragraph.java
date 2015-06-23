package entity;

import java.util.List;

public class Paragraph implements Composite {
    private List<Sentence> sentences;
    private String bound;

    public List<Sentence> getSentences() {
        return sentences;
    }

    public void setSentences(List<Sentence> sentences) {
        this.sentences = sentences;
    }

    public Paragraph(List<Sentence> sentences) {
        this.sentences = sentences;
    }

    @Override
    public String toSourceString() {
        StringBuilder sb = new StringBuilder();
        for (Sentence sentence : sentences) {
            sb.append(sentence.toSourceString());
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
