package commands.filterbyargument;

import commands.history.HistoryCommand;
import typesfiles.MyTreeMap;

public class FilterStartsByName {
    public FilterStartsByName(MyTreeMap map, String fullCom) {
        String[] operand = fullCom.split(" ");
        if (operand.length >= 2) {
            StringBuilder allStr = new StringBuilder("");
            for (String str : operand) {
                allStr.append(str);
            }
            System.out.println(allStr);
            if (allStr.toString().contains("filterstartswithname")) {
                allStr.delete(0, "filterstartswithname".length());
                outputFlatsWithName(map, allStr.toString());
            }
        } else {
            System.out.println("Команда filter не распознана");
        }

        HistoryCommand.addHistory("filter command...");
    }

    private void outputFlatsWithName(MyTreeMap map, String name) {
        for (Integer keyNow : map.getMyMap().keySet()) {
            if (map.getMyMap().get(keyNow).getName().replace(" ", "").startsWith(name))
                System.out.println(map.getMyMap().get(keyNow));
        }
    }
}
