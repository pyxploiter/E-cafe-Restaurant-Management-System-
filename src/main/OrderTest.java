package main;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class OrderTest {
	private Order testOrder;
	
	@Before
	public void setUp()
	{
		testOrder = new Order();
	}
	
	@Test
	public void testOrder() {
		assertNotNull(testOrder);
	}

	@Test
	public void testIsDelivery() {
		testOrder.setOrderType("delivery");
		assertTrue(testOrder.isDelivery());
	}

	@Test
	public void testIsPickup() {
		testOrder.setOrderType("pickup");
		assertTrue(testOrder.isPickup());
	}

	@Test
	public void testGetOrderType() {
		testOrder.setOrderType("pickup");
		assertEquals(testOrder.getOrderType(), "pickup");
	}

	@Test
	public void testCalcBill() {
		Item item = new Item("Garlic Bread","appetizer",250);
		testOrder.addItem(item, 4);
		assertEquals(testOrder.calcBill(), 1000);
	}

	@Test
	public void testGetBill() {
		Item item = new Item("Garlic Bread","appetizer",200);
		testOrder.addItem(item, 4);
		testOrder.calcBill();
		assertEquals(testOrder.calcBill(), 800);
	}

}
