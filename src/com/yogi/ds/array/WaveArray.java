package com.yogi.ds.array;

public class WaveArray {

	public static void sortInWaveForm(int[] a) {
		// int size = a.length;
		for (int i = 0; i < a.length;) {
			if (i > 0 && a[i - 1] > a[i]) {
				a[i] = a[i] + a[i - 1];
				a[i - 1] = a[i] - a[i - 1];
				a[i] = a[i] - a[i - 1];
			}
			if (i < a.length - 1 && a[i + 1] > a[i]) {
				a[i] = a[i] + a[i + 1];
				a[i + 1] = a[i] - a[i + 1];
				a[i] = a[i] - a[i + 1];
			}
			i += 2;
		}
		for (int i : a) {
			System.out.print(i + " ");
		}
	}

	public static void main(String[] args) {
		sortInWaveForm(new int[] { 10, 90, 49, 2, 1, 5, 23 });
	}
}
