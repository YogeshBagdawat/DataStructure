package com.yogi.ds.array;

public class ArraysDemo<T> {

	private T[] values;
	public int size;

	public ArraysDemo(T... values) {
		this.values = values.clone();
		this.size = values.length;
	}

	public int find(T key) {
		for (int i = 0; i < size; i++) {
			if (values[i].equals(key)) {
				return i;
			}
		}
		return -1;
	}

	public boolean delete(T key) {
		for (int i = 0; i < size; i++) {
			if (values[i].equals(key)) {
				--size;
				for (; i < size; i++) {
					values[i] = values[i + 1];
				}
				return true;
			}
		}
		return false;
	}

	public void insert(T key) {
		size++;
		values[size-1] = key;
	}

	public void print() {
		for (int i = 0; i < size; i++) {
			System.out.print(values[i] + " ");
		}
		System.out.println();
	}
}
