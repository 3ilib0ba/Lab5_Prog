package commands;

import main.MyTreeMap;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class ExecuteScript {
    public ExecuteScript(MyTreeMap map, String fileName) {
        String path = fileName;

        try {
            InputStreamReader inputStreamReader = new InputStreamReader(new FileInputStream(path));

            System.out.println(path);

            int nowChar;
            StringBuilder allText = new StringBuilder();
            while ((nowChar = inputStreamReader.read()) != -1)
                allText.append((char) nowChar);

            Scanner scanOfExecutFile = new Scanner(allText.toString());

            new Execute(true, map, scanOfExecutFile);
        } catch (FileNotFoundException e) {
            System.out.println("File not found...");
        } catch (IOException e) {
            System.out.println("IOException");
        }
    }
}
