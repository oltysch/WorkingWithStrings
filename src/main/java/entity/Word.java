package entity;

import java.util.List;

/**
 * Created by Admin on 10.06.2015.
 */
public class Word extends AbstractComposite<Char> implements SentencePart {
    public Word() {
    }

    @Override
    public void add(Char aChar) {
        super.add(aChar);
    }

    @Override
    public String toSourceString() {
        return super.toSourceString();
    }
}
