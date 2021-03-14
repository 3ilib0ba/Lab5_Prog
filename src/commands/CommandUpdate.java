package commands;

import main.MyTreeMap;
import typesfiles.Flat;

import java.util.Map;
import java.util.TreeMap;

public class CommandUpdate {
    public CommandUpdate(int idUpd, MyTreeMap map){
        try {
            Integer keyOfUpd = checkId(idUpd, map.getMyMap());
            System.out.println(keyOfUpd);
            new CommandInsert(keyOfUpd, map, true);
        } catch (InvalidArg e) {
            System.out.println(e.getMessage());
        }
    }

    private Integer checkId(int searchId, TreeMap<Integer, Flat> map)
            throws InvalidArg{
        for (Map.Entry<Integer, Flat> entry : map.entrySet()) {
            int id = entry.getValue().getId();
            if (id == searchId)
                return entry.getKey();
        }
        throw new InvalidArg("the given id was not found in the collection, there is nothing to update");
    }
}
