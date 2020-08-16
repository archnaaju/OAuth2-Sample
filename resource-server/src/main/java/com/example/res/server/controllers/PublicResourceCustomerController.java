package com.example.res.server.controllers;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import com.example.res.server.entity.Customer;
import com.example.res.server.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;


@Controller
@RequestMapping("api/v1")
public class PublicResourceCustomerController {
	@Autowired
	private CustomerService customerService;

	@GetMapping("customers/{customerId}")
	public HttpEntity<?> getCustomer(@PathVariable("customerId") UUID id) {
		Optional<Customer> customer = customerService.findCustomerById(id);
		if (customer.isPresent()) {
			return new ResponseEntity<Customer>(customer.get(), HttpStatus.OK);
		} else {
			return new ResponseEntity<String>("Not found Customer with id = " + id, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("customers")
	public ResponseEntity<List<Customer>> getAllCustomers() {
		List<Customer> list = customerService.findAllCustomers();
		return new ResponseEntity<List<Customer>>(list, HttpStatus.OK);
	}

	@PostMapping("customers")
	public ResponseEntity<Void> addCustomer(@RequestBody Customer customer, UriComponentsBuilder builder) {
		Customer customerResult = customerService.addCustomer(customer);
		HttpHeaders headers = new HttpHeaders();
		headers.setLocation(builder.path("/customers/{customerId}").buildAndExpand(customerResult.getId()).toUri());
		return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
	}

} 