package junxiao.leetcode.palindrome_number;

import java.util.*;

public class Solution {
	public boolean isPalindrome(int x) {
		if (x<0) return false;
		int p = 1;
		int num = x;
		while (num/10 != 0) {
			p *= 10;
			num /= 10;
		}
		
		while (x!=0){
			int l = x/p;
			int r = x%10;
			if (l != r) return false;
			x = x%p;
			x = x/10;
			p /= 100;
		}
		return true;
	}
}
