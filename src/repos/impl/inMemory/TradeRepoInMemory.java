package repos.impl.inMemory;

import enums.Gender;
import models.*;
import repos.TradeRepo;

import java.util.ArrayList;
import java.util.List;

public class TradeRepoInMemory implements TradeRepo {
    private static TradeRepoInMemory INSTANCE;
    List<Trade> databaseTrade = new ArrayList<>();

    {
        databaseTrade.add(new Trade(
                new Car(CarType.PASSENGER, "Lada", "Priora"),
                new Customer("Wick", "John", "Nikitich",
                        40, Gender.MALE)
        ));
        databaseTrade.add(new Trade(
                new Car(CarType.PASSENGER, "Volkswagen", "Polo"),
                new Customer("Scott", "Jeanne", "Borisovna",
                        40, Gender.MALE)
        ));
    }

    private TradeRepoInMemory(){}

    public static TradeRepoInMemory getInstance(){
        if (INSTANCE == null){
            INSTANCE = new TradeRepoInMemory();
        }
        return INSTANCE;
    }

    @Override
    public void save(Trade trade) {
        databaseTrade.add(trade);
    }

    @Override
    public Trade findById(int id) {
        for (Trade trade : databaseTrade){
            if (trade.getId() == id){
                return trade;
            }
        }
        return null;
    }

    @Override
    public void update(Trade newTrade) {
        Trade oldTrade = findById(newTrade.getId());
        oldTrade.setCar(newTrade.getCar());
        oldTrade.setCustomer(newTrade.getCustomer());
    }

    @Override
    public void removeById(int id) {
        databaseTrade.remove(findById(id));
    }

    @Override
    public List<Trade> listAll() {
        return databaseTrade;
    }
}
