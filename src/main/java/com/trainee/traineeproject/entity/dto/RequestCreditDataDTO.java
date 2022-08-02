package com.trainee.traineeproject.entity.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;

public class RequestCreditDataDTO {

    private Integer id;
    //@JsonIgnore
    private Integer requestId;
    private CustomerDTO customer;
    private CreditDataDTO creditData;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getRequestId() {
        return requestId;
    }

    public void setRequestId(Integer requestId) {
        this.requestId = requestId;
    }

    /*public RequestDTO getRequest() {
        return request;
    }

    public void setRequest(RequestDTO request) {
        this.request = request;
    }*/

    public CustomerDTO getCustomer() {
        return customer;
    }

    public void setCustomer(CustomerDTO customer) {
        this.customer = customer;
    }

    public CreditDataDTO getCreditData() {
        return creditData;
    }

    public void setCreditData(CreditDataDTO creditData) {
        this.creditData = creditData;
    }
}
