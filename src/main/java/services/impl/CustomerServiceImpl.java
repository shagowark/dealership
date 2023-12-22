package services.impl;

import models.Customer;
import repos.CustomerRepo;
import repos.impl.db.CustomerRepoDB;
import repos.impl.inMemory.CustomerRepoInMemory;
import services.CustomerService;

import java.util.List;
import java.util.UUID;

public class CustomerServiceImpl implements CustomerService {
    private static CustomerServiceImpl INSTANCE;
    private final CustomerRepo customerRepo = CustomerRepoDB.getInstance(); // можно поменять на inmemory

    private CustomerServiceImpl() {
    }

    public static CustomerServiceImpl getInstance() {

        if (INSTANCE == null) {
            INSTANCE = new CustomerServiceImpl();
        }
        return INSTANCE;

    }

    @Override
    public void save(Customer customer) {
        customerRepo.save(customer);
    }

    @Override
    public Customer findById(UUID id) {
        return customerRepo.findById(id);
    }

    @Override
    public void update(Customer customer) {
        customerRepo.update(customer);
    }

    @Override
    public void removeById(UUID id) {
        customerRepo.removeById(id);
    }

    @Override
    public List<Customer> listAll() {
        return customerRepo.listAll();
    }
}
