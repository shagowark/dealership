package enums;

public enum Gender {
    MALE("Male"),
    FEMALE("Female");

    private String text;
    Gender(String text) {
        this.text = text;
    }
    public String getText(){
        return this.text;
    }
    public static Gender fromString(String text) {
        for (Gender type : Gender.values()) {
            if (type.text.equalsIgnoreCase(text)) {
                return type;
            }
        }
        return null;
    }
    @Override
    public String toString() {
        return switch (this){
            case MALE -> "Male";
            case FEMALE -> "Female";
        };
    }
}
