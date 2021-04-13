package com.jiuzhang.p1;

public class ValidPalindrome {
	public static void main(String[] args) {
		String str = "abba";
		boolean isParlindrome = ValidPalindrome.thirdWay(str);
		System.out.println(str + " is parlindrome: " + isParlindrome);
		
		str = "aacaa";
		isParlindrome = ValidPalindrome.thirdWay(str);
		System.out.println(str + " is parlindrome: " + isParlindrome);
		
		str = "A man, a plan, a canal: Panama";
		isParlindrome = ValidPalindrome.thirdWay(str);
		System.out.println(str + " is parlindrome: " + isParlindrome);
		
		//should be false
		str = "race a car";
		isParlindrome = ValidPalindrome.thirdWay(str);
		System.out.println(str + " is parlindrome: " + isParlindrome);
    }
	
	/**
	 * check from head and trail.
	 * @param str
	 * @return
	 */
	static boolean checkFromTwoSides(String str) {
		if(str == null)
			return true;
		
		char[] charArray = str.toCharArray();
		int len = charArray.length;
		int i=0;
		int j=len-1;
		for(; i <= j; i++, j--) {
			if(charArray[i] != charArray[j])
				return false;
		}
		
		return true;
	}
	
	/**
	 * check from middle
	 * 
	 * @param str
	 * @return
	 */
	static boolean validParlindromeFromMiddle(String str) {
		if(str == null)
			return true;
		
		char[] charArray = str.toCharArray();
		int len = str.length();
		int mid = len / 2;
		int odd = len % 2;
		if(odd == 1) {
			for(int i = 0; i <= mid; i++) {
				if(charArray[mid - i] != charArray[mid + i])
					return false;
			}
		}
		else {
			for(int i = 1; i <= mid; i++) {
				if(charArray[mid -i] != charArray[mid - 1 + i])
					return false;
			}
		}
		return true;
	}
	
	/*
	 * consider case --
	 * "A man, a plan, a canal: Panama"
	 * it return true;
	 */
	static boolean thirdWay(String str) {
		
		if(str == null)
			return true;
		
		str = str.toLowerCase();
		int len = str.length();
		int h = 0;
		int t = len -1;
		while(h<=t) {
			while(!isChar(str.charAt(h)) && h<=t) {
				h++;
			}
			
			while(!isChar(str.charAt(t)) && h<=t) {
				t--;
			}
			if(h>=t)
				return true;
			
			if(str.charAt(h) != str.charAt(t))
				return false;
			
			h++;
			t--;
		}
		
		return true;
	}
	
	static boolean isChar(char c) {
		return c >= 'a' && c <= 'z';
	}
}
