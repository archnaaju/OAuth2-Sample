package com.example.res.server.controllers;

import com.example.res.server.entity.Customer;
import com.example.res.server.entity.Product;
import com.example.res.server.service.CustomerService;
import com.example.res.server.service.ProductService;
import com.example.res.server.service.ProductWithCustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Controller
@RequestMapping("api/v1")
public class PublicResourceProductController {

    @Autowired
    private CustomerService customerService;

    @Autowired
    private ProductService productService;

    @Autowired
    private ProductWithCustomerService productWithCustomerService;

    @GetMapping("customers/{customerId}/products")
    public HttpEntity<List<Product>> getAllCustomers(@PathVariable("customerId") UUID customerId) {
        Optional<Customer> customer = customerService.findCustomerById(customerId);
        Optional<List<Product>> productList = Optional.empty();
        if (customer.isPresent()) {
            productList = Optional.ofNullable(customer.get().getProductList());
        }
        return productList.map(products -> new ResponseEntity<>(products, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(
                                Collections.emptyList(),
                                HttpStatus.INTERNAL_SERVER_ERROR
                        )
                );

    }

    @PostMapping("customers/{customerId}/products")
    public ResponseEntity<Void> addCustomer(@PathVariable("customerId") UUID customerId,
                                            @RequestBody Product product,
                                            UriComponentsBuilder builder) {
        Optional<Product> productResult = productWithCustomerService
                .addProductByCustomer(customerId, product);
        HttpHeaders headers = new HttpHeaders();
        productResult.ifPresent(value -> headers.setLocation(builder
                .path("/api/v1/products/{productId}")
                .buildAndExpand(value.getId()).toUri())
        );
        return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
    }

    @GetMapping("products/{productId}")
    public HttpEntity<?> getProductById(@PathVariable("productId") UUID productId) {
        Optional<Product> product = productService.findProductById(productId);
        if (product.isPresent()) {
            return new ResponseEntity<Product>(product.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<String>("Not found Product with id = " + productId,
                    HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
