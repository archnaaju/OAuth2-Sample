package com.example.res.server.service;

import com.example.res.server.entity.Customer;

import java.util.List;
import java.util.Optional;

public interface CustomerService {
    List<Customer> findAll();
    Optional<Customer> getCustomerById(String customerId);
    Customer addCustomer(Customer customer);
    void updateCustomer(Customer customer);
    void deleteCustomer(String customerId);
}
