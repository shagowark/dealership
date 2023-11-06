package services.impl;

import models.Car;
import models.Customer;
import models.Trade;
import parsers.CustomerParser;
import repos.CarRepo;
import repos.impl.inMemory.CarRepoInMemory;
import services.CarService;

import java.util.List;
public class CarServiceImpl implements CarService {
    private static CarServiceImpl INSTANCE;
    private final CarRepo carRepo = CarRepoInMemory.getInstance();
    private final CustomerServiceImpl customerServiceImpl = CustomerServiceImpl.getInstance();
    private final TradeServiceImpl tradeServiceImpl = TradeServiceImpl.getInstance();

    private CarServiceImpl(){}
    public static CarServiceImpl getInstance(){
        if (INSTANCE == null){
            INSTANCE = new CarServiceImpl();
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

    public void sellCar(int carId, String customerStr) {
        Car car = findById(carId);
        Customer customer = CustomerParser.parseStrToCustomer(customerStr);
        customerServiceImpl.save(customer);
        tradeServiceImpl.save(new Trade(carId, customer.getId()));
        removeById(carId);
    }
}
