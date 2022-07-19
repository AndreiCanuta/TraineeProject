package com.trainee.traineeproject.service;

import com.trainee.traineeproject.entity.Customer;
import com.trainee.traineeproject.repository.CusomerRepository;
import com.trainee.traineeproject.repository.CustomerRepositoryMock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Qualifier("customerServiceImpl")
public class CustomerServiceImpl implements CustomerService {
    //private final CustomerRepositoryMock customerRepositoryMock = new CustomerRepositoryMock();

    @Autowired
    private final CusomerRepository cusomerRepository;

    @Override
    @Transactional
    public Customer getAllCustomers() {
        Customer c = cusomerRepository.findById("1");
        c.getProducts()
        cusomerRepository.
        cusomerRepository.findAll();
//        return customerRepositoryMock.getAllCustomers();
    }
/*

    public Customer getByCustomerId (CustomerId customerId) {
        return customerRepositoryMock.getByCustomerId(customerId);
    }

    public List<Customer> getCustomersByCountry (String country) {
        return customerRepositoryMock.getCustomersByCountry(country);
    }

    public List<Customer> getGroupByVAT (String VAT) {
        return customerRepositoryMock.getGroupByVAT(VAT);
    }

    public List<Customer> getCustomersByStoreNumber (String storeNumber) {
        return customerRepositoryMock.getCustomersByStoreNumber(storeNumber);
    }

    public List<Customer> getCustomersByCustomerNumber (String customerNumber) {
        return customerRepositoryMock.getCustomersByCustomerNumber(customerNumber);
    }

    public void changeCheckoutCode (String country, String checkoutCheckCodeOld, String checkoutCheckCodeNew) {
        customerRepositoryMock.changeCheckoutCode(country, checkoutCheckCodeOld, checkoutCheckCodeNew);
    }
*/

}
