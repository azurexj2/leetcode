package junxiao.leetcode.implement_strstr;

import java.util.*;

public class Solution {
	public int strStr(String haystack, String needle){
		if (haystack==null || needle==null) return -1;
		if (needle.length()==0) return 0;
		if (haystack.length()==0) return -1;
		int m = haystack.length();
		int n = needle.length();
		for (int i=0; i < m-n+1; ++i){
			for (int j=0;j<n;++j){
				if (haystack.charAt(i+j)!=needle.charAt(j)){
					break;
				}
				else if (j==n-1){
					return i;
				}
			}
			
		}
		return -1;
	}
}
