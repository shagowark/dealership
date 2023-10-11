package services;

import models.Car;
import models.Customer;
import models.Trade;
import parsers.CustomerParser;
import repos.CarRepo;
import repos.impl.inMemory.CarRepoInMemory;

import java.util.List;
public class CarService {
    private static CarService INSTANCE;
    private final CarRepo carRepo = CarRepoInMemory.getInstance();
    private final CustomerService customerService = CustomerService.getInstance();
    private final TradeService tradeService = TradeService.getInstance();

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

    public void sellCar(int carId, String customerStr) {
        Car car = findById(carId);
        Customer customer = CustomerParser.parseStrToCustomer(customerStr);
        customerService.save(customer);
        tradeService.save(new Trade(carId, customer.getId()));
        removeById(carId);
    }
}
