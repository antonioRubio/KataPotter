package main;

import java.util.Arrays;

public class KataPotter {
	private static final double COST_PER_BOOK = 8.0;
	
	private int[] booksBuyed;
	private double[] discount = {0.0, 0.05, 0.1, 0.15, 0.2, 0.3, 0.45};
	
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

	public double getTotalCost() {
		double cost = 0.0;
		int[] copyOfOrderedBooksBuyed = getCopyOfOrderedBooksBuyed();
		for (int position = 0; position < copyOfOrderedBooksBuyed.length; position++) {
			if (copyOfOrderedBooksBuyed[position] == 0) continue;
			cost += getAccumulatedCost(copyOfOrderedBooksBuyed, position);
			substractQuantityOfBooks(copyOfOrderedBooksBuyed, position);
		}
		return cost;
	}
	
	private double getAccumulatedCost(int[] booksQuantity, int position) {
		int numOfDifferentBooks = booksQuantity.length - position;
		int quantity = booksQuantity[position];
		int discountPosition = numOfDifferentBooks - 1;
		double booksDiscount = numOfDifferentBooks * getDiscount(discountPosition);
		return quantity * booksDiscount * COST_PER_BOOK;
	}

	private double getDiscount(int discountPosition) {
		return 1 - discount[discountPosition];
	}

	private void substractQuantityOfBooks(int[] booksQuantity, int partialPosition) {
		int quantity = booksQuantity[partialPosition];
		for (int position = partialPosition; position < booksQuantity.length; position++)
			booksQuantity[position] -= quantity;
	}

	private int[] getCopyOfOrderedBooksBuyed() {
		int[] copyOfOrderedBooksBuyed = booksBuyed.clone();
		Arrays.sort(copyOfOrderedBooksBuyed);
		return copyOfOrderedBooksBuyed;
	}
	
	
}
