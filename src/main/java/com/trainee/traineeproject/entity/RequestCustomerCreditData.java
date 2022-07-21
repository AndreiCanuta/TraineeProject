package com.trainee.traineeproject.entity;

public class RequestCustomerCreditData {
    private CustomerId customerId;
    private CreditData initialCreditData;
    private CreditData newCreditData;

    public RequestCustomerCreditData(CustomerId customerId, CreditData initialCreditData, CreditData newCreditData) {
        this.customerId = customerId;
        this.initialCreditData = initialCreditData;
        this.newCreditData = newCreditData;
    }

    public CustomerId getCustomerId() {
        return customerId;
    }

    public void setCustomerId(CustomerId customerId) {
        this.customerId = customerId;
    }

    public CreditData getInitialCreditData() {
        return initialCreditData;
    }

    public void setInitialCreditData(CreditData initialCreditData) {
        this.initialCreditData = initialCreditData;
    }

    public CreditData getNewCreditData() {
        return newCreditData;
    }

    public void setNewCreditData(CreditData newCreditData) {
        this.newCreditData = newCreditData;
    }
}
