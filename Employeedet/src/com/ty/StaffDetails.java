package com.ty;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class StaffDetails {

	public static void main(String[] args) {
//		taking values form user input 
		Scanner sc = new Scanner(System.in);
		System.out.println("enter the staff id");
		int id = sc.nextInt();
		System.out.println("enter the staff name");
		String name = sc.next();
		System.out.println("enter the staff age");
		int age = sc.nextInt();

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/employeedet", "root", "root");
			PreparedStatement preparedStatement = connection.prepareStatement("insert into staff values(?,?,?)");
			preparedStatement.setInt(1,id);
			preparedStatement.setString(2,name);
			preparedStatement.setInt(3,age);

			preparedStatement.execute();
			connection.close();

			System.out.println("data saved");
			sc.close();


		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
