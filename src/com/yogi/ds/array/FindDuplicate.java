package com.yogi.ds.array;

/*
 * Given an array of n elements which contains elements from 0 to n-1, with any of these numbers appearing any number of times. 
 * Find these repeating numbers in O(n) and using only constant memory space.
 * 
 * if range is more when elements are not limited to a range
 * than using hash map key is array value and value as frequency
 */
public class FindDuplicate {

	public static void printDuplicateArray(int[] a) {
		int n = a.length;
		for (int i = 0; i < n; i++) {
			int index = a[i] % n;
			a[index] += n;
		}
		for (int i = 0; i < n; i++) {
			if ((a[i]/n) > 1) {
				System.out.println(i + " ");
			}
		}
	}
	public static void main(String[] args) {
		int arr[] = {1, 6, 3, 1, 3, 6, 6};
		printDuplicateArray(arr);
	}
}
