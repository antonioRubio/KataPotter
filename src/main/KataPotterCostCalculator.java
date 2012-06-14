package main;

import java.util.Arrays;

public class KataPotterCostCalculator implements CostCalculator {
	
	private static final double COST_PER_BOOK = 8.0;
	private int[] elementsBuyed;
	private double[] discount = {0.0, 0.05, 0.1, 0.15, 0.2, 0.3, 0.45};

	@Override
	public void setElementsBuyed(int[] elementsBuyed) {
		this.elementsBuyed = elementsBuyed;
	}

	@Override
	public double getCost() {
		double cost = 0.0;
		int[] copyOfOrderedElementsBuyed = getCopyOfOrderedElementsBuyed();
		for (int position = 0; position < copyOfOrderedElementsBuyed.length; position++) {
			if (copyOfOrderedElementsBuyed[position] == 0) continue;
			cost += getAccumulatedCost(copyOfOrderedElementsBuyed, position);
			substractQuantityOfElements(copyOfOrderedElementsBuyed, position);
		}
		return cost;
	}
	
	private int[] getCopyOfOrderedElementsBuyed() {
		int[] copyOfOrderedElementsBuyed = elementsBuyed.clone();
		Arrays.sort(copyOfOrderedElementsBuyed);
		return copyOfOrderedElementsBuyed;
	}
	
	private double getAccumulatedCost(int[] elementsQuantity, int position) {
		int numOfDifferentElements = elementsQuantity.length - position;
		int quantity = elementsQuantity[position];
		int discountPosition = numOfDifferentElements - 1;
		double elementsDiscount = numOfDifferentElements * getDiscount(discountPosition);
		return quantity * elementsDiscount * COST_PER_BOOK;

	}

	private double getDiscount(int discountPosition) {
		return 1 - discount[discountPosition];
	}
	
	private void substractQuantityOfElements(int[] elementsQuantity, int partialPosition) {
		int quantity = elementsQuantity[partialPosition];
		for (int position = partialPosition; position < elementsQuantity.length; position++)
			elementsQuantity[position] -= quantity;
	}
	
	
}
