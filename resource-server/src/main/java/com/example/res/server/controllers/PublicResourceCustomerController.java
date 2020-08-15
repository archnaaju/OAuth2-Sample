package com.example.res.server.controllers;
import java.util.List;

import com.example.res.server.entity.Customer;
import com.example.res.server.service.FindCustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;




@Controller
@RequestMapping("api/v1")
public class PublicResourceCustomerController {
	@Autowired
	private FindCustomerService findCustomerService;

	@GetMapping("customers")
	public ResponseEntity<List<Customer>> getAllArticles() {
		List<Customer> list = findCustomerService.findAll();
		return new ResponseEntity<List<Customer>>(list, HttpStatus.OK);
	}

} 