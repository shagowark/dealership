package controllers;

import models.Customer;
import parsers.CustomerParser;
import services.CustomerService;

import java.util.List;

public class CustomerController {
    private static CustomerController INSTANCE;
    private final CustomerService customerService = CustomerService.getInstance();
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

    public String findCustomerById(int id){
        return customerService.findById(id).toString();
    }
    public void  updateCustomer(String carStr){
        customerService.update(CustomerParser.parseStrToCustomerWithId(carStr));
    }
    public void removeCustomerById(int id){
        customerService.removeById(id);
    }

    public List<String> listAllCustomers(){
        return customerService.listAll().stream().map(Customer::toString).toList();
    }
}
