package junxiao.leetcode.spiral_matrix_ii;

import java.util.*;

public class Solution {
    public int[][] generateMatrix(int n) {
    	int[][] res = new int[n][n];
    	int ind = 1;
    	int row_b = 0, row_e = n-1;
    	int col_b = 0, col_e = n-1;
    	while(ind <= n*n){
    	    for(int i=col_b;i<=col_e;++i){
    	    	res[row_b][i]=ind++;
    	    }
    	    ++row_b;
    	    for(int i=row_b;i<=row_e;++i){
    	    	res[i][col_e]=ind++;
    	    }
    	    --col_e;
    	    for(int i=col_e;i>=col_b;--i){
    	    	res[row_e][i]=ind++;
    	    }
    	    --row_e;
    	    for(int i=row_e;i>=row_b;--i){
    	    	res[i][col_b]=ind++;
    	    }
    	    ++col_b;
    	}
    	
    	return res;
    }
}
