package junxiao.leetcode.jump_game_ii;

import java.util.*;

public class Solution {
	public int jump(int[] nums){
		// each step form a block
		// inside current block we find the farest we can reach
		// when current block is over, ++ step, we have another block
		// [blockLeft blockRight] ... ... farest
		if (nums==null) return 0;
		int len = nums.length;
		if (len<=1) return 0;
		int step = 0;
		int farest = nums[0];
		int blockRight = nums[0];
		for (int i =1;i<len && i<=farest && farest<len-1; ++i){
			farest = Math.max(farest, nums[i]+i);
			if (farest>=len-1) return ++step;
			if (i==blockRight){
				blockRight = farest;
				++step;
			}
		}
		if (farest>=len-1)
			return step;
		return 0;
		
	}
	public int queen(int n){
		
	}
}
