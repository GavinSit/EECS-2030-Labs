import java.util.ArrayList;
import java.util.List;

/*
 * Requirement:
 * You are required to implement all methods recursively.
 * You receive a zero if there is any occurrence of a loop (e.g., for, while).  
 */
public class RecursiveMethods {
	/**
	 * Return an array storing the first n numbers in a Fibonacci sequence.
	 * The Fibonacci starts with the first two numbers being 1 and 1, then 
	 * starting from the 3rd number, it is the sum of the previous two numbers.  
	 * You can assume that n is positive.
	 * e.g., fibArray(5) returns an array {1, 1, 2, 3, 5}.
	 * @param n the first n Fibonacci numbers 
	 * @return an array representing the first n Fibonacci numbers
	 * 
	 * You are forbidden to use the fibList method below to solve this problem.
	 * 
	 * Requirement:
	 * You are required to implement all methods recursively.
	 * You receive a zero if there is any occurrence of a loop (e.g., for, while). 
	 */
	public int[] fibArray(int n) {
		/* Your Task. */
		return null;
	} 
	
	/**
	 * Return a list storing the first n numbers in a Fibonacci sequence.
	 * The Fibonacci starts with the first two numbers being 1 and 1, then 
	 * starting from the 3rd number, it is the sum of the previous two numbers.  
	 * You can assume that n is positive.
	 * e.g., fibList(5) returns a list {1, 1, 2, 3, 5}.
	 * @param n the first n Fibonacci numbers 
	 * @return a list representing the first n Fibonacci numbers
	 * 
	 * You are forbidden to use the fibArray method above to solve this problem.
	 * 
	 * Requirement:
	 * You are required to implement all methods recursively.
	 * You receive a zero if there is any occurrence of a loop (e.g., for, while).
	 */
	public List<Integer> fibList(int n) {
		/* Your Task. */
		return null;
	}
	
	/**
	 * Return whether or not an array represents the first n numbers in a Fibonacci sequence.
	 * The Fibonacci starts with the first two numbers being 1 and 1, then 
	 * starting from the 3rd number, it is the sum of the previous two numbers.  
	 * The array may or may not be empty.
	 * e.g., isFibArray({1, 2}) returns false and isFibArray({1, 1, 2, 3, 5, 8}) returns true.
	 * @param a an array
	 * @return true if input array a (of length n) represents the first n Fibonacci numbers; false otherwise.
	 * 
	 * You are forbidden to use the isFibList method below to solve this problem.
	 * 
	 * Requirement:
	 * You are required to implement all methods recursively.
	 * You receive a zero if there is any occurrence of a loop (e.g., for, while).
	 */
	public boolean isFibArray(int[] a) {
		/* Your Task. */
		return false;
	}
	
	/**
	 * Return whether or not a list represents the first n numbers in a Fibonacci sequence.
	 * The Fibonacci starts with the first two numbers being 1 and 1, then 
	 * starting from the 3rd number, it is the sum of the previous two numbers.  
	 * The array may or may not be empty.
	 * e.g., isFibList({1, 2}) returns false and isFibList({1, 1, 2, 3, 5, 8}) returns true.
	 * @param a an array
	 * @return true if input list a (of length n) represents the first n Fibonacci numbers; false otherwise.
	 * 
	 * You are forbidden to use the isFibArray method above to solve this problem.
	 * 
	 * Requirement:
	 * You are required to implement all methods recursively.
	 * You receive a zero if there is any occurrence of a loop (e.g., for, while).
	 */
	public boolean isFibList(List<Integer> list) {
		/* Your Task. */
		return false;
	}
	
	/**
	 * Given a sorted input array a, return a sorted array of size a.length + 1, 
	 * consisting of all elements of array a and integer i.
	 * @param a an array that is sorted in a non-descending order
	 * @param i an integer
	 * @return a sorted array of size a.length + 1, consisting of all elements of array a and integer i.
	 * e.g., insertIntoSortedArray({1, 2, 4, 5}, 3) returns a sorted array {1, 2, 3, 4, 5}.
	 * 
	 * You are forbidden to use the insertIntoSortedList method below to solve this problem.
	 * 
	 * Requirement:
	 * You are required to implement all methods recursively.
	 * You receive a zero if there is any occurrence of a loop (e.g., for, while).
	 */
	public int[] insertIntoSortedArray(int[] a, int i) {
		/* Your Task. */
		return null;
	}
	
	
	/**
	 * Given a sorted input list, return a sorted list of size list.size() + 1, 
	 * consisting of all elements of the input list and integer i.
	 * @param list a list that is sorted in a non-descending order
	 * @param i an integer
	 * @return a sorted list of size list.size() + 1, consisting of all elements of the input list and integer i.
	 * e.g., insertIntoSortedList({1, 2, 4, 5}, 3) returns a sorted list {1, 2, 3, 4, 5}.
	 * 
	 * You are forbidden to use the insertIntoSortedArray method above to solve this problem.
	 * 
	 * Requirement:
	 * You are required to implement all methods recursively.
	 * You receive a zero if there is any occurrence of a loop (e.g., for, while).
	 */
	public List<Integer> insertIntoSortedList(List<Integer> list, int i) {
		/* Your Task. */
		return null;
	}
	
	/**
	 * Given two sorted arrays left and right, 
	 * return a sorted array of size left.length + right.length, 
	 * consisting of all elements of arrays left and right.
	 * @param left a sorted array
	 * @param right a sorted array 
	 * @return a sorted array of size left.length + right.length, consisting of all elements of arrays left and right.
	 * e.g., mergeSortedArrays({1, 3, 5, 7}, {2, 4, 6, 8}) returns a sorted array {1, 2, 3, 4, 5, 6, 7, 8}.
	 * 
	 * You are forbidden to use the mergeSortedLists method below to solve this problem.
	 * 
	 * Requirement:
	 * You are required to implement all methods recursively.
	 * You receive a zero if there is any occurrence of a loop (e.g., for, while).
	 */
	public int[] mergeSortedArrays(int[] left, int[] right) {
		/* Your Task. */
		return null;
	}
	
	/**
	 * Given two sorted lists left and right, 
	 * return a sorted list of size left.size() + right.size(), 
	 * consisting of all elements of lists left and right.
	 * @param left a sorted list
	 * @param right a sorted list 
	 * @return a sorted list of size left.size() + right.size(), consisting of all elements of lists left and right.
	 * e.g., mergeSortedLists({1, 3, 5, 7}, {2, 4, 6, 8}) returns a sorted list {1, 2, 3, 4, 5, 6, 7, 8}.
	 * 
	 * You are forbidden to use the mergeSortedArrays method above to solve this problem.
	 * 
	 * Requirement:
	 * You are required to implement all methods recursively.
	 * You receive a zero if there is any occurrence of a loop (e.g., for, while).
	 */
	public List<Integer> mergeSortedLists(List<Integer> left, List<Integer> right) {
		return null;
	}
}
