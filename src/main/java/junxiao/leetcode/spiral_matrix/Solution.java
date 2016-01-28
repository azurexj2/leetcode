package junxiao.leetcode.spiral_matrix;

import java.util.*;

public class Solution {
	public List<Integer> spiralOrder(int[][] matrix){
		List<Integer> res = new ArrayList<>();
		if (matrix==null) return res;
		int m = matrix.length;
		int n = matrix[0].length;
		int row_b = 0, row_e = m-1;
		int col_b = 0, col_e = n-1;
		while(true){
			for (int i=col_b;i<=col_e;++i){
				res.add(matrix[row_b][i]);
			}
			++row_b;
			if (row_b>row_e) break;
			for (int i=row_b;i<=row_e;++i){
				res.add(matrix[i][col_e]);
			}
			--col_e;
			if (col_b>col_e) break;
			for(int i=col_e;i>=col_b;--i){
				res.add(matrix[row_e][i]);
			}
			--row_e;
			if (row_b>row_e) break;
			for(int i=row_e;i>=row_b;--i){
				res.add(matrix[i][col_b]);
			}
			++col_b;
			if (col_b>col_e) break;
		}
		return res;
	}
}
