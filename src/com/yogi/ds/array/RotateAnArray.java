package com.yogi.ds.array;

/*
 * a[(n - (k % n)+ m) % n
 * print left rotate array
 */
public class RotateAnArray {

	public int[] rotateAnArray(int[] a, int m) {
		int arr[] = new int[a.length];
		for (int i = 0; i < a.length; i++) {
			arr[(i + m) % a.length] = a[i];
		}
		return arr;
	}

	/*
	 * O(n) space complexity O(1)
	 */

	public void rotate(int[] a, int m) {
		int j;
		int k;
		int n = a.length;
		int temp;
		for (int i = 0; i < gcd(n, m); i++) {
			j = i;
			temp = a[i];
			while (true) {
				k = j + m;
				if (k >= n) {
					k = k - n;
				}
				if (k == i) {
					break;
				}
				a[j] = a[k];
				j = k;
			}
			a[j] = temp;
		}
	}

	private int gcd(int a, int b) {
		if (b == 0) {
			return a;
		} else {
			return gcd(b, a % b);
		}
	}
}
