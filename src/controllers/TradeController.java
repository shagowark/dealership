package controllers;

import models.Trade;
import services.TradeService;

import java.util.List;

public class TradeController {
    private static TradeController INSTANCE;
    private final TradeService tradeService = TradeService.getInstance();
    private TradeController(){}
    public static TradeController getInstance(){
        if (INSTANCE == null){
            INSTANCE = new TradeController();
        }
        return INSTANCE;
    }

    public List<String> listAllTrades() {
        return tradeService.listAll().stream().map(Trade::toString).toList();
    }
}
