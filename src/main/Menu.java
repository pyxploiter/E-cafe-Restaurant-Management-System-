package main;

public class Menu {
	Item item[] = new Item[15];
	
	public Menu() {
		generateMenu();
	}
	
	public void generateMenu() {
		item[0] = new Item("Garlic Bread","appetizer",250);
		item[1] = new Item("Garlic Knots","appetizer",100);
		item[2] = new Item("Fried Calamari","appetizer",980);
		item[3] = new Item("French Fries","appetizer",300);
		
		item[4] = new Item("Beef Soup","soup",250);
		item[5] = new Item("Wonton Soup","soup",250);
		
		item[6] = new Item("Chicken Thai Curry","maindish",700);
		item[7] = new Item("Fish Thai Curry","maindish",850);
		item[8] = new Item("Rendang Rice Set","maindish",670);
		item[9] = new Item("Lamb Chops","maindish",450);
		item[10] = new Item("Filet Steak","maindish",750);
		item[11] = new Item("Roasted Mutton","maindish",900);
		
		item[12] = new Item("Roasted Potatoes","sidedish",150);
		item[13] = new Item("Bacon","sidedish",200);
		item[14] = new Item("Sausage","sidedish",100);
	}
	
	public void showMenu() {
		System.out.println("============================== MENU ==============================");
		System.out.println("Item No         Item Name              Category              Price");
		System.out.println("------------------------------------------------------------------");
		for (int i=0; i<15; i++) {
				System.out.printf("   %-12d%-24s%-22s%-10d",(i+1),item[i].name,item[i].category,item[i].price);
				System.out.println();
		}
		System.out.println("------------------------------------------------------------------");
	}
}
