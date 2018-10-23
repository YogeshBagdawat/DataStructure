package com.yogi.ds.queue;

import java.util.Stack;

public class QueueUsingStack {

	Stack<Integer> s1 = new Stack<>();
	Stack<Integer> s2 = new Stack<>();

	public static void main(String[] args) {
		QueueUsingStack q = new QueueUsingStack();
		q.enque(1);
		q.enque(2);
		q.enque(3);
		System.out.println(q.deQueue());
		System.out.println(q.deQueue());
		System.out.println(q.deQueue());
	}

	public void enque(int data) {
		s1.push(data);
	}

	public int deQueue() {
		int el = 0;
		while (s1.size() - 1 > 0) {
			s2.push(s1.pop());
		}
		el = s1.pop();
		while(!s2.isEmpty()) {
			s1.push(s2.pop());
		}
		return el;
	}

}
