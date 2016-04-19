package junxiao.leetcode.count_of_smaller_numbers_after_self;

import java.util.*;


public class Solution {
    private class numInd {
        int ind;
        int val;
        int count;
        numInd(int ind, int val){
            this.ind = ind;
            this.val = val;
            count = 0;
        }
        
    }
    public List<Integer> countSmaller(int[] nums) {
        // mergeSort (or any stable sort)
        /*
            For each number, count how many number moved before it
            conider two array, left and right, do merge sort
            when we move one element from left to merged array,
            count how many we already moved from right to merged array,
            whe we move one element from right, no smaller have move before it
        */
        int len = nums.length;
        List<Integer> res = new ArrayList<>();
        if (len==0) return res;
        numInd[] arr = new numInd[len];
        for (int i=0; i < len;++i){
            arr[i] = new numInd(i,nums[i]);
        }
        numInd[] sorted = mergeSort(arr,0,len-1);
        for (int i =0; i <len;++i){
            res.add(4);
        }
        for (int i =0; i <len;++i){
            res.set(sorted[i].ind,sorted[i].count);
        }
        return res;
    }
    private numInd[] mergeSort(numInd[] arr, int start, int end){
        if (start>=end) return new numInd[]{arr[start]};
        int len = end-start+1;
        int M = start + (end-start)/2;
        numInd[] left = mergeSort(arr,start,M);
        numInd[] right = mergeSort(arr,M+1,end);
        numInd[] sorted = new numInd[len];
        for (int l = 0, r=0; (l<left.length || r<right.length);){
            if (r==right.length || (l<left.length && left[l].val <= right[r].val)){
                left[l].count += r;
                sorted[r+l] = left[l];
                ++l;
            }
            else{
                sorted[r+l] = right[r];
                r++;
            }
        }
        return sorted;
    }

}
public class Solution2 {
    public List<Integer> countSmaller(int[] nums) {
        // from back be begining, sort, binary search the index
        // if we can use BST to store the sorted array,
        // n* logn
        int len = nums.length;
        List<Integer> res = new ArrayList<>();
        List<Integer> sorted = new ArrayList<>();
        if (len==0) return res;
        for (int i = len-1;i>=0;--i){
            // here ind is the insertion place
            int ind = search(sorted, nums[i]);
            res.add(ind);
            sorted.add(ind,nums[i]);
        }
        Collections.reverse(res);
        return res;
        
    }
    private int search(List<Integer> arr, int target){
        int L = 0, H = arr.size()-1;
        while (L<=H){
            int M = L + (H-L)/2;
            if (target <= arr.get(M)){
                H = M -1;
            }
            else 
                L = M +1;
        }
        return L;
    }
}