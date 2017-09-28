package main;

import static org.junit.Assert.*;

import org.junit.Test;

public class EcafeTest extends Ecafe {
	@Test
	public void testValidOrderTime() {
		int orderHour = 9, orderMint = 15;
		assertFalse(validOrderTime(orderHour, orderMint));
		orderHour = 14; orderMint = 10;
		assertTrue(validOrderTime(orderHour, orderMint));
	}

}
