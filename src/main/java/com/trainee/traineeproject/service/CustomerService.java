package com.trainee.traineeproject.service;

import com.trainee.traineeproject.entity.Customer;
import com.trainee.traineeproject.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class CustomerService {
    @Autowired
    CustomerRepository customerRepository;

    @Transactional
    public List<Customer> getAllCustomers () {
        return customerRepository.getAllCustomers();
    }
}
