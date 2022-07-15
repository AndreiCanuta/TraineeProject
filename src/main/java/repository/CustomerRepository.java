package repository;

import data.Database;
import entity.Customer;
import entity.CustomerId;

import java.util.List;

public class CustomerRepository {
    private final Database database = Database.getInstance();

    public void addCustomer (Customer customer) {
        database.addCustomer(customer);
    }

    public List<Customer> getAllCustomers () {
        return database.getCustomers();
    }

    public Customer getByCustomerId (CustomerId customerId) {
        for (Customer customer : database.getCustomers()) {
            if (customer.getCustomerId().equals(customerId)) {
                return customer;
            }
        }
        return null;
    }
}
