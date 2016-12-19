
// ****************************************************************
// Square.java
//
// Define a Square class with methods to create and read in
// info for a square matrix and to compute the sum of a row,
// a col, either diagonal, and whether it is magic.
//          
// ****************************************************************

import java.util.*;

public class MagicSquare {
	int[][] square;
	private Scanner in = new Scanner(System.in);

	public MagicSquare(int size)// create new square of given size
	{
		square = new int[size][size];
	}

	public int sumRow(int row)// return the sum of the values in the given row
	{
		int sum = 0;
		for (int i = 0; i < square.length; i++) {
			sum += square[row][i];
		}
		return sum;
	}

	public int sumCol(int col)// return the sum of the values in the given
								// column
	{
		int sum = 0;
		for (int i = 0; i < square.length; i++) {
			sum += square[i][col];
		}
		return sum;
	}

	public int sumMainDiag()// return the sum of the values in the main diagonal
	{
		int sum = 0;
		for (int i = 0; i < square.length; i++) {
			sum += square[i][i];
		}
		return sum;
	}

	public int sumOtherDiag()// return the sum of the values in the other
								// ("reverse") diagonal
	{
		int sum = 0;
		int j = square.length - 1;
		for (int i = 0; i < square.length; i++) {
			sum += square[i][j];
			j--;
		}
		return sum;
	}

	// return true if the square is magic (all rows, cols, and diags have same
	// sum)
	public boolean magic() {
		int matchs = 0;
		if (sumMainDiag() == sumOtherDiag()) {
			int target = sumMainDiag();
			for (int i = 0; i < square.length; i++) {
				if (sumCol(i) == target && sumRow(i) == target) {
					matchs++;
				}
			}
			if (matchs == square.length) {
				return true;
			}
		} else {
			return false;
		}
		return false;
	}

	public void readSquare()// read info into the square from the standard
							// input.
	{
		for (int row = 0; row < square.length; row++) {
			for (int col = 0; col < square.length; col++) {
				square[row][col] = in.nextInt();
			}
		}
	}

	public void printSquare() {// print the contents of the square, neatly
								// formatted {
		System.out.print("\n");
		for (int col = 0; col < square.length; col++) {
			for (int row = 0; row < square.length; row++) {
				System.out.print("     " + square[col][row] + " ");
			}
			System.out.println("\n");
		}
	}

}
