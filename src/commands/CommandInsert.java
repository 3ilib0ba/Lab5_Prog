package commands;

import commands.exceptions.InvalidArg;
import main.MyTreeMap;
import typesfiles.Coordinates;
import typesfiles.Flat;
import typesfiles.Furnish;
import typesfiles.House;

import java.util.Scanner;

import static main.MyTreeMap.ID_MAX;

public class CommandInsert {
    Scanner scanner;
    private int id; // Значение поля должно быть больше 0,
    // Значение этого поля должно быть уникальным,
    // Значение этого поля должно генерироваться автоматически
    private String name; // Поле не может быть null, Строка не может быть пустой
    private Coordinates coordinates = new Coordinates(0, 0); // Поле не может быть null
    //private java.util.Date creationDate; // Поле не может быть null, Значение этого поля должно генерироваться автоматически
    private long area; // Максимальное значение поля: 667, Значение поля должно быть больше 0
    private Long numberOfRooms; // Поле может быть null, Значение поля должно быть больше 0
    private int numberOfBathrooms; // Значение поля должно быть больше 0
    private long timeToMetroOnFoot; // Значение поля должно быть больше 0
    private Furnish furnish; // Поле не может быть null
    private House house;

    public CommandInsert(Integer key, MyTreeMap map, boolean fromUpdate, Scanner scanner) {
        execute(key, map, scanner);

        if (fromUpdate)
            HistoryCommand.addHistory("Update");
        else
            HistoryCommand.addHistory("Insert");
    }

    private void execute(Integer key, MyTreeMap map, Scanner scanner){
        this.scanner = scanner;
        id = ID_MAX;

        try {
            name = this.setName();          // обработка имени
            coordinates.setX(setNewX());    // обработка координаты X
            coordinates.setY(setNewY());    // обработка координаты Y
            area = setNewArea();            // задали площадь квартиры
            numberOfRooms = setNumOfRooms();            // задали количество комнат
            numberOfBathrooms = setNumOfBathrooms();    // задали количество ванных
            timeToMetroOnFoot = setTimeMetro();         // задали время до метро
            furnish = setFurnish();                     // задали тип интерьера
            house = setHouse();                         // указали дом

            Flat newFlat = Flat.newBuilder()
                    .setId(id)
                    .setName(name)
                    .setCoordinates(coordinates)
                    .setCreationDate()
                    .setArea(area)
                    .setNumberOfRooms(numberOfRooms)
                    .setNumberOfBathrooms(numberOfBathrooms)
                    .setTimeToMetroOnFoot(timeToMetroOnFoot)
                    .setFurnish(furnish)
                    .setHouse(house)
                    .build();
            map.addFlat(key, newFlat); // Поместили квартиру в map

        } catch (InvalidArg e) {
            System.out.println(e.getMessage());
        } catch (Exception e) {
            System.out.println("Wrong format");
        }
    }

    private String setName()
            throws InvalidArg {
        try {
            System.out.print("Input name: ");
            String a = scanner.nextLine();
            if (a.equals("")) {
                throw new InvalidArg("Name isn't empty");
            }
            return a;
        } catch (InvalidArg e) {
            System.out.println(e.getMessage());
            return setName();
        } catch (Exception e) {
            System.out.println("Error input");
            return setName();
        }
    }

    private Float setNewX()
            throws InvalidArg {
        try {
            System.out.print("Input X coordinate: ");
            String answer = scanner.nextLine();
            float newX = Float.parseFloat(answer);
            if (newX < 0f || newX > 483f) {
                throw new InvalidArg("X in [0; 483]");
            }
            return newX;
        } catch (InvalidArg e) {
            System.out.println(e.getMessage());
            return setNewX();
        } catch (Exception e) {
            System.out.println("Input error");
            return setNewX();
        }
    }

    private double setNewY()
            throws InvalidArg {
        try {
            System.out.print("Input Y coordinate: ");
            String answer = scanner.nextLine();
            double newY = Double.parseDouble(answer);
            if (newY < 0 || newY > 311) {
                throw new InvalidArg("Y in [0; 311]");
            }
            return newY;
        } catch (InvalidArg e) {
            System.out.println(e.getMessage());
            return setNewY();
        } catch (Exception e) {
            System.out.println("Input error");
            return setNewY();
        }
    }

    private long setNewArea()
            throws InvalidArg {
        try {
            System.out.print("Input area to object: ");
            String answer = scanner.nextLine();
            long newArea = Long.parseLong(answer);
            if (newArea <= 0 || newArea > 667) {
                throw new InvalidArg("AREA in [0; 667]");
            }
            return newArea;
        } catch (InvalidArg e) {
            System.out.println(e.getMessage());
            return setNewArea();
        } catch (Exception e) {
            System.out.println("Input error");
            return setNewArea();
        }
    }

    private Long setNumOfRooms()
            throws InvalidArg {
        try {
            System.out.print("Input count of rooms: ");
            String answer = scanner.nextLine();
            if (answer.equals("")) {
                return null;
            }
            Long newNum = Long.parseLong(answer);
            if (newNum <= 0) {
                throw new InvalidArg("count > 0");
            }
            return newNum;
        } catch (InvalidArg e) {
            System.out.println(e.getMessage());
            return setNumOfRooms();
        } catch (Exception e) {
            System.out.println("Input error");
            return setNumOfRooms();
        }
    }

    private int setNumOfBathrooms()
            throws InvalidArg {
        try {
            System.out.print("Input count of bathrooms: ");
            String answer = scanner.nextLine();
            int number = Integer.parseInt(answer);
            if (number <= 0) {
                throw new InvalidArg("count > 0");
            }
            return number;
        } catch (InvalidArg e) {
            System.out.println(e.getMessage());
            return setNumOfBathrooms();
        } catch (Exception e) {
            System.out.println("Input error");
            return setNumOfBathrooms();
        }
    }

    private long setTimeMetro() {
        try {
            System.out.print("Input time of walk to the metro: ");
            String answer = scanner.nextLine();
            long number = Long.parseLong(answer);
            if (number <= 0) {
                throw new InvalidArg("Time > 0");
            }
            return number;
        } catch (InvalidArg e) {
            System.out.println(e.getMessage());
            return setTimeMetro();
        } catch (Exception e) {
            System.out.println("Input error");
            return setTimeMetro();
        }
    }

    private Furnish setFurnish() {
        System.out.print("Input characteristics of the interior:" + "\n" +
                "\t\t" + "1) Designer" + "\n" +
                "\t\t" + "2) None" + "\n" +
                "\t\t" + "3) Fine" + "\n" +
                "\t\t" + "4) Bad" + "\n" +
                "\t\t" + "5) Little" + "\n"
        );
        System.out.print("Your choice: ");
        String answer = scanner.nextLine();
        switch (answer.toUpperCase()) {
            case "DESIGNER":
                return Furnish.DESIGNER;
            case "NONE":
                return Furnish.NONE;
            case "FINE":
                return Furnish.FINE;
            case "BAD":
                return Furnish.BAD;
            case "LITTLE":
                return Furnish.LITTLE;
            default:
                System.out.println("Input error, try it again");
                return setFurnish();
        }
    }

    /**
     * Далее метод setHouse возвращает новый объект класса House
     * Прочие методы вспомогательные
     *
     * @return House
     * @throws InvalidArg
     */

    private int setYear()
            throws InvalidArg {
        try {
            System.out.print("Enter the year the house was built: ");
            String answer = scanner.nextLine();
            int number = Integer.parseInt(answer);
            if (number <= 0) {
                throw new InvalidArg("year > 0");
            }
            return number;
        } catch (InvalidArg e) {
            System.out.println(e.getMessage());
            return setYear();
        } catch (Exception e) {
            System.out.println("Enter error");
            return setYear();
        }
    }

    private int setNumberOfFlatsOnFloor()
            throws InvalidArg {
        try {
            System.out.print("Enter the number of flats per floor: ");
            String answer = scanner.nextLine();
            int number = Integer.parseInt(answer);
            if (number <= 0) {
                throw new InvalidArg("number of flats > 0");
            }
            return number;
        } catch (InvalidArg e) {
            System.out.println(e.getMessage());
            return setNumberOfFlatsOnFloor();
        } catch (Exception e) {
            System.out.println("Input error");
            return setNumberOfFlatsOnFloor();
        }
    }

    private int setNumberOfLifts()
            throws InvalidArg {
        try {
            System.out.print("How many lifts in the house: ");
            String answer = scanner.nextLine();
            int number = Integer.parseInt(answer);
            if (number <= 0) {
                throw new InvalidArg("count of lifts > 0");
            }
            return number;
        } catch (InvalidArg e) {
            System.out.println(e.getMessage());
            return setNumberOfLifts();
        } catch (Exception e) {
            System.out.println("Input error");
            return setNumberOfLifts();
        }
    }

    private House setHouse()
            throws InvalidArg {
        String name;                    //Поле не может быть null
        int year;                       //Значение поля должно быть больше 0
        int numberOfFlatsOnFloor;   //Значение поля должно быть больше 0
        Integer numberOfLifts;      //Значение поля должно быть больше 0

        System.out.println("creating a house");

        name = setName();
        year = setYear();
        numberOfFlatsOnFloor = setNumberOfFlatsOnFloor();
        numberOfLifts = setNumberOfLifts();

        return new House(name, year, numberOfFlatsOnFloor, numberOfLifts);
    }

}
