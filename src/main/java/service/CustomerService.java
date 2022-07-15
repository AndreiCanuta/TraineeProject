package service;

import entity.Customer;
import entity.CustomerId;
import repository.CustomerRepository;

import java.util.List;

public class CustomerService {
    private final CustomerRepository customerRepository = new CustomerRepository();

    public List<Customer> getAllCustomers () {
        return customerRepository.getAllCustomers();
    }

    public Customer getByCustomerId (CustomerId customerId){
        return customerRepository.getByCustomerId(customerId);
    }
}
