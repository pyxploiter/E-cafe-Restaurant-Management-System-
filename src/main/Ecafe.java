package main;
import java.util.*;

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
		int itemNo = 1, quantity = 0;
		Date time = new Date();
		Scanner sc=new Scanner(System.in);
		Ecafe ecafe = new Ecafe();
		if (time.getHours()<ecafe.openTime.getHours() || time.getHours()>=ecafe.closeTime.getHours() ) {
			System.out.println("=========> Cafe 420 is closed now. <=========");
		}
		else {
			for(;;) {
				ecafe.order = new Order();
				System.out.println("=========> Welcome to Cafe 420 <=========");
				System.out.println();
				ecafe.menu.showMenu();	
				System.out.println("=> Type 0 to place the order:-");
				for(;;) {
					System.out.print("Type the Item No: ");
					itemNo = sc.nextInt();
					if (itemNo == 0)
						break;
					System.out.print("=> Quantity of Item-"+itemNo+": ");
					quantity = sc.nextInt();
					ecafe.order.addItem(ecafe.menu.item[(itemNo-1)], quantity);
				}

				if (itemNo == 0) {
					System.out.println("1. Home Delivery");
					System.out.println("2. Self Pick-up");
					int orderType = sc.nextInt();
					if (orderType == 1) {
						ecafe.order.setOrderType("delivery");
						System.out.print("Type the delivery address: ");
						ecafe.order.deliveryAddress = sc.next();
						ecafe.order.placeOrder();
						System.out.println(ecafe.order.getBill());

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
