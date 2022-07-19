package com.trainee.traineeproject.entity;

import com.sun.istack.NotNull;
import org.hibernate.annotations.Fetch;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

@Entity
public class Customer {

    @Id
    private String id;

    // private CustomerId customerId;
    @NotNull
    private String country;

    @Column(name = "store")
    private String storeNumber;

    private String customerNumber;

    private String name;
    private String VAT;
    private String CheckoutCheckCode;
//    private CreditData currentCreditData;

    @Enumerated
    private CustomerType customerType;
    private LocalDate registrationDate;

    @OneToMany(fetch = FetchType.LAZY)
    private List<Product> products;

    public List<Product> getProducts() {
        return products;
    }

    public Customer() {
    }

    public Customer(CustomerId customerId, String name, String VAT,
                    String checkoutCheckCode, CreditData currentCreditData,
                    CustomerType customerType, LocalDate registrationDate) {
        this.id = UUID.randomUUID().toString();
        this.country = customerId.getCountry();
        this.storeNumber = customerId.getStoreNumber();
        this.customerNumber = customerId.getCustomerNumber();
        this.name = name;
        this.VAT = VAT;
        CheckoutCheckCode = checkoutCheckCode;
//        this.currentCreditData = currentCreditData;
        this.customerType = customerType;
        this.registrationDate = registrationDate;
    }

    /*public CustomerId getCustomerId() {
        return customerId;
    }

    public void setCustomerId(CustomerId customerId) {
        this.customerId = customerId;
    }
*/

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getVAT() {
        return VAT;
    }

    public void setVAT(String VAT) {
        this.VAT = VAT;
    }

    public String getCheckoutCheckCode() {
        return CheckoutCheckCode;
    }

    public void setCheckoutCheckCode(String checkoutCheckCode) {
        CheckoutCheckCode = checkoutCheckCode;
    }

/*
    public CreditData getCurrentCreditData() {
        return currentCreditData;
    }

    public void setCurrentCreditData(CreditData currentCreditData) {
        this.currentCreditData = currentCreditData;
    }
*/

    public CustomerType getCustomerType() {
        return customerType;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", VAT='" + VAT + '\'' +
                ", CheckoutCheckCode='" + CheckoutCheckCode + '\'' +
//                ", currentCreditData=" + currentCreditData +
                ", customerType=" + customerType +
                ", registrationDate=" + registrationDate +
                '}';
    }
}
