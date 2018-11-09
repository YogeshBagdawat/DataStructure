package com.yogi.ds.array;


public class MaximumSumSubArray {

	public int maxSumSubbArray(int[] a) {
		int maxSoFar = 0;
		int maxEndingHere = 0;

		for (int i : a) {
			maxEndingHere = maxEndingHere + a[i];
			if (maxSoFar < maxEndingHere) {
				maxSoFar = maxEndingHere;
			}
			if (maxEndingHere < 0) {
				maxEndingHere = 0;
			}

		}
		return maxSoFar;
	}

	public int maxSubSum(int[] a, int l, int h) {
		if (l == h) {
			return a[l];
		} else {
			int m = (l + h) / 2;
			return Math.max(Math.max(maxSubSum(a, l, m), maxSubSum(a, m + 1, h)), maxCross(a, l, m, h));
		}
	}

	private int maxCross(int[] a, int l, int m, int h) {
		int leftSum = 0;
		int sum = 0;
		for (int i = m; i >= l; i--) {
			sum += a[i];
			if (sum > leftSum) {
				leftSum = sum;
			}
		}
		int rightSum = 0;
		sum = 0;
		for (int i = m + 1; i <= h; i++) {
			sum += a[i];
			if (sum > rightSum) {
				rightSum = sum;
			}
		}
		return leftSum + rightSum;
	}
}
