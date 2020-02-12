package com.qa.controller;

import java.util.List;

import org.apache.log4j.Logger;

import com.qa.persistence.domain.Order;
import com.qa.services.CrudServices;
import com.qa.utils.Utils;


public class OrderController implements CrudController<Order> {
		public static final Logger LOGGER = Logger.getLogger(OrderController.class);
	private CrudServices<Order> orderService;

	public OrderController(CrudServices<Order> orderService) {
		this.orderService = orderService;
		
	}
	
	public List<Order> readAll() {
		for (Order order : orderService.readAll()) {
			LOGGER.info(order.toString());
		}	
		return null;
	}

	public Order create() {
		return null;
	}

	public Order update() {
		return null;
	}

	public void delete() {
		LOGGER.info("Please enter the Id of the order you want to delete");
		String stringNum = Utils.getInput();
		int num = Integer.parseInt(stringNum);
		orderService.delete(num);
		LOGGER.info("Order deleted");

	}


}
