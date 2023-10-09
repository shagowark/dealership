package repos;

import models.Customer;

import java.util.List;

public interface CustomerRepo {
    int save(Customer customer);
    Customer findById(int id);
    void update(Customer customer);
    void removeById(int id);
    List<Customer> listAll();
}
