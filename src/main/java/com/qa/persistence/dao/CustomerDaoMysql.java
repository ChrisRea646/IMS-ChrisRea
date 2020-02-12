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
import com.qa.utils.Utils;


public class CustomerDaoMysql implements Dao<Customer> {

	public static final Logger LOGGER = Logger.getLogger(CustomerController.class);
	private Statement statement = null;
	private ResultSet resultSet = null;


	
	public CustomerDaoMysql(String username, String password) {
		Config.username = username;
		Config.password = password;
	}
	

	
	Customer customerFromResultSet(ResultSet resultSet) throws SQLException {
		int id = resultSet.getInt("Customer_ID");
		String name = resultSet.getString("Customer_Name");
		return new Customer(id, name);
	}
	
	public List<Customer> readAll() {
		
		ArrayList<Customer> customers = new ArrayList<Customer>();
		try (Connection connection = DriverManager.getConnection(Config.url, Config.username, Config.password)) {
			statement = connection.createStatement();
			resultSet = statement.executeQuery("select * from Customers");
			while (resultSet.next()) {
				int id = resultSet.getInt("Customer_ID");
				String name = resultSet.getString("Customer_Name");
				Customer customer = new Customer(id, name);
				customers.add(customer);
			}
		} catch (Exception e) {
			LOGGER.debug(e.getStackTrace());
			LOGGER.error(e.getMessage());
		}finally {
			Utils.close(statement, resultSet);
		}
		return customers;
		
	}
		public Customer readLatest() {
			try (Connection connection = DriverManager.getConnection(Config.url, Config.username, Config.password)) {
					statement = connection.createStatement();
					resultSet = statement.executeQuery("SELECT FROM Customers ORDER BY id DESC LIMIT 1");
				resultSet.next();
				return customerFromResultSet(resultSet);
			} catch (Exception e) {
				LOGGER.debug(e.getStackTrace());
				LOGGER.error(e.getMessage());
			}finally {
				Utils.close(statement, resultSet);
			}
			return null;
		}
	

	public Customer create(Customer customer) {
		try (Connection connection = DriverManager.getConnection(Config.url, Config.username, Config.password)) {
			statement = connection.createStatement();
			statement.executeUpdate("insert into Customers(Customer_Name) values('" + customer.getname() + "')");
			
		} catch (Exception e) {
			LOGGER.debug(e.getStackTrace());
			LOGGER.error(e.getMessage());
		}finally {
			Utils.close(statement, resultSet);

		}
		return customer;
	}

	public Customer update(Customer customer) {
		try (Connection connection = DriverManager.getConnection(Config.url, Config.username, Config.password)) {
			statement = connection.createStatement();
			statement.executeUpdate("UPDATE Customers SET Customer_Name = '" + customer.getname()
					+ "' where Customer_Id = " + customer.getId());
		} catch (Exception e) {
			LOGGER.debug(e.getStackTrace());
			LOGGER.error(e.getMessage());
		}finally {
			Utils.close(statement, resultSet);

		}
		return customer;

	}

	public void delete(int id) {
		try (Connection connection = DriverManager.getConnection(Config.url, Config.username, Config.password)) {
			statement = connection.createStatement();
			statement.executeUpdate("DELETE FROM Customers WHERE Customer_ID = '" + id + " ';");
			
		} catch (Exception e) {
			
			LOGGER.debug(e.getStackTrace());
			LOGGER.error(e.getMessage());
		}finally {
			Utils.close(statement, resultSet);

		}

	}


		
	

}
