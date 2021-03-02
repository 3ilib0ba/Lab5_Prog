package commands;

import commands.countcommands.CountLess;
import commands.filterbyargument.FilterStartsByName;
import commands.help.CommandHelp;
import commands.history.HistoryCommand;
import commands.info.CommandInfo;
import commands.insertandupdate.CommandInsert;
import commands.insertandupdate.CommandUpdate;
import commands.minbyid.MinById;
import commands.removecommands.ClearCommand;
import commands.removecommands.RemoveByKey;
import commands.removecommands.RemoveByLower;
import commands.replace.ReplaceByKeyLowe;
import commands.show.CommandShow;
import commands.uploadandread.SaveCommand;
import typesfiles.MyTreeMap;

import java.util.Scanner;

public class Execute {

    /**
     * @param map
     */

    public static void execute(MyTreeMap map) {
        Scanner SCANNER = new Scanner(System.in);
        String command, execCom;
        String[] commands;

        do {
            System.out.print("Enter the command: ");
            command = SCANNER.nextLine(); // ожидание новой команды

            commands = command.toLowerCase().split(" ");
            execCom = commands[0];

            switch (execCom) {

                case "help":
                    if (commands.length == 1) {
                        CommandHelp.helpCommand();
                    } else {
                        System.out.println("Команда help_<...> не воспринята");
                    }
                    break;

                case "info":
                    if (commands.length == 1) {
                        CommandInfo.infoCommand(map);
                    } else {
                        System.out.println("Команда info_<...> не воспринята");
                    }
                    break;

                case "show":
                    if (commands.length == 1) {
                        CommandShow.showCommand(map);
                    } else {
                        System.out.println("Команда show_<...> не воспринята");
                    }
                    break;

                case "insert":
                    if (commands.length == 1) {
                        System.out.println("Ожидается введение ключа элемента");
                    } else if (commands.length >= 3) {
                        System.out.println("Команда имеет вид \"insert <ключ нового элемента>\"");
                    } else {
                        try {
                            Integer newKey = Integer.parseInt(commands[1]);
                            CommandInsert commandInsert = new CommandInsert(newKey, map, false);
                        } catch (NumberFormatException e) {
                            System.out.println("требуется ввести ключ нового элемента, тип - Integer");
                        }
                    }
                    break;

                case "update":
                    if (commands.length == 1) {
                        System.out.println("Ожидается введение id элемента");
                    } else if (commands.length >= 3) {
                        System.out.println("Команда имеет вид \"update <id обновляемого элемента>\"");
                    } else {
                        try {
                            int idUpd = Integer.parseInt(commands[1]);
                            new CommandUpdate(idUpd, map);
                        } catch (NumberFormatException e) {
                            System.out.println("требуется ввести ключ нового элемента, тип - int");
                        }
                    }
                    break;

                case "remove":
                    if (commands.length == 1) {
                    } else {
                        if (commands[1].equals("key")) { // обработка команды remove key
                            if (commands.length == 3) {
                                try {
                                    Integer newKey = Integer.parseInt(commands[2]);
                                    new RemoveByKey(map.getMyMap(), newKey);
                                } catch (NumberFormatException e) {
                                    System.out.println("требуется ввести ключ нового элемента, тип - Integer");
                                }
                            } else {
                                System.out.println("Введен неверный формат, необходимо 'remove key <ЧИСЛО>'");
                            }
                        } else if (commands[1].equals("lower")) { // обработка команды remove lower
                            if (commands.length == 3) {
                                try {
                                    long comp = Long.parseLong(commands[2]);
                                    new RemoveByLower(map.getMyMap(), comp);
                                } catch (NumberFormatException e) {
                                    System.out.println("требуется ввести минимальную площадь, тип - long");
                                }
                            } else {
                                System.out.println("Введен неверный формат, необходимо 'remove lower <ЧИСЛО>'");
                            }
                        } else {
                            System.out.println("remove <...> не воспринята");
                        }
                    }
                    break;

                case "clear":
                    if (commands.length == 1) {
                        new ClearCommand(map.getMyMap());
                    } else {
                        System.out.println("команда clear <...> не распознана");
                    }
                    break;

                case "save":
                    if (commands.length == 1) {
                        SaveCommand.startSaveFile(map.getMyMap());
                    } else {
                        System.out.println("команда save <...> не распознана");
                    }
                    break;

                case "execute_script":
                    break;
                case "history":
                    if (commands.length == 1) {
                        HistoryCommand.printHistory();
                    } else {
                        System.out.println("Для получения истории команд введите 'history'");
                    }
                    break;

                case "replace":
                    if (commands.length == 5 && commands[1].equals("if") && commands[2].equals("lowe")) {
                        try {
                            Integer newKey = Integer.parseInt(commands[3]);
                            long newArea = Long.parseLong(commands[4]);
                            new ReplaceByKeyLowe(map.getMyMap(), newKey, newArea);
                        } catch (NumberFormatException e) {
                            System.out.println("требуется ввести ключ нового элемента, тип - Integer,\n" +
                                    "а также его новое значение площади, тип - long");
                        }
                    } else {
                        System.out.println("Формат задан неверно");
                    }
                    break;

                case "min":
                    if (commands.length == 3 && commands[1].equals("by") && commands[2].equals("id")) {
                        new MinById(map.getMyMap());
                    } else {
                        System.out.println("Формат команды - 'min by id'");
                    }
                    break;

                case "count":
                    new CountLess(command, map);
                    break;

                case "filter":
                    new FilterStartsByName(map, command);
                    break;

                case "exit":
                    System.out.println("Завершаю программу");
                    return;

                default:
                    System.out.println("Команда не распознана");
                    break;
            }
        }
        while (true);
    }
}
