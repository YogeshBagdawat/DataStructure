package com.yogi.ds.stack;

class LinkedList<T> {
	class Node {
		T data;
		Node next;

		Node() {
			this.data = null;
			this.next = null;
		}

		Node(T data) {
			this.data = data;
			this.next = null;
		}
	}

	Node head;

	public boolean insert(T data) {
		Node temp = new Node(data);
		if (head == null) {
			head = temp;
		} else {
			temp.next = head;
			head = temp;
		}
		return true;
	}

	public T  delete() {
		T el = null;
		if (head == null) {
			System.out.println("list is empty");
			return el;
		} else {
			el = head.data;
			head = head.next;
			return el;
		}
	}

	public  T peek() {
		T el = null;
		if (head == null) {
			System.out.println("list is empty");
			return el;
		} else {
			return head.data;
		}
	}

	public int size() {
		int result = 0;
		Node temp = head;
		if (head == null) {
			return result;
		} else {
			while (temp != null) {
				temp = temp.next;
				result++;
			}
		}
		return result;
	}

	public boolean isEmpty() {
		if (head == null) {
			return true;
		}
		return false;
	}

	public void print() {
		Node temp = head;
		if (head == null) {
			System.out.println("list is empty");
		} else {
			while (temp != null) {
				System.out.println(temp.data);
				temp = temp.next;
			}
		}
	}
}

public class StackUsingLinkedList<T> {
	LinkedList<T> li = new LinkedList<>();

	public boolean push(T data) {
		return li.insert(data);
	}

	public T pop() {
		return li.delete();
	}

	public T peek() {
		return li.peek();
	}

	public boolean isEmpty() {
		return li.isEmpty();
	}

	public boolean isFull() {
		return false;
	}

	public int size() {
		return li.size();
	}
}
