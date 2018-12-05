import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
 * Requirement:
 * You are required to implement all methods recursively.
 * You receive a zero if there is any occurrence of a loop (e.g., for, while).  
 */
public class RecursiveMethods {
	/**
	 * Return an array storing the first n numbers in a Fibonacci sequence. The
	 * Fibonacci starts with the first two numbers being 1 and 1, then starting from
	 * the 3rd number, it is the sum of the previous two numbers. You can assume
	 * that n is positive. e.g., fibArray(5) returns an array {1, 1, 2, 3, 5}.
	 * 
	 * @param n
	 *            the first n Fibonacci numbers
	 * @return an array representing the first n Fibonacci numbers
	 * 
	 *         You are forbidden to use the fibList method below to solve this
	 *         problem.
	 * 
	 *         Requirement: You are required to implement all methods recursively.
	 *         You receive a zero if there is any occurrence of a loop (e.g., for,
	 *         while).
	 */
	public int[] fibArray(int n) {
		/* Your Task. */
		int array[] = new int[n];

		if (n == 1) { // only runs if n starts at 1
			array[0] = 1;
			return array;
		} else if (n == 2) { // if fib arraay is two
			array[0] = 1;
			array[1] = 1;
			return array;
		}
		int temp[] = fibArray(n - 1);
		System.arraycopy(temp, 0, array, 0, temp.length); // copies temp into array so theres one extra spot
		array[n - 1] = array[n - 2] + array[n - 3]; // does the fib thing
		return array;
	}

	/**
	 * Return a list storing the first n numbers in a Fibonacci sequence. The
	 * Fibonacci starts with the first two numbers being 1 and 1, then starting from
	 * the 3rd number, it is the sum of the previous two numbers. You can assume
	 * that n is positive. e.g., fibList(5) returns a list {1, 1, 2, 3, 5}.
	 * 
	 * @param n
	 *            the first n Fibonacci numbers
	 * @return a list representing the first n Fibonacci numbers
	 * 
	 *         You are forbidden to use the fibArray method above to solve this
	 *         problem.
	 * 
	 *         Requirement: You are required to implement all methods recursively.
	 *         You receive a zero if there is any occurrence of a loop (e.g., for,
	 *         while).
	 */
	public List<Integer> fibList(int n) {
		/* Your Task. */
		List<Integer> list = new ArrayList<Integer>();
		if (n == 1) {
			list.add(1);
			return list;
		} else if (n == 2) {
			list.add(1);
			list.add(1);
			return list;
		}
		list.addAll(fibList(n - 1));

		int size = list.size();
		list.add(list.get(size - 1) + list.get(size - 2));

		return list;
	}

	/**
	 * Return whether or not an array represents the first n numbers in a Fibonacci
	 * sequence. The Fibonacci starts with the first two numbers being 1 and 1, then
	 * starting from the 3rd number, it is the sum of the previous two numbers. The
	 * array may or may not be empty. e.g., isFibArray({1, 2}) returns false and
	 * isFibArray({1, 1, 2, 3, 5, 8}) returns true.
	 * 
	 * @param a
	 *            an array
	 * @return true if input array a (of length n) represents the first n Fibonacci
	 *         numbers; false otherwise.
	 * 
	 *         You are forbidden to use the isFibList method below to solve this
	 *         problem.
	 * 
	 *         Requirement: You are required to implement all methods recursively.
	 *         You receive a zero if there is any occurrence of a loop (e.g., for,
	 *         while).
	 */
	public boolean isFibArray(int[] a) {
		/* Your Task. */
		if (a.length == 2) {
			return a[0] == 1 && a[1] == 1;
		} else if (a.length == 1) {
			return a[0] == 1;
		}
		if (a[a.length - 1] != a[a.length - 2] + a[a.length - 3]) {
			return false;
		}
		int temp[] = Arrays.copyOfRange(a, 0, a.length - 1);
		return isFibArray(temp);
	}

	/**
	 * Return whether or not a list represents the first n numbers in a Fibonacci
	 * sequence. The Fibonacci starts with the first two numbers being 1 and 1, then
	 * starting from the 3rd number, it is the sum of the previous two numbers. The
	 * array may or may not be empty. e.g., isFibList({1, 2}) returns false and
	 * isFibList({1, 1, 2, 3, 5, 8}) returns true.
	 * 
	 * @param a
	 *            an array
	 * @return true if input list a (of length n) represents the first n Fibonacci
	 *         numbers; false otherwise.
	 * 
	 *         You are forbidden to use the isFibArray method above to solve this
	 *         problem.
	 * 
	 *         Requirement: You are required to implement all methods recursively.
	 *         You receive a zero if there is any occurrence of a loop (e.g., for,
	 *         while).
	 */
	public boolean isFibList(List<Integer> list) {
		/* Your Task. */
		if (list.size() == 1) {
			return list.get(0) == 1;
		} else if (list.size() == 2) {
			return list.get(0) == 1 && list.get(1) == 1;
		}
		if (list.get(list.size() - 1) != list.get(list.size() - 2) + list.get(list.size() - 3)) {
			return false;
		}

		list.remove(list.size() - 1);
		return isFibList(list);
	}

	/**
	 * Given a sorted input array a, return a sorted array of size a.length + 1,
	 * consisting of all elements of array a and integer i.
	 * 
	 * @param a
	 *            an array that is sorted in a non-descending order
	 * @param i
	 *            an integer
	 * @return a sorted array of size a.length + 1, consisting of all elements of
	 *         array a and integer i. e.g., insertIntoSortedArray({1, 2, 4, 5}, 3)
	 *         returns a sorted array {1, 2, 3, 4, 5}.
	 * 
	 *         You are forbidden to use the insertIntoSortedList method below to
	 *         solve this problem.
	 * 
	 *         Requirement: You are required to implement all methods recursively.
	 *         You receive a zero if there is any occurrence of a loop (e.g., for,
	 *         while).
	 */
	public int[] insertIntoSortedArray(int[] a, int i) {
		/* Your Task. */
		if (a.length == 0) { // if null array
			int temp[] = new int[1];
			temp[0] = i;
			return temp;
		}
		int lastIndex = a.length - 1;
		int length = a.length;
		int newArray[];

		if (a[lastIndex] > i) { // if i is greater, then delete last element and check next one from the right

			newArray = new int[length - 1]; // create a new array to store array a but without the last element
											// because we know i < last element of a
			System.arraycopy(a, 0, newArray, 0, length - 1); // copies new stuff into array but minus last element
			int[] returnedarray = new int[length + 1];
			newArray = insertIntoSortedArray(newArray, i); // stores all the same numbers with added i somewhere in
															// array
			System.arraycopy(newArray, 0, returnedarray, 0, newArray.length); // copies into into returnedarray
			returnedarray[length] = a[lastIndex]; // add the last element deleted earlier
			return returnedarray;
		} else { // i is greater or equal to last element then put it in and return;
			newArray = new int[length + 1];
			System.arraycopy(a, 0, newArray, 0, length);
			newArray[length] = i;
			return newArray;
		}
	}

	/**
	 * Given a sorted input list, return a sorted list of size list.size() + 1,
	 * consisting of all elements of the input list and integer i.
	 * 
	 * @param list
	 *            a list that is sorted in a non-descending order
	 * @param i
	 *            an integer
	 * @return a sorted list of size list.size() + 1, consisting of all elements of
	 *         the input list and integer i. e.g., insertIntoSortedList({1, 2, 4,
	 *         5}, 3) returns a sorted list {1, 2, 3, 4, 5}.
	 * 
	 *         You are forbidden to use the insertIntoSortedArray method above to
	 *         solve this problem.
	 * 
	 *         Requirement: You are required to implement all methods recursively.
	 *         You receive a zero if there is any occurrence of a loop (e.g., for,
	 *         while).
	 */
	public List<Integer> insertIntoSortedList(List<Integer> list, int i) {
		/* Your Task. */
		if (list.isEmpty()) {
			list.add(i);
			return list;
		}

		int lastIndex = list.size() - 1;

		if (list.get(lastIndex) > i) {
			int temp = list.get(lastIndex);
			list.remove(lastIndex);
			list = insertIntoSortedList(list, i);
			list.add(temp);
			return list;
		} else {
			list.add(i);
			return list;
		}
	}

	/**
	 * Given two sorted arrays left and right, return a sorted array of size
	 * left.length + right.length, consisting of all elements of arrays left and
	 * right.
	 * 
	 * @param left
	 *            a sorted array
	 * @param right
	 *            a sorted array
	 * @return a sorted array of size left.length + right.length, consisting of all
	 *         elements of arrays left and right. e.g., mergeSortedArrays({1, 3, 5,
	 *         7}, {2, 4, 6, 8}) returns a sorted array {1, 2, 3, 4, 5, 6, 7, 8}.
	 * 
	 *         You are forbidden to use the mergeSortedLists method below to solve
	 *         this problem.
	 * 
	 *         Requirement: You are required to implement all methods recursively.
	 *         You receive a zero if there is any occurrence of a loop (e.g., for,
	 *         while).
	 */
	public int[] mergeSortedArrays(int[] left, int[] right) {
		/* Your Task. */
		int ls = left.length; // left size
		int rs = right.length; // right size
		int transfer[] = new int[ls + rs];

		if (ls == 0 && rs == 0) {
			return left;
		} else if (ls == 0 && rs != 0) {
			return right;
		} else if (ls != 0 && rs == 0) {
			return left;
		}

		if (left[0] > right[0]) {
			transfer[0] = right[0];
			int newRight[] = new int[rs - 1];
			System.arraycopy(right, 1, newRight, 0, rs - 1);
			int temp[] = mergeSortedArrays(left, newRight);
			System.arraycopy(temp, 0, transfer, 1, temp.length);
		} else if (right[0] > left[0]) {
			transfer[0] = left[0];
			int newLeft[] = new int[ls - 1];
			System.arraycopy(left, 1, newLeft, 0, ls - 1);
			int temp[] = mergeSortedArrays(newLeft, right);
			System.arraycopy(temp, 0, transfer, 1, temp.length);
		} else if (left[0] == right[0]) {
			transfer[0] = left[0];
			transfer[1] = right[0];
			int newLeft[] = new int[ls - 1];
			int newRight[] = new int[rs - 1];
			System.arraycopy(left, 1, newLeft, 0, ls - 1);
			System.arraycopy(right, 1, newRight, 0, rs - 1);
			int temp[] = mergeSortedArrays(newLeft, newRight);
			System.arraycopy(temp, 0, transfer, 1, temp.length);
		}
		return transfer;
	}

	/**
	 * Given two sorted lists left and right, return a sorted list of size
	 * left.size() + right.size(), consisting of all elements of lists left and
	 * right.
	 * 
	 * @param left
	 *            a sorted list
	 * @param right
	 *            a sorted list
	 * @return a sorted list of size left.size() + right.size(), consisting of all
	 *         elements of lists left and right. e.g., mergeSortedLists({1, 3, 5,
	 *         7}, {2, 4, 6, 8}) returns a sorted list {1, 2, 3, 4, 5, 6, 7, 8}.
	 * 
	 *         You are forbidden to use the mergeSortedArrays method above to solve
	 *         this problem.
	 * 
	 *         Requirement: You are required to implement all methods recursively.
	 *         You receive a zero if there is any occurrence of a loop (e.g., for,
	 *         while).
	 */
	public List<Integer> mergeSortedLists(List<Integer> left, List<Integer> right) {
		List<Integer> temp = new ArrayList<Integer>();
		if (left.isEmpty() && right.isEmpty()) { // if both empty just return
			return temp;
		} else if (left.isEmpty() && !right.isEmpty()) { // left empty right isnt
			return right;
		} else if (right.isEmpty() && !left.isEmpty()) { // right empty left isnt
			return left;
		}

		if (left.get(0) > right.get(0)) { // if left greater add right side
			temp.add(right.get(0));
			right.remove(0);
			temp.addAll(mergeSortedLists(left, right));
		} else if (right.get(0) > left.get(0)) { // if right side greater, add left sid
			temp.add(left.get(0));
			left.remove(0);
			temp.addAll(mergeSortedLists(left, right));
		} else if (right.get(0) == left.get(0)) { // if both sides same
			temp.add(left.get(0));
			temp.add(right.get(0));
			right.remove(0);
			left.remove(0);
			temp.addAll(mergeSortedLists(left, right));
		}
		return temp;
	}
}
