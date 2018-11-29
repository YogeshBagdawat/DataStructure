package com.yogi.ds.string;

public class Palindrom {

	public boolean checkPalindrom(String s) {

		/*
		 * String r = new StringBuffer(s).reverse().toString(); if(r.equals(s)) { return
		 * true; } return false;
		 */
		int l = 0;
		int h = s.length() - 1;
		while (l < h) {
			if (s.charAt(l) != s.charAt(h)) {
				return false;
			}
			l++;
			h--;
		}
		return true;
	}
}
