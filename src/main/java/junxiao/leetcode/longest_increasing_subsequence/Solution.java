package junxiao.leetcode.longest_increasing_subsequence;

import java.util.*;

public class Solution {
    public int lengthOfLIS(int[] nums) {
        if (nums==null) return 0;
        int len = nums.length;
        if (len<=1) return len;
        int[] D = new int[len];
        Arrays.fill(D,1);
        //D[i] is the largest one that sequence end at i
        // max: D[j] + 1 if nums[i] > nums[j]
        for (int i =1; i<len;++i){
            for (int j = 0;j<i;++j){
                if (nums[i] > nums[j]){
                    D[i] = Math.max(D[i],D[j]+1);
                }
            }
        }
        int maxLen =0;
        for (int i =0; i < len;++i){
            maxLen = Math.max(maxLen, D[i]);
        }
        return maxLen;
    }
    public int lengthOfLIS2(int[] nums) {
        if (nums==null) return 0;
        int len = nums.length;
        if (len<=1) return len;
        int[] D = new int[len];
        D[0] = nums[0];
        int ind = 0;
        //D[i] store the length i+1 sequence's last value
        // ind point to the last sequence
        //three possible when we have a new value
        //1. val is larger than all of previous stored sequence
        //   clone the last sequence and app val: D[ind+1] = val;
        //2. val is the smallest among all previous sequence's last value
        //   replace D[0] : D[0] = val
        //3. val is among those previous sequence's last value
        //   find out the lower bound of the sequence, ie the smallest value that larger or equle to val
        //   replace D[lower bound pos] = val;
        // for example: 2, 10, 5, 20: all possible longest sequence:
        //   2 ...
        //   2 5 ...
        //   2 5 20 ...
        // now new val, image 1, 30 , 15
        for (int i = 1; i<len; ++i){
            // case 1 and 2:
            if (nums[i] > D[ind])
                D[++ind] = nums[i];
            else if (nums[i] < D[0])
                D[0] = nums[i];
            else {//case 3
                int pos = lowerBound(D,0,ind,nums[i]);
                D[pos] = nums[i];
            }
        }
        return ind+1;
    }
    private int lowerBound(int[] D, int start, int end, int key){
        int L = start, H = end;
        while (L <= H){
            int M = L + (H-L)/2;
            if (D[M] ==key)
                return M;
            else if (D[M]>key)
                H = M -1;
            else
                L = M+1;
        }
        return L;
    }
}
