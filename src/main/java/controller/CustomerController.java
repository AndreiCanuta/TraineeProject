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
        return customerService.getByCustomerId(customerId);
    }

    public List<Customer> getCustomerByCountry (String country) {
        return customerService.getCustomersByCountry(country);
    }

    public List<Customer> getGroupByVAT (String VAT) {
        return customerService.getGroupByVAT(VAT);
    }

    public List<Customer> getCustomersByStoreNumber (String storeNumber) {
        return customerService.getCustomersByStoreNumber(storeNumber);
    }

    public List<Customer> getCustomersByCustomerNumber (String customerNumber) {
        return customerService.getCustomersByCustomerNumber(customerNumber);
    }

    public void changeCheckoutCode (String country, String checkoutCheckCodeOld, String checkoutCheckCodeNew) {
        customerService.changeCheckoutCode(country, checkoutCheckCodeOld, checkoutCheckCodeNew);
    }

}
