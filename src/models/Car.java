package models;

public class Car {
    private static int ID_COUNTER;
    private int id;
    private CarType type;
    private String brand;
    private String model;

    public Car(CarType type, String brand, String model) {
        this.id = ++ID_COUNTER;
        this.type = type;
        this.brand = brand;
        this.model = model;
    }

    public Car(int id, CarType type, String brand, String model) {
        this.id = id;
        this.type = type;
        this.brand = brand;
        this.model = model;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public CarType getType() {
        return type;
    }

    public void setType(CarType type) {
        this.type = type;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    @Override
    public String toString() {
        return Integer.toString(id) +
                " " +
                type.toString() +
                " " +
                brand +
                " " +
                model;
    }
}
