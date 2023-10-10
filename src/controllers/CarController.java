package controllers;

import models.Car;
import parsers.CarParser;
import services.CarService;

import java.util.ArrayList;
import java.util.List;

public class CarController {
    private final CarService carService = CarService.getInstance();

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
}
