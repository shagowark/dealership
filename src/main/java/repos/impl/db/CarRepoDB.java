package repos.impl.db;

import config.DBConnectionManager;
import enums.CarType;
import models.Car;
import repos.CarRepo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class CarRepoDB implements CarRepo {
    private static CarRepoDB INSTANCE;
    private final Connection connection = DBConnectionManager.getConnection();

    private CarRepoDB() {
    }

    public static CarRepoDB getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new CarRepoDB();
        }
        return INSTANCE;
    }

    @Override
    public void save(Car car) {
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(
                    "INSERT INTO car VALUES (?, ?, ?, ?)");

            preparedStatement.setObject(1, car.getId());
            preparedStatement.setString(2, car.getType().toString());
            preparedStatement.setString(3, car.getBrand());
            preparedStatement.setString(4, car.getModel());

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public Car findById(UUID id) {
        Car car = new Car();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(
                    "SELECT * FROM car WHERE id = ?");

            preparedStatement.setObject(1, id);

            ResultSet resultSet = preparedStatement.executeQuery();
            resultSet.next();
            car.setId(UUID.fromString(resultSet.getString("id")));
            car.setType(CarType.fromString(resultSet.getString("type")));
            car.setBrand(resultSet.getString("brand"));
            car.setModel(resultSet.getString("model"));
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return car;
    }

    @Override
    public void update(Car car) {
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(
                    "UPDATE car SET type=?, brand=?, model=? WHERE id=?");


            preparedStatement.setString(1, car.getType().toString());
            preparedStatement.setString(2, car.getBrand());
            preparedStatement.setString(3, car.getModel());
            preparedStatement.setObject(4, car.getId());

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void removeById(UUID id) {
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(
                    "DELETE FROM car WHERE id = ?");

            preparedStatement.setObject(1, id);

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<Car> listAll() {
        List<Car> cars = new ArrayList<>();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(
                    "SELECT * FROM car");

            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                cars.add(new Car(
                        UUID.fromString(resultSet.getString("id")),
                        CarType.fromString(resultSet.getString("type")),
                        resultSet.getString("brand"),
                        resultSet.getString("model")
                ));
            }
        } catch (SQLException e) {
            throw new RuntimeException();
        }

        return cars;
    }
}
