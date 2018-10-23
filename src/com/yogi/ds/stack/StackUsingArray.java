package com.yogi.ds.stack;
/*
 * stack implementation using array
 * supported features push pop and peek and isEmpty
 * 0 not allowed as element 
 */
public class StackUsingArray {
	int[] arr = new int[10];
	int i = 0;
	
	/*
	 *  push an element in an array 
	 *  @param is element of type int 
	 *  return boolean whether
	 *  element is pushed or not
	 *  if stack is full than say stack overflow 
	 */
	
	public boolean push(int element) {
		if (!isFull()) {
			arr[i++] = element;
			return true;
		}
		System.out.println("stack is full");
		return false;
	}
	
	/*
	 * pop return top element from stack or say stack underflow 
	 * and remove element from top
	 */
	
	public int pop() {
		if(!isEmpty()) {
			return arr[--i];
		}
		System.out.println("stack is empty");
		return 0;
	}
	/*
	 * return top element from stack but would not remove from top of stack
	 */
	public int peek() {
		if(!isEmpty()) {
			int p = i-1;
			return arr[p];
		}
		System.out.println("stack is empty");
		return 0;
	}
	/*
	 * return whether stack is empty or not
	 */
	public boolean isEmpty() {
		if(i == 0) {
			return true;
		}
		return false;
	}
	
	/*
	 * return whether stack is full or not
	 */
	
	public boolean isFull() {
		if(i == arr.length) {
			return true;
		}
		return false;
	}
	
	public int size(){
		return i;
	}
}
