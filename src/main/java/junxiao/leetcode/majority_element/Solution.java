package junxiao.leetcode.majority_element;

import java.util.*;

public class Solution {
	public int majorityElement(int[] nums){
		int slow = 0, fast = 1;
		while(fast<nums.length){
			if (slow<0){
				nums[0] = nums[fast];
				slow = 0;
			}
			else if (nums[fast]!=nums[slow]){
			   --slow;
			}
			else {
				// fast == slow
				++slow;
				nums[slow] = nums[fast];
			}
			++fast;
		}
		return nums[slow];
	}
}
