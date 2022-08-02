package com.trainee.traineeproject.entity.dto;

import com.trainee.traineeproject.entity.RequestStatus;

import java.time.LocalDateTime;
import java.util.Collection;

public class RequestDTO {

    private Integer id;
    private CustomerDTO customerId;
    private Collection<RequestCreditDataDTO> requestedGroupCreditData;
    private RequestStatus status;
    private LocalDateTime createdAt;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public CustomerDTO getCustomerId() {
        return customerId;
    }

    public void setCustomerId(CustomerDTO customerId) {
        this.customerId = customerId;
    }

    public Collection<RequestCreditDataDTO> getRequestedGroupCreditData() {
        return requestedGroupCreditData;
    }

    public void setRequestedGroupCreditData(Collection<RequestCreditDataDTO> requestedGroupCreditData) {
        this.requestedGroupCreditData = requestedGroupCreditData;
    }

    public RequestStatus getStatus() {
        return status;
    }

    public void setStatus(RequestStatus status) {
        this.status = status;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }
}
