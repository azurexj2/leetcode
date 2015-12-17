package junxiao.leetcode.two-sum;

import java.util.*;

public class Solution {
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < nums.length; i++){
            int tmp = target - nums[i];
            if (map.containsKey(tmp)){
                return new int[]{map.get(tmp),i+1};
            }
            else {
                map.put(nums[i], i+1);
            }
        }

        return new int[2];

    }
}
