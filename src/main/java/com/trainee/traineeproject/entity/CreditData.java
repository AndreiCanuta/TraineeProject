package com.trainee.traineeproject.entity;

public class CreditData {
    private Integer id;
    private Integer limit;
    private Product product;
    private Integer credit_period;

    public CreditData(Integer id, Integer limit, Product product, Integer credit_period) {
        this.id = id;
        this.limit = limit;
        this.product = product;
        this.credit_period = credit_period;
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

    @Override
    public String toString() {
        return "CreditData{" +
                "limit=" + limit +
                ", product=" + product +
                ", credit_period=" + credit_period +
                '}';
    }
}
