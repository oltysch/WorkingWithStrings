import java.io.*;

import static logic.FileWorks.updateFile;
import static logic.FileWorks.writeFile;

/**
 * Created by Admin on 10.06.2015.
 */
public class Runner {
    public static void main(String[] args) {
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
