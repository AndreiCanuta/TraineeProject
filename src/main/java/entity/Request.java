package entity;

import java.time.LocalDateTime;
import java.util.Collection;

public class Request {
    private String id;
    private CustomerId requestedCustomerId;
    private Collection<RequestCustomerCreditData> requestedGroupCreditData;
    private RequestStatus status;
    private LocalDateTime createdAt;

    public Request(String id, CustomerId requestedCustomerId,
                   Collection<RequestCustomerCreditData> requestedGroupCreditData,
                   RequestStatus status, LocalDateTime createdAt) {
        this.id = id;
        this.requestedCustomerId = requestedCustomerId;
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

    public CustomerId getRequestedCustomerId() {
        return requestedCustomerId;
    }

    public void setRequestedCustomerId(CustomerId requestedCustomerId) {
        this.requestedCustomerId = requestedCustomerId;
    }

    public Collection<RequestCustomerCreditData> getRequestedGroupCreditData() {
        return requestedGroupCreditData;
    }

    public void setRequestedGroupCreditData(Collection<RequestCustomerCreditData> requestedGroupCreditData) {
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
