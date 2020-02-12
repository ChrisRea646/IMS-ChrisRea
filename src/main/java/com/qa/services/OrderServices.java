package com.qa.services;

import java.util.List;
import com.qa.persistence.dao.Dao;
import com.qa.persistence.domain.Order;

public class OrderServices implements CrudServices<Order> {
	
	Dao<Order> orderDao;
	
	public OrderServices(Dao<Order> orderDao) {
		this.orderDao = orderDao;
	}

	public List<Order> readAll() {
		return orderDao.readAll();
	}

	public Order create(Order order) {
		return orderDao.create(order);
	}

	public Order update(Order order) {
		return orderDao.update(order);
	}

	public void delete(int id) {
		orderDao.delete(id);
		
	}

}
