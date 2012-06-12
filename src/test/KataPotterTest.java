package test;

import static org.junit.Assert.*;

import main.KataPotter;

import org.junit.Test;

public class KataPotterTest {
	
	@Test
	public void buyNoBookTest() {
		KataPotter kataPotter = new KataPotter();
		assertEquals(0.0, kataPotter.getTotalCost(), 0.0);
	}

	@Test
	public void buyOneFirstBookTest() {
		KataPotter kataPotter = new KataPotter();
		int numCopies = 1;
		kataPotter.addToCart(KataPotter.book.FIRST, numCopies);
		assertEquals(8.0, kataPotter.getTotalCost(), 0.0);
	}
	
	@Test
	public void buyOneSecondBookTest() {
		KataPotter kataPotter = new KataPotter();
		int numCopies = 1;
		kataPotter.addToCart(KataPotter.book.SECOND, numCopies);
		assertEquals(8.0, kataPotter.getTotalCost(), 0.0);
	}
	
	@Test
	public void buyTwoFirstBookTest() {
		KataPotter kataPotter = new KataPotter();
		int numCopies = 2;
		kataPotter.addToCart(KataPotter.book.FIRST, numCopies);
		assertEquals(16.0, kataPotter.getTotalCost(), 0.0);
	}
	@Test
	public void buyTwoSecondBookTest() {
		KataPotter kataPotter = new KataPotter();
		int numCopies = 2;
		kataPotter.addToCart(KataPotter.book.SECOND, numCopies);
		assertEquals(16.0, kataPotter.getTotalCost(), 0.0);
	}
	
	@Test
	public void buyTwoFirstDifferentAddToCartBookTest() {
		KataPotter kataPotter = new KataPotter();
		int numCopies = 1;
		kataPotter.addToCart(KataPotter.book.FIRST, numCopies);
		kataPotter.addToCart(KataPotter.book.FIRST, numCopies);
		assertEquals(16.0, kataPotter.getTotalCost(), 0.0);
	}
	
	@Test
	public void buyTwoDifferentBookTest() {
		KataPotter kataPotter = new KataPotter();
		int numCopies = 1;
		kataPotter.addToCart(KataPotter.book.FIRST, numCopies);
		kataPotter.addToCart(KataPotter.book.SECOND, numCopies);
		assertEquals(15.2, kataPotter.getTotalCost(), 0.0);
	}
	
	@Test
	public void buyThreeDifferentBookTest() {
		KataPotter kataPotter = new KataPotter();
		int numCopies = 1;
		kataPotter.addToCart(KataPotter.book.FIRST, numCopies);
		kataPotter.addToCart(KataPotter.book.SECOND, numCopies);
		kataPotter.addToCart(KataPotter.book.THIRD, numCopies);
		assertEquals(21.6, kataPotter.getTotalCost(), 0.0);
	}
	
	@Test
	public void buySevenDifferentBookTest() {
		KataPotter kataPotter = new KataPotter();
		int numCopies = 1;
		kataPotter.addToCart(KataPotter.book.FIRST, numCopies);
		kataPotter.addToCart(KataPotter.book.SECOND, numCopies);
		kataPotter.addToCart(KataPotter.book.THIRD, numCopies);
		kataPotter.addToCart(KataPotter.book.FOURTH, numCopies);
		kataPotter.addToCart(KataPotter.book.FIFTH, numCopies);
		kataPotter.addToCart(KataPotter.book.SIXTH, numCopies);
		kataPotter.addToCart(KataPotter.book.SEVENTH, numCopies);
		assertEquals(30.8, kataPotter.getTotalCost(), 0.1);
	}
	
	@Test
	public void buySevenDifferentBookAndOneRepeatedTest() {
		KataPotter kataPotter = new KataPotter();
		int numCopies = 1;
		kataPotter.addToCart(KataPotter.book.FIRST, numCopies);
		kataPotter.addToCart(KataPotter.book.FIRST, numCopies);
		kataPotter.addToCart(KataPotter.book.SECOND, numCopies);
		kataPotter.addToCart(KataPotter.book.THIRD, numCopies);
		kataPotter.addToCart(KataPotter.book.FOURTH, numCopies);
		kataPotter.addToCart(KataPotter.book.FIFTH, numCopies);
		kataPotter.addToCart(KataPotter.book.SIXTH, numCopies);
		kataPotter.addToCart(KataPotter.book.SEVENTH, numCopies);
		assertEquals(38.8, kataPotter.getTotalCost(), 0.1);
	}
	
	@Test
	public void buySevenDifferentBookAndTwoRepeatedTest() {
		KataPotter kataPotter = new KataPotter();
		int numCopies = 1;
		kataPotter.addToCart(KataPotter.book.FIRST, numCopies + 1);
		kataPotter.addToCart(KataPotter.book.SECOND, numCopies + 1);
		kataPotter.addToCart(KataPotter.book.THIRD, numCopies);
		kataPotter.addToCart(KataPotter.book.FOURTH, numCopies);
		kataPotter.addToCart(KataPotter.book.FIFTH, numCopies);
		kataPotter.addToCart(KataPotter.book.SIXTH, numCopies);
		kataPotter.addToCart(KataPotter.book.SEVENTH, numCopies);
		assertEquals(46.0, kataPotter.getTotalCost(), 0.1);
	}
}
