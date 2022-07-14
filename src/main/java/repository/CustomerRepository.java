package repository;

import data.Database;
import entity.Customer;

import java.util.List;

public class CustomerRepository {
    private final Database database = Database.getInstance();

    public void addCustomer (Customer customer) {
        database.addCustomer(customer);
    }

    public List<Customer> getAllCustomers () {
        return database.getCustomers();
    }
}
