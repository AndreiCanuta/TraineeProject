package repository;

import data.Database;
import entity.Customer;

public class CustomerRepository {
    private final Database database = Database.getInstance();

    public void addCustomer (Customer customer) {
        database.addCustomer(customer);
    }
}
