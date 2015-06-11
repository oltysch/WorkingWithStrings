package logic;

import java.io.*;
import java.util.List;

/**
 * Created by Admin on 10.06.2015.
 */
public class FileWorks {

    /**
     * @param fileName
     * @param text
     * It creates the file, and writes the text.
     */
    public static void writeFile(String fileName, String text) {
        File file = new File(fileName);

        try {
            if(!file.exists())
                file.createNewFile();
            PrintWriter out = new PrintWriter(file.getAbsoluteFile());
            try {
                out.print(text);
            } finally {
                out.close();
            }
        }catch(IOException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * @param fileName
     * @param newText
     * Adds new text in file.
     */
    public static void updateFile(String fileName, String newText) {
        File file = new File(fileName);
        StringBuilder stringBuilder = new StringBuilder();
        try {
            String oldText = readFile(fileName);
            stringBuilder.append(oldText);
            stringBuilder.append(newText);
            writeFile(fileName, stringBuilder.toString());
        }catch (FileNotFoundException e) {
            System.err.println("Ошибка, такого файла не существует");
            e.printStackTrace();
        }
    }

    /**
     * @param fileName
     * @param newText
     * Adds new text in file, or works like a writeFile.
     * this experimental method.
     */
    public static void updateFileExperimental(String fileName, String newText) {
        File file = new File(fileName);
        StringBuilder stringBuilder = new StringBuilder();
        try {
            String oldText = readFile(fileName);
            stringBuilder.append(oldText);
            stringBuilder.append(newText);
            writeFile(fileName, stringBuilder.toString());
        }catch (FileNotFoundException e) {
            writeFile(fileName, newText);
        }
    }

    /**
     * @param fileName
     * @return String (readed text)
     * @throws FileNotFoundException
     */
    public static String readFile(String fileName) throws FileNotFoundException {
        StringBuilder stringBuilder = new StringBuilder();
        File file = new File(fileName);
        if (!file.exists()) throw new FileNotFoundException(fileName);

        try {
            BufferedReader in = new BufferedReader(new FileReader( file.getAbsoluteFile()));
            try {
                String s;
                while ((s = in.readLine()) != null) {
                    stringBuilder.append(s);
                    stringBuilder.append("\n");
                }
            } finally {
                in.close();
            }
        } catch(IOException e) {
            throw new RuntimeException(e);
        }

        return stringBuilder.toString();
    }
}
