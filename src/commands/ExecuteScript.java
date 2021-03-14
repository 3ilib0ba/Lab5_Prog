package commands;

import main.MyTreeMap;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class ExecuteScript {
    public ExecuteScript(MyTreeMap map, String fileName) {
        //TODO Разобраться с путями
        String path = "src\\resourse\\scripts\\" + fileName;

        try {
            InputStreamReader inputStreamReader = new InputStreamReader(new FileInputStream(path));

            System.out.println(path);

            int nowChar;
            StringBuilder allText = new StringBuilder();
            while ((nowChar = inputStreamReader.read()) != -1)
                allText.append((char) nowChar);

            Scanner scannerOfFile = new Scanner(allText.toString());
            while (scannerOfFile.hasNextLine()) {
                executeScript(scannerOfFile.nextLine());
            }
        } catch (FileNotFoundException e) {
            System.out.println("File not found...");
        } catch (IOException e) {
            System.out.println("IOException");
        }
    }

    private void executeScript(String command) {
        System.out.println(command);
    }
}
