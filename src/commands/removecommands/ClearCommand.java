package commands.removecommands;

import commands.history.HistoryCommand;
import typesfiles.Flat;

import java.util.TreeMap;

public class ClearCommand {
    public ClearCommand(TreeMap<Integer, Flat> map) {
        map.clear();
        System.out.println("Коллекция очищена, для добавления новых элементов воспользуйтесь 'insert <key>'");

        HistoryCommand.addHistory("Clear");
    }
}
