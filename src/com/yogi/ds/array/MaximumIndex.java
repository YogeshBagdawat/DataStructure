package com.yogi.ds.array;

public class MaximumIndex {

	public int maxIndex(int[] a) {
		int[] lMinIndex = new int[a.length];
		int[] rMaxIndex = new int[a.length];
		int min = Integer.MIN_VALUE;
		lMinIndex[0] = a[0];
		for (int i = 1; i < a.length; i++) {
			lMinIndex[i] = min(a[i], lMinIndex[i - 1]);

		}
		int max = Integer.MAX_VALUE;
		rMaxIndex[a.length - 1] = a[a.length - 1];
		for (int i = a.length - 2; i >= 0; i--) {
			rMaxIndex[i] = max(a[i], rMaxIndex[i + 1]);
		}
		int maxDiff = -1;
		for (int i = 0, j = 0; i < a.length && j < a.length;) {
			if (lMinIndex[i] < rMaxIndex[j]) {
				maxDiff = max(maxDiff, j - i);
				j++;
			} else {
				i++;
			}
		}
		return maxDiff;
	}

	private int max(int i, int j) {
		return i > j ? i : j;
	}

	private int min(int i, int j) {
		return i > j ? j : i;
	}

	public static void main(String[] args) {
		MaximumIndex max = new MaximumIndex();
		int arr[] = { 9, 2, 3, 4, 5, 6, 7, 8, 18, 0 };
		int n = arr.length;
		int maxDiff = max.maxIndex(arr);
		System.out.println(maxDiff);
	}
}
