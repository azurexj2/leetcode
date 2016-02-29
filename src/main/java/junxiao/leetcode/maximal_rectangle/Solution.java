package junxiao.leetcode.maximal_rectangle;

import java.util.*;

public class Solution {
	public int maximalRectangle(char[][] matrix) {
		int m = matrix.length;
		if (m==0) return 0;
		int n = matrix[0].length;
		if (n==0) return 0;
		int size = 0;
		int[] heights = new int[n];
		for (int i = 0; i <m; ++i){
			for (int j = 0; j <n; ++j){
				if (matrix[i][j]=='0')
					heights[j] = 0;
				else 
					++heights[j];
			}
			int tmpSize = largestRectangleArea2(heights);
			size = Math.max(size, tmpSize);
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
