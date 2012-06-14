package main;

public class KataPotter {
	private int[] booksBuyed;
	private CostCalculator costCalculator;
	
	public static enum book {
		FIRST, SECOND, THIRD, FOURTH, FIFTH, SIXTH, SEVENTH
	}
	
	public KataPotter() {
		int numBooks = book.values().length;
		booksBuyed = new int[numBooks];
	}

	public void addToCart(book bookNumber, int numCopies) {
		int positionBookNumber = bookNumber.ordinal();
		booksBuyed[positionBookNumber] += numCopies;
	}
	
	public void addToCart(int[] bookCopies) {
		for (int positionBookNumber = 0; positionBookNumber < bookCopies.length; 
				positionBookNumber++) {
			booksBuyed[positionBookNumber] += bookCopies[positionBookNumber];
		}
	}

	public double getTotalCost() {
		costCalculator.setElementsBuyed(booksBuyed);
		return costCalculator.getCost();
	}
	
	public int[] getBooksInCartArray() {
		return booksBuyed;
	}
	
	public void setCostCalulator(CostCalculator costCalculator) {
		this.costCalculator = costCalculator;
	}
	
	public Order generateOrder(String name, String direction) {
		Order order = new Order();
		order.setName(name);
		order.setDirection(direction);
		order.setPrice(getTotalCost());
		order.setBookCopies(booksBuyed);
		return order;
	}
}
