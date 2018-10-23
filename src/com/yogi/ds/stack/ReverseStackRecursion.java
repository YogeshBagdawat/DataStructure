package com.yogi.ds.stack;

class Stack1 {
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
	Node tail;

	public void push(int data) {
		Node temp = new Node(data);
		if (head == null) {
			head = temp;
		} else {
			temp.next = head;
			head = temp;
		}
	}

	public void pushEnd(int data) {
		Node temp = new Node(data);
		if (tail != null) {
			tail.next = temp;
			tail = tail.next;
		} else {
			head = temp;
			tail = temp;
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

	public void sortStack() {
		Node temp = this.head;
		while (temp != null) {
			Node temp1 = temp.next;
			while(temp1!=null){
				if(temp.data>temp1.data) {
					int d = temp.data;
					temp.data = temp1.data;
					temp1.data = d;
				}
				temp1 = temp1.next;
			}
			temp = temp.next;
		}
	}
	public void sortUsingRecursion() {
		sortUsingRecursion(head);
	}

	private void sortUsingRecursion(Node temp) {
		if(temp == null ){
			return;
		} else{
			int a = this.pop();
			sortUsingRecursion(temp.next);
			sortInsert(a);
		}
	}

	private void sortInsert(int a) {
		if(this.isEmpty()||this.peek()>a) {
			this.push(a);
		} else {
			int b = this.pop();
			sortInsert(a);
			this.push(b);
		}
	}
}

public class ReverseStackRecursion {

	static int count;

	public static void main(String[] args) {
		Stack1 stack = new Stack1();
		stack.push(30);
		stack.push(-5);
		stack.push(18);
		stack.push(14);
		stack.push(-3);
		Stack1 revStack = new Stack1();
		//stack.display();
		count = stack.size();
		ReverseStackRecursion rev = new ReverseStackRecursion();
		// rev.rev(stack);
		// stack.display();
		// revStack.display();
		//rev.sortStack(stack);
		//stack.sortStack();
		stack.sortUsingRecursion();
		stack.display();
	}

	public void rev(Stack1 stack) {
		count = count - 1;
		if (count < 0) {
			return;
		}
		int te = stack.pop();
		rev(stack);
		stack.pushEnd(te);
	}

	public void reverseStack(Stack1 stack, Stack1 revStack) {
		if (stack.isEmpty()) {
			return;
		}
		revStack.push(stack.pop());
		reverseStack(stack, revStack);
	}
}
