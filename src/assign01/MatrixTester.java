/**
 * Romney Doria
 * CS2420 - Summer 2015
 * Instructor: Paymon Saebi
 * Assignment 01
 * Due: Friday, May 29, 2015
 */
/*
 * Here is a starting point for your Matrix tester. You will have to fill in the rest of "main" with
 * more code to sufficiently test your Matrix class. We will be using our own MatrixTester for grading. 
 *
 * @author Paymon Saebi
 * @author
*/
package assign01;

import assign01.Matrix;

public class MatrixTester 
{
	public static void main(String[] args)
	{			
		Matrix M1 = new Matrix(new int[][]
		                                 {{1, 2, 3},
										  {4, 5, 6}});
		
		Matrix M2 = new Matrix(new int[][]
		                                 {{4, 5},
										  {3, 2},
										  {1, 1}});
		
		Matrix M3 = new Matrix(new int[][]
                {{6, 5, 4},
				  {3, 2, 1}});
		
		Matrix M4 = new Matrix(new int[][]
                {{1, 2, 3},
				  {2, 5, 6}});
		
		Matrix M5 = new Matrix(new int[][]
							{{1, 2},
							 {3, 4}});
		
		Matrix M6 = new Matrix(new int[][]
				{{1, 2},
				 {3, 4}});
		
		Matrix M7 = new Matrix(new int[][]
										{{1, 2, 3, 4, 5},
										 {6, 7, 8, 9, 10},
										 {11, 12, 13, 14, 15}
										});
		
		Matrix M8 = new Matrix(new int[][]
				{{1, 2, 3},
				 {4, 5, 6},
				 {7, 7, 9},
				 {10, 11, 12},
				 {13, 14, 15}
				});
		
		
				
		
		// this is the known correct result of multiplying M1 by M2
		Matrix referenceMultiply = new Matrix(new int[][]
		                                                {{13, 12},
														 {37, 36}});
		
		
		/* 
		 * Note that none of the tests below will be correct until you have implemented all methods.
		 * This is just one example of a test, you must write more tests and cover all cases.
		 */
		
		// get the matrix computed by your times method
		Matrix computedMultiply = M1.times(M2);
		System.out.println(computedMultiply);
		
		// exercises your toString method
		System.out.println("Computed result for M1 * M2:\n" + computedMultiply); 
		
		// exercises your .equals method, and makes sure that your computed result is the same as the known correct result
		if(!referenceMultiply.equals(computedMultiply)) 
			System.out.println("Should be:\n" + referenceMultiply);
		
		//TODO: fill in more tests that fully exercise all of your methods
		
		System.out.println(".equals method testing ");
		System.out.println(M1.equals(M2)); //Returns false
		System.out.println(M1.equals(M1)); //Returns true
		System.out.println(M5.equals(M6)); //returns true;
		
		System.out.println(".toString() method testing");
		System.out.println(M1);
		System.out.println(M2);
		System.out.println(M3);
		
		System.out.println(".plus() method testing");
		Matrix sumMatrix1 = M1.plus(M3);
		System.out.println(sumMatrix1); //Lucky 7s
		Matrix sumMatrix2 = M5.plus(M5);
		System.out.println(sumMatrix2); //multiples of two
		
		Matrix sumMatrix4 = M7.plus(M7);
		System.out.println(sumMatrix4); //3x5 matrix addition
		System.out.println(M4.plus(M5)); //Will return error and null
		
		System.out.println(".times() method testing");
		Matrix prodMatrix1 = M1.times(M2); //2x2 Matrix
		System.out.println(prodMatrix1);
		Matrix prodMatrix2 = M2.times(M3); //3x3 matrix based on 3x2 times 2x3 Matrix
		System.out.println(prodMatrix2);
		
		Matrix prodMatrix4 = M7.times(M8);
		System.out.println(prodMatrix4); //3x5 by 5x3 matrix
		
		System.out.println(M1.times(M4)); //Will return error and null
		
	}
}
