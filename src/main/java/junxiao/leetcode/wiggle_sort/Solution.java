package junxiao.leetcode.wiggle_sort;

import java.util.*;

public class Solution {
    public void wiggleSort(int[] nums) {
        // for even ind we need less,
        // for odd ind we need larger
        for (int i = 0; i < nums.length-1; ++i){
            if (( i%2==0 && nums[i] > nums[i+1]) || (i%2==1 && nums[i]<nums[i+1])){
                int tmp = nums[i];
                nums[i] = nums[i+1];
                nums[i+1] = tmp;
            }

        }
    }

}