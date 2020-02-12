package com.qa.persistence.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import com.qa.controller.OrderController;
import com.qa.persistence.domain.Item;
import com.qa.persistence.domain.Order;
import com.qa.utils.Config;
import com.qa.utils.Utils;

public class OrderDaoMysql implements Dao<Order> {
	
	public static final Logger LOGGER = Logger.getLogger(OrderController.class);
	private Statement statement = null;
	private ResultSet resultSet = null;
	
	public OrderDaoMysql(String username, String password) {
		Config.username = username;
		Config.password = password;
	}
	Order orderFromResultSet(ResultSet resultSet) throws SQLException {
		int num = resultSet.getInt("Order_Num");
		double total = resultSet.getDouble("Order_Total");
		int quantity = resultSet.getInt("Order_Quantity");
		int cusid = resultSet.getInt("Customer_ID");
		int cardid = resultSet.getInt("Card_ID");
		return new Order(num, total, quantity, cusid, cardid);
	}
	
	public List<Order> readAll() {
		ArrayList<Order> orders = new ArrayList<Order>();
		try (Connection connection = DriverManager.getConnection(Config.url, Config.username, Config.password)) {
			statement = connection.createStatement();
			resultSet = statement.executeQuery("select * from Orders");
			while (resultSet.next()) {
				int num = resultSet.getInt("Order_Num");
				double total = resultSet.getDouble("Order_Total");
				int quantity = resultSet.getInt("Order_Quantity");
				int cusid = resultSet.getInt("Customer_ID");
				int cardid = resultSet.getInt("Card_ID");
				Order order = new Order(num, total, quantity, cusid, cardid);
				orders.add(order);
			}
		} catch (Exception e) {
			LOGGER.debug(e.getStackTrace());
			LOGGER.error(e.getMessage());
		} finally {
			Utils.close(statement, resultSet);

		}
		return orders;
	}
	

	public Order create(Order t) {
		return null;
	}

	public Order update(Order t) {
		return null;
	}

	public void delete(int num) {
		try (Connection connection = DriverManager.getConnection(Config.url, Config.username, Config.password)) {
			statement = connection.createStatement();
			statement.executeUpdate("DELETE FROM Orders WHERE Order_Num = '" + num + " ';");

		} catch (Exception e) {

			LOGGER.debug(e.getStackTrace());
			LOGGER.error(e.getMessage());
		} finally {
			Utils.close(statement, resultSet);

		}
	
	}
}
