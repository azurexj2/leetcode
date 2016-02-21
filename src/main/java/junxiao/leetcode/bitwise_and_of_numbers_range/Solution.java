package junxiao.leetcode.bitwise_and_of_numbers_range;

import java.util.*;

public class Solution {
	public int rangeBitwiseAnd(int m, int n){
		if (m==n)return m;
		int num = m^n;
		int count = 0;
		while(num!=0){
			num = num>>>1;
			++count;
		}
		int mask = (1<< (1+count)) -1;
		mask = ~mask;
		return m & mask;
	}
}
