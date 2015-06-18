package entity;

import java.util.List;

/**
 * Created by Admin on 18.06.2015.
 */
public class Text {
    private List<Paragraph> paragraphs;

    public List<Paragraph> getParagraphs() {
        return paragraphs;
    }

    public void setParagraphs(List<Paragraph> paragraphs) {
        this.paragraphs = paragraphs;
    }

    public Text(List<Paragraph> paragraphs) {
        this.paragraphs = paragraphs;
    }
}
