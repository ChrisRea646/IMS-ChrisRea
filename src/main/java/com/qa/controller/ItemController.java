package com.qa.controller;

import java.util.List;

import org.apache.log4j.Logger;

import com.qa.persistence.domain.Customer;
import com.qa.persistence.domain.Item;
import com.qa.services.CrudServices;
import com.qa.utils.Utils;

public class ItemController implements CrudController<Item> {
	
	public static final Logger LOGGER = Logger.getLogger(ItemController.class);
	
	private CrudServices<Item> itemService;

	public ItemController(CrudServices<Item> itemService) {
		this.itemService = itemService;
		
	}
	public List<Item> readAll() {
		for (Item item : itemService.readAll()) {
			LOGGER.info(item.toString());
		}	
		return null;
	}

	public Item create() {
		LOGGER.info("Please enter a card ID:");
		String stringID = Utils.getInput();
		int id = Integer.parseInt(stringID);
		LOGGER.info("Please enter a card name:");
		String name = Utils.getInput();
		LOGGER.info("Please enter a card cost:");
		String stringCost = Utils.getInput();
		double cost = Double.parseDouble(stringCost);
		itemService.create(new Item(id,name,cost));
		LOGGER.info("Item created");
		return null;
	}

	public Item update() {
		LOGGER.info("Please enter the id of the card you would like to update");
		String stringId = Utils.getInput();
		int id = Integer.parseInt(stringId);
		LOGGER.info("Please enter the card name:");
		String name = Utils.getInput();
		LOGGER.info("Please enter a cost");
		String stringCost = Utils.getInput();
		double cost = Double.parseDouble(stringCost);
		Item item = itemService.update(new Item(id, name, cost));
		LOGGER.info("Card Updated");
		return item;

	}


	public void delete() {
		LOGGER.info("Please enter the Id of the card you want to delete");
		String stringId = Utils.getInput();
		int id = Integer.parseInt(stringId);
		itemService.delete(id);
		LOGGER.info("Card deleted");

	}

}