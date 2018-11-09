package com.yogi.ds.array;

public class MaximumPathInTwoArrays {

	int sum1;
	int sum2;

	public int maxPath(int[] a, int[] b) {

		sum1 = 0;
		sum2 = 0;
		int i = 0;
		int j = 0;
		while (i < a.length && j < b.length) {
			if (a[i] < b[j]) {
				sum1 += a[i++];
			} else if (a[i] > b[j]) {
				sum2 += b[j++];
			} else {
				sum1 += a[i++];
				sum2 += b[j++];
				changePath();
			}

		}
		while (i < a.length) {
			sum1 += a[i++];
		}
		while (j < b.length) {
			sum2 += b[j++];
		}
		changePath();
		return sum1;
	}

	public void changePath() {
		sum2 = sum1 > sum2 ? sum1 : (sum1 = sum2);
	}

	/*
	 * public static void main(String[] args) { MaximumPathInTwoArrays m = new
	 * MaximumPathInTwoArrays(); System.out.println(m.maxPath(new int[] { 2, 3, 7,
	 * 10, 12 }, new int[] { 1, 5, 7, 8 })); System.out.println(m.maxPath(new int[]
	 * { 10, 12 }, new int[] { 5, 7, 9 })); System.out.println( m.maxPath(new int[]
	 * { 2, 3, 7, 10, 12, 15, 30, 34 }, new int[] { 1, 5, 7, 8, 10, 15, 16, 19 }));
	 * // System.out.println(m.maxPath(new int[] { 2, 3, 7, 10, 12 }, new int[] { 1,
	 * 5, // 7, 8 })); }
	 */
}
