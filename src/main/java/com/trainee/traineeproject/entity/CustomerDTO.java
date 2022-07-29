package com.trainee.traineeproject.entity;

import lombok.Builder;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.UUID;

@Builder
public class CustomerDTO {

    private String storeNumber;
    private String country;
    private String name;
    private String VAT;
    private String CheckoutCheckCode;

    private CreditData currentCreditData;
    private CustomerType customerType;


    public CustomerDTO(String storeNumber, String country, String name, String VAT,
                       String checkoutCheckCode, CreditData currentCreditData,
                       CustomerType customerType) {
        this.storeNumber = storeNumber;
        this.country = country;
        this.name = name;
        this.VAT = VAT;
        CheckoutCheckCode = checkoutCheckCode;
        this.currentCreditData = currentCreditData;
        this.customerType = customerType;
    }

    public CustomerDTO() {

    }

    public String getStoreNumber() {
        return storeNumber;
    }

    public void setStoreNumber(String storeNumber) {
        this.storeNumber = storeNumber;
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

    @Override
    public String toString() {
        return "CustomerDTO{" +
                "storeNumber='" + storeNumber + '\'' +
                ", country='" + country + '\'' +
                ", name='" + name + '\'' +
                ", VAT='" + VAT + '\'' +
                ", CheckoutCheckCode='" + CheckoutCheckCode + '\'' +
                ", currentCreditData=" + currentCreditData +
                ", customerType=" + customerType +
                '}';
    }
}
