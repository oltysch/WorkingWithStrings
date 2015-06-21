package entity;

import java.util.List;

/**
 * Created by Admin on 18.06.2015.
 */
public class Text implements Composite {
    private List<Paragraph> listValues;
    private String bound;

    public List<Paragraph> getListValues() {
        return listValues;
    }

    public void setListValues(List<Paragraph> listValues) {
        this.listValues = listValues;
    }

    public Text(List<Paragraph> paragraphs) {
        this.listValues = paragraphs;
    }

    @Override
    public String toSourceString() {
        StringBuilder sb = new StringBuilder();
        for (Paragraph paragraph : listValues) {
            sb.append(paragraph.toSourceString());
            if (!(paragraph.getBound()==null))
                sb.append(paragraph.getBound());
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
