package main;

import java.util.ArrayList;
import java.util.Date;

public class Order {
	private String type;
	private int bill;
	private ItemPreparation prepareItem;
	public String deliveryAddress;
	public Date pickupTime = new Date();
	private ArrayList<Integer> itemQuantity = new ArrayList<>();
	private ArrayList<Item> orderItems = new ArrayList<>();
	
	public Order() {
		prepareItem = new ItemPreparation();
		deliveryAddress = null;
		bill = 0;
		type = null;
	}
	
	//checking if type of order is delivery
	public boolean isDelivery() {
		return type.equals("delivery") ? true: false;
	}
	
	//checking if type of order is pickup
	public boolean isPickup() {
		return type.equals("pickup") ? true: false;
	}
	
	//adding item to order
	public void addItem(Item item, int quantity) {
		orderItems.add(item);
		itemQuantity.add(quantity);
	}
	
	public String getOrderType() {
		return type;
	}
	
	public void setOrderType(String orderType) {
		this.type = orderType;
	}
	
	//placing order
	public void placeOrder() {
		calcBill();
		if (prepareItem.getAvailableCooks()!=0) {
			System.out.println("Your order is placed");
		}
	}
	
	//calculating bill of order
	public int calcBill() {
		for (int i=0; i<orderItems.size(); i++) {
			bill += orderItems.get(i).price * itemQuantity.get(i);
		}
		return bill;
	}
	
	public int getBill() {
		return bill;
	}
}
