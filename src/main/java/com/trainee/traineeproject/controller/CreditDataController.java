package com.trainee.traineeproject.controller;

import com.trainee.traineeproject.entity.CreditData;
import com.trainee.traineeproject.entity.CreditDataType;
import com.trainee.traineeproject.entity.Product;
import com.trainee.traineeproject.repository.CreditDataRepository;
import com.trainee.traineeproject.service.CreditDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/creditData")
public class CreditDataController {

    @Autowired
    CreditDataService creditDataService;

    @GetMapping("/all")
    public ResponseEntity<?> getAllCreditData () {
        return new ResponseEntity<>(creditDataService.getAllCreditData(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getCreditDataById (@PathVariable Integer id) {
        return new ResponseEntity<>(creditDataService.getCreditDataById(id), HttpStatus.OK);
    }
    @GetMapping("/alll")
    public ResponseEntity<?> getAllCreditDataAux () {
        return new ResponseEntity<>(creditDataService.aux(), HttpStatus.OK);
    }
}
