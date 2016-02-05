package junxiao.leetcode.convert_sorted_array_to_binary_search_tree;

import java.util.*;
import junxiao.leetcode.TreeNode;

public class Solution {
	public TreeNode sortedArrayToBST(int[] nums){
		return helper(nums,0,nums.length-1);
		
	}
	private TreeNode helper(int[] nums, int begin, int end){
		if (begin>end || begin<0) return null;
		int M = begin + (end-begin)/2;
		TreeNode head = new TreeNode(nums[M]);
		if (begin==end)
			return head;
		head.left=helper(nums,begin,M-1);
		head.right=helper(nums,M+1,end);
		return head;
	}
}
