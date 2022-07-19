package com.trainee.traineeproject.service;

import com.trainee.traineeproject.entity.Customer;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Qualifier("customerServiceMocks")
public class CustomerServiceMocks implements CustomerService {

    @Override
    public List<Customer> getAllCustomers () {
        //return Arrays.asList(new Customer(new CustomerId("1", "1", "RO")));
        return null;
    }

}
