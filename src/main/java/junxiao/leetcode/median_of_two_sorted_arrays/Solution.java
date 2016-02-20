package junxiao.leetcode.median_of_two_sorted_arrays;

import java.util.*;

import org.mockito.exceptions.verification.NoInteractionsWanted;

public class Solution {
	public double findMedianSortedArrays(int[] nums1, int[] nums2){
		int len1 = nums1.length;
		int len2 = nums2.length;
		int len = len1+len2;
		// kth minimal, k=[1 len]
		if (len%2==1){
			return (double) kth(nums1, 0, len1-1, nums2, 0, len2-1, len/2+1);
		}
		else {
			int l = kth(nums1, 0, len1-1, nums2, 0, len2-1, len/2);
			int r = kth(nums1, 0, len1-1, nums2, 0, len2-1, len/2 + 1);
			return  (l+r)/2.0;
		}
	}
	private int kth(int[] n1, int s1, int e1, int[] n2, int s2, int e2, int target){
		int len1 = e1 - s1 + 1;
		int len2 = e2 - s2 + 1;
		if (len2 < len1){
			return kth(n2, s2, e2, n1, s1, e1, target);
		}
	    //now len2 >= len1;
		if (len1<=0) return n2[target-1];
		if (target==1) return Math.min(n1[s1], n2[s2]);

		int l1 = Math.min(target/2, len1);
		int l2 = target - l1;
		int ind1 = l1 + s1;
		int ind2 = l2 + s2;
		
		if (n1[ind1 - 1] == n2[ind2-1]){
			return n1[ind1-1];
		}
		else if (n1[ind1-1] < n2[ind2-1]){
			return kth(n1, ind1, e1, n2, s2, e2, target-l1);
		}
		else {
			return kth(n1, s1, e1, n2, ind2, e2, target-l2);
		}

	}
}
