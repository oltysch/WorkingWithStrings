package entity;

import java.util.List;

/**
 * Created by Admin on 18.06.2015.
 */
public class Text implements Composite {
    private List<Paragraph> paragraphs;
    private String bound;

    public List<Paragraph> getParagraphs() {
        return paragraphs;
    }

    public void setParagraphs(List<Paragraph> paragraphs) {
        this.paragraphs = paragraphs;
    }

    public Text(List<Paragraph> paragraphs) {
        this.paragraphs = paragraphs;
    }

    @Override
    public String toSourceString() {
        StringBuilder sb = new StringBuilder();
        for (Paragraph paragraph : paragraphs) {
            sb.append(paragraph.toSourceString());
            sb.append("\n");
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
