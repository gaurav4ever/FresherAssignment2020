package com.nuclei.assignment.test;

import static org.junit.Assert.*;

import org.junit.Test;

import com.nuclei.assignment.beans.Item;

public class Test1 {
	private static final double DELTA = 1e-15;
	//JUnit testcase for testing the computed total amount for a raw item type
	@Test
	public void testRaw() {
		Item item = new Item("aloh", 12, 3, "raw");
		assertEquals(item.getTotal(), (item.getPrice()+0.125*item.getPrice())*item.getQuantity(), DELTA);
	}

}
