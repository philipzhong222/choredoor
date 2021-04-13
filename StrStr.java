package com.jiuzhang.p1;

public class StrStr {
	
	/**
	 * https://www.lintcode.com/problem/strstr/
	 * 
	 * Returns a index to the first occurrence of target in source,
     * or -1  if target is not part of source.
     * 
     * https://www.jiuzhang.com/solution/strstr/
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		String src = "abcdabcdefg";
		String tar = "bcd";
		
		int index = StrStr.strStr(src, tar);
		System.out.println("index = " + index);
    }
	
	static int strStr(String src, String tar) {
		
		if(src == null || tar == null || src.length() < tar.length())
			return -1;
		
		int index = 0;
		int srcLen = src.length();
		int tarLen = tar.length();
		for(;index <= srcLen - tarLen; index ++) {
			boolean match = true;
			for(int k=0; k < tarLen && match; k++) {
				if(src.charAt(index + k) != tar.charAt(k))
					match = false;
			}
			if(match)
				return index;
		}
		
		
		return -1;
	}
}
