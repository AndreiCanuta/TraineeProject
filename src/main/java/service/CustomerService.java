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

    public Customer getByCustomerId (CustomerId customerId) {
        return customerRepository.getByCustomerId(customerId);
    }

    public List<Customer> getCustomersByCountry (String country) {
        return customerRepository.getCustomersByCountry(country);
    }

    public List<Customer> getGroupByVAT (String VAT) {
        return customerRepository.getGroupByVAT(VAT);
    }

    public List<Customer> getCustomersByStoreNumber (String storeNumber) {
        return customerRepository.getCustomersByStoreNumber(storeNumber);
    }

    public List<Customer> getCustomersByCustomerNumber (String customerNumber) {
        return customerRepository.getCustomersByCustomerNumber(customerNumber);
    }

    public void changeCheckoutCode (String country, String checkoutCheckCodeOld, String checkoutCheckCodeNew) {
        customerRepository.changeCheckoutCode(country, checkoutCheckCodeOld, checkoutCheckCodeNew);
    }
}
