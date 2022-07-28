package com.trainee.traineeproject.controller;

import com.trainee.traineeproject.entity.CreditData;
import com.trainee.traineeproject.entity.CreditDataType;
import com.trainee.traineeproject.entity.Product;
import com.trainee.traineeproject.repository.CreditDataRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/creditData")
public class CreditDataController {

    @Autowired
    CreditDataRepository creditDataRepository;


    @GetMapping("/add")
    public void addCreditData() {
        CreditData creditData = new CreditData(1, Product.BANK_TRANSFER , 15, CreditDataType.OLD);
        creditDataRepository.save(creditData);
    }

}
