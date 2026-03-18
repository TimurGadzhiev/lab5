package model;

/**
 * Класс, представляющий координаты транспортного средства.
 * Содержит координаты x и y с ограничениями на значения.
 */
public class Coordinates {
    /**
     * Координата x.
     * Максимальное значение поля: 98.
     */
    private int x;

    /**
     * Координата y.
     * Значение поля должно быть больше -112, поле не может быть null.
     */
    private Integer y;

    /**
     * Конструктор для создания координат с заданными значениями.
     *
     * @param x координата x
     * @param y координата y
     */
    public Coordinates(int x, Integer y) {
        this.x = x;
        this.y = y;
    }

    /**
     * Возвращает координату x.
     *
     * @return значение координаты x
     */
    public int getX() {
        return x;
    }

    /**
     * Устанавливает координату x.
     *
     * @param x новое значение x (должно быть ≤ 98)
     */
    public void setX(int x) {
        this.x = x;
    }

    /**
     * Возвращает координату y.
     *
     * @return значение координаты y
     */
    public int getY() {
        return y;
    }

    /**
     * Устанавливает координату y.
     *
     * @param y новое значение y (должно быть > -112, не null)
     */
    public void setY(Integer y) {
        this.y = y;
    }

    /**
     * Возвращает строковое представление координат.
     *
     * @return строка в формате "Coordinates{x = X, y = Y}"
     */
    public String toString() {
        return "Coordinates{x = " + x + ", y = " + y + "}";
    }

}
