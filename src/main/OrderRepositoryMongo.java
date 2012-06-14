package main;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.List;

import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.Mongo;
import com.mongodb.MongoException;

public class OrderRepositoryMongo implements OrderRepository {
	DBCollection orderCollection;
	
	public OrderRepositoryMongo() {
		try {
			Mongo mongoConnection = new Mongo();
			DB dataBase = mongoConnection.getDB("orderDB");
			orderCollection = dataBase.getCollection("order");
		} catch (UnknownHostException e) {
			e.printStackTrace();
		} catch (MongoException e) {
			e.printStackTrace();
		}
	}

	@Override
	public List<Order> retrieveAllOrders() {
		DBCursor cursor = orderCollection.find();
		List<Order> orders = new ArrayList<Order>();
		while (cursor.hasNext())
			orders.add(unserialize((BasicDBObject) cursor.next()));
		return orders;
	}

	@Override
	public void saveOrder(Order order) {
		orderCollection.insert(serialize(order));
	}
	
	private BasicDBObject serialize(Order order) {
		BasicDBObject basicDBObject = new BasicDBObject();
		Method[] orderMethods = order.getClass().getDeclaredMethods();
		for (int methodPosition = 0; methodPosition < orderMethods.length; methodPosition++) {
			Method method = orderMethods[methodPosition];
			String methodName = method.getName();
			if (methodName.startsWith("get")) {
				String atributeName = methodName.substring(3).toLowerCase();
				try {
					basicDBObject.put(atributeName, method.invoke(order));
				} catch (IllegalArgumentException e) {
					e.printStackTrace();
				} catch (IllegalAccessException e) {
					e.printStackTrace();
				} catch (InvocationTargetException e) {
					e.printStackTrace();
				}
			}
		}
		return basicDBObject;	
	}
	
	private Order unserialize(BasicDBObject basicDBObject) {
		Order order = new Order();
		Method[] orderMethods = order.getClass().getDeclaredMethods();
		for (int methodPosition = 0; methodPosition < orderMethods.length; methodPosition++) {
			Method method = orderMethods[methodPosition];
			String methodName = method.getName();
			if (methodName.startsWith("set")) {
				String atributeName = methodName.substring(3).toLowerCase();
				try {
					method.invoke(order, basicDBObject.get(atributeName));
				} catch (IllegalArgumentException e) {
					e.printStackTrace();
				} catch (IllegalAccessException e) {
					e.printStackTrace();
				} catch (InvocationTargetException e) {
					e.printStackTrace();
				}
			}
		}
		return order;
	}

	@Override
	public void clearRepository() {
		orderCollection.drop();
	}

	@Override
	public long getNumberOfOrders() {
		return orderCollection.getCount();
	}

}
