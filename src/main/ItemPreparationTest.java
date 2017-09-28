package main;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class ItemPreparationTest {
	ItemPreparation test;
	@Before
	public void setUp()
	{
		test = new ItemPreparation();
	}

	@Test
	public void testGetAvailableCooks() {
		assertEquals(test.getAvailableCooks(), 4);
	}

}
