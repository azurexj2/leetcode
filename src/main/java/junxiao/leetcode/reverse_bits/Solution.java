package junxiao.leetcode.reverse_bits;

import java.util.*;

public class Solution {
	public int reverseBits(int n){
		int res = 0;
		int i = 0;
		while(n!=0){
			int mask = n & 0x1;
			res |= (mask << (31-i));
			n >>>= 1;
			++i;
		}
		return res;
	}
}
