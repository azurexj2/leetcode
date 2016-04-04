package junxiao.leetcode.wiggle_sort_ii;

import java.util.*;

public class Solution {
    public void wiggleSort(int[] nums) {
        // we need partition the array that
        // AAXBB or AAXB, where ind = n/2, left <= nums[ind], 
        // right >= nums[ind]
        //kind like find out median number
        
        
        int len = nums.length;
        if (len<=1) return;
        int m = median(nums);
        int left = 0, right = len -1;
        int ptr = 0;
        while (ptr <= right){
            if (nums[ptr]<m){
                swap(nums,ptr,left);
                ++left;
                ++ptr;
            }
            else if (nums[ptr]>m){
                swap(nums,ptr,right);
                --right;
            }
            else 
                ++ptr;
        }
        int smallStart = ((len%2 ==1)? len/2 : (len/2-1) );
        int largeStart = len -1;
        int[] arr = new int[len];
        for (int i = 0; i < len; i+=2){
            arr[i] = nums[smallStart--];
        }
        for (int i = 1; i < len; i+=2){
            arr[i] = nums[largeStart--];
        }
        for (int i = 0; i < len; ++i){
            nums[i] = arr[i];
        }
    }
    private int median(int[] nums){
        int len = nums.length;
        int begin = 0, end = len -1;
        int ind = partition(nums,begin, end);
        while (ind!=len/2){
            if (ind < len/2){
                begin = ind + 1;
            }
            else {
                end = ind -1;
            }
            ind = partition(nums,begin,end);
        }
        return nums[len/2];
    }
    private int partition(int[] nums, int begin, int end){
        // return ind that [begin begin-1] <= ind,
        //                   ind <= [ind+1, end]
        if (begin >=end) return begin;
        int pivotalInd = begin + (end - begin)/2;
        int pivotalVal = nums[pivotalInd];
        swap(nums,pivotalInd,end);
        int left = 0, right = end-1;
        for (int i = 0; i <= end-1; ++i){
            if (nums[i] <=pivotalVal){
                swap(nums,left,i);
                ++left;
            }
        }
        swap(nums,left,end);
        return left;
    }
    private void swap(int[] nums, int i, int j){
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }
}