package junxiao.leetcode.single_number;

import java.util.*;

public class Solution {
	public int singleNumber(int[] nums){
		int single = 0;
		for(int n : nums){
		   single ^= n;	
		}
		return single;
	}
}
