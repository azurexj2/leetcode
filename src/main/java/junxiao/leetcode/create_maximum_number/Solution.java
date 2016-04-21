package junxiao.leetcode.create_maximum_number;

import java.util.*;

public class Solution {
    public int[] maxNumber(int[] nums1, int[] nums2, int k) {
        int len1 = nums1.length;
        int len2 = nums2.length;
        int[] res = new int[k];
        for(int i = 0; i<=k; ++i){
            // find len i and k-i from nums1 and nums2 respectively
            if (i<=len1 && k-i <=len2){
                int[] candidate = merge(maxK(nums1,i),maxK(nums2,k-i));
                if (compareTo(res,0,candidate,0)<0){
                    res = candidate;
                }
            }
        }
        return res;
    }
    private int[] merge(int[] nums1, int[] nums2){
        int p1=0, p2=0, ind=0;
        int[] res = new int[nums1.length+nums2.length];
        while(p1<nums1.length || p2<nums2.length){
            if (p2==nums2.length || (p1<nums1.length && compareTo(nums1, p1, nums2, p2)>=0)){
                res[ind++] = nums1[p1++];
            }
            else {
                res[ind++] = nums2[p2++];
            }
        }
        return res;
    }
    private int compareTo(int[] nums1, int p1, int[] nums2, int p2){
        //compare nums1[p1] nums2[p2]
        // 66
        // 669
        // if they are equal
        // we need look for next bigger one
        // if still equle, we return the longer one
        while(p1<nums1.length && p2<nums2.length && nums1[p1]==nums2[p2]){
            ++p1;
            ++p2;
        }
        if (p1<nums1.length&&p2<nums2.length){
            return nums1[p1]-nums2[p2];
        }
        // p1 reach end, p2 is larger
        return p1==nums1.length? -1 : 1;
    }
    private int[] maxK(int[] nums, int k){
        /*
            use stack to store the max k
            while: !stack.isEmpty && the remaing element can fill the k
                    && stack.peek < num[i]
                    stack.poll
                    7663 k=3
                    7->6, 6 coming, shouldn't remove
                    7669 k =3
            if (stack.size <k) stack.add(num[i])
        */
        int len = nums.length;
        if (k==0 || k>len) return new int[0];
        if (k==len) return nums;
        int[] stack = new int[k];
        int ind = 0; // which means there are ind element in the stack
        // ind should <=k
        for (int i =0; i < len;++i){
            while(ind>0 && ((ind-1) + (len-i))>=k 
                    && stack[ind-1]<nums[i]){
                        //stack poll
                        --ind;
                    }
            if (ind<k){
                stack[ind++] = nums[i];
            }
        }
        return stack;
    }
}