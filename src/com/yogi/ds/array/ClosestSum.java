package com.yogi.ds.array;

public class ClosestSum {

	public static void closestSumInArray(int[] a, int x) {
		int left = 0;
		int right = 0;
		int minDiff = Integer.MAX_VALUE;
		int l = 0;
		int r = a.length - 1;
		while (l < r) {
			if (Math.abs(x - a[l] - a[r]) < minDiff) {
				left = a[l];
				right = a[r];
				minDiff = Math.abs(x - a[l] - a[r]);
			}
			if (a[l] + a[r] < x) {
				l++;
			} else {
				r--;
			}
		}
		System.out.println(left + " " + right);
	}

	public static void main(String[] args) {
		int arr[] = { 10, 22, 28, 29, 30, 40 }, x = 54;
		int n = arr.length;
		closestSumInArray(arr, x);
	}
}
