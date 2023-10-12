package controllers;

import models.Trade;
import services.impl.TradeServiceImpl;

import java.util.List;

public class TradeController {
    private static TradeController INSTANCE;
    private final TradeServiceImpl tradeServiceImpl = TradeServiceImpl.getInstance();
    private TradeController(){}
    public static TradeController getInstance(){
        if (INSTANCE == null){
            INSTANCE = new TradeController();
        }
        return INSTANCE;
    }

    public List<String> listAllTrades() {
        return tradeServiceImpl.listAll().stream().map(Trade::toString).toList();
    }
}
