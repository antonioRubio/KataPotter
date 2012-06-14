package test;

import static org.junit.Assert.*;

import main.CostCalculator;
import main.KataPotter;
import main.KataPotterCostCalculator;
import main.Order;
import main.OrderRepository;
import main.OrderRepositoryMongo;

import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class KataPotterTest {
	
	private KataPotter kataPotter;
	
	@BeforeClass
	public static void setUpClass() {
		OrderRepository repository = new OrderRepositoryMongo();
		repository.clearRepository();
		
	}
	
	@Before
	public void setUp() {
		kataPotter = new KataPotter();
		CostCalculator costCalculator = new KataPotterCostCalculator();
		kataPotter.setCostCalulator(costCalculator);
	}
	
	@Test
	public void buyNoBookTest() {
		assertEquals(0.0, kataPotter.getTotalCost(), 0.0);
	}

	@Test
	public void buyOneFirstBookTest() {
		int numCopies = 1;
		kataPotter.addToCart(KataPotter.book.FIRST, numCopies);
		assertEquals(8.0, kataPotter.getTotalCost(), 0.0);
	}
	
	@Test
	public void buyOneSecondBookTest() {
		int numCopies = 1;
		kataPotter.addToCart(KataPotter.book.SECOND, numCopies);
		assertEquals(8.0, kataPotter.getTotalCost(), 0.0);
	}
	
	@Test
	public void buyTwoFirstBookTest() {
		int numCopies = 2;
		kataPotter.addToCart(KataPotter.book.FIRST, numCopies);
		assertEquals(16.0, kataPotter.getTotalCost(), 0.0);
	}
	@Test
	public void buyTwoSecondBookTest() {
		int numCopies = 2;
		kataPotter.addToCart(KataPotter.book.SECOND, numCopies);
		assertEquals(16.0, kataPotter.getTotalCost(), 0.0);
	}
	
	@Test
	public void buyTwoFirstDifferentAddToCartBookTest() {
		int numCopies = 1;
		kataPotter.addToCart(KataPotter.book.FIRST, numCopies);
		kataPotter.addToCart(KataPotter.book.FIRST, numCopies);
		assertEquals(16.0, kataPotter.getTotalCost(), 0.0);
	}
	
	@Test
	public void buyTwoDifferentBookTest() {
		int numCopies = 1;
		kataPotter.addToCart(KataPotter.book.FIRST, numCopies);
		kataPotter.addToCart(KataPotter.book.SECOND, numCopies);
		assertEquals(15.2, kataPotter.getTotalCost(), 0.0);
	}
	
	@Test
	public void buyThreeDifferentBookTest() {
		int numCopies = 1;
		kataPotter.addToCart(KataPotter.book.FIRST, numCopies);
		kataPotter.addToCart(KataPotter.book.SECOND, numCopies);
		kataPotter.addToCart(KataPotter.book.THIRD, numCopies);
		assertEquals(21.6, kataPotter.getTotalCost(), 0.0);
	}
	
	@Test
	public void buySevenDifferentBookTest() {
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
	
	@Test
	public void buySevenDifferentBookAndTwoRepeatedSetBooksTest() {
		int[] bookCopies = new int[] {2, 2, 1, 1, 1, 1, 1};
		kataPotter.addToCart(bookCopies);
		assertArrayEquals(bookCopies, kataPotter.getBooksInCartArray());
	}
	
	@Test
	public void buySevenDifferentBookAndTwoRepeatedSetBooksPriceTest() {
		int[] bookCopies = new int[] {2, 2, 1, 1, 1, 1, 1};
		kataPotter.addToCart(bookCopies);
		assertEquals(46.0, kataPotter.getTotalCost(), 0.1);
	}
	
	@Test
	public void buySevenDifferentBookAndTwoRepeatedGetBooksTest() {
		int numCopies = 1;
		kataPotter.addToCart(KataPotter.book.FIRST, numCopies + 1);
		kataPotter.addToCart(KataPotter.book.SECOND, numCopies + 1);
		kataPotter.addToCart(KataPotter.book.THIRD, numCopies);
		kataPotter.addToCart(KataPotter.book.FOURTH, numCopies);
		kataPotter.addToCart(KataPotter.book.FIFTH, numCopies);
		kataPotter.addToCart(KataPotter.book.SIXTH, numCopies);
		kataPotter.addToCart(KataPotter.book.SEVENTH, numCopies);
		int[] bookCopies = new int[] {2, 2, 1, 1, 1, 1, 1};
		assertArrayEquals(bookCopies, kataPotter.getBooksInCartArray());
	}
	
	@Test
	public void orderRepositoryTest() {
		OrderRepository repository = new OrderRepositoryMongo();
		String name = "Julian";
		String direction = "123 Sesame Street";
		int[] bookCopies = new int[] {2, 2, 1, 1, 1, 1, 1};
		kataPotter.addToCart(bookCopies);
		Order order = kataPotter.generateOrder(name, direction);
		repository.saveOrder(order);
		assertEquals(46.0, kataPotter.getTotalCost(), 0.1);
	}
	
	@AfterClass
	public static void tearDownClass() {
		OrderRepository repository = new OrderRepositoryMongo();
		repository.clearRepository();
		
	}
}
