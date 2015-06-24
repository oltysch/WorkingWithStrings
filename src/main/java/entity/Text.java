package entity;

import java.util.List;

/**
 * Created by Admin on 18.06.2015.
 */
public class Text extends AbstractComposite<Paragraph> {
    public Text() {
    }

    @Override
    public void add(Paragraph paragraph) {
        super.add(paragraph);
    }

    @Override
    public String toSourceString() {
        return super.toSourceString();
    }

    @Override
    public Paragraph get(int index) {
        return super.get(index);
    }
}
