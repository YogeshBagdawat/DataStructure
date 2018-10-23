package com.yogi.ds.stack;

class StackWithMiddle {
	boolean isMiddleUpdate = true;
	class Node {
		int data;
		Node next;
		Node prev;

		Node() {
			this.data = 0;
			this.next = null;
			this.prev = null;
		}

		Node(int data) {
			this.data = data;
			this.next = null;
			this.prev = null;
		}
	}

	Node head;
	Node middle;
	private boolean isMiddleUpdatePop = true;

	public int getMiddle() {
		return middle.data;
	}

	public void deleteMiddle() {
		Node temp = middle.next;
		Node temp1 = middle.prev;
		temp.prev = middle.prev;
		temp1.next = middle.next;
		Node temp3 = middle;
		temp3.next = temp3.prev = null;
		middle = middle.prev;
	}

	public void push(int data) {
		Node temp = new Node(data);
		if (head == null) {
			head = temp;
			middle = temp;
		} else if (middle.prev == null) {
			temp.next = head;
			head.prev = temp;
			head = temp;
			middle.prev = temp;;
		} else {
			//temp.prev = head.prev;
			temp.next = head;
			head.prev = temp;
			head = temp;
			if(isMiddleUpdate) {
				middle = middle.prev;
				isMiddleUpdate = false ; 
			} else {
				isMiddleUpdate = true;
			}
		}
	}

	public int pop() {
		if (head != null) {
			int d = head.data;
			head = head.next;
			if(isMiddleUpdatePop ) {
				middle = middle.next;
				isMiddleUpdatePop = false ; 
			} else {
				isMiddleUpdatePop = true;
			}
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

	public void display() {
		display(head);
	}

	public void display(Node head) {
		if (head == null) {
			return;
		}
		System.out.println(head.data);
		display(head.next);
	}

	public int size() {
		return size(head);
	}

	public int size(Node temp) {
		if (temp == null) {
			return 0;
		}
		return 1 + size(temp.next);
	}
}

public class OperationOnMidddleElement {

	StackWithMiddle s = new StackWithMiddle();

	public static void main(String[] args) {
		StackWithMiddle s = new StackWithMiddle();
		s.push(6);
		s.push(9);
		s.push(11);
		s.push(15);
		s.push(18);
		System.out.println(s.pop());
		System.out.println(s.size());
		System.out.println(s.middle.data);
	}
}
