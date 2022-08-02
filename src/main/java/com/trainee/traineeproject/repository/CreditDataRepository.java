package com.trainee.traineeproject.repository;

import com.trainee.traineeproject.entity.CreditData;
import com.trainee.traineeproject.entity.dto.CreditDataDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CreditDataRepository extends CrudRepository<CreditData, Integer>, JpaRepository<CreditData, Integer> {

    @Query(value = "SELECT new com.trainee.traineeproject.entity.dto.CreditDataDTO(" +
            "cust.id, cred.creditLimit, cred.product, cred.creditPeriod) " +
            "from Customer cust " +
            "join CreditData cred " +
            "on cust.currentCreditData = cred.id")
    List<CreditDataDTO> findAllCredit();

    List<CreditData> findByCreditLimitBetweenOrderByCreditLimitDesc(Integer startLimit, Integer endLimit);


}
