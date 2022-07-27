package com.trainee.traineeproject.entity;

import java.time.LocalDateTime;
import java.util.Collection;

public class Request {
    private String id;
    private Integer customerId;
    private Collection<RequestCreditData> requestedGroupCreditData;
    private RequestStatus status;
    private LocalDateTime createdAt;

    public Request(String id, Integer customerId, Collection<RequestCreditData> requestedGroupCreditData, RequestStatus status, LocalDateTime createdAt) {
        this.id = id;
        this.customerId = customerId;
        this.requestedGroupCreditData = requestedGroupCreditData;
        this.status = status;
        this.createdAt = createdAt;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Integer getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Integer customerId) {
        this.customerId = customerId;
    }

    public Collection<RequestCreditData> getRequestedGroupCreditData() {
        return requestedGroupCreditData;
    }

    public void setRequestedGroupCreditData(Collection<RequestCreditData> requestedGroupCreditData) {
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

    @Override
    public String toString() {
        return "Request{" +
                "id='" + id + '\'' +
                ", customerId=" + customerId +
                ", requestedGroupCreditData=" + requestedGroupCreditData +
                ", status=" + status +
                ", createdAt=" + createdAt +
                '}';
    }
}

