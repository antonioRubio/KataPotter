package main;

import java.util.List;

public interface OrderRepository {
	public List<Order> retrieveAllOrders();
	public void saveOrder(Order order);
	public void clearRepository();
	public long getNumberOfOrders();
}
