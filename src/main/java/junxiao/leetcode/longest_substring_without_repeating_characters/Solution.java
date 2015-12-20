package junxiao.leetcode.longest_substring_without_repeating_characters;

import java.util.*;

public class Solution {
	public int lengthOfLongestSubstring(String s) {
		if (s==null) return 0;
		int[] v = new int[256];
		Arrays.fill(v, -1);
		int pos = 0;
		int maxLen = 0;
		for (int i =0; i< s.length(); ++i){
			//two case
			//1. v[s[i]] >= pos, we hit the repeating in current windows, need move the pos
			//2. else, current windows are clear,
			if (v[s.charAt(i)] >= pos){
				maxLen = Math.max(maxLen, i-pos);
				pos = v[s.charAt(i)] + 1;
			}
			v[s.charAt(i)] = i;
		}
		return maxLen;
		
	}
}
