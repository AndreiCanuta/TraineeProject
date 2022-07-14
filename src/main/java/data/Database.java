package data;

import entity.Customer;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Database {
    private static Database instance = null;
    private static final List<Customer> customers = Collections.synchronizedList(new ArrayList<>());

    private Database () {

    }

    public static Database getInstance() {
        if (instance == null) {
            instance = new Database();
        }
        return instance;
    }

    public List<Customer> getCustomers() {
        return customers;
    }

    public void addCustomer(Customer customer){
        customers.add(customer);
    }

    @Override
    public String toString() {
        return "Database{" +
                "customers=" + customers +
                '}';
    }
}
