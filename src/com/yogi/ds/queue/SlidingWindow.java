package com.yogi.ds.queue;

import java.util.Deque;
import java.util.LinkedList;

public class SlidingWindow {

	public static void main(String[] args) {
		int arr[]={12, 1, 78, 90, 89, 57, 56};
        int k=3;
        printMax(arr, k);
	}

	public static void printMax(int[] a, int k) {
		Deque<Integer> q = new LinkedList<>();
		int n = a.length;
		int i = 0;
		for (; i < k; i++) {
			while (!q.isEmpty() && a[i] >= a[q.peekLast()]) {
				q.removeLast();
			}
			q.addLast(i);
		}
		for (; i < n; i++) {
			System.out.println(a[q.peek()]);
			while (!q.isEmpty() && i - k  >= q.peek()) {
				q.remove();
			}
			while (!q.isEmpty() && a[i] >= a[q.peekLast()]) {
				q.removeLast();
			}
			q.addLast(i);
		}
			System.out.println(a[q.poll()]);
			q.clear();
	}
}
