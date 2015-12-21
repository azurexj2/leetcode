package junxiao.leetcode.reverse_integer;

import java.util.*;

public class Solution {
	public int reverse(int x) {
		//need deal with overflow
		long res = 0;
		while (x!=0) {
			res = res*10 + (x % 10);
			x /= 10;
		}
		if (res < Integer.MIN_VALUE || res > Integer.MAX_VALUE) {
			return 0;
		}
		return (int) res;
		
		
	}
}
