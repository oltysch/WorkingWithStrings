package logic;
import entity.*;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Parser {

    /*String regexParagraph = ("\\S+.+?(\\.|\\!|\\?)\\n");
    Pattern patternParagraph = Pattern.compile(regexParagraph);
    Matcher matcherParagraph = patternParagraph.matcher(text);*/

    public <T extends Composite> T parse(String s, Class<T> aClass) {
        Class comosite = aClass.getDeclaringClass();

        return null;
    }

    public Text parseText(String input) {
        String[] temp = input.split("\\n");
        List<Paragraph> paragraphs=new ArrayList<Paragraph>();
        for (String part: temp) {
            Paragraph paragraph = parseParagraph(part);
            paragraphs.add(paragraph);
        }
        return new Text(paragraphs);
    }

    private Paragraph parseParagraph(String input) {
        String[] temp = input.split("([.?!] )");
        List<Sentence> sentences = new ArrayList<Sentence>();
        for (String part: temp) {
            Sentence sentence = parseSentence(part);
            sentences.add(sentence);
        }
        return new Paragraph(sentences);
    }

    private Sentence parseSentence(String input) {
        String[] temp = input.split("\\s");
        List<Word> words = new ArrayList<Word>();
        for (String part: temp) {
            Word word = parseWord(part);
            words.add(word);
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

//    trying make the universal parser
    /*public Component parse() {
        return new Component;
    }*/
}
