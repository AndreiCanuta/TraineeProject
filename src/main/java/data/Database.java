package data;

import entity.Customer;

import java.util.ArrayList;
import java.util.List;

public class Database {
    private static Database instance = null;
    public List<Customer> customers;

    private Database () {
        customers = new ArrayList<Customer>();
    }

    public static Database getInstance() {
        if (instance == null) {
            instance = new Database();
        }
        return instance;
    }
}
