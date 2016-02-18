package junxiao.leetcode.number_of_1_bits;

import java.util.*;

public class Solution {
	public int hammingWeight(int n){
		int count = 0;
		while(n!=0){
			count++;
			n = n &(n-1);
		}
		return count;
	}
}
