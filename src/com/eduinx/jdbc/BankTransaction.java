//package com.eduinx.jdbc;
//
//import java.sql.Connection;
//import java.sql.DriverManager;
//import java.sql.SQLException;
//import java.sql.Statement;
//
//public class BankTransaction 
//{
//	public static void main(String[] args) throws ClassNotFoundException, SQLException 
//	{
//
//		//Loading DriverClass
//		Class.forName("com.mysql.cj.jdbc.Driver");
//
//		//connection information
//		final String url = "jdbc:mysql://localhost/eduinx";
//		final String username="root";
//		final String password="Cherry";
//
//		//executing a SQL Query
//		String str1 = "update Bank set balance=balance-100 where acc_no=1";
//		String str2 = "update Bank set balance=balance+100 where acc_no=2";
//		
//		Connection conn=null;
//		
//		try {
//		//Connection Establishment
//		conn = DriverManager.getConnection(url, username, password);
//		conn.setAutoCommit(false);
//
//		//Creating the Statement
//		Statement st = conn.createStatement();
//		st.addBatch(str1);
//		st.addBatch(str2);
//		st.executeBatch();
//		
//		//save the table
//		conn.commit();
//		System.out.println("Transaction Successfully Completed!!!"); 
//		
//		}
//		catch (Exception e) {
//			
//			System.out.println("Exception occured - rolling back the changes");
//		}
//		finally {
//            if (conn != null) {
//                conn.close();
//            }
//        }
//	}
//}