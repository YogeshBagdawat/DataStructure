package com.yogi.ds.stack;

public class StockSpan {

	public static void main(String[] args) {
		 int price[] = {10, 4, 5, 90, 120, 80};
	        int n = price.length;
	        int s[]=new int[n];
	         
	        // Fill the span values in array S[]
	        s = (new StockSpan()).calculateSpan(price);
	        for(int a : s){
	        	System.out.println(a);
	        }
	        
	}

	public int[] calculateSpan(int[] el) {
		int p = el.length;
		int[] span = new int[el.length];
		Stack1 stack = new Stack1();
		stack.push(0);
		span[0] = 1;

		for (int i = 1; i < el.length; i++) {
			while (!stack.isEmpty() && el[stack.peek()] < el[i]) {
				stack.pop();
			}
			span[i] = stack.isEmpty() ? i + 1 : i - stack.peek();
			stack.push(i);
		}

		return span;
	}

}
