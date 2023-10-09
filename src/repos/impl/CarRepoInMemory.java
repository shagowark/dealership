package repos.impl;

import models.Car;
import models.CarType;
import repos.CarRepo;

import java.util.ArrayList;
import java.util.List;

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
    public int save(Car car) {
        return 0;
    }

    @Override
    public Car findById(int id) {
        return null;
    }

    @Override
    public void update(Car car) {

    }

    @Override
    public void removeById(int id) {

    }

    @Override
    public List<Car> listAll() {
        return null;
    }
}
