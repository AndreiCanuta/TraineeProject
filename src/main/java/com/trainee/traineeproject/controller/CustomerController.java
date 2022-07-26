package com.trainee.traineeproject.controller;

import com.trainee.traineeproject.entity.Customer;
import com.trainee.traineeproject.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/customers")
public class CustomerController {

    @Autowired
    CustomerService customerService;

    @GetMapping()
    public ResponseEntity<List<Customer>> getAllCustomers () {
        return ResponseEntity.ok(customerService.getAllCustomers());
    }




}
