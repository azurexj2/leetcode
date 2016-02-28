package junxiao.leetcode.majority_element_ii;

import java.util.*;

import org.w3c.dom.css.ElementCSSInlineStyle;

public class Solution {
	public List<Integer> majorityElement(int[] nums){
		List<Integer> res = new ArrayList<>();
		if (nums==null || nums.length==0) return res;
		int c1 = 0, c2 = 0;
		int n1 = nums[0], n2 = nums[0];
		for (int i = 0; i < nums.length;++i){
			if (c1>0 && n1 == nums[i])
				++c1;
			else if (c2>0 && n2==nums[i])
				++c2;
			else if (c1==0){
				++c1;
				n1 = nums[i];
			}
			else if (c2==0){
				++c2;
				n2 = nums[i];
			}
			else {
				// c1>0 && c2>0, nums[i]!=n1 && nums[i]!=n2
				--c1;
				--c2;
			}
		}
		int count1 =0, count2 =0;
		for (int i =0; i<nums.length;++i){
			if (nums[i]==n1)
				++count1;
			else if (nums[i]==n2)
				++count2;
		}
		if (count1 > nums.length/3)
			res.add(n1);
		if (count2> nums.length/3)
			res.add(n2);
		return res;
	}
}
