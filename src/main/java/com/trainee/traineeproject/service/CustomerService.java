package com.trainee.traineeproject.service;

import com.trainee.traineeproject.entity.*;
import com.trainee.traineeproject.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import javax.transaction.Transactional;
import java.lang.reflect.Array;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class CustomerService {
    @Autowired
    CustomerRepository customerRepository;

    @Transactional
    public CustomerDTO getCustomer(UUID id){
        Customer customer = customerRepository.findById(id);
        return CustomerDTO.builder()
                .storeNumber(customer.getStoreNumber())
                .country(customer.getCountry())
                .name(customer.getName())
                .VAT(customer.getVAT())
                .CheckoutCheckCode((customer.getCheckoutCheckCode()))
                .build();
    }

    @Transactional
    public List<CustomerDTO> getAllCustomers(){
        Iterable<Customer> customerIterable = customerRepository.findAll();
        List<Customer> customers = new ArrayList<>();
        customerIterable.forEach(customers::add);

        return customers.stream()
                .map(c -> CustomerDTO.builder()
                        .storeNumber(c.getStoreNumber())
                        .country(c.getCountry())
                        .name(c.getName())
                        .VAT(c.getVAT())
                        .CheckoutCheckCode((c.getCheckoutCheckCode()))
                        .build())
                .collect(Collectors.toList());
    }
}
