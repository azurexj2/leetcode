package junxiao.leetcode.jump_game;

import java.util.*;

public class Solution {
	public boolean canJump(int[] nums){
		int n = nums.length;
		int reached = 0;
		for (int i =0; i < n-1;++i){
			if (i>reached) return false;
			reached = Math.max(reached, i+nums[i]);
		}
		return reached>=n-1 ? true:false;
	}
}
