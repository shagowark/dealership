package parsers;

import enums.CarType;
import enums.Gender;
import models.Car;
import models.Customer;

public class CustomerParser {
    public static Customer parseStrToCustomer(String str){
        String[] words = str.split(" ");
        return new Customer(
                words[0],
                words[1],
                words[2],
                Integer.parseInt(words[3]),
                words[4].equals("Male") ? Gender.MALE : Gender.FEMALE //TODO переделать
        );
    }

    public static Customer parseStrToCustomerWithId(String str){
        String[] words = str.split(" ");
        return new Customer(
                Integer.parseInt(words[0]),
                words[1],
                words[2],
                words[3],
                Integer.parseInt(words[4]),
                words[5].equals("Male") ? Gender.MALE : Gender.FEMALE
        );
    }
}
