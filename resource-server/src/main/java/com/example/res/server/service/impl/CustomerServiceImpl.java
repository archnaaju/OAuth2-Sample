package com.example.res.server.service.impl;

import com.example.res.server.entity.Customer;

import com.example.res.server.repository.CustomerRepository;
import com.example.res.server.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    private CustomerRepository customerRepository;

    @Override
    public List<Customer> findAllCustomers() {
        Iterable<Customer> customerIterable = customerRepository.findAll();
        Iterator<Customer> customerIterator = customerIterable.iterator();
        List<Customer> customerList = new ArrayList<>();
        customerIterator.forEachRemaining(customerList::add);
        return customerList;
    }

    @Override
    public Optional<Customer> findCustomerById(UUID customerId) {
        return customerRepository.findById(customerId);
    }

    @Override
    public Customer addCustomer(Customer customer) {
        return customerRepository.save(customer);
    }

    @Override
    public void updateCustomer(Customer customer) {
        customerRepository.save(customer);
    }

    @Override
    public void deleteCustomer(UUID customerId) {
        Optional<Customer> customerForDelete = findCustomerById(customerId);
        customerForDelete.ifPresent(customer -> customerRepository.delete(customer));
    }
}
