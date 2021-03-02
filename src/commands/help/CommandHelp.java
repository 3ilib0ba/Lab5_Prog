package commands.help;

import commands.history.HistoryCommand;

public class CommandHelp {
    public static void helpCommand() {
        System.out.println("Текущие доступные команды:" +
                "\n\thelp: Вывод справки по доступным командам" +
                "\n\tinfo: Вывод подробной информации о TreeMap" +
                "\n\tshow: Вывод всех элементов коллекции в строковом представлении" +
                "\n\tinsert <KEY>: Заполнение и добавление нового элемента" +
                "\n\tupdate <ID>: Обновление элемента по его заданному id" +
                "\n\tremove key <key>: Удаление элемента по его ключу" +
                "\n\tclear: Очистка коллекции" +
                "\n\tsave: Сохранить коллекцию в файл" +
                "\n\texecute script <FileName>: Запуск файла с командами" +
                "\n\tremove lower <area>: Запуск файла с командами" +
                "\n\thistory: вывод истории последних команд" +
                "\n\treplace if lowe <KEY, AREA>: Замена элемента по ключу, если новое значение меньше" +
                "\n\tmin by id: Вывод элемента с наименьшим id" +
                "\n\tcount less than number of bathrooms <NUMBER>: Вывод количества элементов, у которых ванных меньше чем задано" +
                "\n\tfilter starts with name <STARTofNAME>: Вывод всех элементов, имя которых начинается с STARTofNAME" +

                "\n\texit: Выход из программы(коллекция не сохраненяется при этой команде)" +
                "\n");

        HistoryCommand.addHistory("help");
    }
}
