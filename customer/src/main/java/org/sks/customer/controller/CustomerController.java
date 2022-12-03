package org.sks.customer.controller;

import java.util.Optional;

import org.sks.customer.bean.Customer;
import org.sks.customer.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/customer")
public class CustomerController {
	@Autowired
	CustomerService customerService;

	@GetMapping(value = "/{customerId}")
	public void getCustomer(@PathVariable(required = false) Optional<Integer> customerId) {
		if (customerId.isPresent()) {
			customerService.findCustomer(customerId.get());
		}

	}

	@PostMapping(value = "/")
	public Customer addCustomer(@RequestBody Customer customer) {
		customerService.addCustomer(customer);
		return customer;
	}
}
