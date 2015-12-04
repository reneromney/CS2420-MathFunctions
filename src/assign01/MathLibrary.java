package assign01; /* DO NOT modify the package declaration. */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

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

/* DO NOT modify the interface of MathLibrary. */
public class MathLibrary 
{
	/**
  	* Mean Value
  	* <p>
  	* Takes the mean values of an ArrayList consisting of
  	* data type Double. If the input list is null or empty, return 0.0.
  	* <p>
  	* Method takes all elements in passed in ArrayList and adds them
  	* all up into a single double variable. Variable is then divided by the
  	* size of the ArrayList.
  	* 
  	* @param list ArrayList consisting of Double data type
  	* @return a double value based on values of given ArrayList parameter
  	*/
	public static double mean(ArrayList<Double> list) 
	{
		if( (list == null) || (list.size() == 0) || (list.isEmpty()) ) return 0.0;
		
		double average = 0;
			
		for(int i = 0; i < list.size(); i++)
			average += list.get(i);
			
		return average / list.size();
	}

  /**
   * Median
   * <p>
   * Finds the median value given an Array consisting of data type Double.
   * Method will first create a copy of given array,
   * and then sort array in ascending numerical order. 
   * The middle of the array is the median value.  
   * <p>
   * If array length is even, the mean of the two middle values will be 
   * taken.
   * <p>
   * If array length is odd, the middle value will be taken.
   * <p>
   * If the input array is null or empty, return 0.0.
   * 
   * @param The ArrayList consisting of Double data type
   * @return A double value based on Median value of given list 
   */
  public static double median(double[] arr) 
  {
	  if( (arr == null) || (arr.length == 0) ) return 0.0;
	  
	  double[] temp = new double[arr.length];
	  
	  System.arraycopy(arr, 0, temp, 0, arr.length);
	  
	  Arrays.sort(temp); 
	  
	  double answer = 0;
  
	  if(temp.length % 2 == 1)
		  answer = temp[temp.length / 2]; //For odd numbered arrays
	  else
		  answer = (temp[temp.length / 2] + temp[temp.length / 2 - 1])/2; //For even numbered arrays
  
	  return answer;
  }

  /**
   * Mode
   * <p>
   * Checks for value that occurs most often. 
   * <p>
   * If the input array is null or empty, return 0. 
   * <p>
   * If all elements are unique,return the element in the first row and first column.  
   * If there is a tie for the mode, return any of the most frequently occurring values.)
   * 
   * @param arr The 2d array that will be calculated for mode
   * @return Returns the value with highest occurrence 
   */
  public static int mode(int[][] arr) 
  {
	  if((arr == null) || arr[0] == null || (arr.length == 0) || arr[0].length == 0 ) 
		  throw new NullPointerException();
		  
	  ArrayList<Integer> tempInt = new ArrayList<Integer>();
	  
	  //Place all elements into a single array list for iteration given their order
	  for(int row = 0; row < arr.length; row++)
		  for(int column = 0; column < arr[0].length; column++)
			  tempInt.add(arr[row][column]);
	
	 /**
	  * This is where the actual counting of how many times a 
	  * number shows up in the list takes place. 
	  * Each number in the list is checked against the other element in the arrayList. 
	  * If the number appears elsewhere in the list, increase times variable 1 (acts as a counter). 
	  * If the number ends up showing the most, it's set as the highest number based on frequency
	  * along with its count. Otherwise, we move on to the next item in the ArrayList and check it. 
	  */
	 int counter = 0;
	 int highNum = 0;
	 int highCount = 0;
	 
	 do
	 {
		 int times = 0;
		
		 int temp = tempInt.get(counter);
		 
		 for(int element : tempInt )
		 {
			 if(element == temp)
				 times++;
		 }
			
	   if(times > highCount)
	   {
		   highNum = temp;
		   highCount = times;
	   }
	   
	   if( (counter == tempInt.size()) && (highCount == 1))
		   highNum = arr[0][0];
	
	   counter++;
	   
	 } while(counter != tempInt.size());
	 
	 return highNum;
  }

  /**
   * Find the Greatest Common Divisor of two int type variables
   * <p>
   * (Note: If either of the input integers are not positive, return -1.)
   * <p>
   * @param a the first int for GCD
   * @param b the second int for GCD
   * @return The greatest common divisor between both inputs 'a' and 'b'
   */
  public static int gcd(int a, int b) 
  {
	if((a <= 0) || (b <= 0)) return -1;
	  
    ArrayList<Integer> temp1 = new ArrayList<Integer>();
    ArrayList<Integer> temp2 = new ArrayList<Integer>();
    ArrayList<Integer> temp3 = new ArrayList<Integer>();
    
    //First, calculate all of int a's factors and add to temp1 ArrayList
    for(int i = 1; i <= a; i++)
    	if(a % i == 0)
    		temp1.add(i);
    
    //Second, calculate all of int b's factors and add to temp2 ArrayList
    for(int j = 1; j <= b; j++)
    	if(b % j == 0)
    		temp2.add(j);
    
    //Take both temp1 and temp2 and find what factors match in both ArrayLists
    for(int element1 : temp1)
    	for(int element2 : temp2)
    		if(element1 == element2)
    			temp3.add(element2);
  
    //Reverse order of the ArrayList to pull out first element, which is the largest factor
    Collections.reverse(temp3);
  
    return temp3.get(0);
  }

  /**
   * Finds the least common multiple of two int variables. 
   * Take the product of (a * b) and divide by the gcd(a, b)
   * <p>
   * If either of the input integers are not positive, return -1.
   * <p>
   * @param a the first int for lcd
   * @param b the second int for lcd
   * @return The least common multiple for both int 'a' and int 'b'
   */
  public static int lcm(int a, int b) 
  {
    if( (gcd(a, b) == -1) ) return -1;
    
    int lcmResult = (a * b) / gcd(a, b);
    
    return lcmResult;
  }

  /**
   * Find next prime after given n parameter
   * <p>
   * The idea is to +1 n, divide itself to find factors. For each
   * time that n % 2 == 0, a variable counter increases by 1. If counter
   * exceeds more than 2 (because primes are 1 and themselves), 
   * the n is increased again and the process starts over. 
   * <p>
   * If the input integer is not positive, return -1.
   * 
   * @param n Input to find next available prime
   * @return Next prime
   */
  public static int nextPrime(int n) 
  {
    if(n <= 0) return -1;
    
    if(n == 1) return 2;
    
    int nextPrime = 0;
    int primeCounter = 0;	
    
    //Iterate by one to not count int n as the next available prime
    n++;
    
    boolean findPrime = true;
    
    while(findPrime)
    {
    	int temp = n;
    	primeCounter = 0;
    	
        for(int i = 1; i <= temp; i++)
        	if(temp % i == 0)
        		primeCounter++;
        
      //Prime numbers are 1 and themselves. If result of primeCounter is not exactly two,
      //then move onward to the next n (increase by 1)
      if(primeCounter == 2)
      {
    	  nextPrime = temp;
    	  findPrime = false;
      }
       
      n++;
    } 
    
    return nextPrime;
  }
}