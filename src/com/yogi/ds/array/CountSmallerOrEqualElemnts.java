package com.yogi.ds.array;

public class CountSmallerOrEqualElemnts {

	public int countSmallerOrEqual(int[] a, int key, int low, int high) {
		int mid = low + (high - low) / 2;
		if (low < high) {
			if (a[mid] == key) {
				while(a[mid+1]==key) {
					mid++;
				}
				return mid + 1;
			} else if (a[mid] < key) {
				return countSmallerOrEqual(a, key, mid + 1, high);
			} else if (a[mid] > key) {
				return countSmallerOrEqual(a, key, low, mid);
			}
		} else {
			if (mid >= a.length) {
				return a.length;
			}
			if(mid<=0) {
				return 0;
			}
			while (a[mid] > key) {
				mid--;
			}
		}

		return mid + 1;
	}
}
