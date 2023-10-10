package controllers;

import models.Trade;
import services.TradeService;

import java.util.List;

public class TradeController {
    private final TradeService tradeService = TradeService.getInstance();

    public List<String> listAllTrades() {
        return tradeService.listAll().stream().map(Trade::toString).toList();
    }
}
