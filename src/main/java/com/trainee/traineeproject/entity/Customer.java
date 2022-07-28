package com.trainee.traineeproject.entity;

import javax.persistence.*;
import java.time.LocalDate;
@Entity
@Table(name = "customer")
public class Customer {
    @Id
    @GeneratedValue(strategy=GenerationType.SEQUENCE)
    private Integer id;
    private String storeNumber;
    private String customerNumber;
    private String country;
    private String name;
    private String VAT;
    private String CheckoutCheckCode;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "current_credit_data")
    private CreditData currentCreditData;
    @Enumerated(EnumType.STRING)
    private CustomerType customerType;
    private LocalDate registrationDate;


    public Customer(String storeNumber, String customerNumber, String country, String name, String VAT, String checkoutCheckCode, CreditData currentCreditData, CustomerType customerType, LocalDate registrationDate) {
        this.storeNumber = storeNumber;
        this.customerNumber = customerNumber;
        this.country = country;
        this.name = name;
        this.VAT = VAT;
        CheckoutCheckCode = checkoutCheckCode;
        this.currentCreditData = currentCreditData;
        this.customerType = customerType;
        this.registrationDate = registrationDate;
    }

    public Customer() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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

    public CreditData getCurrentCreditData() {
        return currentCreditData;
    }

    public void setCurrentCreditData(CreditData currentCreditData) {
        this.currentCreditData = currentCreditData;
    }

    public CustomerType getCustomerType() {
        return customerType;
    }

    public void setCustomerType(CustomerType customerType) {
        this.customerType = customerType;
    }

    public LocalDate getRegistrationDate() {
        return registrationDate;
    }

    public void setRegistrationDate(LocalDate registrationDate) {
        this.registrationDate = registrationDate;
    }


    @Override
    public String toString() {
        return "Customer{" +
                "id=" + id +
                ", storeNumber='" + storeNumber + '\'' +
                ", customerNumber='" + customerNumber + '\'' +
                ", country='" + country + '\'' +
                ", name='" + name + '\'' +
                ", VAT='" + VAT + '\'' +
                ", CheckoutCheckCode='" + CheckoutCheckCode + '\'' +
                ", currentCreditData=" + currentCreditData +
                ", customerType=" + customerType +
                ", registrationDate=" + registrationDate +
                '}';
    }
}
