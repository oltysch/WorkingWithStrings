package logic;
import entity.*;
import util.PropertyManager;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Parser {
    private String paragraph = "";
    private String sentence = "";
    private String sentenceBorder = "";
    private String word = "";
    private String wordBorder = "";

    public <T extends Composite> T parse(String s, Class<T> aClass) {
        Class comosite = aClass.getDeclaringClass();

        return null;
    }

    public void configure(PropertyManager pm) {
        paragraph = pm.getProperty("paragraph.regex");
        sentence = pm.getProperty("sentence.regex");
//        sentenceBorder = pm.getProperty("sentenceBorder.regex");
        word = pm.getProperty("word.regex");
        wordBorder = pm.getProperty("wordBorder.regex");
    }

    public Text parseText(String input) {
        Text text = new Text();
//        String[] temp = input.split(paragraph);
        Pattern pattern = Pattern.compile(paragraph);
        Matcher matcher = pattern.matcher(input);
        while (matcher.find()) {
            text.add(parseParagraph(matcher.group()));
        }
        /*for (String part: temp) {
            Paragraph paragraph = parseParagraph(part);
            text.add(paragraph);
        }*/
        return text;
    }

    private Paragraph parseParagraph(String input) {
        Paragraph paragraph = new Paragraph();
        Pattern pattern = Pattern.compile(sentence);
        Matcher matcher = pattern.matcher(input);
        while (matcher.find()) {
            paragraph.add(parseSentence(matcher.group()));
        }
        return paragraph;
    }

    private Sentence parseSentence(String input) {
        Sentence sentence = new Sentence();
        Pattern pattern = Pattern.compile(word);
        Matcher matcher = pattern.matcher(input);
        while (matcher.find()) {
            if (!matcher.group().matches(wordBorder)) {
                sentence.add(parseWord(matcher.group()));
            } else {
                for (int i = 0; i < matcher.group().length(); i++) {
                    sentence.add(new Char(matcher.group().charAt(i)));
                }
            }
        }
        return sentence;
    }

    private Word parseWord(String input) {
        Word word = new Word();
        for (int i=0; i<input.length(); i++) {
            word.add(new Char(input.charAt(i)));
        }
        return word;
    }
}
