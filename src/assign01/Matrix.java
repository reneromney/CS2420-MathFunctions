/**
 * Romney Doria
 * CS2420 - Summer 2015
 * Instructor: Paymon Saebi
 * Assignment 01
 * Due: Friday, May 29, 2015
 */

package assign01;

/**
 * This class represents a 2D matrix, and provides methods for 
 * addition, multiplication, comparison, and printing.
 * 
 * @author Paymon Saebi
 * @author
 */ 
public class Matrix 
{
	int numRows;
	int numColumns;
	int data[][];
	
	// Constructor with data for new matrix (automatically determines dimensions)
	public Matrix(int d[][])
	{
		numRows = d.length; // d.length is the number of 1D arrays in the 2D array
		if(numRows == 0)
			numColumns = 0;
		else
			numColumns = d[0].length; // d[0] is the first 1D array
		data = new int[numRows][numColumns]; // create a new matrix to hold the data
		// copy the data over
		for(int i=0; i < numRows; i++) 
			for(int j=0; j < numColumns; j++)
				data[i][j] = d[i][j];
	}
	
	/**
	 * Function used to determine if two Matrix objects are compatible and if they are the same.
	 * 1: determine if Matrix is compatible based on rows/columns. If not, return false
	 * 2: Loop through elements of Matrix 1 and 2 check if they match
	 * 3: If all elements match, then return true. If any elements mismatch, then return false;
	 */
	@Override // instruct the compiler that we do indeed intend for this method to override the superclass' (Object) version
	public boolean equals(Object o)
	{
		if(!(o instanceof Matrix)) return false; // make sure the Object we're comparing to is a Matrix
			
		Matrix m = (Matrix)o; // if the above was not true, we know it's safe to treat 'o' as a Matrix
		
		if(this.data.length == m.data.length && this.data[0].length == m.data[0].length) 
		{
			for (int i = 0; i < this.data.length; i++)
				for (int j = 0; j < this.data[0].length; j++)
					if (this.data[i][j] != m.data[i][j]) return false;
			
			return true; // placeholder
		}
		else return false;
	}
		
	@Override // instruct the compiler that we do indeed intend for this method to override the superclass' (Object) version
	public String toString()
	{
		String resultString = "";
		
		for (int i = 0; i < this.data.length; i++)
		{
			for (int j = 0; j < this.data[0].length; j++)
				resultString += this.data[i][j] + " ";
			
			resultString += "\n";
		}
		return resultString; // placeholder
	}
	
	/**
	 * Multiplication Matrix
	 *  1. Check if the two matrices are compatible for multiplication, if not, return null.
	 *  2. If they are compatible, create new Matrix based on compatible dimensions
	 *  3. Multiple matrix1 row by matrix2 column, set product to new Matrix (product Matrix). 
	 *  4. If there are still columns to process on Matrix 2, increase product Matrix column by 1, Matrix 2 column by 1 (to shift)
	 *  5. If there are no columns to process, but still rows to process, 
	 *  	-reset product Matrix column to 0, product Matrix row += 1;
	 *  	-reset Matrix 2 column to 0;
	 *  	-Increase Matrix 1 row by 1
	 *  6. If matrix 1 row variable is greater than actual rows, exit loop 
	 *  7. Return product Matrix
	 */
	public Matrix times(Matrix m)
	{	
		if(!(this.data[0].length == m.data.length) )
		{
			System.out.println("Error: matrix arguments are not compatible for multiplcation!");
			return null;
		}
		
		Matrix prodMatrix = new Matrix(new int[this.data.length][m.data[0].length]);
		
		int prodMatrixRow = 0;
		int prodMatrixCol = 0;
		
		int mat1row = 0;
		
		int mat2col = 0;
		
		do
		{
			for(int i = 0; i < this.data[0].length;i++)
				prodMatrix.data[prodMatrixRow][prodMatrixCol] += this.data[mat1row][i] * m.data[i][mat2col]; 
			
			if( (mat2col !=  m.data[0].length-1) )
			{
				prodMatrixCol += 1;
				mat2col += 1;
			}
			else
			{
				prodMatrixCol = 0;
				prodMatrixRow += 1;
				mat2col = 0;
				mat1row += 1;
			}
			
		} while ( !(mat1row >= this.data.length));	
		
		return prodMatrix; // placeholder
	}
	
	/**
	 *  Addition Matrix
	 *  1.Check if the two matrices are compatible for addition, if not, return null.
	 *  2. If they are compatible, create a new matrix 
	 *  3. For each row/column element of new matrix, add matrix 1 and matrix 2 of the same corresponding row/element
	 */
	public Matrix plus(Matrix m)
	{
		if(this.data.length == m.data.length && this.data[0].length == m.data[0].length)
		{
			Matrix sumMatrix = new Matrix(new int[m.numRows][m.numColumns]);
			
			for (int i = 0; i < sumMatrix.numRows; i++)
				for (int j = 0; j < sumMatrix.numColumns; j++)
					sumMatrix.data[i][j] = this.data[i][j] + m.data[i][j];
			
			return sumMatrix; // placeholder
		}
		else 
		{
			System.out.println("Error: matrix arguments are not compatible for addition!");
			return null;
		}
	}
}
