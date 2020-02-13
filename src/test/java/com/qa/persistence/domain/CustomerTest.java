package com.qa.persistence.domain;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

public class CustomerTest {
	
	private Customer customer;
	private Customer other;
	
	@Before
	public void setUp() {
		customer = new Customer(1, "Chris Perrins");
		other = new Customer(1, "Chris Perrins");
	}
	
//	@Test
//	public void settersTest() {
//		assertNotNull(customer.getId());
//		assertNotNull(customer.getname());
//		
//		customer.setId(0);
//		assertNull(customer.getId());
//		customer.name(null);
//		assertNull(customer.getname());
//		
//	}
	
	@Test
	public void equalsWithNull() {
		assertFalse(customer.equals(null));
	}
	
	@Test
	public void equalsWithDifferentObject() {
		assertFalse(customer.equals(new Object()));
	}
	
	@Test
	public void createCustomerWithId() {
		assertEquals(1L, customer.getId(), 0);
		assertEquals("Chris Perrins", customer.getname());
	}
	
	@Test
	public void checkEquality() {
		assertTrue(customer.equals(customer));
	}
	
	@Test
	public void checkEqualityBetweenDifferentObjects() {
		assertTrue(customer.equals(other));
	}
	
	@Test
	public void customerNameNullButOtherNameNotNull() {
		customer.name(null);
		assertFalse(customer.equals(other));
	}
	
	@Test
	public void customerNamesNotEqual() {
		other.name("Rhys Thompson");
		assertFalse(customer.equals(other));
	}
	
	@Test
	public void checkEqualityBetweenDifferentObjectsNullName() {
		customer.name(null);
		other.name(null);
		assertTrue(customer.equals(other));
	}
	
	@Test
	public void nullId() {
		customer.setId(0);
		assertFalse(customer.equals(other));
	}
	
	@Test
	public void nullIdOnBoth() {
		customer.setId(0);
		other.setId(0);
		assertTrue(customer.equals(other));
	}
	
	@Test
	public void otherIdDifferent() {
		other.setId(2);
		assertFalse(customer.equals(other));
	}
	
//	@Test
//	public void constructorWithoutId() {
//		Customer customer = new Customer("Chris Perrins");
//		assertNull(customer.getId());
//		assertNotNull(customer.getname());
//	}
	
	@Test
	public void hashCodeTest() {
		assertEquals(customer.hashCode(), other.hashCode());
	}
	@Test
	public void hashCodeTestWithNull() {
		Customer customer = new Customer(null);
		Customer other = new Customer(null);
		assertEquals(customer.hashCode(), other.hashCode());
	}
	
	@Test
	public void toStringTest() {
		String toString = "id:1 | Name:Chris Perrins";
		assertEquals(toString, customer.toString());
	}
}