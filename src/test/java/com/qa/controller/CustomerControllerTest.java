package com.qa.controller;

import static org.junit.Assert.assertEquals;
import java.util.ArrayList;
import java.util.List;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.Spy;
import org.mockito.junit.MockitoJUnitRunner;
import com.qa.persistence.domain.Customer;
import com.qa.services.CustomerServices;

@RunWith(MockitoJUnitRunner.class)
public class CustomerControllerTest {
	
	/**
	 *  The thing I want to fake functionlity for
	 */
	@Mock
	private CustomerServices customerServices;
	
	/**
	 * Spy is used because i want to mock some methods inside the item I'm testing
	 * InjectMocks uses dependency injection to insert the mock into the customer controller
	 */
	@Spy
	@InjectMocks
	private CustomerController customerController;
	
	@Test
	public void readAllTest() {
		CustomerController customerController = new CustomerController(customerServices);
		List<Customer> customers = new ArrayList<>();
		customers.add(new Customer("Chris Perrins"));
		customers.add(new Customer("Rhys Thompson"));
		customers.add(new Customer("George Name"));
		Mockito.when(customerServices.readAll()).thenReturn(customers);
		customerController.readAll();
	}

	@Test
	public void createTest() {
		String name = "Chris perrins";
		Mockito.doReturn(name).when(customerController).getInput();
		Customer customer = new Customer(name);
		Customer savedCustomer = new Customer(1, "Chris Perrins");
		Mockito.when(customerServices.create(customer)).thenReturn(savedCustomer);
		assertEquals(savedCustomer, customerController.create());
	}

	/**
	 * 
	 */
	@Test
	public void updateTest() {
		String id = "1";
		String name = "James Rea";
		Mockito.doReturn(id, name).when(customerController).getInput();
		//Mockito.doReturn(id, firstName, surname).when(customerController).getInput();
		Customer customer = new Customer(1, name);
		Mockito.when(customerServices.update(customer)).thenReturn(customer);
		//Mockito.when(customerServices.update(customer)).thenReturn(customer);
		assertEquals(customer, customerController.update());
	}
	

	/**
	 * Delete doesn't return anything, so we can just verify that it calls the delete method
	 */
	@Test
	public void deleteTest() {
		String id = "1";
		Mockito.doReturn(id).when(customerController).getInput();
		customerController.delete();
	}
	
}
