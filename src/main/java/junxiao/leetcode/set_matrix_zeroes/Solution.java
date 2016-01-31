package junxiao.leetcode.set_matrix_zeroes;

import java.util.*;

public class Solution {
	public void setZeroes(int[][] matrix){
		if (matrix==null) return;
		int m = matrix.length;
		int n = matrix[0].length;
		boolean[] row = new boolean[m];
		boolean[] col = new boolean[n];
		for (int i = 0; i < m; ++i){
			for (int j = 0; j < n; ++j){
				if (matrix[i][j]==0){
					row[i] = true;
					col[j] = true;
				}
			}
		}
		for (int i =0; i < m; ++i){
			if (row[i]==true){
				Arrays.fill(matrix[i], 0);
			}
		}
		for (int i=0; i <n; ++i){
			if (col[i]==true){
				for (int j = 0; j < m; ++j){
					matrix[j][i] = 0;
				}
			}
		}
	}
	public void setZeroes2(int[][] matrix){
		if (matrix==null) return;
		int m = matrix.length;
		int n = matrix[0].length;
		//if a row has zero, we don't need it
		//we can use the first zero row to store the col information
		//set row to zero on the flight
		int ind = -1;
		boolean flag = false;
		for (int i =0; i<m;++i){
			flag = false;
			for (int j =0; j <n;++j){
				if (matrix[i][j]==0){
					if (ind<0){
						ind = i;
						// matrix[i][j]=0;
					}
					else {
						//ind already set
						matrix[ind][j]=0;
						flag = true;
					}
				}
			}
			if (flag)
				Arrays.fill(matrix[i], 0);
		}
		if (ind<0) return;
		for (int j=0;j<n;++j){
			if (matrix[ind][j]==0){
				//set all col j to 0
				for (int i=0;i<m;++i){
					matrix[i][j]=0;
				}
			}
		}
		Arrays.fill(matrix[ind], 0);
	}
}
