package commands.countcommands;

import commands.history.HistoryCommand;
import typesfiles.MyTreeMap;
import typesfiles.Flat;

import java.util.Map;

public class CountLess {
    public CountLess(String fullCom, MyTreeMap map) {
        String[] operand = fullCom.toLowerCase().split(" ");
        if (operand.length >= 2) {
            if (operand.length == 7 && operand[1].equals("less")
                                    && operand[2].equals("than")
                                    && operand[3].equals("number")
                                    && operand[4].equals("of")
                                    && operand[5].equals("bathrooms")) {
                try {
                    int number = Integer.parseInt(operand[6]);
                    countLessThanNumOfBath(map, number);
                } catch (NumberFormatException e) {
                    System.out.println("количество ванных комнат это число типа int");
                }
            }
        } else {
            System.out.println("Неверный формат команды 'count <...>'");
        }

        HistoryCommand.addHistory("count...");
    }

    private void countLessThanNumOfBath(MyTreeMap map, int numBath) {
        int counter = 0;
        for (Map.Entry<Integer, Flat> entry : map.getMyMap().entrySet()) {
            if (entry.getValue().getNumberOfBathrooms() < numBath)
                counter++;
        }
        System.out.println("В коллекции находится " + counter + " объектов у которых ванных комнат меньше чем вы задали");
    }
}