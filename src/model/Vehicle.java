package model;


public class Vehicle implements Comparable<Vehicle> {
    private Long id; //Поле не может быть null, Значение поля должно быть больше 0, Значение этого поля должно быть уникальным, Значение этого поля должно генерироваться автоматически
    private String name; //Поле не может быть null, Строка не может быть пустой
    private Coordinates coordinates; //Поле не может быть null
    private java.util.Date creationDate; //Поле не может быть null, Значение этого поля должно генерироваться автоматически
    private Float enginePower; //Поле не может быть null, Значение поля должно быть больше 0
    private Float capacity; //Поле может быть null, Значение поля должно быть больше 0
    private Integer fuelConsumption; //Поле не может быть null, Значение поля должно быть больше 0
    private VehicleType type; //Поле может быть null

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Coordinates getCoordinates() {
        return coordinates;
    }

    public java.util.Date getCreationDate() {
        return creationDate;
    }

    public Float getEnginePower() {
        return enginePower;
    }

    public Float getCapacity() {
        return capacity;
    }

    public Integer getFuelConsumption() {
        return fuelConsumption;
    }

    public VehicleType getType() {
        return type;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setCoordinates(Coordinates coordinates) {
        this.coordinates = coordinates;
    }

    public void setCreationDate(java.util.Date creationDate) {
        this.creationDate = creationDate;
    }

    public void setEnginePower(Float enginePower) {
        this.enginePower = enginePower;
    }

    public void setCapacity(Float capacity) {
        this.capacity = capacity;
    }

    public void setFuelConsumption(Integer fuelConsumption) {
        this.fuelConsumption = fuelConsumption;
    }

    public void setType(VehicleType type) {
        this.type = type;
    }

    public String toString() {
        return "Vehicle{" + "id = " + id + ", name = " + name + ", coordinates = " + coordinates + ", creationDate = " + creationDate + ", enginePower = " + enginePower + ", capacity = " + capacity + ", fuelConsumption = " + fuelConsumption + ", type = " + type + "}";
    }
    @Override
    public int compareTo(Vehicle other) {
        if (other == null) {
            return 1;
        }
        return this.enginePower.compareTo(other.enginePower);
    }
}
