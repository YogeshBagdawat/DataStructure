package com.yogi.ds.heap;

public class Heap {

	public static void main(String[] args) {
		int a[] = { 4, 1, 3, 2, 16, 9, 10, 14, 8, 7 };
		Heap heap = new Heap();
		heap.buildMaxHeap(a);
		heap.heapSort(a);
		for (int i : a) {
			System.out.println(i);
		}
	}

	private void heapSort(int[] a) {
		int n = a.length;
		int heapSize = n;
		for (int i = n - 1; i > 0; i--) {
			swap(a, 0, i);
			heapSize = heapSize - 1;
			maxHeapify(a, heapSize, 0);
		}
	}

	public void buildMaxHeap(int[] a) {
		int heapSize = a.length;
		for (int i = a.length / 2 - 1; i >= 0; i--) {
			maxHeapify(a, heapSize, i);
		}
	}
/**
 * to maintain max heap property
 * @param a array 
 * @param heapsize
 * @param i
 * @return void
 */
	public void maxHeapify(int[] a, int heapSize, int i) {
		int l = left(i);
		int r = right(i);
		int largest = i;
		if (l < heapSize && a[l] > a[i]) {
			largest = l;
		}
		if (r < heapSize && a[r] > a[largest]) {
			largest = r;
		}
		if (largest != i) {
			swap(a, i, largest);
			maxHeapify(a, heapSize, largest);
		}
	}

	public void swap(int[] a, int i, int largest) {
		int temp = a[i];
		a[i] = a[largest];
		a[largest] = temp;
	}

	public int right(int i) {
		return 2 * i + 2;
	}

	public int left(int i) {
		return 2 * i + 1;
	}
}
