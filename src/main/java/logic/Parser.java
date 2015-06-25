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


    public <T extends Composite> T parse(String input, String inputClass) throws ClassNotFoundException, IllegalAccessException, InstantiationException {
        PropertyManager pm = new PropertyManager("parser.properties");
        String sClass = pm.getProperty(inputClass);
        Class cClass = Class.forName("entity." + inputClass);
        T t = (T) cClass.newInstance();
        String regex = pm.getProperty(sClass + ".regex");
        String regexBorder = pm.getProperty(sClass + "Border.regex");
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(input);
        while (matcher.find()) {
            if (regexBorder == null) {
                t.add(parse(matcher.group(), sClass));
            } else {
                if (!matcher.group().matches(regexBorder)) {
                    //it's may be a problem
                    t.add(parseWord(matcher.group()));
                } else {
                    for (int i = 0; i < matcher.group().length(); i++) {
                        t.add(new Char(matcher.group().charAt(i)));
                    }
                }
            }
        }
        return t;
    }

    public void configure(PropertyManager pm) {
        paragraph = pm.getProperty("Paragraph.regex");
        sentence = pm.getProperty("Sentence.regex");
//        sentenceBorder = pm.getProperty("sentenceBorder.regex");
        word = pm.getProperty("Word.regex");
        wordBorder = pm.getProperty("WordBorder.regex");
    }

    public Text parseText(String input) {
        Text text = new Text();
        Pattern pattern = Pattern.compile(paragraph);
        Matcher matcher = pattern.matcher(input);
        while (matcher.find()) {
            text.add(parseParagraph(matcher.group()));
        }
        /*String[] temp = input.split(paragraph);
        for (String part: temp) {
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
