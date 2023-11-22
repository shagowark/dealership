package repos.impl.db;

import config.DBConnectionManager;
import enums.CarType;
import models.Car;
import models.Trade;
import repos.TradeRepo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class TradeRepoDB implements TradeRepo {
    private static TradeRepoDB INSTANCE;
    private final Connection connection = DBConnectionManager.getConnection();

    private TradeRepoDB() {
    }

    public static TradeRepoDB getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new TradeRepoDB();
        }
        return INSTANCE;
    }
    @Override
    public void save(Trade trade) {
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(
                    "INSERT INTO trade VALUES (?, ?, ?)");

            preparedStatement.setObject(1, trade.getId());
            preparedStatement.setObject(2, trade.getCarId());
            preparedStatement.setObject(3, trade.getCustomerId());

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public Trade findById(UUID id) {
        Trade trade = new Trade();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(
                    "SELECT * FROM trade WHERE id = ?");

            preparedStatement.setObject(1, id);

            ResultSet resultSet = preparedStatement.executeQuery();
            resultSet.next();
            trade.setId(UUID.fromString(resultSet.getString("id")));
            trade.setCarId(UUID.fromString(resultSet.getString("car_id")));
            trade.setCustomerId(UUID.fromString(resultSet.getString("customer_id")));
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return trade;
    }

    @Override
    public void update(Trade trade) {
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(
                    "UPDATE trade SET car_id=?, customer_id=? WHERE id=?");


            preparedStatement.setObject(1, trade.getCarId());
            preparedStatement.setObject(2, trade.getCustomerId());
            preparedStatement.setObject(3, trade.getId());

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void removeById(UUID id) {
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(
                    "DELETE FROM trade WHERE id = ?");

            preparedStatement.setObject(1, id);

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<Trade> listAll() {
        List<Trade> trades = new ArrayList<>();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(
                    "SELECT * FROM trade");

            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                trades.add(new Trade(
                        UUID.fromString(resultSet.getString("id")),
                        UUID.fromString(resultSet.getString("car_id")),
                        UUID.fromString(resultSet.getString("customer_id"))
                ));
            }
        } catch (SQLException e) {
            throw new RuntimeException();
        }

        return trades;
    }
}
