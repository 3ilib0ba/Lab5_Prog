package commands;

import typesfiles.Flat;

import java.util.TreeMap;

/**
 * Class for replacing a flat with less key
 */
public class ReplaceByKeyLowe {
    public ReplaceByKeyLowe(TreeMap<Integer, Flat> map, Integer key, long area) {
        if (map.containsKey(key)) {
            replacing(map, key, area);
        } else {
            System.out.println("Element with this <KEY> not found");
        }
    }

    /**
     * method for search flats with needed area
     * @param map - map with replacing object
     * @param key - key of object
     * @param area - area of compare
     */
    private void replacing(TreeMap<Integer, Flat> map, Integer key, long area){
        if (map.get(key).getArea() > area) {
            map.get(key).setArea(area);
            System.out.println("Ok");
        } else {
            System.out.println("Area has not become smaller");
        }

        HistoryCommand.addHistory("Replace if lowe");
    }
}
