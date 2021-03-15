package commands;

import com.google.gson.Gson;
import typesfiles.Flat;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.util.Scanner;
import java.util.TreeMap;

/**
 * Class for saving a collection to a file
 */
public class SaveCommand {
    private static int numericOfSave = 1;

    /**
     * function for save
     * @param collection - saving collection
     * @param name - name of file
     */
    public static void saveTheCollection(TreeMap<Integer, Flat> collection, String name) {
        String path = "saves/";
        try (BufferedWriter bufWr = new BufferedWriter(new FileWriter(path + name + ".json"))) {
            bufWr.write(new Gson().toJson(collection));
            System.out.println("Saved into -> " + name + ".json");
        } catch (Exception e) {
            System.out.println("Error");
        }
    }

    /**
     * function for get name of saving file
     * @param map - saving map
     * @param scanner - mod of saving
     */
    public static void startSaveFile(TreeMap<Integer, Flat> map, Scanner scanner) {
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
