import entity.Text;
import logic.FileWorker;
import logic.Parser;
import util.PropertyManager;

import java.io.*;

/**
 * Created by Admin on 10.06.2015.
 */
public class Runner {
    public static void main(String[] args) {
        startDemonstrate();
    }

    public static void startDemonstrate() {
        Parser parser = new Parser();
        PropertyManager propertyManager = new PropertyManager("parser.properties");
        parser.configure(propertyManager);
        String string = null;
        try {
            string = FileWorker.readFile("123.txt");
        } catch (FileNotFoundException e) {
            string = "Just test text. sentence 2 phash, 89 uiyas.\n" +
                    "and an new paragraph. just one. and one sentence, with puntctuations!\n" +
                    "or sfsf jsafe aeafe. eaefe safe effaf. eaefe oiaje joifeae.";
        }
        Text text = parser.parseText(string);
        System.out.println("Исходный текст: \n" + string + "\n");
        System.out.println("Результат:\n" + text.toSourceString());
        String str = text.get(1).get(2).get(4).toSourceString();
        String str2 = text.get(1).get(2).get(5).toSourceString();
        String str3 = text.get(1).get(2).get(6).toSourceString();
        System.out.println("Результат вывода по одному элементу:\n" + "\n" + str + "\n" + str2 + "\n" + str3);
    }
}
