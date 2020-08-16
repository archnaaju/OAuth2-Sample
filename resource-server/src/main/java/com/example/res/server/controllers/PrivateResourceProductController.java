package com.example.res.server.controllers;

import com.example.res.server.entity.Product;
import com.example.res.server.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@Controller
@RequestMapping("api/v1")
public class PrivateResourceProductController {
    @Autowired
    private ProductService productService;

    @PutMapping("products/{productId}")
    public ResponseEntity<Product> updateProduct(@PathVariable("productId") UUID productId,
                                                 @RequestBody Product product) {
        productService.updateProduct(product);
        return new ResponseEntity<Product>(product, HttpStatus.OK);
    }

    @DeleteMapping("products/{productId}")
    public ResponseEntity<Void> deleteProduct(@PathVariable("productId") UUID productId) {
        productService.deleteProduct(productId);
        return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
    }
}
