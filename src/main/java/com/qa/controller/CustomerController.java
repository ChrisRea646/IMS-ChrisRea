package com.qa.controller;

import java.util.List;

import org.apache.log4j.Logger;

import com.qa.persistence.domain.Customer;
import com.qa.services.CrudServices;
import com.qa.utils.Utils;

public class CustomerController implements CrudController<Customer> {

	public static final Logger LOGGER = Logger.getLogger(CustomerController.class);

	private CrudServices<Customer> customerService;

	public CustomerController(CrudServices<Customer> customerService) {
		this.customerService = customerService;
	}

	public List<Customer> readAll() {
		for (Customer customer : customerService.readAll()) {
			LOGGER.info(customer.toString());
		}
		return null;
	}

	public Customer create() {
		LOGGER.info("Please enter a Name");
		String name = Utils.getInput();
		customerService.create(new Customer(name));
		LOGGER.info("Customer created");
		return null;
	}

	public Customer update() {
		LOGGER.info("Please enter the id of the customer you would like to update");
		String stringId = Utils.getInput();
		int id = Integer.parseInt(stringId);
		LOGGER.info("Please enter a name");
		String name = Utils.getInput();
		Customer customer = customerService.update(new Customer(id, name));
		LOGGER.info("Customer Updated");
		return customer;

	}

	public void delete() {
		LOGGER.info("Please enter the Id of the customer you want to delete");
		String id = Utils.getInput();
		customerService.delete(id);
		LOGGER.info("Customer deleted");

	}


}
