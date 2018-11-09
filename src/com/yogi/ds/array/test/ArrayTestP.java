package com.yogi.ds.array.test;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.Test;
import com.yogi.ds.array.ArraysDemo;
import com.yogi.ds.array.CountSmallerOrEqualElemnts;
import com.yogi.ds.array.LeadersInArray;
import com.yogi.ds.array.MajorityElement;
import com.yogi.ds.array.MaximumPathInTwoArrays;
import com.yogi.ds.array.MinimumDistanceBetween2Elements;

public class ArrayTestP {

	@Test
	public void test() {
		ArraysDemo<Integer> arr = new ArraysDemo<>(2, 3, 4, 5, 7);
		assertEquals(2, arr.find(4));
		assertEquals(true, arr.delete(4));
		assertEquals(false, arr.delete(10));
		arr.insert(11);
	}

	@Test
	public void testCount() {
		CountSmallerOrEqualElemnts cs = new CountSmallerOrEqualElemnts();
		int[] a = new int[] { 1, 2, 4, 5, 5, 5, 8, 10 };
		assertEquals(6, cs.countSmallerOrEqual(a, 5, 0, a.length));
	}

	@Test
	public void minimumTest() {
		MinimumDistanceBetween2Elements min = new MinimumDistanceBetween2Elements();
		assertEquals(1, min.minimumDistanceBetween2Elements(new int[] { 2, 5, 3, 5, 4, 4, 2, 3 }, 3, 2));
		assertEquals(1, min.minimumDistanceBetween2Elements(new int[] { 1, 2 }, 1, 2));
		assertEquals(2, min.minimumDistanceBetween2Elements(new int[] { 3, 4, 5 }, 3, 5));
		assertEquals(4, min.minimumDistanceBetween2Elements(new int[] { 3, 5, 4, 2, 6, 5, 6, 6, 5, 4, 8, 3 }, 3, 6));
	}

	@Test
	public void leaderTest() {
		assertArrayEquals(new Integer[] { 2, 5, 17 },
				new LeadersInArray().printleaders(new int[] { 16, 17, 4, 3, 5, 2 }), "integer array");
	}

	@Test
	public void majorityTest() {
		MajorityElement m = new MajorityElement();
		assertEquals(4, m.majorityElement(new int[] { 3, 3, 4, 2, 4, 4, 2, 4, 4 }));
		assertEquals(-1, m.majorityElement(new int[] { 3, 3, 4, 2, 4, 4, 2, 4 }));
		assertEquals(1, m.majorityElement(new int[] { 1, 1, 2, 1, 3, 5, 1 }));
		assertEquals(2, m.majorityElement(new int[] { 2, 2, 3, 5, 2, 2, 6 }));
		assertEquals(-1, m.majorityElement(new int[] { 1, 3, 3, 1, 2 }));
		assertEquals(2, m.majorityElement(new int[] { 2, 2, 2, 2, 5, 5, 2, 3, 3 }));
	}

	@Test
	public void maxPath() {
		MaximumPathInTwoArrays m = new MaximumPathInTwoArrays();
		assertEquals(35, m.maxPath(new int[] { 2, 3, 7, 10, 12 }, new int[] { 1, 5, 7, 8 }));
		assertEquals(22, m.maxPath(new int[] { 10, 12 }, new int[] { 5, 7, 9 }));
		assertEquals(122,
				m.maxPath(new int[] { 2, 3, 7, 10, 12, 15, 30, 34 }, new int[] { 1, 5, 7, 8, 10, 15, 16, 19 }));

	}
}
