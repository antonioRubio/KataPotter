package org.antonio.katapotter;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class OrderRepositoryMongoTest {
	
	private OrderRepositoryMongo orm;
	
	@Before
	public void setUp() {
		orm = new OrderRepositoryMongo();
	}
	
	@Test
	public void setOneOrderTest() {
		Order order = new Order();
		order.setDirection("123 Sesame Street");
		order.setName("Pepito");
		order.setPrice(17.2);
		order.setBookCopies(new int[] {1,2,3,4,5,6,7});
		orm.saveOrder(order);
		assertEquals(1, orm.getNumberOfOrders());
	}
	
	@Test
	public void setTwoOrderTest() {
		Order order = new Order();
		order.setDirection("123 Sesame Street");
		order.setName("Pepito");
		order.setPrice(17.2);
		order.setBookCopies(new int[] {1,2,3,4,5,6,7});
		orm.saveOrder(order);
		orm.saveOrder(order);
		assertEquals(2, orm.getNumberOfOrders());
	}
	
	@After
	public void tearDown() {
		orm.clearRepository();
	}

}
