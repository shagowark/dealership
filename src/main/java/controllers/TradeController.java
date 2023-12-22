package controllers;

import models.Trade;
import parsers.CustomerParser;
import services.TradeService;
import services.impl.TradeServiceImpl;

import java.util.List;
import java.util.UUID;

public class TradeController {
    private static TradeController INSTANCE;
    private final TradeService tradeService = TradeServiceImpl.getInstance();
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

    public void sellCar(UUID id, String customerStr) {
        tradeService.sellCar(id, CustomerParser.parseStrToCustomer(customerStr));
    }
}
