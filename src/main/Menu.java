package main;
import java.sql.*;
import java.util.Scanner;

import DAO.databaseHandler;

public class Menu {
	databaseHandler db_handler = new databaseHandler();
	Scanner sc=new Scanner(System.in);
	
	public Menu() {
		
	}
	
	public void addItem() {
		System.out.print("Item name: ");
		String item_name = sc.nextLine();
		System.out.print("Item category: ");
		String item_category = sc.nextLine();
		System.out.print("Item price: ");
		int item_price = sc.nextInt();
		try {
			db_handler.prep_stmt = db_handler.conn.prepareStatement("insert into items_tbl (name, category, price) values (?,?,?)");
			db_handler.prep_stmt.setString(1, item_name);
			db_handler.prep_stmt.setString(2, item_category.toString());
			db_handler.prep_stmt.setInt(3, item_price);
			
			int affected_tuples = db_handler.prep_stmt.executeUpdate();
			
			db_handler.prep_stmt.close();
		}catch(SQLException se){
		   se.printStackTrace();
		}
	}
	
	public void removeItem() {
		System.out.print("Item name: ");
		String item_name = sc.nextLine();
		try {
			db_handler.call_stmt = db_handler.conn.prepareCall("{call deleteItem(\""+item_name+"\")}");
			//db_handler.prep_stmt = db_handler.conn.prepareStatement("delete from items_tbl where name = ?");
			//db_handler.prep_stmt.setString(1,item_name);
			int affected_tuples = db_handler.call_stmt.executeUpdate();
			
			db_handler.call_stmt.close();
		}catch(SQLException se){
		   se.printStackTrace();
		}
	}
	
	public void showMenu() {
		System.out.println("============================== MENU ==============================");
		System.out.println("Item ID         Item Name              Category              Price");
		System.out.println("------------------------------------------------------------------");
		try {
			db_handler.prep_stmt = db_handler.conn.prepareStatement("select * from items_tbl");
			ResultSet items = db_handler.prep_stmt.executeQuery();
			while(items.next()) {
				System.out.printf("   %-12d%-24s%-22s%-10d",items.getInt("item_id"),items.getString("name"),items.getString("category"), items.getInt("price"));
				System.out.println();
			}
			items.close();
			db_handler.prep_stmt.close();
		}catch(SQLException se){
		   se.printStackTrace();
		}
		System.out.println("------------------------------------------------------------------");
	}
}
