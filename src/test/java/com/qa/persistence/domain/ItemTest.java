package com.qa.persistence.domain;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

public class ItemTest {

	private Item item;
	private Item other;

	@Before
	public void setUp() {
		item = new Item(1, "apple", 20D);
		other = new Item(1, "apple", 20D);
	}

//	@Test
//	public void settersTest() {
//		assertNotNull(item.getId());
//		assertNotNull(item.getCard());
//		assertNotNull(item.getCardCost());
//
//		item.setId(0);
//		assertNull(item.getId());
//		item.setCard(null);
//		assertNull(item.getCard());
//		item.setCardCost(0);
//		assertNull(item.getCardCost());
//
//	}

	@Test
	public void equalsWithNull() {
		assertFalse(item.equals(null));
	}

	@Test
	public void equalsWithDifferentObject() {
		assertFalse(item.equals(new Object()));
	}

	@Test
	public void createItemWithId() {
		assertEquals(1L, item.getId(), 0);
		assertEquals("apple", item.getCard());
		assertEquals(20D, item.getCardCost(), 20D);
	}

	@Test
	public void checkEquality() {
		assertTrue(item.equals(item));
	}

//	@Test
//	public void checkEqualityBetweenDifferentObjects() {
//		assertTrue(item.equals(other));
//	}

	@Test
	public void itemNameNullButOtherNameNotNull() {
		item.setCard(null);
		assertFalse(item.equals(other));
	}

	@Test
	public void itemNamesNotEqual() {
		other.setCard("banana");
		assertFalse(item.equals(other));
	}

//	@Test
//	public void checkEqualityBetweenDifferentObjectsNullName() {
//		item.setCard(null);
//		other.setCard(null);
//		assertTrue(item.equals(other));
//	}

	@Test
	public void nullItemId() {
		item.setId(0);
		assertFalse(item.equals(other));
	}

//	@Test
//	public void nullItemIdOnBoth() {
//		item.setId(0);
//		other.setId(0);
//		assertTrue(item.equals(other));
//	}

	@Test
	public void otherItemIdDifferent() {
		other.setId(2);
		assertFalse(item.equals(other));
	}

	@Test
	public void otherValueDifferent() {
		other.setCardCost(30D);
		assertFalse(item.equals(other));
	}


//	@Test
//	public void constructorWithoutItemId() {
//		Item item = new Item("apple", 12);
//		assertNull(item.getId());
//		assertNotNull(item.getCard());
//		assertNotNull(item.getCardCost());
//	}

//	@Test
//	public void hashCodeTest() {
//		assertEquals(item.hashCode(), other.hashCode());
//	}

}

