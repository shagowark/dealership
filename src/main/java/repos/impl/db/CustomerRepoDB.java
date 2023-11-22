package repos.impl.db;

import config.DBConnectionManager;
import enums.CarType;
import enums.Gender;
import models.Car;
import models.Customer;
import repos.CustomerRepo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class CustomerRepoDB implements CustomerRepo {
    private static CustomerRepoDB INSTANCE;
    private final Connection connection = DBConnectionManager.getConnection();

    private CustomerRepoDB() {
    }

    public static CustomerRepoDB getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new CustomerRepoDB();
        }
        return INSTANCE;
    }
    @Override
    public void save(Customer customer) {
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(
                    "INSERT INTO customer VALUES (?, ?, ?, ?, ?, ?)");

            preparedStatement.setObject(1, customer.getId());
            preparedStatement.setString(2, customer.getLastName());
            preparedStatement.setString(3, customer.getFirstName());
            preparedStatement.setString(4, customer.getMiddleName());
            preparedStatement.setInt(5, customer.getAge());
            preparedStatement.setString(6, customer.getGender().toString());

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public Customer findById(UUID id) {
        Customer customer = new Customer();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(
                    "SELECT * FROM customer WHERE id = ?");

            preparedStatement.setObject(1, id);

            ResultSet resultSet = preparedStatement.executeQuery();
            resultSet.next();
            customer.setId(UUID.fromString(resultSet.getString("id")));
            customer.setLastName(resultSet.getString("last_name"));
            customer.setFirstName(resultSet.getString("first_name"));
            customer.setMiddleName(resultSet.getString("middle_name"));
            customer.setAge(resultSet.getInt("age"));
            customer.setGender(Gender.fromString(resultSet.getString("gender")));
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return customer;
    }

    @Override
    public void update(Customer customer) {
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(
                    "UPDATE customer SET last_name=?, first_name=?, middle_name=?, age=?, gender=? WHERE id=?");


            preparedStatement.setString(1, customer.getLastName());
            preparedStatement.setString(2, customer.getFirstName());
            preparedStatement.setString(3, customer.getMiddleName());
            preparedStatement.setInt(4, customer.getAge());
            preparedStatement.setString(5, customer.getGender().toString());
            preparedStatement.setObject(6, customer.getId());

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void removeById(UUID id) {
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(
                    "DELETE FROM customer WHERE id = ?");

            preparedStatement.setObject(1, id);

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<Customer> listAll() {
        List<Customer> customers = new ArrayList<>();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(
                    "SELECT * FROM customer");

            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                customers.add(new Customer(
                        UUID.fromString(resultSet.getString("id")),
                        resultSet.getString("last_name"),
                        resultSet.getString("first_name"),
                        resultSet.getString("middle_name"),
                        resultSet.getInt("age"),
                        Gender.fromString(resultSet.getString("gender"))
                ));
            }
        } catch (SQLException e) {
            throw new RuntimeException();
        }

        return customers;
    }
}
