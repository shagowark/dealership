package enums;

public enum Gender {
    MALE,
    FEMALE;


    @Override
    public String toString() {
        return switch (this){
            case MALE -> "Male";
            case FEMALE -> "Female";
        };
    }
}
