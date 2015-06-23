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
        sentenceBorder = pm.getProperty("sentenceBorder.regex");
        word = pm.getProperty("word.regex");
        wordBorder = pm.getProperty("wordBorder.regex");
    }

    public Text parseText(String input) {
        String[] temp = input.split(paragraph);
        List<Paragraph> paragraphs=new ArrayList<Paragraph>();
        for (String part: temp) {
            Paragraph paragraph = parseParagraph(part);
            paragraphs.add(paragraph);
        }
        return new Text(paragraphs);
    }

    private Paragraph parseParagraph(String input) {
        Pattern pattern = Pattern.compile(sentence);
        Matcher matcher = pattern.matcher(input);
        List<Sentence> sentences = new ArrayList<Sentence>();
        while (matcher.find()) {
            if (!matcher.group().matches(sentenceBorder)) {
                sentences.add(parseSentence(matcher.group()));
            } else {
                if (sentences.size() > 0)
                    sentences.get(sentences.size() - 1).setBound(matcher.group());
            }
        }
        return new Paragraph(sentences);
    }

    private Sentence parseSentence(String input) {
        Pattern pattern = Pattern.compile(word);
        Matcher matcher = pattern.matcher(input);
        List<Word> words = new ArrayList<Word>();
        while (matcher.find()) {
            if (!matcher.group().matches(wordBorder)) {
                words.add(parseWord(matcher.group()));
            } else {
                if (words.size() > 0)
                    words.get(words.size() - 1).setBound(matcher.group());
            }
        }
        return new Sentence(words);
    }

    private Word parseWord(String input) {
        List<Char> chars = new ArrayList<Char>();
        for (int i=0; i<input.length(); i++) {
            chars.add(new Char(input.charAt(i)));
        }
        return new Word(chars);
    }
}
