package utilities;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.List;
import java.util.Scanner;

public class Utils {

    public List<String> readFromFile(String fileName) throws IOException {
        Path path = Paths.get(fileName);
        List<String> stringList = Files.readAllLines(path);
        return stringList;

    }









    public void writeOnFile(String fileName, String content) {

        try {
            FileWriter myWriter = new FileWriter(fileName);
            myWriter.write(content);
            myWriter.close();
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }

    public void appendToFile(String fileName, String content) {
        try {
            File f = new File(fileName);

            if (f.exists())
                Files.write(Paths.get(fileName), content.getBytes(), StandardOpenOption.APPEND);
            else writeOnFile(fileName, content);
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();

        }
    }


}

