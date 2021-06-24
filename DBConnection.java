package com.cmr.prj.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
public class DBConnection {
	private static final String URL = "jdbc:oracle:thin:@localhost:1521";
	private static final String USERNAME = "system";
	private static final String PASSWORD = "system";
	
	private static Connection con = null;
	
	static
	{
		// Step 1 
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			
			// Step 2:
			con = DriverManager.getConnection(URL, USERNAME, PASSWORD);
			System.out.println("Establised connection successfully..........");
		}
		
		catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	public static Connection getConnection() {
		return con;
	}
		
}
