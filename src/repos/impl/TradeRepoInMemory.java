package repos.impl;

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
    public int save(Trade trade) {
        return 0;
    }

    @Override
    public Trade findById(int id) {
        return null;
    }

    @Override
    public void update(Trade trade) {

    }

    @Override
    public void removeById(int id) {

    }

    @Override
    public List<Trade> listAll() {
        return null;
    }
}
