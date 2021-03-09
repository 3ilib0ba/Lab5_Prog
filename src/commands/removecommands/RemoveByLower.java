package commands.removecommands;

import commands.history.HistoryCommand;
import typesfiles.Flat;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.TreeMap;

public class RemoveByLower {
    public RemoveByLower(TreeMap<Integer, Flat> map, long areaAtr) {
        List<Integer> keysRemoved = new LinkedList<>();

        map.forEach((key, value) -> {
            long b = value.getArea() - areaAtr;
            if (b < 0) {
                keysRemoved.add(key);
            }
        });

        Iterator<Integer> iterator = keysRemoved.iterator();
        while (iterator.hasNext()) {
            map.remove(iterator.next());
        }

        HistoryCommand.addHistory("remove lower <...>");
    }
}
