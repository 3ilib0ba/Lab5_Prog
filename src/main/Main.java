package main;

import commands.Execute;
import commands.ReadCommand;

import java.util.Date;

public class Main {
    public static Date dateOfInit;

    public static void main(String[] args) {
        MyTreeMap MyMap = new MyTreeMap(); // Создание TreeMap в которой будут обработаны элементы
        dateOfInit = new Date();
        for (String s : args) {
            MyMap.addToTree(ReadCommand.readTheCollection(s)); // all files args[] -> Collection
        }
        //MyMap.addToTree(ReadCommand.readTheCollection("FLAT.json"));
        Execute.execute(MyMap);
    }
}
