package com.yogi.ds.string;

/*
 * 1. sort both string.
 * 2. compare both string char by char
 * 
 */
public class Anagram {

	public boolean isAnagram(char[] str1, char[] str2) {
		if (str1.length != str2.length) {
			return false;
		}
		int[] count = new int[256];
		for (int i = 0; i < str1.length && i < str2.length; i++) {
			count[str1[i]]++;
			count[str2[i]]++;
		}
		for (int i = 0; i < 256; i++) {
			if (count[i] != 0) {
				return false;
			}
		}
		return true;
	}
}
