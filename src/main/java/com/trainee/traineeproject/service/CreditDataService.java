package com.trainee.traineeproject.service;

import com.trainee.traineeproject.entity.CreditData;
import com.trainee.traineeproject.entity.dto.CreditDataDTO;
import com.trainee.traineeproject.repository.CreditDataRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Spliterator;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class CreditDataService {

    @Autowired
    CreditDataRepository creditDataRepository;

    @Transactional
    public List<CreditDataDTO> getAllCreditData() {
        Spliterator<CreditData> creditDataSpliterator = creditDataRepository.findAll().spliterator();


        return StreamSupport.stream(creditDataSpliterator,true)
                 .map(c -> CreditDataDTO.builder()
                    .creditLimit(c.getCreditLimit())
                    .creditPeriod(c.getCreditPeriod())
                    .product(c.getProduct())
                    .build())
                 .collect(Collectors.toList());
    }

    @Transactional
    public CreditDataDTO getCreditDataById (Integer id) {
        CreditData creditData = creditDataRepository.findById(id)
                .orElseThrow(() ->
                        new ResponseStatusException(HttpStatus.NOT_FOUND, "CreditData does not exist"));


        return CreditDataDTO.builder()
                .creditLimit(creditData.getCreditLimit())
                .creditPeriod(creditData.getCreditPeriod())
                .product(creditData.getProduct())
                .build();
    }

    @Transactional
    public List<CreditDataDTO> aux () {
        creditDataRepository.findByCreditLimitBetweenOrderByCreditLimitDesc(1000,2000);
        return creditDataRepository.findAllCredit();
    }


}
