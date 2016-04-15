package junxiao.leetcode.patching_array;

import java.util.*;

public class Solution {
    public int minPatches(int[] nums, int n) {
        /*
        assume we meet a number missing that can not be get from current partial portion of nums[0,i],
        i.e. [1,missing) is possible
        case 1: nums[i+1] <= missing, then we can reach [1,missing+nums[i+1])
        case 2: nums[i+1] > missing, then current nums can not sum to missing, we need add missing to max the reaching
                to [1,missing+missing)
        */
        int count = 0;
        long missing = 1; 
        int ind = 0;
        while(missing<=n){
            if (ind<nums.length && nums[ind]<=missing){
                missing += nums[ind];
                ++ind;
            }
            else {
                missing += missing;
                ++count;
            }
        }
        
        return count;
    }
}