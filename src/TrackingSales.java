
// ****************************************************************
// TrackingSales.java
//
// Reads in and stores sales for each of 5 salespeople.  Displays
// sales entered by salesperson id and total sales for all salespeople.
//
// ****************************************************************
import java.util.*;

public class TrackingSales {
	private static Scanner in = new Scanner(System.in);
	private static int salespeople = 0;
	private static int[] sales;
	private static int sum = 0;
	private static int average = 0;
	private static int biggestSale = 0;
	private static int bestSalesperson = 0;
	private static int smallestSale = 99999;
	private static int worstSalesperson = 0;
	private static int userValue = 0;

	public static void main(String[] args) {
		Import();
		Results();
		Compare(userValue);
	}

	public static void Import() {
		System.out.println("How many salespeople are there?");
		salespeople = in.nextInt();
		in.nextLine();
		sales = new int[salespeople + 1];
		for (int i = 1; i < sales.length; i++) {
			System.out.print("Enter sales for salesperson " + i + ": ");
			sales[i] = in.nextInt();
			in.nextLine();
		}
	}

	public static void Results() {
		System.out.println("\nSalesperson   Sales");
		System.out.println("--------------------");
		for (int i = 1; i < sales.length; i++) {
			System.out.println("     " + i + "         " + sales[i]);
			if (sales[i] > biggestSale) {
				biggestSale = sales[i];
				bestSalesperson = i;
			}
			if (sales[i] < smallestSale) {
				smallestSale = sales[i];
				worstSalesperson = i;
			}
			sum += sales[i];
		}
		average = sum / salespeople;
		System.out.println("\nSalesperson " + bestSalesperson + " had the largest sale at: " + sales[bestSalesperson]);
		System.out.println("Salesperson " + worstSalesperson + " had the smallest sale at: " + sales[worstSalesperson]);
		System.out.println("Average sale: " + average);
		System.out.println("Total sales: " + sum);
		System.out.println("\nEnter a value");
		userValue = in.nextInt();
	}

	public static void Compare(int x) {
		int count = 0;
		System.out.println("\nSalespeople that have exceeded that value:");
		System.out.println("Salesperson   Sales");
		System.out.println("--------------------");
		for (int i = 1; i < sales.length; i++) {
			if (sales[i] > userValue) {
				System.out.println("     " + i + "         " + sales[i]);
				count++;
			}
		}
		System.out.println("\nThe amount of salespeople that exceeded that amount: " + count);
	}
}