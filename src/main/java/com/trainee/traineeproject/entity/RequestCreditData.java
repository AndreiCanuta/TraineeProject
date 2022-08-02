package com.trainee.traineeproject.entity;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

@Entity
public class RequestCreditData {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Integer id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(referencedColumnName = "id")
    private Request request;

    @OneToOne
    private Customer customer;

    @OneToOne
    private CreditData creditData;

    public RequestCreditData() {
    }

    public RequestCreditData(Integer id, Request request, Customer customer, CreditData creditData) {
        this.id = id;
        this.request = request;
        this.customer = customer;
        this.creditData = creditData;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Request getRequest() {
        return request;
    }

    public void setRequest(Request request) {
        this.request = request;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public CreditData getCreditData() {
        return creditData;
    }

    public void setCreditData(CreditData creditData) {
        this.creditData = creditData;
    }

    @Override
    public String toString() {
        return "RequestCreditData{" +
                "id='" + id + '\'' +
                ", request=" + request +
                ", customer=" + customer +
                ", creditData=" + creditData +
                '}';
    }
}