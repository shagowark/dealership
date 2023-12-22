package services.impl;

import models.Customer;
import models.Trade;
import parsers.CustomerParser;
import repos.TradeRepo;
import repos.impl.db.TradeRepoDB;
import repos.impl.inMemory.TradeRepoInMemory;
import services.CarService;
import services.CustomerService;
import services.TradeService;

import java.util.List;
import java.util.UUID;

public class TradeServiceImpl implements TradeService {
    private static TradeServiceImpl INSTANCE;
    private final TradeRepo tradeRepo = TradeRepoDB.getInstance(); // можно поменять на inmemory
    private final CustomerService customerService = CustomerServiceImpl.getInstance();
    private final CarService carService = CarServiceImpl.getInstance();

    private TradeServiceImpl() {
    }

    public static TradeServiceImpl getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new TradeServiceImpl();
        }
        return INSTANCE;
    }

    @Override
    public void save(Trade trade) {
        tradeRepo.save(trade);
    }

    @Override
    public Trade findById(UUID id) {
        return tradeRepo.findById(id);
    }

    @Override
    public void update(Trade trade) {
        tradeRepo.update(trade);
    }

    @Override
    public void removeById(UUID id) {
        tradeRepo.removeById(id);
    }

    @Override
    public List<Trade> listAll() {
        return tradeRepo.listAll();
    }

    @Override
    public void sellCar(UUID carId, Customer customer) {
        customerService.save(customer);
        carService.removeById(carId);
        save(new Trade(carId, customer.getId()));
    }
}
