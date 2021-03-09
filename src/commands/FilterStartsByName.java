package commands;

import typesfiles.MyTreeMap;

public class FilterStartsByName {
    public FilterStartsByName(MyTreeMap map, String[] command) {
        if (command.length != 2) {
            System.out.println("Wrong format. Need -> 'filter_starts_by_name <name/of/flat>'. Replace 'spacebutton' to '/'");
        } else {
            String name = command[1];
            name = name.replace("/", " ");
            outputFlatsWithName(map, name);
        }

        HistoryCommand.addHistory("FilterStartsByName command...");
    }

    private void outputFlatsWithName(MyTreeMap map, String name) {
        for (Integer keyNow : map.getMyMap().keySet()) {
            if (map.getMyMap().get(keyNow).getName().startsWith(name))
                System.out.println(map.getMyMap().get(keyNow));
        }
    }
}
