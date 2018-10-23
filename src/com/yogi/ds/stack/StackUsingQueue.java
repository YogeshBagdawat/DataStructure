package com.yogi.ds.stack;

import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

public class StackUsingQueue {

	Queue<Integer> q = new LinkedList<>();
	Queue<Integer> q1 = new LinkedList<>();

	public static void main(String[] args) {
		StackUsingQueue s = new StackUsingQueue();
		s.push(6);
		s.push(9);
		s.push(7);
		System.out.println(s.pop());
		System.out.println(s.pop());
		s.push(5);
		System.out.println(s.pop());
	}

	public void push(int data) {
		q.add(data);
	}

	public int pop() {
		
		while (q.size()  > 1) {
			int s = q.remove();
			q1.add(s);
		}
		int el = q.remove();
		q.addAll(q1);
		return el;
	}

	public int size() {
		return q.size();
	}

	public boolean isEmpty() {
		return q.isEmpty();
	}
}
