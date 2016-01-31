package junxiao.leetcode.sort_colors;

import java.util.*;

public class Solution {
	public void sortColors(int[] nums){
		if (nums==null || nums.length<=1) return;
		int len = nums.length;
		int red = 0, white = 0, blue = 0;
		int ind = 0;
		while (ind <= blue){
			if (nums[ind]==0){
				//red
				swap(nums,ind,red);
				++ind;
				++red;
				++white;
			}
			else if (nums[ind]==1){
				++ind;
				++white;
			}
			else {
				swap(nums,ind,blue);
				--blue;
			}
		}
	}
	public void swap(int[] nums,int i, int j){
		int tmp = nums[i];
		nums[i] = nums[j];
		nums[j] = tmp;
	}
}
