package main;

public class Order {
	private String direction;
	private String name;
	private double price;
	private int[] bookCopies;

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

}
