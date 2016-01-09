package junxiao.leetcode.longest_common_prefix;

import java.util.*;

public class Solution {
	public String longestCommonPrefix(String[] strs) {
		if (strs.length==0) return new String();
		if (strs.length==1) return strs[0];
		StringBuilder res = new StringBuilder();
		int ind = 0;
		while (ind<strs[0].length()) {
			char c = strs[0].charAt(ind);
			for (int i=1; i < strs.length;++i){
				if (ind>=strs[i].length() || strs[i].charAt(ind)!=c){
					return res.toString();
				}
			}
			res.append(c);
			++ind;
		}
		return res.toString();
	}
}
