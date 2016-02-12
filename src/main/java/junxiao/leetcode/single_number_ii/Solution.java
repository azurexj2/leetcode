package junxiao.leetcode.single_number_ii;

import java.util.*;

public class Solution {
	public int singleNumber(int[] nums){
		int n = 0;
		for (int i=0;i<32;++i){
			int mask = 0x1<<i;
			int sum = 0;
			for (int j=0;j<nums.length;++j){
				sum += (nums[j]&mask)>0?1:0;
			}
			if (sum%3==1){
				n |= mask;
			}
		}
		return n;
	}
}
