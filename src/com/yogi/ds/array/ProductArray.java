package com.yogi.ds.array;

import java.util.Arrays;

/*
 * Given an array arr[] of n integers, construct a Product Array prod[] (of same size) 
 * such that prod[i] is equal to the product of all the elements of arr[] except arr[i]. 
 * Solve it without division operator and in O(n).
 */

public class ProductArray {

	public static int[] productArray(int[] a) {
		int size = a.length;
		int[] prod = new int[size];
		int temp = 1;
		Arrays.fill(prod, 1);
		for (int i = 0; i < size; i++) {
			prod[i] = temp;
			temp *= a[i];
		}
		temp = 1;
		for (int i = size - 1; i >= 0; i--) {
			prod[i] *= temp;
			temp *= a[i];
		}
		return prod;
	}

	public static void main(String[] args) {
		int arr[] = { 10, 3, 5, 6, 2 };
		for (int a : productArray(arr)) {
			System.out.print(a + " ");
		}
	}
}
