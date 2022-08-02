package com.trainee.traineeproject.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import java.time.LocalDateTime;
import java.util.Collection;

@Entity
public class Request {
    @Id
    private Integer id;

    @OneToOne
    @JoinColumn(name = "customer_id")
    private Customer customerId;

    @OneToMany(mappedBy = "request", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
    private Collection<RequestCreditData> requestedGroupCreditData;

    @Enumerated(EnumType.STRING)
    private RequestStatus status;

    @Column(name = "request_data")
    private LocalDateTime createdAt;

    public Request() {
    }

    public Request(Integer id, Customer customerId, Collection<RequestCreditData> requestedGroupCreditData, RequestStatus status, LocalDateTime createdAt) {
        this.id = id;
        this.customerId = customerId;
        this.requestedGroupCreditData = requestedGroupCreditData;
        this.status = status;
        this.createdAt = createdAt;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Customer getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Customer customerId) {
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
                "id=" + id +
                ", customerId=" + customerId +
                ", requestedGroupCreditData=" + requestedGroupCreditData +
                ", status=" + status +
                ", createdAt=" + createdAt +
                '}';
    }

}

