package com.ty;

import java.util.Scanner;

public class Student {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		StudentInterface si = new StudentImplementation();
		boolean repeat = true;
		while(repeat) {
			System.out.println("1:addStudent\n2:deleteStudent\n3:updateStudent\n4:GetStudent\n5:GetAll\n6:GetByName\n7:exit");
			System.out.println("enter your choice 1-7");
			int choice = scanner.nextInt();
			switch(choice) {
			case 1:si.addStudent();
			break;
			case 2:si.deleteStudent();
			break;
			case 3:si.updateStudent();
			break;
			case 4:si.getStudentRecord();
			break;
			case 5:si.getAll();
			break;
			case 6:si.getByName();
			break;
			case 7:{
				repeat=false;
				System.out.println("thank you");
			}
			break;
			default: System.out.println("enter between 1-7 numbers only");
			}
		}
		scanner.close();
	}
}








