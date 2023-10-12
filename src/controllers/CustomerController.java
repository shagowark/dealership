package controllers;

import models.Customer;
import parsers.CustomerParser;
import services.impl.CustomerServiceImpl;

import java.util.List;

public class CustomerController {
    private static CustomerController INSTANCE;
    private final CustomerServiceImpl customerServiceImpl = CustomerServiceImpl.getInstance();
    private CustomerController(){}
    public static CustomerController getInstance(){
        if (INSTANCE == null){
            INSTANCE = new CustomerController();
        }
        return INSTANCE;
    }

    public void saveCustomer(String customerStr){
        customerServiceImpl.save(CustomerParser.parseStrToCustomer(customerStr));
    }

    public String findCustomerById(int id){
        return customerServiceImpl.findById(id).toString();
    }
    public void  updateCustomer(String carStr){
        customerServiceImpl.update(CustomerParser.parseStrToCustomerWithId(carStr));
    }
    public void removeCustomerById(int id){
        customerServiceImpl.removeById(id);
    }

    public List<String> listAllCustomers(){
        return customerServiceImpl.listAll().stream().map(Customer::toString).toList();
    }
}
