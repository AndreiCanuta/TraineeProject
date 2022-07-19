package com.trainee.traineeproject.controller;

import com.trainee.traineeproject.entity.Customer;
import com.trainee.traineeproject.entity.CustomerId;
import com.trainee.traineeproject.service.CustomerService;
import com.trainee.traineeproject.service.CustomerServiceImpl;
import com.trainee.traineeproject.service.CustomerServiceMocks;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.Mapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/customers")
public class CustomerController {

    @Autowired
    @Qualifier("customerServiceImpl")
    CustomerService customerService;

    @GetMapping()
    public ResponseEntity<?> getAllCustomers () {
        boolean conditie = true;
        if (conditie) {
            return ResponseEntity.ok(customerService.getAllCustomers());
            customerService.getAllCustomers().get(0).getProducts();
        } else {
            return ResponseEntity.badRequest().body("Ati gresit requestul!");
        }
    }

    @GetMapping("/{country}/{storeNumber}/{customerNumber}")
    public Customer getByCustomerId (@PathVariable("country") String country,
                                     @PathVariable("storeNumber") String store,
                                     @PathVariable() String customerNumber) {
        System.out.println("Params: " + country + "/" + store + "/" + customerNumber);
        return null;
//        return customerService.getByCustomerId(customerId);
    }

/*
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
*/

}
