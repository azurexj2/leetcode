package junxiao.leetcode.implement_strstr;

import java.util.*;
public class Solution {
    public int strStr(String haystack, String needle) {
        int lenS = haystack.length();
        int lenP = needle.length();
        if (lenP==0) return 0;
        if (lenS==0) return -1;
        int indS = 0, indP =0;
        int[] next = nextTable(needle);
        while(indS < lenS && indP < lenP){
            if (indP==-1 || haystack.charAt(indS)==needle.charAt(indP)){
                ++indS;
                ++indP;
            }
            else{
                indP = next[indP];
            }
        }
        if (indP==lenP)
            return indS-indP;
        return -1;
    }
    private int[] nextTable(String str){
        // here next[i] is the max prefix that match suffix in str[0,i-1];
        // a  b  c  a e
        // -1 0  0  0 1
        int len = str.length();
        int[] next = new int[len];
        if (len==0) return next;
        next[0] = -1;
        if (len==1) return next;
        next[1] = 0;
        int prefix = 0;
        int suffix = 2;
        while(suffix<len){
            /*
            three case:
            1. str[prefix]==str[suffix-1]: next[suffix]=next[suffix-1]+1, ++prefix, ++suffix,
            2. not equal, but prefix>0, we may have substring in [0,prefix-1] match suffix of [0,suffix-1]
                then we check: let prefix=next[prefix], check str[prefix] and str[suffix-1], next[suffix] = prefix+1
                note that, when k'=next[prefix]>0, means [0,k'] may match[suffix-1-k, suffix-1] 
            3. not equal, prefix==0, next[suffix]=0;++suffix
            */
            if (str.charAt(prefix)==str.charAt(suffix-1)){
                ++prefix;
                next[suffix]=prefix;
                ++suffix;
            }
            else if (prefix>0){
                prefix=next[prefix];
            }
            else {
                //prefix==0
                next[suffix]=0;
                ++suffix;
            }
        }
        return next;
    }
}
public class Solution2 {
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
