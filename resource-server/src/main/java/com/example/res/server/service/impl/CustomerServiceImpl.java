package com.example.res.server.service.impl;

import com.example.res.server.entity.Customer;

import com.example.res.server.repository.CustomerRepository;
import com.example.res.server.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;

@Service
public class CustomerServiceImpl implements CustomerService {

    @Autowired()
    CustomerRepository customerRepository;

    @Override
    public List<Customer> findAll() {
        Iterable<Customer> customerIterable = customerRepository.findAll();
        Iterator<Customer> customerIterator = customerIterable.iterator();
        List<Customer> customerList = new ArrayList<>();
        customerIterator.forEachRemaining(customerList::add);
        return customerList;
    }

    @Override
    public Optional<Customer> getCustomerById(long customerId) {
        return customerRepository.findById(customerId);
    }

    @Override
    public Customer addCustomer(Customer customer) {
        return customerRepository.save(customer);
    }
}
