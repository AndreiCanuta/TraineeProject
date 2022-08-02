package com.trainee.traineeproject.entity;

import javax.persistence.*;

@Entity
public class CreditData {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Integer id;
    private Integer creditLimit;
    @Enumerated(EnumType.STRING)
    private Product product;
    private Integer creditPeriod;
    @Enumerated(EnumType.STRING)
    private CreditDataType type;

    public CreditData(Integer creditLimit, Product product, Integer creditPeriod, CreditDataType type) {
        this.creditLimit = creditLimit;
        this.product = product;
        this.creditPeriod = creditPeriod;
        this.type = type;
    }

    public CreditData() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getCreditLimit() {
        return creditLimit;
    }

    public void setCreditLimit(Integer limit) {
        this.creditLimit = limit;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public Integer getCreditPeriod() {
        return creditPeriod;
    }

    public void setCreditPeriod(Integer creditPeriod) {
        this.creditPeriod = creditPeriod;
    }

    public CreditDataType getType() {
        return type;
    }

    public void setType(CreditDataType type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "CreditData{" +
                "limit=" + creditLimit +
                ", product=" + product +
                ", credit_period=" + creditPeriod +
                '}';
    }
}
