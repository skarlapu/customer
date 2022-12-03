package org.sks.customer.service;

import java.util.Optional;

import org.sks.customer.exception.NoRecordFoundException;
import org.sks.customer.model.Customer;
import org.sks.customer.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CustomerService {
	@Autowired
	CustomerRepository repository;

	public org.sks.customer.bean.Customer findCustomer(Integer customerId) {
		Optional<Customer> customer = repository.findById(customerId);
		if (customer.isPresent()) {
			return modelToBean(customer.get(), new org.sks.customer.bean.Customer());
		} else {
			throw new NoRecordFoundException("No Data found for the given Customer Id :" + customerId);
		}
	}

	public Customer addCustomer(org.sks.customer.bean.Customer customer) {
		return repository.save(beanToModel(customer, new Customer()));
	}

	public Customer updateCustomer(Customer customer) {
		Optional<Customer> record = repository.findById(customer.getCustomerId());
		if (record.isPresent()) {
			Customer cust = record.get();
			cust.setCustomerId(customer.getCustomerId());
			cust.setFirstName(customer.getFirstName());
			cust.setLastName(customer.getLastName());
			cust.setGender(customer.getGender());
			cust.setSsn(customer.getSsn());
			repository.save(cust);
		} else {
			throw new NoRecordFoundException("No Data Found for the given Customer to update");
		}

		return customer;
	}

	private org.sks.customer.bean.Customer modelToBean(Customer model, org.sks.customer.bean.Customer bean) {
		bean.setCustomerId(model.getCustomerId());
		bean.setFirstName(model.getFirstName());
		bean.setLastName(model.getLastName());
		bean.setGender(model.getGender());
		bean.setSsn(model.getSsn());
		return bean;
	}

	private Customer beanToModel(org.sks.customer.bean.Customer bean, Customer model) {
		model.setCustomerId(bean.getCustomerId());
		model.setFirstName(bean.getFirstName());
		model.setLastName(bean.getLastName());
		model.setGender(bean.getGender());
		model.setSsn(bean.getSsn());
		return model;
	}

}
