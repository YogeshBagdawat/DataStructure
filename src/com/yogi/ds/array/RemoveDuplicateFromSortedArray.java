package com.yogi.ds.array;

public class RemoveDuplicateFromSortedArray {

	public static int removeDuplicate(int[] a) {
		int n = a.length;
		boolean isb = true;
		int k = 0;
		int j = 0;
		for (int i = 0; i < a.length - 1; i++) {
			if (a[i] != a[i+1]) {
				a[j++] = a[i];
			}
			/*
			 * int j = i + 1; if (a[i] == a[j]) { while (a[i] == a[j] && j < a.length - 1) {
			 * j++; n--; } if (isb) { k = i + 1; isb = false; a[k] = a[j]; }else { k++; a[k]
			 * = a[j-1]; } i = j - 1; }
			 */
		}
		a[j++] = a[n-1];
		return j;
	}

	public static void main(String[] args) {
		int[] a = new int[] {2,2,2,2};
		int j = removeDuplicate(a);

		for (int i = 0; i < j; i++) {
			System.out.println(a[i]);
		}
	}
}
