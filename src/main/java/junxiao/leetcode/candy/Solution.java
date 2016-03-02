package junxiao.leetcode.candy;

import java.util.*;

public class Solution {
	public int candy(int[] ratings){
		if (ratings==null) return 0;
		int len = ratings.length;
		if (len<=1)return len;
		int count = 0;
		int[] arr = new int[len];
		arr[0] = 1;
		//from left to right
		// child with higher rating than left one has more candy
		// then from right to left
		// child with higher rating than right one has more candy
		for (int i = 1; i < len; ++i){
			if (ratings[i] > ratings[i-1]){
				arr[i] = arr[i-1]+1;
			}
			else
				arr[i] = 1;
		}
		for (int i = len-2; i>=0;--i){
			if (ratings[i]>ratings[i+1]){
				arr[i] = Math.max(arr[i], arr[i+1]+1);
			}
		}
		for (int n:arr){
			count+=n;
		}
		return count;
	}
}
