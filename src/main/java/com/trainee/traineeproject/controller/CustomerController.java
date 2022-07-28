package com.trainee.traineeproject.controller;

import com.trainee.traineeproject.entity.*;
import com.trainee.traineeproject.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/api/customers")
public class CustomerController {

    @Autowired
    CustomerRepository customerRepository;

    @GetMapping("/add")
    public void addCreditData() {
        CreditData creditData = new CreditData(1000, Product.BANK_TRANSFER , 15, CreditDataType.CURRENT);
        Customer customer = new Customer("1", "1", "1", "1", "1", "1", creditData, CustomerType.HORECA, LocalDate.now());
        customerRepository.save(customer);
    }




}
