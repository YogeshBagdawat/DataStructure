package com.yogi.ds.array;

import java.util.ArrayList;

public class LeadersInArray {

	public Integer[] printleaders(int[] a) {
		int leaders = Integer.MIN_VALUE;
		ArrayList<Integer> al = new ArrayList<>();
		for (int i = a.length - 1; i > 0; i--) {
			if (a[i] > leaders) {
				leaders = a[i];
				al.add(a[i]);
				System.out.println(leaders);
			}
		}
		return al.toArray(new Integer[al.size()]);
	}
}
