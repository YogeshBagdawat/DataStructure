package com.yogi.ds.stack;

/*
 * 1. Scan the infix expression from left to right.
 * 2. If the scanned character is an operand, output it.
 * 3. Else,…..
 * 	3.1 If the precedence of the scanned operator is greater than 
 * 	the precedence of the operator in the stack(or the stack is empty), push it.…..
 * 	3.2 Else, Pop the operator from the stack until the precedence of 
 * 		the scanned operator is less-equal to the precedence of 
 * 		the operator residing on the top of the stack. Push the scanned operator to the stack.
 * 4. If the scanned character is an ‘(‘, push it to the stack.
 * 5. If the scanned character is an ‘)’, pop and output from the stack until an ‘(‘ is encountered.
 * 6. Repeat steps 2-6 until infix expression is scanned.
 * 7. Pop and output from the stack until it is not empty.
 */
public class InfixToPostfix {

	/*
	 * private enum Operator { PLUS('+'), MINUS('-'), MULTIPLICATION('*'),
	 * DIVISION('/'), XOR('^'); char c;
	 * 
	 * Operator(char c) { this.c = c; }
	 * 
	 * private char getSign() { return c; }
	 * 
	 * }
	 */

	public static void main(String[] args) {
		//InfixToPostfix infixToPostfix = new InfixToPostfix();
		String exp = "a+b*(c^d-e)^(f+g*h)-i";// "10+2*8-3";//
		System.out.println((new InfixToPostfix()).infixToPostfix(exp));
	}

	public StringBuilder infixToPostfix(String infix) {
		StringBuilder postfix = new StringBuilder();
		//Stack<Character> stack = new Stack<>();
		StackUsingLinkedList<Character> stack = new StackUsingLinkedList<>();
		//StackUsingLinkedList stack = new StackUsingLinkedList();
		for (int i = 0; i < infix.length(); i++) {
			char c = infix.charAt(i);
			if (Character.isLetterOrDigit(c)) {
				postfix.append(c);
			} else if (c == '(') {
				stack.push(c);
			} else if (c == ')') {
				while (!stack.isEmpty() && stack.peek() != '(') {
					postfix.append((char)stack.pop());
					if (!stack.isEmpty() && stack.peek() != '(') {
						System.out.println("invalid expression");
					} else {
						//stack.pop();
					}
				}
				stack.pop();
			} else {
				if (!stack.isEmpty() && getPriority((char)stack.peek()) < getPriority(c)) {
					stack.push(c);
				} else {
					while (!stack.isEmpty() && getPriority((char)stack.peek()) >= getPriority(c)) {
						postfix.append((char)stack.pop());
					}
					stack.push(c);
				}
			}
		}
		while(!stack.isEmpty()) {
			postfix.append((char)stack.pop());
		}
		return postfix;

	}

	public int getPriority(char c) {
		int priority = -1;
		switch (c) {
		case '+':
		case '-':
			priority = 1;
			break;
		case '*':
		case '/':
			priority = 2;
			break;
		case '^':
			priority = 3;
			break;
		default:
			break;
		}
		return priority;
	}

}
