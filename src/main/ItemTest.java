package main;

import static org.junit.Assert.*;

import org.junit.Test;

public class ItemTest {

	@Test
	public void testItem() {
		Item item = new Item("Bacon","sidedish",100);
		assertEquals(item.price, 100);
		assertEquals(item.name, "Bacon");
	}

	@Test
	public void testGetPrice() {
		Item item = new Item("Salad","sidedish",300);
		assertEquals(item.getPrice(),300);
	}

	@Test
	public void testGetName() {
		Item item = new Item("Salad","sidedish",300);
		assertEquals(item.getName(),"Salad");
	}

	@Test
	public void testGetCategory() {
		Item item = new Item("Salad","sidedish",300);
		assertEquals(item.getCategory(),"sidedish");
	}

}
