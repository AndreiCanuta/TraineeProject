package com.trainee.traineeproject.entity;

public class CreditData {
    private Integer limit;
    private Product product;
    private int credit_period;

    public CreditData(Integer limit, Product product, int period) {
        this.limit = limit;
        this.product = product;
        this.credit_period = period;
    }

    public double getLimit() {
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

    public int getPeriod() {
        return credit_period;
    }

    public void setPeriod(int period) {
        this.credit_period = period;
    }

    @Override
    public String toString() {
        return "CreditData{" +
                "limit=" + limit +
                ", product=" + product +
                ", period=" + credit_period +
                '}';
    }
}
