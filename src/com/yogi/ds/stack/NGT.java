package com.yogi.ds.stack;


class Stack {
	class Node {
		int data;
		Node next;

		Node() {
			this.data = 0;
			this.next = null;
		}

		Node(int data) {
			this.data = data;
			this.next = null;
		}
	}

	Node head;

	public void push(int data) {
		Node temp = new Node(data);
		if (head == null) {
			head = temp;
		} else {
			temp.next = head;
			head = temp;
		}
	}

	public int pop() {
		if (head != null) {
			int d = head.data;
			head = head.next;
			return d;
		} else {
			System.out.println("stack is empty");
			return -1;
		}
	}

	public int peek() {
		if (head != null) {
			return head.data;
		} else {
			System.out.println("stack is empty");
			return -1;
		}
	}

	public boolean isEmpty() {
		if (head == null) {
			return true;
		}
		return false;
	}
}

public class NGT {
	public static void main(String[] args) {
		NGT ng = new NGT();
		ng.ngt(new int[]{ 11, 13, 21, 3 });
	}

	public void ngt(int[] a) {
		Stack stack = new Stack();
		//Map<Integer, Integer> map = new HashMap<>();
		for (int i = 1; i < a.length; i++) {
			stack.push(a[i-1]);
			int nex = a[i];
			while (!stack.isEmpty() && stack.peek() < nex) {
				System.out.println(stack.peek() + " next = " + nex);
				//map.put(stack.peek(), nex);
				stack.pop();
			}
		}
		while (!stack.isEmpty()) {
			//map.put(stack.pop(), -1);
			System.out.println(stack.pop() + " next = " + -1);
		}
		//map.put(a[a.length-1], -1);
		System.out.println(a[a.length - 1] + " next = " + -1);
		/*Set<Integer> set = map.keySet();
		for (Integer el : set) {
			System.out.println(el + "next" + map.get(el));
		}*/
	}
}
