package com.yogi.ds.array;

public class MaximumSumOfLengthOfNonOverlappingSubarray {

	public static int maxLen(int[] a, int k) {
		int i = 0;
		int totalLen = 0;
		boolean isInclude = false;
		for (i = 0; i < a.length;) {
			int len = 0;
			isInclude = false;
			while (i < a.length && a[i] <= k) {
				if (a[i] == k) {
					isInclude = true;
				}
				len++;
				i++;
			}
			while (i < a.length && a[i] > k) {
				i++;
			}
			if (isInclude) {
				totalLen += len;
			}
		}
		return totalLen;
	}
	public static void main(String[] args) { 
		  
        int arr[] = { 4, 5, 7, 1, 2, 9, 8, 4, 3, 1 }; 
        int size = arr.length; 
        int k = 4; 
        int ans = maxLen(arr, k); 
        System.out.println("Max Length :: " + ans); 
    } 

}
