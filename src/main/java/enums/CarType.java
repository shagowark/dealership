package enums;

public enum CarType {
    TRUCK("Truck"),
    PASSENGER("Passenger");

    private String text;
    CarType(String text) {
        this.text = text;
    }

    public String getText(){
        return this.text;
    }

    public static CarType fromString(String text) {
        for (CarType type : CarType.values()) {
            if (type.text.equalsIgnoreCase(text)) {
                return type;
            }
        }
        return null;
    }

    @Override
    public String toString() {
        return switch (this){
            case TRUCK -> "Truck";
            case PASSENGER -> "Passenger";
        };
    }
}
