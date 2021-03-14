package typesfiles;

import java.util.Date;

public class Flat implements Comparable<Flat> {
    private int id; //Значение поля должно быть больше 0, Значение этого поля должно быть уникальным,
    // Значение этого поля должно генерироваться автоматически
    private String name; //Поле не может быть null, Строка не может быть пустой
    private Coordinates coordinates; //Поле не может быть null
    private java.util.Date creationDate; //Поле не может быть null, Значение этого поля должно генерироваться автоматически
    private long area; //Максимальное значение поля: 667, Значение поля должно быть больше 0
    private Long numberOfRooms; //Поле может быть null, Значение поля должно быть больше 0
    private int numberOfBathrooms; //Значение поля должно быть больше 0
    private long timeToMetroOnFoot; //Значение поля должно быть больше 0
    private Furnish furnish; //Поле не может быть null
    private House house; //Поле может быть null

    private Flat() {

    }

    /**
     * Далее представлены создание объекта и геттеры
     * геттеры реализованы через public методы
     * Создание объекта через Builder
     */

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Coordinates getCoordinates() {
        return coordinates;
    }

    public Date getCreationDate() {
        return creationDate;
    }

    public long getArea() {
        return area;
    }

    public Long getNumberOfRooms() {
        return numberOfRooms;
    }

    public int getNumberOfBathrooms() {
        return numberOfBathrooms;
    }

    public long getTimeToMetroOnFoot() {
        return timeToMetroOnFoot;
    }

    public Furnish getFurnish() {
        return furnish;
    }

    public House getHouse() {
        return house;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setCoordinates(Coordinates coordinates) {
        this.coordinates = coordinates;
    }

    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }

    public void setArea(long area) {
        this.area = area;
    }

    public void setNumberOfRooms(Long numberOfRooms) {
        this.numberOfRooms = numberOfRooms;
    }

    public void setNumberOfBathrooms(int numberOfBathrooms) {
        this.numberOfBathrooms = numberOfBathrooms;
    }

    public void setTimeToMetroOnFoot(long timeToMetroOnFoot) {
        this.timeToMetroOnFoot = timeToMetroOnFoot;
    }

    public void setFurnish(Furnish furnish) {
        this.furnish = furnish;
    }

    public void setHouse(House house) {
        this.house = house;
    }

    // Создаём статический метод, при помощи которого
    // будут вызываться private constructors
    public static Builder newBuilder() {
        return new Flat().new Builder();
    }

    @Override
    public int compareTo(Flat o) {
        long a = this.getArea() - o.getArea();
        int b = this.id - o.getId();

        if (b < 0) {
            return -1;
        } else if (b > 0) {
            return 1;
        }

        if (a < 0) {
            return -1;
        } else if (a > 0) {
            return 1;
        }

        return 0;
    }

    public class Builder {
        private Builder() {
        }

        public Builder setId(int id) {
            Flat.this.id = id;

            return this;
        }

        public Builder setName(String name) {
            Flat.this.name = name;

            return this;
        }


        public Builder setCoordinates(Coordinates coordinates) {
            Flat.this.coordinates = coordinates;

            return this;
        }

        public Builder setCreationDate() {
            Flat.this.creationDate = new Date();

            return this;
        }

        public Builder setArea(long area) {
            Flat.this.area = area;

            return this;
        }

        public Builder setNumberOfRooms(Long numberOfRooms) {
            Flat.this.numberOfRooms = numberOfRooms;

            return this;
        }

        public Builder setNumberOfBathrooms(int numberOfBathrooms) {
            Flat.this.numberOfBathrooms = numberOfBathrooms;

            return this;
        }

        public Builder setTimeToMetroOnFoot(long timeToMetroOnFoot) {
            Flat.this.timeToMetroOnFoot = timeToMetroOnFoot;

            return this;
        }

        public Builder setFurnish(Furnish furnish) {
            Flat.this.furnish = furnish;

            return this;
        }

        public Builder setHouse(House house) {
            Flat.this.house = house;

            return this;
        }

        public Flat build() {
            return Flat.this;
        }
    }

    @Override
    public String toString() {
        return "Flat{\n" +
                "\tid=" + id + ", \n" +
                "\tname='" + name + '\'' + ", \n" +
                "\tcoordinates=" + coordinates + ", \n" +
                "\tcreationDate=" + creationDate + ", \n" +
                "\tarea=" + area + ", \n" +
                "\tnumberOfRooms=" + numberOfRooms + ", \n" +
                "\tnumberOfBathrooms=" + numberOfBathrooms + ", \n" +
                "\ttimeToMetroOnFoot=" + timeToMetroOnFoot + ", \n" +
                "\tfurnish=" + furnish + ", \n" +
                "\thouse=" + house + "\n" +
                '}';
    }

    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }
}
