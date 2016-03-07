package junxiao.leetcode.increasing_triplet_subsequence;

import java.util.*;

public class Solution {
    public boolean increasingTriplet(int[] nums) {
        //similar as the longest increasing sequece,
        //D[0], D[1] store the length 1 and 2 sequence
        // thress case, new val larger, less or between then
        if (nums==null || nums.length <=2) return false;
        int[] D = new int[3];
        int ind = 0;
        D[0] = nums[0];
        for(int i=1;i<nums.length;++i){
            if (nums[i]<=D[0])
                D[0]=nums[i];
            else if (nums[i] > D[ind]){
                D[++ind] = nums[i];
                if (ind==2)
                    return true;
            }
            else {
                D[1] = nums[i];
            }
            
        }
        return false;
    }
}
