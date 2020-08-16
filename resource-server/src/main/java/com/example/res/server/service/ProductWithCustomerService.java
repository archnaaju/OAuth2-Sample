package com.example.res.server.service;

import com.example.res.server.entity.Product;

import java.util.Optional;
import java.util.UUID;

public interface ProductWithCustomerService {
    Optional<Product> addProductByCustomer(UUID customerId, Product product);
}
