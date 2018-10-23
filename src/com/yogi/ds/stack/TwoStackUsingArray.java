package com.yogi.ds.stack;

class FirstStack {
	int i = 0;

	public void push1(int data) {
		if (i >= 0 && i < TwoStackUsingArray.arr.length-1) {
			TwoStackUsingArray.arr[i++] = data;
		} else {
			System.out.println("stack full");
		}
	}

	public int pop1() {
		if(i > 0 && i < TwoStackUsingArray.arr.length-1) {
			return TwoStackUsingArray.arr[--i];
		} else{
			System.out.println("stack is empty");
			return -1;
		}
	}

}

class SecondStack {
	int j = 9;

	public void push2(int data) {
		if (j >= 0 && j < TwoStackUsingArray.arr.length) {
			TwoStackUsingArray.arr[j--] = data;
		} else {
			System.out.println("stack full");
		}
	}

	public int pop2() {
		if(j > 0 && j < TwoStackUsingArray.arr.length-1) {
			return TwoStackUsingArray.arr[++j];
		} else{
			System.out.println("stack is empty");
			return -1;
		}
	}
}

public class TwoStackUsingArray {
	static int[] arr = new int[10];

	public static void main(String[] args) {
		FirstStack stack1 = new FirstStack();
		SecondStack stack2 = new SecondStack();
		stack1.push1(5);
		stack2.push2(9);
		stack1.push1(2);
		//stack1.push1(3);
		stack2.push2(7);
		System.out.println("pop from one " + stack1.pop1());
		System.out.println("pop from one " + stack1.pop1());
		System.out.println("pop from one " + stack1.pop1());
		System.out.println("pop from two " + stack2.pop2());
		/*System.out.println("pop from two " + stack2.pop2());
		System.out.println("pop from two " + stack2.pop2());*/
	}
}
