package junxiao.leetcode.search_a_2d_matrix;

import java.util.*;

public class Solution {
	public boolean searchMatrix(int[][] matrix, int target){
		// search ind 0 to m*n-1
		// index x: row=x/n, col=x%n
		if (matrix==null) return false;
		int m = matrix.length;
		int n = matrix[0].length;
		int L = 0, H = m*n-1;
		while(L<=H){
			int M = L + (H-L)/2;
			int val = matrix[M/n][M%n];
			if (val == target){
				return true;
			}
			else if (val < target){
				L = M + 1;
			}
			else {
				H = M -1;
			}
		}
		return false;
	}
}
