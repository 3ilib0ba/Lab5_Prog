package commands.info;

import commands.history.HistoryCommand;
import typesfiles.MyTreeMap;

import static main.Main.dateOfInit;

public class CommandInfo {
    public static void infoCommand(MyTreeMap map) {
        System.out.println("Info of map:" +
                "\n\tТип карты:" + map.getMyMap().getClass() +
                "\n\tДата инициализации:" + dateOfInit +
                "\n\tКоличество элементов:" + map.getMyMap().size() +
                "\n\tДля подробной информации -> show");

        HistoryCommand.addHistory("info");
    }
}
