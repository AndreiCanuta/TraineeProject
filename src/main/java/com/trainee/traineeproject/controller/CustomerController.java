package com.trainee.traineeproject.controller;
import com.trainee.traineeproject.entity.Customer;
import com.trainee.traineeproject.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/customers")
public class CustomerController {

    @Autowired
    CustomerService customerService;

    @GetMapping("/{id}")
    public ResponseEntity<?> getUser(@PathVariable UUID id) {
        return new ResponseEntity<>(customerService.getCustomer(id), HttpStatus.OK);
    }

    @GetMapping("/all")
    public ResponseEntity<?> getAllUsers() {
        return new ResponseEntity<>(customerService.getAllCustomers(), HttpStatus.OK);
    }

    @RequestMapping(path = "/{id}/delete", method={RequestMethod.DELETE, RequestMethod.GET})
    public ResponseEntity<?> deleteById(@PathVariable("id") UUID id) {
       try {
            customerService.deleteById(id);
            return new ResponseEntity<>("Customer deleted", HttpStatus.OK);
       } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
       }
    }

    @RequestMapping(path = "/{id}/{newStoreNumber}/updateStoreNumber", method=RequestMethod.GET)
    public ResponseEntity<?> updateCustomerStoreNumber(@PathVariable("id") UUID id,
                                            @PathVariable("newStoreNumber") String newStoreNumber) {
        try {
            customerService.updateStoreNumber(id, newStoreNumber);
            return new ResponseEntity<>("Customer updated", HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_MODIFIED);
        }
    }

    @RequestMapping(path = "/add", method=RequestMethod.GET)
    public ResponseEntity<?> addCustomer(@RequestBody Customer customer) {
        try {
            return new ResponseEntity<>(customerService.addCustomer(customer).toString(), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_ACCEPTABLE);
        }
    }

    @GetMapping("/paging/{pageNo}/{pageSize}")
    public List<Customer> getPaginatedCustomers(@PathVariable int pageNo,
                                               @PathVariable int pageSize) {

        List<Customer> paginatedCustomers = customerService.findPaginated(pageNo, pageSize);
        return paginatedCustomers;
    }
}
