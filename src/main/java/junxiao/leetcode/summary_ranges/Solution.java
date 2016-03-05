package junxiao.leetcode.summary_ranges;

import java.util.*;

public class Solution {
    public List<String> summaryRanges(int[] nums) {
        List<String> res = new ArrayList<>();
        if (nums==null || nums.length==0) return res;
        int begin = 0;
        int i = 1;
        while (begin < nums.length){
            if (i==nums.length || nums[i]!=nums[i-1]+1){
                String range = String.valueOf(nums[begin]);
                if ((i-1) != begin){
                    //non-single
                    range+= "->";
                    range += String.valueOf(nums[i-1]);
                }
                res.add(range);
                begin = i;
            }
            ++i;
        }
        return res;
    }
}
