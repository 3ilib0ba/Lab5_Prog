package typesfiles;

public class Coordinates {
    private float x; //Максимальное значение поля: 483
    private double y; //Максимальное значение поля: 311

    public Coordinates(float x, double y) {
        this.x = x;
        this.y = y;
    }

    public float getX() { return x; }

    public void setX(float x) {
        this.x = x;
    }

    public double getY() {
        return y;
    }

    public void setY(double y) {
        this.y = y;
    }

    @Override
    public String toString() {
        return "Coordinates{" +
                "x = " + x +
                ", y = " + y +
                '}';
    }
}
