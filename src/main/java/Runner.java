import entity.Text;
import logic.FileWorks;
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
            string = FileWorks.readFile("123.txt");
        } catch (FileNotFoundException e) {
            string = "Just test text. sentence 2 phash, 89 uiyas.\n" +
                    "and an new paragraph. just one. and one sentence, with puntctuations!\n" +
                    "or sfsf jsafe aeafe. eaefe safe effaf. eaefe oiaje joifeae.";
        }
        Text text = parser.parseText(string);
        System.out.println("Исходный текст: \n" + string + "\n");
        System.out.println("Результат:\n" + text.toSourceString());
    }

    /**
     * @return int (user input)
     * Just tests, do not use this method.
     * Requests enter the number to the correct input
     */
    public static int testReadNumber() {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int res;
        System.out.println("введите цифру:");
        try {
            res = Integer.parseInt(reader.readLine());
            return res;
        } catch (Throwable e) {
            System.err.println("Ошибка! требуется ввести цифру.");
            return testReadNumber();
        }
    }
}
