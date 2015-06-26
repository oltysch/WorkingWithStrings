package logic;

import entity.*;
import util.PropertyManager;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Parser {
    private String paragraph = "";
    private String sentence = "";
    private String sentenceBorder = "";
    private String word = "";
    private String wordBorder = "";
    private PropertyManager propertyManager;


    public <T extends Composite> T parse(String input, String inputClass) throws ClassNotFoundException, IllegalAccessException, InstantiationException {
        String sClass = propertyManager.getProperty(inputClass);
        Class<T> cClass = (Class<T>) Class.forName("entity." + inputClass);
        T t = cClass.newInstance();

        String regex = propertyManager.getProperty(sClass + ".regex");
        String regexBorder = propertyManager.getProperty(sClass + "Border.regex");
        if (regex != null) {
            Pattern pattern = Pattern.compile(regex);
            Matcher matcher = pattern.matcher(input);
            while (matcher.find())
                if ((regexBorder != null) && (matcher.group().matches(regexBorder)))
                    t.add(new Char(matcher.group().charAt(0)));
                else t.add(parse(matcher.group(), sClass));
        } else {
            t = (T) parseWord(input);
        }
        return t;

        /*String sClass = propertyManager.getProperty(inputClass);
        Class cClass = Class.forName("entity." + inputClass);
        T t = (T) cClass.newInstance();
        String regex = propertyManager.getProperty(sClass + ".regex");
        String regexBorder = propertyManager.getProperty(sClass + "Border.regex");
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(input);
        while (matcher.find()) {
            if (regexBorder == null) {
                t.add(parse(matcher.group(), sClass));
            } else {
                if (!matcher.group().matches(regexBorder)) {
                    t.add(parseWord(matcher.group()));
                } else {
                    for (int i = 0; i < matcher.group().length(); i++) {
                        t.add(new Char(matcher.group().charAt(i)));
                    }
                }
            }
        }
        return t;*/
    }

    public Parser() {
    }

    public Parser(PropertyManager propertyManager) {
        this.propertyManager = propertyManager;
    }

    public void setPropertyManager(PropertyManager propertyManager) {
        this.propertyManager = propertyManager;
    }

    /**
     * @param propertyManager configures the properties, uses specified propertyManager
     *                        USELESS FOR METHOD "parse"
     *                        works only in parseText, parseParagraph, parseSentence.
     */
    public void configure(PropertyManager propertyManager) {
        paragraph = propertyManager.getProperty("Paragraph.regex");
        sentence = propertyManager.getProperty("Sentence.regex");
//        sentenceBorder = pm.getProperty("sentenceBorder.regex");
        word = propertyManager.getProperty("Word.regex");
        wordBorder = propertyManager.getProperty("WordBorder.regex");
    }

    /**
     * configures the properties, uses self propertyManager
     * USELESS FOR METHOD "parse"
     * works only in parseText, parseParagraph, parseSentence.
     */
    public void configure() {
        paragraph = propertyManager.getProperty("Paragraph.regex");
        sentence = propertyManager.getProperty("Sentence.regex");
//        sentenceBorder = pm.getProperty("sentenceBorder.regex");
        word = propertyManager.getProperty("Word.regex");
        wordBorder = propertyManager.getProperty("WordBorder.regex");
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

    public Paragraph parseParagraph(String input) {
        Paragraph paragraph = new Paragraph();
        Pattern pattern = Pattern.compile(sentence);
        Matcher matcher = pattern.matcher(input);
        while (matcher.find()) {
            paragraph.add(parseSentence(matcher.group()));
        }
        return paragraph;
    }

    public Sentence parseSentence(String input) {
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

    public Word parseWord(String input) {
        Word word = new Word();
        for (int i = 0; i < input.length(); i++) {
            word.add(new Char(input.charAt(i)));
        }
        return word;
    }
}
