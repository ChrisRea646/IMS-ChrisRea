package com.qa.services;

import java.util.List;

import com.qa.persistence.dao.Dao;
import com.qa.persistence.domain.Item;

public class ItemServices implements CrudServices<Item> {
	
	Dao<Item> itemDao;
	
	public ItemServices(Dao<Item> itemDao) {
		this.itemDao = itemDao;
	}

	@Override
	public List<Item> readAll() {
		// TODO Auto-generated method stub
		return itemDao.readAll();
	}

	@Override
	public Item create(Item item) {
		// TODO Auto-generated method stub
		return itemDao.create(item);
	}

	@Override
	public Item update(Item item) {
		// TODO Auto-generated method stub
		return itemDao.update(item);
	}

	
	public void delete(int id) {
		itemDao.delete(id);
	}
	
	
}
