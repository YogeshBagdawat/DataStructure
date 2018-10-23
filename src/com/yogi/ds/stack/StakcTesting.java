package com.yogi.ds.stack;

import java.util.Formatter;
import java.util.Map;

//import org.apache.commons.collections4.map.HashedMap;

public class StakcTesting {
	
	public static void main(String[] args) {
		/*Map<String, String> ma = new HashedMap<>();
		ma.put("yogi", "kh");
		ma.put("shrai", "ma");
		ma.put("yosh", "makh");
		Formatter formatter = new Formatter();
		
		for(String s : ma.keySet()){
			System.out.print(s+ma.get(s));
		}
		for(String s : ma.keySet()){
			formatter.format(" %s %s", s, ma.get(s));
		}
		System.out.println(formatter);
		System.out.println(formatter.toString());
		*/
		StackUsingLinkedList<Integer> sua = new StackUsingLinkedList<>();
		System.out.println(sua.push(5));
		System.out.println(sua.push(8));
		System.out.println(sua.push(6));
		System.out.println(sua.push(11));
		System.out.println(sua.size());
		System.out.println(sua.pop());
		System.out.println(sua.pop());
		System.out.println(sua.pop());
		System.out.println(sua.pop());
		System.out.println(sua.size());
		System.out.println(sua.peek());
		System.out.println(sua.pop());
		System.out.println(sua.size());
	}

}
