package services.impl;

import models.Customer;
import repos.CustomerRepo;
import repos.impl.inMemory.CustomerRepoInMemory;
import services.CustomerService;

import java.util.List;

public class CustomerServiceImpl implements CustomerService {
    private static CustomerServiceImpl INSTANCE;
    private final CustomerRepo customerRepo = CustomerRepoInMemory.getInstance();

    private CustomerServiceImpl() {
    }

    public static CustomerServiceImpl getInstance() {

        if (INSTANCE == null) {
            INSTANCE = new CustomerServiceImpl();
        }
        return INSTANCE;

    }

    public void save(Customer customer) {
        customerRepo.save(customer);
    }

    public Customer findById(int id) {
        return customerRepo.findById(id);
    }

    public void update(Customer customer) {
        customerRepo.update(customer);
    }

    public void removeById(int id) {
        customerRepo.removeById(id);
    }

    public List<Customer> listAll() {
        return customerRepo.listAll();
    }
}
