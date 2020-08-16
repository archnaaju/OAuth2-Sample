package com.example.res.server.repository;

import com.example.res.server.entity.Customer;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;
import java.util.UUID;

public interface CustomerRepository extends CrudRepository<Customer, Long> {
    Optional<Customer> findById(UUID id);
}
