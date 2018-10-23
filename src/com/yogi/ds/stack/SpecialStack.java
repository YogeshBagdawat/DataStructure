package com.yogi.ds.stack;

import java.util.Stack;

public class SpecialStack extends Stack<Integer> {

	Stack<Integer> min = new Stack<>();

	public static void main(String[] args) {
		SpecialStack s = new SpecialStack();
		s.push(18);
		s.push(19);
		s.push(29);
		s.push(15);
		s.push(16);
		s.pop();
		s.pop();
		System.out.println(s.getMin());
		// s.push(5);
		System.out.println(s.getMin());
	}

	public void push(int data) {
		super.push(data);
		if (min.isEmpty() || min.peek() > data) {
			min.push(data);
		}
	}

	public Integer pop() {
		int a = super.pop();
		return a == min.peek() ? min.pop() : a;
	}

	public Integer getMin() {
		return min.peek();
	}
}
