package com.yogi.ds.queue;

class LinkedList {
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

	Node front;
	Node rear;

	public void push(int data) {
		Node temp = new Node(data);
		if (this.size() == 0) {
			front = rear = temp;
		} else {
			rear.next = temp;
			rear = rear.next;
		}
	}

	public void pushEnd(int data) {

	}

	public int pop() {
		if(this.size() != 0){
			int el = front.data;
			front = front.next;
			return el;
		}
		return -1;
	}

	public int popFromFIFO() {
		return -1;
	}

	public int front() {
		return front.data;
	}

	public int rear() {
		return rear.data;
	}

	public int size() {
		int size = 0;
		Node temp = front;
		while (temp != null) {
			size++;
			temp = temp.next;
		}
		return size;
	}
}

public class QueuesingLinkedList {
	LinkedList list = new LinkedList();

	public static void main(String[] args) {
		QueuesingLinkedList q = new QueuesingLinkedList();
		q.enqueue(8);
		q.enqueue(9);
		q.enqueue(5);
		q.enqueue(11);
		System.out.println(q.front());
		System.out.println(q.rear());
		q.dequeue();
		System.out.println(q.front());
	}

	public void enqueue(int data) {
		list.push(data);
	}

	public int dequeue() {
		return list.pop();
	}

	public int front() {
		return list.front();
	}

	public int rear() {
		return list.rear();
	}
}
