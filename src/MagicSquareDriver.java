
// ****************************************************************
// SquareTest.java
//
// Uses the Square class to read in square data and tell if 
// each square is magic.
//          
// ****************************************************************

import java.util.*;

public class MagicSquareDriver {
	private static Scanner in = new Scanner(System.in);

	public static void main(String[] args) {
		int count = 1;// count which square we're on
		int size = 0;
		while (size != -1) {
			System.out.println("Enter a size for the square");
			size = in.nextInt();
			MagicSquare square = new MagicSquare(size);// create a new Square of a given size
			double size2 = (int) Math.pow(size, 2);// creates a value for printing
			//calls method to read in values
			System.out.println("Enter " + size2 + " seperate values for the square");
			square.readSquare();
			System.out.println("\n******** Square " + count + " ********");
			square.printSquare();// print the square
			// print the sums of its rows
			System.out.print("The sum of the rows are: ");
			for (int i = 0; i < size; i++) {
				System.out.print(square.sumRow(i) + ", ");
			}
			// print the sums of its columns
			System.out.print("\nThe sum of the columns are: ");
			for (int i = 0; i < size; i++) {
				System.out.print(square.sumCol(i) + ", ");
			}
			//print out the sum of the main diagonal
			System.out.println("\nThe sum of the main diagonal is: " + square.sumMainDiag()); 
			//print out the sum of the other diagonal
			System.out.println("The sum of the other diagonal is: " + square.sumOtherDiag()); 
			if (square.magic()) // determine and print whether it is a magic square
			{
				System.out.println("This is a Magic Square! Awesome!");
				break;
			} else {
				System.out.println("This isn't a Magic Square");
			}
			count++;
		}

	}
}
