package repos.impl.inMemory;

import models.Customer;
import enums.Gender;
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
    public void save(Customer customer) {
        databaseCustomer.add(customer);
    }

    @Override
    public Customer findById(int id) {
        for (Customer customer : databaseCustomer){
            if (customer.getId() == id){
                return customer;
            }
        }
        return null;
    }

    @Override
    public void update(Customer newCustomer) {
        Customer oldCustomer = findById(newCustomer.getId());
        oldCustomer.setLastName(newCustomer.getLastName());
        oldCustomer.setFirstName(newCustomer.getFirstName());
        oldCustomer.setMiddleName(newCustomer.getMiddleName());
        oldCustomer.setAge(newCustomer.getAge());
        oldCustomer.setGender(newCustomer.getGender());
    }

    @Override
    public void removeById(int id) {
        databaseCustomer.remove(findById(id));
    }

    @Override
    public List<Customer> listAll() {
        return databaseCustomer;
    }
}
