package logic;

import java.io.*;
import java.util.List;

/**
 * Created by Admin on 10.06.2015.
 */
public class FileWorks {

    public static String readFile(String fileName) throws FileNotFoundException {
        StringBuilder stringBuilder = new StringBuilder();

        exists(fileName);

        return "";

    }

    public static void exists(String fileName) throws FileNotFoundException {
        File file = new File(fileName);
        if (!file.exists()) throw new FileNotFoundException(file.getName());
    }

    public static void createFile(String filename) {
        File file = new File(filename);
        try {
            file.createNewFile();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
