package junxiao.leetcode.add_binary;

import java.util.*;

public class Solution {
	public String addBinary(String a, String b){
		if (a==null || a.length()==0) return b;
		if (b==null || b.length()==0) return a;
		int len_a = a.length();
		int len_b = b.length();
		if (len_a < len_b) return addBinary(b,a);
		//now len_a >= len_b
		StringBuilder res = new StringBuilder();
		int carry = 0;
		for (int i = 0; i<len_a;++i){
			int sum = a.charAt(len_a-1-i) - '0'
					+ (len_b-1-i>=0?b.charAt(len_b-1-i) - '0':0)
					+ carry;
			carry = sum<=1 ? 0 : 1;
			res.append(sum%2);
		}
		if (carry==1)
			res.append(1);
		return res.reverse().toString();
	}
}
