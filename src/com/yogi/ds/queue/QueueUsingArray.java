package com.yogi.ds.queue;

public class QueueUsingArray {

	class Queue {
		int capacity = 100;
		int rear = 0;
		int front = 0;
		int[] a = new int[100];

		public void enqueue(int data) {
			a[rear++] = data;
		}

		public int dequeue() {
			a[front] = -1;
			return a[front++];
		}

		public int front() {
			if (a[front] == 0) {
				return -1;
			}
			return a[front];
		}

		public int rear() {
			if (a[rear - 1] == -1) {
				return -1;
			}
			return a[rear - 1];
		}
	}

	public static void main(String[] args) {
		Queue q = (new QueueUsingArray()).new Queue();
		q.enqueue(8);
		q.enqueue(9);
		q.enqueue(5);
		q.enqueue(11);
		System.out.println(q.front());
		q.dequeue();
		/*q.dequeue();
		q.dequeue();*/
		System.out.println(q.front());
		System.out.println(q.rear());
		/*
		 * System.out.println(q.dequeue()); System.out.println(q.dequeue());
		 * System.out.println(q.dequeue()); System.out.println(q.front());
		 * System.out.println(q.rear());
		 */
	}

}
