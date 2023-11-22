package repos.impl.inMemory;

import models.Car;
import enums.CarType;
import repos.CarRepo;

import java.util.*;

public class CarRepoInMemory implements CarRepo {
    private static CarRepoInMemory INSTANCE;
    List<Car> databaseCar = new ArrayList<>();

    {
        databaseCar.add(new Car(CarType.PASSENGER, "Mercedes", "Benz"));
        databaseCar.add(new Car(CarType.PASSENGER, "Lada", "Granta"));
        databaseCar.add(new Car(CarType.TRUCK, "Volvo", "FH16"));
    }

    private CarRepoInMemory(){}
    public static CarRepoInMemory getInstance(){
        if (INSTANCE == null){
            INSTANCE = new CarRepoInMemory();
        }
        return INSTANCE;
    }

    @Override
    public void save(Car car) {
        databaseCar.add(car);
    }

    @Override
    public Car findById(UUID id) {
        for (Car car : databaseCar){
            if (car.getId() == id){
                return car;
            }
        }
        return null;
    }

    @Override
    public void update(Car newCar) {
        Car car = findById(newCar.getId());
        car.setType(newCar.getType());
        car.setBrand(newCar.getBrand());
        car.setModel(newCar.getModel());
    }

    @Override
    public void removeById(UUID id){
        databaseCar.remove(findById(id));
    }

    @Override
    public List<Car> listAll() {
        return databaseCar;
    }
}
