package com.qa.utils;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

import org.apache.log4j.Logger;

import com.qa.controller.CustomerController;

public class Utils {
	
	private Utils () {
		
	}
	public static final Logger LOGGER = Logger.getLogger(CustomerController.class);

	public static String getInput() {
		@SuppressWarnings("resource")
		Scanner scanner = new Scanner(System.in); 
		return scanner.nextLine();
	}

	public static void close(Statement statement, ResultSet resultSet) {
		try {
			if(statement != null)
				statement.close();
		} catch (SQLException se2) {
			LOGGER.info("",se2);
		}
		try {
			if (resultSet != null)
				resultSet.close();
		} catch (SQLException se) {
			LOGGER.info("",se);
		}
	}
}
