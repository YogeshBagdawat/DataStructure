package com.yogi.ds.array;

public class MinimumDistanceBetween2Elements {

	public int minimumDistanceBetween2Elements(int[] a, int x, int y) {
		int minD = Integer.MAX_VALUE;
		int prev = -1;
		for (int i = 0; i < a.length; i++) {
			if ((a[i] == x || a[i] == y) && prev == -1) {
				prev = i;
			} else if (a[i] == x || a[i] == y) {
				if (a[i] != a[prev] && i - prev < minD) {
					minD = i - prev;
					prev = i;
				} else {
					prev = i;
				}
			}
		}
		return minD;
	}
}
