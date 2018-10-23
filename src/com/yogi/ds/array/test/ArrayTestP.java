package com.yogi.ds.array.test;


import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.Test;
import com.yogi.ds.array.ArraysDemo;
import com.yogi.ds.array.CountSmallerOrEqualElemnts;

public class ArrayTestP {

	@Test
	public void test() {
		ArraysDemo<Integer> arr = new ArraysDemo<>(2, 3, 4, 5, 7);

		//arr.print();
		assertEquals(2, arr.find(4));
		assertEquals(true, arr.delete(4));
		//arr.print();
		assertEquals(false, arr.delete(10));
		arr.insert(11);
		//arr.print();

	}
	@Test
	public void testCount() {
		CountSmallerOrEqualElemnts cs = new CountSmallerOrEqualElemnts();
		int[] a = new int[] {1, 2, 4, 5, 5,5,8, 10};
		assertEquals(6, cs.countSmallerOrEqual(a, 5, 0, a.length));
	}
}
