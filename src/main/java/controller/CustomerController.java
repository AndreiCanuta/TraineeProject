package controller;

import entity.Customer;
import service.CustomerService;

import java.util.List;

public class CustomerController {
    CustomerService customerService = new CustomerService();

    public List<Customer> getAllCustomers () {
        return customerService.getAllCustomers();
    }
}
