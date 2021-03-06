package commands;

import commands.exceptions.NullMapException;
import typesfiles.Flat;

import java.util.Map;
import java.util.TreeMap;

/**
 * Class with 'min_by_id' command. Search and show flat with min id.
 */
public class MinById {
    public MinById(TreeMap<Integer, Flat> map) {
        try {
            Integer keyOfMinFlatById = searchMin(map);
            System.out.println(map.get(keyOfMinFlatById));
        } catch (NullMapException e) {
            System.out.println(e.getMessage());
        }

        HistoryCommand.addHistory("min by id");
    }

    /**
     * method for search key of flat(in the MAP) with min id
     * @param map - Where flat will be searching
     * @return
     * @throws NullMapException
     */
    private Integer searchMin(TreeMap<Integer, Flat> map)
            throws NullMapException{
        Integer keyNow = null;
        Integer keyOfMin = null;
        int idOfMin = 0;
        for (Map.Entry<Integer, Flat> entry : map.entrySet()) {
            if (keyNow == null) {
                keyNow = entry.getKey();
                idOfMin = entry.getValue().getId();
                keyOfMin = keyNow;
            } else {
                if (idOfMin > entry.getValue().getId()) {
                    keyNow = entry.getKey();
                    idOfMin = entry.getValue().getId();
                    keyOfMin = keyNow;
                }
            }
        }
        if (keyOfMin == null) {
            throw new NullMapException("Your collection is empty");
        }
        return keyOfMin;
    }
}
