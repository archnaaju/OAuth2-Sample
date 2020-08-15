package com.example.res.server.service;

import com.example.res.server.entity.Customer;

import java.util.List;

public interface FindCustomerService {
    List<Customer> findAll();
}
