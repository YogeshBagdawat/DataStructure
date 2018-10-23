package com.yogi.ds.queue;

import com.yogi.ds.heap.Heap;

public class PriorityQueueImpl {

	Heap heap = new Heap();

	public static void main(String[] args) {

	}

	private int maximum(int[] a) {
		return a[0];
	}

	private int maxExtract(int[] a) {
		int n = a.length;
		if (n == 0) {
			System.out.println("cant extract queue is  empty");
			return -1;
		}
		int el = a[0];
		a[0] = a[n - 1];
		n--;
		heap.maxHeapify(a, n, 0);
		return el;
	}

	private void increaseValue(int[] a, int i, int val) {
		if (val < a[i]) {
			return;
		}
		int n = a.length;
		a[i] = val;
		while (i > 0 && a[i / 2] < a[i]) {
			heap.swap(a, i / 2, i);
			i /= 2;
		}
	}

	private void insertValue(int[] a, int val) {
		int n = a.length;
		n += 1;
		a[n] = -1;
		increaseValue(a, n, val);
	}
}
