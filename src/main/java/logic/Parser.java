package logic;
import entity.Letter;
import entity.Sentence;
import entity.Word;

import java.util.ArrayList;

public class Parser {
    /**
     * @param string
     * @return ArrayList<Letter>
     * Parse string on letters array
     */
    public static ArrayList<Letter> parseLetter(String string) {
        ArrayList<Letter> result = new ArrayList<Letter>();
        System.arraycopy(string, 0, result, 0, string.length());
        /*for(char s: string.toCharArray()) {
            letters.add(new Letter(s));
        }*/
        return result;
    }

    /**
     * @param word
     * @return ArrayList<Letter>
     * Parse word on letters array
     */
    public static ArrayList<Letter> parseLetter(Word word) {
        ArrayList<Letter> result = new ArrayList<Letter>();
        /*for(char s: word.toCharArray()) {
            result.add(new Letter(s));
        }*/
        System.arraycopy(word.getValue(), 0, result, 0, word.getValue().length());
        return result;
    }

    public static ArrayList<Word> parseWord(Sentence offer) {
        ArrayList<Word> result = new ArrayList<Word>();
        System.arraycopy(offer, 0, result, 0, offer.getValue().size());
        return result;
    }
}
