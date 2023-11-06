package parsers;

import models.Car;
import enums.CarType;

public class CarParser {
    public static Car parseStrToCar(String str){
        String[] words = str.split(" ");
        return new Car(words[0].equals("Passenger") ? CarType.PASSENGER : CarType.TRUCK, //TODO переделать enum
                words[1], words[2]);
    }

    public static Car parseStrToCarWithId(String str){
        String[] words = str.split(" ");
        return new Car(Integer.parseInt(
                words[0]),
                words[1].equals("Passenger") ? CarType.PASSENGER : CarType.TRUCK,
                words[2], words[3]);
    }
}
