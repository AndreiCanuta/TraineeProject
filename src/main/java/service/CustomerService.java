package service;

import entity.Customer;
import repository.CustomerRepository;

import java.util.List;

public class CustomerService {
    private final CustomerRepository customerRepository = new CustomerRepository();

    public List<Customer> getAllCustomers () {
        return customerRepository.getAllCustomers();
    }
}
