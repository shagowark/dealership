package services;

import models.Car;
import repos.CarRepo;
import repos.impl.inMemory.CarRepoInMemory;

import java.util.List;
public class CarService {
    private static CarService INSTANCE;
    private final CarRepo carRepo = CarRepoInMemory.getInstance();

    private CarService(){}
    public static CarService getInstance(){
        if (INSTANCE == null){
            INSTANCE = new CarService();
        }
        return INSTANCE;
    }
    public void save(Car car){
        carRepo.save(car);
    }
    public Car findById(int id){
        return carRepo.findById(id);
    }
    public void update(Car car){
        carRepo.update(car);
    }
    public void removeById(int id){
        carRepo.removeById(id);
    }
    public List<Car> listAll(){
        return carRepo.listAll();
    }
}
