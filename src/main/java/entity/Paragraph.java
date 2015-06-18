package entity;

import java.util.List;

public class Paragraph {
    private List<Sentence> sentences;

    public List<Sentence> getSentences() {
        return sentences;
    }

    public void setSentences(List<Sentence> sentences) {
        this.sentences = sentences;
    }

    public Paragraph(List<Sentence> sentences) {
        this.sentences = sentences;
    }
}
