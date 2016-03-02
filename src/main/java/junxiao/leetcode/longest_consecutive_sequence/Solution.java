package junxiao.leetcode.longest_consecutive_sequence;

import java.util.*;

public class Solution {
	public int longestConsecutive(int[] nums){
		if (nums==null) return 0;
		int len = nums.length;
		if (len<=1) return len;
		Set<Integer> remain = new HashSet<>();
		for (int num : nums){
			//duplicat is removed
			remain.add(num);
		}
		int maxLen = Integer.MIN_VALUE;
		for (int n : nums){
			//1. n is already visited; continue
			//2. n not visited, then calucate left and right of n
			if (!remain.contains(n)) continue;
			int left = -1;
			int right = 1;
			int l = 1;
			while(remain.remove(n+left--))
				++l;
			while(remain.remove(n+right++))
				++l;
			maxLen = Math.max(maxLen, l);
			if (remain.isEmpty()) 
				break;
		}
		return maxLen;
		
	}
}
