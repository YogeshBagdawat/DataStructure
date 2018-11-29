package com.yogi.ds.string;

public class MergeTwoString {

	public static String mergeTwoString(String str1, String str2) {

		StringBuilder sb = new StringBuilder();

		int i = 0;
		int j = 0;

		while (i < str1.length() && j < str2.length()) {
			sb.append(str1.charAt(i++));
			sb.append(str2.charAt(j++));
		}

		 if (i != str1.length()) { 
	            sb.append(str1.substring(i)); 
	        } 
	        if (j != str2.length()) { 
	            sb.append(str2.substring(j)); 
	        } 
		return sb.toString();

	}

	public static void main(String[] args) 
    { 
        String s1 = "geeks"; 
        String s2 = "forgeeks"; 
        System.out.println(mergeTwoString(s1, s2)); 
    } 
}
