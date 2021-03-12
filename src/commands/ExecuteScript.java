package commands;

import main.MyTreeMap;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;

public class ExecuteScript {
    public ExecuteScript(MyTreeMap map, String fileName) {
        String path = "scripts\\" + fileName;

        try {
            InputStreamReader inputStreamReader = new InputStreamReader(new FileInputStream(path));

            System.out.println(path);

            int nowChar;
            StringBuilder allText = new StringBuilder();
            while ((nowChar = inputStreamReader.read()) != -1)
                allText.append((char) nowChar);

            System.out.println(allText.toString());

        } catch (FileNotFoundException e) {
            System.out.println("File not found...");
        } catch (IOException e) {
            System.out.println("IOException");
        }
    }
}
