package main;

public class Item {
	protected String name;
	protected String category;
	protected int price;
	
	//constructor without arguments
	public Item() {
		
	}
	
	//constructor with arguments
	public Item(String itemName, String itemCategory, int itemPrice) {
		this.name = itemName;
		this.category = itemCategory;
		this.price = itemPrice;
	}
	
	//setter for price variable
	public void setPrice(int itemPrice) {
		this.price = itemPrice;
	}
	
	//setter for name variable
	public void setName(String itemName) {
		this.name = itemName;
	}
	
	//setter for category
	public void setCategory(String itemCategory) {
		this.category = itemCategory;
	}
	
	//getter for price
	public int getPrice() {
		return this.price;
	}
	
	//getter for name
	public String getName() {
		return this.name;
	}
	
	//getter for category
	public String getCategory() {
		return this.category;
	}
}
