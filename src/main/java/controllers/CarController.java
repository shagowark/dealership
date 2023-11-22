package controllers;

import models.Car;
import parsers.CarParser;
import services.impl.CarServiceImpl;

import java.util.List;
import java.util.UUID;

public class CarController {
    private static CarController INSTANCE;
    private final CarServiceImpl carServiceImpl = CarServiceImpl.getInstance();
    private CarController(){}
    public static CarController getInstance(){
        if (INSTANCE == null){
            INSTANCE = new CarController();
        }
        return INSTANCE;
    }

    public void saveCar(String carStr){
        carServiceImpl.save(CarParser.parseStrToCar(carStr));
    }

    public String findCarById(UUID id){
        return carServiceImpl.findById(id).toString();
    }
    public void  updateCar(String carStr){
        carServiceImpl.update(CarParser.parseStrToCarWithId(carStr));
    }
    public void removeCarById(UUID id){
            carServiceImpl.removeById(id);
    }

    public List<String> listAllCars(){
        return carServiceImpl.listAll().stream().map(Car::toString).toList();
    }

    public void sellCar(UUID id, String customerStr) {
        carServiceImpl.sellCar(id, customerStr);
    }
}
