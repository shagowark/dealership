package controllers;

import models.Car;
import parsers.CarParser;
import services.CarService;

import java.util.List;

public class CarController {
    private static CarController INSTANCE;
    private final CarService carService = CarService.getInstance();
    private CarController(){}
    public static CarController getInstance(){
        if (INSTANCE == null){
            INSTANCE = new CarController();
        }
        return INSTANCE;
    }

    public void saveCar(String carStr){
        carService.save(CarParser.parseStrToCar(carStr));
    }

    public String findCarById(int id){
        return carService.findById(id).toString();
    }
    public void  updateCar(String carStr){
        carService.update(CarParser.parseStrToCarWithId(carStr));
    }
    public void removeCarById(int id){
            carService.removeById(id);
    }

    public List<String> listAllCars(){
        return carService.listAll().stream().map(Car::toString).toList();
    }

    public void sellCar(int id, String customerStr) {
        carService.sellCar(id, customerStr);
    }
}
