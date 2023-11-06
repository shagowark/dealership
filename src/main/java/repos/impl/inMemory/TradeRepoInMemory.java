package repos.impl.inMemory;

import enums.CarType;
import enums.Gender;
import models.*;
import repos.TradeRepo;

import java.util.ArrayList;
import java.util.List;

public class TradeRepoInMemory implements TradeRepo {
    private static TradeRepoInMemory INSTANCE;
    List<Trade> databaseTrade = new ArrayList<>();

    {
        databaseTrade.add(new Trade(14, 20));
        databaseTrade.add(new Trade(10, 10));
        databaseTrade.add(new Trade(17, 50));
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
        oldTrade.setCarId(newTrade.getCarId());
        oldTrade.setCustomerId(newTrade.getCustomerId());
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
