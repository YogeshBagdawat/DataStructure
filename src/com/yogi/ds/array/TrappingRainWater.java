package com.yogi.ds.array;

public class TrappingRainWater {

	public static int findWater(int[] a) {
		int n = a.length;
		int[] left = new int[n];
		int[] right = new int[n];
		int water = 0;
		left[0] = a[0];
		for (int i = 1; i < n; i++) {
			left[i] = left[i - 1] < a[i] ? a[i] : left[i - 1];
		}
		right[n - 1] = a[n - 1];
		for (int i = n - 2; i >= 0; i--) {
			right[i] = right[i + 1] < a[i] ? a[i] : right[i + 1];
		}
		for (int i = 0; i < n; i++) {
			water += ((left[i] < right[i]) ? (left[i] - a[i]) : (right[i] - a[i]));
		}
		return water;
	}

	public static int findWaterSpaceOptimization(int[] a) {
		int n = a.length;
		int lo = 0;
		int hi = n - 1;
		int water = 0;
		int leftMax = a[lo];
		int rightMax = a[hi];
		while (lo <= hi) {
			if (a[lo] < a[hi]) {
				if (a[lo] > leftMax) {
					leftMax = a[lo];
				} else {
					water += leftMax - a[lo];
				}
				lo++;
			} else {
				if (a[hi] > rightMax) {
					rightMax = a[hi];
				} else {
					water += rightMax - a[hi];
				}
				hi--;
			}
		}
		return water;
	}

	public static void main(String[] args) {
		int[] a = { 0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1 };
		System.out.println(findWaterSpaceOptimization(a));
	}
}
