package models;

import java.util.UUID;

public class Trade {
    private UUID id;
    private UUID carId;
    private UUID customerId;

    public Trade(UUID carId, UUID customerId) {
        this.id = UUID.randomUUID();
        this.carId = carId;
        this.customerId = customerId;
    }

    public Trade(UUID id, UUID carId, UUID customerId) {
        this.id = id;
        this.carId = carId;
        this.customerId = customerId;
    }

    public Trade() {

    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public UUID getCarId() {
        return carId;
    }

    public void setCarId(UUID carId) {
        this.carId = carId;
    }

    public UUID getCustomerId() {
        return customerId;
    }

    public void setCustomerId(UUID customerId) {
        this.customerId = customerId;
    }

    @Override
    public String toString() {
        return id.toString() +
                " " +
                carId.toString() +
                " " +
                customerId.toString();
    }
}
