package services;

import models.Customer;
import repos.CustomerRepo;
import repos.impl.inMemory.CustomerRepoInMemory;

import java.util.List;

public class CustomerService {
    private static CustomerService INSTANCE;
    private final CustomerRepo customerRepo = CustomerRepoInMemory.getInstance();

    private CustomerService() {
    }

    public static CustomerService getInstance() {

        if (INSTANCE == null) {
            INSTANCE = new CustomerService();
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
