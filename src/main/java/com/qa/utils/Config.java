package com.qa.utils;

public class Config {
	public static String username;
	public static String password;
	public final static String url = "jdbc:mysql://localhost:3306/ims";

	public String getUsername() {
		return username;
	}

	public String getPassword() {
		return password;
	}

}
