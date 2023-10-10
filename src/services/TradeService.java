package services;

import models.Trade;
import repos.TradeRepo;
import repos.impl.inMemory.TradeRepoInMemory;

import java.util.List;

public class TradeService {
    private static TradeService INSTANCE;
    private final TradeRepo tradeRepo = TradeRepoInMemory.getInstance();

    private TradeService() {
    }

    public static TradeService getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new TradeService();
        }
        return INSTANCE;
    }

    public void save(Trade trade) {
        tradeRepo.save(trade);
    }

    public Trade findById(int id) {
        return tradeRepo.findById(id);
    }

    public void update(Trade trade) {
        tradeRepo.update(trade);
    }

    public void removeById(int id) {
        tradeRepo.removeById(id);
    }

    public List<Trade> listAll() {
        return tradeRepo.listAll();
    }
}
