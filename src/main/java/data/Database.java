package data;

import entity.Customer;

import java.util.ArrayList;
import java.util.List;

public class Database {
    private static Database instance = null;
    final private List<Customer> customers = new ArrayList<Customer>();;

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
        this.customers.add(customer);
    }
}
