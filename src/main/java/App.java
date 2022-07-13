import data.Database;
import entity.Customer;

import java.util.ArrayList;
import java.util.List;

public class App {

    public static void main (String[] arcs) {
        Database database = Database.getInstance();
        List<Customer> customerList = database.getCustomers();
    }
}
