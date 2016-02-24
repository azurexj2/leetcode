package junxiao.leetcode.contains_duplicate_ii;

import java.util.*;

public class Solution {
	public boolean containsNearbyDuplicate(int[] nums, int k){
		if (nums==null)return false;
		int min = Integer.MAX_VALUE;
		int max = Integer.MIN_VALUE;
		for (int n: nums){
			min = n < min ? n : min;
			max = n > max ? n : max;
		}
		int[] arr = new int[max-min+1];
		Arrays.fill(arr, -1);
		for (int n=0; n < nums.length;++n){
			int ind = nums[n] - min;
			if (arr[ind]!=-1){
				if (n - arr[ind] <=k)
					return true;
				}
			arr[ind] = n;
		}
		return false;
	}
}
