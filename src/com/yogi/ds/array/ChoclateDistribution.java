package com.yogi.ds.array;

import java.util.Arrays;

public class ChoclateDistribution {

	public static int minDiffrence(int[] a, int m) {
		Arrays.sort(a);
		if (m == 0 || a.length == 0)
			return 0;
		if (a.length < m)
			return -1;
		int diff = Integer.MAX_VALUE;
		for (int i = 0; i < a.length && m + i <= a.length; i++) {
			if (diff >= a[m + i - 1] - a[i]) {
				diff = a[m + i - 1] - a[i];
			}
		}
		return diff;
	}

	public static void main(String[] args) {
		int a[] = { 12, 4, 7, 9, 2, 23, 25, 41, 30, 40, 28, 42, 30, 44, 48, 43, 50 };

		int m = 7;
		System.out.println(minDiffrence(a, m));
	}
}
