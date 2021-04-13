package com.jiuzhang.p1;

public class LongestPalindromeSubString {
	/**
	 * https://www.lintcode.com/problem/longest-palindromic-substring/
	 * 
	 * https://www.jiuzhang.com/solution/longest-palindromic-substring/
	 * 
	 * Given a string S, find the longest palindromic substring in S. You may assume that the maximum length of S is 1000, and there exists one unique longest palindromic substring.
	 * 
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		//String src = "abcdzdcab";//case 1
		String src = "abcddcab"; //case 2
		
		String longestPal = longestPalindromeForString2(src);
		
		System.out.println("Lonegest sub palindrome is " + longestPal);
    }
	
	static String longestPalindromeForString(String src) {
		String longestPal = null;
		int longPalLen = 0;
		int srcLen = src.length();
		//No need to go through all of them
		for(int i = 0; i < srcLen; i++) {
			System.out.println("============>index  = " + i);
			String tmpSrc = LongestPalindromeSubString.longestPalindromeAt(src, i);
			System.out.println("palstr  = " + tmpSrc);
			if(tmpSrc != null) {
				if(tmpSrc.length() > longPalLen) {
					longestPal = tmpSrc;
					longPalLen = tmpSrc.length();
				}
			}
		}
		
		return longestPal;
	}
	
	static String longestPalindromeAt(String src, int index) {
		
		if(src == null || index < 0 || index > src.length())
			return null;
		
		int srcLen = src.length();
		
		//case 1: acbca 
		int k = 0;
		boolean found = false;
		boolean bounded = false;
		int left = index;
		int right = index;
		while(left >= 0 && right <= srcLen -1 && !found && !bounded) {
			left = index -k;
			right = index + k;
			//find difference, stop
			if(src.charAt(left) != src.charAt(right))
				found = true;
			//go to the boundary, stop
			else if(left <= 0 || right >= srcLen -1)
				bounded = true;
			//otherwise, add one more char
			else if(left > 0 && right < srcLen -1)
				k++;
		}
		
		System.out.println("k = " + k);
		String palStr1 = null;
		System.out.println("left=" + left);
		System.out.println("right=" + right);
		if(found) {
			System.out.println("found difference..");
			palStr1 = src.substring(left + 1, right);
		}
		else {
			//go to boundary
			System.out.println("go to boundary");
			
			palStr1 = src.substring(left, right + 1);
		}
		System.out.println("palStr1 = " + palStr1);
		
//		//case 2: acca
		String palStr2 = null;
		int m = 0;
		found = false;
		bounded = false;
		left = index;
		right = index + 1;
		while(left >= 0 && right <= srcLen -1 && !found && !bounded) {
			left = index -m;
			right = index + 1 + m;
			//find difference, stop
			if(src.charAt(left) != src.charAt(right))
				found = true;
			//go to the boundary, stop
			else if(left <= 0 || right >= srcLen -1)
				bounded = true;
			//otherwise, add one more char
			else if(left > 0 && right < srcLen -1)
				m++;
		}
		
		System.out.println("m = " + m);
		System.out.println("left=" + left);
		System.out.println("right=" + right);
		System.out.println("found=" + found);
		System.out.println("bounded=" + bounded);
		if(found) {
			System.out.println("found difference..");
			palStr2 = src.substring(left + 1, right);
		}
		else {
			//go to boundary
			System.out.println("go to boundary");
			if(right < srcLen)
				palStr2 = src.substring(left, right + 1);
			else
				palStr2 = src.substring(left, right); //this is the case when left is at the right end.
		}
		System.out.println("palStr2 = " + palStr2);
		
		if(palStr2 != null && palStr1 != null) {
			if(palStr2.length() > palStr1.length())
				return palStr2;
			else
				return palStr1;
		}
		else if(palStr2 != null)
			return palStr2;
		else
			return palStr1;

	}
	
	static String longestPalindromeForString2(String src) {
		String longestPal = null;
		int longPalLen = 0;
		int srcLen = src.length();
		//No need to go through all of them
		for(int i = 0; i < srcLen - 1; i++) {
			System.out.println("============>index  = " + i);
			String tmpSrc1 = LongestPalindromeSubString.findLongestPalFrom(src, i, i);
			String tmpSrc2 = LongestPalindromeSubString.findLongestPalFrom(src, i, i + 1);
			System.out.println("tmpSrc1  = " + tmpSrc1);
			System.out.println("tmpSrc2  = " + tmpSrc2);
			if(tmpSrc1 != null) {
				if(tmpSrc1.length() > longPalLen) {
					longestPal = tmpSrc1;
					longPalLen = tmpSrc1.length();
				}
			}
			if(tmpSrc2 != null) {
				if(tmpSrc2.length() > longPalLen) {
					longestPal = tmpSrc2;
					longPalLen = tmpSrc2.length();
				}
			}
		}
		
		return longestPal;
	}
	
	/**
	 * Best solution
	 * @param str
	 * @param left
	 * @param right
	 * @return
	 */
	static String findLongestPalFrom(String str, int left, int right) {
		while(left >= 0 && right < str.length() && str.charAt(left) == str.charAt(right)) {
			left --;
			right ++;
		}

		System.out.println("left=" + left);
		System.out.println("right=" + right);
		System.out.println("==>return " + str.substring(left + 1, right));
		//The chars should be [left + 1, right -1]
		//do one step back
		return str.substring(left + 1, right);
		
	}
}
