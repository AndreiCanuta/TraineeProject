package controller;

import entity.Customer;
import entity.CustomerId;
import repository.CustomerRepository;
import service.CustomerService;

import java.util.List;
import java.util.stream.Collectors;

public class CustomerController {
    CustomerService customerService = new CustomerService();
    CustomerRepository customerRepository = new CustomerRepository();

    public List<Customer> getAllCustomers () {
        return customerService.getAllCustomers();
    }


    public Customer getByCustomerId (CustomerId customerId) {
        try {
            List<Customer> customers = customerRepository.getAllCustomers()
                    .stream()
                    .filter(c -> c.getCustomerId().equals(customerId))
                    .collect(Collectors.toList());

            return customers.get(0);
        } catch (IndexOutOfBoundsException e){
            return null;
        }
    }
}
