package junxiao.leetcode.rotate_image;

import java.util.*;

public class Solution {
	public void rotate(int[][] matrix) {
		//  swap accoring to \
		// then flip coopring to |
		if (matrix==null) return;
		int n = matrix.length;
		for (int i =0; i<n;++i){
			for (int j =i+1;j<n;++j){
				swap(matrix,i,j,j,i);
			}
		}
		for (int i =0; i < n; ++i){
			for (int j=0;j<n/2;++j){
				swap(matrix,i,j,i,n-1-j);
			}
		}
	}
	public void swap(int[][]  matrix, int i, int j, int m, int n){
		int tmp = matrix[i][j];
		matrix[i][j] = matrix[m][n];
		matrix[m][n] = tmp;
	}
}
