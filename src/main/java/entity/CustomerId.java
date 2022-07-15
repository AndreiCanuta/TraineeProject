package entity;

import java.util.Objects;

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

    @Override
    public String toString() {
        return "CustomerId{" +
                "storeNumber='" + storeNumber + '\'' +
                ", customerNumber='" + customerNumber + '\'' +
                ", country='" + country + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof CustomerId)) return false;
        CustomerId that = (CustomerId) o;
        return Objects.equals(storeNumber, that.storeNumber) && Objects.equals(customerNumber, that.customerNumber) && Objects.equals(country, that.country);
    }

    @Override
    public int hashCode() {
        return Objects.hash(storeNumber, customerNumber, country);
    }
}
