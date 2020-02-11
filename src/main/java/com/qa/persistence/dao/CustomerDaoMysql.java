package com.qa.persistence.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import com.qa.controller.CustomerController;
import com.qa.persistence.domain.Customer;
import com.qa.utils.Config;

public class CustomerDaoMysql implements Dao<Customer> {

	public static final Logger LOGGER = Logger.getLogger(CustomerController.class);
	
	Customer customerFromResultSet(ResultSet resultSet) throws SQLException {
		int id = resultSet.getInt("id");
		String name = resultSet.getString("name");
		return new Customer(id, name);
	}
	
	public List<Customer> readAll() {
		ArrayList<Customer> customers = new ArrayList<Customer>();
		try (Connection connection = DriverManager.getConnection("jdbc:mysql://35.189.105.102:3306/yugioh",
				Config.username, Config.password)) {
			Statement statement = connection.createStatement();
			ResultSet resultSet = statement.executeQuery("select * from Customers");
			while (resultSet.next()) {
				int id = resultSet.getInt("Customer_ID");
				String name = resultSet.getString("Customer_Name");
				Customer customer = new Customer(id, name);
				customers.add(customer);
			}
		} catch (Exception e) {
			LOGGER.debug(e.getStackTrace());
			LOGGER.error(e.getMessage());

		}
		return customers;
		
	}
		public Customer readLatest() {
			try (Connection connection = DriverManager.getConnection("jdbc:mysql://35.189.105.102:3306/yugioh",
					Config.username, Config.password);
					Statement statement = connection.createStatement();
					ResultSet resultSet = statement.executeQuery("SELECT FROM customers ORDER BY id DESC LIMIT 1");) {
				resultSet.next();
				return customerFromResultSet(resultSet);
			} catch (Exception e) {
				LOGGER.debug(e.getStackTrace());
				LOGGER.error(e.getMessage());
			}
			return null;
		}
	

	public Customer create(Customer customer) {
		try (Connection connection = DriverManager.getConnection("jdbc:mysql://35.189.105.102:3306/yugioh",
				Config.username, Config.password)) {
			Statement statement = connection.createStatement();
			statement.executeUpdate("insert into Customers(Customer_Name) values('" + customer.getname() + "')");
			
		} catch (Exception e) {
			LOGGER.debug(e.getStackTrace());
			LOGGER.error(e.getMessage());

		}
		return customer;
	}

	public Customer update(Customer customer) {
		try (Connection connection = DriverManager.getConnection("jdbc:mysql://35.189.105.102:3306/yugioh",
				Config.username, Config.password)) {
			Statement statement = connection.createStatement();
			statement.executeUpdate("UPDATE Customers SET Customer_Name = '" + customer.getname()
					+ "' where Customer_Id = " + customer.getId());
		} catch (Exception e) {
			LOGGER.debug(e.getStackTrace());
			LOGGER.error(e.getMessage());

		}
		return customer;

	}

	public void delete(String id) {
		try (Connection connection = DriverManager.getConnection("jdbc:mysql://35.189.105.102:3306/yugioh",
				Config.username, Config.password)) {
			Statement statement = connection.createStatement();
			statement.executeUpdate("DELETE FROM Customers WHERE Customer_ID = '" + id + " ';");
		} catch (Exception e) {
			LOGGER.debug(e.getStackTrace());
			LOGGER.error(e.getMessage());

		}

	}

}
