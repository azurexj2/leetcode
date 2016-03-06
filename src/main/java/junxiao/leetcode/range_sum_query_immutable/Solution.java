package junxiao.leetcode.range_sum_query_immutable;

import java.util.*;

public class Solution {
    private int[] sum;
    public NumArray(int[] nums) {
        sum = new int[nums.length];
        int sumSofar = 0;
        for (int i =0; i<nums.length;++i){
            sumSofar += nums[i];
            sum[i] = sumSofar;
        }
    }

    public int sumRange(int i, int j) {
        if (i==0) return sum[j];
        return sum[j] - sum[i-1];
    }
}
