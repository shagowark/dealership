package models;

public enum CarType {
    TRUCK,
    PASSENGER;

    @Override
    public String toString() {
        return switch (this){
            case TRUCK -> "Truck";
            case PASSENGER -> "Passenger";
        };
    }
}
