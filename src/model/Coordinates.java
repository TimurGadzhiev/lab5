package model;

public class Coordinates {
    private int x; //Максимальное значение поля: 98
    private Integer y; //Значение поля должно быть больше -112, Поле не может быть null

    public Coordinates(int x, Integer y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }
    public int getY() {
        return y;
    }
    public String toString() {
        return "Coordinates{x = " + x + ", y = " + y + "}";
    }

}
