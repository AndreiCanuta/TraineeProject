package entity;

public class CustomerId {
    private String storeNumber;
    private String customerNumber;
    private String country;

    public CustomerId(String storeNumber, String customerNumber, String country) {
        this.storeNumber = storeNumber;
        this.customerNumber = customerNumber;
        this.country = country;
    }

    public String getStoreNumber() {
        return storeNumber;
    }

    public void setStoreNumber(String storeNumber) {
        this.storeNumber = storeNumber;
    }

    public String getCustomerNumber() {
        return customerNumber;
    }

    public void setCustomerNumber(String customerNumber) {
        this.customerNumber = customerNumber;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }
}
