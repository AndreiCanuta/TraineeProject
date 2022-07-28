package com.trainee.traineeproject.entity;

import javax.persistence.*;

@Entity
public class CreditData {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Integer id;
    private Integer credit_limit;
    @Enumerated(EnumType.STRING)
    private Product product;
    private Integer credit_period;
    @Enumerated(EnumType.STRING)
    private CreditDataType type;

    public CreditData(Integer credit_limit, Product product, Integer credit_period, CreditDataType type) {
        this.credit_limit = credit_limit;
        this.product = product;
        this.credit_period = credit_period;
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

    public Integer getCredit_limit() {
        return credit_limit;
    }

    public void setCredit_limit(Integer limit) {
        this.credit_limit = limit;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public Integer getCredit_period() {
        return credit_period;
    }

    public void setCredit_period(Integer credit_period) {
        this.credit_period = credit_period;
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
                "limit=" + credit_limit +
                ", product=" + product +
                ", credit_period=" + credit_period +
                '}';
    }
}
