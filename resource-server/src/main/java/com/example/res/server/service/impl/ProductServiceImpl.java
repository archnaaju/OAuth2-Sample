package com.example.res.server.service.impl;

import com.example.res.server.entity.Product;
import com.example.res.server.repository.ProductRepository;
import com.example.res.server.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductRepository productRepository;

    @Override
    public List<Product> findAllProducts() {
        Iterable<Product> productsIterable = productRepository.findAll();
        Iterator<Product> productIterator = productsIterable.iterator();
        List<Product> productList = new ArrayList<>();
        productIterator.forEachRemaining(productList::add);
        return productList;
    }

    @Override
    public Optional<Product> findProductById(UUID productId) {
        return productRepository.findById(productId);
    }
}
