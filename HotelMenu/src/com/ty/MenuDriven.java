package com.ty;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class MenuDriven {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/hotelmenuchart", "root","root");
			boolean repeat = true;
			do {
				System.out.println("welcome to hotel shri siddharoodha hotel");
				System.out.println("1.AddMenu\n2.DeleteMenu\n3.updateMenu\n4.getMenu\n5.getItem\n6.exit");
				System.out.println("Enter the choice between 1-6");
				System.out.println("enter your choice");
				int choice = sc.nextInt();
				switch (choice) {
				case 1: {
					//add the items into the menu 
					System.out.println("enter the item id");
					int id = sc.nextInt();
					System.out.println("enter the item name");
					String name = sc.next();
					System.out.println("enter the quantity in no's");
					int quantity = sc.nextInt();
					System.out.println("enter the cost");
					int cost = sc.nextInt();
					PreparedStatement preparedStatement = connection.prepareStatement("insert into hotelmenu values(?,?,?,?)");
					preparedStatement.setInt(1, id);
					preparedStatement.setString(2, name);
					preparedStatement.setInt(3, quantity);
					preparedStatement.setInt(4, cost);

					preparedStatement.execute();
					System.out.println("menu saved");

				}
				break;

				case 2 :{
					//delete the menu based on the item's
					System.out.println("enter the item to delete");
					String item_delete = sc.next();
					PreparedStatement preparedStatement = connection.prepareStatement("delete from hotelmenu where name=?");
					preparedStatement.setString(1,item_delete);
					preparedStatement.execute();
					System.out.println("data deleted");

				}
				break;

				case 3:{
					System.out.println("update by id ,then enter : 11");
					System.out.println("update by name,then enter : 22");
					System.out.println("update by qunatity,then enter : 33");
					System.out.println("update by cost,then enter : 44");
					int update = sc.nextInt();
					switch(update) {
					case 11:{
						//update the menu based on the item id
						System.out.println("enter already existing item name");
						String item_existing = sc.next();
						System.out.println("enter the item Id to update");
						int item_update = sc.nextInt();
						PreparedStatement preparedStatement = connection.prepareStatement("update hotelmenu set id=? where name=?" );
						preparedStatement.setInt(1,item_update);
						preparedStatement.setString(2,item_existing);
						preparedStatement.execute();
						System.out.println("data updated");	
					}
					break;
					case 22:{
							//update the menu based on the item name
						System.out.println("enter already existing item name");
						String item_existing = sc.next();
						System.out.println("enter the item name to update");
						String item_update = sc.next();
						PreparedStatement preparedStatement = connection.prepareStatement("update hotelmenu set name=? where name=?" );
						preparedStatement.setString(1,item_update);
						preparedStatement.setString(2,item_existing);
						preparedStatement.execute();
						System.out.println("data updated");	
					}
					break;
					case 33:{
						//update the menu based on the quantity
						System.out.println("enter already existing item_name");
						String item_existing = sc.next();
						System.out.println("enter the item quantity in no's to update");
						int item_update = sc.nextInt();
						PreparedStatement preparedStatement = connection.prepareStatement("update hotelmenu set quantity=? where name=?" );
						preparedStatement.setInt(1,item_update);
						preparedStatement.setString(2,item_existing);
						preparedStatement.execute();
						System.out.println("data updated");
					}
					break;
					case 44:{
						//update the menu based on the cost
						System.out.println("enter already existing item_name");
						String item_existing = sc.next();
						System.out.println("enter the item_cost to update");
						int item_update = sc.nextInt();
						PreparedStatement preparedStatement = connection.prepareStatement("update hotelmenu set cost=? where name=?" );
						preparedStatement.setInt(1,item_update);
						preparedStatement.setString(2,item_existing);
						preparedStatement.execute();
						System.out.println("data updated");
					}
					break;
					default :
						System.out.println("invalid choice");
						break;
					}

				}
				break;

				case 4:{
//					get all items,cost and other detalis from the menu
					PreparedStatement preparedStatement = connection.prepareStatement("select * from hotelmenu"); 
					ResultSet resultSet = preparedStatement.executeQuery();
					while(resultSet.next()) {
						System.out.println("Item Id: "+resultSet.getInt(1));
						System.out.println("Item name: "+resultSet.getString(2));
						System.out.println("Item quantity: "+resultSet.getInt(3));
						System.out.println("Item cost: "+resultSet.getInt(4));

						System.out.println("****************************");
					}
				}
				break;

				case 5:{
//					get only items from the menu
					System.out.println("enter the item_name");
					String item = sc.next();
					PreparedStatement preparedStatement = connection.prepareStatement("select * from hotelmenu where name=? "); 
					preparedStatement.setString(1, item);
					ResultSet resultSet = preparedStatement.executeQuery();
					while(resultSet.next()) {
						System.out.println("Item Id: "+resultSet.getInt(1));
						System.out.println("Item name: "+resultSet.getString(2));
						System.out.println("Item quantity: "+resultSet.getInt(3));
						System.out.println("Item cost: "+resultSet.getInt(4));

						System.out.println("****************************");
					}
				

				}
				break;

				case 6:{
					repeat=false;
					System.out.println("thank you");
				}
				break;

				default :
					System.out.println("invalid choice");	
					break;
				}

			} while (repeat);
			connection.close();

		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		
		sc.close();

	}
}
