/**
 * @author Pragati Shrivastava and Rachana Deolikar
 * @version 1.0
 */
package com.project.connections;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnection {

	public static Connection getConnection() throws Exception {
		String url = "jdbc:mysql://localhost:3306/OOAD_db";
		String user = "admin";
		String password = "admin123";
		Class.forName("com.mysql.jdbc.Driver");
		Connection con = null;
		con = DriverManager.getConnection(url, user, password);
		System.out.println("connection done!");
		return con;
	}
}
