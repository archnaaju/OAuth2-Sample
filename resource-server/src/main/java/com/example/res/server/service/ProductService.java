package com.example.res.server.service;

import com.example.res.server.entity.Product;

import java.util.List;
import java.util.Optional;

public interface ProductService {
    List<Product> findAllProducts();
    Optional<Product> getProductById(String productId);
}
