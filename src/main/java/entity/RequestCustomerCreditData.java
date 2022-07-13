package entity;

public class RequestCustomerCreditData {
    private CustomerId customerId;
    private CreditData intialCreditData;
    private CreditData newCreditData;

    public RequestCustomerCreditData(CustomerId customerId, CreditData intialCreditData, CreditData newCreditData) {
        this.customerId = customerId;
        this.intialCreditData = intialCreditData;
        this.newCreditData = newCreditData;
    }

    public CustomerId getCustomerId() {
        return customerId;
    }

    public void setCustomerId(CustomerId customerId) {
        this.customerId = customerId;
    }

    public CreditData getIntialCreditData() {
        return intialCreditData;
    }

    public void setIntialCreditData(CreditData intialCreditData) {
        this.intialCreditData = intialCreditData;
    }

    public CreditData getNewCreditData() {
        return newCreditData;
    }

    public void setNewCreditData(CreditData newCreditData) {
        this.newCreditData = newCreditData;
    }
}
