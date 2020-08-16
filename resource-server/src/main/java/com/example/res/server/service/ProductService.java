package com.example.res.server.service;

import com.example.res.server.entity.Product;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface ProductService {
    List<Product> findAllProducts();
    Optional<Product> findProductById(UUID productId);
}
