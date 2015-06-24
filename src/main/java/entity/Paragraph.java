package entity;

import java.util.List;

public class Paragraph extends AbstractComposite<Sentence> {

    public Paragraph() {
        super();
    }

    @Override
    public String toSourceString() {
        return super.toSourceString();
    }

    @Override
    public void add(Sentence sentence) {
        super.add(sentence);
    }

    @Override
    public Sentence get(int index) {
        return super.get(index);
    }
}
