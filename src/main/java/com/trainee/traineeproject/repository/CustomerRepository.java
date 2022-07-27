package com.trainee.traineeproject.repository;

import com.trainee.traineeproject.entity.Customer;
import org.springframework.data.repository.CrudRepository;

public interface CustomerRepository extends CrudRepository<Customer, Integer> {

}
