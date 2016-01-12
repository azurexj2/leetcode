package junxiao.leetcode.divide_two_integers;

import java.util.*;

public class Solution {
	public int divide(int dividend, int divisor) {
		if (divisor==0) return Integer.MAX_VALUE;
		if (dividend==Integer.MIN_VALUE && divisor==-1) return Integer.MAX_VALUE;
		long a = dividend;
		a = Math.abs(a);
		long b = divisor;
		b = Math.abs(b);
		int res = 0;
		while (a>=b){
			long tmp = b;
			int count = 1;
			while(a>=tmp){
				res += count;
				a -= tmp;
				tmp <<= 1;
				count <<= 1;
			}
		}
		
		int sign = ((dividend>>31) ^ (divisor>>31))>0 ? -1 : 1;
		return sign*res;
		
	}
}
