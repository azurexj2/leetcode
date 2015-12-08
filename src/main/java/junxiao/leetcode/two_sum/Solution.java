package junxiao.leetcode.two_sum;
import java.util.*;

public class Solution {
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> map = new HashMap<>();
            int l = nums.length;
            for (int i = 0; i < l; ++i){
                int tmp = target - nums[i];
                if (map.containsKey(tmp)){
                    int left = map.get(tmp);
                    return new int[]{left, i+1};
                }
                else {
                    map.put(nums[i], i+1);
                }
            }
            return new int[2];
    }
}

