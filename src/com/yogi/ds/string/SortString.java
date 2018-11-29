package com.yogi.ds.string;

import java.util.Arrays;
import java.util.Comparator;

public class SortString {

	public String sort(String str1) {
		
		/*
		 * char[] temp = str1.toCharArray(); Arrays.sort(temp);
		 */
		Character[] temp = new Character[str1.length()];
		for(int i =0 ;i<str1.length();i++) {
			temp[i] = str1.charAt(i);
		}
		Arrays.sort(temp, new Comparator<Character>() {

			@Override
			public int compare(Character c1, Character c2) {
				return Character.compare(c1, c2);
			}
		});
		 StringBuilder sb = new StringBuilder(temp.length); 
	        for (Character c : temp) 
	            sb.append(c.charValue()); 
		return sb.toString();
	}
}
