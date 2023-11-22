package models;

import enums.CarType;

import java.util.UUID;

public class Car {
    private UUID id;
    private CarType type;
    private String brand;
    private String model;

    public Car(CarType type, String brand, String model) {
        this.id = UUID.randomUUID();
        this.type = type;
        this.brand = brand;
        this.model = model;
    }

    public Car(UUID id, CarType type, String brand, String model) {
        this.id = id;
        this.type = type;
        this.brand = brand;
        this.model = model;
    }

    public Car() {

    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
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
        return id.toString() +
                " " +
                type.toString() +
                " " +
                brand +
                " " +
                model;
    }
}
