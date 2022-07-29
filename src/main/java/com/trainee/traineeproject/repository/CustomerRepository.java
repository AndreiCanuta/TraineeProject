package com.trainee.traineeproject.repository;

import com.trainee.traineeproject.entity.Customer;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface CustomerRepository extends CrudRepository<Customer, Integer> {
    public Customer findById(UUID id);
}
