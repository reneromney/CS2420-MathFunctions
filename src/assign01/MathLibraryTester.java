package assign01;

import static org.junit.Assert.*;
import static assign01.MathLibrary.*;
import java.util.ArrayList;
import java.util.Arrays;
import org.junit.Test;

/**
 * @author Romney Doria
 * @author CADE: doria
 * @since 9/3/2015
 * CS2420 - Fall 2015
 * Instructor: Erin Parker
 * Due Date: 9/3/2015
 * Assignment 1
 * Github: reneromney
 */

public class MathLibraryTester 
{
	/** 
	 * JUnit 4 tests to test Mean Method
	 * */
	@Test
	public void testMeanNullList()
	{
		ArrayList<Double> alEmpty = null; 
		assertEquals(0.0, mean(alEmpty), .001);
	}
	
	@Test
	public void testMeanEmpty()
	{
		ArrayList<Double> alEmpty2 = new ArrayList<Double>(); //ArrayList with size 0
		assertEquals(0.0, mean(alEmpty2), .001);
	}
	
	@Test
	public void testMeanZero()
	{
		ArrayList<Double> zeroList = new ArrayList<Double>(Arrays.asList(0.0));
		assertEquals(0.0, mean(zeroList), .001);
	}
	
	@Test
	public void testMean1() 
	{
		ArrayList<Double> list1 = new ArrayList<Double>(Arrays.asList(3.4, 9.0, 7.8, 1.2, 5.6)); //Average is 5.4
		assertEquals(5.4, mean(list1), .001);
	}
	
	@Test
	public void testMean2()
	{
		ArrayList<Double> list2 = new ArrayList<Double>(Arrays.asList(6.8, 2.5, 5.5, 11.1, 7.6, 3.1)); //Average is 6.1
		assertEquals(6.1, mean(list2),.001);
	}
	
	@Test
	public void testMean3()
	{
		ArrayList<Double> list3 = new ArrayList<Double>(Arrays.asList(1.0, 2.0, 3.0, 4.0, 5.0, 6.0, 7.0, 8.0, 9.0, 10.0)); //Average is 5.5
		assertEquals(5.5, mean(list3),.001);
	}
	
	/** 
	 * JUnit 4 tests to test Median Method
	 * */
	@Test
	public void testMedianEmpty()
	{
		double[] arrEmpty = new double[0];
		assertEquals(0.0, median(arrEmpty), .001);
	}

	@Test
	public void testMedianNull()
	{
		double[] arrNull = null;
		assertEquals(0.0, median(arrNull), .001);
	}
	
	@Test
	public void testMedianOdd() 
	{
		double[] arrOdd = {4.2, 2.9, 5.3, 1.7, 3.5}; //Median value is 3.5
		assertEquals(3.5, median(arrOdd), .001);
	}
	
	@Test
	public void testMedianEven() 
	{
		double[] arrEven = {3.4, 1.5, 2.0, 5.5};
		assertEquals(2.7, median(arrEven), .001);
	}
	
	@Test
	public void testMedianEven2()
	{
		double[] arrEven2 = {3.4, 1.5, 2.0, 4.5, 11.9, 5.5, 7.2, 4.0, 8.9, 10.0}; //Median Value is 5.0
		assertEquals(5.0, median(arrEven2), .001);
	}

	@Test
	public void testMedianzero()
	{
		double[] arrZero = {0.0};
		assertEquals(0.0, median(arrZero), .001);
	}

	/** 
	 * JUnit 4 tests to test Mode Method
	 * */
	@Test
	public void testModeEmpty() 
	{	
		int[][] arrModeEmpty = new int[10][10];
		assertEquals(0, mode(arrModeEmpty));
	}
	
	@Test(expected=NullPointerException.class)
	public void testModeNull() 
	{
		int[][] arrModeNull = null;
		mode(arrModeNull);
	}
	
	@Test
	public void testMode1() 
	{
		int[][] arr_2d = { { 2, 2, 2 }, { 0, 3, 3 }, { 22, 7, 1 }, { 1, 1, 1 }}; //Mode is 1
		assertEquals(1, mode(arr_2d));
	}
	
	@Test
	public void testMode2() 
	{
		int[][] arr_2da = { { 3, 3, 2 }, { 1, 1, 1 }, { 1, 8, 3 }, { 2, 4, 3 }}; //3 and 4 appears 4 times, but 3 shows up first on list
	
		assertEquals(3, mode(arr_2da));
	}
	
	@Test
	public void testModeNoDuplicates() 
	{
		int[][] arr_2db = { { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 }, { 10, 11, 12 }}; //No duplicates, returns 1
		assertEquals(1, mode(arr_2db));
	}

	/** 
	 * JUnit 4 tests to test GCD Method
	 * */
	@Test
	public void testGCDlessThanOneA()
	{
		assertEquals(-1, gcd(0, 42));
	}
	
	@Test
	public void testGCDlessThanOneB()
	{
		assertEquals(-1, gcd(42, -1));
	}
	
	
	@Test
	public void testGCD1() 
	{
		assertEquals(27, gcd(27, 81));
	}
	
	@Test
	public void testGCD2() 
	{
		assertEquals(32, gcd(32, 128));
	}
	
	@Test
	public void testGCD3() 
	{
		assertEquals(9, gcd(81, 45));
	}
	
	@Test
	public void testGCD4() 
	{
		assertEquals(18, gcd(198, 36));
	}
 
	@Test
	public void testGCD5() {
		assertEquals(6, gcd(18, 24));
	}
	
	/** 
	 * JUnit 4 tests to test LCM Method
	 * */
	
	@Test
	public void testLCMZeroA() 
	{
		assertEquals(-1, lcm(0, 6));
	}
	
	@Test
	public void testLCMZeroB() 
	{
		assertEquals(-1, lcm(6, 0));
	}
	
	@Test
	public void testLCM1() 
	{
		assertEquals(42, lcm(21, 6));
	}
	
	@Test
	public void testLCM2() 
	{
		assertEquals(198, lcm(198, 2));
	}
	
	@Test
	public void testLCM3() 
	{
		assertEquals(480, lcm(32, 15));
	}
	
	@Test
	public void testLCM4() 
	{
		assertEquals(2943, lcm(27, 981));
	}
	
	/** 
	 * JUnit 4 tests to test Next Prime Method
	 * */
	
	@Test
	public void testNextPrimeZero() 
	{
		assertEquals(-1, nextPrime(0));
	}
	
	@Test
	public void testNextPrimeOne() 
	{
		assertEquals(2, nextPrime(1));
	}
	
	@Test
	public void testNextPrime1() 
	{
		assertEquals(29, nextPrime(23));
	}
	
	@Test
	public void testNextPrime2() 
	{
		assertEquals(1373, nextPrime(1368));
	}
	
	@Test
	public void testNextPrime3() 
	{
		assertEquals(5851, nextPrime(5849));
	}
}
