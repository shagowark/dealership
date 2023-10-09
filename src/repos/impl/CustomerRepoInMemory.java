package repos.impl;

import models.Customer;
import models.Gender;
import repos.CustomerRepo;

import java.util.ArrayList;
import java.util.List;

public class CustomerRepoInMemory implements CustomerRepo {
    private static CustomerRepoInMemory INSTANCE;
    List<Customer> databaseCustomer = new ArrayList<>();

    {
        databaseCustomer.add(new Customer("Ivanov", "Ivan", "Ivanovich",
                25, Gender.MALE));
        databaseCustomer.add(new Customer("Zuckerberg", "Mia", "Pavlovna",
                18, Gender.FEMALE));
        databaseCustomer.add(new Customer("Shevtsov", "Boris", "Georgievich",
                55, Gender.MALE));
    }

    private CustomerRepoInMemory(){}

    public static CustomerRepoInMemory getInstance(){
        if (INSTANCE == null){
            INSTANCE = new CustomerRepoInMemory();
        }
        return INSTANCE;
    }

    @Override
    public int save(Customer customer) {
        return 0;
    }

    @Override
    public Customer findById(int id) {
        return null;
    }

    @Override
    public void update(Customer customer) {

    }

    @Override
    public void removeById(int id) {

    }

    @Override
    public List<Customer> listAll() {
        return null;
    }
}
