package com.trainee.traineeproject.repository;

import com.trainee.traineeproject.entity.Request;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RequestRepository extends CrudRepository<Request, Integer>, JpaRepository<Request, Integer> {



}
