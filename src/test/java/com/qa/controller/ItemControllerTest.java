//package com.qa.controller;

//import static org.junit.Assert.assertEquals;

//import java.util.ArrayList;
//import java.util.List;
//
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.mockito.InjectMocks;
//import org.mockito.Mock;
//import org.mockito.Mockito;
//import org.mockito.Spy;
//import org.mockito.junit.MockitoJUnitRunner;
//
//import com.qa.persistence.domain.Item;
//import com.qa.services.ItemServices;

//@RunWith(MockitoJUnitRunner.class)
//public class ItemControllerTest {

	/**  
	 * The thing I want to fake functionlity for
	 */
//	@Mock
//	private ItemServices itemServices;

	/**
	 * Spy is used because I want to mock some methods inside the item I'm testing
	 * InjectMocks uses dependency injection to insert the mock into the customer
	 * controller
	 */
///	@Spy
//	@InjectMocks 
//	private ItemController itemController;

//	@Test
//	public void createTest() {
//		String name = "dandelion";
//		String stringValue = "40"; 
//		Mockito.doReturn(name, stringValue).when(itemController).getInput();
//		
//		double value = Double.parseDouble(stringValue);
//		Item item = new Item(0, name, value);
//		Item setUpItem4 = new Item(4, "dandelion", 40 );
//		Mockito.when(itemServices.create(item)).thenReturn(setUpItem4);
//		assertEquals(setUpItem4, itemController.create());
//	}

//	@Test
//	public void readAllTest() {
//
//		ItemController itemController = new ItemController(itemServices);
//		List<Item> items = new ArrayList<>();
//		items.add(new Item(1, "apple", 10));
//		Mockito.when(itemServices.readAll()).thenReturn(items);
//		assertEquals(items, itemController.readAll());
//	}

	/** 
	 *  
	 */
//	@Test
//	public void updateTest() { 
//		Item item = new Item(0, "apple", 10);
//		String stringId = "1";
//		String name = "apple";
//		String stringValue = "10";
//		String stringStock = "10";
//		Mockito.doReturn(stringId, name, stringValue, stringStock).when(itemController).getInput();
//
//		Item returnedItem = new Item(1, name, 10 );
//		
//		Mockito.when(itemServices.update( item)).thenReturn(returnedItem);
//		assertEquals(returnedItem, itemController.update());
//	}

	/**
	 * Delete doesn't return anything, so we can just verify that it calls the
	 * delete method
//	 */
//	@Test
//	public void deleteTest() {
//		String id = "3";
//		Mockito.doReturn(id).when(itemController).getInput();
//		itemController.delete();
//		Mockito.verify(itemServices, Mockito.times(1)).delete(3);
//	}
//
//}
