package junxiao.leetcode.string_to_integer_atoi;

import java.util.*;

public class Solution {
	public int myAtoi(String str) {
        int L = str.length();
        if (L==0) return 0;
		long res = 0;
		//first skip beginning space
		//then process +/- sign
		//then res += c*10
		//we need check the overflow use int.max, then return max/min
		//once we hit non digital char, return current value
		int ind = 0;
		int sign = 1;
		while (ind < L && str.charAt(ind)==' '){
			++ind;
		}
		if (ind < L && str.charAt(ind)=='+'){
			++ind;
		}
		else if (ind < L && str.charAt(ind)=='-'){
			sign = -1;
			++ind;
		}
		
		while (ind<L){
			char c = str.charAt(ind);
			if (c<'0' || c>'9'){
				return (int) (sign*res);
			}
			res = res*10 + c-'0';
			if ((sign*res) > Integer.MAX_VALUE) {
			    return Integer.MAX_VALUE;
			    }
			else if ((sign*res) < Integer.MIN_VALUE) {
				return Integer.MIN_VALUE;
			}
			++ind;
		}
		res = res * sign;
		return (int) res;	
	}
}
