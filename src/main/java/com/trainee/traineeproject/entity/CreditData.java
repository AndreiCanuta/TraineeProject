package com.trainee.traineeproject.entity;

import javax.persistence.*;

@Entity
@Table(name = "credit_data")
public class CreditData {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private Integer limit;
    @Enumerated(EnumType.STRING)
    private Product product;
    private Integer credit_period;

    private String type;

    public CreditData(Integer limit, Product product, Integer credit_period, String type) {
        this.limit = limit;
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

    public Integer getLimit() {
        return limit;
    }

    public void setLimit(Integer limit) {
        this.limit = limit;
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

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "CreditData{" +
                "limit=" + limit +
                ", product=" + product +
                ", credit_period=" + credit_period +
                '}';
    }
}
