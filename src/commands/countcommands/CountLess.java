package commands.countcommands;

import commands.history.HistoryCommand;
import typesfiles.MyTreeMap;
import typesfiles.Flat;

import java.util.Map;

public class CountLess {
    public CountLess(MyTreeMap map, int number) {
        int counter = 0;

        for (Map.Entry<Integer, Flat> entry : map.getMyMap().entrySet()) {
            if (entry.getValue().getNumberOfBathrooms() < number)
                counter++;
        }
        System.out.println(counter + " objects with less number of bathrooms");

        HistoryCommand.addHistory("count_less_than_number_of_bathrooms");
    }
}