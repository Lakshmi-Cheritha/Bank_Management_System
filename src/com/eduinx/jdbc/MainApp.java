package com.eduinx.jdbc;

import java.sql.SQLException;
import java.util.Scanner;

public class MainApp {
	public static void main(String[] args) throws ClassNotFoundException, SQLException, InterruptedException {
		try (Scanner sc = new Scanner(System.in)) {
	
			System.out.println("-----------------------------");
			System.out.println("Application Started");
			System.out.println("-----------------------------");
			BankRead.displayRecords();

			System.out.println("-----------------------------");
			System.out.println("-----Bank Management System-----");
			System.out.println("-----------------------------");
			System.out.println(" 1. Insert \n 2. Update \n 3. Delete  \n 4. Exit");
			System.out.println("-----------------------------");
			Thread.sleep(2000);
			System.out.print("Enter your choice: ");

			int choice = sc.nextInt();
			switch (choice) {
				case 1:
					BankInsert.insertRecords();
					BankRead.displayRecords();
					break;
				case 2:
					BankUpdate.updateRecords();
					BankRead.displayRecords();
					break;
				case 3:
					BankDelete.deleteRecords();
					BankRead.displayRecords();
					break;
				case 4:
					System.out.println("Application ended");
					System.exit(0);
					break;
				default:
					System.out.println("Invalid option. Please choose a valid menu option.");
					
			}
		}
	}
}

