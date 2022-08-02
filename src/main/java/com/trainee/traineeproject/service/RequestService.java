package com.trainee.traineeproject.service;

import com.trainee.traineeproject.entity.Request;
import com.trainee.traineeproject.entity.RequestCreditData;
import com.trainee.traineeproject.entity.dto.CreditDataDTO;
import com.trainee.traineeproject.entity.dto.CustomerDTO;
import com.trainee.traineeproject.entity.dto.RequestCreditDataDTO;
import com.trainee.traineeproject.entity.dto.RequestDTO;
import com.trainee.traineeproject.repository.RequestRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class RequestService {

    private RequestRepository requestRepository;

    public RequestService(RequestRepository requestRepository) {
        this.requestRepository = requestRepository;
    }

    public Request update(Integer id, Request updatedRequest) {
        assert id.equals(updatedRequest.getId()) : "Id not matching";

        Request request = requestRepository.findById(id).orElseThrow(() -> new RuntimeException("request not found"));

        // update data on request
        request.setCustomerId(updatedRequest.getCustomerId());
        request.setCreatedAt(updatedRequest.getCreatedAt());
        request.setStatus(updatedRequest.getStatus());

        // what is happening here? :D
        request.setRequestedGroupCreditData(updatedRequest.getRequestedGroupCreditData());

        // save
        return requestRepository.save(request);
    }

    public RequestDTO getById(Integer id) {
        Request request = requestRepository.findById(id).orElse(null);
        RequestDTO requestDTO = new RequestDTO();

        requestDTO.setId(request.getId());
        requestDTO.setCustomerId(new CustomerDTO(
                request.getCustomerId().getStoreNumber(),
                request.getCustomerId().getCountry(),
                request.getCustomerId().getName(),
                request.getCustomerId().getVAT(),
                request.getCustomerId().getCheckoutCheckCode(),
                request.getCustomerId().getCurrentCreditData(),
                request.getCustomerId().getCustomerType()
                ));
        requestDTO.setCreatedAt(request.getCreatedAt());
        requestDTO.setStatus(request.getStatus());
        requestDTO.setRequestedGroupCreditData(
                request.getRequestedGroupCreditData().stream()
                        .map(requestCreditData -> mapToDTO(requestCreditData, requestDTO))
                        .collect(Collectors.toList())
        );
        return requestDTO;
    }

    private RequestCreditDataDTO mapToDTO(RequestCreditData requestCreditData, RequestDTO requestDTO) {
        RequestCreditDataDTO dto = new RequestCreditDataDTO();
        dto.setId(requestCreditData.getId());
        //dto.setRequest(requestDTO);
        dto.setRequestId(requestCreditData.getRequest().getId());
        dto.setCreditData(new CreditDataDTO(
                null,
                requestCreditData.getCreditData().getCreditLimit(),
                requestCreditData.getCreditData().getProduct(),
                requestCreditData.getCreditData().getCreditPeriod()
                ));
        dto.setCustomer(new CustomerDTO(
                requestCreditData.getCustomer().getStoreNumber(),
                requestCreditData.getCustomer().getCountry(),
                requestCreditData.getCustomer().getName(),
                requestCreditData.getCustomer().getVAT(),
                requestCreditData.getCustomer().getCheckoutCheckCode(),
                requestCreditData.getCustomer().getCurrentCreditData(),
                requestCreditData.getCustomer().getCustomerType()
        ));
        return dto;
    }

}
