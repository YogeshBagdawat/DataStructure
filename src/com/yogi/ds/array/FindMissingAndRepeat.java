package com.yogi.ds.array;

public class FindMissingAndRepeat {

	public static void findMissingAndRepeatElement(int[] a) {
		for (int i = 0; i < a.length; i++) {
			if (a[Math.abs(a[i]) - 1] > 0) {
				a[Math.abs(a[i]) - 1] = -a[Math.abs(a[i]) - 1];
			} else {
				System.out.print("repeating element is : " + -a[i] + " ");
			}
		}

		for (int i = 0; i < a.length; i++) {
			if (a[i] > 0) {
				System.out.print("\nmissing element is : " + (i + 1));
			}
		}
	}

	public static void main(String[] args) {
		// int arr[] = { 3, 1, 3 };
		// int arr[] = { 4, 3, 6, 2, 1, 1 };
		int[] arr = { 7, 3, 4, 5, 5, 6, 2 };
		findMissingAndRepeatElement(arr);
	}
}
