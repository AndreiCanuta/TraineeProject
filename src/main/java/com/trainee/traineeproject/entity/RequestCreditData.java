package com.trainee.traineeproject.entity;

public class RequestCreditData {
    private Integer id;
    private Integer requestId;
    private Integer customerId;
    private Integer creditDataId;

    public RequestCreditData(Integer id, Integer requestId, Integer customerId, Integer creditDataId) {
        this.id = id;
        this.requestId = requestId;
        this.customerId = customerId;
        this.creditDataId = creditDataId;
    }

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

    public Integer getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Integer customerId) {
        this.customerId = customerId;
    }

    public Integer getCreditDataId() {
        return creditDataId;
    }

    public void setCreditDataId(Integer creditDataId) {
        this.creditDataId = creditDataId;
    }

    @Override
    public String toString() {
        return "RequestCreditData{" +
                "id=" + id +
                ", requestId=" + requestId +
                ", customerId=" + customerId +
                ", creditDataId=" + creditDataId +
                '}';
    }
}