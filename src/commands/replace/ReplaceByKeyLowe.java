package commands.replace;

import commands.history.HistoryCommand;
import typesfiles.Flat;

import java.util.TreeMap;

public class ReplaceByKeyLowe {
    public ReplaceByKeyLowe(TreeMap<Integer, Flat> map, Integer key, long area) {
        if (map.containsKey(key)) {
            replacing(map, key, area);
        } else {
            System.out.println("Не найден элемент с таким <KEY>");
        }
    }

    private void replacing(TreeMap<Integer, Flat> map, Integer key, long area){
        if (map.get(key).getArea() > area) {
            map.get(key).setArea(area);
            System.out.println("Замена успешно произведена");
        } else {
            System.out.println("Площадь не уменьшилась");
        }

        HistoryCommand.addHistory("Replace if lowe");
    }
}
