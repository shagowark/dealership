package services.impl;

import models.Car;
import models.Customer;
import models.Trade;
import parsers.CustomerParser;
import repos.CarRepo;
import repos.impl.db.CarRepoDB;
import repos.impl.inMemory.CarRepoInMemory;
import services.CarService;

import java.util.List;
import java.util.UUID;

public class CarServiceImpl implements CarService {
    private static CarServiceImpl INSTANCE;
    private final CarRepo carRepo = CarRepoDB.getInstance(); // можно менять на inmemory и db

    private CarServiceImpl(){}
    public static CarServiceImpl getInstance(){
        if (INSTANCE == null){
            INSTANCE = new CarServiceImpl();
        }
        return INSTANCE;
    }

    @Override
    public void save(Car car){
        carRepo.save(car);
    }
    @Override
    public Car findById(UUID id){
        return carRepo.findById(id);
    }
    @Override
    public void update(Car car){
        carRepo.update(car);
    }
    @Override
    public void removeById(UUID id){
        carRepo.removeById(id);
    }
    @Override
    public List<Car> listAll(){
        return carRepo.listAll();
    }
}
