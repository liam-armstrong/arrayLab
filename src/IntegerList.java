
// ****************************************************************
// IntegerList.java
//
// Define an IntegerList class with methods to create, fill,
// sort, and search in a list of integers.
// 
// ****************************************************************

public class IntegerList {
	int[] list; // values in the list

	public IntegerList(int size)// create a list of the given size
	{
		list = new int[size];
	}

	// fill array with integers between 1 and 100, inclusive
	public void randomize() {
		for (int i = 0; i < list.length; i++) {
			list[i] = (int) (Math.random() * 100) + 1;
		}
	}

	public void print() // print array elements with indices
	{
		for (int i = 0; i < list.length; i++) {
			System.out.println(i + ":\t" + list[i]);
		}
	}

	// return the index of the first occurrence of target in the list.
	// return -1 if target does not appear in the list
	public int search(int target) {
		int location = -1;
		for (int i = 0; i < list.length && location == -1; i++) {
			if (list[i] == target) {
				location = i;
			}
		}
		return location;
	}

	// sort the list into ascending order using the selection sort algorithm
	public void increasingSort() {
		int minIndex;
		for (int i = 0; i < list.length - 1; i++) {
			// find smallest element in list starting at location i
			minIndex = i;
			for (int j = i + 1; j < list.length; j++) {
				if (list[j] < list[minIndex]) {
					minIndex = j;
				}
			}
			// swap list[i] with smallest element
			int temp = list[i];
			list[i] = list[minIndex];
			list[minIndex] = temp;
		}
	}

	public void decreasingSort() {
		int maxIndex;
		for (int i = 0; i < list.length - 1; i++) {
			// find largest element in list starting at location i
			maxIndex = i;
			for (int j = i + 1; j < list.length; j++) {
				if (list[j] > list[maxIndex]) {
					maxIndex = j;
				}
			}
			// swap list[i] with smallest element
			int temp = list[i];
			list[i] = list[maxIndex];
			list[maxIndex] = temp;
		}
	}

	public void replaceFirst(int oldVal, int newVal) {
		int firstLoc = -1;
		for (int i = 0; i < list.length; i++) {
			if (list[i] == oldVal) {
				firstLoc = i;
				break;
			}
		}
		if (firstLoc != -1) {
			list[firstLoc] = newVal;
		} else {
			System.out.println("Not in list");
		}
	}

	public void replaceAll(int oldVal, int newVal) {
		for (int i = 0; i < list.length; i++) {
			if (list[i] == oldVal) {
				list[i] = newVal;
			}
		}
	}
}