package com.qa.controller;

import java.util.List;

import org.apache.log4j.Logger;

import com.qa.persistence.domain.Customer;
import com.qa.services.CrudServices;
import com.qa.utils.Utils;

/**
 * Takes in customer details for CRUD functionality
 *
 */
public class CustomerController implements CrudController<Customer> {

	public static final Logger LOGGER = Logger.getLogger(CustomerController.class);

	private CrudServices<Customer> customerService;

	public CustomerController(CrudServices<Customer> customerService) {
		this.customerService = customerService;
	}

	String getInput() {
		return Utils.getInput(); 
	}
 
	/**
	 * Reads all customers to the logger
	 */
	public List<Customer> readAll() {
		for (Customer customer : customerService.readAll()) {
			LOGGER.info(customer.toString());
		}
		return null;
	}

	/**
	 * Creates a customer by taking in user input
	 */
	public Customer create() {
		LOGGER.info("Please enter a Name");
		String name = getInput();
		LOGGER.info("Customer created");
		return customerService.create(new Customer(name));
	}

	/**
	 * Updates an existing customer by taking in user input
	 */
	public Customer update() {
		LOGGER.info("Please enter the id of the customer you would like to update");
		String stringId = getInput();
		int id = Integer.parseInt(stringId);
		LOGGER.info("Please enter a name");
		String name = getInput();
		Customer customer = customerService.update(new Customer(id, name));
		LOGGER.info("Customer Updated");
		return customer;

	}

	/**
	 * Deletes an existing customer by the id of the customer
	 */
	public void delete() {
		LOGGER.info("Please enter the Id of the customer you want to delete");
		String stringId = getInput();
		int id = Integer.parseInt(stringId);
		customerService.delete(id);
		LOGGER.info("Customer deleted");

	}

}
