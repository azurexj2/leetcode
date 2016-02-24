package junxiao.leetcode.contains_duplicate;

import java.util.*;

public class Solution {
	public boolean containsDuplicate(int[] nums){
		if (nums==null)return false;
		Set<Integer> set = new HashSet<>();
		for (int n : nums){
			if (!set.add(n)){
				return false;
			}
		}
		return true;
	}
	public boolean containsDuplicate2(int[] nums){
		if (nums==null)return false;
		int min = Integer.MAX_VALUE;
		int max = Integer.MIN_VALUE;
		for (int n: nums){
			min = n < min ? n : min;
			max = n > max ? n : max;
		}
		int[] arr = new int[max-min+1];
		for (int n : nums){
			if (arr[n-min]!=0)
				return true;
			arr[n-min] = 1;
		}
		return true;

	}
}
