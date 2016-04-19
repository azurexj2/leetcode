package junxiao.leetcode.count_of_range_sum;

import java.util.*;

public class Solution {
    public int countRangeSum(int[] nums, int lower, int upper) {
        // divide and conquer, when compute cross middle range sum
        // sort the right sum array, then for left e, search those between lower-e and upper-e
        // the number is we need add as the range begin at e
        return helper(nums,0,nums.length-1, lower, upper);
    }
    private int helper(int[] nums, int start, int end, int lower, int upper){
        //base case
        if (start > end) return 0;
        if (start==end){
            if (nums[start]>=lower && nums[start]<=upper)
                return 1;
            else
                return 0;
        }
        int M = start + (end-start)/2;
        int left = helper(nums,start,M,lower,upper);
        int right = helper(nums,M+1,end,lower,upper);
        //now check cross M range sum
        // first get sum arr
        int lenRight = end - (M+1) + 1;
        long[] sums = new long[lenRight];
        long rightSum = 0;
        for (int i=M+1;i<=end;++i){
            rightSum += nums[i];
            sums[i-M-1] = rightSum;
        }
        //now we have sums, sort it
        Arrays.sort(sums);
        int count = left+right;
        //lets look for every entry in the left, binary search the range in the right
        long leftSum = 0;
        for (int i =M;i>=start;--i){
            leftSum += nums[i];
            count += search(sums, lower-leftSum, upper-leftSum);
        }
        return count;
    }
    private int search(long[] sums, long lower, long upper){
        return insertion(sums,upper+0.5) - insertion(sums,lower-0.5);
    }
    private int insertion(long[] sums, double val){
        int L =0, H = sums.length-1;
        while (L<=H){
            int M = L + (H-L)/2;
            if (sums[M] < val)
                L = M +1;
            else 
                H = M -1;
        }
        return L;
    }
}