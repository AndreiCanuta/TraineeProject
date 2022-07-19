package repository;

import data.Database;
import entity.Customer;
import entity.CustomerId;

import java.util.List;
import java.util.stream.Collectors;

public class CustomerRepository {
    private final Database database = Database.getInstance();

    public void addCustomer (Customer customer) {
        database.addCustomer(customer);
    }

    public List<Customer> getAllCustomers () {
        return database.getCustomers();
    }

    public Customer getByCustomerId (CustomerId customerId) {
        try {
            List<Customer> customers = database.getCustomers()
                    .stream()
                    .filter(c -> c.getCustomerId().equals(customerId))
                    .collect(Collectors.toList());

            return customers.get(0);
        } catch (IndexOutOfBoundsException e){
            return null;
        }
    }

    public List<Customer> getGroupByVAT (String VAT) {
        return database.getCustomers()
                .stream()
                .filter(c -> c.getVAT().equals(VAT))
                .collect(Collectors.toList());
    }

    public List<Customer> getCustomersByCountry (String country) {
        return database.getCustomers()
                .stream()
                .filter(c -> c.getCustomerId().getCountry().equals(country))
                .collect(Collectors.toList());
    }

    public List<Customer> getCustomersByStoreNumber (String storeNumber) {
        return database.getCustomers()
                .stream()
                .filter(c -> c.getCustomerId().getStoreNumber().equals(storeNumber))
                .collect(Collectors.toList());
    }

    public List<Customer> getCustomersByCustomerNumber (String customerNumber) {
        return database.getCustomers()
                .stream()
                .filter(c -> c.getCustomerId().getCustomerNumber().equals(customerNumber))
                .collect(Collectors.toList());
    }

    public void changeCheckoutCode (String country, String checkoutCheckCodeOld, String checkoutCheckCodeNew) {
        database.getCustomers()
                .stream()
                .filter(c -> c.getCheckoutCheckCode().equals(checkoutCheckCodeOld) && c.getCustomerId().getCountry().equals(country))
                .forEach(c -> c.setCheckoutCheckCode(checkoutCheckCodeNew));
    }

}
