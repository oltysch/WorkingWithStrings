import entity.Paragraph;
import entity.Text;
import logic.FileWorks;
import logic.Parser;

import java.io.*;

import static logic.FileWorks.updateFile;
import static logic.FileWorks.writeFile;

/**
 * Created by Admin on 10.06.2015.
 */
public class Runner {
    public static void main(String[] args) throws FileNotFoundException {
        Parser parser = new Parser();
        String string = "Just test text. sentence 2 phash 89 uiyas.\n" +
                "and an new paragraph. just one.\n" +
                "or sfsf jsafe aeafe. eaefe safe effaf. eaefe oiaje joifeae.";
        Text text = parser.parseText(string);
    }

    public void startDemonstrate() {
        //
    }

    /**
     * @return int (user input)
     * Just tests, do not use this method.
     * Requests enter the number to the correct input
     */
    public static int testReadNumber() {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int res;
        System.out.println("before try/catch");
        System.out.println("введите цифру:");
        try {
            res=Integer.parseInt(reader.readLine());
            return res;
        }catch (Throwable e) {
            System.err.println("Ошибка! требуется ввести цифру.");
            return testReadNumber();
        }
    }
}
