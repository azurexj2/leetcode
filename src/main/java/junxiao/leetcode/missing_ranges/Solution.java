package junxiao.leetcode.missing_ranges;

import java.util.*;

public class Solution {
    public List<String> findMissingRanges(int[] nums, int lower, int upper) {
        List<String> res = new ArrayList<>();
        //first check lower
        int len = nums.length;
        int pre = lower-1;//fix here, faied with ingeger.min_value
        for (int i = 0; i < len; ++i){
            if (nums[i]-pre == 1)
                ;
            else if (nums[i]-pre == 2){
                res.add(""+(nums[i]-1));
            }
            else {
                res.add(pre+1 + "->" + (nums[i]-1));
            }
            pre = nums[i];
        }
        if (upper!=pre){
            if (upper-pre == 1)
                res.add(""+upper);
            else
                res.add(pre+1 + "->" + upper);
        }

        return res;
    }
}