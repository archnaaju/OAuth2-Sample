package com.example.res.server.repository;

import com.example.res.server.entity.Product;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;
import java.util.UUID;

public interface ProductRepository extends CrudRepository<Product, Long> {
    Optional<Product> findById(UUID id);
}
