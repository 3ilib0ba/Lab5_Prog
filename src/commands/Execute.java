package commands;

import main.MyTreeMap;

import java.util.Scanner;

public class Execute {
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
                        System.out.println("Unknown help_<...> command");
                    }
                    break;

                case "info":
                    if (commands.length == 1) {
                        CommandInfo.infoCommand(map);
                    } else {
                        System.out.println("Unknown info_<...> command");
                    }
                    break;

                case "show":
                    if (commands.length == 1) {
                        CommandShow.showCommand(map);
                    } else {
                        System.out.println("Unknown show_<...> command");
                    }
                    break;

                case "insert":
                    if (commands.length == 1) {
                        System.out.println("wait KEY");
                    } else if (commands.length >= 3) {
                        System.out.println("Wrong format. Need -> 'insert <key>'");
                    } else {
                        try {
                            Integer newKey = Integer.parseInt(commands[1]);
                            new CommandInsert(newKey, map, false);
                        } catch (NumberFormatException e) {
                            System.out.println("type key - Integer");
                        }
                    }
                    break;

                case "update":
                    if (commands.length == 1) {
                        System.out.println("wait id");
                    } else if (commands.length >= 3) {
                        System.out.println("Wrong format. Need -> 'update <id>'");
                    } else {
                        try {
                            int idUpd = Integer.parseInt(commands[1]);
                            new CommandUpdate(idUpd, map);
                        } catch (NumberFormatException e) {
                            System.out.println("type of id - int");
                        }
                    }
                    break;

                case "remove_key":
                    if (commands.length != 2) {
                        System.out.println("Wrong format. Need -> 'remove_key <KEY>'");
                    } else {
                        try {
                            Integer newKey = Integer.parseInt(commands[1]);
                            new RemoveByKey(map.getMyMap(), newKey);
                        } catch (NumberFormatException e) {
                            System.out.println("key of object - Integer");
                        }
                    }
                    break;
                case "remove_lower":
                    if (commands.length != 2) {
                        System.out.println("Wrong format 'remove lower <numeric>'");
                    } else {
                        try {
                            long comp = Long.parseLong(commands[1]);
                            new RemoveByLower(map.getMyMap(), comp);
                        } catch (NumberFormatException e) {
                            System.out.println("min square, type - long");
                        }
                    }
                    break;

                case "clear":
                    if (commands.length == 1) {
                        new ClearCommand(map.getMyMap());
                    } else {
                        System.out.println("Unknown clear_<...> command");
                    }
                    break;

                case "save":
                    if (commands.length == 1) {
                        SaveCommand.startSaveFile(map.getMyMap());
                    } else {
                        System.out.println("Unknown save_<...> command");
                    }
                    break;

                case "execute_script":
                    //  write an execute of this command
                    break;

                case "history":
                    if (commands.length == 1) {
                        HistoryCommand.printHistory();
                    } else {
                        System.out.println("Unknown history_<...> command");
                    }
                    break;

                case "replace_if_lowe":
                    if (commands.length == 3) {
                        try {
                            Integer newKey = Integer.parseInt(commands[1]);
                            long newArea = Long.parseLong(commands[2]);
                            new ReplaceByKeyLowe(map.getMyMap(), newKey, newArea);
                        } catch (NumberFormatException e) {
                            System.out.println("\tkey type - Integer,\n" + "\tarea type - long");
                        }
                    } else {
                        System.out.println("Wrong format. Need -> 'replace_if_lowe <key> <long>'");
                    }
                    break;

                case "min_by_id":
                    new MinById(map.getMyMap());
                    break;

                case "count_less_than_number_of_bathrooms":
                    if (commands.length == 2) {
                        try {
                            int numBath = Integer.parseInt(commands[1]);
                            new CountLess(map, numBath);
                        } catch (NumberFormatException e) {
                            System.out.println("number of bathrooms -> int");
                        }
                    } else {
                        System.out.println("Wrong format. Need -> 'count_less_than_number_of_bathrooms <NUMBER>'");
                    }
                    break;

                case "filter_starts_by_name":
                    new FilterStartsByName(map, commands);
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
