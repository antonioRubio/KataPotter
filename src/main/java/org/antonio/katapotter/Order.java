package org.antonio.katapotter;

import java.io.IOException;

import org.apache.log4j.Logger;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;


public class Order {
	private String direction;
	private String name;
	private double price;
	private int[] bookCopies;
	
	private Logger logger = Logger.getLogger(Order.class);

	public void setDirection(String direction) {
		this.direction = direction;
	}

	public String getDirection() {
		return direction;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public double getPrice() {
		return price;
	}

	public void setBookCopies(int[] bookCopies) {
		this.bookCopies = bookCopies;
	}

	public int[] getBookCopies() {
		return bookCopies;
	}
	
	public String toJSON() {
		ObjectMapper mapper = new ObjectMapper();
		String jsonStringOrder = null;
		try {
			jsonStringOrder = mapper.writeValueAsString(this);
		} catch (JsonGenerationException e) {
			logger.error(e.getMessage());
		} catch (JsonMappingException e) {
			logger.error(e.getMessage());
		} catch (IOException e) {
			logger.error(e.getMessage());
		}
		return jsonStringOrder;
	}
}
