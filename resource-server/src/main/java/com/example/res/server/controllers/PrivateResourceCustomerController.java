package com.example.res.server.controllers;

import com.example.res.server.entity.Customer;
import com.example.res.server.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;


@Controller
@RequestMapping("api/v1")
public class PrivateResourceCustomerController {
    @Autowired
    private CustomerService customerService;

    @PutMapping("customers/{customerId}")
    public ResponseEntity<Customer> updateCustomer(@PathVariable("customerId") UUID customerId, @RequestBody Customer customer) {
        customerService.updateCustomer(customer);
        return new ResponseEntity<Customer>(customer, HttpStatus.OK);
    }
    @DeleteMapping("customers/{customerId}")
    public ResponseEntity<Void> deleteCustomer(@PathVariable("customerId") UUID customerId) {
        customerService.deleteCustomer(customerId);
        return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
    }
}
