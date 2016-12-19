
// ***************************************************************
//   Shop.java
//
//   Uses the Item class to create items and add them to a shopping
//   cart stored in an ArrayList.
// ***************************************************************

import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Scanner;

public class ShopArrayList {
	static public ArrayList<Item> cart = new ArrayList<Item>();

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);

		String itemName;
		double itemPrice;
		int quantity;
		String keepShopping = "y";

		do {
			System.out.println("Enter the name of the item: ");
			itemName = in.next();

			System.out.println("Enter the unit price: ");
			itemPrice = in.nextDouble();

			System.out.println("Enter the quantity: ");
			quantity = in.nextInt();

			// *** create a new item and add it to the cart
			cart.add(new Item(itemName, itemPrice, quantity));
			// *** print the contents of the cart object using println
			print();
			System.out.println("Continue shopping (y/n)");
			keepShopping = in.next();
		} while (keepShopping.equalsIgnoreCase("y"));
		System.out.println("Thanks for shopping!");
		in.close();

	}

	public static void print() {
		double sum = 0;
		NumberFormat fmt = NumberFormat.getCurrencyInstance();
		for (int i = 0; i < cart.size(); i++) {
			String name = cart.get(i).getName();
			double price = cart.get(i).getPrice();
			int quantity = cart.get(i).getQuantity();
			double total = price * quantity;

			System.out.println(name + "\t" + fmt.format(price) + "\t" + quantity + "\t" + fmt.format(total));
			sum += total;
		}
		System.out.println("Your total is: " + "$" + sum + "\n");
	}
}
