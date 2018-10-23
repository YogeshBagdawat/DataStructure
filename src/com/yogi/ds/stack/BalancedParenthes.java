package com.yogi.ds.stack;

public class BalancedParenthes {

	public static void main(String[] args) {
		BalancedParenthes bal = new BalancedParenthes();
		System.out.println(bal.isBalancedParentheses("[()]{}{[()()]()}"));
	}

	public boolean isBalancedParentheses(String expr) {
		StackUsingLinkedList<Character> aul = new StackUsingLinkedList<>();
		for (int i = 0; i < expr.length(); i++) {
			char c = expr.charAt(i);
			if (c == '(' || c == '{' || c == '[') {
				aul.push(c);
			} else {
				if (c == ')' && '(' == (char) aul.peek()) {
					aul.pop();
				} else if (c == '}' && '{' == (char) aul.peek()) {
					aul.pop();
				} else if (c == ']' && '[' == (char) aul.peek()) {
					aul.pop();
				} else {
					return false;
				}
			}
		}
		if (aul.isEmpty()) {
			return true;
		}
		return false;
	}

}
