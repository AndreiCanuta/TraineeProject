package com.trainee.traineeproject.repository;

import com.trainee.traineeproject.data.Database;
import com.trainee.traineeproject.entity.Customer;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class CustomerRepository {
    private Database database = Database.getInstance();

    public List<Customer> getAllCustomers () {
        return database.getCustomers();
    }

    public void addCustomer (Customer customer) {
        database.addCustomer(customer);
    }
}
