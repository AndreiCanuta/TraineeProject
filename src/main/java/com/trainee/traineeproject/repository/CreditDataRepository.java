package com.trainee.traineeproject.repository;

import com.trainee.traineeproject.entity.CreditData;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CreditDataRepository extends CrudRepository<CreditData, Integer> {
}
