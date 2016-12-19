
// ****************************************************************
// IntegerListTest.java
//
// Provide a menu-driven tester for the IntegerList class.
//          
// ****************************************************************
import java.util.*;

public class IntegerListDriver {
	static IntegerList list = new IntegerList(10);
	static Scanner in = new Scanner(System.in);

	// Create a list, then repeatedly print the menu and do what the
	// user asks until they quit
	public static void main(String[] args) {
		printMenu();
		int choice = in.nextInt();
		in.nextLine();
		while (choice != 0) {
			dispatch(choice);
			printMenu();
			choice = in.nextInt();
			in.nextLine();
		}
	}

	// Do what the menu item calls for
	public static void dispatch(int choice) {
		int loc;
		switch (choice) {
		case 0:
			System.out.println("Bye!");
			break;
		case 1:
			System.out.println("How big should the list be?");
			int size = in.nextInt();
			in.nextLine();
			list = new IntegerList(size);
			list.randomize();
			break;
		case 2:
			list.increasingSort();
			break;
		case 3:
			list.decreasingSort();
			break;
		case 4:
			System.out.println("Enter the value being replaced: ");
			int oldVal = in.nextInt();
			in.nextLine();
			System.out.println("Enter the new value: ");
			list.replaceFirst(oldVal, in.nextInt());
			in.nextLine();
			break;
		case 5:
			System.out.println("Enter the value being replaced: ");
			oldVal = in.nextInt();
			in.nextLine();
			System.out.println("Enter the new value: ");
			list.replaceAll(oldVal, in.nextInt());
			in.nextLine();
			break;
		case 6:
			System.out.print("Enter the value to look for: ");
			loc = list.search(in.nextInt());
			in.nextLine();
			if (loc != -1) {
				System.out.println("Found at location " + loc);
			} else {
				System.out.println("Not in list");
			}
			break;
		case 7:
			list.print();
			break;
		default:
			System.out.println("Sorry, invalid choice");
		}
	}

	// Print the user's choices
	public static void printMenu() {
		System.out.println("\n   Menu   ");
		System.out.println("   ====");
		System.out.println("0: Quit");
		System.out.println("1: Create a new list (** do this first!! **)");
		System.out.println("2: Sort the list using selection sort (Increasing)");
		System.out.println("3: Sort the list using selection sort (Decreasing)");
		System.out.println("4: Replace the first of a value in the list");
		System.out.println("5: Replace all instances of a value in the list");
		System.out.println("6: Find an element in the list using sequential search");
		System.out.println("7: Print the list");
		System.out.print("\nEnter your choice: ");
	}

}