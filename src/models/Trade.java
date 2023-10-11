package models;

public class Trade {
    private static int ID_COUNTER;
    private int id;
    private int carId;
    private int customerId;

    public Trade(int carId, int customerId) {
        this.id = ++ID_COUNTER;
        this.carId = carId;
        this.customerId = customerId;
    }

    public Trade(int id, int carId, int customerId) {
        this.id = id;
        this.carId = carId;
        this.customerId = customerId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCarId() {
        return carId;
    }

    public void setCarId(int carId) {
        this.carId = carId;
    }

    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    @Override
    public String toString() {
        return id +
                " " +
                carId +
                " " +
                customerId;
    }
}
