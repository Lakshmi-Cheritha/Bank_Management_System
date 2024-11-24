package com.eduinx.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class BankDelete 
{
	public static void deleteRecords() throws ClassNotFoundException, SQLException
	{

		// Loading DriverClass
		Class.forName("com.mysql.cj.jdbc.Driver");

		// Connection information
		final String url = "jdbc:mysql://localhost/eduinx";
		final String username = "root";
		final String password = "Cherry";

		// Connection Establishment
		Connection connection = DriverManager.getConnection(url, username, password);

		// Executing SQL Delete Statement
		String sql = "delete from Bank where acc_no=?";
		
		try (Scanner sc = new Scanner(System.in)) {
			System.out.println("Enter account number to delete that account record: ");
			int a_num=sc.nextInt();
			
			PreparedStatement st = connection.prepareStatement(sql);
			st.setInt(1, a_num);
			
			int ex= st.executeUpdate();
			if(ex>=0) {
				System.out.println("Deleted account Successfully");
			}else {
				System.out.println("Failed at deleting acount record");
			}
		}
	}
}