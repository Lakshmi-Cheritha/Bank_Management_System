package com.eduinx.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class BankUpdate 
{
	public static void updateRecords() throws ClassNotFoundException, SQLException 
	{

		//Loading DriverClass
		Class.forName("com.mysql.cj.jdbc.Driver");

		//connection information
		final String url = "jdbc:mysql://localhost/eduinx";
		final String username="root";
		final String password="Cherry";

		//Connection Establishment
		Connection connection = DriverManager.getConnection(url, username, password);

		//executing a SQL Query
		String sql = "update Bank set balance=balance+? where acc_no=?";

		try (Scanner sc = new Scanner(System.in)) {
			System.out.println("Enter the amount that to add existing balance ");
			int amount= sc.nextInt();
			
			System.out.println("Enter the account number to update balance ");
			int a_num = sc.nextInt();
			
			//Creating the Statement
			PreparedStatement st = connection.prepareStatement(sql);
			st.setInt(1, amount);
			st.setInt(2,a_num);
			
			int ex = st.executeUpdate();

			if(ex>0) {
				System.out.println("Updated balance Succesfully"); 
			}else {
				System.out.println("Balance update faild "); 
			}
		}
	}
}