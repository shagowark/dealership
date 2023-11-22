package repos.impl.inMemory;

import enums.CarType;
import enums.Gender;
import models.*;
import repos.TradeRepo;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class TradeRepoInMemory implements TradeRepo {
    private static TradeRepoInMemory INSTANCE;
    List<Trade> databaseTrade = new ArrayList<>();

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
    public Trade findById(UUID id) {
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
    public void removeById(UUID id) {
        databaseTrade.remove(findById(id));
    }

    @Override
    public List<Trade> listAll() {
        return databaseTrade;
    }
}
