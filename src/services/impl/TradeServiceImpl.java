package services.impl;

import models.Trade;
import repos.TradeRepo;
import repos.impl.inMemory.TradeRepoInMemory;
import services.TradeService;

import java.util.List;

public class TradeServiceImpl implements TradeService {
    private static TradeServiceImpl INSTANCE;
    private final TradeRepo tradeRepo = TradeRepoInMemory.getInstance();

    private TradeServiceImpl() {
    }

    public static TradeServiceImpl getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new TradeServiceImpl();
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
