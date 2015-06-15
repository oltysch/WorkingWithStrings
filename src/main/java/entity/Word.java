package entity;

import java.util.ArrayList;

/**
 * Created by Admin on 10.06.2015.
 */
public class Word {
    private String value;

    public Word() {
    }

    public Word(String value) {

        this.value = value;
    }

    public String getValue() {

        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public char[] toCharArray() {
        char[] result= new char[value.length()];
        System.arraycopy(value, 0, result, 0, value.length());
        return result;
    }

    /*public Letter toLetterArray() {
        char[] result= new char[value.length()];
        System.arraycopy(value, 0, result, 0, value.length());
        return result;
    }*/
}
