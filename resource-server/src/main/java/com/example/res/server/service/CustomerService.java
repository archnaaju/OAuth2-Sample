package com.example.res.server.service;

import com.example.res.server.entity.Customer;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface CustomerService {
    List<Customer> findAllCustomers();
    Optional<Customer> findCustomerById(UUID customerId);
    Customer addCustomer(Customer customer);
    void updateCustomer(Customer customer);
    void deleteCustomer(UUID customerId);
}
