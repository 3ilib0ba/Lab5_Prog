package commands.removecommands;

import commands.history.HistoryCommand;
import typesfiles.Flat;

import java.util.TreeMap;

public class RemoveByKey {
    public RemoveByKey(TreeMap<Integer, Flat> map, Integer keyRemoved) {
        if (map.containsKey(keyRemoved)) {
            Flat removed = map.remove(keyRemoved);
            System.out.println("Удален объект " + removed);
        } else {
            System.out.println("Элементы с таким key не найден");
        }

        HistoryCommand.addHistory("remove key <...>");
    }
}
