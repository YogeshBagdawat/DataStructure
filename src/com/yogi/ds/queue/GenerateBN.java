package com.yogi.ds.queue;

import java.util.Formatter;
import java.util.LinkedList;
import java.util.Queue;

public class GenerateBN {

	public static void main(String[] args) {
		GenerateBN gnb = new GenerateBN();
		gnb.generateBN(10);
	}

	public void generateBN(int n) {
		Formatter formate = new Formatter();
		StringBuilder s = new StringBuilder("1");
		Queue<String> q = new LinkedList<>();
		q.offer(s.toString());
		for (int i = 0; i < n; i++) {
			String p = q.peek();
			q.offer(p + "0");
			q.offer(p + "1");
			System.out.println(q.poll());
		}
	}
}
