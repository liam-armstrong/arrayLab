import java.util.*;

public class ReversingArray {
	private static Scanner in = new Scanner(System.in);
	private static int[] arr;
	private static int[] arrcopy;// copy for printing only
	private static int count;

	public static void main(String[] args) {
		Create();
		Print();
	}

	public static void Create() {
		System.out.println("Enter a number");
		count = in.nextInt();
		arr = new int[count];
		System.out.println("Enter " + count + " numbers");
		for (int i = 0; i < count; i++) {
			arr[i] = in.nextInt();
			in.nextLine();
		}
		arrcopy = Arrays.copyOf(arr, arr.length);
	}

	public static void Print() {
		System.out.println("Swappping...");
		Swap();
		System.out.println("\n   Pre-Swap    Post-Swap");
		System.out.println("---------------------------");
		for (int i = 0; i < count; i++) {
			System.out.print("      " + arrcopy[i] + "     ");
			System.out.println("      " + arr[i] + "     ");
		}
	}

	public static void Swap() {
		int swapCount = count;
		int swap = count - 1;
		if (count % 2 != 0) {
			swapCount--;
		}
		swapCount = swapCount / 2;
		for (int i = 0; i < swapCount; i++) {
			int temp = arr[swap];
			arr[swap] = arr[i];
			arr[i] = temp;
			swap--;
		}
	}
}
