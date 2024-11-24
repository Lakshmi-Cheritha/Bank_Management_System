package com.eduinx.jdbc;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class BankInsert 
{
	public static void insertRecords() throws ClassNotFoundException, SQLException 
	{
	
		//Loading the Driver
		Class.forName("com.mysql.cj.jdbc.Driver");

		//connection information
		final String url = "jdbc:mysql://localhost/eduinx";
		final String username="root";
		final String password="Cherry";

		//Connection Establishment
		Connection connection = DriverManager.getConnection(url, username, password);
		
		//executing a SQL Query
		String sql = "insert into Bank values(?,?,?)";
		
		try (Scanner sc = new Scanner(System.in)) {
			System.out.println("Enter account number");
			int a_num = sc.nextInt();
			
			sc.nextLine();
			
			System.out.println("Enter account bank name");
			String a_name = sc.nextLine();
			
			System.out.println("Enter account balance");
			int a_balance = sc.nextInt();
			
			sc.nextLine();
			
			//Creating the Statement
			PreparedStatement st = connection.prepareStatement(sql);
			st.setInt(1,a_num);
			st.setString(2,a_name);
			st.setInt(3, a_balance);
			
			int ex = st.executeUpdate();
			
			if(ex>0) {
				System.out.println("Bank details added Successfully"); 
			}else {
				System.out.println("Failed to add bank details");
			}
		}
	}
}

