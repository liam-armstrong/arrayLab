
// ***************************************************************
//   Shop.java
//
//   Uses the Item class to create items and add them to a shopping
//   cart stored in an ArrayList.
// ***************************************************************

import java.text.NumberFormat;
import java.util.Arrays;
import java.util.Scanner;

public class ShopArray {
	static public Item[] cart = new Item[1];

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);

		String itemName;
		double itemPrice;
		int quantity;
		String keepShopping = "y";
		int i = 0;
		
		do {
			System.out.println("Enter the name of the item: ");
			itemName = in.next();

			System.out.println("Enter the unit price: ");
			itemPrice = in.nextDouble();

			System.out.println("Enter the quantity: ");
			quantity = in.nextInt();

			// *** create a new item and add it to the cart
			cart[i] = new Item(itemName, itemPrice, quantity);
			// *** print the contents of the cart object using println
			i++; 
			print();
			increaseSize();
			
			System.out.println("Continue shopping (y/n)");
			keepShopping = in.next();
		} while (keepShopping.equalsIgnoreCase("y"));
		System.out.println("Thanks for shopping!");
		in.close();

	}

	public static void print() {
		double sum = 0;
		NumberFormat fmt = NumberFormat.getCurrencyInstance();
		for (int i = 0; i < cart.length; i++) {
			String name = cart[i].getName();
			double price = cart[i].getPrice();
			int quantity = cart[i].getQuantity();
			double total = price * quantity;
			System.out.println(name + "\t" + fmt.format(price) + "\t" + quantity + "\t" + fmt.format(total));
			sum += total;
		}
		System.out.println("Your total is: " + "$" + sum + "\n");
	}

	private static void increaseSize() {
		int size = cart.length + 1;
		Item[] array = Arrays.copyOf(cart, size);
		cart = array;
	}
}
