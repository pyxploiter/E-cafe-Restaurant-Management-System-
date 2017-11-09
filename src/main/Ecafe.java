package main;
import java.sql.SQLException;
import java.util.*;

import DAO.databaseHandler;

public class Ecafe {
	private Date openTime = new Date();
	private Date closeTime = new Date();
	private Menu menu = new Menu();
	private Order order;
	public int orderTime[] = new int[2];
	
	public Ecafe() {
		openTime.setHours(11);
		closeTime.setHours(22);
	}
	
	public boolean validOrderTime(int hour, int mint) {
		if(openTime.getHours() > hour || closeTime.getHours() <= hour) {
			return false;
		}
		else {
			return true;
		}
	}
	
	public static void main(String[] args) {
		databaseHandler db_handler = new databaseHandler();
		int itemID = 1, quantity = 0;
		Date time = new Date();
		Scanner sc=new Scanner(System.in);
		Ecafe ecafe = new Ecafe();
		if (time.getHours()<ecafe.openTime.getHours() || time.getHours()>=ecafe.closeTime.getHours() ) {
			System.out.println("=========> Cafe 420 is closed now. <=========");
		}
		else {
			for(;;) {
				ecafe.order = new Order();
				System.out.println("\n\t     =========> Welcome to Cafe 420 <=========");
				System.out.println();
				ecafe.menu.showMenu();
				System.out.println("=> Type 0 to place the order:-");
				for(;;) {
					System.out.print("Type the Item ID: ");
					itemID = sc.nextInt();
					if (itemID == 0)
						break;
					System.out.print("=> Quantity of Item-"+itemID+": ");
					quantity = sc.nextInt();
					ecafe.order.addItem(itemID, quantity);
					
				}

				if (itemID == 0) {
					System.out.println("1. Home Delivery");
					System.out.println("2. Self Pick-up");
					int orderType = sc.nextInt();
					if (orderType == 1) {
						ecafe.order.setOrderType("delivery");
						System.out.print("Type the delivery address: ");
						ecafe.order.deliveryAddress = sc.next();
						ecafe.order.placeOrder();
						System.out.println("Bill = Rs."+ecafe.order.getBill());
						
						try {
							db_handler.prep_stmt = db_handler.conn.prepareStatement("insert into order_tbl (type, delivery_addr, bill) values (?,?,?);");
							db_handler.prep_stmt.setString(1, "delivery");
							db_handler.prep_stmt.setString(2, ecafe.order.deliveryAddress);
							db_handler.prep_stmt.setInt(3, ecafe.order.getBill());
							
							int affected_tuples = db_handler.prep_stmt.executeUpdate();
							db_handler.prep_stmt.close();
							
						}catch(SQLException se){
						   se.printStackTrace();
						}

					}
					else if (orderType == 2) {
						ecafe.order.setOrderType("pickup");
						System.out.println("Enter pick up time (24-h format => <hrs mints>):");
						ecafe.orderTime[0] = sc.nextInt();
						ecafe.orderTime[1] = sc.nextInt();
						if (ecafe.validOrderTime(ecafe.orderTime[0],ecafe.orderTime[1])) {
							ecafe.order.pickupTime.setHours(ecafe.orderTime[0]);
							ecafe.order.pickupTime.setMinutes(ecafe.orderTime[1]);
							ecafe.order.placeOrder();	
							System.out.println(ecafe.order.getBill());
							
							try {
								db_handler.prep_stmt = db_handler.conn.prepareStatement("insert into order_tbl (type, pickupTime, bill) values (?,?,?)");
								db_handler.prep_stmt.setString(1, "pickup");
								db_handler.prep_stmt.setDate(2, (java.sql.Date) ecafe.order.pickupTime);
								db_handler.prep_stmt.setInt(3, ecafe.order.getBill());
								
								int affected_tuples = db_handler.prep_stmt.executeUpdate();
								
								db_handler.prep_stmt.close();
							}catch(SQLException se){
							   se.printStackTrace();
							}
						}
						else {
							System.out.println("Your order cannot be placed at this time");
						}
					}
				}
			}
		}
	}
}
