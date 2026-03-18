package model;
/**
 * Класс, представляющий транспортное средство.
 */

 public class Vehicle implements Comparable<Vehicle> {
    /**
     * Уникальный идентификатор транспортного средства.
     * Поле не может быть null, должно быть больше 0.
     * Генерируется автоматически.
     */
    private Long id;

    /**
     * Название транспортного средства.
     * Поле не может быть null, строка не может быть пустой.
     */
    private String name;

    /**
     * Координаты транспортного средства.
     * Поле не может быть null.
     */
    Coordinates coordinates;

    /**
     * Дата создания записи о транспортном средстве.
     * Поле не может быть null, генерируется автоматически.
     */
    private java.util.Date creationDate;

    /**
     * Мощность двигателя.
     * Поле не может быть null, значение должно быть больше 0.
     */
    private Float enginePower;

    /**
     * Вместимость транспортного средства.
     * Поле может быть null, если не null, то значение должно быть больше 0.
     */
    private Float capacity;

    /**
     * Расход топлива.
     * Поле не может быть null, значение должно быть больше 0.
     */
    private Integer fuelConsumption;

    /**
     * Тип транспортного средства.
     * Поле может быть null.
     */
    private VehicleType type;

    /**
     * Возвращает уникальный идентификатор.
     * @return id транспортного средства
     */
    public Long getId() {
        return id;
    }

    /**
     * Возвращает название транспортного средства.
     * @return название
     */
    public String getName() {
        return name;
    }

    /**
     * Возвращает координаты.
     * @return объект Coordinates
     */
    public Coordinates getCoordinates() {
        return coordinates;
    }

    /**
     * Возвращает дату создания записи.
     * @return дата создания
     */
    public java.util.Date getCreationDate() {
        return creationDate;
    }

    /**
     * Возвращает мощность двигателя.
     * @return мощность двигателя
     */
    public Float getEnginePower() {
        return enginePower;
    }

    /**
     * Возвращает вместимость.
     * @return вместимость или null, если не указана
     */
    public Float getCapacity() {
        return capacity;
    }

    /**
     * Возвращает расход топлива.
     * @return расход топлива
     */
    public Integer getFuelConsumption() {
        return fuelConsumption;
    }

    /**
     * Возвращает тип транспортного средства.
     * @return тип или null
     */
    public VehicleType getType() {
        return type;
    }

    /**
     * Устанавливает уникальный идентификатор.
     * @param id новый идентификатор
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * Устанавливает название транспортного средства.
     * @param name новое название
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Устанавливает координаты.
     * @param coordinates новые координаты
     */
    public void setCoordinates(Coordinates coordinates) {
        this.coordinates = coordinates;
    }

    /**
     * Устанавливает дату создания.
     * @param creationDate новая дата
     */
    public void setCreationDate(java.util.Date creationDate) {
        this.creationDate = creationDate;
    }

    /**
     * Устанавливает мощность двигателя.
     * @param enginePower новая мощность
     */
    public void setEnginePower(Float enginePower) {
        this.enginePower = enginePower;
    }

    /**
     * Устанавливает вместимость.
     * @param capacity новая вместимость
     */
    public void setCapacity(Float capacity) {
        this.capacity = capacity;
    }

    /**
     * Устанавливает расход топлива.
     * @param fuelConsumption новый расход
     */
    public void setFuelConsumption(Integer fuelConsumption) {
        this.fuelConsumption = fuelConsumption;
    }

    /**
     * Устанавливает тип транспортного средства.
     * @param type новый тип
     */
    public void setType(VehicleType type) {
        this.type = type;
    }

    /**
     * Возвращает строковое представление объекта.
     * @return строка с информацией о транспортном средстве
     */
    public String toString() {
        return "Vehicle{" + "id = " + id + ", name = " + name + ", coordinates = " + coordinates + ", creationDate = " + creationDate + ", enginePower = " + enginePower + ", capacity = " + capacity + ", fuelConsumption = " + fuelConsumption + ", type = " + type + "}";
    }

    /**
     * Сравнивает текущий объект с другим по мощности двигателя.
     * Используется для сортировки по умолчанию.
     *
     * @param other другой объект Vehicle для сравнения
     * @return отрицательное число, если текущий меньше,
     *         положительное, если больше, 0 если равны
     */
    @Override
    public int compareTo(Vehicle other) {
        if (other == null) {
            return 1;
        }
        return this.enginePower.compareTo(other.enginePower);
    }
}
