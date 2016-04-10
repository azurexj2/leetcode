package junxiao.leetcode.missing_number;

import java.util.*;

public class Solution {
    public int missingNumber(int[] nums) {
        int n = nums.length;
        int res = 0;
        for (int i=0;i<n;++i){
            res ^= (nums[i] ^ i);
        }
        return res^n;
    }
}
public class Solution1 {
    public int missingNumber(int[] nums) {
        int n = nums.length;
        long sum = (n+1)*n/2;
        long s = 0;
        for (int m : nums){
            s += m;
        }
        return (int) (sum - s);
    }
}