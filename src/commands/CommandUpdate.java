package commands;

import commands.exceptions.InvalidArg;
import main.MyTreeMap;
import typesfiles.Flat;

import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class CommandUpdate {
    public CommandUpdate(int idUpd, MyTreeMap map, Scanner scanner){
        try {
            Integer keyOfUpd = checkId(idUpd, map.getMyMap());
            System.out.println(keyOfUpd);
            new CommandInsert(keyOfUpd, map, true, scanner);
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
