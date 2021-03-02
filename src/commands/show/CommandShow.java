package commands.show;

import commands.history.HistoryCommand;
import typesfiles.MyTreeMap;

public class CommandShow {
    public static void showCommand(MyTreeMap map) {
        if (map.getMyMap().size() == 0) {
            System.out.println("Коллекция пустая(можно исправить командой insert <key>)");
        } else {
            System.out.println("Вывод всех элементов списка квартир");
            for (Integer key : map.getMyMap().keySet()) {
                System.out.println(map.getMyMap().get(key));
            }
        }

        HistoryCommand.addHistory("Show");
    }
}
