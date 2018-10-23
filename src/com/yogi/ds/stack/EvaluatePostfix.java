package com.yogi.ds.stack;

import java.util.Stack;

public class EvaluatePostfix {

	public static void main(String[] args) {
		System.out.println(new EvaluatePostfix().evaluatePostfix("231*+9-"));
	}

	public int evaluatePostfix(String postfix) {
		//StackUsingLinkedList stack = new StackUsingLinkedList();
		Stack<Integer> stack = new Stack<>();
		for (int i = 0; i < postfix.length(); i++) {
			char c = postfix.charAt(i);
			if (Character.isDigit(c)) {
				int a = Character.getNumericValue(c);
				stack.push(a);
				
			} else {
				 int val1 = stack.pop();
	             int val2 = stack.pop();
	                 
				switch (c) {
				case '+':
					stack.push(val1+val2);
					
					break;
				case '-':
					stack.push((val2-val1));
					break;
				case '*':
					stack.push((val2*val1));
					break;
				case '/':
					stack.push((val2/val1));
					break;
				default:
					break;
				}
			}
			
		}
		return stack.pop();
	}

}
