package com.trainee.traineeproject.entity.dto;

import com.trainee.traineeproject.entity.Product;
import lombok.Builder;
import org.springframework.stereotype.Component;

import javax.persistence.Entity;
import java.util.UUID;

@Builder
public class CreditDataDTO {
    private UUID customerId;
    private Integer creditLimit;
    private Product product;
    private Integer creditPeriod;

    public CreditDataDTO(UUID customerId, Integer creditLimit, Product product, Integer creditPeriod) {
        this.customerId = customerId;
        this.creditLimit = creditLimit;
        this.product = product;
        this.creditPeriod = creditPeriod;
    }

    public CreditDataDTO() {}

    public Integer getCreditLimit() {
        return creditLimit;
    }

    public void setCreditLimit(Integer creditLimit) {
        this.creditLimit = creditLimit;
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

    public UUID getCustomerId() {
        return customerId;
    }

    public void setCustomerId(UUID customerId) {
        this.customerId = customerId;
    }
}