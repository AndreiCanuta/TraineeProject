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
        return customerService.getAllCustomers()
                .stream()
                .filter(c -> c.getVAT().equals(VAT))
                .collect(Collectors.toList());
    }

    public List<Customer> getCustomersByCountry (String country) {
        return customerService.getAllCustomers()
                .stream()
                .filter(c -> c.getCustomerId().getCountry().equals(country))
                .collect(Collectors.toList());
    }

    public List<Customer> getCustomersByStoreNumber (String storeNumber) {
        return customerService.getAllCustomers()
                .stream()
                .filter(c -> c.getCustomerId().getStoreNumber().equals(storeNumber))
                .collect(Collectors.toList());
    }

    public List<Customer> getCustomersByCustomerNumber (String customerNumber) {
        return customerService.getAllCustomers()
                .stream()
                .filter(c -> c.getCustomerId().getCustomerNumber().equals(customerNumber))
                .collect(Collectors.toList());
    }

    public void changeCheckoutCode () {
        customerService.getAllCustomers()
                .stream()
                .filter(c -> c.getCheckoutCheckCode().equals("30") && c.getCustomerId().getCountry().equals("DE"))
                .forEach(c -> c.setCheckoutCheckCode("32"));
    }

}
