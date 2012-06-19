package org.antonio.katapotter;

import java.io.IOException;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.DBObject;
import com.mongodb.Mongo;
import com.mongodb.MongoException;
import com.mongodb.util.JSON;

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

	public List<Order> retrieveAllOrders() {
		DBCursor cursor = orderCollection.find();
		List<Order> orders = new ArrayList<Order>();
		ObjectMapper mapper = new ObjectMapper();
		Order order = null;
		while (cursor.hasNext()) {
			try {
				DBObject dbObject = (DBObject) cursor.next();
				String jsonObject = JSON.serialize(dbObject);
				order = mapper.readValue(jsonObject, Order.class);
				orders.add(order);
			} catch (JsonParseException e) {
				e.printStackTrace();
			} catch (JsonMappingException e) {
				e.printStackTrace();
			} catch (MongoException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
			
		}
		return orders;
	}

	public void saveOrder(Order order) {
		String jsonOrder = order.toJSON();
		DBObject dbObject = (DBObject) JSON.parse(jsonOrder);
		orderCollection.insert(dbObject);
	}
	
	public void clearRepository() {
		orderCollection.drop();
	}

	public long getNumberOfOrders() {
		return orderCollection.getCount();
	}

}