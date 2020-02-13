package com.qa.persistence.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import org.apache.log4j.Logger;

import com.qa.controller.ItemController;

import com.qa.persistence.domain.Item;
import com.qa.utils.Config;
import com.qa.utils.Utils;

public class ItemDaoMysql implements Dao<Item> { 

	public static final Logger LOGGER = Logger.getLogger(ItemController.class);
	private Statement statement = null;
	private ResultSet resultSet = null;
	
	public ItemDaoMysql(String username, String password) {
		Config.username = username;
		Config.password = password;
	}

	Item itemFromResultSet(ResultSet resultSet) throws SQLException {
		int id = resultSet.getInt("Card_ID");
		String card = resultSet.getString("Card_Name");
		double cardCost = resultSet.getDouble("Card_Cost");
		return new Item(id, card, cardCost);
	}

	/**
	 * Reads all items from the database
	 * 
	 * @return A list of customers
	 */
	public List<Item> readAll() {

		ArrayList<Item> items = new ArrayList<Item>();
		try (Connection connection = DriverManager.getConnection(Config.url, Config.username, Config.password)) {
			statement = connection.createStatement();
			resultSet = statement.executeQuery("select * from Cards");
			while (resultSet.next()) {
				int id = resultSet.getInt("Card_ID");
				String name = resultSet.getString("Card_Name");
				double cardCost = resultSet.getDouble("Card_Cost");
				Item item = new Item(id, name, cardCost);
				items.add(item);
			}
		} catch (Exception e) {
			LOGGER.debug(e.getStackTrace());
			LOGGER.error(e.getMessage());
		} finally {
			Utils.close(statement, resultSet);

		}
		return items;
	}

	public Item readLatest() {
		try (Connection connection = DriverManager.getConnection(Config.url, Config.username, Config.password)) {
				statement = connection.createStatement();
				resultSet = statement.executeQuery("SELECT FROM Cards ORDER BY id DESC LIMIT 1");
			resultSet.next();
			return itemFromResultSet(resultSet);
		} catch (Exception e) {
			LOGGER.debug(e.getStackTrace());
			LOGGER.error(e.getMessage());
		} finally {
			Utils.close(statement, resultSet);
		}
		return null;
	}

	/**
	 * Creates n item in the database
	 * 
	 * @param item - takes in an item object.
	 */
	public Item create(Item item) {
		try (Connection connection = DriverManager.getConnection(Config.url, Config.username, Config.password)) {
			statement = connection.createStatement();
			statement.executeUpdate("insert into Cards(Card_ID,Card_Name,Card_Cost) values ('" + item.getId() + "','"
					+ item.getCard() + "','" + item.getCardCost() + "')");

		} catch (Exception e) {
			LOGGER.debug(e.getStackTrace());
			LOGGER.error(e.getMessage());
		} finally {
			Utils.close(statement, resultSet); 

		}
		return item;
	}
	/**
	 * Updates an item in the database
	 * 
	 * @param item - takes in an item object, the id field will be used to
	 *                 update that item in the database
	 * @return
	 */
	public Item update(Item item) {
		try (Connection connection = DriverManager.getConnection(Config.url, Config.username, Config.password)) {
			statement = connection.createStatement();
			statement.executeUpdate(
					"UPDATE Cards SET Card_Cost = '" + item.getCardCost() + "' where Card_ID = " + item.getId());
		} catch (Exception e) {
			LOGGER.debug(e.getStackTrace());
			LOGGER.error(e.getMessage());
		} finally {
			Utils.close(statement, resultSet);
		}
		return item;

	}
	/**
	 * Deletes an item from the database
	 * 
	 * @param id - id of the item
	 */
	public void delete(int id) {
		try (Connection connection = DriverManager.getConnection(Config.url, Config.username, Config.password)) {
			statement = connection.createStatement();
			statement.executeUpdate("DELETE FROM Cards WHERE Card_ID = '" + id + " ';");

		} catch (Exception e) {

			LOGGER.debug(e.getStackTrace());
			LOGGER.error(e.getMessage());
		} finally {
			Utils.close(statement, resultSet);

		}

	}
}
