package com.ty;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class StudentImplementation implements StudentInterface{
	Scanner scanner = new Scanner(System.in);

	@Override
	public void addStudent() {
		System.out.println("enter the student id");
		int id = scanner.nextInt();
		System.out.println("enter the student name");
		String name = scanner.next();
		System.out.println("enter the student age");
		int age = scanner.nextInt();
		System.out.println("enter the student marks");
		int marks = scanner.nextInt();
		System.out.println("enter the student trainer");
		String trainer = scanner.next();

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/jspiderbasvngudiinfo", "root","root");
			PreparedStatement preparedStatement = connection.prepareStatement("insert into jspstudents values (?,?,?,?,?)");

			preparedStatement.setInt(1, id);
			preparedStatement.setString(2, name);
			preparedStatement.setInt(3, age);
			preparedStatement.setInt(4, marks);
			preparedStatement.setString(5,trainer);

			preparedStatement.execute();
			connection.close();

			System.out.println("data added successfully");

		} catch (ClassNotFoundException | SQLException e) {

			e.printStackTrace();
		}


	}

	@Override
	public void deleteStudent() {

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/jspiderbasvngudiinfo", "root","root");
			System.out.println("enter the student name to delete");
			String student_delete = scanner.next();
			PreparedStatement preparedStatement = connection.prepareStatement("delete from jspstudents where name=?");

			preparedStatement.setString(1, student_delete);
			preparedStatement.execute();
			connection.close();

			System.out.println("data deleted");

		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}

	}

	@Override
	public void updateStudent() {

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/jspiderbasvngudiinfo", "root","root");
			System.out.println("update by student id, then enter 11");
			System.out.println("update by student name, then enter 12");
			System.out.println("update by student age, then enter 13");
			System.out.println("update by student marks, then enter 14");
			System.out.println("update by student trainer, then enter 15");
			int student_update_type = scanner.nextInt();
			switch(student_update_type) {
			case 11:{
				//				update the student based on the id 
				System.out.println("enter already existing student name");
				String student_existing = scanner.next();
				System.out.println("enter the student Id to update");
				int student_update = scanner.nextInt();
				PreparedStatement preparedStatement = connection.prepareStatement("update jspstudents set id=? where name=?" );
				preparedStatement.setInt(1,student_update);
				preparedStatement.setString(2,student_existing);
				preparedStatement.execute();
				System.out.println("data updated");	
			}
			break;
			case 12:{
				//				update the student based on the name
				System.out.println("enter already existing student name");
				String student_existing = scanner.next();
				System.out.println("enter the student name to update");
				String student_update = scanner.next();
				PreparedStatement preparedStatement = connection.prepareStatement("update jspstudents set name=? where name=?" );
				preparedStatement.setString(1,student_update);
				preparedStatement.setString(2,student_existing);
				preparedStatement.execute();
				System.out.println("data updated");
			}
			break;
			case 13:{
				//				update the student based on the age 
				System.out.println("enter already existing student name");
				String student_existing = scanner.next();
				System.out.println("enter the student age to update");
				int student_update = scanner.nextInt();
				PreparedStatement preparedStatement = connection.prepareStatement("update jspstudents set age=? where name=?" );
				preparedStatement.setInt(1,student_update);
				preparedStatement.setString(2,student_existing);
				preparedStatement.execute();
				System.out.println("data updated");
			}
			break;
			case 14:{
				//				update the student based on the marks
				System.out.println("enter already existing student name");
				String student_existing = scanner.next();
				System.out.println("enter the student marks to update");
				int student_update = scanner.nextInt();
				PreparedStatement preparedStatement = connection.prepareStatement("update jspstudents set marks=? where name=?" );
				preparedStatement.setInt(1,student_update);
				preparedStatement.setString(2,student_existing);
				preparedStatement.execute();
				System.out.println("data updated");
			}
			break;
			case 15:{
				//			update the student based on the trainer	
				System.out.println("enter already existing student name");
				String student_existing = scanner.next();
				System.out.println("enter the trainer name to update");
				String trainer_update = scanner.next();
				PreparedStatement preparedStatement = connection.prepareStatement("update jspstudents set trainer=? where name=?" );
				preparedStatement.setString(1,trainer_update);
				preparedStatement.setString(2,student_existing);
				preparedStatement.execute();
				System.out.println("data updated");
			}
			break;
			
			}
			connection.close();
		} catch (ClassNotFoundException | SQLException e) {
			
			e.printStackTrace();
		}

	}

	@Override
	public void getStudentRecord() {

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/jspiderbasvngudiinfo", "root","root");
			System.out.println("enter the student name ");
			String name = scanner.next();
			PreparedStatement preparedStatement = connection.prepareStatement("select * from jspstudents info where name=? "); 
			preparedStatement.setString(1, name);
			ResultSet resultSet = preparedStatement.executeQuery();

			while(resultSet.next()) {
				System.out.println("****************************");
				System.out.println("student Id: "+resultSet.getInt(1));
				System.out.println("student name: "+resultSet.getString(2));
				System.out.println("student age: "+resultSet.getInt(3));
				System.out.println("student marks: "+resultSet.getInt(4));
				System.out.println("student trainer: "+resultSet.getString(5));

				System.out.println("****************************");
			}
		
			preparedStatement.execute();
			connection.close();
			
		} catch (ClassNotFoundException | SQLException e) {
			
			e.printStackTrace();
		}

	}

	@Override
	public void getAll() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/jspiderbasvngudiinfo", "root","root");
			PreparedStatement preparedStatement = connection.prepareStatement("select * from jspstudents"); 
			ResultSet resultSet = preparedStatement.executeQuery();
			
			while(resultSet.next()) {
				System.out.println("****************************");
				System.out.println("student Id: "+resultSet.getInt(1));
				System.out.println("student name: "+resultSet.getString(2));
				System.out.println("student age: "+resultSet.getInt(3));
				System.out.println("student marks: "+resultSet.getInt(4));
				System.out.println("student trainer: "+resultSet.getString(5));
				
				System.out.println("****************************");
			}
			
			preparedStatement.execute();
			connection.close();
			
		} catch (ClassNotFoundException | SQLException e) {
			
			e.printStackTrace();
		}

	}

	@Override
	public void getByName() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/jspiderbasvngudiinfo", "root","root");
			System.out.println("enter the student id to get student name");
			int id = scanner.nextInt();
			PreparedStatement preparedStatement = connection.prepareStatement("select id,name from jspstudents where id=?"); 
			preparedStatement.setInt(1, id);
			ResultSet resultSet = preparedStatement.executeQuery();
			
			while(resultSet.next()) {
				System.out.println("****************************");
				System.out.println("student Id: "+resultSet.getInt(1));
				System.out.println("student name: "+resultSet.getString(2));
				
				System.out.println("****************************");
			}
			
			preparedStatement.execute();
			connection.close();
			
		} catch (ClassNotFoundException | SQLException e) {
			
			e.printStackTrace();
		}

	}

}
