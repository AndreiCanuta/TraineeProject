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

@Service
public class CustomerService {
    @Autowired
    CustomerRepository customerRepository;

//    @Transactional
//    public List<Customer> getAllCustomers () {
//        return customerRepository.getAllCustomers();
//    }

    public UUID addCustomer(){
        CreditData creditData = new CreditData(1000, Product.BANK_TRANSFER , 15, CreditDataType.CURRENT);
        Customer customer = new Customer("1", "1", "1", "1", "1", "1", creditData, CustomerType.HORECA, LocalDate.now());
        return customerRepository.save(customer).getId();
    }


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
        Iterable<Customer> customers = customerRepository.findAll();
        List<Customer> custs = new ArrayList<>();
        customers.forEach(custs::add);
        List<CustomerDTO> customerDTOS = new ArrayList<>();

        for (var customer: custs){
            customerDTOS.add(CustomerDTO.builder()
                    .storeNumber(customer.getStoreNumber())
                    .country(customer.getCountry())
                    .name(customer.getName())
                    .VAT(customer.getVAT())
                    .CheckoutCheckCode((customer.getCheckoutCheckCode()))
                    .build());

        }
        return customerDTOS;
    }
}
