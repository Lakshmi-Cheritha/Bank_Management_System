package com.eduinx.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class BankRead {
	public static void displayRecords() throws ClassNotFoundException, SQLException {

		// Loading the JDBC Driver
		Class.forName("com.mysql.cj.jdbc.Driver");

		// Connection information
		final String url = "jdbc:mysql://localhost/eduinx";
		final String username = "root";
		final String password = "Cherry";

		// Establishing the Connection
		Connection connection = DriverManager.getConnection(url, username, password);

		// SQL query to read data from the Bank table
		String readQuery = "SELECT * FROM Bank";

		// Creating the Statement
		Statement stmt = connection.createStatement();

		// Executing the query and storing the result
		ResultSet rs = stmt.executeQuery(readQuery);

		// Iterating through the ResultSet to display the data
		while (rs.next()) {
			int accountNumber = rs.getInt("acc_no");
			String bankName = rs.getString("bank_name");
			double balance = rs.getDouble("balance");

			System.out.println("----------------------------");
			System.out.println("Account No: " + accountNumber);
			System.out.println("Bank Name: " + bankName);
			System.out.println("Balance: " + balance);
			
		}
	}
}