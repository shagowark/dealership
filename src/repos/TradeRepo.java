package repos;

import models.Trade;

import java.util.List;

public interface TradeRepo {
    int save(Trade trade);
    Trade findById(int id);
    void update(Trade trade);
    void removeById(int id);
    List<Trade> listAll();
}
