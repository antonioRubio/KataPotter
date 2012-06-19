package org.antonio.katapotter;

import static org.junit.Assert.*;


import org.junit.Test;

public class OrderTest {

	@Test
	public void addressTest() {
		Order order = new Order();
		String direction = "123 Sesame street";
		order.setDirection(direction);
		assertEquals(direction, order.getDirection());
	}
	
	@Test
	public void nameTest() {
		Order order = new Order();
		String name = "Pepito";
		order.setName(name);
		assertEquals(name, order.getName());
	}
	
	@Test
	public void priceTest() {
		Order order = new Order();
		double price = 1.23;
		order.setPrice(price);
		assertEquals(price, order.getPrice(), 0.0);
	}
	
	@Test
	public void booksTest() {
		Order order = new Order();
		int[] bookCopies = new int[] {2, 2, 1, 1, 1, 1, 1};
		order.setBookCopies(bookCopies);
		assertArrayEquals(bookCopies, order.getBookCopies());
	}
	
	@Test
	public void toJSONTest() {
		Order order = new Order();
		String direction = "123 Sesame street";
		String name = "Pepito";
		double price = 1.23;
		order.setPrice(price);
		order.setName(name);
		int[] bookCopies = new int[] {2, 2, 1, 1, 1, 1, 1};
		order.setDirection(direction);
		order.setBookCopies(bookCopies);
		String result = "{\"direction\":\"123 Sesame street\",\"name\":\"Pepito\",\"price\":1.23,\"bookCopies\":[2,2,1,1,1,1,1]}";
		assertEquals(result, order.toJSON());
	}

}
