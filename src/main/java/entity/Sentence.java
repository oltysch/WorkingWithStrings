package entity;

import java.util.ArrayList;

/**
 * Created by Admin on 10.06.2015.
 */
public class Sentence {
    private ArrayList value;

    public Sentence() {
    }

    public Sentence(ArrayList value) {

        this.value = value;
    }

    public ArrayList getValue() {

        return value;
    }

    public void setValue(ArrayList value) {
        this.value = value;
    }

    public ArrayList toWordArray() {
        ArrayList<Word> result= new ArrayList<Word>();
        System.arraycopy(value, 0, result, 0, value.size());
        return result;
    }
}
