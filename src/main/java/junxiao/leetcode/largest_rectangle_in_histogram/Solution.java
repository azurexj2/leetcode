package junxiao.leetcode.largest_rectangle_in_histogram;

import java.util.*;

public class Solution {
	public int largestRectangleArea(int[] heights){
		int size = 0;
		if (heights==null || heights.length==0)
			return size;
		for (int i=0; i< heights.length;++i){
			if (i<heights.length-1 && heights[i+1]>=heights[i]){
				continue;
			}
			int minHigh = heights[i];
			for (int j = i; j>=0; ++j){
				minHigh = Math.min(minHigh, heights[j]);
				int tmpSize = minHigh * (i-j+1);
				size = Math.max(size, tmpSize);
			}
		}
		return size;
	}
	public int largestRectangleArea2(int[] heights){
		int size = 0;
		if (heights==null || heights.length==0)
			return size;
		Deque<Integer> stack = new ArrayDeque<>();
		int len = heights.length;
		int[] arr = new int[len+2];
		for (int i = 1; i <=len;++i){
			arr[i] = heights[i-1];
		}
		stack.addFirst(0);
		for (int i = 1; i <len+2;++i){
			while(arr[stack.peekFirst()]> arr[i]){
				//pop out all out of order 
				int ind = stack.removeFirst();
				int high = arr[ind];
				int l = i-1 - (stack.peekFirst()+1) + 1;
				size = Math.max(size, high*l);
			}
			stack.addFirst(i);
		}
		return size;
	}
}
