package com.yogi.ds.array;

public class MajorityElement {

	public int majorityElement(int[] a) {
		int majIndex = 0;
		int count = 1;
		for (int i = 1; i < a.length; i++) {
			if (a[majIndex] == a[i]) {
				count++;
			} else {
				count--;
			}
			if (count == 0) {
				majIndex = i;
				count = 1;
			}
		}
		count = 0;
		for (int i = 0; i < a.length; i++) {
			if (a[majIndex] == a[i]) {
				count++;
			}
		}
		if (count > a.length / 2) {
			return a[majIndex];
		} else {
			return -1;
		}
	}
}
