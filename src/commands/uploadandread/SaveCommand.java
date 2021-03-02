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
    public static void saveTheCollection(TreeMap<Integer, Flat> collection, String name){
        String path = "C:\\Users\\evonn\\Desktop\\itmoAll\\Программирование\\Лаба_5 прога\\src\\resourse\\saves\\";
        try (BufferedWriter bufWr = new BufferedWriter(new FileWriter(path + name + ".json"))) {
            bufWr.write(new Gson().toJson(collection));
            System.out.println("Коллекция сохранена в файл -> " + name + ".json");
        } catch (Exception e) {
            System.out.println();
        }
    }

    public static void startSaveFile(TreeMap<Integer, Flat> map) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Имя файла, в который необходимо сохранить коллекцию: ");
        String name = scanner.nextLine();
        if (name.equals("")) {
            System.out.println("Сохранение в файл с именем по умолчанию");
            new SaveCommand(map);
        } else {
            new SaveCommand(map, name);
        }

        HistoryCommand.addHistory("Save");
    }

    public SaveCommand(TreeMap<Integer, Flat> collection){
        String name = "save " + numericOfSave;
        saveTheCollection(collection, name);
        numericOfSave++;
    }

    public SaveCommand(TreeMap<Integer, Flat> collection, String name){
        saveTheCollection(collection, name);
    }
}
