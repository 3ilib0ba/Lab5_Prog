package commands.history;

import java.util.Iterator;
import java.util.LinkedList;

public abstract class HistoryCommand {
    public static final int HISTORYSIZE = 7;

    public static LinkedList<String> historyList = new LinkedList<>();

    public static void addHistory(String nameOfCommand){
        if (historyList.size() < HISTORYSIZE) {
            historyList.add(nameOfCommand);
        } else {
            historyList.removeFirst();
            historyList.addLast(nameOfCommand);
        }
    }

    public static void printHistory() { // Метод для выполнения команды history
        addHistory("history");
        Iterator<String> iterator = historyList.iterator();
        int counter = 1;

        while (iterator.hasNext()) {
            System.out.println(counter++ + ") " + iterator.next());
        }
    }
}
