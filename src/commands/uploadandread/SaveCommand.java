package commands.uploadandread;

import com.google.gson.Gson;
import commands.history.HistoryCommand;
import typesfiles.Flat;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.util.Scanner;
import java.util.TreeMap;

public class SaveCommand {
    private static int numericOfSave = 1;

    public static void saveTheCollection(TreeMap<Integer, Flat> collection, String name) {
        String path = "saves\\";
        try (BufferedWriter bufWr = new BufferedWriter(new FileWriter(path + name + ".json"))) {
            bufWr.write(new Gson().toJson(collection));
            System.out.println("Saved into -> " + name + ".json");
        } catch (Exception e) {
            System.out.println("Error");
        }
    }

    public static void startSaveFile(TreeMap<Integer, Flat> map) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Input filename: ");
        String name = scanner.nextLine();
        if (name.equals("")) {
            System.out.println("casual filename");
            new SaveCommand(map);
        } else {
            new SaveCommand(map, name);
        }

        HistoryCommand.addHistory("Save");
    }

    public SaveCommand(TreeMap<Integer, Flat> collection) {
        String name = "save " + numericOfSave;
        saveTheCollection(collection, name);
        numericOfSave++;
    }

    public SaveCommand(TreeMap<Integer, Flat> collection, String name) {
        saveTheCollection(collection, name);
    }
}
