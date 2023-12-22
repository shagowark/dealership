package services;

import models.Customer;
import models.Trade;

import java.util.UUID;

public interface TradeService extends DefaultService<Trade> {
    void sellCar(UUID id, Customer customer);
}
