package junxiao.leetcode.search_in_rotated_sorted_array_ii;

import java.util.*;

public class Solution {
    public boolean search(int[] nums, int target) {
        if (nums.length==0) return false;
        int minInd = findMin(nums);
        if (nums[minInd]==target) return true;
        int L =0, H = nums.length-1;
        if (target==nums[H]) return true;
        if (target<nums[H]){
            L = minInd;
        }
        else {
            H = ((minInd -1>=0) ? minInd-1 : nums.length-1);
        }
        while (L<=H){
            int M = L +(H-L)/2;
            if (nums[M]==target)
                return true;
            else if (nums[M]<target)
                L = M+1;
            else 
                H = M-1;
        }
        return false;
        
    }
    public int findMin(int[] nums) {
        int L = 0, H = nums.length-1;
        while(L<H){
            int M = L + (H-L)/2;
            if (nums[M]==nums[H])
                --H;
            else if (nums[M]<nums[H])
                H = M;
            else 
                L = M +1;
        }
        return L;
    }
}
public class Solution2 {
	public boolean search(int[] nums, int target) {
		if (nums==null || nums.length==0) return false;
		int L = 0, H = nums.length-1;
		while (L<=H){
			int M = L +(H-L)/2;
			if (nums[M]==target)
				return true;
			if (nums[M]>nums[H]){
				if (target>=nums[L] && target<nums[M]){
					H = M -1;
				}
				else {
					L = M +1;
				}
			}
			else if (nums[M]<nums[H]){
				if (target >nums[M] && target<=nums[H]){
					L = M +1;
				}
				else {
					H = M -1;
				}
			}
			else {
				//nums[M]==nums[H]
				--H;
			}
		}
		return false;
	}
}
