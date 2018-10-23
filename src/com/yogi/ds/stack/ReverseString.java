package com.yogi.ds.stack;

public class ReverseString {

	public static void main(String[] args) {
		System.out.println(new ReverseString().reverse("asdfg"));
	}
	public String reverse(String str) {
		StringBuilder revStr = new StringBuilder();
		StackUsingLinkedList<Character> stack = new StackUsingLinkedList<>();
		//Stack<Character> stack = new Stack<>();
		for(int i=0;i<str.length();i++){
			stack.push(str.charAt(i));
		}
		while(!stack.isEmpty()){
			revStr = revStr.append(stack.pop());
		}
		return revStr.toString();
	}
}
