package controllers;

import models.Customer;
import parsers.CustomerParser;
import services.CustomerService;
import services.impl.CustomerServiceImpl;

import java.util.List;
import java.util.UUID;

public class CustomerController {
    private static CustomerController INSTANCE;
    private final CustomerService customerService = CustomerServiceImpl.getInstance();
    private CustomerController(){}
    public static CustomerController getInstance(){
        if (INSTANCE == null){
            INSTANCE = new CustomerController();
        }
        return INSTANCE;
    }

    public void saveCustomer(String customerStr){
        customerService.save(CustomerParser.parseStrToCustomer(customerStr));
    }

    public String findCustomerById(UUID id){
        return customerService.findById(id).toString();
    }
    public void  updateCustomer(String carStr){
        customerService.update(CustomerParser.parseStrToCustomerWithId(carStr));
    }
    public void removeCustomerById(UUID id){
        customerService.removeById(id);
    }

    public List<String> listAllCustomers(){
        return customerService.listAll().stream().map(Customer::toString).toList();
    }
}
