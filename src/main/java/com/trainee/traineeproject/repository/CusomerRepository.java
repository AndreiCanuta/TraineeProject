package com.trainee.traineeproject.repository;

import com.trainee.traineeproject.entity.Customer;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CusomerRepository extends CrudRepository<Customer, String> {
}
