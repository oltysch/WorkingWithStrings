package entity;

import java.util.List;

/**
 * Created by Admin on 10.06.2015.
 */
public class Sentence extends AbstractComposite<SentencePart> {
    public Sentence() {
    }

    @Override
    public String toSourceString() {
        return super.toSourceString();
    }

    @Override
    public void add(SentencePart sentencePart) {
        super.add(sentencePart);
    }
}
