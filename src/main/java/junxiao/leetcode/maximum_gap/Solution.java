package junxiao.leetcode.maximum_gap;

import java.util.*;

public class Solution {
	public int maximumGap(int[] nums){
		if (nums==null) return 0;
		int len = nums.length;
		if (len<=1) return 0;
		int minN = nums[0];
		int maxN = minN;
		int[] bucketMin = new int[len];
		int[] bucketMax = new int[len];
		boolean[] bucketVisited = new boolean[len];
		for (int n : nums){
			minN = Math.min(minN, n);
			maxN = Math.max(maxN, n);
		}
		double gap = (double)(maxN-minN+1)/len;
		// we need put n numbers to n bucket
		// if all goes to one bucket, then mean all numbers are the same
		// otherwise at least two numbers will go to one bucket, we have at least
		// one empty bucket. Then the maxim gap is there.
		for (int n: nums){
			int ind = (int) ((n-minN)/gap);
			if (bucketVisited[ind]){
				bucketMax[ind] = Math.max(bucketMax[ind], n);
				bucketMin[ind] = Math.min(bucketMin[ind], n);
			}
			else{
				bucketVisited[ind] = true;
				bucketMax[ind] = n;
				bucketMin[ind] = n;
			}

		}
		int maxGap = 0;
		int left = bucketMax[0];
		for (int i =1; i < len;++i){
			if (bucketVisited[i]){
			    int tmpGap = bucketMin[i] - left;	
			    maxGap = Math.max(maxGap, tmpGap);
			    left = bucketMax[i];
			}
		}
		return maxGap;
		
	}
}
