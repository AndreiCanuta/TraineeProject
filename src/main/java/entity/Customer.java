package entity;

import entity.CreditData;
import entity.CustomerId;
import entity.CustomerType;

import java.util.Date;

public class Customer {
    private CustomerId customerId;
    private String name;
    private String VAT;
    private String CheckoutCheckCode;
    private CreditData currentCreditData;
    private CustomerType customerType;
    private Date registrationDate;

    public Customer(CustomerId customerId, String name, String VAT,
                    String checkoutCheckCode, CreditData currentCreditData,
                    CustomerType customerType, Date registrationDate) {
        this.customerId = customerId;
        this.name = name;
        this.VAT = VAT;
        CheckoutCheckCode = checkoutCheckCode;
        this.currentCreditData = currentCreditData;
        this.customerType = customerType;
        this.registrationDate = registrationDate;
    }

    public CustomerId getCustomerId() {
        return customerId;
    }

    public void setCustomerId(CustomerId customerId) {
        this.customerId = customerId;
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
}
