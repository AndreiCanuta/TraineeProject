package controller;

import entity.Customer;
import entity.CustomerId;
import service.CustomerService;

import java.util.List;
import java.util.stream.Collectors;

public class CustomerController {
    CustomerService customerService = new CustomerService();

    public List<Customer> getAllCustomers () {
        return customerService.getAllCustomers();
    }

    public Customer getByCustomerId (CustomerId customerId) {
        try {
            List<Customer> customers = customerService.getAllCustomers()
                    .stream()
                    .filter(c -> c.getCustomerId().equals(customerId))
                    .collect(Collectors.toList());

            return customers.get(0);
        } catch (IndexOutOfBoundsException e){
            return null;
        }
    }

    public List<Customer> getGroupByVAT (String VAT) {
        try {
            List<Customer> customers = customerService.getAllCustomers()
                    .stream()
                    .filter(c -> c.getVAT().equals(VAT))
                    .collect(Collectors.toList());

            return customers;
        } catch (IndexOutOfBoundsException e){
            return null;
        }
    }
}
