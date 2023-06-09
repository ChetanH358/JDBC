package com.ty;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Employee {

	public static void main(String[] args) {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
//			("jdbc:mysql://localhost:3306/studentdet", "root", "root")
			Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/employeedet", "root", "root");
			
			Statement statement = connection.createStatement();
//			eid/ename/sal/designation
			
			statement.execute("insert into employee values(1011,'shubam',30.75,'app tester')");
//			statement.execute("delete from employee where eid=1006");
			
			connection.close();
			System.out.println("Data saved");
//			System.out.println("Data deleted");
			
			
			
			
			
			
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		

	}

} 